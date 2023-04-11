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
 <link href="resources/css/addBook.css/" rel="stylesheet" type="text/css">

</head>
<body>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <a class="navbar-brand" href="dashboard">Welcome, ${sessionScope.username}</a>
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
    <div>
        <div class="wrapper fadeInDown">
            <div id="fadeIn first">
                <h2 class='addBook'>Add New Book</h2>
            </div class=".form-wrapper">
            <br/>
            <form action="${pageContext.request.contextPath}/addBook" method="POST">
                <input type='text' id='title' class="fadeIn second" name='title'
                placeholder="Title" value=""/>
                <input type='text' id='author' class="fadeIn third" name='author'
                placeholder="Author" value=""/>
                <input type='text' id='isbn' class="fadeIn fourth" name='isbn'
                placeholder="Isbn" value=""/>
                <input type='text' id='genre' class="fadeIn fifth" name='genre'
                placeholder="Genre" value=""/>
                <input type='text' id='description' class="fadeIn sixth" name='description'
                placeholder="Description" value=""/>
                <input type='text' id='coverimage' class="fadeIn seventh" name='coverImage'
                placeholder="Cover Image" value=""/>
                <input type='number' id='rating' class="fadeIn eighth" name='rating'
                placeholder="Rating" value="" step="0.1"/>
                <input type='number' id='price' class="fadeIn ninth" name='price'
                placeholder="Price" value="" step="0.01"/>

                <input type="submit" class="btn-login" value="Add Book" />
            </form>
        </div>
    </div>
</div>
</body>
</html>
