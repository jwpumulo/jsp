package com.yedam.dao;

<<<<<<< HEAD
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.Employee;

public class EmpDAO extends DAO {

	public List<Employee> search(Employee emp) {
		// TODO Auto-generated method stub

		List<Employee> empList = new ArrayList<>();

		String query = "select * from tbl_employees where emp_name = nvl(?, emp_name) order by emp_no";

		try {
			pstmt = getConnect().prepareStatement(query);
			pstmt.setString(1, emp.getEmpName());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Employee emp1 = new Employee();
				emp1.setEmpNo(rs.getInt("emp_no"));
				emp1.setEmpName(rs.getString("emp_name"));
				emp1.setTelNo(rs.getString("tel_no"));
				emp1.setHireDate(rs.getDate("hire_date"));
				emp1.setSalary(rs.getInt("salary"));

				empList.add(emp1);
			}

			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empList;
	}

	public boolean register(Employee emp) {
		// TODO Auto-generated method stub

		String query = "insert into tbl_employees values (?, ?, ?, ?, ?)";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			pstmt = getConnect().prepareStatement(query);
			pstmt.setInt(1, emp.getEmpNo());
			pstmt.setString(2, emp.getEmpName());
			pstmt.setString(3, emp.getTelNo());
			pstmt.setString(4, sdf.format(emp.getHireDate()));
			pstmt.setInt(5, emp.getSalary());

			int r = pstmt.executeUpdate();

			conn.close();

			if (r > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public Employee selectEmp(int empNo) {

		String query = "select * from tbl_employees where emp_no = ?";

		try {
			pstmt = getConnect().prepareStatement(query);
			pstmt.setInt(1, empNo);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				Employee emp = new Employee();
				emp.setEmpNo(rs.getInt("emp_no"));
				emp.setEmpName(rs.getString("emp_name"));
				emp.setTelNo(rs.getString("tel_no"));
				emp.setHireDate(rs.getDate("hire_date"));
				emp.setSalary(rs.getInt("salary"));

				conn.close();

				return emp;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
=======
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.Employee;



public class EmpDAO extends DAO {
	

	// 상세조회.
	public Employee selectEmp(int empNo) {
		String query = "select * from tbl_employees" + " where emp_no = ?";
		try {
			psmt = getConnect().prepareStatement(query);
			psmt.setInt(1, empNo);
			
			ResultSet rs = psmt.executeQuery(); // 조회.
			if(rs.next()) { // 조회결과가 한건 있으면...
				Employee emp = new Employee();
				emp.setEmpNo(rs.getInt("emp_no")); // 칼럼값.
				emp.setEmpName(rs.getString("emp_name"));
				emp.setTelNo(rs.getString("tel_no"));
				emp.setHireDate(rs.getDate("hire_date"));
				emp.setSalary(rs.getInt("salary"));
				
				return emp; // 반환.
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; // 조회된 결과 없음(null)
	}

	// 등록.
	public boolean registerEmp(Employee emp) { // 등록.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String query = "insert into tbl_employees ";
		query += "values (" + emp.getEmpNo() //
				+ ", '" + emp.getEmpName() //
				+ "', '" + emp.getTelNo() //
				+ "', '" + sdf.format(emp.getHireDate()) //
				+ "', " + emp.getSalary()//
				+ ")";
		try {
			Statement stmt = getConnect().createStatement();
			int r = stmt.executeUpdate(query);
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	} // end of registerEmp().

	// 목록.
	public List<Employee> search(Employee emp) {
		List<Employee> empList = new ArrayList<>();
		String qry = "select * from tbl_employees " //
//				+ "where emp_name = nvl('" + emp.getEmpNo() + "', emp_name) " //
				+ "where emp_name = nvl(?, emp_name) " // number, varchar2 에 따라 처리.
				+ "order by emp_no";

		try {
//			Statement stmt = getConnect().createStatement();
			PreparedStatement stmt = getConnect().prepareStatement(qry);
			stmt.setString(1, emp.getEmpName()); // 첫번째 ?에 사원이름을 대입.
			ResultSet rs = stmt.executeQuery();
			// 조회결과.
			while (rs.next()) {
				Employee empl = new Employee();
				empl.setEmpNo(rs.getInt("emp_no"));
				empl.setEmpName(rs.getString("emp_name"));
				empl.setHireDate(rs.getDate("hire_date"));
				empl.setSalary(rs.getInt("salary"));
				empl.setTelNo(rs.getString("tel_no"));

				empList.add(empl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empList;
>>>>>>> branch 'master' of https://github.com/jwpumulo/jsp.git
	}
}
