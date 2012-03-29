<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="well sidebar-nav">
	<ul class="nav nav-list">
		<li class="nav-header">Sidebar</li>
		<li><a href="<c:url value="/job/${key}/summary" />"><spring:message code="jobs.summary.link" /></a></li>
		<li><a href="<c:url value="/job/${key}/schedule" />"><spring:message code="jobs.schedule.link" /></a></li>
		<li><a href="<c:url value="/job/${key}/delete" />"><spring:message code="jobs.delete.link" /></a></li>
	</ul>
</div>
