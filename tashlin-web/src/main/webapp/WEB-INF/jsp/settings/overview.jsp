<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h1><spring:message code="settings.title" /></h1>

<form action="<c:url value="/settings" />" method="post">
	<h2><spring:message code="settings.colors.title" /></h2>
	<spring:message code="settings.colors.label.success" /><input type="text" name="color.success" value="" /><br />
	<spring:message code="settings.colors.label.failure" /><input type="text" name="color.failure" value="" /><br />
	<spring:message code="settings.colors.label.unstable" /><input type="text" name="color.unstable" value="" /><br />

	<input type="submit" value="<spring:message code="button.save" />" />
	
	
	
</form>