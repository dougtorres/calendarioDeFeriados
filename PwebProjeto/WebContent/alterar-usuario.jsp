<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if
	test="${empty sessionScope || sessionScope.status != 'logado'}">
	<c:redirect url="index.jsp"></c:redirect>
</c:if>
<c:if test="${sessionScope.status == 'logado' }">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
	integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>

<!-- Custom styles for this template -->
<link href="css/navbar.css" rel="stylesheet">


<!-- Custom styles for this template -->
<link href="css/styles.css" rel="stylesheet">
</head>
<body>
	<div class="container">

		<!-- Static navbar -->
		<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">

				<a class="navbar-brand" href="#">Calendário de Feriados 1.0</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
				<li><a href="dashboard.jsp">Dashboard</a></li>
						<li><a href="controller.do?op=logout">Sair</a></li>
						</ul>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
		<!--/.container-fluid --> </nav>

		<!-- Main component for a primary marketing message or call to action -->

<form class="form-horizontal"  method="POST" action="controller.do" class="form-signin">
<fieldset>

<!-- Form Name -->
<legend>Alterar Conta</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="nome">Nome:</label>  
  <div class="col-md-4">
  <input id="nome" name="nome" type="text" placeholder="Digite seu nome" class="form-control input-md" value="${requestScope.usuario.getNome() }"/>
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="login">Login:</label>  
  <div class="col-md-4">
  <input id="login" name="login" type="text" placeholder="Digite um login" class="form-control input-md " value="${requestScope.usuario.getLogin() }">
    
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Senha:</label>
  <div class="col-md-4">
    <input id="password" name="password" type="password" placeholder="Digite uma senha" class="form-control input-md" value="${requestScope.usuario.getSenha() }">
    
  </div>
</div>
<input type="hidden" name="op" value="alterar_usuario"/>
<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for=""></label>
  <div class="col-md-4">
    <button id="" name="" class="btn btn-inverse">Alterar</button>
    <a href="/pwebprojeto/controller.do?op=excluirFeriado" class="btn btn-danger">Excluir</a>
  </div>
</div>

</fieldset>
</form>
<br><br>	
		
<br>
<br>
<br>
<div align="center" id="resultado">${requestScope.resultado }</div>
</body>
</html>


</c:if>