function newUserCnt(){
	$.ajax({
		async: false,
		url: "/admin/main/newUserCnt",
		type: "get", 
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		data: false,
		dataType: "json",
		success: function(data){
			$("#newUserCnt").html(number_format(data.cnt) + " 명");
		},
		error: function(request, status, error){
			console.log("code:" + request.status);
			console.log("message:" + request.responseText);
			console.log("error:" + error);
		}
	});
}
function boardWriteCnt(){
	$.ajax({
		async: false,
		url: "/admin/main/boardWriteCnt",
		type: "get", 
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		data: false,
		dataType: "json",
		success: function(data){
			$("#boardWriteCnt").html(number_format(data.cnt) + " 건");
		},
		error: function(request, status, error){
			console.log("code:" + request.status);
			console.log("message:" + request.responseText);
			console.log("error:" + error);
		}
	});
}

function channelCreateCnt(){
	$.ajax({
		async: false,
		url: "/admin/main/channelCreateCnt",
		type: "get", 
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		data: false,
		dataType: "json",
		success: function(data){
			$("#channelCreateCnt").html(number_format(data.cnt) + " 건");
		},
		error: function(request, status, error){
			console.log("code:" + request.status);
			console.log("message:" + request.responseText);
			console.log("error:" + error);
		}
	});
}

function regVideoCnt(){
	$.ajax({
		async: false,
		url: "/admin/main/regVideoCnt",
		type: "get", 
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		data: false,
		dataType: "json",
		success: function(data){
			$("#regVideoCnt").html(number_format(data.cnt) + " 건");
		},
		error: function(request, status, error){
			console.log("code:" + request.status);
			console.log("message:" + request.responseText);
			console.log("error:" + error);
		}
	});
}
function dailyMemberAmount(){
	$.ajax({
		async: false,
		url: "/admin/main/dailyMemberAmount",
		type: "get", 
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		data: false,
		dataType: "json",
		success: function(data){
			var dateList = [];
			var amountList = [];
			$.each(data, function(index, item){
				$.each(item, function(index, jsonData){
					dateList.push(jsonData.createDateTime);
					amountList.push(jsonData.amount);
				});
			});
			let ctx = document.getElementById("myAreaChart");
			chart(dateList, amountList, ctx);
		},
		error: function(request, status, error){
			console.log("code:" + request.status);
			console.log("message:" + request.responseText);
			console.log("error:" + error);
		}
	});
}

function dailyChannelAmount(){
	$.ajax({
		async: false,
		url: "/admin/main/dailyChannelAmount",
		type: "get", 
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		data: false,
		dataType: "json",
		success: function(data){
			var dateList = [];
			var amountList = [];
			$.each(data, function(index, item){
				$.each(item, function(index, jsonData){
					dateList.push(jsonData.createDateTime);
					amountList.push(jsonData.amount);
				});
			});
			
			
			chart2(dateList, amountList);
		},
		error: function(request, status, error){
			console.log("code:" + request.status);
			console.log("message:" + request.responseText);
			console.log("error:" + error);
		}
	});
}

//pie차트
$.getJSON("http://localhost:8080/admin/main/pieChart", function(data){
	
	$.each(data, function(inx, obj){

		chartPieLabels.push(obj.unizKeyword);

		chartPieData.push(obj.count);

	});
	
	pieChart();

	console.log("create Chart")

});

function number_format(number, decimals, dec_point, thousands_sep) {
	// * example: number_format(1234.56, 2, ',', ' ');
	// * return: '1 234,56'
	number = (number + '').replace(',', '').replace(' ', '');
	var n = !isFinite(+number) ? 0 : +number, prec = !isFinite(+decimals) ? 0
			: Math.abs(decimals), sep = (typeof thousands_sep === 'undefined') ? ','
			: thousands_sep, dec = (typeof dec_point === 'undefined') ? '.'
			: dec_point, s = '', toFixedFix = function(n, prec) {
		var k = Math.pow(10, prec);
		return '' + Math.round(n * k) / k;
	};
	// Fix for IE parseFloat(0.55).toFixed(0) = 0;
	s = (prec ? toFixedFix(n, prec) : '' + Math.round(n)).split('.');
	if (s[0].length > 3) {
		s[0] = s[0].replace(/\B(?=(?:\d{3})+(?!\d))/g, sep);
	}
	if ((s[1] || '').length < prec) {
		s[1] = s[1] || '';
		s[1] += new Array(prec - s[1].length + 1).join('0');
	}
	return s.join(dec);
}

Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#858796';

function chart(dateList, amountList){
	var ctx = document.getElementById("myAreaChart");
	var myLineChart = new Chart(
		ctx, {
			type : 'line',
			data : {
				labels : dateList,
				datasets : [ {
					label : "회원수",
					lineTension : 0.3,
					backgroundColor : "rgba(78, 115, 223, 0.5)",
					borderColor : "rgba(78, 115, 223, 1)",
					pointRadius : 3,
					pointBackgroundColor : "rgba(78, 115, 223, 1)",
					pointBorderColor : "rgba(78, 115, 223, 1)",
					pointHoverRadius : 3,
					pointHoverBackgroundColor : "rgba(78, 115, 223, 1)",
					pointHoverBorderColor : "rgba(78, 115, 223, 1)",
					pointHitRadius : 10,
					pointBorderWidth : 2,
					data : amountList,
				} ],
			},
			options : {
				maintainAspectRatio : false,
				layout : {
					padding : {
						left : 10,
						right : 25,
						top : 25,
						bottom : 0
					}
				},
				scales : {
					xAxes : [ {
						time : {
							unit : 'date'
						},
						gridLines : {
							display : false,
							drawBorder : false
						},
						ticks : {
							maxTicksLimit : 7
						}
					} ],
					yAxes : [ {
						ticks : {
							maxTicksLimit : 5,
							padding : 10,
							// Include a dollar sign in the ticks
							callback : function(value, index, values) {
								return number_format(value) + '명';
							}
						},
						gridLines : {
							color : "rgb(234, 236, 244)",
							zeroLineColor : "rgb(234, 236, 244)",
							drawBorder : false,
							borderDash : [ 2 ],
							zeroLineBorderDash : [ 2 ]
						}
					} ],
				},
				legend : {
					display : false
				},
				tooltips : {
					backgroundColor : "rgb(255,255,255)",
					bodyFontColor : "#858796",
					titleMarginBottom : 10,
					titleFontColor : '#6e707e',
					titleFontSize : 14,
					borderColor : '#dddfeb',
					borderWidth : 1,
					xPadding : 15,
					yPadding : 15,
					displayColors : false,
					intersect : false,
					mode : 'index',
					caretPadding : 10,
					callbacks : {
						label : function(tooltipItem, chart) {
							var datasetLabel = chart.datasets[tooltipItem.datasetIndex].label || '';
							return datasetLabel + ': ' + number_format(tooltipItem.yLabel) + '명';
						}
					}
				}
			}
		});
}

function chart2(dateList, amountList){
	let ctx = document.getElementById("myAreaChart2");
	var myLineChart = new Chart(
		ctx, {
			type : 'line',
			data : {
				labels : dateList,
				datasets : [ {
					label : "채널",
					lineTension : 0.3,
					backgroundColor : "rgba(78, 115, 223, 0.5)",
					borderColor : "rgba(78, 115, 223, 1)",
					pointRadius : 3,
					pointBackgroundColor : "rgba(78, 115, 223, 1)",
					pointBorderColor : "rgba(78, 115, 223, 1)",
					pointHoverRadius : 3,
					pointHoverBackgroundColor : "rgba(78, 115, 223, 1)",
					pointHoverBorderColor : "rgba(78, 115, 223, 1)",
					pointHitRadius : 10,
					pointBorderWidth : 2,
					data : amountList,
				} ],
			},
			options : {
				maintainAspectRatio : false,
				layout : {
					padding : {
						left : 10,
						right : 25,
						top : 25,
						bottom : 0
					}
				},
				scales : {
					xAxes : [ {
						time : {
							unit : 'date'
						},
						gridLines : {
							display : false,
							drawBorder : false
						},
						ticks : {
							maxTicksLimit : 7
						}
					} ],
					yAxes : [ {
						ticks : {
							maxTicksLimit : 5,
							padding : 10,
							// Include a dollar sign in the ticks
							callback : function(value, index, values) {
								return number_format(value) + '개';
							}
						},
						gridLines : {
							color : "rgb(234, 236, 244)",
							zeroLineColor : "rgb(234, 236, 244)",
							drawBorder : false,
							borderDash : [ 2 ],
							zeroLineBorderDash : [ 2 ]
						}
					} ],
				},
				legend : {
					display : false
				},
				tooltips : {
					backgroundColor : "rgb(255,255,255)",
					bodyFontColor : "#858796",
					titleMarginBottom : 10,
					titleFontColor : '#6e707e',
					titleFontSize : 14,
					borderColor : '#dddfeb',
					borderWidth : 1,
					xPadding : 15,
					yPadding : 15,
					displayColors : false,
					intersect : false,
					mode : 'index',
					caretPadding : 10,
					callbacks : {
						label : function(tooltipItem, chart) {
							var datasetLabel = chart.datasets[tooltipItem.datasetIndex].label || '';
							return datasetLabel + ': ' + number_format(tooltipItem.yLabel) + '개';
						}
					}
				}
			}
		});
}
var chartPieLabels = [];
var chartPieData = [];

function pieChart(){

	let myChartOne = document.getElementById("myAreaChart3");

	let barChart = new Chart(myChartOne, {
	    type: 'pie',
	    data: {
	        labels: chartPieLabels,
	        datasets: [{
	            label: '시청순위',
	            data : chartPieData,
	            backgroundColor: [
	                "#E45E56",
	                "#FF914C",
	                "#860B5E",
	                "#BA305C",
	                "#4B0156",
	                "#4D3D8F",
	                "#3F6EC1",
	                "#00CEFF",
	                "#1B9EE6",
	                "#E45E56",
	                "#1E9FE4"
	            ],
	            borderColor: [
	            	"#E45E56",
	                "#FF914C",
	                "#860B5E",
	                "#BA305C",
	                "#4B0156",
	                "#4D3D8F",
	                "#3F6EC1",
	                "#00CEFF",
	                "#1B9EE6",
	                "#E45E56",
	                "#1E9FE4"
	            ],
	            borderWidth: 1
	        }]
	    },
	    options: {
	        title: {
	            display: 'true',
	            text: '영상 카테고리 별 그래프',
	            fontSize: 20,
	            fontColor: '#7460ee'
	        },
	        /* legend: {
	            display: true,
	            position: 'top' // right, left, bottom, top
	        }, */
	        tooltips: {
	            enabled: true
	        }
	    }
	})
	};