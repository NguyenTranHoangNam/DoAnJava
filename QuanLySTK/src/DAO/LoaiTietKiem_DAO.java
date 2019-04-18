package DAO;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;

import model.Loaitietkiem;
import model.Sotietkiem;

public class LoaiTietKiem_DAO {
	 public ArrayList<Loaitietkiem> getLoaiTietKiem() {
			
			 Session session = config.sessionFactory.openSession();
			 ArrayList<Loaitietkiem> ltks = new ArrayList();
		     try {

		         // Bat dau 1 transaction (Giao dich)

		         session.beginTransaction();

		         // Thuc thi cau querry

		         String sql = "from Loaitietkiem";
		         Query query = session.createQuery(sql);
		         ltks = (ArrayList<Loaitietkiem>) query.list();
		       	System.out.println(ltks.size() + "abc");
		       	return ltks;
		     } catch (RuntimeException e) {

		         session.getTransaction().rollback();

		         e.printStackTrace();

		     } finally {

		         session.flush();

		         session.close();

		     }
			return null;
		}

}
