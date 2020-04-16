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
			alert('本当に削除しますか？');
			return true;
		}
	});
});