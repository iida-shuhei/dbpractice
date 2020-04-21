//いいねボタン
$("#review").on('click',function(){
	var reviewId = $('#review').val();
	var userId = $('#user').val();
	
	console.log("ユーザー"　+userId)
	console.log(reviewId)
	
	$.ajax({
		type : 'POST',
		url : '/good',
		data : {
			reviewId : reviewId,
			userId : userId
		},
		dataType : 'json'
	}).done(function(data){
		var id = $('#review').val();
		$.ajax({
			type : 'POST',
			url : '/countGood',
			data : {
				reviewId : reviewId
			},
			dataType : 'json'
		}).done(function(data){
			$("#textGood").html("<span>" + data + "<span>");
		})
	})
});