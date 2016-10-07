<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
    <head>
        <title>Lastest connections</title>
        <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.5/css/bootstrap.min.css" />
        <script type="text/javascript" src="webjars/jquery/2.1.4/jquery.min.js"></script>
    </head>
    <body>
        <div class="container">
            <h2>Welcome to UNIZAR Web Engineering's log page!</h2>           
            <!-- A panel showing a log with the latest 10 connections that are made to the web server. The latest connection is shown first -->
            <div class="panel panel-default">    
                <div class="panel-heading">Latest 10 connections</div>
                <div class="panel-body"> 
					<ul>
					<c:forEach items="${connectLogs}" var="item">
						<li>An user has connected at ${item}</li>
					</c:forEach>
					</ul>
                </div>
                <div class="panel-footer">
                	<a href="/">Back</a>
                </div> 
            </div>
        </div>
    </body>
</html>
