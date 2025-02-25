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

public class ModifyBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		req.setCharacterEncoding("utf-8");
		
		//이미지 갱신 시 기존 이미지 처리
		
		String saveDir = req.getServletContext().getRealPath("images");
		MultipartRequest mr = new MultipartRequest(req, saveDir, 1024*1024*5, "utf-8",new DefaultFileRenamePolicy());
		
		BoardVO board = new BoardVO();
		board.setBoardNo(Integer.parseInt(mr.getParameter("board_no")));
		board.setTitle(mr.getParameter("title"));
		board.setContent(mr.getParameter("content"));
		board.setImg(mr.getFilesystemName("img"));
		
		BoardDAO dao = new BoardDAO();
		
		if (dao.updateBoard(board)) {
			resp.sendRedirect("boardList.do");
		} else {
			
		}
	}
=======
import com.yedam.dao.BoardDAO;
import com.yedam.vo.BoardVO;

public class ModifyBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ?bno=25&title=ffff&content=ffff
		String bno = req.getParameter("bno");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		BoardVO board = new BoardVO(); // 메소드의 파라미터.
		board.setBoardNo(Integer.parseInt(bno));
		board.setTitle(title);
		board.setContent(content);
		
		
		BoardDAO bdao = new BoardDAO();
		if (bdao.updateBoard(board)) { // 목록이동.
			resp.sendRedirect("boardList.do");
		} else {
			System.out.println("처리실패.");
		}

	}

>>>>>>> branch 'master' of https://github.com/jwpumulo/jsp.git
}
