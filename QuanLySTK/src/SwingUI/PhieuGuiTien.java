package SwingUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import DAO.LoaiTietKiem_DAO;
import DAO.PhieuGuiTien_DAO;
import DAO.SoTietKiem_DAO;
import DAO.QuyDinh_DAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import model.Loaitietkiem;
import model.Phieuguitien;
import model.Quydinh;
import model.Sotietkiem;
import model.Taikhoankhachhang;
import SwingUI.TraCuu;

public class PhieuGuiTien extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaSo;
	private JTextField txtNgayGui;
	private JTextField txtKhachHang;
	private JTextField txtSoTienGui;
	private JTextField txtMaPhieuGui;

	/**
	 * Launch the application.
	 */
	public static void main(String maSotietkiem, String hoTen, String loaiTK) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhieuGuiTien frame = new PhieuGuiTien(maSotietkiem, hoTen,loaiTK);
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
	public PhieuGuiTien(String maSotietkiem, String hoTen, String loaiTK) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 263);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPhieuGui = new JLabel("PHI\u1EBEU G\u1EECI TI\u1EC0N");
		lblPhieuGui.setBounds(208, 11, 146, 24);
		lblPhieuGui.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPhieuGui.setForeground(Color.BLUE);
		contentPane.add(lblPhieuGui);
		
		JLabel lblMaSo = new JLabel("M\u00E3 s\u1ED5:");
		lblMaSo.setForeground(Color.BLACK);
		lblMaSo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMaSo.setBounds(27, 93, 78, 14);
		contentPane.add(lblMaSo);
		
		JLabel lblNgayGui = new JLabel("Ng\u00E0y g\u1EEDi:");
		lblNgayGui.setForeground(Color.BLACK);
		lblNgayGui.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNgayGui.setBounds(27, 133, 78, 14);
		contentPane.add(lblNgayGui);
		
		JLabel lblKhachHang = new JLabel("Kh\u00E1ch h\u00E0ng:");
		lblKhachHang.setForeground(Color.BLACK);
		lblKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblKhachHang.setBounds(268, 93, 78, 14);
		contentPane.add(lblKhachHang);
		
		JLabel lblSoTien = new JLabel("S\u1ED1 ti\u1EC1n g\u1EEDi:");
		lblSoTien.setForeground(Color.BLACK);
		lblSoTien.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSoTien.setBounds(268, 133, 78, 14);
		contentPane.add(lblSoTien);
		
		txtMaSo = new JTextField();
		txtMaSo.setColumns(10);
		txtMaSo.setBounds(107, 90, 125, 20);
		contentPane.add(txtMaSo);
		
		JDateChooser dateNgayGui = new JDateChooser();
		dateNgayGui.setDateFormatString("dd/MM/yyyy");
		dateNgayGui.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dateNgayGui.setBounds(106, 130, 125, 20);
		contentPane.add(dateNgayGui);
		
		txtKhachHang = new JTextField();
		txtKhachHang.setColumns(10);
		txtKhachHang.setBounds(356, 90, 146, 20);
		contentPane.add(txtKhachHang);
		
		txtSoTienGui = new JTextField();
		txtSoTienGui.setColumns(10);
		txtSoTienGui.setBounds(356, 130, 146, 20);
		contentPane.add(txtSoTienGui);
		
		txtMaSo.setText(maSotietkiem);
		txtKhachHang.setText(hoTen);
		
		JButton btnXacNhan = new JButton("X\u00E1c Nh\u1EADn");
		
		btnXacNhan.addActionListener(new ActionListener() {
			@SuppressWarnings("null")
			public void actionPerformed(ActionEvent e) {
				SoTietKiem_DAO stkD = new SoTietKiem_DAO();
				Loaitietkiem ltk = stkD.getLoaiTietKiem(loaiTK);
				
				Sotietkiem stk = stkD.getSoTietKiem(maSotietkiem);
				
				//QuyDinh_DAO qdD = new QuyDinh_DAO();
				//Quydinh qd = qdD.getQuyDinh("QD01");
				
				double so_du, so_tien_gui;
				
				if (ltk.getMaLoaiTietKiem().equals("L01")) {
					//if (Double.parseDouble(txtSoTienGui.getText()) < Double.parseDouble(qd.getChiTiet())){}
					
					if (Double.parseDouble(txtSoTienGui.getText()) < 100000) {
						JOptionPane.showMessageDialog(null, "So tien gui toi thieu phai la 100.000" );
					}
					else {
						PhieuGuiTien_DAO pgtD = new PhieuGuiTien_DAO();
				
						Sotietkiem ma_soTK = pgtD.getSoTietKiem(maSotietkiem);
				
						String date = ((JTextField)dateNgayGui.getDateEditor().getUiComponent()).getText();
						Date dateGenerate = null;
						try {
							dateGenerate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
						} catch (ParseException e1) {
									
							e1.printStackTrace();
						}
						so_tien_gui = Double.parseDouble(txtSoTienGui.getText());
				
						int result = pgtD.phieuGuiTien(txtMaPhieuGui.getText(), ma_soTK, dateGenerate, txtSoTienGui.getText());
						System.out.println(result);
				
						JOptionPane.showMessageDialog(null, "Quy khach da gui " + so_tien_gui + " vao So tiet kiem!");
				
						so_du = stk.getSoDu().doubleValue() + so_tien_gui;//Cap nhat so du tai khoan
						int update = stkD.updateSoTietKiem(maSotietkiem, BigDecimal.valueOf(so_du));//Update so du trong STK
						
					}
				
				}
				else{
					JOptionPane.showMessageDialog(null, "Chi nhan gui tien voi loai tiet kiem 'Khong ky han'");
				
				}
				
			}
		});
		btnXacNhan.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXacNhan.setBounds(322, 171, 92, 29);
		contentPane.add(btnXacNhan);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancel.setBounds(424, 171, 78, 29);
		contentPane.add(btnCancel);
		
		JLabel lblMaPhieuGui = new JLabel("Mã phiếu gửi:");
		lblMaPhieuGui.setForeground(Color.BLACK);
		lblMaPhieuGui.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMaPhieuGui.setBounds(27, 49, 70, 14);
		contentPane.add(lblMaPhieuGui);
		
		txtMaPhieuGui = new JTextField();
		txtMaPhieuGui.setColumns(10);
		txtMaPhieuGui.setBounds(107, 46, 395, 20);
		contentPane.add(txtMaPhieuGui);
		
		txtSoTienGui.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
			      char c = e.getKeyChar();
			      if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
			         e.consume();  
			      }
			   }
		});
	}
}

