package peerGradingSystem;

public class student {
	private String fullName;
	private Integer marks;

	public student(String fullName, Integer marks){
		this.fullName = fullName;
		this.marks = marks;
	}
	public Integer getMarks() {
		return marks;
	}
	
	public void setMarks(Integer marks) {
		this.marks = marks;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}