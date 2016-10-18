<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Hello world</title>
        <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.5/css/bootstrap.min.css" />
        <script type="text/javascript" src="webjars/jquery/2.1.4/jquery.min.js"></script>
    </head>
    <body>
        <div class="container">
            <h2>UNIZAR Web Engineering's Students List!</h2>
            <div class="panel panel-default">
                <div class="panel-heading">This page has been visited by:</div>
                <div class="panel-body">${listUsers}</div>
            </div>
            <form  action="http://localhost:8080/">
            	<input type="submit" value="Add other User"/>
            </form> 
        </div>
    </body>
</html>
