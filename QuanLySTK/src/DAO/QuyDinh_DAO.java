package DAO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Dangnhap;
import model.Loaitietkiem;
import model.Phieuruttien;
import model.Quydinh;
import model.Sotietkiem;
import model.Taikhoankhachhang;

public class QuyDinh_DAO {
//	 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	 
	 public Quydinh getQuyDinh(String maQD) {
		 Quydinh quy_dinh = new Quydinh();
		 Session session = config.sessionFactory.openSession();
	      try {
         session.beginTransaction();
         // Thuc thi cau querry
         
         String sql = "from Quydinh qd where qd.maQd =:maQD";
         Query query = session.createQuery(sql);
         query.setString("maQD", maQD);
         ArrayList<Quydinh> result = (ArrayList<Quydinh>) query.list();
         if(result.size() > 0) {
        	 System.out.println(result.get(0).getMaQD());
        	 return result.get(0);
         }
           return null;       
     } catch (RuntimeException e) {

         session.getTransaction().rollback();

         e.printStackTrace();

     } finally {

         session.flush();

         session.close();

     }

		 return null;
	 }
	 
	 public Quydinh ThoiGianGuiToiThieu(String maQD) {
		 Quydinh quydinh = new Quydinh();
		 Session session = config.sessionFactory.openSession();
		 
	     try {

	         // Bat dau 1 transaction (Giao dich)
	    	 session.beginTransaction();
	    	 
	    	 String sql = "from Quydinh qd where qd.maQd =:maQD";
	         Query query = session.createQuery(sql);
	         query.setString("maQD", maQD);
	         ArrayList<Quydinh> result = (ArrayList<Quydinh>) query.list();
	         if(result.size() > 0) {
	        	 System.out.println(result.get(0).getMaQD());
	        	 return result.get(0);
	         }
	         return null;
	         
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
