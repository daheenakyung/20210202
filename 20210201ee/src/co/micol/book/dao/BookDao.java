package co.micol.book.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.book.common.DAO;
import co.micol.book.vo.BookVo;

public class BookDao extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;
	
	public ArrayList<BookVo> selectList() {
		ArrayList<BookVo> list = new ArrayList<BookVo>();
		BookVo vo = new BookVo();
		String sql = "SELECT * FROM BOOK";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new BookVo();
				vo.setbCode(rs.getString("bookcode"));
				vo.setbName(rs.getString("bookname"));
				vo.setQuanti(rs.getInt("quantity"));
				vo.setbCount(rs.getInt("bcount"));
				list.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	
	public BookVo select(BookVo vo) {
		String sql = "SELECT * FROM BOOK WHERE BOOKCODE = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getbCode());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo = new BookVo();
				vo.setbCode(rs.getString("bookcode"));
				vo.setbName(rs.getString("bookname"));
				vo.setQuanti(rs.getInt("quantity"));
				vo.setbCount(rs.getInt("bcount"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	} 
	
	public int insert(BookVo vo) {
		int n = 0;
		String sql = "insert into book values(?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getbCode());
			psmt.setString(2, vo.getbName());
			psmt.setInt(3, vo.getQuanti());
			psmt.setInt(4, vo.getbCount());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	public int update(BookVo vo) {
		int n = 0;
		String sql = "UPDATE BOOK SET BOOKNAME = ?, BCOUNT = ? WHERE BOOKCODE = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getbName());
			psmt.setInt(2, vo.getbCount());
			psmt.setString(3, vo.getbCode());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	public int delete(BookVo vo) {
		int n = 0;
		String sql = "DELETE FROM BOOK WHERE BOOKCODE = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getbCode());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	private void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
