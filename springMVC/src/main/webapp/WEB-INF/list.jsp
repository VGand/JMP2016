<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>User service, list of users</title>
    </head>
    <body>
        <div class="main-panel">
            <span class="user-header"> List of users</span>
            <div class="search-panel">
                <form:form id="loginForm" method="post" action="search" modelAttribute="searchBean">
                    <form:label path="searchString">Enter search string</form:label>
                    <form:input id="searchString" name="searchString" path="searchString" /><br>
                    <input type="submit" value="Search" />
                </form:form>
            </div>

            <div class="user-table-panel">
                <table class="user-table">
                    <thead>
                        <tr>
                            <th>First name</th>
                            <th>Last name</th>
                            <th>Email</th>
                            <th>Login</th>
                            <th>Birthday</th>
                            <th>Action<th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="user" items="${userList}">
                            <tr>
                                <td>${user.firstName}</td>
                                <td>${user.lastName}</td>
                                <td>${user.email}</td>
                                <td>${user.login}</td>
                                <td><fmt:formatDate pattern="dd-MM-yyyy" value="${user.birthDay}"/></td>
                                <td>
                                    <a href="<c:url value='/user/${user.id}'/>" class="view-button">View</a>
                                    <a href="<c:url value='/user/delete/${user.id}'/>" class="delete-button">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <br>
            <a href="<c:url value='/user/edit/'/>" class="create-button">Create new user</a>
        </div>
    </body>
</html>