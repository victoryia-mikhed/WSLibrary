<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title><spring:message code="title.login"/></title>
    <link rel="stylesheet" href="<spring:url value="/resources/css/style.css"/>">
    <link rel="stylesheet" href="<spring:url value="/resources/css/bootstrap.min.css"/>">
    <script src="<spring:url value="/resources/js/jquery-1.11.3.js"/>"></script>
    <script src="<spring:url value="/resources/js/bootstrap.min.js"/>"></script>
</head>
<body>
<div class="wrapper">
    <spring:url value="/main" var="urlMain"/>
    <spring:url value="/login" var="urlLogin"/>
    <header class="main-header">
        <a href="${urlMain}" class="logo"><span><spring:message code="title.library"/></span></a>
        <ul class="menu">
            <li><a href="${urlLogin}" class="link login-link"><spring:message code="title.login"/></a></li>
        </ul>
    </header>
    <h1><spring:message code="title.login"/></h1>

    <form class="form-login" name="login" method="POST" action="${pageContext.request.contextPath}/j_spring_security_check">
        <div class="input">
            <label for="inputLogin" id="login"><spring:message code="label.login"/>:</label>
            <input type="text" name="j_username" id="inputLogin" value="user1">
        </div>
        <div class="input">
            <label for="inputPassword" id="password"><spring:message code="label.password"/>:</label>
            <input type="password" name="j_password" id="inputPassword" value="pass1">
        </div>
        <button type="submit" id="submit"><spring:message code="button.login"/></button>
        <div class="error-msg">${error}</div>
        <div class="logout-success">${logout}</div>
    </form>
</div>

<footer>
    <h6 class="copyright"><spring:message code="footer.copyright"/></h6>
    <p class="footerText"><spring:message code="footer.text"/></p>
</footer>

</body>
</html>