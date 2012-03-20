<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!doctype html>
<html>
	<head>
		<c:set var="title"><tiles:getAsString name="title" /></c:set>
		<title><spring:message code="${title}" /> - Tashlin</title>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/tashlin.css" />" />
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/grids.css" />" />
	</head>
	<body>
		<div id="hd">
			<a href="/" id="logo" title="Home"></a>
			<ul id="nv">
				<li><a href="<c:url value="/jobs" />"><spring:message code="jobs.title" /></a></li>
				<li><a href="<c:url value="/views" />"><spring:message code="views.title" /></a></li>
				<li><a href="<c:url value="/plugins" />"><spring:message code="plugins.title" /></a></li>
				<li class="right"><a href="<c:url value="/settings" />"><spring:message code="settings.title" /></a></li>
			</ul>
		</div>
		<div id="doc3" class="yui-t6">
			<div id="yui-main">
				<div class="yui-b">
					<tiles:insertAttribute name="page" />
				</div>
			</div>
			<div class="yui-b">menu</div>
		</div>
	</body>
</html>

