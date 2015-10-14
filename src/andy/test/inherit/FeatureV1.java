package andy.test.inherit;

public class FeatureV1 {
	private String name;
	private String gender;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public FeatureV1(){
		
	}
	/**
	 * @param name
	 * @param gender
	 */
	public FeatureV1(String name, String gender) {
		super();
		this.name = name;
		this.gender = gender;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
