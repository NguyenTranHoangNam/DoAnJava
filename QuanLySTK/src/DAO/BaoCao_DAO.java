package DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import model.BaoCao;
import model.Loaitietkiem;
import model.Phieuguitien;


public class BaoCao_DAO {
	
		 public List<Object[]> getGiaoDich(Date ngay) {
				
				 Session session = config.sessionFactory.openSession();
				
					try {

			         // Bat dau 1 transaction (Giao dich)

			         session.beginTransaction();

			         // Thuc thi cau querry

			         String sql = "SELECT stk.loaitietkiem.maLoaiTietKiem,SUM( pgt.soTienGui),"
			         		+ "SUM( prt.soTienRut),SUM( pgt.soTienGui) - SUM( prt.soTienRut) "
			         		+ " from Phieuguitien  pgt, Phieuruttien  prt, Sotietkiem stk, Loaitietkiem ltk"
			 				+ " where "
			 				+ "pgt.sotietkiem.maSo = stk.maSo and "
			 				+ "prt.sotietkiem.maSo = stk.maSo and "
			 				+ "pgt.ngayGuiTien = prt.ngayRutTien and "
			 				+ "pgt.ngayGuiTien = :ngay and "
			 				+ "ltk.maLoaiTietKiem = stk.loaitietkiem.maLoaiTietKiem "
			 				+"group by prt.sotietkiem.maSo,pgt.sotietkiem.maSo "
			 				+ "";
			         
//			         String sql = "SELECT Sotietkiem.loaitietkiem.maLoaiTietKiem, SUM( Phieuguitien.soTienGui), SUM( Phieuruttien.soTienRut),SUM( Phieuguitien.soTienGui) - SUM( Phieuruttien.soTienRut) "
//				         		+ " from Phieuguitien  , Phieuruttien  , Sotietkiem , Loaitietkiem "
//				 				+ " where "
//				 				+ "Phieuguitien.sotietkiem.maSo = Sotietkiem.maSo or "
//				 				+ "Phieuruttien.sotietkiem.maSo = Sotietkiem.maSo and "
//				 				+ "Phieuguitien.ngayGuiTien = Phieuruttien.ngayRutTien and "
//				 				+ "Phieuguitien.ngayGuiTien = '2019-06-22' and "
//				 				+ "Loaitietkiem.maLoaiTietKiem = Sotietkiem.loaitietkiem.maLoaiTietKiem "
//				 				+"group by Phieuruttien.sotietkiem.maSo,Phieuguitien.sotietkiem.maSo ";
			         Query query = session.createQuery(sql);
			         query.setDate("ngay", ngay);
			         List<Object[]> ltks  =  query.list();
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
		 

		 public List<Object[]> getBaoCaoThang(String maLoaiTietKiem,Integer thang) {
				
				 Session session = config.sessionFactory.openSession();
				
					try {

			         // Bat dau 1 transaction (Giao dich)

			         session.beginTransaction();

			         // Thuc thi cau querry

			         
			         String sql = "SELECT stk.loaitietkiem.maLoaiTietKiem, SUM(stk), stk.ngayMoSo, stk.ngayDaoHan"
				         		+ " from Sotietkiem stk, Loaitietkiem ltk"
				 				+ " where "
				 				+ "stk.maSo = phieuguitien.maSoTietKiem \n" + 
				 				"and sotietkiem.MaLoaiTietKiem = :maLoaiTK'\n" + 
				 				"and phieuguitien.NgayGuiTien like '%-:thang-%'";
			         
			         Query query = session.createQuery(sql);
			         query.setInteger("thang", thang);
			         query.setString("maLoaiTK", maLoaiTietKiem);
			         
			         List<Object[]> ltks  =  query.list();
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
