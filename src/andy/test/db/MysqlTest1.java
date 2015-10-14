package andy.test.db;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MysqlTest1 {
	public static void main(String[] args) {
//		addJob();
//		queryAJob();
//		queryAllJobs();
		
//		addJobinJob2();
		queryJobInJob2();
	}

	private static void addJobinJob2() {
		Configuration config = new Configuration().configure();
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = config.buildSessionFactory(registry);
		
		Job2 job = new Job2();
		job.setId(1);
		job.setTitle("Hello");
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(job);
		session.getTransaction().commit();
	}

	private static void queryJobInJob2() {
		Configuration config = new Configuration().configure("/hibernate.cfg.xml");
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = config.buildSessionFactory(registry);
		
		// get a job
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Job2 job = (Job2) session.load(Job2.class, 1);
		System.out.println("job id: "+ job.getId());
		System.out.println("job title: "+ job.getTitle());
		session.getTransaction().commit();
	}

	private static void queryAllJobs() {
		SessionFactory sessionFactory  = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Job> jobs = session.createQuery("from Job").list();
		session.getTransaction().commit();
		for (Job job : jobs){
			System.out.println("Job id: " + job.getId() + "  " + "Job title: " + job.getTitle());
		}
	}

	private static void queryAJob() {
		Configuration config = new Configuration().configure();
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = config.buildSessionFactory(registry);
		
		// get a job
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Job job = (Job) session.load(Job.class, 2);
		System.out.println("job id: "+ job.getId());
		System.out.println("job title: "+ job.getTitle());
		session.getTransaction().commit();
		
	}

	private static void addJob() {
		// 4.x
//		Configuration config = new Configuration().configure();
//		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
//		SessionFactory sessionFactory = config.buildSessionFactory(registry);
		// 3.x
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		// create a new job
		Job job = new Job();
		job.setTitle("ttt1");
		
		// create a session
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(job);
		session.getTransaction().commit();
	}
	
	
}
