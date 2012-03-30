<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<script>

	var timer;
	$(document).ready(function() {
		$("#run").click(function() {
			$.get('<c:url value="/job/${job.key}/build" />', function(data) {
				timer = setInterval(writeToConsole, 500);
			});
		});
	});
	

	
	
</script>


<h2>Jobs</h2>

<p class="pull-right">
	<a class="btn" href="<c:url value="/jobs/add" />">
		<i class="icon-plus"></i><spring:message code="jobs.add.title" />
	</a>
	<a class="btn" href="<c:url value="/settings/reload" />" title="<spring:message code="reload.configuration" />">
		<i class="icon-repeat"></i>
	</a>
</p>

<c:if test="${not empty jobs}">
<table class="table table-striped">
        <thead>
          <tr>
            <th style="width: 50px;"><spring:message code="jobs.status.label" /></th>
            <th><spring:message code="jobs.name.label" /></th>
            <th style="width: 50px;"></th>
            <th style="width: 50px;"></th>
          </tr>
        </thead>
             <tbody>
        <c:forEach var="job" items="${jobs}">
          <tr>
            <td><span class="label label-success">Success</span></td>
            <td><a href="<c:url value='/job/${job.key}/summary' />">${job.name}</a></td>
            <td><a class="btn schedule"><i class="icon-play"></i></a></td>
            <td><a href="<c:url value='/job/${job.key}/delete' />" class="btn"><i class="icon-trash"></i></a></td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
</c:if>






