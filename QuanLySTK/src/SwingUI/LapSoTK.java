package SwingUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.LoaiTietKiem_DAO;
import DAO.SoTietKiem_DAO;
import model.Loaitietkiem;
import model.Taikhoankhachhang;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class LapSoTK extends JFrame {

	private JPanel contentPane;
	private JTextField tfMaSo;
	private JTextField tfKhachHang;
	private JTextField tfDiaChi;
	private JTextField tfSoTienGui;
	private JTextField tfCMND;

	/**
	 * Launch the application.
	 */
	public static void main(String hoten,String cmnd, String diaChi, String maTK) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LapSoTK frame = new LapSoTK(hoten,cmnd,diaChi,maTK);
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
	public LapSoTK(String hoten,String cmnd, String diaChi,String maTK) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dateChooser.setBounds(348, 108, 130, 26);
		contentPane.add(dateChooser);
		
		JLabel lblNewLabel = new JLabel("Mo So Tiet Kiem");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 6, 438, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblMaSo = new JLabel("Ma So");
		lblMaSo.setBounds(6, 47, 92, 16);
		contentPane.add(lblMaSo);
		
		tfMaSo = new JTextField();
		tfMaSo.setBounds(98, 42, 130, 26);
		contentPane.add(tfMaSo);
		tfMaSo.setColumns(10);
		
		JLabel lblKhchHng = new JLabel("Khach Hang");
		lblKhchHng.setBounds(6, 80, 92, 16);
		contentPane.add(lblKhchHng);
		
		tfKhachHang = new JTextField();
		tfKhachHang.setColumns(10);
		tfKhachHang.setBounds(98, 75, 130, 26);
		contentPane.add(tfKhachHang);
		
		JLabel lblaCh = new JLabel("Dia Chi");
		lblaCh.setBounds(6, 113, 92, 16);
		contentPane.add(lblaCh);
		
		tfDiaChi = new JTextField();
		tfDiaChi.setColumns(10);
		tfDiaChi.setBounds(98, 108, 130, 26);
		contentPane.add(tfDiaChi);
		
		JLabel lblSTinGi = new JLabel("So Tien");
		lblSTinGi.setBounds(6, 146, 92, 16);
		contentPane.add(lblSTinGi);
		
		tfSoTienGui = new JTextField();
		tfSoTienGui.setColumns(10);
		tfSoTienGui.setBounds(98, 141, 130, 26);
		contentPane.add(tfSoTienGui);
		
		JLabel lblLoiTitKim = new JLabel("Loai TK");
		lblLoiTitKim.setBounds(244, 47, 108, 16);
		contentPane.add(lblLoiTitKim);
		
		JLabel lblCmnd = new JLabel("CMND:");
		lblCmnd.setBounds(244, 80, 108, 16);
		contentPane.add(lblCmnd);
		
		tfCMND = new JTextField();
		tfCMND.setColumns(10);
		tfCMND.setBounds(348, 75, 130, 26);
		contentPane.add(tfCMND);
		
		JLabel lblNgyMS = new JLabel("Ngay Mo So");
		lblNgyMS.setBounds(244, 113, 108, 16);
		contentPane.add(lblNgyMS);
		
		JComboBox cbLoaiTk = new JComboBox();
		cbLoaiTk.setBounds(348, 42, 130, 27);
		contentPane.add(cbLoaiTk);
		
		cbLoaiTk.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Khong ky han ","6 Thang","3 Thang" }));
		tfKhachHang.setText(hoten);
		tfCMND.setText(cmnd);
		tfDiaChi.setText(diaChi);
		JButton btnXacNhan = new JButton("Xac Nhan");
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String date = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
				Date dateGenerate = null;
				try {
					dateGenerate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				SoTietKiem_DAO stk = new SoTietKiem_DAO();
				Loaitietkiem loaiTK = stk.getLoaiTietKiem("L01");
				Taikhoankhachhang tkkh = stk.getTaiKhoanKhachHang(maTK);

				int result = stk.MoSoTk(tfMaSo.getText(),"TK0001",loaiTK,dateGenerate,tfSoTienGui.getText(),tkkh);
				System.out.println(result);
			}
		});
		btnXacNhan.setBounds(347, 179, 131, 29);
		contentPane.add(btnXacNhan);
		
		JButton btnHuy = new JButton("Huy");
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnHuy.setBounds(92, 179, 136, 29);
		contentPane.add(btnHuy);
		
		
		tfSoTienGui.addKeyListener(new KeyAdapter() {
			   public void keyTyped(KeyEvent e) {
				      char c = e.getKeyChar();
				      if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
				         e.consume();  // ignore event
				      }
				   }
				});
		
		tfCMND.addKeyListener(new KeyAdapter() {
			   public void keyTyped(KeyEvent e) {
				      char c = e.getKeyChar();
				      if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE))  {
				         e.consume();  // ignore event
				      }
				   }
				});
		
		

	}
}
