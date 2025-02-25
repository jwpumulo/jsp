package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.dao.MemberDAO;
import com.yedam.vo.MemberVO;

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		if (req.getMethod().equals("GET")) {

			req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);

		} else if (req.getMethod().equals("POST")) {

			String memberId = req.getParameter("member_id");
			String passwd = req.getParameter("passwd");

			MemberDAO dao = new MemberDAO();

			MemberVO member = dao.login(memberId, passwd);

			if (member != null) {
				if ("User".equals(member.getResponsibility())) {
					HttpSession session = req.getSession();
					session.setAttribute("loginId", memberId);
					resp.sendRedirect("boardList.do");

				} else if ("Admin".equals(member.getResponsibility())) {
					HttpSession session = req.getSession();
					session.setAttribute("loginId", memberId);
					resp.sendRedirect("memberList.do");

				}
			} else {

			}
		}
	}
=======
		// 요청방식(get/post)
		if (req.getMethod().equals("GET")) {
			// 1.로그인 화면.
			req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);

		} else if (req.getMethod().equals("POST")) {
			// 2. 로그인 기능.
			String id = req.getParameter("uname");
			String pw = req.getParameter("psw");

			// 로그인 체크.
			MemberDAO mdao = new MemberDAO();
			MemberVO mvo = mdao.login(id, pw);

			if (mvo != null) { // 로그인 성공.
				System.out.println("환영합니다. " + mvo.getMemberName());
				// 세션객체에 로그인 아이디를 저장.
				HttpSession session = req.getSession();
				session.setAttribute("loginId", id); // attribute 활용.
				resp.sendRedirect("boardList.do");
				
			} else { // 로그인 실패.
				System.out.println("id, pw 확인.");
			}

		}

	}

>>>>>>> branch 'master' of https://github.com/jwpumulo/jsp.git
}
