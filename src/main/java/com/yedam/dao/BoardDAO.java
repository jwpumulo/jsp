package com.yedam.dao;

<<<<<<< HEAD
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.BoardVO;
import com.yedam.vo.SearchVO;

public class BoardDAO extends DAO {
	
	public int getTotalCnt(SearchVO search) {
		
		String query = "select count(1) total_cnt from tbl_board ";
		
		if ("T".equals(search.getSearchCondition())) {
			query += "where title like '%'||?||'%' ";
		} else if ("W".equals(search.getSearchCondition())) {
			query += "where writer like '%'||?||'%' ";
		} else if ("TW".equals(search.getSearchCondition())) {
			query += "where title like '%'||?||'%' or writer like '%'||?||'%' ";
		}

		try {
			pstmt = getConnect().prepareStatement(query);
			int cnt = 1;
			if ("T".equals(search.getSearchCondition())) {
				pstmt.setString(cnt++, search.getKeyword());
			} else if ("W".equals(search.getSearchCondition())) {
				pstmt.setString(cnt++, search.getKeyword());
			} else if ("TW".equals(search.getSearchCondition())) {
				pstmt.setString(cnt++, search.getKeyword());
				pstmt.setString(cnt++, search.getKeyword());
			}
			
			rs = pstmt.executeQuery();

			if (rs.next()) {

//				return rs.getInt("total_cnt");
				return rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
		return 0;
	}

	public void updateViewCnt(int boardNo) {

		String query = "update tbl_board set view_cnt = view_cnt + 1 where board_no = ?";

		try {
			pstmt = getConnect().prepareStatement(query);
			pstmt.setInt(1, boardNo);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}
	}

	public BoardVO getBoard(int boardNo) {

		String query = "select * from tbl_board where board_no = ?";

		try {
			pstmt = getConnect().prepareStatement(query);
			pstmt.setInt(1, boardNo);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				BoardVO board = new BoardVO();
				board.setBoardNo(boardNo);
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setWriteDate(rs.getDate("write_date"));
				board.setViewCnt(rs.getInt("view_cnt"));
				board.setImg(rs.getString("img"));

				return board;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}

		return null;
	}

	public List<BoardVO> selectBoard(SearchVO search) {

		List<BoardVO> list = new ArrayList<>();

		String query = "select * "
				+ "from (select rownum rn, tbl_a.* "
				+ "from (select * "
				+ "from tbl_board ";
		
		if ("T".equals(search.getSearchCondition())) {
			query += "where title like '%'||?||'%' ";
		} else if ("W".equals(search.getSearchCondition())) {
			query += "where writer like '%'||?||'%' ";
		} else if ("TW".equals(search.getSearchCondition())) {
			query += "where title like '%'||?||'%' or writer like '%'||?||'%' ";
		}
		
		query += "order by board_no desc) tbl_a) tbl_b "
				+ "where tbl_b.rn > ((? - 1) * 5) and tbl_b.rn < ((? * 5) + 1)";
				
		//int cnt = 1, cnt++, if 로 처리?
		try {
			pstmt = getConnect().prepareStatement(query);
			int cnt = 1;
			if ("T".equals(search.getSearchCondition())) {
				pstmt.setString(cnt++, search.getKeyword());
			} else if ("W".equals(search.getSearchCondition())) {
				pstmt.setString(cnt++, search.getKeyword());
			} else if ("TW".equals(search.getSearchCondition())) {
				pstmt.setString(cnt++, search.getKeyword());
				pstmt.setString(cnt++, search.getKeyword());			
			}
			pstmt.setInt(cnt++, search.getPageNo());
			pstmt.setInt(cnt++, search.getPageNo());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardVO board = new BoardVO();
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setWriteDate(rs.getDate("write_Date"));
				board.setViewCnt(rs.getInt("view_cnt"));
				board.setImg(rs.getString("img"));
				
				list.add(board);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}

		return list;
	}

	public boolean insertBoard(BoardVO board) {

		String query = "insert into tbl_board (board_no, title, content, writer, img) "
				+ "values (board_seq.nextval, ?, ?, ?, ?)";

		try {
			pstmt = getConnect().prepareStatement(query);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getWriter());
			pstmt.setString(4, board.getImg());

			int r = pstmt.executeUpdate();

			if (r > 0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}

		return false;
	}

	public boolean updateBoard(BoardVO board) {

		String query = "update tbl_board set title = ?, "
				+ "content = ?, "
				+ "img = nvl(?, img) "
				+ "where board_no = ?";

		try {
			pstmt = getConnect().prepareStatement(query);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getImg());
			pstmt.setInt(4, board.getBoardNo());

			int r = pstmt.executeUpdate();

			if (r > 0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}

		return false;
	}

	public boolean deleteBoard(int boardNo) {

		String query = "delete from tbl_board where board_no = ?";

		try {
			pstmt = getConnect().prepareStatement(query);
			pstmt.setInt(1, boardNo);

			int r = pstmt.executeUpdate();

			if (r > 0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}

=======
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.BoardVO;
import com.yedam.vo.SearchVO;

/*
 * 추가,수정,삭제,조회
 * Create, Read, Update, Delete
 */
public class BoardDAO extends DAO {

	// 페이징의 처리를 위한 실체데이터.
	public int getTotalCount() {
		String sql = "select count(1) from tbl_board";
		try {
			psmt = getConnect().prepareStatement(sql);
			rs = psmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1); // count(1) 값.
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect(); // 정상실행이거나 예외발생이나 반드시 실행할 코드.
		}
		return 0; // 조회된 정보 없음.
	}

	// 글조회수 증가.
	public void updateCount(int boardNo) {
		String sql = "update tbl_board" //
				+ "   set   view_cnt = view_cnt + 1" //
				+ "   where board_no = ?";
		try {
			psmt = getConnect().prepareStatement(sql);
			psmt.setInt(1, boardNo);
			psmt.executeUpdate(); // 쿼리실행.
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect(); // 정상실행이거나 예외발생이나 반드시 실행할 코드.
		}
	}

	// 상세조회. 글번호 => 전체정보 반환.
	public BoardVO getBoard(int boardNo) {
		String sql = "select board_no" //
				+ "         ,title" //
				+ "         ,content" //
				+ "         ,writer" //
				+ "         ,write_date" //
				+ "         ,view_cnt" //
				+ "   from tbl_board" //
				+ "   where board_no = ?";

		try {
			psmt = getConnect().prepareStatement(sql);
			psmt.setInt(1, boardNo); //
			rs = psmt.executeQuery();
			// 조회결과 존재하면...
			if (rs.next()) {
				BoardVO board = new BoardVO();
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setWriteDate(rs.getDate("write_date"));
				board.setViewCnt(rs.getInt("view_cnt"));
				// 결과반환.
				return board;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect(); // 정상실행이거나 예외발생이나 반드시 실행할 코드.
		}
		return null; // 조회결과 없음.
	} // end of getBoard.

	// 조회.
	public List<BoardVO> selectBoard(SearchVO search) {
		List<BoardVO> brdList = new ArrayList<>();
		String qry = "select * " + "from (select rownum rn, tbl_a.* "
				+ "      from (select board_no, title, content, writer, write_date, view_cnt "
				+ "            from tbl_board ";
		if (search.getSearchCondition().equals("T")) {
			qry += "          where title like '%'||?||'%'";
		} else if (search.getSearchCondition().equals("W")) {
			qry += "          where writer like '%'||?||'%'";
		} else if (search.getSearchCondition().equals("TW")) {
			qry += "          where title like '%'||?||'%' or writer like '%'||?||'%' ";
		}

		qry += "            order by board_no desc) tbl_a) tbl_b " 
		        + "where tbl_b.rn >= (? - 1)* 5 + 1 "
				+ "and   tbl_b.rn <= ? * 5";
		try {
			psmt = getConnect().prepareStatement(qry);
			// 조건.
			int cnt = 1;
			if (search.getSearchCondition().equals("T")) { // 제목 검색.
				psmt.setString(cnt++, search.getKeyWord());
			} else if (search.getSearchCondition().equals("W")) { // 작성자 검색.
				psmt.setString(cnt++, search.getKeyWord());
			} else if (search.getSearchCondition().equals("TW")) { // 제목, 작성자 검색.
				psmt.setString(cnt++, search.getKeyWord());
				psmt.setString(cnt++, search.getKeyWord());
			}
			
			psmt.setInt(cnt++, search.getPage()); // 페이지.
			psmt.setInt(cnt++, search.getPage()); // 페이지.

			rs = psmt.executeQuery();
			// 조회결과
			while (rs.next()) {
				BoardVO brd = new BoardVO();
				brd.setBoardNo(rs.getInt("board_no"));
				brd.setTitle(rs.getString("title"));
				brd.setContent(rs.getString("content"));
				brd.setWriter(rs.getString("writer"));
				brd.setWriteDate(rs.getDate("write_date"));
				brd.setViewCnt(rs.getInt("view_cnt"));

				brdList.add(brd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect(); // 정상실행이거나 예외발생이나 반드시 실행할 코드.
		}
		return brdList;
	}

	// 추가.
	public boolean insertBoard(BoardVO board) {
		String sql = "insert into tbl_board (board_no, title, content, writer) " //
				+ "   values(board_seq.nextval,?,?,?)";
		try {
			psmt = getConnect().prepareStatement(sql);
			psmt.setString(1, board.getTitle());
			psmt.setString(2, board.getContent());
			psmt.setString(3, board.getWriter());

			int r = psmt.executeUpdate(); // insert 실행.
			if (r == 1) {
				return true; // 정상 등록.
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect(); // 정상실행이거나 예외발생이나 반드시 실행할 코드.
		}
		return false; // 비정상 처리.
	}

	// 수정.
	public boolean updateBoard(BoardVO board) {
		String sql = "update tbl_board " //
				+ "set    title = ? " //
				+ "      ,content = ? " //
				+ "where board_no = ?";
		try {
			psmt = getConnect().prepareStatement(sql);
			psmt.setString(1, board.getTitle());
			psmt.setString(2, board.getContent());
			psmt.setInt(3, board.getBoardNo());

			int r = psmt.executeUpdate(); // 쿼리실행.

			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect(); // 정상실행이거나 예외발생이나 반드시 실행할 코드.
		}
		return false;
	}

	// 삭제.
	public boolean deleteBoard(int boardNo) {
		String query = "delete from tbl_board where board_no =?";
		try {
			psmt = getConnect().prepareStatement(query);
			psmt.setInt(1, boardNo); // ?에 값 지정.
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect(); // 정상실행이거나 예외발생이나 반드시 실행할 코드.
		}
>>>>>>> branch 'master' of https://github.com/jwpumulo/jsp.git
		return false;
	}

}
