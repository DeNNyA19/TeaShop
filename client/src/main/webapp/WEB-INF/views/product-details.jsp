<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Product Details | E-Shopper</title>
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
		<jsp:include page="/WEB-INF/views/template/search_form.jsp"/>
	</header>
	<section>
		<div class="container">
			<div class="row">
				<jsp:include page="/WEB-INF/views/template/left_menu.jsp"/>
				<div class="col-sm-9 padding-right">
					<div class="product-details"><!--product-details-->
						<div class="col-sm-5">
							<div class="view-product">
								<img src="<c:url value="/image/${tea.idOfTea}"/>" alt="" />
							</div>

						</div>
						<div class="col-sm-7">
							<div class="product-information"><!--/product-information-->
								<h2>${tea.nameOfTea}</h2>
								<span>
									<span>${tea.price} руб. </span>
									<form action="<c:url value="/cart/addAmount"/>" method="post">
										<label>Quantity:</label>
										<input type="hidden" name="id" value="${tea.idOfTea}">
										<input type="hidden" name="url" value="${requestScope['javax.servlet.forward.request_uri']}">
										<input name="amount" type="text" value="1">
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
										<button class="btn btn-fefault cart" type="submit">

											Add to cart
										</button>
									</form>
								</span>
								<p><b>Тип:</b> ${tea.type.nameOfType}</p>
								<p><b>Страна происхождения:</b> ${tea.country.nameOfCountry}</p>
							</div><!--/product-information-->
						</div>
					</div><!--/product-details-->
					

					<div class="recommended_items"><!--recommended_items-->
						<h2 class="title text-center">recommended items</h2>
						<div id="recommended-item-carousel" class="carousel slide" data-ride="carousel">
							<div class="carousel-inner">
								<div class="item active">
									<c:forEach items="${recommendedTeas1}" var="tea">
										<a href="<c:url value="/tea-details/${tea.idOfTea}"/>">
											<div class="col-sm-4">
												<div class="product-image-wrapper">
													<div class="single-products">
														<div class="productinfo text-center">
															<img src="/image/${tea.idOfTea}" alt="" />
															<h2>${tea.price} руб.</h2>
															<p>${tea.nameOfTea}</p>
															<form action="<c:url value="${pageContext.request.contextPath}/cart/add"/>" method="post">
																<input type="hidden" name="id" value="${tea.idOfTea}">
																<input type="hidden" name="url" value="${requestScope['javax.servlet.forward.request_uri']}">
																<button class="btn btn-default add-to-cart" type="submit">Добавить в корзину</button>
															</form>
														</div>
													</div>
												</div>
											</div>
										</a>
									</c:forEach>
								</div>
								<div class="item">
									<c:forEach items="${recommendedTeas2}" var="tea">
										<a href="<c:url value="/tea-details/${tea.idOfTea}"/>">
											<div class="col-sm-4">
												<div class="product-image-wrapper">
													<div class="single-products">
														<div class="productinfo text-center">
															<img src="/image/${tea.idOfTea}" alt="" />
															<h2>${tea.price} руб.</h2>
															<p>${tea.nameOfTea}</p>
															<form action="<c:url value="${pageContext.request.contextPath}/cart/add"/>" method="post">
																<input type="hidden" name="id" value="${tea.idOfTea}">
																<input type="hidden" name="url" value="${requestScope['javax.servlet.forward.request_uri']}">
																<button class="btn btn-default add-to-cart" type="submit">Добавить в корзину</button>
															</form>
														</div>
													</div>
												</div>
											</div>
										</a>
									</c:forEach>
								</div>
							</div>
							 <a class="left recommended-item-control" href="#recommended-item-carousel" data-slide="prev">
								<i class="fa fa-angle-left"></i>
							  </a>
							  <a class="right recommended-item-control" href="#recommended-item-carousel" data-slide="next">
								<i class="fa fa-angle-right"></i>
							  </a>			
						</div>
					</div><!--/recommended_items-->
					
				</div>
			</div>
		</div>
	</section>
	<footer id="footer"><!--Footer-->
		<jsp:include page="/WEB-INF/views/template/footer.jsp"/>
	</footer><!--/Footer-->


	<script>
        <%@include file="/resources/js/price-range.js" %>
	</script>
	<script src="<c:url value="/resources/js/jquery.js"/>" type="text/javascript"></script>
	<script src="<c:url value="${pageContext.request.contextPath}/resources/js/price-range.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/jquery.scrollUp.min.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/jquery.prettyPhoto.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/main.js"/>" type="text/javascript"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/price-range.js"></script>
</body>
</html>