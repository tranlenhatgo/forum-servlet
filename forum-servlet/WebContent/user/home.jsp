<%@page import="com.myproject.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
User user = (User) request.getSession().getAttribute("user");
if (user != null) {
	request.setAttribute("user", user);
}
%>
<!DOCTYPE html>
<html>
<head>
<%@include file="include/head.jsp" %>
 <meta charset="UTF-8" />
<title>Index</title>
<link rel="stylesheet" href="<c:url value='user/styles/home.css'/>" />
<body>
	<%@include file="include/navbar.jsp" %>
	<hr class="hr mt-4 mg-s mg-e" />
	<div class="container w-auto mg-e mg-s">
		<div class="row d-flex">
			<div class="col-sm-9 table-responsive">
				<table class="table table-borderless table-thread"> 
					<thead>
						<tr class="text-secondary">
							<th style="width: 60%; margin-left: 20px">Thread</th>
							<th style="width: 10%">Created</th>
							<th style="width: 10%">Posts</th>
							<th style="width: 20%">Last</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="thread" items="${threads}">
						<tr>
							<td>
								<div class="row1">
									<img src="img/thread-img/${thread.img}" alt="#" class="thread-pic" />
									<div>
										<a class="link" href="thread?id=${thread.thread_id}">${thread.thread_name}</a>
										<p>${thread.description}</p>
									</div>
								</div>
							</td>
							<td>
								<div class="">${thread.created_at}</div>
							</td>
							<td>9</td>
							<td>
								<div class="">
									<p>
										By <a class="link"> Adzz</a>
									</p>
									<p>at 4/5/2021</p>
								</div>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col-sm-3">
				<table class="table categories">
					<thead>
						<tr>
							<th style="font-weight: 500">Category</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><a class="link">Entertainment</a></td>
							<td>5</td>
						</tr>
						<tr>
							<td><a class="link">School</a></td>
							<td>6</td>
						</tr>
						<tr>
							<td><a class="link">Study</a></td>
							<td>7</td>
						</tr>
						<tr>
							<td><a class="link">Technology</a></td>
							<td>8</td>
						</tr>
						<tr>
							<td><a class="link">Space</a></td>
							<td>9</td>
						</tr>
					</tbody>
				</table>
				<table class="table ads">
					<thead>
						<tr>
							<th style="font-weight: 500">Advertising</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th><img src="img/ad.jpg" alt="#" style="width: 250px" /></th>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<%@include file="include/footer.jsp" %>
	<script type="module"
		src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
	<script type="module" 
		src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
	<script src="https://unpkg.com/@popperjs/core@2"></script>
</body>
</html>
