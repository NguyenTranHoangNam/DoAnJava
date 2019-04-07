package DAO;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Dangnhap;
import model.Sotietkiem;

public class SoTietKiem_DAO {
	 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	 public int MoSoTk(String maSoTK,String cusName,String loaiTK , String ngayMoSo, String soTien) {
	 	Sotietkiem sotk = new Sotietkiem();
	 	 Session session = sessionFactory.openSession();
	 	      try {

	          // Bat dau 1 transaction (Giao dich)

	          session.beginTransaction();
	          // Thuc thi cau querry
	          
	          
	          
	          String sql = "INSERT INTO Sotietkiem(maSo, taikhoankhachang, loaitietkiem, ngayMoSo, ngayDaoHan, soDu, laiSuat)"
	          		+ " VALUES ('11','TK0001','L01','1','1','1','1')";
	        
	          Query query = session.createQuery(sql);
//	          query.setString("value1", maSoTK);
//	          query.setString("value2", cusName);
//	          query.setString("value3",loaiTK);
//	          query.setString("value4",ngayMoSo);
//	          query.setString("value5",);
//	          query.setString("value6",soTien);
//	          query.setString("value7",'1');
	          int result = query.executeUpdate();
	          return result;
	          
	      } catch (RuntimeException e) {

	          session.getTransaction().rollback();

	          e.printStackTrace();

	      } finally {

	          session.flush();

	          session.close();

	      }
	 	return 0;
	 }
	 
	 public ArrayList<Sotietkiem> TraCuuSTK() {
			Sotietkiem stk = new Sotietkiem();
			 Session session = sessionFactory.openSession();
			 ArrayList<Sotietkiem> stks = new ArrayList();
		     try {

		         // Bat dau 1 transaction (Giao dich)

		         session.beginTransaction();

		         // Thuc thi cau querry

		         String sql = "select * from sotietkiem ";
		         Query query = session.createQuery(sql);
		       	stks = (ArrayList<Sotietkiem>) query.list();
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
