<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <title>Edit SuperHero</title>
         <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"> 
    </head>
    <body>
        <h1>Edit Hero</h1>
        
          <div>
<!--              
              <sf:form method="post" action="EditHero" modelAttribute="hero">
                Name: <sf:input type="text" path="name"/><br/>
                Description: <sf:input type="text" path="description"/><br/>
                Power: <sf:input type="text" path="power"/><br/>
                
                <sf:button type="submit">save</sf:button>
            </sf:form>-->
              
              
              
              
              
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
                        
                         <button type="button" class="btn btn-primary" id="updateHero">Update Hero</button>
                        
                    </form>
                    </div>     
        
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/app.js"></script>
    </body>
</html>
