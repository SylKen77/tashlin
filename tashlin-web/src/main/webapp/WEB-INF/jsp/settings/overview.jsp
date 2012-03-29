<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1><spring:message code="settings.title" /></h1>

<form:form commandName="globalSettings" cssClass="form-horizontal">
        <fieldset>
          <div class="control-group">
            <label for="input01" class="control-label"><spring:message code="settings.mavenHome.label" /></label>
            <div class="controls">
            	<form:input path="mavenHome" cssClass="input-xlarge" />
            </div>
          </div>
          <div class="form-actions">
            <button class="btn btn-primary" type="submit"><spring:message code="button.save" /></button>
            <button class="btn">Cancel</button>
          </div>
        </fieldset>
</form:form>