<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
            <div class="page-breadcrumb">
                <div class="row align-items-center">
                    <div class="col-md-6 col-8 align-self-center">
                        <h3 class="page-title mb-0 p-0">Dashboard</h3>
                        <div class="d-flex align-items-center">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="#">Home</a></li>
                                    <li class="breadcrumb-item active" aria-current="page">Dashboard</li>
                                </ol>
                            </nav>
                        </div>
                    </div>
                    <div class="col-md-6 col-4 align-self-center">
                    </div>
                </div>
            </div>
            <!-- ============================================================== -->
            <!-- End Bread crumb and right sidebar toggle -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- Container fluid  -->
            <!-- ============================================================== -->
   			<div class="container-fluid" id="container-wrapper">
						<div class="row mb-3">
							<div class="col-xl-3 col-md-6 mb-4">
								<div class="card">
									<div class="card-body">
										<div class="row no-gutters align-items-center">
											<div class="col mr-2">
												<div class="text-xs font-weight-bold text-uppercase mb-1">오늘의 신규 가입자</div>
												<div class="h5 mb-0 mr-3 font-weight-bold text-gray-800" id="newUserCnt"></div>
											</div>
											<div class="col-auto">
												<a href="/admin/user"><i class="fas fa-users fa-2x text-info"></i></a>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-xl-3 col-md-6 mb-4">
								<div class="card">
									<div class="card-body">
										<div class="row no-gutters align-items-center">
											<div class="col mr-2">
												<div class="text-xs font-weight-bold text-uppercase mb-1">오늘의 게시판 작성 게시물 수</div>
												<div class="h5 mb-0 font-weight-bold text-gray-800" id="boardWriteCnt"></div>
											</div>
											<div class="col-auto">
												<a href="/admin/order"><i class="fas fa-comments fa-2x text-warning"></i></a>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-xl-3 col-md-6 mb-4">
								<div class="card">
									<div class="card-body">
										<div class="row no-gutters align-items-center">
											<div class="col mr-2">
												<div class="text-xs font-weight-bold text-uppercase mb-1">오늘 등록된 채널 수</div>
												<div class="h5 mb-0 font-weight-bold text-gray-800" id="channelCreateCnt"></div>
											</div>
											<div class="col-auto">
												<i class="fas fa-tv fa-2x text-success"></i>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-xl-3 col-md-6 mb-4">
								<div class="card">
									<div class="card-body">
										<div class="row align-items-center">
											<div class="col mr-2">
												<div class="text-xs font-weight-bold text-uppercase mb-1">오늘 등록된 영상 수</div>
												<div class="h5 mb-0 font-weight-bold text-gray-800" id="regVideoCnt"></div>
											</div>
											<div class="col-auto">
												<i class="far fa-caret-square-right fa-3x text-danger"></i>
											</div>
										</div>
									</div>
								</div>
							</div>
	
							<div class="col-xl-6 col-lg-6">
								<div class="card mb-4">
									<div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
										<h6 class="m-0 font-weight-bold text-primary">일주일간 회원 수 변화</h6>
									</div>
									<div class="card-body">
										<div class="chart-area">
											<canvas id="myAreaChart"></canvas>
										</div>
									</div>
								</div>
							</div>
							
							<div class="col-xl-6 col-lg-6">
								<div class="card mb-4">
									<div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
										<h6 class="m-0 font-weight-bold text-primary">일주일간 채널 수 변화</h6>
									</div>
									<div class="card-body">
										<div class="chart-area">
											<canvas id="myAreaChart2"></canvas>
										</div>
									</div>
								</div>
							</div>
							
							<div class="col-xl-6 col-lg-6">
								<div class="card mb-4" >
									<div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
									</div>
									<div class="card-body">
										<div class="chart-area">
											<canvas id="myAreaChart3"></canvas>
										</div>
									</div>
								</div>
							</div>
							
						</div>
						<!--Row-->
					</div>
      	  <!-- End Container fluid  -->
      	</div>
      	 <!-- Page wrapper  -->
      	 
      	 <%@ include file="/WEB-INF/views/admin/include/footer.jsp" %>
		</div>
		
		<%@include file="/WEB-INF/views/admin/include/scripts.jsp" %>
		<script src = "https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.bundle.js"></script>
		<script src = "https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.bundle.min.js"></script>
		<script src = "https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.js"></script>
		<script src = "https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.min.js"></script> 
		<script src="/resources/js/js/main.js"></script>
		<script>
			$(document).ready(function(){
				newUserCnt();
				boardWriteCnt();
				channelCreateCnt();
				regVideoCnt();
				dailyMemberAmount();
				dailyChannelAmount();
			});
		</script>   	 
	</body>
</html>

