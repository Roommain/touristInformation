// 轮播
var ppt = document.querySelector('#ppt'),
	button = document.querySelector('#button'),
	btn = button.querySelectorAll('div'),
	img = ppt.querySelectorAll('div'),
	len = img.length,
	timer = null,
	index = 0;

[].forEach.call(img, function (item) {
	item.style.width = (100 / len) + '%';
});
ppt.style.left = '0%';
ppt.style.width = (100 * len) + '%';

//自动播放函数autoPlay
function autoPlay () {
	setInterval(function() {
		show(index);
	},2500);
}
autoPlay();//应用

//图片切换
function show (a) {
	index = a;

	var left = ppt.style.left;
	if (index < len - 1) {
		// 切换到下一张图片
		ppt.style.left = (parseInt(left) - 100) + '%';
		index ++;
	}
	else if (index == len - 1) {
		ppt.style.left = '0%';
		index = 0;
	}
	for (var i = 0; i < btn.length; i++)
		btn[i].className = 'btn';
	btn[index].className = 'current';
}
// 页面内容
window.onload = function () {
	// 旅游要闻
	var head = $('#travelNews .abstractInfo h4')[0];
	var absContent = $('#travelNews .abstractInfo p')[0];
	var travelNewsDate = $('#travelNews .abstractInfo .date')[0];
	var travelPic = $('#travelNews .pic img')[0];
	var travelNewsMore = $('#travelNews .moreHeader ul a');
	$.ajax({
		type: 'POST',
		url: '',
		async: false,
		'contentType': 'application/json',
		data: JSON.stringify({
			esdifferent: '旅游要闻'
		}),
		success: function (res) {
			head.innerHTML = res.list[0].estitle;
			absContent.innerHTML = res.list[0].esmessage.substring(0, 200) + '...';
			travelNewsDate.innerHTML = res.list[0].esdate;
			travelPic.src = res.list[0].esfacepicture;
			for (var i = 1; i < 7; i++) {
				travelNewsMore[i-1].innerHTML = res.list[i].estitle.substring(0, 28) + '...';
			}
		},
		error: function (errorText, errorType) {
			console.log(errorText);
		}
	});
	// 旅游资讯
	var travelInfoHead = $('#travelInfo .travelInfoDiv h4');
	var travelInfoAbsContent = $('#travelInfo .travelInfoDiv p');
	$.ajax({
		type: 'POST',
		url: '',
		async: false,
		'contentType': 'application/json',
		data: JSON.stringify({
			esdifferent: '综合信息'
		}),
		success: function (res) {
			for (var i = 0; i < 3; i++) {
				travelInfoHead[i].innerHTML = res.list[i].estitle.substring(0, 34) + '...';
				travelInfoAbsContent[i].innerHTML = res.list[i].esmessage.substring(0, 200) + '...';
			}
		},
		error: function (errorText, errorType) {
			console.log(errorText);
		}
	});
	// 机关党建
	var partyHead = $('#party .abstractInfo h4')[0];
	var partyAbsContent = $('#party .abstractInfo p')[0];
	var partyDate = $('#party .abstractInfo .date')[0];
	var partyPic = $('#party .pic img')[0];
	var partyMore = $('#party .moreHeader ul a');
	$.ajax({
		type: 'POST',
		url: '',
		async: false,
		'contentType': 'application/json',
		data: JSON.stringify({
			esdifferent: '机关党建'
		}),
		success: function (res) {
			partyHead.innerHTML = res.list[0].estitle;
			partyAbsContent.innerHTML = res.list[0].esmessage.substring(0, 200) + '...';
			partyDate.innerHTML = res.list[0].esdate;
			partyPic.src = res.list[0].esfacepicture;
			for (var i = 1; i < 7; i++) {
				partyMore[i-1].innerHTML = res.list[i].estitle.substring(0, 28) + '...';
			}
		},
		error: function (errorText, errorType) {
			console.log(errorText);
		}
	});
	// 玩遍张家口
	var tourHead = $('#tour .tourInfo p');
	var tourPic = $('#tour .tourPicture img')[0];
	$.ajax({
		type: 'POST',
		url: '',
		async: false,
		'contentType': 'application/json',
		data: JSON.stringify({
			esdifferent: '市内美景'
		}),
		success: function (res) {
			for (var i = 0; i < 6; i++) {
				tourHead[i].innerHTML = res.list[i].estitle.substring(0, 28) + '...';
				tourPic[i].src = res.list[i].esfacepicture;
			}
		},
		error: function (errorText, errorType) {
			console.log(errorText);
		}
	});
	// 网上办公
	var onlineWorkName = $('#onlineWork ul a');
	var onlineWorkLink = $('#onlineWork ul a');
	$.ajax({
		type: 'POST',
		url: 'http://120.77.177.77:8080/ZJKou/showInterfacen.action',
		async: false,
		'contentType': 'application/json',
		data: JSON.stringify({
			pageNum: 1
		}),
		success: function (res) {
			for (var i = 0; i < 6; i++) {
				onlineWorkName[i].innerHTML = res.list[i].intername;
				onlineWorkLink[i].href = res.list[i].interaddress;
			}
		},
		error: function (errorText, errorType) {
			console.log(errorText);
		}
	});
}