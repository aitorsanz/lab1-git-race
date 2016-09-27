<!DOCTYPE html>

<html lang="en">
	<head>
		<script type="text/javascript" src="webjars/jquery/2.1.4/jquery.min.js" ></script>
		<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.5/css/bootstrap.min.css" />
		<title>Hello world</title>
	</head>
	<body>
		<div class="container">
			<h2>Welcome to UNIZAR Web Engineering's test page!</h2>
			<!-- A Bootstrap panel showing the console with the current time and a message from the server -->
			<div class="panel panel-default">
				<div class="panel-body"><kbd>${time}<span class="glyphicon glyphicon-console"></span>${message}</kbd></div>
				<div class="panel-footer">This page has been visited <strong>${hitCounter}</strong> time${hitCounter != 1 ? "s" : ""}!</div>
			</div>
		</div>
	</body>
</html>