<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
	<c:if test="${sales.size() ne 0}">
		<section id="cart_items">
			<div class="container">
				<div class="breadcrumbs">
					<ol class="breadcrumb">
					  <li><a href="<c:url value="/home"/>">Home</a></li>
					  <li class="active">Shopping Cart</li>
					</ol>
				</div>
				<div class="table-responsive cart_info">
					<table class="table table-condensed">
						<thead>
							<tr class="cart_menu">
								<td class="image">Чай</td>
								<td class="description"></td>
								<td class="price">Цена</td>
								<td class="quantity">Количество</td>
								<td class="total">Всего</td>
								<td></td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${sales}" var="sale">
								<tr>
									<td class="cart_product">
										<a href="<c:url value="/tea-details/${sale.tea.idOfTea}"/>"><img src="<c:url value="/image/${sale.tea.idOfTea}"/>" alt=""></a>
									</td>
									<td class="cart_description">
										<h4><a href="">${sale.tea.nameOfTea}</a></h4>
									</td>
									<td class="cart_price">
										<p>${sale.tea.price} руб.</p>
									</td>
									<td class="cart_quantity">
										<div class="cart_quantity_button">
											<a class="cart_quantity_up" href="<c:url value="/cart/plus/${sale.tea.idOfTea}"/>"> + </a>
											<input class="cart_quantity_input" type="text" name="quantity" value="${sale.amount}" autocomplete="off" size="2">
											<c:if test="${sale.amount le 1}">
												<a onclick='return false;' class="cart_quantity_down" href="<c:url value="/cart/minus/${sale.tea.idOfTea}"/>"> - </a>
											</c:if>
											<c:if test="${sale.amount gt 1}">
												<a class="cart_quantity_down" href="<c:url value="/cart/minus/${sale.tea.idOfTea}"/>"> - </a>
											</c:if>
										</div>
									</td>
									<td class="cart_total">
										<p class="cart_total_price">${sale.amount * sale.tea.price} руб.</p>
									</td>
									<td class="cart_delete">
										<a class="cart_quantity_delete" href="<c:url value="/cart/remove/${sale.tea.idOfTea}"/> "><i class="fa fa-times"></i></a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</section> <!--/#cart_items-->

		<section id="do_action">
			<div class="container">

				<div class="row">

					<div class="col-sm-6">
						<div class="total_area">
							<ul>
								<li>Всего <span>${finalPrice} руб.</span></li>
							</ul>
								<a class="btn btn-default check_out" href="<c:url value="/checkout/view"/> ">Заказать</a>
						</div>
					</div>
				</div>
			</div>
		</section><!--/#do_action-->
	</c:if>
	<c:if test="${sales.size() eq 0}">
	<section class="empty_cart">
		<h3>В корзине отсутствуют товары</h3>
	</section>
	</c:if>
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