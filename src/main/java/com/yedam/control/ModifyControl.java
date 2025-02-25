package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD

import com.yedam.dao.BoardDAO;
import com.yedam.vo.BoardVO;

public class ModifyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int boardNo = Integer.parseInt(req.getParameter("board_no"));

		BoardDAO dao = new BoardDAO();

		BoardVO board = dao.getBoard(boardNo);

		String loginId = (String) req.getSession().getAttribute("loginId");

		req.setAttribute("board", board);

		if (!board.getWriter().equals(loginId)) {
			
			req.setAttribute("msg", "권한을 확인하세요");
			req.getRequestDispatcher("board/board.tiles").forward(req, resp);

		} else {

			req.getRequestDispatcher("board/modifyBoard.tiles").forward(req, resp);
		}

	}

}
=======
import javax.servlet.http.HttpSession;

import com.yedam.dao.BoardDAO;
import com.yedam.vo.BoardVO;

public class ModifyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 수정화면 open.
		String bno = req.getParameter("bno");
		
		BoardDAO bdao = new BoardDAO();
		BoardVO board = bdao.getBoard(Integer.parseInt(bno)); // 문자열 "14" -> int 14
		
		// 세션아이디 vs. 글작성 아이디.
		HttpSession session = req.getSession();
		String sessionId = (String) session.getAttribute("loginId");
		String writerId = board.getWriter();
		
		if (!sessionId.equals(writerId)) {
			req.setAttribute("msg", "권한을 확인하세요.");
			req.setAttribute("board", board);
			req.getRequestDispatcher("/WEB-INF/views/board.jsp").forward(req, resp);
			return;
		}
		
		// 요청정보의 attribute활용.
		req.setAttribute("board", board); //
		req.getRequestDispatcher("/WEB-INF/views/modifyBoard.jsp").forward(req, resp);
	}

}

>>>>>>> branch 'master' of https://github.com/jwpumulo/jsp.git
