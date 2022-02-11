package book.model.dto;

public class BookDTO {
	private String bname;
	private String Bnumber;
	private String publisher;
	
	public BookDTO() {}	
	
	public BookDTO(String bname, String bnumber, String publisher) {
		this.bname = bname;
		this.Bnumber = bnumber;
		this.publisher = publisher;
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
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String barely) {
		this.publisher = barely;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("1. 책 이름");
		builder.append(bname);
		builder.append("2. 책 고유번호");
		builder.append(Bnumber);
		builder.append("3. 출판사");
		builder.append(publisher);
		return builder.toString();
	}
	
	
	
}
