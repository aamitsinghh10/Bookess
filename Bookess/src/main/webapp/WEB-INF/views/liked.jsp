<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liked Books</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
    crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
    crossorigin="anonymous"></script>

    <link href="resources/css/liked.css/" rel="stylesheet" type="text/css">
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
           <a class="nav-link" href="${pageContext.request.contextPath}/dashboard">Dashboard</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/">Logout</a>
          </li>
        </ul>
      </div>
    </nav>
    <div class="container mt-4">
        <h1 class="mb-4">Liked Books</h1>
        <div class="row">
            <c:forEach var="book" items="${liked}">
                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <img src="${book.coverImage}" class="card-img-top" alt="${book.title} Cover Image">
                        <div class="card-body">
                            <h5 class="card-title">${book.title}</h5>
                            <p class="card-text"><strong>Author:</strong> ${book.author}</p>
                            <p class="card-text"><strong>ISBN:</strong> ${book.isbn}</p>
                            <p class="card-text"><strong>Genre:</strong> ${book.genre}</p>
                            <p class="card-text"><strong>Description:</strong> ${book.description}</p>
                            <p class="card-text"><strong>Rating:</strong> ${book.rating}</p>
                            <h6 class="card-subtitle mb-2 text-muted">Price: $${book.price}</h6>
                            <div class="d-flex justify-content-between align-items-center">
                                <div class="btn-group">
                                    <a href="${pageContext.request.contextPath}/book?id=${book.id}" class="btn btn-sm btn-outline-secondary">Remove</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>