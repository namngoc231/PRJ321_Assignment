<%-- 
    Document   : register
    Created on : Nov 5, 2020, 11:16:07 AM
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
                    <div class="row d-flex justify-content-center">
                        <div class="col-lg-8">
                            <h3>Register now!</h3>
                            <form action="register" method="post">
                                <div class="form-group">
                                    <label for="username">Username:</label>
                                    <input type="text" class="form-control" placeholder="Enter Username" name="username" required />
                                </div>
                                <div class="form-group">
                                    <label for="password">Password:</label>
                                    <input type="password" class="form-control" placeholder="Enter Password" name="password" required />
                                </div>
                                <div class="form-group">
                                    <label for="name">Your Name:</label>
                                    <input type="text" class="form-control" placeholder="Enter Your Name" name="name" required />
                                </div>
                                <div class="form-group">
                                    <label for="address">Address:</label>
                                    <input type="text" class="form-control" placeholder="Enter Your Address" name="address" required />
                                </div>
                                <div class="form-group">
                                    <label for="email">Email:</label>
                                    <input type="email" class="form-control" placeholder="Enter Email" name="email" required />
                                </div>
                                <div class="form-group">
                                    <label for="phone">Phone number:</label>
                                    <input type="text" class="form-control" placeholder="Enter Phone Number" name="phone" required />
                                </div>
                                <c:if test="${requestScope.errorMsg ne null}">
                                    <div class="form-group">
                                        <label for="error" class="text-danger">${requestScope.errorMsg}</label>
                                    </div>
                                </c:if>
                                <button type="submit" class="btn btn-primary"><i class="fas fa-user-plus"></i> Register</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <jsp:include page="components/js.jsp" />
        <jsp:include page="components/footer.jsp" />
    </body>
</html>
