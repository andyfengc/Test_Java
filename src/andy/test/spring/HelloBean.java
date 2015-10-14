package andy.test.spring;

public class HelloBean {
	private PersonBean personBean;

	public PersonBean getPersonBean() {
		return personBean;
	}

	public void setPersonBean(PersonBean personBean) {
		this.personBean = personBean;
	}

	public String greet(String name) {
		return "hello " + name + " from spring";
	}
	
	public String greetPerson(){
		if (this.personBean != null){
			return "Hello " + personBean.getName() + " " + personBean.getEmail() + " from spring";
		}
		return null;
	}
}
