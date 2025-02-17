package com.yedam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/empInfo")
public class GetEmployeeServ extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파라미터(?eno=1001)
		resp.setContentType("text/html;charset=utf-8");
		String eno = req.getParameter("eno");
		
		EmpDAO edao = new EmpDAO();
		Employee result = edao.selectEmp(Integer.parseInt(eno));
		String str = "<table border = '2'>"; // <table><tr><th><td>1001</td></th>...
		str += "<tr><th>사번</th><td>" + result.getEmpNo() + "</td></tr>";
		str += "<tr><th>전화</th><td>" + result.getTelNo() + "</td></tr>";
		str += "</table>";
		
		PrintWriter out = resp.getWriter(); // 출력스트림.
		out.print(str);
	}
}
