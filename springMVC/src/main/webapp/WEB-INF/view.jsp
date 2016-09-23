<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Getting Started: Serving Web Content</title>
</head>
<body>
    <div class="main-panel">
        <span class="user-header">View user info</span>
        <table class="view-table">
            <tr>
                <td>First name</td>
                <td>${user.firstName}</td>
            </tr>
            <tr>
                <td>Last name</td>
                <td>${user.lastName}</td>
            </tr>
            <tr>
                <td>Email</td>
                <td>${user.email}</td>
            </tr>
            <tr>
                <td>Login</td>
                <td>${user.login}</td>
            </tr>
            <tr>
                <td>Birthday</td>
                <td><fmt:formatDate pattern="dd-MM-yyyy" value="${user.birthDay}"/></td>
            </tr>
        </table>
        <br>
        <br>
        <a href="<c:url value='/user/edit/${user.id}'/>" class="edit-button">Edit</a>
        <a href="<c:url value='/user/'/>" class="golist-button">GoToList</a>
    </div>
</body>
</html>