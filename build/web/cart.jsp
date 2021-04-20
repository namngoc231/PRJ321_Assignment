<%-- 
    Document   : cart
    Created on : Nov 7, 2020, 5:13:29 PM
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
            
            <div class="page-wrapper d-flex justify-content-center">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1><i class="fas fa-shopping-cart"></i> Your Cart</h1>
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th scope="col">Order</th>
                                        <th scope="col">Name</th>
                                        <th scope="col">Quantity</th>
                                        <th scope="col">Price</th>
                                        <th scope="col">Total</th>
                                        <th scope="col">Remove</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:choose>
                                        <c:when test="${not empty sessionScope.user.catList}">
                                            <c:set var = "subTotal" value = "${0}"/>
                                            <c:forEach items="${sessionScope.user.catList}" var="c" varStatus="i">
                                                <tr>
                                                    <th scope="row">${i.count}</th>
                                                    <td>${c.name}</td>
                                                    <td><input type="number" value="${c.quantity}" /></td>
                                                    <td>${c.price}</td>
                                                    <td><fmt:formatNumber value="${c.price * c.quantity}" type="number" maxFractionDigits="3" /></td>
                                                    <td><a href="?removeId=${c.id}" class="btn btn-danger"><i class="fas fa-trash"></i></a></td>
                                                        <c:set var="subTotal" value="${subTotal + c.price * c.quantity}" />
                                                </tr>
                                            </c:forEach>
                                            <tr>
                                                <th scope="row">Sub Total:</th>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td><fmt:formatNumber value="${subTotal}" type="number" maxFractionDigits="3" /></td>
                                            </tr>
                                        </c:when>
                                        <c:otherwise>
                                            <tr><td></td>                                        
                                                <td></td>
                                                <td>Your Cart is Empty!</td>
                                                <td></td>
                                                <td></td>
                                            </tr>
                                        </c:otherwise>
                                    </c:choose>
                                </tbody>
                            </table>
                            <c:if test="${sessionScope.user ne null}">
                                <div class="d-flex justify-content-end">
                                    <a href="store" class="btn btn-primary mr-sm-2">Continue Shopping</a>
                                    <c:if test="${not empty sessionScope.user.catList}">
                                        <a href="checkout.jsp" class="btn btn-danger">Check Out</a>
                                    </c:if>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <jsp:include page="components/js.jsp" />
        <jsp:include page="components/footer.jsp" />
    </body>
</html>
