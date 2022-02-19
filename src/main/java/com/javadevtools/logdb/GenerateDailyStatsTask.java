package com.javadevtools.logdb;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.threeten.extra.LocalDateRange;

import com.javadevtools.dateformat.FormatterType;

@Component
public class GenerateDailyStatsTask {
	private static final LocalDate DEFAULT_LATEST_DATE = LocalDate.of(2022, Month.JANUARY, 1);

	private static final Logger log = LoggerFactory.getLogger(GenerateDailyStatsTask.class);

	@PersistenceContext
	private Session session;

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	@Scheduled(cron = "0 0 6 * * *")
	public void reportCurrentTime() {
		log.info("Running {}", GenerateDailyStatsTask.class);

		LocalDate today = LocalDate.now();
		for (RequestType requestType : RequestType.values()) {
			LocalDate latestDate = getLatest(requestType);
			LocalDateRange dateRange = LocalDateRange.of(latestDate.plusDays(1), today);

			log.info("Generating stats for {} in range {}", requestType, dateRange);

			switch (requestType) {
				case SimpleDateFormat:
					updateFormatStats(requestType, FormatLogEntry.class, dateRange, FormatterType.SimpleDateFormat);
					break;
				case DateTimeFormatter:
					updateFormatStats(requestType, FormatLogEntry.class, dateRange, FormatterType.DateTimeFormatter);
					break;
				case SimpleDateFormatParse:
					updateFormatStats(requestType, ParseLogEntry.class, dateRange, FormatterType.SimpleDateFormat);
					break;					
				case DateTimeFormatterParse:
					updateFormatStats(requestType, ParseLogEntry.class, dateRange, FormatterType.DateTimeFormatter);
					break;
			}
		}
	}

	private LocalDate getLatest(RequestType type) {
		CriteriaBuilder b = session.getCriteriaBuilder();

		CriteriaQuery<LocalDate> query = b.createQuery(LocalDate.class);
		Root<DailyRequestVolume> l = query.from(DailyRequestVolume.class);

		query.select(b.greatest(l.<LocalDate>get("requestDate")))
				.where(b.equal(l.get("requestType"), type));

		return Optional.ofNullable(session.createQuery(query).getSingleResult())
				.orElse(DEFAULT_LATEST_DATE);
	}

	private void updateFormatStats(RequestType requestType, Class<?> entity, LocalDateRange dateRange, FormatterType formatterType) {
		CriteriaBuilder b = session.getCriteriaBuilder();

		CriteriaQuery<Tuple> query = b.createQuery(Tuple.class);
		Root<?> e = query.from(entity);

		query.multiselect(b.count(e), e.get("created").as(LocalDate.class));

		query.where(b.and(
				b.equal(e.get("formatterType"), formatterType),
				b.between(e.get("created").as(LocalDate.class), dateRange.getStart(), dateRange.getEndInclusive())));

		query.groupBy(e.get("created").as(LocalDate.class));

		List<Tuple> results = session.createQuery(query).getResultList();
		long count = 0;
		for (Tuple t : results) {
			entityManager.persist(DailyRequestVolume.create(
					t.get(1, LocalDate.class),
					requestType,
					t.get(0, Long.class)));
			
			count++;
		}
		
		log.info("Inserted {} rows", count);
	}
}
