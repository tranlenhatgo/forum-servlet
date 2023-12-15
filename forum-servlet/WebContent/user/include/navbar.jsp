<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand">
	<div class="container-fluid large-container d-flex">
		<div class="home">
			<ion-icon name="home" style="font-size: 1.2rem; margin-right: 5px"></ion-icon>
			<a class="link">Home</a>
		</div>
		<form class="d-flex">
			<input class="form-control me-3" type="text" placeholder="Search" />
			<button type="button" class="btn btn-primary btn-search">
				<ion-icon name="search"></ion-icon>
			</button>
		</form>
		<%if (user==null) {%>
		<a
          class="nav-link text-light login-hover"
          data-bs-toggle="modal"
          data-bs-target="#myLogin"
          >Login</a
        	>
		<%} else { %>
		<div class="dropdown">
			<div class="user-login" type="button"
				data-bs-toggle="dropdown" aria-expanded="false">
				<img src="img/user-img/${user.profile_pic}" alt="#" id="user-pic" class="" />
				<p>${user.username}</p>
				<ion-icon name="caret-down-outline"></ion-icon>
			</div>
			<ul class="dropdown-menu">
				<li><a class="dropdown-item" href="#">Profile</a></li>
				<li><a class="dropdown-item" href="#">Dark Mode</a></li>
				<li><a class="dropdown-item" href="logout">Log out</a></li>
			</ul>
		</div>
		<%} %>
	</div>
</nav>
<div class="modal" id="myLogin">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">Login Form</h4>
				<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
			</div>
			<div class="modal-body">
				<div class="container mt-3">
					<form id="loginform" method="get" action="user/login">
						<div class="form-floating mb-3 mt-3">
							<input type="text" class="form-control" id="email"
								placeholder="Enter email" name="email" /> <label for="email">Email</label>
						</div>
						<div class="form-floating mt-3 mb-3">
							<input type="password" class="form-control" id="password"
								placeholder="Enter password" name="password" /> <label for="pwd">Password</label>
						</div>
						<a class="" href="#">Forget your password?</a>
					</form>
				</div>
			</div>
			<div class="modal-footer">
				<div>
					<a href="">Register</a>
				</div>
				<button type="submit" form="loginform" class="btn btn-dark" data-bs-dismiss="modal">Login</button>
			</div>
		</div>
	</div>
</div>