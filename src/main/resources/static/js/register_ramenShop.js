//郵便番号検索
$(function() {
	$('#btn').on('click',function(){
		$.ajax({
			url: "http://zipcloud.ibsnet.co.jp/api/search?zipcode=" 
				+ $('#zipcode').val(),
			dataType : 'jsonp',
		}).done(function(data) {
			if (data.results) {
				setData(data.results[0]);
			} else {
				alert('該当するデータが見つかりませんでした');
			}
		}).fail(function(data){
			alert('通信に失敗しました');
		});
			function setData(data) {
				$('#prefecture').val(data.address1);
				$('#city').val(data.address2);
				$('#other').val(data.address3);
			}
	});
});

//営業時間：月曜日
$(function(){
	$("#forMon").hide();
	$("#forMonNight").hide();
	$("#mon").on('click',function(){
		$("#forMon").toggle();
	})
	$("#btnForMon").on('click',function(){
		$("#forMonNight").show();
	})
});