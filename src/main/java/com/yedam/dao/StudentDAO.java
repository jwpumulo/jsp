package com.yedam.dao;

<<<<<<< HEAD
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.Student;

public class StudentDAO extends DAO {

	public List<Student> search(Student std) {
		// TODO Auto-generated method stub

		List<Student> stdList = new ArrayList<>();

		String query = "select * from tbl_student" + " where student_name = nvl(?, student_name)"
				+ " order by student_no";

		try {
			pstmt = getConnect().prepareStatement(query);
			pstmt.setString(1, std.getStudentName());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				stdList.add(new Student(rs.getString("student_no"), rs.getString("student_name"), rs.getString("phone"),
						rs.getString("address")));
			}

			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stdList;
	}

	public boolean addStd(Student std) {
		// TODO Auto-generated method stub

		String query = "insert into tbl_student values (?, ?, ?, ?)";

		try {
			pstmt = getConnect().prepareStatement(query);
			pstmt.setString(1, std.getStudentNo());
			pstmt.setString(2, std.getStudentName());
			pstmt.setString(3, std.getPhone());
			pstmt.setString(4, std.getAddress());

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

=======
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.Student;

public class StudentDAO extends DAO {
	
	public boolean addStudent(Student student) {
		String sql = "insert into tbl_student (student_no, student_name, phone, address) " //
				+ "values(?,?,?,?)";
		try {
			psmt = getConnect().prepareStatement(sql);
			psmt.setString(1, student.getStudentNo());
			psmt.setString(2, student.getStudentName());
			psmt.setString(3, student.getPhone());
			psmt.setString(4, student.getAddress());
			
			// 쿼리실행.
			int r = psmt.executeUpdate(); // 처리된 건수반환.
			if(r > 0) {
				return true; // 등록성공.
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 등록실패.
	}
	
	// 학생목록을 반환 메소드. 참고) EmpDAO.search()
	public List<Student> studentList() {
		List<Student> studentList = new ArrayList<>();
		String qry = "select * from tbl_student " //
				+ "order by student_no";
		try {
//			Statement stmt = getConnect().createStatement();
			psmt = getConnect().prepareStatement(qry);
			rs = psmt.executeQuery();
			// 조회결과.
			while (rs.next()) {
				Student student = new Student();
				student.setStudentNo(rs.getString("student_no"));
				student.setStudentName(rs.getString("student_name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));

				studentList.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studentList;
	} // end of studentList()
	
	public boolean registerEmp(Student std) { // 등록.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String query = "insert into tbl_student ";
		query += "values (" + std.getStudentNo() //
				+ ", '" + std.getStudentName() //
				+ "', '" + std.getPhone() //
				+ "', '" + std.getAddress() //
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
>>>>>>> branch 'master' of https://github.com/jwpumulo/jsp.git
}
