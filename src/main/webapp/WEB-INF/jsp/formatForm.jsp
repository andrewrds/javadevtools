<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<form id="dateformat">
    <div>
        <p>
            Format Pattern
            <input id="inputFormat"
                   placeholder="yyyy-MM-dd'T'HH:mm:ss"
                   autocomplete="off"
                   maxlength="300"
                   oninput="sendFormatRequest('${param.url}')"/>
        </p>

        <p>
            Locale
            <input id="inputLocale"
                   autocomplete="off"
                   oninput="sendFormatRequest('${param.url}')"
                   list="localesList"
                   value="en-US" />
        </p>
        
        <p>
        	Time Zone
        	<input id="inputTimeZone"
        	       autocomplete="off"
        	       oninput="sendFormatRequest('${param.url}')"
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