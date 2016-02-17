<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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


<script type="text/javascript">
$(function() { // document ready
	  
	  $('#calendar').fullCalendar({
	    header: {
	      left: 'prev,next today',
	      center: 'title',
	      right: 'month,agendaWeek,agendaDay'
	    },
	    defaultDate: '2014-11-12',
	    editable: true,
	    eventLimit: true, // allow "more" link when too many events
	    events: [
	      {
	        title: 'All Day Event',
	        start: '2014-11-01'
	      },
	      {
	        title: 'Long Event',
	        start: '2014-11-07',
	        end: '2014-11-10'
	      },
	      {
	        id: 999,
	        title: 'Repeating Event',
	        start: '2014-11-09T16:00:00'
	      },
	      {
	        id: 999,
	        title: 'Repeating Event',
	        start: '2014-11-16T16:00:00'
	      },
	      {
	        title: 'Conference',
	        start: '2014-11-11',
	        end: '2014-11-13'
	      },
	      {
	        title: 'Meeting',
	        start: '2014-11-12T10:30:00',
	        end: '2014-11-12T12:30:00'
	      },
	      {
	        title: 'Lunch',
	        start: '2014-11-12T12:00:00'
	      },
	      {
	        title: 'Meeting',
	        start: '2014-11-12T14:30:00'
	      },
	      {
	        title: 'Happy Hour',
	        start: '2014-11-12T17:30:00'
	      },
	      {
	        title: 'Dinner',
	        start: '2014-11-12T20:00:00'
	      },
	      {
	        title: 'Birthday Party',
	        start: '2014-11-13T07:00:00'
	      },
	      {
	        title: 'Click for Google',
	        url: 'http://google.com/',
	        start: '2014-11-28'
	      }
	    ]
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