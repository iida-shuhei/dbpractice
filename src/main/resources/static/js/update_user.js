/**
 * 
 */
$(function() {
	$("#del").on('click', function() {
		var userId = $('#userId').val();
		var result = window.confirm('本当に削除しますか？');
		if(result) {
			return true;
		} else {
			return false;
		}
	});
});