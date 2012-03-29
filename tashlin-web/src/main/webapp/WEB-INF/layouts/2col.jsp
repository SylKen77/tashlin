<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <c:set var="title">
		<tiles:getAsString name="title" />
	</c:set>
	<title><spring:message code="${title}" /> - Tashlin</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
      .sidebar-nav {
        padding: 9px 0;
      }
    </style>
    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a> 
          <a class="brand" href="<c:url value="/jobs" />">Tashlin</a>
          <div class="nav-collapse">
            <ul class="nav">
              <li><a href="<c:url value="/jobs" />"><spring:message code="jobs.title" /></a></li>
              <li><a href="<c:url value="/settings" />"><spring:message code="settings.title" /></a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>

    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span3">
        	<tiles:insertAttribute name="nav" />
        </div><!--/span-->
        <div class="span9">
         	<tiles:insertAttribute name="page" />
        </div><!--/span-->
      </div><!--/row-->

      <hr>

      <footer>
        <p>&copy; Tashlin 2012</p>
      </footer>

    </div>
  </body>
</html>
