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
import model.Sotietkiem;
import model.Taikhoankhachhang;

public class SoTietKiem_DAO {
//	 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	 public int MoSoTk(String maSoTK,String cusName,Loaitietkiem loaiTK , Date ngayMoSo, String soTien,Taikhoankhachhang tkkhachhang) {
	 	Sotietkiem sotk = new Sotietkiem();
	 	 Session session = config.sessionFactory.openSession();
	 	      try {

	          // Bat dau 1 transaction (Giao dich)

	          session.beginTransaction();
	          // Thuc thi cau querry
	          BigDecimal soDu = new BigDecimal(soTien);
	          Sotietkiem soTK = new Sotietkiem( maSoTK, loaiTK, tkkhachhang, new Date(),
	      			new Date(), soDu, loaiTK.getLaiSuat());
	          session.save(soTK);

		         // kết thúc 1 giao dịch

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
	 
	 public Loaitietkiem getLoaiTietKiem(String loaiTK) {
		 Loaitietkiem loaitietkiem = new Loaitietkiem();
		 Session session = config.sessionFactory.openSession();
	      try {
         session.beginTransaction();
         // Thuc thi cau querry
         
         String sql = "from Loaitietkiem ltk where ltk.maLoaiTietKiem =:loaiTk";
         Query query = session.createQuery(sql);
         query.setString("loaiTk", loaiTK);
         ArrayList<Loaitietkiem> result = (ArrayList<Loaitietkiem>) query.list();
         if(result.size() > 0) {
        	 System.out.println(result.get(0).getMaLoaiTietKiem());
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
	 
	 
	 
	 public ArrayList<Sotietkiem> TraCuuSTK() {
			Sotietkiem stk = new Sotietkiem();
			 Session session = config.sessionFactory.openSession();
			 ArrayList<Sotietkiem> stks = new ArrayList();
		     try {

		         // Bat dau 1 transaction (Giao dich)

		         session.beginTransaction();

		         // Thuc thi cau querry

		         String sql = "from Sotietkiem";
		         Query query = session.createQuery(sql);
		       	stks = (ArrayList<Sotietkiem>) query.list();
		       	System.out.println(stks.size() + "abc");
		       	return stks;
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
