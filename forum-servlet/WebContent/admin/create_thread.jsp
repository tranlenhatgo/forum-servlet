<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">

<head>
<%@include file="include/head.jsp"%>
<title>Create Thread</title>
<link rel="stylesheet" href="styles/create_thread.css">
</head>

<body>
	<div class="dash">
		<%@ include file="include/navbar.jsp"%>
		<div class="dash-app">
			<%@include file="include/header.jsp"%>
			<main class="dash-content">
				<div class="container-fluid">
					<h2 class="dash-title">Create New Threads</h2>
					<div class="row">
						<div class="container">
							<div class="card spur-card">
								<div class="card-header">
									<div class="spur-card-icon">
										<i class="fas fa-chart-bar"></i>
									</div>
									<div class="spur-card-title"></div>
								</div>
								<div class="card-body ">
									<form method="post" action="createNewThread">
										<div class="form-group">
											<label for="inputName">Name Thread</label> 
											<input name="thread-name" type="text" class="form-control" id="inputName">
										</div>
										<div class="form-group">
											<label for="inputDesc">Description</label>
											<textarea name="description" class="form-control" id="inputDesc" rows="3"></textarea>
										</div>
										<div class="form-group inputImg">
											<div class="d-flex">
											<label for="inputImage">Image</label>
											<div class="d-flex ">
												<div>
													<label class="button" for="customFile2">Choose
														file</label> 
														<input name="image" type="file" class="form-control d-none" id="customFile2"
														onchange="displaySelectedImage(event, 'selectedAvatar')" />
												</div>
											</div>
											</div>
											<div>
												<div class="d-flex mb-4">
													<img id="selectedAvatar"
														src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAPoAAADcCAYAAABZGbwWAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAAHYcAAB2HAY/l8WUAAABhaVRYdFNuaXBNZXRhZGF0YQAAAAAAeyJjbGlwUG9pbnRzIjpbeyJ4IjowLCJ5IjowfSx7IngiOjI0OSwieSI6MH0seyJ4IjoyNDksInkiOjIxOX0seyJ4IjowLCJ5IjoyMTl9XX0ouBkJAAACoElEQVR4Xu3TIQJAQAAAwTtZE/z/eYKmU3yCnUn7gZ3Hed0D+K19W+fyNvBjRocAo0OA0SHA6BBgdAgwOgQYHQKMDgFGhwCjQ4DRIcDoEGB0CDA6BBgdAowOAUaHAKNDgNEhwOgQYHQIMDoEGB0CjA4BRocAo0OA0SHA6BBgdAgwOgQYHQKMDgFGhwCjQ4DRIcDoEGB0CDA6BBgdAowOAUaHAKNDgNEhwOgQYHQIMDoEGB0CjA4BRocAo0OA0SHA6BBgdAgwOgQYHQKMDgFGhwCjQ4DRIcDoEGB0CDA6BBgdAowOAUaHAKNDgNEhwOgQYHQIMDoEGB0CjA4BRocAo0OA0SHA6BBgdAgwOgQYHQKMDgFGhwCjQ4DRIcDoEGB0CDA6BBgdAowOAUaHAKNDgNEhwOgQYHQIMDoEGB0CjA4BRocAo0OA0SHA6BBgdAgwOgQYHQKMDgFGhwCjQ4DRIcDoEGB0CDA6BBgdAowOAUaHAKNDgNEhwOgQYHQIMDoEGB0CjA4BRocAo0OA0SHA6BBgdAgwOgQYHQKMDgFGhwCjQ4DRIcDoEGB0CDA6BBgdAowOAUaHAKNDgNEhwOgQYHQIMDoEGB0CjA4BRocAo0OA0SHA6BBgdAgwOgQYHQKMDgFGhwCjQ4DRIcDoEGB0CDA6BBgdAowOAUaHAKNDgNEhwOgQYHQIMDoEGB0CjA4BRocAo0OA0SHA6BBgdAgwOgQYHQKMDgFGhwCjQ4DRIcDoEGB0CDA6BBgdAowOAUaHAKNDgNEhwOgQYHQIMDoEGB0CjA4BRocAo0OA0SHA6BBgdAgwOgQYHQKMDgFGhwCjQ4DRIcDoEGB0CDA6BBgdAowOAUaHAKNDgNEhwOgQYHQIMDoEGB0CjA4BRgeA7xvjAZ0XBbbn+pWqAAAAAElFTkSuQmCC"
														class="rounded-circle"
														style="width: 100px; height: 100px; object-fit: cover;"
														/>
												</div>
											</div>
										</div>
										<button type="submit" class="btn btn-primary">Submit</button>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</main>
		</div>
	</div>
	
	<script type="text/javascript">
		function displaySelectedImage(event, elementId) {
			const selectedImage = document.getElementById(elementId);
			const fileInput = event.target;

			if (fileInput.files && fileInput.files[0]) {
				const reader = new FileReader();

				reader.onload = function(e) {
					selectedImage.src = e.target.result;
				};

				reader.readAsDataURL(fileInput.files[0]);
			}
		}
	</script>
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