<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="ko">
	<head>
		<%@include file="/WEB-INF/views/admin/include/header.jsp" %>

	</head>
	<body>
 	<div id="main-wrapper" data-layout="vertical" data-navbarbg="skin6" data-sidebartype="full"
        data-sidebar-position="absolute" data-header-position="absolute" data-boxed-layout="full">
	
		<%@ include file="/WEB-INF/views/admin/include/topbar.jsp" %>
				
        <%@ include file="/WEB-INF/views/admin/include/nav.jsp" %>
        <div class="page-wrapper">
            <!-- ============================================================== -->
            <!-- Bread crumb and right sidebar toggle -->
            <!-- ============================================================== -->
          
            <!-- ============================================================== -->
            <!-- End Bread crumb and right sidebar toggle -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <!-- Container Fluid-->
           
					<div class="container-fluid" id="container-wrapper">
						<div class="d-sm-flex align-items-center justify-content-between mb-4">
							<h1 id="headTitle" class="h3 mb-0 text-gray-800" style="display: inline-block;"> 게시판관리 > 목록</h1>
							 
						</div>
                        	
						<!-- Row -->
						<div class="dropdown">
							    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">게시판전체
							    <span class="caret"></span></button>
							    
							    <ul class="dropdown-menu" id="BoardTitle" style="background-color: transparent; border: none; overflow: auto; height: 150px;">
									<li>
									<button class="btn btn-primary" type="button" style="width:131px;" onClick="location.href='/admin/board'">게시판전체</button>
									</li>
							      <c:forEach items="${titleList}" var="list">
									<li><button class="btn btn-primary" style="width:131px; border:solid 1px black;" onClick="searchBoardTitle(${list.boardSN})">${list.boardTitle}</button></li>
								</c:forEach>
							    </ul>
		  						<button type="button" id="btnDel" class="btn btn-danger" onClick="boardReportList()" >신고목록</button>
  						</div>
						<div class="row">
							<!-- DataTable with Hover -->
							<div class="col-lg-12">
								<div class="card mb-4" id="boardForm">
									<div class="table-responsive p-3">
										<table class="table align-items-center table-flush table-hover" style="width: 100%" id="boardTable">
											<thead class="thead-light">
												<tr id="rowData">
													<th>게시물번호</th>
													<th>제목</th>
													<th>닉네임</th>
													<th>게시판명</th>
													<th>조회수</th>
													<th>좋아요수</th>               
													<th>작성일</th>
													<th>변경일</th>
												
												</tr>
											</thead>
										</table>
									</div>
								</div>
							</div>
						</div>
						<!--Row-->
					</div>
					<!---Container Fluid-->
					<%@ include file="/WEB-INF/views/admin/include/footer.jsp" %>
				</div>
		</div>
<%@include file="/WEB-INF/views/admin/include/scripts.jsp" %>		
<script type="text/javascript" src="/resources/js/js/boardList.js"></script>
<script>
       
			 $(document).ready(function() {
				
				 boardList();
			});  
</script>
<%@ include file="/WEB-INF/views/admin/include/footer.jsp" %>
</body>
</html>
