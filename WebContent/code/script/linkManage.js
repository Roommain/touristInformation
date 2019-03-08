window.onload = function () {
	var table = $('table');
	var tbody = $('tbody', table);
	var dataArray = new Array();
	var turnPage = './editLink.html';
	var storage = window.localStorage;
	var pageNumber = 1;
	// 获取页面数据
	$.ajax({
		type: 'POST',
		url: '/ZJKou/addInterfacen.action',
		async: true,
		'contentType': 'application/json',
		data: JSON.stringify({
			someone: storage['userName']
		}),
		success: function (response) {
			for (var i = 0; i < response.list.length; i++) {
				dataArray[i] = '<tr><td>'+response.list[i].interid +'</td><td>'+response.list[i].intername+'</td><td>'+response.list[i].interaddress+'</td><td>'+response.list[i].interprir+'</td><td>'+response.list[i].intertime+'</td><td><button type="button" onclick="window.location.href=' + turnPage + '"><i class="iconfont">&#xe60a;</i></button>  <button<i class="iconfont">&#xe67e;</i></button></td></tr>';
			};
			for (var i = 0; i < dataArray.length; i++) {
				$('tbody').append(dataArray[i]);
			};
		},
		error: function (errorText, errorType) {
			alert('数据请求失败，错误为：' + errorText.statusText);
		}
	});
	// 给按钮绑定点击事件
	var buttons = $('button', table);
	buttons.each(function () {
		for (var i = 0; i < (buttons.length / 2); i++) {
			buttons[2*i].click(function () {
				if (window.confirm("是否确认删除?")) {
					$.ajax({
						type: 'POST',
						url: 'http://120.77.177.77:8080/ZJKou/delInterfacen.action',
						data: {
							carid: this.parent().child().eq(0).val()
						},
						success: function (response) {
							if (response == 0) {
								alert('删除成功！');
							} else {
								alert('删除失败，请重试！');
							}
						},
						error: function (errorText, errorType) {
							alert('数据请求失败，错误为：' + errorText.statusText);
						}
					});
					window.location.href = '../back/linkManage.html';
				}
			});
		};
	})
	$('input').eq(0).keyup(function(){
	    search(this.val());
	});
	//搜索功能,提交ajax数据到后台
	// function search(key){
	//     var datas = {'intertitle': key};
	//     $.ajax({
	//         url: 'http://120.77.177.77:8080/ZJKou/searchInterfacen.action',
	//         data: datas,
	//         type: 'POST',
	//         dataType: 'json',
	//         success: function (data) {
	//         		$('tbody').innerHTML = "";
	//                	for (var i = 0; i < response.list.length; i++) {
	// 			dataArray[i] = '<tr><td>'+response.list[i].interid +'</td><td>'+response.list[i].intername+'</td><td>'+response.list[i].interaddress+'</td><td>'+response.list[i].interprir+'</td><td>'+response.list[i].intertime+'</td><td><button type="button" onclick="window.location.href=' + turnPage + '"><i class="iconfont">&#xe60a;</i></button>  <button<i class="iconfont">&#xe67e;</i></button></td></tr>';
	// 		};
	// 		for (var i = 0; i < dataArray.length; i++) {
	// 			$('tbody').append(dataArray[i]);
	// 		};
	//             }
	//     });
	// }
}
