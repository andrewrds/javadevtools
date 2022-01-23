<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
    <head>
		<title>Java SimpleDateFormat Tester</title>
		<meta content="Test your Java SimpleDateFormat format patterns with this online tool. Enter a date format pattern to see immediately how the current date will be formatted." name="description" />
		<jsp:directive.include file="commonHeaders.jsp" />
	</head>
	<body>
		<div id="header">
			<h1>Java SimpleDateFormat Tester</h1>
		</div>
		
		<jsp:include page="menu.jsp">
			<jsp:param name="page" value="simpledateformat" />
		</jsp:include>

		<div id="content">
			<p>
				The
				<a href="https://docs.oracle.com/javase/8/docs/api/index.html?java/text/SimpleDateFormat.html">SimpleDateFormat</a>
				class is used to format instances of the
				<a href="https://docs.oracle.com/javase/8/docs/api/index.html?java/util/Date.html">Date</a>
				class as strings using a pattern.
			</p>
		    <p>
			    The SimpleDateFormat class is now a legacy class; the
			    <a href="https://docs.oracle.com/javase/8/docs/api/index.html?java/time/format/DateTimeFormatter.html">DateTimeFormatter</a>
			    is a more up to date alternative as part of the new
			    <a href="https://docs.oracle.com/javase/8/docs/api/index.html?java/time/package-summary.html">java.time</a>
			    API.
		    </p>
		    <p>Enter a Java SimpleDateFormat pattern to see immediately how the current date will be formatted.</p>

			<jsp:include page="formatForm.jsp">
				<jsp:param name="url" value="simpledateformat/format" />
			</jsp:include>

			<jsp:directive.include file="simpledateformat-common-issues.jsp" />
        </div>
        
        <jsp:directive.include file="simpledateformat-sidebar.jsp" />
        <jsp:directive.include file="dataLists.jsp"/>
	</body>
</html>
