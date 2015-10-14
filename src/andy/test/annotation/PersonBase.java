package andy.test.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class PersonBase {
	@PersonAnnotation(name = "newton", age = 320, gender = 1)
	public void useAnnotation(String title, int page) {
		System.out.println("call method");
	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		PersonBase pb = new PersonBase();
		Class<?> pbClass= pb.getClass();
		
		// get annotation of a method
		Method uaMethod = pbClass.getMethod("useAnnotation", String.class, int.class);
		PersonAnnotation pAnno = uaMethod.getAnnotation(PersonAnnotation.class);
		System.out.println(pAnno.name() + " " + pAnno.age() + " " +( (pAnno.gender() == 0)? "Male" : "Female"));
		
		Annotation[] annos = pbClass.getAnnotations();
		
		System.out.println();
	}
}
