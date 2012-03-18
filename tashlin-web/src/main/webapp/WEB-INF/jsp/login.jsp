<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

LOGIN

<form action="<c:url value='j_spring_security_check'/>" method="post">
	Username <input type="text" name="j_username" />
	Password <input type="text" name="j_password" />
	<input type="submit" value="Login" />
</form>