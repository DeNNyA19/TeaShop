<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
<header id="header"><!--header-->
    <jsp:include page="/WEB-INF/views/template/header.jsp"/>
</header><!--/header-->
    <table style="width: 100%; ">
        <caption><h3 style="color:orange">Таблица заказов</h3></caption>
        <tr>
            <th>Номер заказа</th>
            <th>Дата заказа</th>
            <th>Цена</th>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Телефон</th>
            <th>Email</th>
            <th>Статус</th>
            <th>Изменить статус</th>
            <th>Применить</th>
        </tr>
        <c:forEach items="${orders}" var="order">
            <tr>
                <td>${order.idOfOrder}</td>
                <td>${order.date}</td>
                <td>${order.finalPrice}</td>
                <td>${order.name}</td>
                <td>${order.surname}</td>
                <td>${order.phone}</td>
                <td>${order.email}</td>
                <td>${order.status}</td>
                <form action="<c:url value="/orders/changeStatus"/>" method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <input type="hidden" name="id" value="${order.idOfOrder}"/>
                    <td>
                        <select name="changedStatus">
                            <c:forEach items="${statuses}" var="statusEnum">
                                <option>${statusEnum.status}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td><button type="submit" class="btn btn-primary">Изменить статус</button></td>
                </form>

            </tr>
        </c:forEach>
    </table>
<footer id="footer"><!--Footer-->
    <jsp:include page="/WEB-INF/views/template/footer.jsp"/>
</footer><!--/Footer-->



<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.scrollUp.min.js"></script>
<script src="js/jquery.prettyPhoto.js"></script>
<script src="js/main.js"></script>
</body>
</html>