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
function channelList(){
	
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
			"url": "/admin/channel/list",
			"type" :"GET",
			"dataType" : "json"
		},
		columns: [
			{data: "postSN", render : function(data, type, row){
				return '<div class="dropdown">\n\
				  <button style="border: 0px; background-color: white;"class="sidebar-link waves-effect waves-dark sidebar-link dropdown-toggle" aria-haspopup="true" aria-expanded="false"  data-toggle="dropdown">\n\
				  <span class="hide-menu">'+data+'</span> </button>\n\
			      <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">\n\
			      		<button class="dropdown-item" onclick="channelDetail('+data+')">게시물상세</button>\n\
						<button class="dropdown-item" onclick="channelUpdate('+data+')">게시물수정</button>\n\
						<button class="dropdown-item" onClick="channelDelete('+data+');">게시물삭제</button>\n\
					</div>\n\
			      </div>'
				
				}
			},
			{data: "channelTitle"},
			{data: "channelText"},
			{data: "nick"},
			{data: "viewCnt"},
			{data: "likeCnt"},
			{data: "createDatetime"},
			{data: "updateDatetime"}
		]
	});
}

function channelDetail(postSN){
	location.href="/admin/channel/detail/"+postSN;
} 

function channelUpdate(postSN){
	alert("미구현");
//	location.href="/admin/board/update/"+postSN;
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
