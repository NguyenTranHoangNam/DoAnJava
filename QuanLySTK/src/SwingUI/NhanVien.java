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
		setBounds(100, 100, 582, 355);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblThongTinNV = new JLabel("THÔNG TIN NHÂN VIÊN");
		lblThongTinNV.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblThongTinNV.setBounds(187, 11, 206, 20);
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
		
		JButton btnInsert = new JButton("Thêm Nhân viên");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnInsert.setBounds(136, 126, 136, 30);
		contentPane.add(btnInsert);
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdate.setBounds(284, 127, 109, 29);
		contentPane.add(btnUpdate);
		
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
		tblNhanVien.setBounds(10, 186, 546, 117);
		contentPane.add(tblNhanVien);
		
		JButton btnSearch = new JButton("Tìm kiếm");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSearch.setBounds(403, 127, 109, 28);
		contentPane.add(btnSearch);
	}
}
