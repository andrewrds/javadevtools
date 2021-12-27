<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
    <head>
		<title>Java SimpleDateFormat Tester</title>
		<link href="page.css" rel="stylesheet">
		<meta content="Test your Java SimpleDateFormat format patterns with this online tool. Enter a date format pattern to see immediately how the current date will be formatted." name="description" />
		<script src="/webjars/jquery/3.6.0/jquery.min.js" async="true"></script>
		<script src="/simpledateformat.js" async="true"></script>
	</head>
	<body>
		<div id="header">
			<h1>Java SimpleDateFormat Tester</h1>
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
            <form id="dateformat">
                <div>
                    <p>
                        Format Pattern
                        <input id="inputFormat" placeholder="yyyy-MM-dd'T'HH:mm:ss" autocomplete="off" oninput="sendFormatRequest(event)"/>
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

            <h2>Common Issues</h2>
            <ul>
                <li>It is important to remember that the SimpleDateFormat class
                    is not thread safe. It will produce unpredictable results if
                    multiple threads try to use the same instance without locking.</li>
                <li>Normally use lower case "y" for the year. Upper case "Y" is
                    the <a href="https://en.wikipedia.org/wiki/ISO_week_date">week year</a>
                    and will normally be the same as they year but can differ around new
                    year.
                </li>
                <li>L vs M: LLLL outputs the stand alone form of the month. This
                    is identical to MMMM in English but in languages such as Finnish,
                    MMMM varies depending on whether a day is included while LLLL
                    always outputs the month in the standard form.</li>
            </ul>
        </div>

        <div id="sidebar">
            <h2>Patterns</h2>
            <table>
                <thead>
                    <tr>
                        <th>Letter</th>
                        <th>Meaning</th>
                        <th colspan="2">Notes</th>
                    </tr>
                </thead>

                <tr>
                    <th colspan="4">Date Formatting</th>
                </tr>
                <tr>
                    <td rowspan="2">y</td>
                    <td rowspan="2">Year</td>
                    <td>yy</td>
                    <td>two digit year</td>
                </tr>
                <tr>
                    <td>yyyy</td>
                    <td>four digit year</td>
                </tr>
                <tr>
                    <td rowspan="4">M</td>
                    <td rowspan="4">Month</td>
                    <td>M</td>
                    <td>one or two digit month</td>
                </tr>
                <tr>
                    <td>MM</td>
                    <td>two digit month</td>
                </tr>
                <tr>
                    <td>MMM</td>
                    <td>abbreviated month name</td>
                </tr>
                <tr>
                    <td>MMMM</td>
                    <td>full month name</td>
                </tr>
                <tr>
                    <td rowspan="2">d</td>
                    <td rowspan="2">Date</td>
                    <td>d</td>
                    <td>one or two digit date</td>
                </tr>
                <tr>
                    <td>dd</td>
                    <td>two digit date</td>
                </tr>
                <tr>
                    <td>G</td>
                    <td>Era</td>
                    <td>G</td>
                    <td>BC/AD</td>
                </tr>
                <tr>
                    <td rowspan="2">E</td>
                    <td rowspan="2">Day of Week Name</td>
                    <td>E</td>
                    <td>abbreviated day name</td>
                </tr>
                <tr>
                    <td>EEEE</td>
                    <td>full day name</td>
                </tr>

                <tr>
                    <th colspan="4">Time</th>
                </tr>
                <tr>
                    <td rowspan="2">H</td>
                    <td rowspan="2">Hour (0-23)</td>
                    <td>H</td>
                    <td>one or two digit hour</td>
                </tr>
                <tr>
                    <td>HH</td>
                    <td>two digit hour</td>
                </tr>
                <tr>
                    <td>h</td>
                    <td>Hour (1-12)</td>
                </tr>
                <tr>
                    <td>k</td>
                    <td>Hour (1-24)</td>
                </tr>
                <tr>
                    <td>K</td>
                    <td>Hour (0-11)</td>
                </tr>
                <tr>
                    <td rowspan="2">m</td>
                    <td rowspan="2">Minute</td>
                    <td>m</td>
                    <td>one or two digit minute</td>
                </tr>
                <tr>
                    <td>mm</td>
                    <td>two digit minute</td>
                </tr>
                <tr>
                    <td rowspan="2">s</td>
                    <td rowspan="2">Second</td>
                    <td>s</td>
                    <td>one or two digit second</td>
                </tr>
                <tr>
                    <td>ss</td>
                    <td>two digit second</td>
                </tr>
                <tr>
                    <td>S</td>
                    <td>Millisecond</td>
                    <td>SSS</td>
                    <td>three digit milliseconds</td>
                </tr>
                <tr>
                    <td>a</td>
                    <td>am/pm Marker</td>
                    <td>a</td>
                    <td>AM/PM</td>
                </tr>

                <tr>
                    <th colspan="4">Time Zone</th>
                </tr>
                <tr>
                    <td rowspan="2">z</td>
                    <td rowspan="2">Time Zone Name</td>
                    <td>z</td>
                    <td>abbreviated time zone name</td>
                </tr>
                <tr>
                    <td>zzzz</td>
                    <td>full time zone name</td>
                </tr>
                <tr>
                    <td>Z</td>
                    <td>Time Zone Offset</td>
                    <td>Z</td>
                    <td>offset in hours and minutes</td>
                </tr>
                <tr>
                    <td rowspan="3">X</td>
                    <td rowspan="3">ISO Time Zone Offset</td>
                    <td>X</td>
                    <td>two digit offset</td>
                </tr>
                <tr>
                    <td>XX</td>
                    <td>four digit offset</td>
                </tr>
                <tr>
                    <td>XXX</td>
                    <td>four digit offset with colon</td>
                </tr>

                <tr>
                    <th colspan="4">ISO Week Date</th>
                </tr>
                <tr>
                    <td>Y</td>
                    <td>Week year</td>
                    <td colspan="2"></td>
                </tr>
                <tr>
                    <td>w</td>
                    <td>Week in year</td>
                    <td colspan="2">e.g. 15th week of the year</td>
                </tr>
                <tr>
                    <td>u</td>
                    <td>Week day number</td>
                    <td colspan="2">e.g. 3rd day of the week</td>
                </tr>

                <tr>
                    <th colspan="4">Additional Date Formatting</th>
                </tr>
                <tr>
                    <td>W</td>
                    <td>Week in Month</td>
                    <td colspan="2">e.g. second week of month</td>
                </tr>
                <tr>
                    <td>D</td>
                    <td>Day in Year</td>
                    <td colspan="2">e.g. 145th day of year</td>
                </tr>
                <tr>
                    <td>F</td>
                    <td>Day of Week in Month</td>
                    <td colspan="2">e.g. third Monday of the month</td>
                </tr>
                <tr>
                    <td>L</td>
                    <td>Standalone Month in Year</td>
                    <td>LLLL</td>
                    <td>full month name</td>
                </tr>
            </table>
        </div>
	</body>
</html>
