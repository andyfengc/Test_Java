package andy.test.spring;

public class PersonBean {
	private String name;
	private String email;
	public PersonBean(){
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @param name
	 * @param email
	 */
	public PersonBean(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	
	
}
