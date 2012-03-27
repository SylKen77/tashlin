<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<h1><spring:message code="jobs.title" /></h1>

<ul>
<c:forEach var="job" items="${jobs}">
	<li><a href="<c:url value='/job/${job.key}/summary' />">${job.name}</a></li>
</c:forEach>
</ul>



