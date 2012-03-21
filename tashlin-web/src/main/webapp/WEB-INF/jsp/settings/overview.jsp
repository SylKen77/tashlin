<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<h1><spring:message code="settings.title" /></h1>


<form:form  commandName="settings">
	<h2><spring:message code="settings.colors.title" /></h2>
	<spring:message code="settings.colors.label.success" />
	<form:input path="colors.success" />

	<input type="submit" value="<spring:message code="button.save" />" />
	
	
	
</form:form>