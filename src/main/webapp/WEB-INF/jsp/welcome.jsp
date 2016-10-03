<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Hello world</title>
        <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.5/css/bootstrap.min.css" />
        <script type="text/javascript" src="webjars/jquery/2.1.4/jquery.min.js"></script>
    </head>
    <body>
        <div class="container">
            <h2>Welcome to UNIZAR Web Engineering's test page!</h2>
            <!-- A Bootstrap panel showing the console with the current time and a message from the server -->
            <div class="panel panel-default">
                <div class="panel-heading">Number of users online: <strong id="onlineUsers">0</strong></div>
                <div class="panel-body"><kbd>${time}<span class="glyphicon glyphicon-console"></span>${message}</kbd></div>
                <div class="panel-footer">This page has been visited <strong>${hitCounter}</strong> time${hitCounter != 1 ? "s" : ""}!</div>
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
