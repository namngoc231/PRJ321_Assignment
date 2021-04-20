<%-- 
    Document   : admin
    Created on : Nov 16, 2020, 7:02:49 PM
    Author     : Nam Ngoc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="components/head.jsp" />
    <body>
        <div class="page-wrapper admin-page">
            <div class="container">
                <div class="row">
                    <a class="btn btn-primary" href="create"><i class="fas fa-plus">Add Product</i></a>
                    <div class="col-lg-12">
                        <div class="d-flex">
                            <span class="justify-content-start w-100">There is ${requestScope.totalCats} cats.</span>
                            <ul class="pagination justify-content-end"></ul>    
                        </div>
                    </div>
                    <div class="col-lg-12">
                        <div class="row">
                            <table class="table">
                                <thead class="thead-dark">
                                    <tr>
                                        <th scope="col">ID</th>
                                        <th scope="col">Name</th>
                                        <th scope="col">Category</th>
                                        <th scope="col">Price</th>
                                        <th scope="col">Actions</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${requestScope.products}" var="p">
                                        <tr>
                                            <th scope="row">${p.id}</th>
                                            <td>
                                                <div class="media">
                                                    <div class="d-flex">
                                                        <img src="${p.thumbnail}"/>
                                                    </div>
                                                    <div class="media-body">
                                                        <p>${p.name}</p>
                                                    </div>
                                                </div>
                                            </td>
                                            <td>${p.category.name}</td>
                                            <td>$${p.price}</td>
                                            <td>
                                                <a href="update?id=${p.id}" class="btn btn-warning"><i class="fas fa-pen"></i> Update</a>
                                                <a href="delete?id=${p.id}" class="btn btn-danger"><i class="far fa-trash-alt"></i> Delete</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <ul class="pagination justify-content-end"></ul>                   
            </div>
        </div>
        <jsp:include page="components/js.jsp" />
        <script src="assets/js/pagger.js"></script>
        <script>paggerBasic('pagination', ${requestScope.pageIndex}, ${requestScope.totalPages}, 2);</script>
    </body>
</html>
