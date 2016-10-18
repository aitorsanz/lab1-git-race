<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Hello world</title>
        <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.5/css/bootstrap.min.css" />
        <script type="text/javascript" src="webjars/jquery/2.1.4/jquery.min.js"></script>
    </head>
    <body>
      <nav class="navbar navbar-inverse">
        <div class="container">
          <div class="navbar-header">
            <a class="navbar-brand" href="#">Web Engineering</a>
          </div>
        </div><!-- /.container -->
      </nav><!-- /.navbar -->
      
      <div class="container">
        <div class="row">
          <div class="col-xs-12 col-sm-6">
            <div class="jumbotron">
              <h2><strong>Welcome to UNIZAR Web Engineering's test page!</strong></h2>
              <p><small><em>This page has been made by the web engineering's students.</em></small></p>
            </div>
          </div>
          <div class="col-xs-12 col-sm-6">
            <!-- A Bootstrap panel showing the console with the current time and a message from the server -->
            <div class="panel panel-default">
                <div class="panel-heading">Number of users online: <strong id="onlineUsers">0</strong></div>
                <div class="panel-body"><kbd>${time}<span class="glyphicon glyphicon-console"></span>${message}</kbd></div>
                <div class="panel-footer">
                	<a href="last">
                		This page has been visited <strong>${hitCounter}</strong> time${hitCounter != 1 ? "s" : ""}!
                	</a>
                </div>
            </div>
            <form method="Post" action="http://localhost:8080/name">
            	Write you name!!<br/>
            	<input name="userName" type="text"/><br/><br/>
            	<input type="submit" value="Enter Name"/>
            </form>
            <div class="panel panel-default">
                <div class="panel-heading">Server location: <strong id="location"></strong></div>
            </div>
          </div>
        </div>
      </div>
     
        <!-- Script to update the number of online users -->
        <script type="text/javascript">

            // Connect to the server WebSocket after getting its location
            // (adds support for non-local servers)
            var ws = new WebSocket("ws://" + window.location.host + "/ws");
            ws.onmessage = function(res) {
                // Replace the number of online users with the value from the WebSocket
                var count = JSON.parse(res.data).numClients;
                document.getElementById("onlineUsers").innerHTML = count;
            };
        </script>

        <!-- Script to search the location of the server ip. -->
        <script>
          var ip = "http://ip-api.com/json/" + window.location.hostname;
          $.getJSON(ip , function(data) {
              if (data.status !== "fail") {
                document.getElementById("location").innerHTML = data.city;
              }
              else {
                document.getElementById("location").innerHTML = "error " + data.message;
              }
          });
        </script>

    </body>
</html>
