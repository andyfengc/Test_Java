package andy.test.db;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * hibernate
 * 
 * @author Andy
 *
 */
public class SqliteTest2 {
	static{
		
	}
	public static void main(String[] args) {
		queryAll();
	}

	private static void queryAll() {
		Configuration config = new Configuration().configure("/hibernateSqlite.cfg.xml");
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = config.buildSessionFactory(registry);
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Student> students = session.createQuery("from Student").list();
		session.getTransaction().commit();
		for (Student student : students){
			System.out.println("student id: " + student.getId() + "  " + "student name: " + student.getName());
		}
	}
}
