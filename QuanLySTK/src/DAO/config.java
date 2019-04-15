package DAO;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class config {
	public static  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

}
