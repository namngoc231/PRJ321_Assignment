<%-- 
    Document   : checkout
    Created on : Nov 7, 2020, 7:05:51 PM
    Author     : Nam Ngoc
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="components/head.jsp" />
    <body>
        <jsp:include page="components/header.jsp" />
        <main>
            <div class="page-wrapper">
                <div class="container">
                    <h1>Order Success</h1> <br/>
                    <h1>Thank you for choosing Our Pet Store</h1> 
                    <br/>
                    <br/>
                    <form method="POST" action="checkout">
                        <button class="btn btn-success" type="submit">Return Home</button>
                    </form>
                </div>
            </div>
        </main>
        <jsp:include page="components/js.jsp" />
        <jsp:include page="components/footer.jsp" />
    </body>
</html>
