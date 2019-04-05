package SwingUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class TaiKhoanKhachHang extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaTK;
	private JTextField txtHoTen;
	private JTextField txtNgaySinh;
	private JTextField txtCMND;
	private JTextField txtDienThoai;
	private JTextField txtDiaChi;
	private JTextField txtEmail;
	private JTextField txtLoaiTK;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaiKhoanKhachHang frame = new TaiKhoanKhachHang();
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
	public TaiKhoanKhachHang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKhachHang = new JLabel("TH\u00D4NG TIN T\u00C0I KHO\u1EA2N KH\u00C1CH H\u00C0NG");
		lblKhachHang.setForeground(Color.BLUE);
		lblKhachHang.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblKhachHang.setBounds(143, 26, 316, 20);
		contentPane.add(lblKhachHang);
		
		JLabel lblMaTK = new JLabel("M\u00E3 T\u00E0i kho\u1EA3n:");
		lblMaTK.setBounds(50, 166, 78, 14);
		contentPane.add(lblMaTK);
		
		txtMaTK = new JTextField();
		txtMaTK.setColumns(10);
		txtMaTK.setBounds(144, 163, 132, 20);
		contentPane.add(txtMaTK);
		
		JLabel lblHoTen = new JLabel("H\u1ECD v\u00E0 T\u00EAn:");
		lblHoTen.setBounds(50, 72, 78, 14);
		contentPane.add(lblHoTen);
		
		txtHoTen = new JTextField();
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(144, 69, 392, 20);
		contentPane.add(txtHoTen);
		
		JLabel lblNgaySinh = new JLabel("Ng\u00E0y sinh:");
		lblNgaySinh.setBounds(50, 103, 77, 14);
		contentPane.add(lblNgaySinh);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(144, 100, 392, 20);
		contentPane.add(txtNgaySinh);
		
		JLabel lblGioiTinh = new JLabel("Gi\u1EDBi t\u00EDnh:");
		lblGioiTinh.setBounds(50, 135, 78, 14);
		contentPane.add(lblGioiTinh);
		
		JComboBox cbbGioiTinh = new JComboBox();
		cbbGioiTinh.setBounds(144, 132, 132, 20);
		contentPane.add(cbbGioiTinh);
		cbbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nam","Nữ" }));
		
		JLabel lblCMND = new JLabel("S\u1ED1 CMND:");
		lblCMND.setBounds(298, 135, 66, 14);
		contentPane.add(lblCMND);
		
		JLabel lblDienThoai = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i:");
		lblDienThoai.setBounds(50, 197, 83, 14);
		contentPane.add(lblDienThoai);
		
		txtCMND = new JTextField();
		txtCMND.setColumns(10);
		txtCMND.setBounds(390, 131, 146, 20);
		contentPane.add(txtCMND);
		
		txtDienThoai = new JTextField();
		txtDienThoai.setColumns(10);
		txtDienThoai.setBounds(144, 194, 392, 20);
		contentPane.add(txtDienThoai);
		
		JLabel lblDiaChi = new JLabel("\u0110\u1ECBa ch\u1EC9:");
		lblDiaChi.setBounds(50, 231, 46, 14);
		contentPane.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setText("");
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(144, 228, 392, 20);
		contentPane.add(txtDiaChi);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(50, 266, 46, 14);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(144, 263, 392, 20);
		contentPane.add(txtEmail);
		
		JButton btnUpdate = new JButton("C\u1EADp nh\u1EADt ");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdate.setBounds(168, 307, 109, 29);
		contentPane.add(btnUpdate);
		
		JButton btnLapSo = new JButton("Lập Sổ tiết kiệm");
		btnLapSo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LapSoTK lap_so = new LapSoTK();
				lap_so.main(null);	//??????????
			}
		});
		btnLapSo.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLapSo.setBounds(413, 306, 139, 30);
		contentPane.add(btnLapSo);
		
		JButton btnSearch = new JButton("Tìm kiếm");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSearch.setBounds(287, 306, 116, 30);
		contentPane.add(btnSearch);
		
		JLabel lblLoaiTK = new JLabel("Loại Tài khoản:");
		lblLoaiTK.setBounds(297, 166, 92, 14);
		contentPane.add(lblLoaiTK);
		
		txtLoaiTK = new JTextField();
		txtLoaiTK.setBounds(390, 163, 146, 20);
		contentPane.add(txtLoaiTK);
		txtLoaiTK.setColumns(10);
		
		JButton btnInsert = new JButton("Thêm Khách");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnInsert.setBounds(33, 306, 125, 30);
		contentPane.add(btnInsert);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"STT", "Họ và Tên", "Ngày sinh", "Giới tính", "Số CMND", "Mã Tài khoản", "Loại Tài khoản", "Số điện thoại", "Địa chỉ", "Email"
			}
		));
		table.setBounds(10, 367, 570, 141);
		contentPane.add(table);
		
		txtNgaySinh.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
			      char c = e.getKeyChar();
			      if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
			         e.consume();  
			      }
			   }
			});
		
		txtCMND.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
			      char c = e.getKeyChar();
			      if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
			         e.consume();  
			      }
			   }
			});
		
		txtDienThoai.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
			      char c = e.getKeyChar();
			      if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
			         e.consume();  
			      }
			   }
			});
		
	}
}
