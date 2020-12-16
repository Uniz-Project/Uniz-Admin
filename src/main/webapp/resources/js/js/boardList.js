//데이터 테이블 필드 초기화
function formClear(){
	$("#tableData1").val("");
	$("#tableData2").val("");
	$("#tableData3").val("");
	$("#tableData4").val("");
	$("#tableData5").val("");
	$("#tableData6").val("");
	$("#tableData7").val("");
	$("#tableData8").val("");
	$("#tableData9").val("");
	
}

//boardList 출력
function boardList(){
	
	$("#boardTable").DataTable({
		processing: true,
		serverSide: false,
		paging: true,
		pagingType: "simple_numbers",
		order: false, 
		ordering: false,
		info: true,
		filter: true,
		
		language: {
			"zeroRecords": "데이터가 없습니다.",
			"lengthMenu": "_MENU_ 개씩 보기",
			"search": "검색:",
			"info": "_PAGE_ / _PAGES_",
			"infoFiltered": "(전체 _MAX_개의 데이터 중 검색결과)",
			"paginate": {
				"previous": "이전",
				"next": "다음"
			} 
		},
		ajax:{
			"url": "/admin/board/list",
			"type" :"GET",
			"dataType" : "json"
		},
		columns: [
			
			//postSN에 드랍다운 메뉴 추가 - render 
			{data: "postSN", render : function(data, type, row){
				return '<div class="dropdown">\n\
				  <button style="border: 0px; background-color: white;"class="sidebar-link waves-effect waves-dark sidebar-link dropdown-toggle" aria-haspopup="true" aria-expanded="false"  data-toggle="dropdown">\n\
				  <span class="hide-menu">'+data+'</span> </button>\n\
			      <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">\n\
			      		<button class="dropdown-item" onclick="boardDetail('+data+')">게시물상세</button>\n\
						<button class="dropdown-item" onclick="boardUpdate('+data+')">게시물수정</button>\n\
						<button class="dropdown-item" onClick="boardDelete('+data+');">게시물삭제</button>\n\
					</div>\n\
			      </div>'
				
				}
			},
			{data: "title"},
			{data: "nick"},
			{data: "boardTitle"},
			{data: "viewCnt"},
			{data: "likeCnt"},
			{data: "createDatetime"},
			{data: "updateDatetime"}
		]
	});
}


//해당 게시글의 게시판 상세페이지로 이동
function boardDetail(postSN){
	location.href="/admin/board/detail/"+postSN;
} 

function boardUpdate(postSN){
	alert("미구현");
//	location.href="/admin/board/update/"+postSN;
}

//해당 게시물 삭제
function boardDelete(postSN){
	var boardForm = $("#boardForm").serialize();
	
	$.ajax({
		url: "/admin/board/delete/"+postSN,
		type: "post", 
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		data: boardForm,
		dataType: "json",
		success: function(data){
			if(data.result === "success"){
				$("#boardTable").DataTable().ajax.reload(); //게시물 삭제 후 리로드
				alert("정상적으로 수정되었습니다.");
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

function searchBoardTitle(boardSN){
	$("#boardTable").DataTable().rows().clear().draw();
	
	$("#boardTable").DataTable().destroy().draw();
	
	$("#boardTable").DataTable({
		processing: true,
		serverSide: false,
		paging: true,
		pagingType: "simple_numbers",
		order: false, 
		ordering: false,
		info: true,
		filter: true,
		
		language: {
			"zeroRecords": "데이터가 없습니다.",
			"lengthMenu": "_MENU_ 개씩 보기",
			"search": "검색:",
			"info": "_PAGE_ / _PAGES_",
			"infoFiltered": "(전체 _MAX_개의 데이터 중 검색결과)",
			"paginate": {
				"previous": "이전",
				"next": "다음"
			} 
		},
		ajax:{
			"url": "/admin/board/boardTitle/" + boardSN,
			"type" :"GET",
			"dataType" : "json"
		},
		columns: [
			
			//postSN에 드랍다운 메뉴 추가 - render 
			{data: "postSN", render : function(data, type, row){
				return '<div class="dropdown">\n\
				  <button style="border: 0px; background-color: white;"class="sidebar-link waves-effect waves-dark sidebar-link dropdown-toggle" aria-haspopup="true" aria-expanded="false"  data-toggle="dropdown">\n\
				  <span class="hide-menu">'+data+'</span> </button>\n\
			      <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">\n\
			      		<button class="dropdown-item" onclick="boardDetail('+data+')">게시물상세</button>\n\
						<button class="dropdown-item" onclick="boardUpdate('+data+')">게시물수정</button>\n\
						<button class="dropdown-item" onClick="boardDelete('+data+');">게시물삭제</button>\n\
					</div>\n\
			      </div>'
				
				}
			},
			{data: "title"},
			{data: "nick"},
			{data: "boardTitle"},
			{data: "viewCnt"},
			{data: "likeCnt"},
			{data: "createDatetime"},
			{data: "updateDatetime"}
		]
	});
}
