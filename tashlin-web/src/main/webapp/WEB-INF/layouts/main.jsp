<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!doctype html>
<html>
	<head>
		<title>Tashlin</title>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/tashlin.css" />" />
	</head>
	<body>
		<div id="hd">
			
			<a href="#">Jobs</a>
			<a href="#">Settings</a>
		</div>
		
		<tiles:insertAttribute name="page" />
	</body>
</html>
