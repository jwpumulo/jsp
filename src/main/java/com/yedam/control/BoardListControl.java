package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
import com.yedam.dao.BoardDAO;
import com.yedam.vo.BoardVO;
import com.yedam.vo.PageVO;
import com.yedam.vo.SearchVO;

public class BoardListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		
		String pageNo = req.getParameter("page_no");
		pageNo = pageNo == null ? "1" : pageNo;
		
		String sc = req.getParameter("search_condition");
		String kw = req.getParameter("keyword");
		sc = sc == null ? "" : sc;
		kw = kw == null ? "" : kw;

		BoardDAO dao = new BoardDAO();
		SearchVO search = new SearchVO(Integer.parseInt(pageNo), sc, kw);

		List<BoardVO> list = dao.selectBoard(search);
		
		req.setAttribute("list", list);
		
		int totalCnt = dao.getTotalCnt(search);
		
		PageVO paging = new PageVO(Integer.parseInt(pageNo), totalCnt);
		
		req.setAttribute("paging", paging);
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		
		req.getRequestDispatcher("board/boardList.tiles").forward(req, resp);
	}
=======
import com.yedam.PageVO;
import com.yedam.dao.BoardDAO;
import com.yedam.dao.EmpDAO;
import com.yedam.vo.BoardVO;
import com.yedam.vo.Employee;
import com.yedam.vo.SearchVO;

public class BoardListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) //
			throws ServletException, IOException {
		// boardList.do?searchCondition=T&keyword=오늘
		String page = req.getParameter("page");
		page = page == null ? "1" : page;
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		sc = sc == null ? "" : sc; // null값처리.
		kw =kw == null ? "" : kw; // null값처리.
		
		// SearchVO : 파라미터.
		SearchVO search = new SearchVO(Integer.parseInt(page), sc, kw);

		String name = "홍길동";
		// boardList.do -> (BoardListControl) -> boardList.jsp
		req.setAttribute("msg", name);
		
		BoardDAO edao = new BoardDAO();
		List<BoardVO> list = edao.selectBoard(search);
		req.setAttribute("list", list);
		
		// 페이징.
		int totalCnt = edao.getTotalCount(); // 실제건수.
		PageVO paging = new PageVO(Integer.parseInt(page), totalCnt);
		req.setAttribute("paging", paging);

		//searchCondition keyword 전달.
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		
		
		// 요청재지정(url:boardList.do (boardList.jsp))
		req.getRequestDispatcher("/WEB-INF/views/boardList.jsp").forward(req, resp);

	}

>>>>>>> branch 'master' of https://github.com/jwpumulo/jsp.git
}
