<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<h1><spring:message code="settings.title" /></h1>


<form:form  commandName="globalSettings">
	<spring:message code="settings.mavenHome.label" />
	<form:input path="mavenHome" />

	<input type="submit" value="<spring:message code="button.save" />" />
	
	
	
</form:form>