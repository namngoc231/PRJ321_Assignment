<%-- 
    Document   : product
    Created on : Nov 5, 2020, 3:30:19 PM
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
                        <div class="col-lg-6">
                            <img src="${requestScope.cat.thumbnail}" class="w-100">
                        </div>
                        <div class="col-lg-6">
                            <h1>${requestScope.cat.name}</h1>
                            <h3>$${requestScope.cat.price}</h3>
                            <h4>Category: ${requestScope.cat.category.name}</h4>
                            <p>${requestScope.cat.shortDesc}</p>
                            <form method="post" action="product?id=${requestScope.cat.id}">
                                <div class="form-group">
                                    <label for="quantity">Quantity: </label>
                                    <input type="number" value="1" min="1" name="quantity" />
                                </div>
                                <c:choose>
                                    <c:when test="${sessionScope.user eq null}">
                                        <a class="btn btn-success" href="login"><i class="fas fa-cart-plus"></i> Add To Cart</a>
                                    </c:when>
                                    <c:otherwise>
                                        <button class="btn btn-success" type="submit"><i class="fas fa-cart-plus"></i> Add To Cart</button>
                                    </c:otherwise>
                                </c:choose>
                            </form>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <h1>Product Description</h1>
                            ${requestScope.cat.desc}
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <jsp:include page="components/js.jsp" />
        <jsp:include page="components/footer.jsp" />
    </body>
</html>
