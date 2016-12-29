<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="container">
  <div class="row">
    <sec:authorize access="hasAnyRole('customer')">
    	<%-- <input type="button" onclick="location.href='${pageContext.request.contextPath}/iMovie/#/listBookerLogs';" value="BookerLogs" class="col-sm-3"/> --%>
    	<input type="button" onclick="location.href='${pageContext.request.contextPath}/iMovie/#/listBookerTickets';" value="BookerTickets" class="col-sm-3"/>
    </sec:authorize>
    <%-- <input type="button" onclick="location.href='${pageContext.request.contextPath}/iMovie/#/listMovies';" value="Movies" class="col-sm-3"/> --%>
    <form action="${pageContext.request.contextPath}/logout" method="POST" class="col-sm-3">
    	<input type="submit" value="Logout" class="col-sm-12"/>
    	<sec:csrfInput />
    </form>
  </div>
</div>
