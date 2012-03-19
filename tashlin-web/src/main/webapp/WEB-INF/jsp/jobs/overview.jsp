<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Jobs</h1>
<c:forEach var="job" items="${jobs}">
	<a href="<c:url value='/jobs/${job.id}'/>">${job.name}</a>
</c:forEach>