package andy.test.inherit;

import java.util.Date;

public class FeatureV3 extends FeatureV2{
	private Date birthday;
	private String firstLanguage;
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getFirstLanguage() {
		return firstLanguage;
	}
	public void setFirstLanguage(String firstLanguage) {
		this.firstLanguage = firstLanguage;
	}
	public FeatureV3(){
		
	}
	/**
	 * @param name
	 * @param gender
	 * @param score
	 * @param grade
	 * @param birthday
	 * @param firstLanguage
	 */
	public FeatureV3(String name, String gender, double score, String grade, Date birthday, String firstLanguage) {
		super(name, gender, score, grade);
		this.birthday = birthday;
		this.firstLanguage = firstLanguage;
	}
	
	public FeatureV3(FeatureV2 record) {
		super(record);
		this.setScore(record.getScore());
		this.setGrade(record.getGrade());
	}
}
