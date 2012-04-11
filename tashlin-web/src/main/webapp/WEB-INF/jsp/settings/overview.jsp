<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1><spring:message code="settings.title" /></h1>

<form:form commandName="globalSettings" cssClass="form-horizontal">
        <fieldset>
          <div class="control-group">
            <label for="mavenHome" class="control-label"><spring:message code="settings.mavenHome.label" /></label>
            <div class="controls">
            	<form:input path="mavenHome" cssClass="input-xlarge" />
            	<form:errors path="mavenHome" cssClass="error" />
            </div>
          </div>
          <div class="form-actions">
            <button class="btn btn-primary" type="submit"><spring:message code="button.save" /></button>
            <a href="<c:url value="/" />" class="btn"><spring:message code="button.cancel" /></a>
          </div>
        </fieldset>
</form:form>