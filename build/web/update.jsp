<%-- 
    Document   : update
    Created on : Nov 17, 2020, 10:46:34 AM
    Author     : Nam Ngoc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="components/head.jsp" />
    <body>
        <div class="page-wrapper">
            <div class="container">
                <div class="row">
                    <form action="update" method="post" class="w-100">
                        <input type="hidden" value="${param.id}" name="id"/>
                        <div class="form-group">
                            <label for="name">Name:</label>
                            <input type="text" name="name" class="form-control" value="${cat.name}" required />
                        </div>
                        <div class="form-group">
                            <label for="price">Price:</label>
                            <input type="text" name="price" class="form-control" value="${cat.price}" required />
                        </div>
                        <div class="form-group">
                            <label for="image">Image URL: </label>
                            <input type="text" name="image" class="form-control" value="${cat.thumbnail}" required />
                        </div>
                        <div class="form-group">
                            <label for="shortDesc">Short Description:</label>
                            <textarea name="shortDesc" class="form-control" required>${cat.shortDesc}</textarea>
                        </div>
                        <div class="form-group">
                            <label for="desc">Description:</label>
                            <textarea name="desc" class="form-control" required>${cat.desc}</textarea>
                        </div>
                        <div class="form-group">
                            <label for="category">Category:</label>
                            <select name="category" class="custom-select">
                                <c:forEach items="${requestScope.categories}" var="c">
                                    <option value="${c.id}"
                                            <c:if test="${cat.category.id eq c.id}">selected</c:if>>${c.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <button class="btn btn-primary" type="submit">Update</button>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="components/js.jsp" />
    </body>
</html>
