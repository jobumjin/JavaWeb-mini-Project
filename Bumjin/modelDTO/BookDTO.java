package book.model.dto;

public class BookDTO {
	private String bname;
	private String Bnumber;
	private String barely;
	
	public BookDTO() {}	
	
	public BookDTO(String bname, String bnumber, String barely) {
		this.bname = bname;
		this.Bnumber = bnumber;
		this.barely = barely;
	}

	public String getbname() {
		return bname;
	}
	public void setbname(String bname) {
		bname = bname;
	}
	public String getBnumber() {
		return Bnumber;
	}
	public void setBnumber(String bnumber) {
		Bnumber = bnumber;
	}
	public String getBarely() {
		return barely;
	}
	public void setBarely(String barely) {
		this.barely = barely;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("1. 책 이름");
		builder.append(bname);
		builder.append("2. 책 고유번호");
		builder.append(Bnumber);
		builder.append("3. 출판사");
		builder.append(barely);
		return builder.toString();
	}
	
	
	
}
