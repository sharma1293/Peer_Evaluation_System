package peerGradingSystem;

public class student {
	private String fullName;
	private Integer marks;
	private float normalisedMarks = 0;

	public student(String fullName, Integer marks){
		this.fullName = fullName;
		this.marks = marks;
	}
	
	
	public Integer getMarks() {
		return marks;
	}
	
	public float getNormalisedMarks() {
		return normalisedMarks;
	}
	
	public void setMarks(Integer marks) {
		this.marks = marks;
	}
	
	public void setNormalisedMarks(float normalisedMarks) {
		this.normalisedMarks = normalisedMarks;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}