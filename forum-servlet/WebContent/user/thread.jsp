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
<title>Thread</title>
<link rel="stylesheet" href="<c:url value='user/styles/thread.css'/>" />
<body>
	<%@include file="include/navbar.jsp" %>
	<hr class="hr mt-4 mg-s mg-e" />
	<div class="banner mg-s mg-e">
      <img src="img/banner.webp" class="img-fluid" alt="#" />
    </div>

    <div class="head-thread d-flex">
      <div
        class="first-part d-flex align-items-center justify-content-between mg-s"
      >
        <div class="d-flex align-items-center">
          <img src="img/thread-img/${thread.img}" alt="#" class="thread-pic" />
          <h2 class="namethread">${thread.thread_name}/</h2>
        </div>
        <ion-icon name="notifications-outline"></ion-icon>
      </div>
      <div class="second-part">
        <div>
          <form class="d-flex input-group">
            <input
              class="form-control"
              type="text"
              placeholder="Search in thread"
            />
            <button type="button" class="btn btn-primary btn-search-post">
              <ion-icon name="search"></ion-icon>
            </button>
          </form>
        </div>
        <div>
          <button
            type="button"
            id="btn-create-post"
            data-bs-toggle="modal"
            data-bs-target="#createPostModal"
            <c:if test = "${user==null}" >
          		disabled
          	</c:if>
          >
            Create Post
          </button>
        </div>
      </div>
    </div>

    <!-- Modal To Create Post -->
    <div
      class="modal fade"
      id="createPostModal"
      tabindex="-1"
      aria-labelledby="createPostModalLabel"
      aria-hidden="true"
    >
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="createPostModalLabel">Create Post</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" ></button>
          </div>
          <div class="modal-body">
            <form id="createPost" method="get" action="user/createNewPost">
              <div class="mb-3">
                <label for="postContent" class="form-label">Content</label>
                <textarea name="content" class="form-control" id="postContent" rows="4" placeholder="Enter post content"></textarea>
              </div>
              <div class="mb-3">
                <label for="postImage" class="form-label">Image</label>
                <input name="img" type="file" class="form-control" id="postImage" accept="image/*" />
              </div>
              <input type="hidden" name="user_id" value="${user.id}"/>
              <input type="hidden" name="thread_id" value="${thread.thread_id}"/>              
            </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
              Cancel
            </button>
            <button form="createPost" type="submit" class="btn btn-primary" >
              Create
            </button>
          </div>
        </div>
      </div>
    </div>


	<!-- List of Post -->
    <div class="posts mg-s mg-e">
      <div class="row">
        <div class="col-9">
        <c:forEach var="post" items="${posts}">
          <div class="post">
            <div class="head-post">
              <img src="img/user-img/${post.creater.profile_pic}" alt="#" />
              <p><a href="#">${post.creater.username}</a> post in ${thread.thread_name} at ${post.created_at}</p>
              <div>
                <ion-icon name="ellipsis-vertical-outline"></ion-icon>
              </div>
            </div>
            <div class="body-post">
              <img src="img/post-img/${post.img}" alt="#" />
              <p>
                ${post.content}
              </p>
            </div>
            <div class="end-post">
              <ion-icon name="caret-up" id="upbtn" onclick="upvote(this)"></ion-icon>
              <p id="upvote">x</p>
              <ion-icon name="caret-down" id="downbtn" onclick="downvote(this)"></ion-icon>
              <p id="downvote">x</p>
              <ion-icon name="chatbox-ellipses-outline"></ion-icon>
              <p>5</p>
              <ion-icon name="arrow-redo-circle-outline"></ion-icon>
            </div>
          </div>
        </c:forEach>
        </div>
        <div class="about-thread col-3">
          <div class="head rounded-top">
            <h5>About Community</h5>
          </div>
          <div class="body rounded-bottom">
            ${thread.about_info}
          </div>
        </div>
      </div>
    </div>
    <div class="mg-s mg-e border rounded-2 mt-5">
      <div class="user-onl-head rounded-top">
        <h5>User online</h5>
      </div>
      <div class="user-onl-body rounded-bottom">
        <p>
          In total there are 5 users online : 0 registered, 0 hidden and 5
          guests (based on users active over the past 5 minutes)
        </p>
        <p>Most users ever online was 569 on Sat Jul 11, 2020 11:51 am</p>
      </div>
    </div>
    <div class="mg-s mg-e border rounded-2 mt-5 mb-5">
      <div class="user-onl-head rounded-top">
        <h5>Statistics</h5>
      </div>
      <div class="user-onl-body rounded-bottom">
        <p>
          Total posts 19 • Total topics 13 • Total members 11 • Our newest
          member Nhat Go
        </p>
      </div>
    </div>
    <div class="ender container-fluid pb-5">
      <div class="row mg-s mg-e d-flex">
        <div class="about-me col-sm-4">
          <h4>About me</h4>
          <p>
            This is a diverse forum website that I have created to learn and
            apply the knowledge I have gained to build it myself.<br />
            I will continue to improve both the website and my personal skills
          </p>
        </div>
        <div class="contact col-sm-3">
          <h4>Contact</h4>
          <ul>
            <li><ion-icon name="call"></ion-icon> +0375591345</li>
            <li><ion-icon name="locate"></ion-icon> VKU Da Nang</li>
            <li><ion-icon name="mail"></ion-icon> gotln.22ite@vku.udn.vn</li>
          </ul>
        </div>
        <div class="end-link col-sm-3">
          <ul>
            <li><ion-icon name="logo-facebook"></ion-icon></li>
            <li><ion-icon name="logo-discord"></ion-icon></li>
            <li><ion-icon name="logo-github"></ion-icon></li>
            <li><ion-icon name="logo-linkedin"></ion-icon></li>
          </ul>
        </div>
      </div>
    </div>
	
	<%@include file="include/footer.jsp" %>
	<script type="module"
		src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
	<script type="module" 
		src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
	<script src="https://unpkg.com/@popperjs/core@2"></script>
	<script src="styles/thread.js"></script>
</body>
</html>