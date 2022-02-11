package book.model.dto;

public class SemobookDTO {
	private String Semobook;
	private String bname;
	private String PId; 
	private String Cname;
	
	public SemobookDTO() {}

	public SemobookDTO(String semobook, String bname, String pId, String cname) {
		super();
		this.Semobook = semobook;
		this.bname = bname;
		this.PId = pId;
		this.Cname = cname;
	}

	public String getSemobook() {
		return Semobook;
	}

	public void setSemobook(String semobook) {
		Semobook = semobook;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getPId() {
		return PId;
	}

	public void setPId(String pId) {
		PId = pId;
	}

	public String getCname() {
		return Cname;
	}

	public void setCname(String cname) {
		Cname = cname;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("1. 세모북이 가진 책");
		builder.append(Semobook);
		builder.append("2. 책 이름");
		builder.append(bname);
		builder.append("3. 고객 이름");
		builder.append(PId);
		builder.append("4. 카테고리");
		builder.append(Cname);
		return builder.toString();
	}

	
	
	
	
	
}
