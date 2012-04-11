<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2><spring:message code="jobs.add.title" /></h2>

<form:form commandName="jobDefinition" cssClass="form-horizontal">
        <fieldset>
          <div class="control-group">
            <label for="name" class="control-label"><spring:message code="job.name.label" /></label>
            <div class="controls">
            	<form:input path="name" cssClass="input-xlarge" />
            	<form:errors path="name" cssClass="error" />
            </div>
          </div>
          <div class="form-actions">
           	<button class="btn btn-primary" type="submit"><spring:message code="button.save" /></button>
            <button class="btn">Cancel</button>
          </div>
        </fieldset>
</form:form>





