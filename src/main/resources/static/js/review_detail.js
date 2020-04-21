/**
 * 
 */
$(function() {
	$("#del").on('click', function() {
		var reviewUserId = $('#reviewUserId').val();
		var userId = $('#userId').val();
		if (reviewUserId != userId) {
			alert('投稿した人だけが削除できます');
			return false;
		} else {
			var result = window.confirm('本当に削除しますか？');
			if(result) {
				return true;
			} else {
				return false;
			}
		}
	});
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
});