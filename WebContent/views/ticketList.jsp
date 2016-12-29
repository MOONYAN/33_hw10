<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<div class="layout">
	<div class="body">
		<div id="kendo_grid">
			<kendo-grid id="grid" options="TicketCtrl.gridOptions"></kendo-grid>
		</div>
		<%--<table>--%>
		<%--<tr ng-repeat="ticketModel in TicketCtrl.ticketModels">--%>
		<%--<td>{{ticketModel.id}}</td>--%>
		<%--<td>{{ticketModel.bookerId}}</td>--%>
		<%--<td>{{ticketModel.movieName}}</td>--%>
		<%--<td>{{ticketModel.showTime}}</td>--%>
		<%--<td>{{ticketModel.seat}}</td>--%>
		<%--</tr>--%>
		<%--</table>--%>
	</div>
</div>

<%-- <div class="container">
<div class="panel panel-primary">
<div class="panel-heading">Own Ticket List</div>
<table class="table">
<thead>
<tr>
<th>id</th>
<th>bookerId</th>
<th>movieName</th>
<th>showTime</th>
<th>seat</th>
<th>Cancel</th>
</tr>
</thead>
<tbody>
<c:forEach items = "${ticketModels}" var="ticketModel">
<tr>
<td>${ticketModel.id}</td>
<td>${ticketModel.bookerId}</td>
<td>${ticketModel.movieName}</td>
<td>${ticketModel.showTime}</td>
<td>${ticketModel.seat}</td>
<td>
<form class="" action="cancelTicket" method="post">
<input class="hidden" type="number" name="ticketId" value="${ticketModel.id}"/>
<input class="btn btn-primary" type="submit" value="Cancel Ticket"/>
<sec:csrfInput />
</form>
</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
<a class="btn btn-primary center-block" role="button" href="operation">OPERATION</a>
</div> --%>
