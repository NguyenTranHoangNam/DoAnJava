package SwingUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import DAO.DangNhap_DAO;
import model.Dangnhap;

public class NhanVien extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaNV;
	private JTextField txtHoTen;
	private JTextField txtNgaySinh;
	private JTextField txtCMND;
	private JTextField txtDienThoai;
	private JTextField txtDiaChi;
	private JTextField txtEmail;
	private JTable tblNhanVien;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVien frame = new NhanVien();
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
	public NhanVien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 576);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblThongTinNV = new JLabel("THÔNG TIN NHÂN VIÊN");
		lblThongTinNV.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblThongTinNV.setBounds(162, 11, 206, 20);
		lblThongTinNV.setForeground(Color.BLUE);
		contentPane.add(lblThongTinNV);
		
		JLabel lblMaNhanVien = new JLabel("Mã Nhân viên: ");
		lblMaNhanVien.setBounds(42, 51, 84, 14);
		contentPane.add(lblMaNhanVien);
		
		txtMaNV = new JTextField();
		txtMaNV.setBounds(136, 48, 378, 20);
		contentPane.add(txtMaNV);
		txtMaNV.setColumns(10);
		
		JLabel lblHoTen = new JLabel("Họ và Tên:");
		lblHoTen.setBounds(43, 82, 78, 14);
		contentPane.add(lblHoTen);
		
		txtHoTen = new JTextField();
		txtHoTen.setBounds(136, 79, 378, 20);
		contentPane.add(txtHoTen);
		txtHoTen.setColumns(10);
		
		JLabel lblNgaySinh = new JLabel("Ngày sinh:");
		lblNgaySinh.setBounds(43, 113, 77, 14);
		contentPane.add(lblNgaySinh);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setBounds(136, 110, 378, 20);
		contentPane.add(txtNgaySinh);
		txtNgaySinh.setColumns(10);
		
		JLabel lblGioiTinh = new JLabel("Giới tính:");
		lblGioiTinh.setBounds(43, 145, 78, 14);
		contentPane.add(lblGioiTinh);
		
		JComboBox cbbGioiTinh = new JComboBox();
		cbbGioiTinh.setBounds(136, 142, 119, 20);
		contentPane.add(cbbGioiTinh);
		
		JLabel lblCMND = new JLabel("Số CMND:");
		lblCMND.setBounds(278, 145, 66, 14);
		contentPane.add(lblCMND);
		
		JLabel lblDienThoai = new JLabel("Số điện thoại:");
		lblDienThoai.setBounds(43, 180, 83, 14);
		contentPane.add(lblDienThoai);
		
		txtCMND = new JTextField();
		txtCMND.setBounds(354, 141, 160, 20);
		contentPane.add(txtCMND);
		txtCMND.setColumns(10);
		
		txtDienThoai = new JTextField();
		txtDienThoai.setBounds(136, 177, 378, 20);
		contentPane.add(txtDienThoai);
		txtDienThoai.setColumns(10);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setBounds(43, 215, 46, 14);
		contentPane.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setText("");
		txtDiaChi.setBounds(136, 212, 378, 20);
		contentPane.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(43, 247, 46, 14);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(136, 243, 378, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnInsert = new JButton("Thêm Nhân viên");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnInsert.setBounds(26, 291, 136, 30);
		contentPane.add(btnInsert);
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdate.setBounds(172, 292, 109, 29);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Xoá Nhân viên");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDelete.setBounds(291, 291, 128, 30);
		contentPane.add(btnDelete);
		
		tblNhanVien = new JTable();
		tblNhanVien.setSurrendersFocusOnKeystroke(true);
		tblNhanVien.setFillsViewportHeight(true);
		tblNhanVien.setToolTipText("");
		tblNhanVien.setCellSelectionEnabled(true);
		tblNhanVien.setColumnSelectionAllowed(true);
		tblNhanVien.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Mã Nhân viên", " Họ và tên", "Ngày sinh", "Giới tính", "Địa chỉ", "Số CMND", "Số điện thoại", "Email"
			}
		));
		tblNhanVien.setForeground(new Color(0, 0, 0));
		tblNhanVien.setBackground(Color.WHITE);
		tblNhanVien.setBounds(10, 350, 546, 141);
		contentPane.add(tblNhanVien);
		
		JButton btnSearch = new JButton("Tìm kiếm");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSearch.setBounds(429, 292, 109, 28);
		contentPane.add(btnSearch);
	}
}
