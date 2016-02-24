<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if
	test="${empty sessionScope || sessionScope.status == 'logado' && sessionScope.usuario.isAdmin() != true}">
	<c:redirect url="index.jsp"></c:redirect>
</c:if>
<c:if
	test="${sessionScope.status == 'logado' && sessionScope.usuario.isAdmin() == true }">

	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
<head>

<title>Gerencia Usuários</title>

<meta charset='utf-8' />
<link
	href='http://fullcalendar.io/js/fullcalendar-2.6.0/fullcalendar.css'
	rel='stylesheet' />
<link
	href='http://fullcalendar.io/js/fullcalendar-2.6.0/fullcalendar.print.css'
	rel='stylesheet' media='print' />
<script
	src='//cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment.min.js'></script>
<script src='//ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script
	src='http://fullcalendar.io/js/fullcalendar-2.6.0/fullcalendar.js'></script>


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

	<div class="container"  >

		<!-- Static navbar -->
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">

					<a class="navbar-brand" href="#">Calendário de Feriados 1.0</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">

					
					<ul class="nav navbar-nav navbar-right">
					<li><a href="dashboard-administrador.jsp">Dashboard</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">Gerenciar Feriados<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="cadastrar-feriado-fixo.jsp">Adicionar Feriado Fixo</a></li>
								<li><a href="controller.do?op=addFeriadoSubstituto">Adicionar Feriado Substituto</a></li>
								<li><a href="cadastrar-feriado-movel.jsp">Adicionar Feriado Móvel</a></li>
							</ul></li>
						<li><a href="lista-usuarios.jsp">Gerenciar Usuários</a></li>

						<li><a href="controller.do?op=logout">Sair</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
			<!--/.container-fluid -->
		</nav>

		<!-- Main component for a primary marketing message or call to action -->



	</div>
	<!-- /container -->
<br><br>
	<div class="panel panel-default"style="width: 600px; position: relative; left: 30%; right: 30% ">
		<!-- Default panel contents -->
		<div class="panel-heading">Usuários</div>

		<!-- Table -->
		<table class="table table-striped">
		<tr>
                    <th>Usuário</th>
                    <th>login</th>
                    <th></th>
                </tr>
		<c:forEach var="usuario" items="${requestScope.usuarios}">
		<tr>
    <td>
        <c:out value="${usuario.getNome()}" />
    </td>
    <td>
     <c:out value="${usuario.getLogin()}" />
    </td>
    <td>
		<a href="/pwebprojeto/controller.do?op=excluirFeriado" class="btn btn-danger">Excluir</a>
    </td>
    </tr>
</c:forEach>
		</table>
	</div>

</body>
	</html>

</c:if>
