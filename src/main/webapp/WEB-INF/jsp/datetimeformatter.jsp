<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
    <head>
		<title>Java DateTimeFormatter Tester</title>
		<link href="page.css" rel="stylesheet">
		<meta content="Test your Java DateTimeFormatter format patterns with this online tool. Enter a date format pattern to see immediately how the current date will be formatted." name="description" />
		<script src="/webjars/jquery/3.6.0/jquery.min.js" async="true"></script>
		<script src="/datetimeformatter.js" async="true"></script>
	</head>
	<body>
		<div id="header">
			<h1>Java DateTimeFormatter Tester</h1>
		</div>
		<div id="menu">
			<p>
				<a href="simpledateformat">SimpleDateFormat Tester</a>
			</p>
			<p>
				<a href="datetimeformatter">DateTimeFormatter Tester</a>
			</p>
		</div>
		<div id="content">
	        <p>
				The
				<a href="https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html">DateTimeFormatter</a>
				class is used to format date-time instances from the new
				<a href="https://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html">java.time</a>
				package. This class is a replacement for the older
				<a href="https://docs.oracle.com/javase/8/docs/api/index.html?java/text/SimpleDateFormat.html">SimpleDateFormat</a>
				class.
			</p>

		    <p>Unlike SimpleDateFormat instances, DateTimeFormatter instances
			are thread safe and immutable so the same instance can be used from
			multiple threads.</p>

            <form id="dateformat">
                <div>
                    <p>
                        Format Pattern
                        <input id="inputFormat" placeholder="yyyy-MM-dd'T'HH:mm:ss" oninput="sendFormatRequest(event)"/>
                    </p>

                    <p>
                        Locale
                        <select id="inputLocale" oninput="sendFormatRequest(event)">
                            <c:forEach var="l" items="${locales}">
                                <option value="${fn:escapeXml(l.toLanguageTag())}" ${l.toLanguageTag().equals("en-US") ? 'selected' : ''}>
                                    <c:out value="${l.displayName}"/>
                                </option>
                            </c:forEach>
                        </select>
                    </p>
                    
                    <p>
                    	Time Zone
                    	<select id="inputTimeZone" oninput="sendFormatRequest(event)">
                            <c:forEach var="z" items="${timeZones}">
                                <option value="${fn:escapeXml(z.ID)}" ${z.ID.equals("America/New_York") ? 'selected' : ''}>
                                    <c:out value="${z.ID}"/>
                                </option>
                            </c:forEach>
                        </select>
                    </p>
                </div>
            </form>

            <div>
                <p id="result">Empty input</p>
            </div>

		    <p>
		        Java Version: <c:out value="${javaVersion}" />
		    </p>
        </div>
	</body>
</html>