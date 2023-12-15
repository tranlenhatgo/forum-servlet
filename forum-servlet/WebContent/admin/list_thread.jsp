<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List threads = List.of((List) request.getAttribute("threads"));
%>

<!doctype html>
<html lang="en">

<head>
<%@include file="include/head.jsp"%>
<title>List of Thread</title>
</head>

<body>
	<div class="dash">
		<%@ include file="include/navbar.jsp"%>
		<div class="dash-app">
			<%@include file="include/header.jsp"%>
			<main class="dash-content">
				<div class="container-fluid">
					<h2 class="dash-title">All Threads</h2>
					<div class="row">
						<div class="container">
							<div class="card spur-card">
								<div class="card-header">
									<div class="spur-card-icon">
										<i class="fas fa-table"></i>
									</div>
								</div>
								<div class="card-body ">
									<table class="table table-in-card">
										<thead>
											<tr>
												<th scope="col">Name</th>
												<th scope="col">Desc</th>
												<th scope="col">Img</th>
												<th scope="col">Created at</th>
												<th scope="col">Change</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="thread" items="${threads}">
												<tr>
													<th scope="row">${thread.thread_name}</th>
													<td>${thread.description}</td>
													<td>${thread.img}</td>
													<td>${thread.created_at}</td>
													<td><a href="update-thread?id=${thread.thread_id}">Update</a> 
														<a href="delete-thread?id=${thread.thread_id}">Delete</a></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</main>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
		integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
		integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
		crossorigin="anonymous"></script>
	<script src="scripts/spur.js"></script>
</body>

</html>