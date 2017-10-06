<%-- 
    Document   : editLocation
    Created on : Aug 16, 2017, 2:09:07 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <title>JSP Page</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"> 
    </head>
    <body>
       
        
         <div class="container">
             
              <h1>Edit Location</h1>
        
         <hr/>
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
                            <label for="txtAddress">address</label>
                            <input type="text" class="form-control" id="txtAddress">
                        </div>
                             <div class="form-group">
                            <label for="txtlatitude">latitude</label>
                            <input type="number" step="0.01" class="form-control" id="txtlatitude">
                        </div>
                             <div class="form-group">
                            <label for="txtlongitude">longitude</label>
                            <input type="number" step="0.01" class="form-control" id="txtlongitude">
                        </div>
                        
                            <button type="button" class="btn btn-primary" onclick="location.href= 'Location.jsp'" id="btnCreateLocation">Update Location</button>
                        
                    </form>
                    </div>  
         <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/appLocation.js"></script>
        
    </body>
</html>
