<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html> 

<head>
<style>
  .failed{
    color: red;
  }
</style>
</head>
<body>

<h3>
My Custom Login Page
</h3>

<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="post">

<c:if test="${param.error!=null}">
<i class="failed">Wrong username or password </i>
</c:if>

<c:if test="${param.logout!=null}">
<i class="failed">You have been logout </i>
</c:if>
<p>
user name : <input type="text" name="username" />
</p>
<p>
password : <input type="password" name="password" />
</p>
<input type="submit" value="login">
</form:form>
</body>


</html>