<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<div id="menu">
	<p>
		<c:choose>
			<c:when test="${param.page == 'simpledateformat'}">SimpleDateFormat Tester</c:when>
			<c:otherwise>
				<a href="simpledateformat">SimpleDateFormat Tester</a>
			</c:otherwise>
		</c:choose>
	</p>
	
	<p>
		<c:choose>
			<c:when test="${param.page == 'datetimeformatter'}">DateTimeFormatter Tester</c:when>
			<c:otherwise>
				<a href="datetimeformatter">DateTimeFormatter Tester</a>
			</c:otherwise>
		</c:choose>
	</p>	
</div>
