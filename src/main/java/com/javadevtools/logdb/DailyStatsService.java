package com.javadevtools.logdb;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

@Component
public class DailyStatsService {
	private final List<String> colors = Arrays.asList(
			"rgb(255, 0, 0)",
			"rgb(0, 255, 0)",
			"rgb(0, 0, 255)",
			"rgb(255, 165, 0)");

	@PersistenceContext
	private Session session;

	public Map<String, Object> getData() {
		return Collections.singletonMap("datasets", getDataSets());
	}

	private List<Map<String, Object>> getDataSets() {
		List<Map<String, Object>> dataSets = new ArrayList<>();

		for (RequestType requestType : RequestType.values()) {
			dataSets.add(getDataSet(requestType));
		}

		return dataSets;
	}

	private Map<String, Object> getDataSet(RequestType requestType) {
		Map<String, Object> dataSet = new HashMap<>();
		dataSet.put("label", requestType.toString());
		dataSet.put("data", getDataQuery(requestType));

		String color = colors.get(requestType.ordinal() % colors.size());
		dataSet.put("borderColor", color);
		dataSet.put("backgroundColor", color);

		return dataSet;
	}

	private List<Map<String, Object>> getDataQuery(RequestType requestType) {
		LocalDate end = LocalDate.now();
		LocalDate start = end.minusDays(30);

		CriteriaBuilder b = session.getCriteriaBuilder();

		CriteriaQuery<DailyRequestVolume> query = b.createQuery(DailyRequestVolume.class);
		Root<DailyRequestVolume> root = query.from(DailyRequestVolume.class);

		query.select(root);
		query.where(b.and(
				b.equal(root.get("requestType"), requestType),
				b.between(root.get("requestDate"), start, end)));
		query.orderBy(b.asc(root.get("requestDate")));
		
		List<DailyRequestVolume> results = session.createQuery(query).getResultList();

		int resultIndex = 0;
		List<Map<String, Object>> data = new ArrayList<>();
		for (LocalDate d : start.datesUntil(end).collect(Collectors.toList())) {
			Map<String, Object> point = new HashMap<>();
			point.put("x", d.toString());

			long count = 0;
			if (resultIndex < results.size()) {
				DailyRequestVolume stats = results.get(resultIndex);
				if (stats.getRequestDate().equals(d)) {
					count = stats.getRequestCount();
					resultIndex++;
				}
			}
			
			point.put("y", count);
			data.add(point);
		}

		return data;
	}
}
