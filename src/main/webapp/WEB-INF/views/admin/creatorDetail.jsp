<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:formatDate var="board_createDatetime" value="${Creator[0].createDateTime}" pattern="yyyy-MM-dd"/>
<fmt:formatDate var="board_updateDatetime" value="${Creator[0].updateDateTime}" pattern="yyyy-MM-dd"/>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@include file="/WEB-INF/views/admin/include/header.jsp"%>
<style>
	.cl{
		display: inline-block;
	    width: 48%;
	}
</style>
</head>
<body>
	<div id="main-wrapper" data-layout="vertical" data-navbarbg="skin6"
		data-sidebartype="full" data-sidebar-position="absolute"
		data-header-position="absolute" data-boxed-layout="full">

		<%@ include file="/WEB-INF/views/admin/include/topbar.jsp"%>

		<%@ include file="/WEB-INF/views/admin/include/nav.jsp"%>
		<div class="page-wrapper">

			<!-- Container Fluid-->
			<div class="container-fluid" id="container-wrapper">
				<div
					class="d-sm-flex align-items-center justify-content-between mb-4">
					<h1 class="h3 mb-0 text-gray-800">유저관리 > 크리에이터 신청 > 상세보기</h1>
				</div>

				<!-- Row -->
				<div class="row">
					<div class="col-md-12">
						<div class="card mb-4">
							<div class="card-header py-3">
								<h6 class="m-0 font-weight-bold text-primary">크리에이터 신청내용 확인</h6>
							</div>
							<div id="originalForm" class="card-body">

								<div style="font-weight: bold; font-size: 20px">
									${Creator[0].userID}님의 신청</div>

								<div style="font-size: 8px; margin-top: 10px">
									<span style="margin-right: 15px">작성자 : ${Creator[0].nick}</span> <span
										style="margin-right: 15px">작성일시 :${board_createDatetime }</span>
									<span>최종 수정일시 : ${board_updateDatetime}</span>
								</div>
								<hr />
								<div>
								<c:forEach items="${Creator}" var="list">
									<img class="cl" src="/resources/imgUpload/apply/${list.uploadPath}/${list.uuid}_${list.fileName}">
								
								</c:forEach>
								</div>

								<hr />

								<div id="divBtns" class="text-right p-3">
									<button type="button"  onClick="history.go(-1)" id="btnClear" class="btn btn-secondary">목록</button>
									<button type="button" id="btnIns" class="btn btn-success mb-1" onclick="permit(${Creator[0].applySN},2);">승인</button>
									<button type="button" id="btnDel" class="btn btn-danger mb-1" onclick="permit(${Creator[0].applySN},3);">거절</button>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!--Row-->
			</div>
		</div>
		
		<%@ include file="/WEB-INF/views/admin/include/footer.jsp"%>
		<!-- Container Fluid -->
	</div>
	<%@include file="/WEB-INF/views/admin/include/scripts.jsp"%>
	
	<script>
	//승인버튼클릭
	function permit(data, state){
		let applySN = parseInt(data);
		const ChangeState = parseInt(state);
		console.log(ChangeState);
		$.ajax({
			url: "/admin/member/creator/accept/"+applySN+'/'+state,
			type: "post", 
			contentType : "application/json; charset=UTF-8",
			dataType: "json",
			success: function(data){
				if(data.result === "SUCCESS"){					
					alert("정상적으로 수정되었습니다.");
					location.href ="/admin/member/creator";
				} else {
					alert("데이터 수정 중 오류가 발생하였습니다.\n입력한 정보를 다시 확인해 주세요.");
				}
			},
			error: function(request, status, error){
				console.log("code:" + request.status);
				console.log("message:" + request.responseText);
				console.log("error:" + error);
			}
		});
	}
	</script>
</body>
</html>

