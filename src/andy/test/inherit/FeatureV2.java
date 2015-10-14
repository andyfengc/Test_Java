package andy.test.inherit;

public class FeatureV2 extends FeatureV1{
	private double score;
	private String grade;
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public FeatureV2(){
		
	}
	public FeatureV2(FeatureV1 record){
		this.setName(record.getName());
		this.setGender(record.getGender());
	}
	/**
	 * @param name
	 * @param gender
	 * @param score
	 * @param grade
	 */
	public FeatureV2(String name, String gender, double score, String grade) {
		super(name, gender);
		this.score = score;
		this.grade = grade;
	}
	
}
