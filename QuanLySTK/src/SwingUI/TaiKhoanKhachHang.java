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

import model.Sotietkiem;
import model.Taikhoankhachhang;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class TaiKhoanKhachHang extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaTK;
	private JTextField txtHoTen;
	private JTable table;
	private DefaultTableModel tbl_TaiKhoan; 

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
	
	public void LoadDSTaiKhoan(ArrayList<Taikhoankhachhang> tkkh) {
		if(tkkh.size() > 0) {
			tbl_TaiKhoan = (DefaultTableModel) table.getModel();
			tbl_TaiKhoan.setRowCount(0);
			for (int i = 0; i < tkkh.size(); i++) {
				Vector<String> row = new Vector<>();
				int stt = i + 1;
				Taikhoankhachhang tk = tkkh.get(stt);
				row.add(stt + "");
				row.add(tk.getHoTen());
				row.add(tk.getNgaySinh().toString());
				row.add(tk.getGioiTinh());
				row.add(tk.getCmnd());
				row.add(tk.getMaTaiKhoan());
				row.add(tk.getLoaitaikhoan().getTenLoaiTaiKhoan());
				row.add(tk.getDienThoai());
				row.add(tk.getDiaChi());
				row.add(tk.getEmail());
				tbl_TaiKhoan.addRow(row);
			}
		}
	}

	/**
	 * Create the frame.
	 */
	public TaiKhoanKhachHang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKhachHang = new JLabel("TÀI KHOẢN KHÁCH HÀNG");
		lblKhachHang.setForeground(Color.BLUE);
		lblKhachHang.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblKhachHang.setBounds(161, 26, 227, 20);
		contentPane.add(lblKhachHang);
		
		JLabel lblMaTK = new JLabel("M\u00E3 T\u00E0i kho\u1EA3n:");
		lblMaTK.setBounds(50, 78, 78, 14);
		contentPane.add(lblMaTK);
		
		txtMaTK = new JTextField();
		txtMaTK.setColumns(10);
		txtMaTK.setBounds(144, 75, 326, 20);
		contentPane.add(txtMaTK);
		
		JLabel lblHoTen = new JLabel("H\u1ECD v\u00E0 T\u00EAn:");
		lblHoTen.setBounds(50, 111, 78, 14);
		contentPane.add(lblHoTen);
		
		txtHoTen = new JTextField();
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(144, 108, 326, 20);
		contentPane.add(txtHoTen);
		
		JButton btnLapSo = new JButton("Lập Sổ tiết kiệm");
		btnLapSo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LapSoTK lap_so = new LapSoTK();
				lap_so.main(null);	//??????????
			}
		});
		btnLapSo.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLapSo.setBounds(280, 156, 139, 30);
		contentPane.add(btnLapSo);
		
		JButton btnSearch = new JButton("Tìm kiếm");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSearch.setBounds(143, 156, 116, 30);
		contentPane.add(btnSearch);
		
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
		table.setBounds(12, 216, 501, 104);
		contentPane.add(table);
		
	}
}
