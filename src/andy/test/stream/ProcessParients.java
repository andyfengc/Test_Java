package andy.test.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProcessParients {
	public static void main(String[] args) {
		List<Patient> patients = getData();
//		patients.stream().forEach(p-> System.out.println(p));
		// pick all at toronto
//		patients.stream().filter(p -> p.getLocation().equals("Toronto")).forEach(p->System.out.println(p));
		// pick yongest at toronto
		Optional<Patient> min = patients.stream().filter(p -> p.getLocation().equals("Toronto")).min((a, b) -> a.getAge() - b.getAge());
		if (min.isPresent()){System.out.println(min);}
		// pick oldest at scarborough
		Optional<Patient> max = patients.stream().filter(p -> p.getLocation().equals("Scarborough")).max((a, b) -> a.getAge() - b.getAge());
		if (max.isPresent()){
			System.out.println(max);
		}
	}

	private static List<Patient> getData() {
		List<Patient> patients = new ArrayList<Patient>();
		patients.add(new Patient("Andy", 30, "Scarborough"));
		patients.add(new Patient("John", 55, "Toronto"));
		patients.add(new Patient("Alice", 23, "Scarborough"));
		patients.add(new Patient("Jing", 63, "Scarborough"));
		patients.add(new Patient("Annie", 28, "Toronto"));
		patients.add(new Patient("Jonny", 7, "Toronto"));
		patients.add(new Patient("Geogge", 37, "Scarborough"));
		patients.add(new Patient("Peter", 60, "Toronto"));
		patients.add(new Patient("Helen", 21, "Scarborough"));
		return patients;
	}
}
class Patient{
	private String name;
	private int age;
	private String location;
	
	/**
	 * @param name
	 * @param age
	 * @param location
	 */
	public Patient(String name, int age, String location) {
		super();
		this.name = name;
		this.age = age;
		this.location = location;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name + " " + age + " " + this.location;
	}
	
}