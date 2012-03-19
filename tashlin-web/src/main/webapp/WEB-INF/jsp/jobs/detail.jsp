<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>${job.name}</h1>

<form action="<c:url value="/jobs/${job.id}" />" method="post">
	<input type="submit" value="Run Build">
</form>