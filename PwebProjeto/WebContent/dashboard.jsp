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

<title>Dashboard</title>

<link
	href='fullcalendar/fullcalendar.css'
	rel='stylesheet' />
<link
	href='fullcalendar/fullcalendar.print.css'
	rel='stylesheet' media='print' />
<script
	src='fullcalendar/moment.min.js'></script>
<script src='fullcalendar/jquery.min.js'></script>
<script
	src='fullcalendar/fullcalendar.js'></script>


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="bootstrap/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="bootstrap/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="bootstrap/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

<!-- Custom styles for this template -->
<link href="css/navbar.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/styles.css" rel="stylesheet">
<script type="text/javascript">
$(document).ready(function() {


	var Admin = "${sessionScope.usuario.isAdmin()}";
	  $('#calendar').fullCalendar({
	    header: {
	      left: 'prev,next today',
	      center: 'title',
	      right: ''
	    },

	    eventSources: [
	          	     "/pwebprojeto/controller.do?op=getNotas",
		             "/pwebprojeto/controller.do?op=getEventos"
		          	    ],
	

	    dayClick: function(date, jsEvent, view) {
	
	       		window.location.href = "/pwebprojeto/adicionar-nota.jsp?data="+date.format("DD/MM/YYYY");
		
	    },


		eventClick: function(calEvent, jsEvent, view) {
			//$("#commentModal").modal();

				window.location.href = "/pwebprojeto/controller.do?descricao="+calEvent.title+"&data="+calEvent.date+"&id="+calEvent.id+"&op=alterarNotaJSP ";

  }


	  
})

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
						<li><a href="controller.do?op=alterarUsuario">Configurações</a></li>
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

	<div id="calendar"></div>
<div id="legendas" style="position: absolute; left: 23.98%">Legenda: (Feriado Fixo: <a style="color: #c36969">Vermelho</a> / Feriado Substituto: <a style="color: #69c36f">Verde</a> / Feriado Móvel: <a style="color: #7269c3">Roxo</a> / Notas: <a style="color: #a1a1a1">Cinza</a>)</div>

</body>
	</html>


</c:if>
