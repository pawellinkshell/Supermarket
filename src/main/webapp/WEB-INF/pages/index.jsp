<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!doctype html>
<html lang="en">
<head>
    <spring:url value="/resources/styles/css/supermarket.css" var="mainCss"/>

    <meta charset="UTF-8">
    <title>Supermarket Web Project</title>

    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">

    <link href="${mainCss}" rel="stylesheet"/>
    <script
            src="http://code.jquery.com/jquery-3.2.1.js"
            integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <style>
        .product_view .modal-dialog {
            max-width: 800px;
            width: 100%;
        }

        .pre-cost {
            text-decoration: line-through;
            color: #a5a5a5;
        }

        .space-ten {
            padding: 10px 0;
        }

    </style>
</head>
<body>

</body>
</html>
<html>
<body>

<%@include file="fragments/menu.jspf" %>
<div class="container" style="padding-top: 50px">
    <h1>Maven + Spring MVC </h1>
    <h2>Supermarket with Checkout mechanism Web Project Example</h2>
</div>

<c:if test="${currentPath == products}">
    <%@include file="products/products.jsp" %>
</c:if>

<c:if test="${currentPath == cart}">
    <%@include file="cart/cart.jsp" %>
</c:if>

</body>
</html>
