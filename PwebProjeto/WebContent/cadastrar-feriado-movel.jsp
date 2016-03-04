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

<title>Cadastrar Feriado Móvel</title>

<meta charset='utf-8' />
<script src='fullcalendar/jquery.min.js'></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="bootstrap/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="bootstrap/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="bootstrap/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

<script
	src="bootstrap/bootstrap-datepicker.min.js"></script>


<!-- Custom styles for this template -->
<link href="css/navbar.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/styles.css" rel="stylesheet">

<script>
	$(document).ready(function() {
		$('#inicioFeriado').datepicker({
			format : 'dd/mm/yyyy'
		}).on('changeDate', function(e) {
			// Revalidate the date field
			$('#eventForm').formValidation('revalidateField', 'date');
		});


		$('#fimFeriado').datepicker({
			format : 'dd/mm/yyyy'
		}).on('changeDate', function(e) {
			// Revalidate the date field
			$('#eventForm').formValidation('revalidateField', 'date');
		});
		
		$('#eventForm').formValidation({
			framework : 'bootstrap',
			icon : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				name : {
					validators : {
						notEmpty : {
							message : 'The name is required'
						}
					}
				},
				date : {
					validators : {
						notEmpty : {
							message : 'The date is required'
						},
						date : {
							format : 'DD/MM/YYYY',
							message : 'The date is not a valid'
						}
					}
				}
			}
		});
	});
</script>

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
						<li><a href="dashboard-administrador.jsp">Dashboard</a></li>
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
	<div align="center">
		<form class="form-horizontal" method="POST" action="controller.do">
			<fieldset>

				<!-- Form Name -->
				<legend>Adicionar Feriado Móvel</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="tituloFeriado">Nome
						do Feriado</label>
					<div class="col-md-4">
						<input id="tituloFeriado" name="tituloFeriadoMovel" type="text"
							placeholder="Digite o nome do feriado"
							class="form-control input-md">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4  control-label">Inicio</label>
					<div class="col-md-4 date">
						<div class="input-group input-append date" id="inicioFeriado">
							<input type="text" class="form-control" name="inicioFeriadoMovel" />
							<span class="input-group-addon add-on"><span
								class="glyphicon glyphicon-calendar"></span></span>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4  control-label">Fim</label>
					<div class="col-md-4 date">
						<div class="input-group input-append date" id="fimFeriado">
							<input type="text" class="form-control" name="fimFeriadoMovel" /> <span
								class="input-group-addon add-on"><span
								class="glyphicon glyphicon-calendar"></span></span>
						</div>
					</div>
				</div>

				<input type="hidden" name="op" value="addFeriadoMovel" />
				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for=""></label>
					<div class="col-md-4">
						<button id="" name="" class="btn btn-inverse">Adicionar</button>
					</div>
				</div>

			</fieldset>
		</form>
	</div>
	<br>
	<br>
	<br>
	<div align="center" id="resultado">${requestScope.resultado }</div>

</body>
	</html>

</c:if>
