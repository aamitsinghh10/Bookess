<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Add Book</title>

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
 <link href="resources/css/addBook.css" rel="stylesheet" type="text/css">

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
          <a class="nav-link" href="${pageContext.request.contextPath}/">Logout</a>
        </li>
      </ul>
    </div>
  </nav>
  <div class="container">
    <h1 class="my-4">Add Book</h1>
    <form action="addBook" method="post" class="mb-4" enctype="multipart/form-data">
      <div class="form-group">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" class="form-control">
      </div>

      <div class="form-group">
        <label for="author">Author:</label>
        <input type="text" id="author" name="author" class="form-control">
      </div>

      <div class="form-group">
        <label for="isbn">ISBN:</label>
        <input type="text" id="isbn" name="isbn" class="form-control">
      </div>

      <div class="form-group">
        <label for="genre">Genre:</label>
        <input type="text" id="genre" name="genre" class="form-control">
      </div>

      <div class="form-group">
        <label for="description">Description:</label>
        <textarea id="description" name="description" class="form-control"></textarea>
      </div>

      <div class="form-group">
        <label for="coverImage">Cover Image:</label>
        <input type="text" id="coverImage" name="coverImage" class="form-control">
      </div>

      <div class="form-group">
        <label for="rating" class="mr-2">Rating:</label>
        <input type="number" step="0.1" min="0" max="10" id="rating" name="rating" class="form-control">
      </div>

      <div class="form-group">
        <label for="price" class="mr-2">Price:</label>
        <input type="number" step="0.01" min="0" id="price" name="price" class="form-control">
      </div>

      <div class="form-group">
        <input type="submit" value="Add Book" class="btn btn-primary">
      </div>
    </form>
  </div>
</body>
</html>
