<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<c:import url="../template/bootStrap.jsp"></c:import>
</head>
<body>

<c:import url="../template/header.jsp"></c:import>

<div class="container">
  <h3>Member List</h3>
  
         <div class="row">
        <div class="col-sm-8">
           <form action="./memberList">
            <div class="input-group">
            	<select class="input-group-sm" id="sel1" name="kind">
            		<option value="tt">Id</option>
            		<option value="wr">Pw</option>
            		<option value="na">Name</option>
            		<option value="em">Email</option>
            	</select>
                   <input id="msg" type="text" class="form-control" name="search" placeholder="Additional Info">
                <div class="input-group-btn">
                  <button class="btn btn-default" type="submit">
                    <i class="glyphicon glyphicon-search"></i>
                  </button>
                </div>
              </div> 
           </form>
        </div>
     </div>
  
  <table CLASS="table table-hober">
  	<tr>
  		<td>Num</td>
  		<td>Id</td>
  		<td>Pw</td>
  		<td>Name</td>
  		<td>Email</td>
  	</tr>
  
  <c:forEach items="${lists}" var="dto" varStatus="vs">
  <tr>
  	<td>${dto.num} : ${vs.count}</td>
  	<td><a href="./memberSelect?num=${dto.num}">${dto.id}</td>
  	<td>${dto.pw}</td>
  	<td>${dto.name}</td>
  	<td>${dto.email}</td>
  </tr>
  </c:forEach>
  
  </table>
  
  <div>
  
  	<c:if test="${pager.beforeCheck}">
  	<a href="./memberList?curPage=${pager.startNum-1}">[이전]</a>
  	</c:if>
  	
  	<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
  		<a href="./memberList?curPage=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a>
  	</c:forEach>
  	
  	<c:if test="${pager.nextCheck}">
  	<a href="./memberList?curPage=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">[다음]</a>
  	</c:if>
  </div>
  
  <a href="./memberJoin" class="btn btn-danger">Write</a>
  
</div>

</body>
</html>