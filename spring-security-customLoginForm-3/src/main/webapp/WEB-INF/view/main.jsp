<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>First Spring mvc Java configuration</title>
</head>
<body>
<h1>First Spring mvc Java configuration
</h1>

<form:form action="${pageContext.request.contextPath}/logout" method="post">

<input type="submit" value="logout">

</form:form>
</body>
</html>