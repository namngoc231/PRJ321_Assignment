<%-- 
    Document   : navigation
    Created on : Nov 5, 2020, 10:18:58 AM
    Author     : Nam Ngoc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top">
        <a class="navbar-brand" href="index"><img src="assets/img/logo.png" alt=""/> Cat Store</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="index"><i class="fas fa-home"></i> Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="store"><i class="fas fa-store"></i> Store</a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0" action="search" method="GET">
                <input class="form-control mr-sm-2" name="k" type="search" placeholder="Search" aria-label="Search" required />
                <button class="btn btn-success my-2 my-sm-0" type="submit"><i class="fas fa-search"></i> Search</button>
            </form>
            <c:choose>
                <c:when test="${sessionScope.user ne null}">
                    <div class="ml-sm-2 btn-group" role="group">
                        <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="false">
                            <i class="far fa-user"></i> ${sessionScope.user.fullName}
                        </button>
                        <div class="dropdown-menu" aria-labelledby="">
                            <c:if test="${sessionScope.user.admin}">
                                <a class="dropdown-item" href="admin"><i class="fas fa-user-shield"></i> Admin</a>
                            </c:if>
                            <a class="dropdown-item" href="cart"><i class="fas fa-shopping-cart"></i> Your Cart</a>
                            <a class="dropdown-item" href="logout"><i class="fas fa-sign-out-alt"></i> Log out!</a>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <a class="btn btn-danger ml-sm-2" href="login"><i class="fas fa-sign-in-alt"></i> Login</a>
                    <a class="btn btn-light ml-sm-2" href="register"><i class="fas fa-user-plus"></i> Register</a>
                </c:otherwise>
            </c:choose>
        </div>
    </nav>
</header>