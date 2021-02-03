package co.micol.book.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.book.common.DAO;
import co.micol.book.vo.BookRentalVo;
import co.micol.book.vo.BookVo;

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
	
	public ArrayList<BookRentalVo> selMem(BookRentalVo vo) {
		ArrayList<BookRentalVo> list = new ArrayList<BookRentalVo>();
		String sql = "SELECT * FROM MYBOOK WHERE MEMBERID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getmId());
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new BookRentalVo();
				vo.setbCode(rs.getString("bookcode"));
				vo.setmId(rs.getString("memberid"));
				vo.setRentalDate(rs.getDate("rentaldate"));
				vo.setbName(rs.getString("bookname"));
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
	
		
		//대여 렌탈테이블에 등록
		public int insert(BookRentalVo vb) {
			int n = 0;
			String sql = "INSERT INTO BOOKRENTAL(BOOKNUMBER, BOOKCODE, MEMBERID) VALUES(BOOKSEQ.NEXTVAL, ?, ?)";
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, vb.getbCode());
				psmt.setString(2, vb.getmId());
				n = psmt.executeUpdate();
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
	
	public int delete(BookRentalVo vo) {
		int n = 0;
		String sql = "DELETE FROM BOOKRENTAL WHERE BOOKNUMBER = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getBookN());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	public int upReturn(BookRentalVo vo) {
		int n = 0;
		String sql = "UPDATE BOOKRENTAL SET  RETURNDATE = SYSDATE WHERE BOOKNUMBER = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getBookN());
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
