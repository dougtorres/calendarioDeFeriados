<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if
	test="${empty sessionScope || sessionScope.status == 'logado' && sessionScope.usuario.isAdmin() != false}">
	<c:redirect url="index.jsp"></c:redirect>
</c:if>
<c:if
	test="${sessionScope.status == 'logado' && sessionScope.usuario.isAdmin() == false }">
	
	
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
<head>

<title>Adicionar Nota</title>

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

<script
	src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.min.js"></script>


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

					<a class="navbar-brand" href="#">Calend�rio de Feriados 1.0</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">

					<ul class="nav navbar-nav navbar-right">
						
					<ul class="nav navbar-nav navbar-right">
						<li><a href="dashboard.jsp">Dashboard</a></li>
						<li><a href=controller.do?op=alterarUsuario">Configura��es</a></li>
						<li><a href="controller.do?op=logout">Sair</a></li>
					</ul>
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
				<legend>Adicionar Nota</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="descricaoNota">Descri��o da Nota</label>
					<div class="col-md-4">
						<input id="descricaoNota" name="descricaoNota" type="text"
							placeholder="Digite a descri��o da nota"
							class="form-control input-md" >
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4  control-label">Data</label>
					<div class="col-md-4 date">
						<div class="input-group input-append date" id="dataNota">
							<input type="text" class="form-control" name="dataNota" value="${param.data}"/>
							<span class="input-group-addon add-on"><span
								class="glyphicon glyphicon-calendar"></span></span>
						</div>
					</div>
				</div>


				<input type="hidden" name="op" value="adicionarNota" />
				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for=""></label>
					<div class="col-md-4">
						<button id="" name="" class="btn btn-inverse">Adicionar</button>
					</div>
				</div>

			</fieldset>
		</form>
	<br>
	<br>
	<br>
	<div align="center" id="resultado">${requestScope.resultado }</div>

</body>
	</html>
	
	
</c:if>