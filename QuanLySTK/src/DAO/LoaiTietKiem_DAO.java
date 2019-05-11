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
	 
	 public int updateLoaiTietKiem(String maLoaiTK, float laiSuat) {
		 Session session = config.sessionFactory.openSession();
		 try {
	            session.beginTransaction();
	            String hqlUpdate = "update Loaitietkiem ltk set ltk.laiSuat = :laisuat where ltk.maLoaiTietKiem = :maLoaiTK";
	            Query query=session.createQuery(hqlUpdate);
	            query.setString("maLoaiTK", maLoaiTK);
	            query.setFloat("laisuat", laiSuat);
	            query.executeUpdate();
	           	session.getTransaction().commit();
	            return 1;
			 
		 }catch (Exception e) {
			// TODO: handle exception
		}finally {

	         session.flush();

	         session.close();

	     }
		 
		 return 0;
	 }
	 
	 public int themLoaiTietKiem(String maLoaiTietKiem, String thoiHan, float laiSuat) {
		 Session session = config.sessionFactory.openSession();
		 try {
	            session.beginTransaction();
	            Loaitietkiem ltk = new Loaitietkiem( maLoaiTietKiem,  thoiHan,  laiSuat);
	            session.save(ltk);
	           	session.getTransaction().commit();
	            return 1;
			 
		 }catch (Exception e) {
			// TODO: handle exception
		}finally {

	         session.flush();

	         session.close();

	     }
		 
		 return 0;
	 }

}
