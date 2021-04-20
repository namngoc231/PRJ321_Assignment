<%-- 
    Document   : login
    Created on : Nov 5, 2020, 11:07:58 AM
    Author     : Nam Ngoc
--%>

<%@page import="model.User"%>
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
                            <h3>Login now!</h3>
                           
                            <form action="login" method="post">
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Username</label>
                                    <input type="text" name="username" class="form-control" placeholder="Enter Username" required />
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Password</label>
                                    <input type="password" name="password" class="form-control" placeholder="Enter Password" required />
                                </div>
                                <div class="form-group form-check">
                                    <input type="checkbox" name="remember" value="remember" class="form-check-input" id="exampleCheck1">
                                    <label class="form-check-label" for="exampleCheck1">Remember me</label>
                                </div>
                                <c:if test="${requestScope.errorMsg ne null}">
                                    <div class="form-group">
                                        <label for="error" class="text-danger">${requestScope.errorMsg}</label>
                                    </div>
                                </c:if>
                                <button type="submit" class="btn btn-primary"><i class="fas fa-sign-in-alt"></i> Login</button>
                                <a class="btn btn-success" href="register"><i class="fas fa-user-plus"></i> Register</a>
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
