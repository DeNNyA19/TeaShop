<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Refresh" content="2; url=http://localhost:8080/" />
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Cart | E-Shopper</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/css/prettyPhoto.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/css/price-range.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/css/animate.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/css/responsive.css"/>" rel="stylesheet" type="text/css">
    <script>
        <%@include file="/resources/js/price-range.js" %>
    </script>
    <style>
        <%@include file="/resources/css/bootstrap.min.css" %>
        <%@include file="/resources/css/font-awesome.min.css" %>
        <%@include file="/resources/css/prettyPhoto.css" %>
        <%@include file="/resources/css/price-range.css" %>
        <%@include file="/resources/css/animate.css" %>
        <%@include file="/resources/css/main.css" %>
        <%@include file="/resources/css/responsive.css" %>
    </style>
</head><!--/head-->

<body>

    <section class="empty_cart">
        <h3>Поздравляем! Заказ успешно выполнен. Вы будете перенаправлены на главную страницу через несколько секунд.</h3>
    </section>




<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.scrollUp.min.js"></script>
<script src="js/jquery.prettyPhoto.js"></script>
<script src="js/main.js"></script>
</body>
</html>
