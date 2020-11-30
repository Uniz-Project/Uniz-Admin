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
							<h1 class="h3 mb-0 text-gray-800">영상추가</h1>
						</div>
	
						<!-- row -->
						<div class="row">
							<div class="col-lg-12">
								<div class="card mb-4">
									<div class="card-header py-3">
										<h6 class="m-0 font-weight-bold text-primary">상세정보</h6>
									</div>
									<div class="card-body">
										<form id="videoForm">
											<div class="form-group">
												<label for="tableData1">제목</label>
												<input class="form-control  mb-3" type="text" id="tableData1" name="title" value="${video.title}" placeholder="">
											</div>
	
											<div class="form-group">
												<label for="tableData2">게시자ID</label>
												<input class="form-control  mb-3" type="text" id="tableData2" name="authorId" value="${video.authorId}"placeholder="" >
											</div>
											<div class="form-group">
												<label for="tableData3">게시자닉네임</label>
												<input class="form-control  mb-3" type="text" id="tableData3" name="authorNick" value="${video.authorNick}"placeholder="" >
											</div>
											
											<div class="form-group">
												<label for="tableData4">유튜브URL</label>
												<input class="form-control  mb-3" type="text" id="tableData4" name="urlPath" value="${video.urlPath}" placeholder="" >
											</div>
											<div class="form-group">
												<label for="tableData5">유튜브썸네일</label>
												<input class="form-control  mb-3" type="text" id="tableData5" name="thumbUrl" value="${video.thumbUrl}" placeholder="" >
											</div>
											<div class="form-group">
												<label for="tableData6">좋아요수</label>
												<input class="form-control  mb-3" type="text" id="tableData6" name="likeCnt" value="${video.likeCnt}" placeholder="" >
											</div>
											<div class="form-group">
												<label for="tableData7">구독자수</label>
												<input class="form-control  mb-3" type="text" id="tableData7" name="followCnt" value="${video.followCnt}" placeholder="" >
											</div>
											<div class="form-group">
												<label for="tableData8">조회수</label>
												<input class="form-control  mb-3" type="text" id="tableData8" name="viewCnt" value="${video.viewCnt}" placeholder="" >
											</div>
											<div class="form-group">
												<label for="tableData9">매핑카테고리</label>
												<input class="form-control  mb-3" type="text" id="tableData9" name="utbCateSn" value="${video.utbCateSn}"placeholder="" >
											</div>
											<div class="form-group">
												<label for="tableData9">비디오아이디</label>
												<input class="form-control  mb-3" type="text" id="tableData10" name="utbVideoID" value="${video.utbVideoID}"placeholder="" >
											</div>
	
											

											<input class="form-control" type="hidden" id="id" name="id" value="0" />
											
										</form>									
										
										<div class="text-right">
											<button type="button"  onClick="history.go(-1)" id="btnClear" class="btn btn-secondary">목록</button>
											<button type="button" onClick="formClear();" id="btnClear" class="btn btn-primary mb-1">초기화</button>
											<button type="button" id="btnIns" class="btn btn-success mb-1" onclick="videoInsert();">입력</button>
											<button type="button" id="btnUpd" class="btn btn-warning mb-1" onclick="videoUpdate();">수정</button>
											<button type="button" id="btnDel" class="btn btn-danger mb-1" onclick="videoDelete();">삭제</button>
										</div>
									</div>
								</div>
							</div>

						</div>
						<!-- row -->
					</div>
					<!-- Container Fluid -->
				</div>
		<%@ include file="/WEB-INF/views/admin/include/footer.jsp" %>
		<script type="text/javascript" src="/resources/js/js/videoList.js"></script>
			</div>
<%@include file="/WEB-INF/views/admin/include/scripts.jsp" %>
	
</body>
</html>
