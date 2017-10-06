<%-- 
    Document   : editSighting
    Created on : Aug 16, 2017, 2:09:31 PM
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
        <h1>Edit Sighting</h1>
        
         <hr/>
                    <div>
                        <form class="form" onsubmit="return false;">
                        <div class="form-group">
                            <label for="txtName">SuperHero Sighted</label>
                            <div id="herosNames">
                                
                            </div>
                            
                           
                        </div>
                            
                        <div class="form-group">
                            <label for="txtLocation">Location</label>
                            <div id="Loc">
                                
                            </div>
                        </div>
                            
                            
                        <div class="form-group">
                            <label for="txtDate">Date</label>
                            <input type="date" class="form-control" id="txtDate">
                        </div>
                        
                      
                   
                         <button type="button" class="btn btn-primary" id="btnCreateSighting">Update Sighting</button>
                        
                    </form>
                    </div> 
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>         
        <script src="${pageContext.request.contextPath}/js/appSuperHero.js"></script>
        
    </body>
</html>
