/**
 * 
 */
$(function() {
	$("#del").on('click', function() {
		var reviewUserId = $('#reviewUserId').val();
		var userId = $('#userId').val();
		if (reviewUserId != userId) {
			alert('投稿した人だけが編集できます');
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
});