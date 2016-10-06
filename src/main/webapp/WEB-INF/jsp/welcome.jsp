<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Hello world</title>
	<!--Style adapted from https://davidwalsh.name/css-flip -->
	<style>	
		.flip-container {
		perspective: 1000px;
	}
		/* flip the pane when hovered */
		.flip-container:hover .flipper, .flip-container.hover .flipper {
			transform: rotateY(180deg);
		}

	.flip-container, .front, .back {
		width: 100px;
		height: 30px;
	}

	/* flip speed goes here */
	.flipper {
		transition: 1s;
		transform-style: preserve-3d;

		position: relative;
	}

	/* hide back of pane during swap */
	.front, .back {
		backface-visibility: hidden;

		position: absolute;
		top: 0;
		left: 0;
	}

	/* front pane, placed above back */
	.front {
		z-index: 2;
		transform: rotateY(0deg);
	}

	/* back, initially hidden pane */
	.back {
		transform: rotateY(180deg);
	}
	</style>
        <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.5/css/bootstrap.min.css" >
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
	
	<div class="flip-container" ontouchstart="this.classList.toggle('hover');">
		<div class="flipper">
			<div class="front">
				Visits: <strong>${hitCounter}</strong>
			</div>
			<div class="back">
				Users online: <strong id="onlineUsers">0</strong>
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
