package com.yedam;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.

@WebServlet("/empInfo")

@Override
public class GetEmpoyeeServ extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse res)
	//파라미터 (?eno=1001)
	
	resp.setContentType("text/html;charset=utf-8";)
	String eno = req.getParameter("eno");
	
	EmpDAO edao = new EmpDAO();
	Employee result = edao.selectEmp(Integer.parseInt(eno));
	String str = "<table border='2'>"; //<table><tr><th>사번</th></td>1001</td></tr>
	str += <tr><th>사번</th><td>+result.getEmpNo() + "</td></tr>";
	
	
	PrintWriter out = resp.getWriter(); // 출력스트림.
	out.print(str);
	
}
}