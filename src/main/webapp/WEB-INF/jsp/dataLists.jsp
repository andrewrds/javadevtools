<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<datalist id="localesList">
    <c:forEach var="l" items="${locales}">
        <option value="${fn:escapeXml(l.toLanguageTag())}">
            <c:out value="${l.toLanguageTag()}: ${l.displayName}"/>
        </option>
    </c:forEach>
</datalist>   
        
<datalist id="timeZonesList">
    <c:forEach var="z" items="${timeZones}">
        <option value="${fn:escapeXml(z.ID)}">
            <c:out value="${z.ID}"/>
        </option>
    </c:forEach>
</datalist>  