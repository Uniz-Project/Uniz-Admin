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
							<h1 class="h3 mb-0 text-gray-800">UWMatchList 관리</h1>
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
												<label for="tableData2">유니즈번호</label>
												<input class="form-control  mb-3" type="text" id="tableData2" name="unizSn" placeholder="" >
											</div>
											
											<div class="form-group">
												<label for="tableData3">Max점수</label>
												<input class="form-control  mb-3" type="text" id="tableData3" name="maxUnizPoint" placeholder="" >
											</div>
											
											<div class="form-group">
												<label for="tableData4">Min점수</label>
												<input class="form-control  mb-3" type="text" id="tableData4" name="minUnizPoint" placeholder="" >
											</div>
											
											<div class="form-group">
												<label for="tableData5">우선순위</label>
												<input class="form-control  mb-3" type="text" id="tableData5" name="priority" placeholder="" >
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
									<div class="dropdown">
										<button style="border: 0px; background-color: white;"class="sidebar-link waves-effect waves-dark sidebar-link dropdown-toggle" aria-haspopup="true" aria-expanded="false"  data-toggle="dropdown">
										<span class="hide-menu">목록</span> </button>
				                       
				                          <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
										    <button class="dropdown-item" onClick="uwMatchList();" >UWMatchList확인</button>
										    <button class="dropdown-item" onClick="uwNotMatchList();">매칭없는유니즈확인</button>
										    <button class="dropdown-item" >Something else here</button>
				 						 </div>
                      			   </div>
									<div class="table-responsive p-3">
										<table class="ui table" style="width:100%" id="codeTable">
											<thead class="thead-light">
												<tr id="rowData">
													
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
				</div>
		<%@ include file="/WEB-INF/views/admin/include/footer.jsp" %>
					<!-- Container Fluid -->
	</div>
	<%@include file="/WEB-INF/views/admin/include/scripts.jsp" %>
		<script type="text/javascript" src="/resources/js/js/wniz.js"></script>
		<script>
       
			 $(document).ready(function() {
				formClear2();
				uwMatchList();				
			}); 
			 $("#codeTable").on("click", "tr", function(){
					rowData = $("#codeTable").DataTable().row(this).data();
					if(rowData !== null){
						formChange2();
					}
				});
			 
</script>
</body>
</html>
