package SwingUI;

import java.awt.BorderLayout;
import java.util.*;
import java.text.*;
import java.time.LocalDate;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Quydinh;
import model.Sotietkiem;

import javax.swing.JLabel;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhieuRutTien frame = new PhieuRutTien();
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
	public PhieuRutTien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 223);
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
		lblMaSo.setBounds(22, 59, 51, 14);
		contentPane.add(lblMaSo);
		
		JLabel lblNgayRut = new JLabel("Ng\u00E0y r\u00FAt:");
		lblNgayRut.setForeground(Color.BLACK);
		lblNgayRut.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNgayRut.setBounds(22, 99, 51, 14);
		contentPane.add(lblNgayRut);
		
		JLabel lblKhachHang = new JLabel("Kh\u00E1ch h\u00E0ng:");
		lblKhachHang.setForeground(Color.BLACK);
		lblKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblKhachHang.setBounds(246, 59, 66, 14);
		contentPane.add(lblKhachHang);
		
		JLabel lblSoTienRut = new JLabel("S\u1ED1 ti\u1EC1n r\u00FAt:");
		lblSoTienRut.setForeground(Color.BLACK);
		lblSoTienRut.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSoTienRut.setBounds(246, 99, 60, 14);
		contentPane.add(lblSoTienRut);
		
		txtMaSo = new JTextField();
		txtMaSo.setColumns(10);
		txtMaSo.setBounds(77, 56, 150, 20);
		contentPane.add(txtMaSo);
		
		txtNgayRut = new JTextField();
		txtNgayRut.setColumns(10);
		txtNgayRut.setBounds(76, 96, 150, 20);
		contentPane.add(txtNgayRut);
		
		txtKhachHang = new JTextField();
		txtKhachHang.setColumns(10);
		txtKhachHang.setBounds(317, 56, 180, 20);
		contentPane.add(txtKhachHang);
		
		txtSoTienRut = new JTextField();
		txtSoTienRut.setColumns(10);
		txtSoTienRut.setBounds(317, 96, 180, 20);
		contentPane.add(txtSoTienRut);
		
		JButton btnXacNhan = new JButton("X\u00E1c Nh\u1EADn");
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Quydinh qd = null;
				
				DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

				Date currentDate = new Date();
				Date date1 = null;
				Date date2 = null;
				
				Sotietkiem stk = null;
				double SoTienConLai, sotienconlai, TienRut;
				TienRut = Double.parseDouble(txtSoTienRut.getText());

				try {
				   String startDate = stk.getNgayMoSo().toString();
				   String endDate = txtNgayRut.getText();

				   date1 = simpleDateFormat.parse(startDate);
				   date2 = simpleDateFormat.parse(endDate);

				   long getDiff = date2.getTime() - date1.getTime();

				   long getDaysDiff = getDiff / (24 * 60 * 60 * 1000);
				   
				   if (qd.getMaQD() == "QD02") {
					   if (getDaysDiff >= Integer.parseInt(qd.getChiTiet())){
						    SoTienConLai = stk.getSoDu().doubleValue() - TienRut; //BigDecimal --> Double
						    BigDecimal.valueOf(SoTienConLai);
						    //Cau lenh Update SoDu so tiet kiem
					   }
					   else {
						   	Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Thong bao");
							alert.setHeaderText(null);
							alert.setContentText("Chi duoc rut tien sau " + qd.getChiTiet() + " ngay mo so!");

							alert.showAndWait();
					   }
				   }
				   
				   
				   Date ngay_dao_han = null;
				   Date ngay_rut = new Date(System.currentTimeMillis());
				   String dao_han = stk.getNgayDaoHan().toString();
				   
				   ngay_dao_han = simpleDateFormat.parse(dao_han);
				   long beforeDiff = ngay_rut.getTime() - ngay_dao_han.getTime();
				   long getBeforeDiff = beforeDiff / (24 * 60 * 60 * 1000);
				   
				   if (getBeforeDiff >= 0){
					    sotienconlai = 0;
					    BigDecimal.valueOf(sotienconlai);
				   }
				   
				}catch (Exception e) {
					   e.printStackTrace();
				}
			}
		});
		btnXacNhan.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXacNhan.setBounds(317, 137, 92, 29);
		contentPane.add(btnXacNhan);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancel.setBounds(419, 137, 78, 29);
		contentPane.add(btnCancel);
		
		txtSoTienRut.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
			      char c = e.getKeyChar();
			      if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
			         e.consume();  
			      }
			   }
			});
		
		txtNgayRut.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
			      char c = e.getKeyChar();
			      if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
			         e.consume();  
			      }
			   }
		});
	}

}
