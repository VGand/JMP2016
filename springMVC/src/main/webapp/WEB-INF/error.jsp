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
        <span class="user-header">View user error</span>
        <div class=error-message>
            <c:if test="${not empty errorMessage}">
                <span>${errorMessage}</span>
            </c:if>
        </div>
        <a href="<c:url value='/user/'/>" class="golist-button">GoToList</a>
    </div>
</body>
</html>