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
<style type="text/css">
	.c1{
      cursor: pointer;
   }
</style>
</head>
<body>

<c:import url="../template/header.jsp"></c:import>

<div class="container">
  <h3>Member List</h3>
  
         <div class="row">
        <div class="col-sm-8">
           <form action="./memberList" id="searchForm">
            <input type="hidden" name="curPage" id="curPage"> 
            <div class="input-group">
            	<select class="input-group-sm" id="kind" name="kind">
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
  	<span class="c1" title="${pager.startNum-1}">[이전]</span> 
  	</c:if>
  	
  	<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
  		<span class="c1" title="${i}">${i}</span>
  	</c:forEach>
  	
  	<c:if test="${pager.nextCheck}">
  		<span class="c1" title="${pager.lastNum+1}">[다음]</span>
  	</c:if>
  </div>
  
  <a href="./memberJoin" class="btn btn-danger">Write</a>
  
</div>

<script type="text/javascript">
	var kind = '${pager.kind}';
	var search = '${pager.search}';
	if(kind == ''){
		kind="tt";
	}
	$('#kind').val(kind);
	$('search').val(search);
	
	$(".c1").click(function() {
		var c = $(this).attr("title");
		
		$("#curPage").val(c);
		$('#kind').val(kind);
		$('#search').val(search);
		$("#searchForm").submit();
	});
</script>

</body>
</html>