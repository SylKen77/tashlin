<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>

	var timer;
	$(document).ready(function() {
		$("#run").click(function() {
			$.get('<c:url value="/job/${job.key}/build" />', function(data) {
				timer = setInterval(writeToConsole, 500);
			});
		});
	});
	
	function writeToConsole() {
		$.get('<c:url value="/job/${job.key}/status" />', function(data) {
			if(data.status != null) {
				$("#console").append("<pre>" + data.status + "</pre>");
			} else {
				clearInterval(timer);
			}
		});
	}
	
	
</script>

<h1>${job.name}</h1>
<div id="console"></div>