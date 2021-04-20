<%-- 
    Document   : store
    Created on : Nov 5, 2020, 10:37:32 AM
    Author     : Nam Ngoc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Cat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Category"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="components/head.jsp" />
    <body>
        <jsp:include page="components/header.jsp" />
        <main>
            <div class="page-wrapper">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3">
                            <ul class="list-group">
                                <li class="list-group-item"><span class="text-uppercase">Product Categories</span></li>
                                    <c:forEach items="${requestScope.categories}" var="c">
                                        <li class="list-group-item"><a href="?cid=${c.id}">${c.name}</a></li>
                                    </c:forEach>
                            </ul>
                        </div>
                        <div class="col-lg-9">
                            <h3>${requestScope.totalRecords} Product(s) Found</h3>
                            <c:if test="${not empty requestScope.cats}">
                                <ul class="pagination"></ul>
                                <div class="row">
                                    <c:forEach items="${requestScope.cats}" var="c">
                                        <div class="card col-lg-4 cat-single">
                                            <a href="product?id=${c.id}"><img class="card-img-top" src="${c.thumbnail}"></a>
                                            <div class="card-body bg-light">
                                                <h3 class="card-title"><a href="product?id=${c.id}">${c.name}</a></h3>
                                                <p class="card-text">$${c.price}</p>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                                <ul class="pagination"></ul>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <jsp:include page="components/js.jsp" />
        <jsp:include page="components/footer.jsp" />
        <script src="assets/js/pagger.js"></script>
        <c:choose>
            <c:when test="${not empty requestScope.cateid}">
                <script>pagger('pagination', 'cid', ${requestScope.cateid}, ${requestScope.pageIndex}, ${requestScope.totalPages}, 2);</script>
            </c:when>
            <c:otherwise>
                <script>paggerBasic('pagination', ${requestScope.pageIndex}, ${requestScope.totalPages}, 2);</script>
            </c:otherwise>
        </c:choose>
    </body>
</html>
