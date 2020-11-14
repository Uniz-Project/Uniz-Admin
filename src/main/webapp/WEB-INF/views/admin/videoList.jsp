<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/admin/include/header.jsp" %>
        <!-- ============================================================== -->
        <!-- End Topbar header -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ============================================================== -->
        <%@ include file="/WEB-INF/views/admin/include/nav.jsp" %>
		<body>
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
							<h1 class="h3 mb-0 text-gray-800" style="display: inline-block;">유튜브 영상관리 > 목록</h1>
							<button type="button" id="btnIns" class="btn btn-success mb-1" onclick="location.href='/admin/video/registerForm'">영상추가</button>
						</div>
	
						<!-- Row -->
						<div class="row">
							<!-- DataTable with Hover -->
							<div class="col-lg-12">
								<div class="card mb-4" id="boardForm">
									<div class="table-responsive p-3">
										<table class="table align-items-center table-flush table-hover" style="width: 100%" id="boardTable">
											<thead class="thead-light">
												<tr>
													<th>비디오번호</th>
													<th>제목</th>
													<th>게시자ID</th>
													<th>게시자명</th>
													<th>유튜브URL</th>
													<th>유튜브썸네일</th>               
													<th>좋아요수</th>
													<th>구독자수</th>
													<th>조회수</th>
													<th>매핑카테고리</th>		
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
				</div>
<script type="text/javascript" src="/resources/js/js/videoList.js"></script>
<script>
       
			 $(document).ready(function() {
				
				videoList();
				
			});  
</script>
<%@ include file="/WEB-INF/views/admin/include/footer.jsp" %>
