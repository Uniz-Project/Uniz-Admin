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


function videoList(){
	
	console.log("실행.....")
	
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
			"url": "/admin/video/list",
			"type" :"GET",
			"dataType" : "json"
		},
		columns: [
			{data: "videoSn", render : function(data, type, row, targets){return "<a href='/admin/video/registerForm/"+data+"'>"+data+ "</a>"}},
			{data: "title"},
			{data: "authorId" },
			{data: "authorNick"},
			{data: "urlPath"},
			{data: "thumbUrl",render : function(data, type, row){return "<img src='"+data+"' style='height: 50px; ' alt='등록된 썸네일이 없습니다.'></img>"} },
			{data: "likeCnt"},
			{data: "followCnt"},
			{data: "viewCount"},
			{data: "utbCateSn"}
			
		]

	});
}

//굳이 ajax로 안해도된다.
function videoInsert(){
	
	console.log("실행.....");
	
	var videoForm = $("#videoForm").serialize();
	
	console.log("videoForm "+ videoForm);
	$.ajax({
		url: "/admin/video/registerForm",
		type: "post", 
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		data: videoForm,
		dataType: "json",
		success: function(data){
			if(data.result === "success"){
				$("#boardForm").DataTable().ajax.reload();
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

