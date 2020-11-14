 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/admin/include/header.jsp" %>

<%@ include file="/WEB-INF/views/admin/include/nav.jsp" %>
        
        
		<div class="page-wrapper">
    <!-- Container Fluid -->
					<div class="container-fluid" id="container-wrapper">
						<div class="d-sm-flex align-items-center justify-content-between mb-4">
							<h1 class="h3 mb-0 text-gray-800">유니즈레이어관리</h1>
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
												<label for="unizSn">유니즈번호</label>
												<input class="form-control  mb-3" type="text" id="unizSn" name="unizSn" placeholder="">
											</div>
	
											<div class="form-group">
												<label for="unizTypeSn">부모유니즈</label>
												<input class="form-control  mb-3" type="text" id="parentUnizSn" name="parentUnizSn" placeholder="">
											</div>
	
											<!-- <div class="form-group">
												<label for="unizKeyword">조상유니즈키워드</label>
												<input class="form-control  mb-3" type="text" id="parentUnizKeyword" name="parentUnizKeyword" placeholder="">
											</div>
	
											<div class="form-group">
												<label for="unizKeyword">자식유니즈키워드</label>
												<input class="form-control  mb-3" type="text" id="childUnizKeyword" name="updateDatedate" placeholder="">
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
						<span class="hide-menu">목록</span>
                         </button>
                         
                          <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						    <button class="dropdown-item" onClick="unizLayerList();" >유니즈레이어확인</button>
						    <button class="dropdown-item" onClick="unizNotLayerList();">관계없는유니즈확인</button>
						    <button class="dropdown-item" >Something else here</button>
 						 </div>
                        
                        </div>
									<div class="table-responsive p-3">
										<table class="ui table" style="width:100%" id="codeTable">
											<thead class="thead-light">
												<tr>
													<th id="column1">유니즈번호</th>
													<th id="column2">부모유니즈</th>
													<th id="column3">생성일</th>
													<th id="column4">변경일</th>
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

		<script type="text/javascript" src="/resources/js/js/unizLayer.js"></script>
		<script>
       
			 $(document).ready(function() {
				formClear();
				unizLayerList();
				
			}); 
			 
			 $("#codeTable").on("click", "tr", function(){
					rowData = $("#codeTable").DataTable().row(this).data();
					if(rowData !== null){
						formChange();
					}
				});
			 
</script>
<%@ include file="/WEB-INF/views/admin/include/footer.jsp" %>
