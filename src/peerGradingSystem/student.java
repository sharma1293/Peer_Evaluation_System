package peerGradingSystem;

public class student {
	private String fullName;
	private Integer ProfessionalisMarks;
	private Integer ParticipationMarks;
	private Integer WorkEvaluationMarks;
	
	
	private float normalisedMarks = 0;

	public student(String fullName, Integer ProfessionalisMarks,Integer ParticipationMarks,Integer WorkEvaluationMarks){
		this.fullName = fullName;
		this.ProfessionalisMarks = ProfessionalisMarks;
		this.ParticipationMarks = ParticipationMarks;
		this.WorkEvaluationMarks = WorkEvaluationMarks;
	}
	
	
	public Integer getProfessionalismMarks() {
		return ProfessionalisMarks;
	}
	
	public Integer getParticipationMarks() {
		return ParticipationMarks;
	}
	
	public Integer getWorkEvaluationMarks() {
		return WorkEvaluationMarks;
	}
	
	public float getNormalisedMarks() {
		return normalisedMarks;
	}
	
	public void setProfessionalismMarks(Integer marks) {
		this.ProfessionalisMarks = marks;
	}
	
	public void setNormalisedMarks(float normalisedMarks) {
		this.normalisedMarks = normalisedMarks;
	}
	
	public void setParticipationMarks(Integer participationMarks) {
		ParticipationMarks = participationMarks;
	}
	
	public void setWorkEvaluationMarks(Integer workEvaluationMarks) {
		WorkEvaluationMarks = workEvaluationMarks;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}