package DAO;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;

import model.Loaitietkiem;
import model.Phieuguitien;
import model.Sotietkiem;

public class PhieuGuiTien_DAO {
	 public ArrayList<Phieuguitien> getPhieuGuiTien() {
			
			 Session session = config.sessionFactory.openSession();
			 ArrayList<Phieuguitien> pgts = new ArrayList();
		     try {

		         // Bat dau 1 transaction (Giao dich)

		         session.beginTransaction();

		         // Thuc thi cau querry

		         String sql = "from Phieuguitien";
		         Query query = session.createQuery(sql);
		         pgts = (ArrayList<Phieuguitien>) query.list();
		       	System.out.println(pgts.size() + "abc");
		       	return pgts;
		     } catch (RuntimeException e) {

		         session.getTransaction().rollback();

		         e.printStackTrace();

		     } finally {

		         session.flush();

		         session.close();

		     }
			return null;
		}
	 
	 public int themPhieuGuiTien(String maPhieuGui, Sotietkiem maSoTietKiem, Date ngayGuiTien, BigDecimal soTienGui) {
		 Session session = config.sessionFactory.openSession();
		 try {
	            session.beginTransaction();
	            Phieuguitien pgt = new Phieuguitien( maPhieuGui,  maSoTietKiem,  ngayGuiTien, soTienGui);
	            session.save(pgt);
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
