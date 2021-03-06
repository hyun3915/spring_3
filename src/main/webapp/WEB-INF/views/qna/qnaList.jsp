<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
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
  <h3>QnA List</h3>
       <div class="row">
        <div class="col-sm-8">
           <form action="./qnaList" id="searchForm">
           <input type="hidden" name="curPage" id="curPage"> 
            <div class="input-group">
            	<select class="input-group-sm" id="kind" name="kind">
            		<option value="tt">Title</option>
            		<option value="wr">Writer</option>
            		<option value="con">Contents</option>
            		<option value="da">RegDate</option>
            		<option value="hi">Hit</option>
            		<option value="re">Ref</option>
            		<option value="st">Step</option>
            		<option value="dep">Depth</option>
            	</select>
                   <input id="search" type="text" class="form-control" name="search" placeholder="Additional Info">
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
  		<td>Title</td>
  		<td>Writer</td>
  		<td>RegDate</td>
  		<td>Hit</td>
  		<td>Ref</td>
  		<td>Step</td>
  		<td>Depth</td>
  	</tr>
  
	<c:forEach items="${lists}" var="dto" varStatus="vs">
	<tr>
  		<td>${dto.num} : ${vs.count} </td>
  		<td>
  			<a href="./qnaSelect?num=${dto.num}">
  			<c:forEach begin="1" end="${dto.depth}">--</c:forEach>
			${dto.title}
			</a>
  		</td>
  		<td>${dto.writer}</td>
 	 	<td>${dto.regDate}</td>
  		<td>${dto.hit}</td>
  		<td>${dto.ref}</td>
	  	<td>${dto.step}</td>
 	 	<td>${dto.depth}</td>
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
  
	<a href="./qnaWrite" class="btn btn-danger">Write</a>

</div>

<script type="text/javascript">
		var kind = '${pager.kind}';
		var search = '${pager.search}';
		if(kind ==''){
			kind='tt';
		}
		$('#kind').val(kind);
		$('#search').val(search);
		
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