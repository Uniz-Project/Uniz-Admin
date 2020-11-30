function formChange(){
	$("#id").val(rowData.id);
	$("#unizSn").val(rowData.unizSn);
	$("#parentUnizSn").val(rowData.parentUnizSn);
	$("#parentUnizKeyword").val(rowData.parentUnizKeyword);
	$("#childUnizKeyword").val(rowData.childUnizKeyword);
	//$("#enable").val(rowData.enable);
	
//	$("#unizSn").attr("readonly", "readonly");
//	$("#unizTypeSn").attr("readonly", "readonly");
//	$("#unizKeyword").attr("readonly", "readonly");
//	
//	$("#btnIns").attr("disabled", "disabled");
//	$("#btnIns").css("opacity","0.3");
//	$("#btnIns").removeAttr("onClick");
	
	$("#btnUpd").removeAttr("disabled");
	$("#btnUpd").removeAttr("style");
	$("#btnUpd").attr("onClick", "codeUpdate();");
}

function formClear(){
	$("#unizSn").val("");
	$("#parentUnizSn").val("");
	$("#parentUnizSn").val("");
	$("#parentUnizKeyword").val("");
	$("#childUnizKeyword").val("");
	$("#id").val("0");
	
//	$("#unizSn").removeAttr("readonly");
	$("#parentUnizSn").removeAttr("readonly");
	$("#parentUnizSn").removeAttr("readonly");
	$("#childUnizKeyword").removeAttr("readonly");
	
	$("#btnIns").removeAttr("disabled");
	$("#btnUpd").removeAttr("disabled");
	$("#btnDel").removeAttr("disabled");
	
	$("#btnIns").removeAttr("style");
	$("#btnUpd").removeAttr("style");
	$("#btnDel").removeAttr("style");
	
	$("#btnUpd").attr("disabled", "disabled");
	
	$("#btnUpd").css("opacity","0.3");
	
	$("#btnIns").removeAttr("onClick");
	$("#btnUpd").removeAttr("onClick");
	
	$("#btnIns").attr("onClick", "codeInsert();");
	$("#btnDel").attr("onClick", "codeDelete();");
	
}

function codeInsert(){
	

		var codeForm = $("#codeForm").serialize();
		
		console.log("codeForm: "+codeForm);
		
		
		$.ajax({
			url: "/admin/uniz/unizLayerinsert",
			type: "post", 
			contentType: "application/x-www-form-urlencoded; charset=utf-8",
			data: codeForm,
			dataType: "json",
			success: function(data){
				if(data.result === "success"){
					$("#codeTable").DataTable().ajax.reload();
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


function codeUpdate(){
	var codeForm = $("#codeForm").serialize();
	console.log(codeForm);
	
	$.ajax({
		url: "/admin/uniz/unizLayerupdate",
		type: "post", 
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		data: codeForm,
		dataType: "json",
		success: function(data){
			if(data.result === "success"){
				$("#codeTable").DataTable().ajax.reload();
				formClear();
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

function codeDelete(){
	var codeForm = $("#codeForm").serialize();
	console.log(codeForm);
	
	$.ajax({
		url: "/admin/uniz/unizLayerdelete",
		type: "post", 
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		data: codeForm,
		dataType: "json",
		success: function(data){
			if(data.result === "success"){
				$("#codeTable").DataTable().ajax.reload();
				formClear();
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

function unizLayerList(){
		
	$("#column1").text("유니즈번호");
	$("#column2").text("부모유니즈");
	$("#column3").text("부모유니즈키워드");
	$("#column4").text("자손유니즈키워드");
	
	console.log("실행.....")
	
	$("#codeTable").DataTable().destroy();
	
	$("#codeTable").DataTable({
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
			"url": "/admin/uniz/unizLayerlist",
			"type" :"GET",
			"dataType" : "json"
		},
		
		columns: [
			{data: "unizSn"},
			{data: "parentUnizSn"},
			{data: "parentUnizKeyword"},
			{data: "childUnizKeyword"}		
		]
	});
	
	
}

function unizNotLayerList(){

	$("#column1").text("유니즈SN");
	$("#column2").text("유니즈타입");
	$("#column3").text("유니즈키워드");
	$("#column4").text("사용여부");
	//실행하면 먼저 ""로 초기화하기
	
	$("#codeTable").DataTable().destroy();
	
	console.log("실행.....")
	
	$("#codeTable").DataTable({
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
			"url": "/admin/uniz/unizNotLayerlist",
			"type" :"GET",
			"dataType" : "json"
		},
		
		columns: [
			{data: "unizSn"},
			{data: "unizTypeSn"},
			{data: "unizKeyword"},
			{data: "enable"}
		]
	});
}

