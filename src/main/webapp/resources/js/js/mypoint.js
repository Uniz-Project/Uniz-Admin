function formChange(){
	$("#id").val(rowData.id);
	$("#unizSN").val(rowData.unizSN);
	$("#unizKeyword").val(rowData.unizKeyword);
	$("#point").val(rowData.point);
	
	$("#btnIns").attr("disabled", "disabled");
	$("#btnIns").css("opacity","0.3");
	$("#btnIns").removeAttr("onClick");
	
	$("#btnUpd").removeAttr("disabled");
	$("#btnUpd").removeAttr("style");
	$("#btnUpd").attr("onClick", "codeUpdate();");
}
function formChange2(){
	$("#id").val(rowData.id);
	$("#tableData1").val(rowData.wnizSn);
	$("#tableData2").val(rowData.unizSn);
	$("#tableData3").val(rowData.maxUnizPoint);
	$("#tableData4").val(rowData.minUnizPoint);
	$("#tableData5").val(rowData.priority);
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
	$("#tableData1").val("");
	$("#tableData2").val("");
	$("#tableData3").val("");
	$("#tableData4").val("");
	$("#tableData5").val("");

//	$("#unizSn").removeAttr("readonly");
	$("#tableData2").removeAttr("readonly");
	$("#tableData3").removeAttr("readonly");
	
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
function formClear2(){
	$("#tableData1").val("");
	$("#tableData2").val("");
	$("#tableData3").val("");
	$("#tableData4").val("");
	$("#tableData5").val("");

//	$("#unizSn").removeAttr("readonly");
	$("#tableData2").removeAttr("readonly");
	$("#tableData3").removeAttr("readonly");
	
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
	
	$("#btnIns").attr("onClick", "uwInsert();");
	$("#btnDel").attr("onClick", "uwDelete();");
	
}

function codeList(){
	
	let userSN = $("#userSN").val();
	
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
			"url": "/admin/member/uniz/"+userSN,
			"type" :"POST",
			"dataType" : "json"
		},
		columns: [
			{data: "unizSN"},
			{data: "unizKeyword"},
			{data: "point"},
			{data: "createDateTime"},
			{data: "updateDateTime"}
		]
	});
}

function codeInsert(){
	
		alert("미구현");
//		$("#tableData1").val("00")
//		$("#tableData3").val("00"); //임시
//		
//		var codeForm = $("#codeForm").serialize();
//		
//		console.log("codeForm: "+codeForm);
//		$.ajax({
//			url: "/admin/wniz/wnizinsert",
//			type: "post", 
//			contentType: "application/x-www-form-urlencoded; charset=utf-8",
//			data: codeForm,
//			dataType: "json",
//			success: function(data){
//				if(data.result === "success"){
//					$("#codeTable").DataTable().ajax.reload();
//					formClear();
//					alert("정상적으로 입력되었습니다.");
//				} else if(data.result === "duplicate"){
//					alert("이미 해당 코드로 입력된 자료가 있습니다.\n확인 후 다시 시도해 주세요.");
//				} else {
//					alert("데이터 입력 중 오류가 발생하였습니다.\n입력한 정보를 다시 확인해 주세요.");
//				}
//			},
//			error: function(request, status, error){
//				console.log(request);
//				console.log("code:" + request.status);
//				console.log("message:" + request.responseText);
//				console.log("error:" + error);
//			}
//		});
	
}

function codeUpdate(){
	
	alert("미구현");
	/*var codeForm = $("#codeForm").serialize();
	console.log(codeForm);
	
	$.ajax({
		url: "/admin/wniz/wnizupdate",
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
	});*/
}

function codeDelete(){
	
	alert("미구현");
	/*var codeForm = $("#codeForm").serialize();
	
	console.log(codeForm);
	
	$.ajax({
		url: "/admin/wniz/wnizdelete",
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
	});*/
}

