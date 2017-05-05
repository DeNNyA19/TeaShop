<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="header_top"><!--header_top-->
			<div class="container">
				<div class="row">
					<div class="col-sm-6 ">
						<div class="contactinfo">
							<ul class="nav nav-pills">
								<li><a href=""><i class="fa fa-phone"></i> +375-29-811-58-19</a></li>
								<li><a href=""><i class="fa fa-envelope"></i> deniskorbovskii@mail.ru</a></li>
							</ul>
						</div>
					</div>
					</div>
				</div>
			</div>
		</div><!--/header_top-->
		
		<div class="header-middle"><!--header-middle-->
			<div class="container">
				<div class="row">
					<div class="col-sm-4">
						<div class="logo pull-left">
							<a href="/index"><img src="/resources/images/logo.jpg" alt="" /></a>
						</div>
					</div>
					<div class="col-sm-8">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">
								<sec:authorize access="hasRole('ADMIN')">
									<li><a href="<c:url value="/orders"/>"><i class="fa"></i> Заказы</a></li>
								</sec:authorize>

								<li><a href="<c:url value="/cart/view"/> "><i class="fa fa-shopping-cart"></i> Корзина(${cartSize})</a></li>
								<c:if test="${user eq 'anonymousUser'}">
									<li><a href="<c:url value="/login"/>"><i class="fa fa-lock"></i> Вход</a></li>
								</c:if>
								<c:if test="${user ne 'anonymousUser'}">
									<li><p>Добро пожаловать, ${user}</p>
										<a href="<c:url value="/logout" />">Logout</a></li>
								</c:if>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-middle-->