<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title><spring:message code="title.book"/></title>
    <link rel="stylesheet" href="<spring:url value="/resources/css/style.css"/>">
    <link rel="stylesheet" href="<spring:url value="/resources/css/bootstrap.min.css"/>">
    <script src="<spring:url value="/resources/js/jquery-1.11.3.js"/>"></script>
    <script src="<spring:url value="/resources/js/bootstrap.min.js"/>"></script>
</head>
<body>
<div class="wrapper">
    <spring:url value="/main" var="urlMain"/>
    <spring:url value="/library" var="urlLibrary"/>
    <spring:url value="/main" var="urlProfile"/>
    <spring:url value="/j_spring_security_logout" var="urlLogout"/>

    <header class="main-header">
        <a href="${urlMain}" class="logo"><span><spring:message code="title.library"/></span></a>
        <ul class="menu">
            <li><a href="${urlLibrary}" class="link"><spring:message code="menu.library"/></a></li>
            <li><a href="${urlProfile}" class="link"><spring:message code="menu.profile"/></a></li>
            <li><a href="${urlLogout}" class="link"><spring:message code="menu.logout"/></a></li>
        </ul>
    </header>

    <h1>${book.title}</h1>

    <main class="main-content">

        <h3>Title: ${book.title}</h3>
        <h4>Author: ${book.author}</h4>
        <h4>Book id: ${book.bookID}</h4>
        <h4>Count books: ${countItems}</h4>
        <p>Description: book description (skipped)</p>
        <br/>
        <c:if test="${countItems > 0}">
            <form:form class="take-book" action="/books/take" method="POST"
                       modelAttribute="book">
                <input type="hidden" name="bookID" value="${book.bookID}">
                <input type="button" class="btn-take-book" value="Take"/>
            </form:form>
        </c:if>
        <br/><br/>
    </main>
</div>

<footer>
    <h6 class="copyright"><spring:message code="footer.copyright"/></h6>
    <p class="footerText"><spring:message code="footer.text"/></p>
</footer>

</body>
</html>
