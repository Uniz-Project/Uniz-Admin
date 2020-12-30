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
							<h1 class="h3 mb-0 text-gray-800">회원게시물수정</h1>
						</div>
	
						<!-- row -->
						<div class="row">
							<div class="col-lg-12">
								<div class="card mb-4">
									<div class="card-header py-3">
										<h6 class="m-0 font-weight-bold text-primary">상세정보</h6>
									</div>
									<div class="card-body">
										<form id="memberForm" action="/admin/board/update" method="post">
										
											<input type="hidden" value="${board.postSN}" name="postSN">
											<div class="form-group">
												<label for="tableData1">게시자</label>
												<input class="form-control  mb-3" type="text" id="tableData1" name="nick" value="${board.nick}" placeholder="" readonly="readonly">
											</div>
	
											<div class="form-group">
												<label for="tableData2">제목</label>
												<input class="form-control  mb-3" type="text" id="tableData2" name="title" value="${board.title}"placeholder="">
											</div>
											<div class="form-group">
												<label for="tableData3">내용</label>
												<textarea class="form-control  mb-3" id="tableData3" name="postContent" placeholder="" >${board.postContent}</textarea>
											</div>
											
										
										<div class="text-right">
											<button type="button" onClick="formClear();" id="btnClear" class="btn btn-primary mb-1">초기화</button>
											<button type="submit" id="btnUpd" class="btn btn-warning mb-1">수정</button>
											<button type="button" id="btnDel" class="btn btn-danger mb-1" onclick="memberDelete();">삭제</button>
										</div>
										</form>									
									</div>
								</div>
							</div>

						</div>
						<!-- row -->
					</div>
					<!-- Container Fluid -->
				</div>
<script type="text/javascript" src="/resources/js/js/boardList.js"></script>
<%@ include file="/WEB-INF/views/admin/include/footer.jsp" %>
					<!-- Container Fluid -->
	</div>
	<%@include file="/WEB-INF/views/admin/include/scripts.jsp" %>
	

</body>
</html>
