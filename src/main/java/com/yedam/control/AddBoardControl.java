package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.dao.BoardDAO;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		req.setCharacterEncoding("utf-8");
		
		String saveDir = req.getServletContext().getRealPath("images");
		MultipartRequest mr = new MultipartRequest(req, saveDir, 1024*1024*5, "utf-8", new DefaultFileRenamePolicy());
		
		BoardVO board = new BoardVO();

		board.setTitle(mr.getParameter("title"));
		board.setContent(mr.getParameter("content"));
		board.setWriter(mr.getParameter("writer"));
		board.setImg(mr.getFilesystemName("img"));

		BoardDAO dao = new BoardDAO();
		if (dao.insertBoard(board)) {
			resp.sendRedirect("boardList.do");
		} else {
			
		}
	}
=======
import com.yedam.dao.BoardDAO;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 3개 파라미터 활용 db 저장. 목록으로 이동.
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");

		// 매개값으로 활용.
		BoardVO bvo = new BoardVO();
		bvo.setTitle(title);
		bvo.setContent(content);
		bvo.setWriter(writer);

		BoardDAO bdao = new BoardDAO();
		if (bdao.insertBoard(bvo)) {
			// forward(매개값 활용) vs. redirect(매개값을 전달못함)
			resp.sendRedirect("boardList.do");
		} else {
			System.out.println("실패");
		}

	}

>>>>>>> branch 'master' of https://github.com/jwpumulo/jsp.git
}
