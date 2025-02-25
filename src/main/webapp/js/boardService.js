/**
 * 
 */

const service = {
	replyList: function(boardNo, successCallback, errorCallback) {
		fetch('replyList.do?board_no=' + boardNo)
			.then(function(result) {
				return result.json();
			}).then(successCallback)
			.catch(errorCallback)

	},
	addReply() {

	},
	removeReply() {

	}
}