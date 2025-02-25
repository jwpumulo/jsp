package com.yedam.serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.EmpDAO;
import com.yedam.vo.Employee;

<<<<<<< HEAD
// was : init service destroy

public class SampleServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
//		super.init(config);

		System.out.println("init called");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.service(req, resp);

		System.out.println("service called");

		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		EmpDAO dao = new EmpDAO();
		List<Employee> list = dao.search(new Employee());

		for (Employee emp : list) {
			out.print("<p><a href='empInfo?emp_no=" + emp.getEmpNo() + "'>" + emp.getEmpNo() + "</a> / " + emp.getEmpName() + "</p>");
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
//		super.destroy();

		System.out.println("destroy called");
=======
/*
 * 서블릿 생성(http 프로토콜 통해 웹브라우저 출력)
 * 1. HttpServlet 을 상속.
 * 2. WebApplicationServer(WAS) => tomcat.
 * 3. WAS의 실행 1)init 2)service 3)destroy
 */
public class SampleServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 호출. 최초한번만 실행.");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service 호출. 호출마다 실행.");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter(); // 출력스트림 생성.
		for (int i = 1; i <= 3; i++)
			out.print("<h3>Hello</h3>");

		// 사원목록 출력.
		EmpDAO edao = new EmpDAO();
		List<Employee> list = edao.search(new Employee());
		for (Employee emp : list) {
			out.print("<p>사번: <a href=''>" + emp.getEmpNo() + "</a>, 이름: "+ emp.getEmpName()+"</p>");
		}
//		out.print("<script>alert('hi')</script>");
	}

	@Override
	public void destroy() {
		System.out.println("서버가 종료됩니다.");
>>>>>>> branch 'master' of https://github.com/jwpumulo/jsp.git
	}
}
