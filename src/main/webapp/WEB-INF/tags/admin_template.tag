<%@ tag language="java" pageEncoding="UTF-8" isELIgnored="false"%>

<%@ attribute name="title" required="true" rtexprvalue="true"%>
<%@ attribute name="breadcrumb" required="true" rtexprvalue="true"%>
<%@ attribute name="content" fragment="true"%>


<!DOCTYPE html>
<html lang="en">

<!-- HEAD  -->
<jsp:include page="/admin/template/head/head.jsp"></jsp:include>

<body>

	<div id="wrapper">

		<!-- MENU -->
		<jsp:include page="/admin/template/menu/menu.jsp" />

		<!-- HEADER -->
		<div id="content-wrapper">
			<div id="content">
				<jsp:include page="/admin/template/header/header.jsp"></jsp:include>
			</div>
			<!-- CONTENT -->

			<div class="container-fluid">
				<jsp:invoke fragment="content"></jsp:invoke>
			</div>
		</div>
	</div>
</body>

<jsp:include page="/admin/template/js/js.jsp"></jsp:include>

</html>
