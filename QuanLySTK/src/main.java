import DAO.DangNhap_DAO;
import model.Dangnhap;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DangNhap_DAO dnDao = new DangNhap_DAO();
		Dangnhap dn = dnDao.KiemTraDangNhap("nthnam", "12345");
//		if(dn != null) {
//			System.out.println("Dang nhap thanh cong "+ dn.getTenDangNhap());
//		}
//		if(dn == null) {
//			System.out.println("Dang nhap that bai");
//		}
	}

}
