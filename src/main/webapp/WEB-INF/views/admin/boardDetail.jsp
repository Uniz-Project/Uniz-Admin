<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@include file="/WEB-INF/views/admin/include/header.jsp"%>
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
					<h1 class="h3 mb-0 text-gray-800">게시판관리 > 글확인</h1>
				</div>

				<!-- Row -->
				<div class="row">
					<div class="col-md-12">
						<div class="card mb-4">
							<div class="card-header py-3">
								<h6 class="m-0 font-weight-bold text-primary">글확인</h6>
							</div>
							<div id="originalForm" class="card-body">

								<div style="font-weight: bold; font-size: 20px">
									${board.title}</div>

								<div style="font-size: 8px; margin-top: 10px">
									<span style="margin-right: 15px">작성자 : ${board.nick}</span> <span
										style="margin-right: 15px">작성일시 :${board.createDatetime }</span>
									<span>최종 수정일시 : ${board.updateDatetime}</span>
								</div>
								<hr />
								<div>${board.postContent}</div>
								<%-- <input type="hidden" id="categoryCd" value="${board.categoryCd}" />
												<input type="hidden" id="id" value="${board.postSN}" /> --%>

								<hr />

								<div id="divBtns" class="text-right p-3">
									<button type="button"  onClick="history.go(-1)" id="btnClear" class="btn btn-secondary">목록</button>
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


</body>
</html>

