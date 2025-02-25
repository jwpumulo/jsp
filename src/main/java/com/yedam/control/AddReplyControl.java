package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.yedam.dao.ReplyDAO;
import com.yedam.vo.ReplyVO;

public class AddReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		req.setCharacterEncoding("utf-8");

		//댓글내용, 작성자, 원본글번호
		String boardNo = req.getParameter("board_no");
		String reply = req.getParameter("reply");
		String replyer = req.getParameter("replyer");

		//매개값
		ReplyVO vo = new ReplyVO();
		vo.setBoardNo(Integer.parseInt(boardNo));
		vo.setReply(reply);
		vo.setReplyer(replyer);

	
		ReplyDAO dao = new ReplyDAO();

		Map<String, Object> result = new HashMap<>();

		if (dao.insertReply(vo)) {
			System.out.println(vo.getReplyNo());
			resp.getWriter().print("{\"retCode\": \"OK\"}");
		} else {
			resp.getWriter().print("{\"retCode\": \"NG\"}");
		}

		
		
		
		//json 생성
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(result);
		
		resp.getWriter().print(json);
	}

}
