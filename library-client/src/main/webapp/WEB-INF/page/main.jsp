<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title><spring:message code="title.profile"/></title>
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

    <h1><spring:message code="title.profile"/></h1>

    <main class="main-content">
        <p>Reader id: ${reader.readerID}</p><br/>
        <p>Reader name: ${reader.name}</p><br/>
        <br/><br/>
        <h2>Taken books:</h2>
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th>Book id</th>
                    <th>Item id</th>
                    <th>Book Title</th>
                    <th>Author</th>
                    <th>Expire date</th>
                    <th>Return book</th>
                </tr>
            </thead>
            <c:forEach var="takenBook" items="${takenBooks}">
                <tr>
                    <td>${takenBook.itemInfo.book.bookID}</td>
                    <td>${takenBook.itemInfo.itemID}</td>
                    <td>${takenBook.itemInfo.book.title}</td>
                    <td>${takenBook.itemInfo.book.author}</td>
                    <td><fmt:formatDate value="${takenBook.returnDate}" pattern="dd MMM yyyy"/></td>
                    <td>
                        <form:form class="return-book" action="/books/return" method="POST"
                                   modelAttribute="itemInfo">
                            <input type="hidden" name="itemID" value="${takenBook.itemInfo.itemID}">
                            <input type="button" class="btn-return-book" value="Return"/>
                        </form:form>
                    </td>
                </tr>
            </c:forEach>
        </table><br/><br/>
    </main>
</div>

<footer>
    <h6 class="copyright"><spring:message code="footer.copyright"/></h6>
    <p class="footerText"><spring:message code="footer.text"/></p>
</footer>

</body>
</html>
