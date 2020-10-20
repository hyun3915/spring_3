<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<title>Insert title here</title>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Page 1-1</a></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>
      </li>
      <li><a href="#">Page 2</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>

<div class="container">
  <h2>Member Update From</h2>
  <form id="frm" action="./memberUpdate" method="post">
  
  	<input type="hidden" name="num" value="${dto.num}">
  
    <div class="form-group">
      <label for="id">Id:</label>
      <input type="text" class="form-control" id="id" readonly="readonly" name="id" value="${dto.id}">
    </div>
    
    <div class="form-group">
      <label for="pw">Pw:</label>
      <input type="text" class="form-control" id="pw" placeholder="Enter pw" name="pw" value="${dto.pw}">
    </div>
   
   <div class="form-group">
      <label for="name">Name:</label>
      <textarea class="form-control" rows="5" id="name" placeholder="Enter name" name ="name">${dto.name}</textarea>
    </div>
    
    <div class="form-group">
      <label for="email">Email:</label>
      <textarea class="form-control" rows="5" id="email" placeholder="Enter email" name ="email">${dto.email}</textarea>
    </div>
    
    <input type="button" class="btn btn-primary" value="Update" id="btn">
    <button type="submit" class="btn btn-default">Update</button>
    
  </form>
</div>

<script type="text/javascript" src="../resources/js/boardWrite.js"></script>

</body>
</html>