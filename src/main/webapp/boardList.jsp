<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>

	<!-- html주석문 -->
	<%
	
	List<Employee> list= (List<Employee>) request.getAttribute("list");\
	request.getAttribute("msg");
	
	
	for (Employee emp : list ) {
	%>
	<li>
		<%emp.getEmpNo( ) %>, <%=emp.getEmpName( ) %>, <%=emp.getSalary() %>
	</li>

	<%
	}
%>

	</ul>
</body>
</html>