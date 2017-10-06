<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Index Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <body>
        <div class="container">
            <h1>Hero Academy</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                     <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/jsp/Home.jsp">Home</a></li>
                     <li role="presentation" ><a href="${pageContext.request.contextPath}/jsp/SuperHero.jsp">SuperHero</a></li>
                	<li role="presentation"><a href="${pageContext.request.contextPath}/jsp/Organization.jsp">Organization</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/jsp/Location.jsp">Location</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/jsp/Sighting.jsp">Sighting</a></li>
                       
                </ul>    
            </div>
                        
                             
                   <h2>Most Recent Sighting</h2>
                    
                    <hr/>
                    
                    <div id="recentSightings">
                        
                    </div>
              
            
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/appHome.js"></script>
        

    </body>
</html>

