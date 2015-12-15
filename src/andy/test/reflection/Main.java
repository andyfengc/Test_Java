package andy.test.reflection;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Date;

public class Main {
	public static void main(String[] args) {
		// displa fields 1
		Class<?> a = Student.class.getClass();
		Field[] b = a.getDeclaredFields();
		for (Field field : Arrays.asList(b)){
			System.out.println(field.getName());
		}
		System.out.println();
		// display fields
		Field[] fields = Student.class.getDeclaredFields();
		for (Field field : Arrays.asList(fields)){
			System.out.println(field.getName());
		}
	}

	class Student {
		private String Name;
		private int Age;
		public Date Dob;
		
		public String getName() {
			return Name;
		}

		public void setName(String name) {
			Name = name;
		}

		public int getAge() {
			return Age;
		}

		public void setAge(int age) {
			Age = age;
		}

	}
}
