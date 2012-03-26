<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!doctype html>
<html>
<head>
<c:set var="title">
	<tiles:getAsString name="title" />
</c:set>
<title><spring:message code="${title}" /> - Tashlin</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/tashlin.css" />" />
<script src="<c:url value="/resources/js/jquery-1.7.2.min.js" />" /></script>
</head>
<body>
	<div id="hd">
		<a href="<c:url value="/" />"><h1>Tashlin</h1></a>
		<div id="pf">
			<a href="<c:url value="/settings" />"><spring:message code="settings.title" /></a>
		</div>
	</div>


	<tiles:insertAttribute name="page" />
</body>
</html>

