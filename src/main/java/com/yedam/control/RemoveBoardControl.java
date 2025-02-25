package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.BoardDAO;

public class RemoveBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		
		int boardNo = Integer.parseInt(req.getParameter("board_no"));
		
		BoardDAO dao = new BoardDAO();
		
		if (dao.deleteBoard(boardNo)) {
			resp.sendRedirect("boardList.do");
		} else {
			
		}
=======
		// ?bno=25
		String bno = req.getParameter("bno");
		
		BoardDAO bdao = new BoardDAO();
		if(bdao.deleteBoard(Integer.parseInt(bno))) {
			resp.sendRedirect("boardList.do");
		} else {
			System.out.println("처리실패.");
		}

>>>>>>> branch 'master' of https://github.com/jwpumulo/jsp.git
	}

}
