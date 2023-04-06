<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add Book</title>

	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
    	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
    	crossorigin="anonymous">

   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
   	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
   	crossorigin="anonymous"></script>
   	<link href="resources/css/addBook.css/" rel="stylesheet" type="text/css">

</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
          <a class="navbar-brand" href="bookStore">Book</a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link" href="dashboard">Dashboard</a>
              </li>

              <li class="nav-item">
                <a class="nav-link" href="logout">Logout</a>
              </li>
            </ul>
          </div>
        </nav>
	<div class="container my-5">
		<h1>Add a Book</h1>
		<form action="addBookServlet" method="post" enctype="multipart/form-data">
			<label>Title:</label>
			<input type="text" name="title" class="form-control"><br>

			<label>Author:</label>
			<input type="text" name="author" class="form-control"><br>

			<label>ISBN:</label>
			<input type="text" name="isbn" class="form-control"><br>

			<label>Genre:</label>
			<input type="text" name="genre" class="form-control"><br>

			<label>Description:</label>
			<textarea name="description" class="form-control"></textarea><br>

			<label>Cover Image:</label>
			<input type="file" name="coverImage" class="form-control-file"><br>

			<label>Rating:</label>
			<input type="number" name="rating" class="form-control"><br>

			<label>Price:</label>
			<input type="number" name="price" class="form-control"><br>

			<input type="submit" value="Add Book" class="btn btn-primary">
		</form>
	</div>
</body>
</html>