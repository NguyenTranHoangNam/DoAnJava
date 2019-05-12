package DAO;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;

import model.Loaitietkiem;
import model.Taikhoankhachhang;

public class TaiKhoanKhachHang_DAO {

	public ArrayList<Taikhoankhachhang> getTKKH() {
		
		 Session session = config.sessionFactory.openSession();
		 ArrayList<Taikhoankhachhang> tkkh = new ArrayList();
	     try {
	         session.beginTransaction();
	         String sql = "from Taikhoankhachhang";
	         Query query = session.createQuery(sql);
	         tkkh = (ArrayList<Taikhoankhachhang>) query.list();
	       	System.out.println(tkkh.size() + "abc");
	       	return tkkh;
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
