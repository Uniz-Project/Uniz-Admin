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

//채널 리스트 출력
function channelList(){
	
	$("#boardTable").DataTable({
		processing: true,
		serverSide: false,
		paging: true,
		pagingType: "simple_numbers",
		order: [[4,'desc']], 
		ordering: true,
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
			"url": "/admin/channel/list",
			"type" :"GET",
			"dataType" : "json"
		},
		columns: [
			{data: "channelSN", render : function(data, type, row){
				return '<div class="dropdown">\n\
				  <button style="border: 0px; background-color: white;"class="sidebar-link waves-effect waves-dark sidebar-link dropdown-toggle" aria-haspopup="true" aria-expanded="false"  data-toggle="dropdown">\n\
				  <span class="hide-menu">'+data+'</span> </button>\n\
			      <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">\n\
			      		<button class="dropdown-item" onclick="searchChannelTitle('+data+')">채널게시판상세</button>\n\
						<button class="dropdown-item" onclick="channelUpdate('+data+')">채널수정</button>\n\
						<button class="dropdown-item" onClick="channelDelete('+data+');">채널삭제</button>\n\
					</div>\n\
			      </div>'
				
				}
			},
			{data: "channelTitle"},
			{data: "channelComment"},
			{data: "nick"},
			{data: "createDatetime"},
			{data: "updateDatetime"}
		]
	});
}
function channelUpdate(channelSN){
	location.href="/admin/channel/update/"+channelSN;
}
function searchChannelTitle(channelSN){
	
	
	$("#boardTable").DataTable().rows().clear().draw();
	
	$("#boardTable").DataTable().destroy().draw();
	
	var element =
		"<th>게시물번호</th>\n\
		<th>제목</th>\n\
		<th>닉네임</th>\n\
		<th>조회수</th>"+       
		"<th>작성일</th>\n\
		<th>변경일</th><th>댓글수</th>";
	
	//테이블에 추가
	$("#rowData").html(element);
	
	$("#headTitle").html("채널관리 > 채널게시판 상세");
		
	$("#boardTable").DataTable({
		processing: true,
		serverSide: false,
		paging: true,
		pagingType: "simple_numbers",
		order: [[5,'desc']], 
		ordering: true,
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
			"url": "/admin/channel/channelTitle/" + channelSN,
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
			      		<button class="dropdown-item" onclick="channelBoardDetail('+data+')">게시물상세</button>\n\
						<button class="dropdown-item" onclick="channelBoardUpdate('+data+')">게시물수정</button>\n\
						<button class="dropdown-item" onClick="channelBoardDelete('+data+');">게시물삭제</button>\n\
					</div>\n\
			      </div>'
				
				}
			},
			{data: "postTitle"},
			{data: "nick"},
			{data: "viewCnt"},
			{data: "createDatetime"},
			{data: "updateDatetime"},
			{data: "replyCnt"}
		]
	});
}

function channelBoardDetail(postSN){
	location.href="/admin/channel/detail/"+postSN;
} 

function channelBoardUpdate(postSN){
//	alert("미구현");
	location.href="/admin/channel/board/update/"+postSN;
}

function channelBoardDelete(postSN){
	var boardForm = $("#boardForm").serialize();
	
	$.ajax({
		url: "/admin/channel/board/delete/"+postSN,
		type: "post", 
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		data: boardForm,
		dataType: "json",
		success: function(data){
			if(data.result === "success"){
				$("#boardTable").DataTable().ajax.reload();
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

function channelDelete(postSN){
	var boardForm = $("#boardForm").serialize();
	
	$.ajax({
		url: "/admin/channel/delete/"+postSN,
		type: "post", 
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		data: boardForm,
		dataType: "json",
		success: function(data){
			if(data.result === "success"){
				$("#boardTable").DataTable().ajax.reload();
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
