package peerGradingSystem;
/**
 * This is a class pertaining to each student and stores information related to each student 
 * @author Group 1
 *
 */
public class student {
	private String fullName;
	private Integer ProfessionalisMarks;
	private Integer ParticipationMarks;
	private Integer WorkEvaluationMarks;
	
	
	private float normalisedMarks = 0;
	
	/**
	 * This is the constructor to the student class
	 * @param fullName the name of the student 
	 * @param ProfessionalisMarks marks in professional category
	 * @param ParticipationMarks marks in participation category
	 * @param WorkEvaluationMarks marks in Work evaluation category
	 */

	public student(String fullName, Integer ProfessionalisMarks,Integer ParticipationMarks,Integer WorkEvaluationMarks){
		this.fullName = fullName;
		this.ProfessionalisMarks = ProfessionalisMarks;
		this.ParticipationMarks = ParticipationMarks;
		this.WorkEvaluationMarks = WorkEvaluationMarks;
	}
	
	/**
	 * Getter for Professionalism Marks
	 * @return ProfessionalisMarks
	 */
	public Integer getProfessionalismMarks() {
		return ProfessionalisMarks;
	}
	/**
	 * Getter for participation marks
	 * @return ParticipationMarks
	 */
	public Integer getParticipationMarks() {
		return ParticipationMarks;
	}
	/**
	 * Getter for work evaluation marks
	 * @return WorkEvaluationMarks
	 */
	public Integer getWorkEvaluationMarks() {
		return WorkEvaluationMarks;
	}
	/**
	 * Getter for normalized marks
	 * @return normalisedMarks
	 */
	public float getNormalisedMarks() {
		return normalisedMarks;
	}
	/**
	 * Setter for professionalism marks
	 * @param marks
	 */
	public void setProfessionalismMarks(Integer marks) {
		this.ProfessionalisMarks = marks;
	}
	/**
	 * Setter for normalized marks
	 * @param normalisedMarks
	 */
	public void setNormalisedMarks(float normalisedMarks) {
		this.normalisedMarks = normalisedMarks;
	}
	/**
	 * Setter for participation marks
	 * @param participationMarks
	 */
	public void setParticipationMarks(Integer participationMarks) {
		ParticipationMarks = participationMarks;
	}
	/**
	 * Setter for Work Evaluation Marks
	 * @param workEvaluationMarks
	 */
	public void setWorkEvaluationMarks(Integer workEvaluationMarks) {
		WorkEvaluationMarks = workEvaluationMarks;
	}
	/**
	 * Getter for full name
	 * @return fullName
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * Setter for full name
	 * @param fullName
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}