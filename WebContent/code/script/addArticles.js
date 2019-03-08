var E = window.wangEditor;
var editor = new E('#editor');
// 或者 var editor = new E( document.getElementById('editor') )
editor.create();

window.onload = function () {
	var form = $('form');
	form.on('submit', function () {
		var header = $('#inputHead').val();
		var content = editor.txt.html();
		var file = $('#uploadFile').get(0).files[0];
		var sort = $('input:radio:checked').val();
		var priority = parseInt($('#priority').val());
		event.preventDefault();
		if (header!=undefined && content!=undefined && sort!=undefined && !isNaN(priority)) {
			var currentDate = new Date();
			var data = {
				someone: 'admin',
				estitle: header,
				esmessage: content,
				espicture: file,
				esdiffernt: sort,
				eslevel: priority,
				esdate: currentDate
			};
			console.log(data);
			$.ajax({
				type: 'POST',
				url: 'http://localhost:8080/ZJKou/addEssay.action',
				async: true,
				dataType:"JSON",
				contentType:"application/json",
				data: JSON.stringify({
//					someone: 'admin',
					esid:0,
					estitle:header,
					esmessage:content.toString(),
					espicture:"fgfgf",
					esdiffernt:sort,
					eslevel:priority,
					esdate:null,
					esfacepicture:"fgfdg"
				}),
				success: function (response) {
					alert('提交成功！');
				},
				error: function (errorText, errorType) {
					alert('数据请求失败，错误为：' + errorText.statusText);
				}
			});
		} else {
			alert('请将信息填写完整且正确！');
		}
	});
}
