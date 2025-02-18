package com.yedam.serv;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.StudentDAO;
import com.yedam.vo.Student;


//service()기능 구현
@WebServlet("/addStudentServ")
public class AddStudentServlet extends HttpServlet { //서블릿 상속
	
	// param의 값을 활용 > db입력
	// 처리성공 / 처리 실패 메세지
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");//요청정보의 한글처리
		resp.setContentType("text/html;charset=utf-8");

		String sno = req.getParameter("std_no"); // empNo의 param에 담겨있는 값 반환.
		String sname = req.getParameter("std_name");
		String tel = req.getParameter("tel_No");
		String addr = req.getParameter("std_addr");
		
		
		//매개값으로 Student 객체
		Student std = new Student();
		std.setStudentNo(sno);
		std.setStudentName(sname);
		std.setPhone(tel);
		std.setAddress(addr);
		
		
		// db등록.
		StudentDAO sdao = new StudentDAO();
	//			boolean result = sdao.registerEmp(new Student(Integer.parseInt(sno), sname, tel, addr));
				
				if (sdao.addStudent(std)) {
					resp.getWriter().print("처리성공");
				} else {
					resp.getWriter().print("처리실패");
				}
	}
}
	
	
	
	

