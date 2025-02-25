package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.BoardDAO;
import com.yedam.vo.BoardVO;

public class BoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		
		int boardNo = Integer.parseInt(req.getParameter("board_no"));
		
		BoardDAO dao = new BoardDAO();

		dao.updateViewCnt(boardNo);
		
		BoardVO board = dao.getBoard(boardNo);
		
		req.setAttribute("board", board);
	
		req.getRequestDispatcher("board/board.tiles").forward(req, resp);
=======
		// board.do?bno=12
		String bno = req.getParameter("bno");
		
		BoardDAO bdao = new BoardDAO();
		BoardVO board = bdao.getBoard(Integer.parseInt(bno)); // 문자열 "14" -> int 14
		bdao.updateCount(Integer.parseInt(bno));
		
		// 요청정보의 attribute활용.
		req.setAttribute("board", board); //
		req.getRequestDispatcher("/WEB-INF/views/board.jsp").forward(req, resp);

>>>>>>> branch 'master' of https://github.com/jwpumulo/jsp.git
	}

}
