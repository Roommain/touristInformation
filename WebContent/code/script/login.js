window.onload = function () {
	var form = $('form');
	var storage = window.localStorage;
	form.on('submit', function () {
		var userName = $('#userName').val();
		var psd = $('#psd').val();
		var sort = $('input:radio:checked').val();
		event.preventDefault();
		if (sort=='admin') {
			console.log('admin1');
			$.ajax({
				type: 'GET',
				url: 'http://localhost:8080/ZJKou/managelogin.action?mananame='+userName.toString()+'&password='+psd.toString(),
				async: true,
				'contentType': 'application/json',
//				data: JSON.stringify({
//					mananame: userName.toString(),
//					password: psd.toString()
//				}),
				success: function (response) {
					storage['userName'] = userName;
					storage['isStoreName'] =  'yes'; 
					window.location.href = '../back/addArticles.html';
				},
				error: function (errorText, errorType) {
					alert('数据请求失败，错误为：' + errorText.statusText);
				}
			});
		} else if(sort=='editor') {
			$.ajax({
				type: 'POST',
				url: 'http://120.77.170.77:8080/ZJKou/editorlogin.action',
				async: true,
				'contentType' : 'application/json',
				data: JSON.stringify({
					editorname: userName,
					password: psd
				}),
				success: function (response) {
					storage['userName'] = userName;
					storage['isStoreName'] =  'yes';
					window.location.href = '../back/addArticles.html';
				},
				error: function (errorText, errorType) {
					alert('数据请求失败，错误为：' + errorText.statusText);
				}
			});
		} else {
			alert('请选择登录身份！');
		}
	});
}
