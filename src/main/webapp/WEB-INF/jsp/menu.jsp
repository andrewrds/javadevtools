<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<div id="menu">
	<p>SimpleDateFormat</p>
	<p>&nbsp;
		<c:choose>
			<c:when test="${param.page == 'simpledateformat'}">format</c:when>
			<c:otherwise>
				<a href="simpledateformat">format</a>
			</c:otherwise>
		</c:choose>
	</p>
	
	<p>&nbsp;
		<c:choose>
			<c:when test="${param.page == 'simpledateformatparse'}">parse</c:when>
			<c:otherwise>
				<a href="simpledateformatparse">parse</a>
			</c:otherwise>
		</c:choose>
	</p>
	
	<p>DateTimeFormatter</p>
	<p>&nbsp;
		<c:choose>
			<c:when test="${param.page == 'datetimeformatter'}">format</c:when>
			<c:otherwise>
				<a href="datetimeformatter">format</a>
			</c:otherwise>
		</c:choose>
	</p>	
	
	<p>&nbsp;
		<c:choose>
			<c:when test="${param.page == 'datetimeformatterparse'}">parse</c:when>
			<c:otherwise>
				<a href="datetimeformatterparse">parse</a>
			</c:otherwise>
		</c:choose>
	</p>			
</div>
