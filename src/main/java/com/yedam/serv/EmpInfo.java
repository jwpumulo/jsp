package com.yedam.serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.EmpDAO;
import com.yedam.vo.Employee;

@WebServlet("/empInfo")

@Override
public class EmpInfo extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException {

	resp.setContentType("text/html;charset=utf-8");
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
	
	String empNo = req.getParameter("emp_no");
	
	EmpDAO dao = new EmpDAO();
	Employee emp = dao.selectEmp(Integer.parseInt(empNo));
	
	PrintWriter out = resp.getWriter(); // 출력스트림.
	out.print("<table style='border: 1px black solid'>");
	
	if (emp != null ) {
		out.print("<tr><th>사번</th></tr>" + emp.getEmpNo()+"</td></tr>");
		out.print("<tr><th>이름</th></tr>" + emp.getEmpName()+"</td></tr>");
		out.print("<tr><th>연락처</th></tr>" + emp.getTelNo()+"</td></tr>");
		out.print("<tr><th>급여</th></tr>" + emp.getSalary()+"</td></tr>");
		out.print("<tr><th>입사일자</th></tr>" + sdf.format(emp.getHireDate())+"</td></tr>");
		
		
	}else {
		out.print("<tr><td>???</td></tr>");
	}
	out.print("</table>");
	out.print("<a href='sample'>목록으로</a>");
	
}
}