<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <title>SuperHero Page</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"> 
    </head>
    <body>
        <div class="container">
            <h1>Hero Academy</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" ><a href="${pageContext.request.contextPath}/jsp/Home.jsp">Home</a></li>
                    <li role="presentation" class="active" ><a href="${pageContext.request.contextPath}/jsp/SuperHero.jsp">SuperHero</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/jsp/Organization.jsp">Organization</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/jsp/Location.jsp">Location</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/jsp/Sighting.jsp">Sighting</a></li>
                   
                </ul>    
            </div>
            <h2>Hero's</h2>

            <hr/>

   <div id="heros">

  </div>

  <hr/>
            <div>
                <form class="form" onsubmit="return false;">
                    <div class="form-group">
                        <label for="txtName">Name</label>
                        <input type="text" class="form-control" id="txtName">
                    </div>
                    <div class="form-group">
                        <label for="txtDescription">Description</label>
                        <input type="text" class="form-control" id="txtDescription">
                    </div>
                    <div class="form-group">
                        <label for="txtPower">Power</label>
                        <input type="text" class="form-control" id="txtPower">
                    </div>

                    <button type="button" class="btn btn-primary" id="btnCreateLocation">Create SuperHero</button>

                    

            </form>
        </div>          


    </div>
    <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/appSuperHero.js"></script>
</body>
</html>
