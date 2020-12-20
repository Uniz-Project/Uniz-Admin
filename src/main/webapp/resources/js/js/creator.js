//필드 초기화 
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


function memberList(){
	
	//memberList호출시 테이블 요소 변경
	var element =
		"<th>회원번호</th><th>회원아이디</th>\n\
		<th>회원닉네임</th>\n\
		<th>신청채널명</th>\n\
		<th>카테고리</th>\n\
		<th>이메일</th>"+         
		"<th>처리상태</th>\n\
		<th>신청일시</th>\n\
		<th>변경일시</th>\n\
		<th>회원타입</th><th>버튼</th>";
		
	//테이블에 추가
	$("#rowData").html(element);
	
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
			"url": "/admin/member/creator", 
			"type" :"POST",
			"dataType" : "json"
		},
		columns: [
			{data: "applySN", render : function(data, type, row){
				return '<a href="/admin/member/creator/detail/'+data+'">'+data+'</a>'
				
				
				}
			},
			{data: "userID"},
			{data: "nick"},
			{data: "channelTitle"},
			{data: "category"},
			{data: "email"},
			{data: "statusName"},
			{data: "createDateTime"},
			{data: "updateDateTime"},
			{data: "userType"},
			{data: "applySN", render : function(data, type, row){
				return '<button type="button" id="btnIns" class="btn btn-success mb-1" onclick="permit('+data+','+11+');">승인</button>'
						+'<button type="button" id="btnIns" style="margin-left : 5px;" class="btn btn-danger mb-1" onclick="permit('+data+','+12+');">거절</button>'
				}
			},
		]

	});
}

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

