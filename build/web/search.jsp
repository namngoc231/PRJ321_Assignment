<%-- 
    Document   : search
    Created on : Nov 5, 2020, 2:54:26 PM
    Author     : Nam Ngoc
--%>

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
                    <div class="row">
                        <div class="col-lg-12">
                            <h1>Search Result for ${requestScope.keyword}:</h1>
                            <c:choose>
                                <c:when test="${not empty requestScope.cats}">
                                    <ul class="pagination"></ul>
                                    <div class="row">
                                        <c:forEach items="${requestScope.cats}" var="c">
                                            <div class="card col-lg-4 cat-single">
                                                <a href="product?id=${c.id}"><img class="card-img-top" src="${c.thumbnail}" alt=""></a>
                                                <div class="card-body bg-light">
                                                    <h5 class="card-title"><a href="product?id=${c.id}">${c.name}</a></h5>
                                                    <p class="card-text">$${c.price}</p>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                    <ul class="pagination"></ul>
                                </c:when>
                                <c:otherwise>
                                    <h1>Nothing matched with keywords</h1>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <jsp:include page="components/js.jsp" />
        <jsp:include page="components/footer.jsp" />
        <script src="assets/js/pagger.js" type="text/javascript"></script>
        <script>pagger('pagination', 'k', '${requestScope.keyword}', ${requestScope.pageIndex}, ${requestScope.totalPages}, 2);</script>
    </body>
</html>
