package andy.test.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class AppTest {
	public static void main(String[] args) {
		testSingleton();
	}

	public static void testSingleton() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// hello bean 1
		HelloBean hb = (HelloBean) context.getBean("helloBean");
//		System.out.println(hb.greet("andy"));
		System.out.println(hb.greetPerson());
		hb.getPersonBean().setName("kathy");
		// hello bean 2
		HelloBean hb2 = (HelloBean) context.getBean("helloBean");
		System.out.println(hb2.greetPerson());
	}
}
