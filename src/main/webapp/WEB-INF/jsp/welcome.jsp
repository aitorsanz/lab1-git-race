<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Hello world</title>
        <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.5/css/bootstrap.min.css" />
        <link href="offcanvas.css" rel="stylesheet">
        <script type="text/javascript" src="webjars/jquery/2.1.4/jquery.min.js"></script>
    </head>
    <body>
      <nav class="navbar navbar-fixed-top navbar-inverse">
        <div class="container">
          <div class="navbar-header">
            <a class="navbar-brand" href="#">Web Engineering</a>
          </div>
        </div><!-- /.container -->
      </nav><!-- /.navbar -->
      <br><br><br>
      <div class="container">
        <div class="row row-offcanvas row-offcanvas-right">
          <div class="col-xs-12 col-sm-6">
            <p class="pull-right visible-xs">
              <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
            </p>
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
                <div class="panel-footer">This page has been visited <strong>${hitCounter}</strong> time${hitCounter != 1 ? "s" : ""}!</div>
            </div>
          </div>
        </div>
      </div>

        <!-- Script to update the number of online users -->
        <script type="text/javascript">
            // Connect to the WebSocket
            var ws = new WebSocket("ws://localhost:8080/ws");
            ws.onmessage = function(res) {
                // Replace the number of online users with the value from the WebSocket
                var count = JSON.parse(res.data).numClients;
                document.getElementById("onlineUsers").innerHTML = count;
            };
        </script>
    </body>
</html>
