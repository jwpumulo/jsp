/**
 * 
 */

document.querySelector('button.btn-danger').addEventListener('click', function(e) {

	if ('${board.writer }' == '${loginId}') {
		location.href = 'removeBoard.do?board_no=${board.boardNo}';
	} else {
		alert('권한을 확인하세요');
	}

	//writer = document.querySelector('table.table>tbody>tr:nth-of-type(4)>td:nth-of-type(1)').innerText;
	//console.log(writer);

});

//function removeBoard(boardNo = int) {
//	console.log(bno);
//	location.href = "removeBoard.do?board_no=" + boardNo;
//}


service.replyList(boardNo, (result) => {
	const target = document.querySelector('div.content>ul');
	result.forEach((item) => {
		html = drawReply(item);
		target.insertAdjacentHTML('beforeend', html);
	})
}, (error) => console.log(error))

function drawReply(reply) {
	html = `<li>
			<span class="col-sm-2">${reply.replyNo}</span>
			<span class="col-sm-5">${reply.reply}</span>
			<span class="col-sm-2">${reply.replyer}</span>
			<span class="col-sm-2"><button type="button" class="btn btn-danger" onclick="removeReply(${reply.replyNo}, this)">삭제</button></span>
			</li>`;
	return html;
}

function addReply() {

	const boardNo = document.querySelector('input[name="board_no"]').value;
	const reply = document.querySelector('input[name="reply"]').value;
	const replyer = loginId;

	fetch('addReply.do?board_no=' + boardNo + "&reply=" + reply + "&replyer=" + replyer)
		.then((result) => {

			return result.json();
		})
		.then((result) => {

			console.log(result);

			if (result.retCode == "OK") {
				alert('등록 성공');
			} else if (result.retCode == "NG") {
				alert('등록 오류');
			} else {
				alert('?????????');
			}
		}).catch((err) => {
			console.log(err);
		});

}

function removeReply(replyNo, btn) {

	fetch('removeReply.do?reply_no=' + replyNo)
		.then(function(result) {

			return result.json();
		}).then((result) => {

			console.log(result);

			if (result.retCode == "OK") {
				btn.parentElement.parentElement.remove();
			} else if (result.retCode == "NG") {
				alert('삭제 오류');
			} else {
				alert('?????????');
			}
		}).catch((err) => {
			console.log(err);
		});

}