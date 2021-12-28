<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
    <head>
		<title>Java DateTimeFormatter Tester</title>
		<meta content="Test your Java DateTimeFormatter format patterns with this online tool. Enter a date format pattern to see immediately how the current date will be formatted." name="description" />
        <jsp:directive.include file="commonHeaders.jsp" />
	</head>
	<body>
		<div id="header">
			<h1>Java DateTimeFormatter Tester</h1>
		</div>
		<div id="menu">
			<p>
				<a href="simpledateformat">SimpleDateFormat Tester</a>
			</p>
			<p>DateTimeFormatter Tester</p>
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

			<jsp:include page="formatForm.jsp">
				<jsp:param name="url" value="datetimeformatter/format" />
			</jsp:include>
        </div>
        
        <jsp:directive.include file="dataLists.jsp"/>
	</body>
</html>
