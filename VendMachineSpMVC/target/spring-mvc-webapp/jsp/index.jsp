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
        <title>Vending Machine</title>
        <link href="css/bootstrap.css" rel="stylesheet">
        <style>
            form{
                display:inline-block;
                text-align: center;
            }
            button{
                margin: 10px;
            }
            #items{
                margin:10px;
            }

        </style>
    </head>
<body>
    <h1>Vending Machine</h1>
    <hr/>
    <div class="container">

        <div class="col-md-9 col-md-70" >

            <c:forEach items="${VItems}" var="currentItem">
                <div class="col-md-4  theItem" > 
                    <form  method="get" action="getItem">
                        <button Type="submit" name="name" value="${currentItem.name}">
                            <span><c:out value="${currentItem.name}"/></span>
                            <span><c:out value="${currentItem.inventory}"/></span>
                            <span><c:out value="${currentItem.cost}"/></span>
                        </button>
                    </form>
                </div>
            </c:forEach>



        </div>
        <div class="col-md-3 col-md-30">

            <h2>Total $ In</h2>

            <input id="money-display" type="number" value="${totalMoney}" readonly></br>


            <div class="btn-group">


                <form method="get" action="addQuarters">
                    <button type="submit" id="add-quarter" >
                        Add Quarter
                    </button>
                </form>

                <form method="get" action="addDimes">
                    <button type="submit" id="add-dime" >
                        Add Dime
                    </button>
                </form>
                </br>

                <form method="get" action="addNickels">
                    <button type="submit" id="add-nickel" >
                        Add Nickel
                    </button>
                </form>
                <form method="get" action="addPennies">
                    <button type="submit" id="add-pennies" >
                        Add Pennies
                    </button>
                </form>
            </div>



            <hr/>



            <h2>Messages</h2>
            <input id="message-display" value="${Message}"  type="text" readonly></br>
            Item:
            <input id="item-display" value="${selectedItem}" type="text" readonly></br>

            <form method="get" action="makePurchase" >

                <button type="submit" id="make-purchase">
                    Make Purchase
                </button> 

            </form>

            <hr/>



            <h2>Change</h2>
            <input id="change-display" value="${correctChange}"  type="text" readonly></br>

            <form method="get" action="returnChange"  >
                <button type="submit" id="change-return">
                    Change Return
                </button>

            </form>


        </div>
    </div>
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</body>
</html>