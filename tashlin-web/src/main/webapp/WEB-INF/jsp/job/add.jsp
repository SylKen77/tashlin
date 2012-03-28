<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1><spring:message code="jobs.add.title" /></h1>

<form:form commandName="job">
	<spring:message code="job.name.label" /><form:input path="name" /><br />
	<spring:message code="job.cronSchedule.label" /><form:input path="cronSchedule" /><br />
	<input type="submit" value="<spring:message code="button.save" />"/>
</form:form>