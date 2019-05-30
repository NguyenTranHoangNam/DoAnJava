package SwingUI;

import java.awt.BorderLayout;
import java.util.*;
import java.text.*;
import java.time.LocalDate;
import java.time.Period;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import DAO.PhieuGuiTien_DAO;
import DAO.PhieuRutTien_DAO;
import DAO.SoTietKiem_DAO;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Loaitietkiem;
import model.Quydinh;
import model.Sotietkiem;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PhieuRutTien extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaSo;
	private JTextField txtNgayRut;
	private JTextField txtKhachHang;
	private JTextField txtSoTienRut;
	private JTextField txtMaPhieuRut;

	/**
	 * Launch the application.
	 */
	public static void main(String maSotietkiem, String hoTen, String loaiTK) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhieuRutTien frame = new PhieuRutTien(maSotietkiem, hoTen, loaiTK);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PhieuRutTien(String maSotietkiem, String hoTen,String loaiTK) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 266);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPhieuRut = new JLabel("PHI\u1EBEU R\u00DAT TI\u1EC0N");
		lblPhieuRut.setForeground(Color.BLUE);
		lblPhieuRut.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPhieuRut.setBounds(203, 11, 146, 24);
		contentPane.add(lblPhieuRut);
		
		JLabel lblMaSo = new JLabel("M\u00E3 s\u1ED5:");
		lblMaSo.setForeground(Color.BLACK);
		lblMaSo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMaSo.setBounds(23, 99, 51, 14);
		contentPane.add(lblMaSo);
		
		JLabel lblNgayRut = new JLabel("Ng\u00E0y r\u00FAt:");
		lblNgayRut.setForeground(Color.BLACK);
		lblNgayRut.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNgayRut.setBounds(23, 139, 51, 14);
		contentPane.add(lblNgayRut);
		
		JLabel lblKhachHang = new JLabel("Kh\u00E1ch h\u00E0ng:");
		lblKhachHang.setForeground(Color.BLACK);
		lblKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblKhachHang.setBounds(265, 99, 66, 14);
		contentPane.add(lblKhachHang);
		
		JLabel lblSoTienRut = new JLabel("S\u1ED1 ti\u1EC1n r\u00FAt:");
		lblSoTienRut.setForeground(Color.BLACK);
		lblSoTienRut.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSoTienRut.setBounds(265, 139, 60, 14);
		contentPane.add(lblSoTienRut);
		
		txtMaSo = new JTextField();
		txtMaSo.setColumns(10);
		txtMaSo.setBounds(93, 96, 143, 20);
		contentPane.add(txtMaSo);
		
		JDateChooser dateNgayRut = new JDateChooser();
		dateNgayRut.setDateFormatString("dd/MM/yyyy");
		dateNgayRut.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dateNgayRut.setBounds(93, 139, 143, 20);
		contentPane.add(dateNgayRut);
		
		txtKhachHang = new JTextField();
		txtKhachHang.setColumns(10);
		txtKhachHang.setBounds(335, 96, 163, 20);
		contentPane.add(txtKhachHang);
		
		txtSoTienRut = new JTextField();
		txtSoTienRut.setColumns(10);
		txtSoTienRut.setBounds(335, 136, 163, 20);
		contentPane.add(txtSoTienRut);
		
		txtMaSo.setText(maSotietkiem);
		txtKhachHang.setText(hoTen);
		
		JButton btnXacNhan = new JButton("X\u00E1c Nh\u1EADn");
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SoTietKiem_DAO stkD = new SoTietKiem_DAO();
				Sotietkiem stk = stkD.getSoTietKiem(maSotietkiem);
				Loaitietkiem ltk = stkD.getLoaiTietKiem(loaiTK);
				
				double SoTienConLai, sotienconlai, TienRut;
				TienRut = Double.parseDouble(txtSoTienRut.getText());

				try {
					PhieuRutTien_DAO prtD = new PhieuRutTien_DAO();
					Sotietkiem ma_soTK = prtD.getSoTietKiem(maSotietkiem);
					
					//String ngay_mo_So = stk.getNgayMoSo().toString();
					//String ngay_rut_Tien = ((JTextField)dateNgayRut.getDateEditor().getUiComponent()).getText();
					String ngay_dao_han = stk.getNgayDaoHan().toString();
					//Date startDate = null;
					//Date endDate = null;
					Date daoHan = null;
					try {
						//startDate = new SimpleDateFormat("dd/MM/yyyy").parse(ngay_mo_So);
						//endDate = new SimpleDateFormat("dd/MM/yyyy").parse(ngay_rut_Tien);
						daoHan = new SimpleDateFormat("dd/MM/yyyy").parse(ngay_dao_han);
						
						//Ngay rut tien - Ngay mo so = 15days
						//long diff_1 = endDate.getTime() - startDate.getTime();
						//long diffDays_1 = diff_1 / (24 * 60 * 60 * 1000);
						
						//Ngay rut tien > Ngay dao han
						//long diff_2 = endDate.getTime() - daoHan.getTime();
						//long diffDays_2 = diff_2 / (24 * 60 * 60 * 1000);
						
						//System.out.print(diffDays_1 + " days, ");
						//System.out.print(diffDays_2 + " days, ");
						
					}catch(ParseException e1) {
						
						e1.printStackTrace();
					}
					
					//Rut tien sau 15 ngay mo so doi voi LoaiTietKiem = Khong ky han
					if (ltk.getMaLoaiTietKiem().equals("L01")) {
						double so_tien_rut, soDu, soTienCon;
						so_tien_rut = Double.parseDouble(txtSoTienRut.getText());
						soDu = stk.getSoDu().doubleValue();
					
						//String ngay_mo_So = stk.getNgayMoSo().toString();
						String ngay_rut_Tien = ((JTextField)dateNgayRut.getDateEditor().getUiComponent()).getText();
						
						//Date startDate = null;
						Date endDate = null;
						//long diff_1, diffDays_1;
						try {
							//startDate = new SimpleDateFormat("dd/MM/yyyy").parse(ngay_mo_So);
							endDate = new SimpleDateFormat("dd/MM/yyyy").parse(ngay_rut_Tien);
							
						}catch(ParseException e1) {
						
							e1.printStackTrace();
						}
						//Ngay rut tien - Ngay mo so = 15days
						//diff_1 = endDate.getTime() - startDate.getTime();
						//diffDays_1 = diff_1 / (24 * 60 * 60 * 1000);
						
						//if (diffDays_1 < 15) {
							if (so_tien_rut <= soDu) {
								int result = prtD.phieuRutTien(txtMaPhieuRut.getText(), ma_soTK, endDate, txtSoTienRut.getText());
								System.out.println(result);
						
								soTienCon = soDu - so_tien_rut;
								int ud = stkD.updateSoTietKiem(maSotietkiem, BigDecimal.valueOf(soTienCon));
						
								JOptionPane.showMessageDialog(null, "Quy khach da rut " + so_tien_rut + " trong So tiet kiem!");
							}
							else {
								JOptionPane.showMessageDialog(null, "So tien rut > So du trong So tiet kiem!");
							}
						//}else {
								//JOptionPane.showMessageDialog(null, "Chi duoc rut tien sau 15 ngay lap so!");
						//}
					}
					else {
						JOptionPane.showMessageDialog(null, "Rut tien sau 15 ngay chi ap dung cho loai tiet kiem 'Khong ky han'!");
					}
				
				   
					//Rut tien voi loai tiet kiem co ky han
					/*if (stk.getNgayDaoHan() != null) {//Voi Loai tiet kiem = Khong ky han => NgayDaoHan = null
						String ngayrut = ((JTextField)dateNgayRut.getDateEditor().getUiComponent()).getText();
						String dao_han = stk.getNgayDaoHan().toString();
				   
						Date ngay_dao_han = null;
						ngay_dao_han = simpleDateFormat.parse(dao_han);
						Date ngay_rut = new SimpleDateFormat("dd/MM/yyyy").parse(ngayrut);//new Date(System.currentTimeMillis());
						
						long beforeDiff = ngay_rut.getTime() - ngay_dao_han.getTime();
						long getBeforeDiff = beforeDiff / (24 * 60 * 60 * 1000);
				   
						if (getBeforeDiff >= 0){
							double tienlai;
							String laisuat = String.valueOf(ltk.getLaiSuat());
							String date = ((JTextField)dateNgayRut.getDateEditor().getUiComponent()).getText();
							Date dateGenerate = null;
							try {
								dateGenerate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
							} catch (ParseException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							
							int result = prtD.phieuRutTien(txtMaPhieuRut.getText(), ma_soTK, dateGenerate, txtSoTienRut.getText());
							System.out.println(result);
							
							sotienconlai = 0;
							
							int ud = stkD.updateSoTietKiem(maSotietkiem, BigDecimal.valueOf(sotienconlai));
							tienlai = Double.parseDouble(laisuat) * Double.parseDouble(ltk.getThoiHan().substring(0));
							
							JOptionPane.showMessageDialog(null, "Quy khach da rut het tien trong So tiet kiem! Lai suat quy khach nhan duoc la " + tienlai);
						}
					}*/
					
					//Rut tien voi loai tiet kiem khong ky han, ngay rut - ngay mo so = 15 --->OK
					/*if (ltk.getMaLoaiTietKiem().equals("L01")) {
						double so_tien_rut, soDu, soTienCon;
						so_tien_rut = Double.parseDouble(txtSoTienRut.getText());
						soDu = stk.getSoDu().doubleValue();
						
						String ngay_rut_Tien = ((JTextField)dateNgayRut.getDateEditor().getUiComponent()).getText();
						Date endDate = null;
						try {
							endDate = new SimpleDateFormat("dd/MM/yyyy").parse(ngay_rut_Tien);
						}catch(ParseException e1) {
							
							e1.printStackTrace();
						}
						 
						if (so_tien_rut <= soDu) {
							int result = prtD.phieuRutTien(txtMaPhieuRut.getText(), ma_soTK, endDate, txtSoTienRut.getText());
							System.out.println(result);
							
							soTienCon = soDu - so_tien_rut;
							int ud = stkD.updateSoTietKiem(maSotietkiem, BigDecimal.valueOf(soTienCon));
							
							JOptionPane.showMessageDialog(null, "Quy khach da rut " + so_tien_rut + " trong So tiet kiem!");
						}
						else {
							JOptionPane.showMessageDialog(null, "So tien rut > So du trong So tiet kiem!");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Rut tien sau 15 ngay chi ap dung cho loai tiet kiem 'Khong ky han'!");
					}*/
				   
				}catch (Exception e) {
						e.printStackTrace();
				}
				
			}
		});
		btnXacNhan.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXacNhan.setBounds(318, 177, 92, 29);
		contentPane.add(btnXacNhan);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancel.setBounds(420, 177, 78, 29);
		contentPane.add(btnCancel);
		
		JLabel lblMaPhieuRut = new JLabel("Mã phiếu rút:");
		lblMaPhieuRut.setForeground(Color.BLACK);
		lblMaPhieuRut.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMaPhieuRut.setBounds(23, 56, 71, 14);
		contentPane.add(lblMaPhieuRut);
		
		txtMaPhieuRut = new JTextField();
		txtMaPhieuRut.setColumns(10);
		txtMaPhieuRut.setBounds(93, 53, 405, 20);
		contentPane.add(txtMaPhieuRut);
		txtMaPhieuRut.setText("PR00");
		
		txtSoTienRut.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
			      char c = e.getKeyChar();
			      if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
			         e.consume();  
			      }
			   }
		});
	}

}
