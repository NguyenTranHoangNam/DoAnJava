package DAO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;

import model.Loaitietkiem;
import model.Phieuguitien;
import model.Phieuruttien;
import model.Sotietkiem;
import model.Taikhoankhachhang;

public class PhieuRutTien_DAO {
	 public int phieuRutTien(String maPhieuRut, Sotietkiem maSoTietKiem, Date dateGenerate, String TienRut) {
			 Phieuruttien phieuRut = new Phieuruttien();
			 Session session = config.sessionFactory.openSession();
			 
		     try {

		         // Bat dau 1 transaction (Giao dich)

		         session.beginTransaction();
		         
		         BigDecimal soTienRut = new BigDecimal(TienRut);
		         
		         Phieuguitien phieurut = new Phieuguitien(maPhieuRut, maSoTietKiem, dateGenerate, soTienRut);
		         session.save(phieurut);
		         
		         session.getTransaction().commit();
		         return 1;

		         
		     } catch (RuntimeException e) {

		         session.getTransaction().rollback();

		         e.printStackTrace();

		     } finally {

		         session.flush();

		         session.close();

		     }
			return 0;
		}
	 
	 public Taikhoankhachhang getTaiKhoanKhachHang(String tk) {
		 Taikhoankhachhang kh = new Taikhoankhachhang();
		 Session session = config.sessionFactory.openSession();
	      	try {
	      		session.beginTransaction();
	      		// Thuc thi cau querry
         
	      		String sql = "from Taikhoankhachhang tk where tk.maTaiKhoan =:maTK";
	      		Query query = session.createQuery(sql);
	      		query.setString("maTK", tk);
	      		ArrayList<Taikhoankhachhang> result = (ArrayList<Taikhoankhachhang>) query.list();
	      		if(result.size() > 0) {
	      			System.out.println(result.get(0).getMaTaiKhoan());
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
	 
	 public Sotietkiem getSoTietKiem(String sotk) {
		 Sotietkiem SoTK = new Sotietkiem();
		 Session session = config.sessionFactory.openSession();
	     try {
	    	 session.beginTransaction();
	    	 // Thuc thi cau querry
         
	    	 String sql = "from Sotietkiem stk where stk.maSo =:maSoTK";
	    	 Query query = session.createQuery(sql);
	    	 query.setString("maSoTK", sotk);
	    	 ArrayList<Sotietkiem> result = (ArrayList<Sotietkiem>) query.list();
	    	 if(result.size() > 0) {
	    		 System.out.println(result.get(0).getMaSo());
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
