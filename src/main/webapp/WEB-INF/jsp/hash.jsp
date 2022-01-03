<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
    <head>
		<title>Hash Generator</title>
		<meta content="Generate MD5, SHA1, SHA256 and SHA512 hashes" name="description" />
		<jsp:directive.include file="commonHeaders.jsp" />
	</head>
	<body>
		<div id="header">
			<h1>Hash Generator</h1>
		</div>
		
		<jsp:include page="menu.jsp">
			<jsp:param name="page" value="hash" />
		</jsp:include>

		<div id="content">
			<p>
				Generate MD5, SHA1, SHA256 and SHA512 hashes
			</p>

			<form id="hashgenerator">
				<textarea id="inputText"
				          rows="10"
				          maxlength="5000"
				          autofocus="autofocus"
				          oninput="sendHashGenerateRequest()"></textarea>
			</form>
			
			<div class="resulttable">
				<div class="resultrow">
					<span class="resultname">MD5</span>
					<input id="md5result" class="resultvalue" readonly="readonly"></input>
					<button class="resultbutton" onclick="copyText('md5result')">Copy</button>
				</div>
				
				<div class="resultrow">
					<span class="resultname">SHA1</span>
					<input id="sha1result" class="resultvalue" readonly="readonly"></input>
					<button class="resultbutton" onclick="copyText('sha1result')">Copy</button>
				</div>	
				
				<div class="resultrow">
					<span class="resultname">SHA-256</span>
					<input id="sha256result" class="resultvalue" readonly="readonly"></input>
					<button class="resultbutton" onclick="copyText('sha256result')">Copy</button>
				</div>
				
				<div class="resultrow">
					<span class="resultname">SHA-512</span>
					<input id="sha512result" class="resultvalue" readonly="readonly"></input>
					<button class="resultbutton" onclick="copyText('sha512result')">Copy</button>
				</div>
			</div>								

        </div>

	</body>
</html>
