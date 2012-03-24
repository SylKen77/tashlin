<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<script>
	$(document).ready(function() {
		$("#run").click(function() {
			$.get('<c:url value="/job/build" />', function(data) {
				$('#console').html(data.status);
			});
		});
	});
</script>

<h1><spring:message code="jobs.title" /></h1>

<ul>
<c:forEach var="job" items="${jobs}">
	<li><a href="<c:url value='/job/${job.name}/summary' />">${job.name}</a></li>
</c:forEach>
</ul>


<input id="run" type="button" value="run build" />

<div id="console"></div>
