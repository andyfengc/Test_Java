package andy.test.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;

@Retention(RetentionPolicy.RUNTIME)
public @interface PersonAnnotation {
	String name();

	int age();

	byte gender();

}
