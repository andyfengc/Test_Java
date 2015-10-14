package andy.test.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="this is the name")
public class ClassTest {
	@Column(name="this is column name")
	private String name;
	@Column(name="this is column age")
	private int age;
	@Column(name="this is column dob")
	private Date dob;
	
	public ClassTest(){
		
	}
	
	@PostConstruct
	public void init(){
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public static void main(String[] args) throws ClassNotFoundException {
		ClassTest ct = new ClassTest();
//		Class<?> c =  ct.getClass();
		Class<?> c = ClassTest.class;
//		Class<?> c =   Class.forName("andy.test.annotation.ClassTest");
		Annotation[] as = c.getAnnotations();
		Field[] fields = c.getFields();
		Field[] allfields =c.getDeclaredFields();
		Method[] methods = c.getMethods();
		System.out.println("aa");
	}

}
