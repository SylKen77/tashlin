<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<script>
	$(document).ready(function() {
		$("#run").click(function() {
			$.get('<c:url value="/jobs/build" />', function(data) {
				$('#console').html(data.status);
			});
		});
	});
</script>

<h1>
	<spring:message code="jobs.title" />
</h1>

<input id="run" type="button" value="run build" />

<div id="console"></div>
