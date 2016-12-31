<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<script src="${pageContext.request.contextPath}/lib/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/lib/angular.min.js"></script>
<script src="${pageContext.request.contextPath}/lib/angular-ui-router/release/angular-ui-router.min.js"></script>
<script src="${pageContext.request.contextPath}/lib/kendo-ui/js/kendo.all.min.js"></script>
<script src="${pageContext.request.contextPath}/lib/kendo-ui/js/jszip.min.js"></script>

<script src="${pageContext.request.contextPath}/js/module.js"></script>

<sec:authorize access="hasAnyRole('customer')">
	<script src="${pageContext.request.contextPath}/js/customer.config.js"></script>
	<script src="${pageContext.request.contextPath}/js/customer.run.js"></script>
	<script src="${pageContext.request.contextPath}/js/controllers/ticketController.js"></script>
	<script src="${pageContext.request.contextPath}/js/controllers/bookingController.js"></script>
	<script src="${pageContext.request.contextPath}/js/services/customerService.js"></script>
</sec:authorize>

<sec:authorize access="hasAnyRole('staff')">
	<script src="${pageContext.request.contextPath}/js/staff.config.js"></script>
	<script src="${pageContext.request.contextPath}/js/staff.run.js"></script>
    <script src="${pageContext.request.contextPath}/js/controllers/movieController.js"></script>
</sec:authorize>

<sec:authorize access="hasAnyRole('admin')">
	<script src="${pageContext.request.contextPath}/js/admin.config.js"></script>
	<script src="${pageContext.request.contextPath}/js/admin.run.js"></script>
	<script src="${pageContext.request.contextPath}/js/controllers/movieController.js"></script>
	<script src="${pageContext.request.contextPath}/js/controllers/manageController.js"></script>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
	<script src="${pageContext.request.contextPath}/js/services/gridViewConfig.js"></script>
	<script src="${pageContext.request.contextPath}/js/services/gridFilterConfig.js"></script>
</sec:authorize>
