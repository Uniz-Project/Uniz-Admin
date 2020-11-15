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
	
	var element =
		"<th>회원번호</th>\n\
		<th>소셜가입처</th>\n\
		<th>회원타입</th>\n\
		<th>닉네임</th>\n\
		<th>프로필</th>\n\
		<th>회원상태</th>"+         
		"<th>최종로그인시간</th>\n\
		<th>가입일시</th>\n\
		<th>변경일시</th>\n\
		<th>최종회원상태</th>";
		
	
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
			"url": "/admin/member/list",
			"type" :"GET",
			"dataType" : "json"
		},
		columns: [
			{data: "userSN", render : function(data, type, row){
				return '<div class="dropdown">\n\
				  <button style="border: 0px; background-color: white;"class="sidebar-link waves-effect waves-dark sidebar-link dropdown-toggle" aria-haspopup="true" aria-expanded="false"  data-toggle="dropdown">\n\
				  <span class="hide-menu">'+data+'</span> </button>\n\
			      <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">\n\
						<button class="dropdown-item" onclick="memberUpdate('+data+')">회원정보수정</button>\n\
						<button class="dropdown-item" onClick="memberBoard('+data+');">게시물확인</button>\n\
						<button class="dropdown-item" onClick="memberUniz('+data+');">유니즈확인</button>\n\
					  <button class="dropdown-item" onClick="memberDelete('+data+');">회원삭제</button>\n\
					</div>\n\
			      </div>'
				
				}
			},
			{data: "provider"},
			{data: "userType"},
			{data: "nick"},
			{data: "imgUrl"},
			{data: "state"},
			{data: "lastLoginDatetime"},
			{data: "createDatetime"},
			{data: "updateDatetime"},
			{data: "lastStateDatetime"}
			
		]

	});
}


function Update(){
	
	console.log("실행.....");
	
	var memberForm = $("#memberForm").serialize();
	
	
	$.ajax({
		url: "/admin/member/update",
		type: "post", 
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		data: memberForm,
		dataType: "json",
		success: function(data){
			if(data.result === "success"){
				
				formClear();
				alert("정상적으로 입력되었습니다.");
			} else if(data.result === "duplicate"){
				alert("이미 해당 코드로 입력된 자료가 있습니다.\n확인 후 다시 시도해 주세요.");
			} else {
				alert("데이터 입력 중 오류가 발생하였습니다.\n입력한 정보를 다시 확인해 주세요.");
			}
		},
		error: function(request, status, error){
			console.log(request);
			console.log("code:" + request.status);
			console.log("message:" + request.responseText);
			console.log("error:" + error);
		}
	});
}

//REST로 바꿔야한다....소스정리할때 할것
function memberUpdate(userSN){
	
	location.href="/admin/member/update/"+userSN;
}

function memberBoard(userSN){
	
	$("#headTitle").html("회원관리 > 회원게시물조회");
	
	$("#boardTable").DataTable().rows().clear().draw();
	
	$("#boardTable").DataTable().destroy().draw();
	
	var element =
		"<th>회원번호</th>\n\
		<th>게시물번호</th>\n\
		<th>제목</th>\n\
		<th>닉네임</th>\n\
		<th>게시판명</th>\n\
		<th>조회수</th>\n\
		<th>좋아요수</th>"+         
		"<th>등록일</th>\n\
		<th>변경일</th>";
	
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
			"url": "/admin/member/board/"+userSN,
			"type" :"GET",
			"dataType" : "json"
		},
		columns: [
			{data: "userSN", render : function(data, type, row){
				
				return '<div class="dropdown">\n\
				  <button style="border: 0px; background-color: white;"class="sidebar-link waves-effect waves-dark sidebar-link dropdown-toggle" aria-haspopup="true" aria-expanded="false"  data-toggle="dropdown">\n\
				  <span class="hide-menu">'+data+'</span> </button>\n\
			      <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">\n\
						<button class="dropdown-item" onclick="memberUpdate('+data+')">회원정보수정</button>\n\
						<button class="dropdown-item" onClick="memberBoard('+data+');">게시물확인</button>\n\
						<button class="dropdown-item" onClick="memberUniz('+data+');">유니즈확인</button>\n\
					  <button class="dropdown-item" onClick="memberDelete('+data+');">회원삭제</button>\n\
					</div>\n\
			      </div>'
				
				}
			},
			{data: "postSN"},
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

function memberUniz(userSN){
	
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
			"url": "/admin/member/uniz"+userSN,
			"type" :"GET",
			"dataType" : "json"
		},
		columns: [
			{data: "userSN", render : function(data, type, row){
				return '<div class="dropdown">\n\
				  <button style="border: 0px; background-color: white;"class="sidebar-link waves-effect waves-dark sidebar-link dropdown-toggle" aria-haspopup="true" aria-expanded="false"  data-toggle="dropdown">\n\
				  <span class="hide-menu">'+data+'</span> </button>\n\
			      <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">\n\
						<button class="dropdown-item" onclick="memberUpdate('+data+')">회원정보수정</button>\n\
						<button class="dropdown-item" onClick="memberBoard('+data+');">게시물확인</button>\n\
						<button class="dropdown-item" onClick="memberUniz('+data+');">유니즈확인</button>\n\
					  <button class="dropdown-item" onClick="memberDelete('+data+');">회원삭제</button>\n\
					</div>\n\
			      </div>'
				
				}
			},
			{data: "provider"},
			{data: "userType"},
			{data: "nick"},
			{data: "imgUrl"},
			{data: "state"},
			{data: "lastLoginDatetime"},
			{data: "createDatetime"},
			{data: "updateDatetime"},
			{data: "lastStateDatetime"}
			
		]

	});
}

function memberDelete(userSN){
	
	location.href="/admin/member/delete/"+userSN;
}



