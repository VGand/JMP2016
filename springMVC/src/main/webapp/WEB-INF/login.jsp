<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Getting Started: Serving Web Content</title>
</head>
<body>
    <form:form id="loginForm" method="post" action="login" modelAttribute="loginBean">
        <table>
            <tr>
                <td><form:label path="username">Enter your user-name</form:label></td>
                <td><form:input id="username" name="username" path="username" /><br></td>
            </tr>
            <tr>
                <td><form:label path="username">Please enter your password</form:label></td>
                <td><form:password id="password" name="password" path="password" /><br></td>
            </tr>
            <tr>
                <div class=error-message>
                    <c:if test="${not empty loginError}">
                        <span>${loginError}</span>
                    </c:if>
                </div>
            </tr>
        </table>
        <input type="submit" value="Submit" />
    </form:form>
</body>
</html>