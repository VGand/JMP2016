<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Getting Started: Serving Web Content</title>
</head>
<body>
    <div class="main-panel">
        <form:form method="post" modelAttribute="user" class="create-user">
            <span class="user-header">View user info</span>
            <table class="view-table">
                <tr>
                    <td>First name</td>
                    <td>
                        <form:input type="text" id="firstName" path="firstName" value="${user.firstName}" />
                        <br>
                        <form:errors path="firstName" class="error-message"/>
                    </td>
                </tr>
                <tr>
                    <td>Last name</td>
                    <td>
                        <form:input type="text" id="lastName" path="lastName" value="${user.lastName}"/>
                        <br>
                        <form:errors path="lastName" class="error-message"/>
                    </td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td>
                        <form:input type="text" id="email" path="email" value="${user.email}"/>
                        <br>
                        <form:errors path="email" class="error-message"/>
                    </td>
                </tr>
                <tr>
                    <td>Login</td>
                    <td>
                        <form:input type="text" id="login" path="login" value="${user.login}"/>
                        <br>
                        <form:errors path="login" class="error-message"/>
                    </td>
                </tr>
                <tr>
                    <td>Birthday</td>
                    <td>
                        <fmt:formatDate pattern="dd-MM-yyyy" value="${birthDay}" var="fmtBirthDay"/>
                        <form:input type="text" id="birthDay" path="birthDay" value="${fmtBirthDay}"/>
                        <br>
                        <form:errors path="birthDay" class="error-message"/>
                    </td>
                </tr>
            </table>
            <c:choose>
                <c:when test="${empty id}">
                    <input type="submit" value="Create" />
                </c:when>
                <c:otherwise>
                    <input type="submit" value="Update" />
                </c:otherwise>
            </c:choose>
        </form:form>
    </div>
</body>
</html>