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
    <!-- Container Fluid -->
					<div class="container-fluid" id="container-wrapper">
						<div class="d-sm-flex align-items-center justify-content-between mb-4">
							<h1 class="h3 mb-0 text-gray-800">위니즈관리</h1>
						</div>
	
						<!-- row -->
						<div class="row">
							<div class="col-lg-6">
								<div class="card mb-4">
									<div class="card-header py-3">
										<h6 class="m-0 font-weight-bold text-primary">상세정보</h6>
									</div>
									<div class="card-body">
										<form id="codeForm">
											<div class="form-group">
												<label for="tableData1">위니즈번호</label>
												<input class="form-control  mb-3" type="text" id="tableData1" name="wnizSn" placeholder="" readonly="readonly">
											</div>
	
											<div class="form-group">
												<label for="tableData2">타이틀</label>
												<input class="form-control  mb-3" type="text" id="tableData2" name="title" placeholder="" >
											</div>
											
											<div class="form-group">
												<label for="tableData3">이미지주소</label>
												<input class="form-control  mb-3" type="text" id="tableData3" name="imgUrl" placeholder="" >
											</div>
	
											<!-- <div class="form-group">
												<label for="unizKeyword">생성일</label>
												<input class="form-control  mb-3" type="text" id="createDateTime" name="createDateTime" placeholder="">
											</div>
	
											<div class="form-group">
												<label for="unizKeyword">변경일</label>
												<input class="form-control  mb-3" type="text" id="updateDateTime" name="updateDateTime" placeholder="">
											</div> -->
	
											<input class="form-control" type="hidden" id="id" name="id" value="0" />
											
										</form>
										<div class="text-right">
											<button type="button" onClick="formClear();" id="btnClear" class="btn btn-primary mb-1">초기화</button>
											<button type="button" id="btnIns" class="btn btn-success mb-1">입력</button>
											<button type="button" id="btnUpd" class="btn btn-warning mb-1">수정</button>
											<button type="button" id="btnDel" class="btn btn-danger mb-1">삭제</button>
										</div>
									</div>
								</div>
							</div>
								
							<div class="col-lg-6">
								<div class="card mb-4">
									<div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
										<h6 class="m-0 font-weight-bold text-primary">목록</h6>
									</div>
									<div class="table-responsive p-3">
										<table class="ui table" style="width:100%" id="codeTable">
											<thead class="thead-light">
												<tr>
													<th>위니즈번호</th>
													<th>타이틀</th>
													<th>이미지경로</th>
													<th>생성일</th>
													<th>변경일</th>
												</tr>
											</thead>
										</table>
									</div>
								</div>
							</div>
						</div>
						<!-- row -->
					</div>
					<!-- Container Fluid -->
					<%@ include file="/WEB-INF/views/admin/include/footer.jsp" %>
				</div>
		</div>
		<%@include file="/WEB-INF/views/admin/include/scripts.jsp" %>
		<script type="text/javascript" src="/resources/js/js/wniz.js"></script>
		<script src="/resources/scss/bootstrap/datatables/jquery.dataTables.min.js"></script>
		<script src="/resources/scss/bootstrap/datatables/dataTables.bootstrap4.min.js"></script>
		<script>
       
			 $(document).ready(function() {
				formClear();
				codeList();
				
			}); 
			 
			 $("#codeTable").on("click", "tr", function(){
					rowData = $("#codeTable").DataTable().row(this).data();
					if(rowData !== null){
						formChange();
					}
				});
			 
</script>
</body>
</html>
