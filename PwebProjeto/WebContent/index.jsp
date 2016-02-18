<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<title>Calendário</title>

<meta charset='utf-8' />
<link href='http://fullcalendar.io/js/fullcalendar-2.6.0/fullcalendar.css' rel='stylesheet' />
<link href='http://fullcalendar.io/js/fullcalendar-2.6.0/fullcalendar.print.css' rel='stylesheet' media='print' />
<script src='//cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment.min.js'></script>
<script src='//ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='http://fullcalendar.io/js/fullcalendar-2.6.0/fullcalendar.js'></script>


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

<!-- Custom styles for this template -->
<link href="css/navbar.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/styles.css" rel="stylesheet">


<script>

$(document).ready(function() { // document ready
	
	  $('#calendar').fullCalendar({
	    header: {
	      left: 'prev,next today',
	      center: 'title',
	      right: 'month,agendaWeek,agendaDay'
	    },
	    
	    events: "/pwebprojeto/controller.do?op=getEventos"
	    
	  });

	  $(".fc-prev-button, .fc-next-button, .fc-today-button").click(function(){

			var moment = $('#calendar').fullCalendar('getDate').format();
			$.ajax({
		        url: "/pwebprojeto/controller.do?op=getEventos&ano="+moment,
		        type: "GET"
			        


		    });
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
					    <li><a href="cadastro.jsp">Cadastre-se</a></li>
						<li><a href="login.jsp">Login</a></li>
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

</body>
</html>