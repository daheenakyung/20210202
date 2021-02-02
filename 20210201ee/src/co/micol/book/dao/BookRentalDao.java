package co.micol.book.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.book.common.DAO;
import co.micol.book.vo.BookRentalVo;
import co.micol.book.vo.BookVo;
import co.micol.book.vo.MemberVo;

public class BookRentalDao extends DAO{
	private PreparedStatement psmt;
	private ResultSet rs;
	
	//대여 조회
	public ArrayList<BookRentalVo> masSelect(){
		ArrayList<BookRentalVo> list = new ArrayList<BookRentalVo>();
		BookRentalVo vo = new BookRentalVo();
		String sql = "SELECT * FROM MEM A, BOOKRENTAL B WHERE A.MEMBERID = B.MEMBERID";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new BookRentalVo();
				vo.setRentalDate(rs.getDate("rentaldate"));
				vo.setmId(rs.getString("memberid"));
				vo.setbCode(rs.getString("bookcode"));
				vo.setReturnDate(rs.getDate("returndate"));
				list.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	
	public BookRentalVo selMem(BookRentalVo vo) {
		String sql = "SELECT A.MEMBERNAME, B.* FROM MEM A, BOOKRENTAL B WHERE A.MEMBERID = B.MEMBERID AND A.MEMBERID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getmId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo = new BookRentalVo();
				vo.setRentalDate(rs.getDate("rentaldate"));
				vo.setbCode(rs.getString("bookcode"));
				vo.setmId(rs.getString("memberid"));
				vo.setReturnDate(rs.getDate("returndate"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}
	
		
		//대여 렌탈테이블에 등록
		public int insert(BookRentalVo vo) {
			int n = 0;
			String sql = "insert into BookRental(rentaldate, bookcode, mid) values(sysdate, ?, ?)";
			try {
				psmt = conn.prepareStatement(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
			return n;
		}
		
	
	//대여하면 수량 -1
	public int upCount(BookVo vo) {
	      int n = 0;
	      String sql = "UPDATE BOOK SET BCOUNT = BCOUNT - 1 WHERE BOOKCODE = ?";
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
	
	//반납하면 수량+1
	public int downCount(BookVo vo) {
	      int n = 0;
	      String sql = "UPDATE BOOK SET BCOUNT = BCOUNT + 1 WHERE BOOKCODE = ?";
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
