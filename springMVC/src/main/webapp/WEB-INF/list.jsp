<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Getting Started: Serving Web Content</title>
</head>
<body>
    <form:form id="loginForm" method="post" action="search" modelAttribute="searchBean">
        <form:label path="searchString">Enter search string</form:label>
        <form:input id="searchString" name="searchString" path="searchString" /><br>
        <input type="submit" value="Search" />
    </form:form>

    <c:if test="${not empty userList}">

    		<ul>
    			<c:forEach var="user" items="${userList}">
    				<li>${user.firstName}</li>
    			</c:forEach>
    		</ul>

    	</c:if>
</body>
</html>