<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<form id="dateformat">
    <div>
        <label for="inputFormat">Format Pattern</label>
        <input id="inputFormat"
               placeholder="yyyy-MM-dd'T'HH:mm:ss"
               autocomplete="off"
               maxlength="300"
               oninput="sendFormatRequest('${param.url}')"/>
    </div>

    <div>
        <label for="inputLocale">Locale</label>
        <input id="inputLocale"
               autocomplete="off"
               maxlength="100"
               oninput="sendFormatRequest('${param.url}')"
               onclick="this.select()"
               list="localesList"
               value="en-US: English (United States)" />
    </div>
    
    <div>
    	<label for="inputTimeZone">Time Zone</label>
    	<input id="inputTimeZone"
    	       autocomplete="off"
    	       maxlength="100"
    	       oninput="sendFormatRequest('${param.url}')"
    	       onclick="this.select()"
    	       list="timeZonesList"
    	       value="America/New_York"/>
    </div>
</form>

<div class="resultPanel">
    <p id="result">Empty input</p>
</div>

<p>
    Java Version: <c:out value="${javaVersion}" />
</p>