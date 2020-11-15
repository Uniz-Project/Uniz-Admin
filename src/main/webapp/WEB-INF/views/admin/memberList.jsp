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
							<h1 id="headTitle" class="h3 mb-0 text-gray-800" style="display: inline-block;"> 회원관리 > 목록</h1>
							<!-- <button type="button" id="btnIns" class="btn btn-success mb-1" onclick="location.href='/admin/member/registerForm'">회원추가</button> -->
						</div>
	
						<!-- Row -->
						<div class="row">
							<!-- DataTable with Hover -->
							<div class="col-lg-12">
								<div class="card mb-4" id="boardForm">
									<div class="table-responsive p-3">
										<table class="table align-items-center table-flush table-hover" style="width: 100%" id="boardTable">
											<thead class="thead-light">
												<tr id="rowData">
													<!-- <th>회원번호</th>
													<th>소셜가입처</th>
													<th>회원타입</th>
													<th>닉네임</th>
													<th>프로필</th>
													<th>회원상태</th>               
													<th>최종로그인시간</th>
													<th>가입일시</th>
													<th>변경일시</th>
													<th>최종회원상태</th> -->		
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
<script type="text/javascript" src="/resources/js/js/memberList.js"></script>
<script>
       
			 $(document).ready(function() {
				
				 memberList();
				
			});  
</script>
<%@ include file="/WEB-INF/views/admin/include/footer.jsp" %>
