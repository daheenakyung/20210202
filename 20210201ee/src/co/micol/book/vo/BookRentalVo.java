package co.micol.book.vo;

import java.sql.Date;

public class BookRentalVo {
	private int bookN;
	private String bName;
	private Date rentalDate;
	private String bCode;
	private String mId;
	private Date returnDate;
	
	public Date getRentalDate() {
		return rentalDate;
	}
	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}
	public String getbCode() {
		return bCode;
	}
	public void setbCode(String bCode) {
		this.bCode = bCode;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public int getBookN() {
		return bookN;
	}
	public void setBookN(int bookN) {
		this.bookN = bookN;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	
	
}
