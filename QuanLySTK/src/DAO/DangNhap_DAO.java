package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;
import model.Dangnhap;

public class DangNhap_DAO {
//	 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
public Dangnhap KiemTraDangNhap(String username,String password) {
	Dangnhap dn = new Dangnhap();
	 Session session = config.sessionFactory.openSession();
	 ArrayList<Dangnhap> dns = new ArrayList();
     try {

         // Bat dau 1 transaction (Giao dich)

         session.beginTransaction();

         // Thuc thi cau querry Dang Nhap

         String sql = "from Dangnhap dn where dn.tenDangNhap =:username and dn.matKhau =:password ";
         Query query = session.createQuery(sql);
         query.setString("username", username);
         query.setString("password", password);
         dns = (ArrayList<Dangnhap>) query.list();

         if(dns.size() > 0) {
        	 System.out.println("Dang nhap thanh cong "+ dns.get(0).getTenDangNhap());
        	 return dns.get(0);
         }
         else {
        	 System.out.println("Dang nhap that bai ");
        	 return null;
         }
     } catch (RuntimeException e) {

         session.getTransaction().rollback();

         e.printStackTrace();

     } finally {

         session.flush();

         session.close();

     }
	return dn;
}
}
