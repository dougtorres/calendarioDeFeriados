<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${empty sessionScope || sessionScope.status == 'logado' && sessionScope.usuario.isAdmin() != true}">
	<c:redirect url="index.jsp"></c:redirect>
</c:if>
<c:if test="${sessionScope.status == 'logado' && sessionScope.usuario.isAdmin() == true }">
	    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DashBoard Administrador</title>
</head>
<body>

</body>
</html>

</c:if>