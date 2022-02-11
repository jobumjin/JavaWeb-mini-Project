package book.model.dto;

public class CategoryDTO {
	private String cName;
	private String cNumber;
	
	public CategoryDTO( ) {}
	
	public CategoryDTO(String cName, String cNumber) {
		this.cName = cName;
		this.cNumber = cNumber;
	}
	
	public String getCName() {
		return cName;
	}
	
	public void setCName(String cName) {
		this.cName = cName;
	}

	public String getCNumber() {
		return cNumber;
	}

	public void setCNumber(String cNumber) {
		this.cNumber = cNumber;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("1. 카테고리 이름 : ");
		builder.append(cName);
		builder.append("2. 고유번호 : ");
		builder.append(cNumber);
		return builder.toString();
	}
}