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
    <title>Интернет-магазин чая</title> 
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
					<div class="features_items"><!--features_items-->
						<c:forEach items="${teas}" var="tea">
							<div class="col-sm-4">
								<div class="product-image-wrapper">
									<div class="single-products">
										<div class="productinfo text-center">
											<a href="<c:url value="/tea-details/${tea.idOfTea}"/> ">
											<img src="<c:url value="/image/${tea.idOfTea}"/>" alt="" />
											<h2>${tea.nameOfTea}</h2>
												<p>Цена: ${tea.price} руб.</p>
											<p>Страна происхождения: ${tea.country.nameOfCountry}</p>
											<p>Тип чая: ${tea.type.nameOfType}</p>
											</a>
											<form action="<c:url value="${pageContext.request.contextPath}/cart/add"/>" method="post">
												<input type="hidden" name="id" value="${tea.idOfTea}">
												<input type="hidden" name="url" value="${requestScope['javax.servlet.forward.request_uri']}">
												<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
												<button class="btn btn-default add-to-cart" type="submit">Добавить в корзину</button>
											</form>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>

					</div><!--features_items-->
					<ul class="pagination">
						<c:forEach begin="1" end="${amountOfPages}" var="i">
							<c:if test="${searchValue eq null}">
								<c:if test="${i eq openedPage}">
									<li onclick='return false;' class="active"><a href="<c:url value="/${url}${i}"/>">${i}</a></li>
								</c:if>
								<c:if test="${i ne openedPage}">
									<li><a href="<c:url value="${url}${i}"/>">${i}</a></li>
								</c:if>
							</c:if>
							<c:if test="${searchValue ne null}">
								<c:if test="${i eq openedPage}">
									<li onclick='return false;' class="active"><a href="<c:url value="/${url}${searchValue}/${i}"/>">${i}</a></li>
								</c:if>
								<c:if test="${i ne openedPage}">
									<li><a href="<c:url value="${url}${searchValue}/${i}"/>">${i}</a></li>
								</c:if>
							</c:if>
						</c:forEach>
					</ul>
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