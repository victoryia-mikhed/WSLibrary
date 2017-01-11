<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title><spring:message code="error"/></title>
    <link rel="stylesheet" href="<spring:url value="/resources/css/style.css"/>">
    <link rel="stylesheet" href="<spring:url value="/resources/css/bootstrap.min.css"/>">
    <script src="<spring:url value="/resources/js/jquery-1.11.3.js"/>"></script>
    <script src="<spring:url value="/resources/js/bootstrap.min.js"/>"></script>
</head>
<body>
<div class="wrapper">
    <spring:url value="/main" var="urlMain"/>

    <h1><spring:message code="error"/></h1>

</div>

<footer>
    <h6 class="copyright"><spring:message code="footer.copyright"/></h6>
    <p class="footerText"><spring:message code="footer.text"/></p>
</footer>

</body>
</html>