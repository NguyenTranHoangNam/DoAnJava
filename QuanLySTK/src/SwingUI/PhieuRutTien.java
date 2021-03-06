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
import DAO.QuyDinh_DAO;
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
	public static void main(String maSotietkiem, String hoTen, String loaiTK, String soDu) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhieuRutTien frame = new PhieuRutTien(maSotietkiem, hoTen, loaiTK, soDu);
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
	public PhieuRutTien(String maSotietkiem, String hoTen,String loaiTK, String soDu) {
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
		txtSoTienRut.setText(soDu);
		
		JButton btnXacNhan = new JButton("X\u00E1c Nh\u1EADn");
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SoTietKiem_DAO stkD = new SoTietKiem_DAO();
				Sotietkiem stk = stkD.getSoTietKiem(maSotietkiem);
				Loaitietkiem ltk = stkD.getLoaiTietKiem(loaiTK);
				//QuyDinh_DAO qdD = new QuyDinh_DAO();
				
				//Quydinh qd = qdD.ThoiGianGuiToiThieu("QD02");
				
				double sotienconlai;

				try {
					PhieuRutTien_DAO prtD = new PhieuRutTien_DAO();
					Sotietkiem ma_soTK = prtD.getSoTietKiem(maSotietkiem);
					
					String ngay_mo_So = stk.getNgayMoSo().toString();	//--->Lay du lieu tu CSDL dang yyyy-MM-dd
					String ngay_dao_Han = stk.getNgayDaoHan().toString();
					String dateMoSo = null;
					String dateDaoHan = null;
					
			        String[] output_1 = ngay_mo_So.split("-");
			        
					String Nam_1 = output_1[0];
					String Thang_1 = output_1[1];
					String Ngay_1 = output_1[2];
					
					String[] output_2 = ngay_dao_Han.split("-");
			        
					String Nam_2 = output_2[0];
					String Thang_2 = output_2[1];
					String Ngay_2 = output_2[2];
					
					try{
					    dateMoSo = Ngay_1 + "/" + Thang_1 + "/" + Nam_1;
					    dateDaoHan = Ngay_2 + "/" + Thang_2 + "/" + Nam_2;
					}
			        catch (Exception e){
					    
						System.out.println("Error");
					
					}
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					
					String ngay_rut_Tien = ((JTextField)dateNgayRut.getDateEditor().getUiComponent()).getText();
					
					Date startDate = null;
					Date endDate = null;
					Date daoHan = null;
					
					try {
						startDate = format.parse(dateMoSo);
						endDate = format.parse(ngay_rut_Tien);
						daoHan = format.parse(dateDaoHan);
						
					}catch(ParseException e1) {
						
						e1.printStackTrace();
					}
					
					//Rut tien sau 15 ngay mo so doi voi LoaiTietKiem = Khong ky han
					if (ltk.getMaLoaiTietKiem().equals("L01")) {
						double so_tien_rut, soDu, soTienCon, laiSuat;
						so_tien_rut = Double.parseDouble(txtSoTienRut.getText());
						soDu = stk.getSoDu().doubleValue();
						//int ngayMin = Integer.parseInt(qd.getChiTiet());
						
						//Ngay rut tien - Ngay mo so = 15days
						long diff_1 = endDate.getTime() - startDate.getTime();
						long diffDays_1 = diff_1 / (24 * 60 * 60 * 1000);
						
						if (diffDays_1 > 15) {
							if (so_tien_rut <= soDu) {
								int result = prtD.phieuRutTien(txtMaPhieuRut.getText(), ma_soTK, endDate, txtSoTienRut.getText());
								System.out.println(result);
						
								soTienCon = soDu - so_tien_rut;
								int ud = stkD.updateSoTietKiem(maSotietkiem, BigDecimal.valueOf(soTienCon));
								
								if (diffDays_1 >= 31) {
									laiSuat = 0.0015 * soDu;
									JOptionPane.showMessageDialog(null, "Quy khach da rut " + so_tien_rut + " trong So tiet kiem! Lai suat nhan duoc la " + laiSuat);
								}
								else {
									JOptionPane.showMessageDialog(null, "Quy khach da rut " + so_tien_rut + " trong So tiet kiem!");
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "So tien rut > So du trong So tiet kiem!");
							}
						}else {
								JOptionPane.showMessageDialog(null, "Chi duoc rut tien sau 15 ngay lap so!");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Rut tien sau 15 ngay chi ap dung cho loai tiet kiem 'Khong ky han'!");
					}
					
					//Rut tien voi loai tiet kiem co ky han
					if (!ltk.getMaLoaiTietKiem().equals("L01")) {
						
						//Ngay rut tien >= Ngay dao han
						long diff_2 = endDate.getTime() - daoHan.getTime();
						long diffDays_2 = diff_2 / (24 * 60 * 60 * 1000);
					   
						if (diffDays_2 >= 0){
							double tienlai;
							String laisuat = String.valueOf(stk.getLaiSuat());
								
							int result = prtD.phieuRutTien(txtMaPhieuRut.getText(), ma_soTK, endDate, txtSoTienRut.getText());
							System.out.println(result);
								
							sotienconlai = 0;
								
							int ud = stkD.updateSoTietKiem(maSotietkiem, BigDecimal.valueOf(sotienconlai));
							tienlai = Double.parseDouble(laisuat) * stk.getSoDu().doubleValue(); 
								
							JOptionPane.showMessageDialog(null, "Quy khach da rut het tien trong So tiet kiem! Lai suat quy khach nhan duoc la " + tienlai);
						}
					}
					
					
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



/*
 *
 */



