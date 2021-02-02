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
	
	public ArrayList<BookRentalVo> masSelect(MemberVo vm, BookVo vb){
		ArrayList<BookRentalVo> list = new ArrayList<BookRentalVo>();
		String sql = "SELECT * FROM BOOKRENTAL";
		BookRentalVo vo;
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new BookRentalVo();
				vm = new MemberVo();
				vb = new BookVo();
				vb.setbCode(rs.getString("b.bcode"));
				vm.setmId(rs.getString("m.memberid"));
				vo.setRentalDate(rs.getDate("r.rentaldate"));
				vo.setReturnDate(rs.getDate("r.returndate"));
				list.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return null;
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