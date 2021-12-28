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

            <form id="dateformat">
                <div>
                    <p>
                        Format Pattern
                        <input id="inputFormat"
                               placeholder="yyyy-MM-dd'T'HH:mm:ss"
                               autocomplete="off"
                               maxlength="300"
                               oninput="sendFormatRequest('datetimeformatter/format')"/>
                    </p>

                    <p>
                        Locale
                        <input id="inputLocale"
                               autocomplete="off"
                               oninput="sendFormatRequest('datetimeformatter/format')"
                               list="localesList"
                               value="en-US" />
                    </p>
                    
                    <p>
                    	Time Zone
                    	<input id="inputTimeZone"
                    	       autocomplete="off"
                    	       oninput="sendFormatRequest('datetimeformatter/format')"
                    	       list="timeZonesList"
                    	       value="America/New_York"/>
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
        
        <jsp:directive.include file="dataLists.jsp"/>
	</body>
</html>
