<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Login | E-Shopper</title>
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
	
	<section id="form"><!--form-->
		<div class="container">
			<div class="row">

				<div class="col-sm-4 col-sm-offset-1">
					<h3>${registerMessage}</h3>
					<div class="login-form"><!--login form-->
						<h2>Войдите в свой кабинет пользователя</h2>
						<c:url var="loginUrl" value="/login" />
						<form action="${loginUrl}" method="post">
							<c:if test="${param.error != null}">
								<div class="alert alert-danger">
									<p>Invalid username and password.</p>
								</div>
							</c:if>
							<c:if test="${param.logout != null}">
								<div class="alert alert-success">
									<p>You have been logged out successfully.</p>
								</div>
							</c:if>
							<input type="text" name="ssoId" placeholder="Логин" required>
							<input type="password"  name="password" placeholder="Пароль" required>
							<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
							<input type="submit" class="btn btn-default" value="Войти">
						</form>
					</div><!--/login form-->
				</div>
				<div class="col-sm-1">
					<h2 class="or">ИЛИ</h2>
				</div>
				<div class="col-sm-4">
					<div class="signup-form"><!--sign up form-->
						<h2>Зарегистрируйтесь</h2>
						<springform:form commandName="userReg" action="/register" method="post">
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
							<springform:input path="username" placeholder="Логин"/>
							<springform:errors path="username" cssClass="error"/>
							<springform:input path="password" placeholder="Пароль"/>
							<springform:errors path="password" cssClass="error"/>
							<springform:input path="confirmPassword" placeholder="Пароль"/>
							<springform:errors path="confirmPassword" cssClass="error"/>
							<springform:input path="name" placeholder="Имя"/>
							<springform:errors path="name" cssClass="error"/>
							<springform:input path="surname" placeholder="Фамилия"/>
							<springform:input path="email" placeholder="Email"/>
							<springform:input path="phone" placeholder="Телефон"/>
							<springform:errors path="phone" cssClass="error"/>
							<input type="submit" value="Зарегистрироваться" class="btn btn-default">
						</springform:form>
					</div><!--/sign up form-->
				</div>
			</div>
		</div>
	</section><!--/form-->
	
	
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