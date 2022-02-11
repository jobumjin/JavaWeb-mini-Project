package book.model.dto;

public class PersonDTO {
	private String pname;
	private String pid;
	private String password;	
	private String interest;
	
	public PersonDTO(String pname, String pid, String password, String interest) {
		super();
		this.pname = pname;
		this.pid = pid;
		this.password = password;
		this.interest = interest;
	}
	
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("1. 대여자 id : ");
		builder.append(pid);
		builder.append(" 2. 이름 : ");
		builder.append(pname);
		builder.append(" 3. 비밀번호 : ");
		builder.append(password);
		builder.append("4. 관심분야 :");
		builder.append(interest);
		return builder.toString();
	}
	

}