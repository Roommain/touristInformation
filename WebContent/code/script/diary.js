window.onload = function () {
	var table = $('table');
	var tbody = $('tbody', table);
	var dataArray = new Array();
	var pageNumber = 1;
	// 获取页面数据
	$.ajax({
		type: 'POST',
		url: 'http://120.77.170.77:8080/ZJKou/showHistory.action',
		async: true,
		'contentType' : 'application/json',
		data: JSON.stringify({
			pageNum: pageNumber,
			esdifferent: ''
		}),
		success: function (response) {
			for (var i = 0; i < response.list.length; i++) {
				dataArray[i] = '<tr><td>'+response.list[i].hid +'</td><td>'+response.list[i].hpeosomething+'</td><td>'+response.list[i].htime+'</td><td><button type="button" onclick="window.location.href=' + turnPage + '"><i class="iconfont">&#xe60a;</i></button>  <button<i class="iconfont">&#xe67e;</i></button></td></tr>';
			};
			for (var i = 0; i < dataArray.length; i++) {
				$('tbody').append(dataArray[i]);
			};
		},
		error: function (errorText, errorType) {
			alert('数据请求失败，错误为：' + errorText.statusText);
		}
	});
}
