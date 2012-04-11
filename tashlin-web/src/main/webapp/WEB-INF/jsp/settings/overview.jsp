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
          </div>
        </fieldset>
</form:form>