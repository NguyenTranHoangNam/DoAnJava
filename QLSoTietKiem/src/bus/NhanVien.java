package bus;

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

public class NhanVien extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaNV;
	private JTextField txtHoTen;
	private JTextField txtNgaySinh;
	private JTextField txtCMND;
	private JTextField txtDienThoai;
	private JTextField txtDiaChi;
	private JTextField textField;
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
		
		JLabel lblThongTinNV = new JLabel("TH\u00D4NG TIN NH\u00C2N VI\u00CAN");
		lblThongTinNV.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblThongTinNV.setBounds(162, 11, 206, 20);
		lblThongTinNV.setForeground(Color.BLUE);
		contentPane.add(lblThongTinNV);
		
		JLabel lblMNhnVin = new JLabel("M\u00E3 Nh\u00E2n vi\u00EAn: ");
		lblMNhnVin.setBounds(42, 51, 84, 14);
		contentPane.add(lblMNhnVin);
		
		txtMaNV = new JTextField();
		txtMaNV.setBounds(136, 48, 378, 20);
		contentPane.add(txtMaNV);
		txtMaNV.setColumns(10);
		
		JLabel lblHoTen = new JLabel("H\u1ECD v\u00E0 T\u00EAn:");
		lblHoTen.setBounds(43, 82, 78, 14);
		contentPane.add(lblHoTen);
		
		txtHoTen = new JTextField();
		txtHoTen.setBounds(136, 79, 378, 20);
		contentPane.add(txtHoTen);
		txtHoTen.setColumns(10);
		
		JLabel lblNgaySinh = new JLabel("Ng\u00E0y sinh:");
		lblNgaySinh.setBounds(43, 113, 77, 14);
		contentPane.add(lblNgaySinh);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setBounds(136, 110, 378, 20);
		contentPane.add(txtNgaySinh);
		txtNgaySinh.setColumns(10);
		
		JLabel lblGioiTinh = new JLabel("Gi\u1EDBi t\u00EDnh:");
		lblGioiTinh.setBounds(43, 145, 78, 14);
		contentPane.add(lblGioiTinh);
		
		JComboBox cbbGioiTinh = new JComboBox();
		cbbGioiTinh.setBounds(136, 142, 119, 20);
		contentPane.add(cbbGioiTinh);
		
		JLabel lblCMND = new JLabel("S\u1ED1 CMND:");
		lblCMND.setBounds(278, 145, 66, 14);
		contentPane.add(lblCMND);
		
		JLabel lblSinThoi = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i:");
		lblSinThoi.setBounds(43, 180, 83, 14);
		contentPane.add(lblSinThoi);
		
		txtCMND = new JTextField();
		txtCMND.setBounds(354, 141, 160, 20);
		contentPane.add(txtCMND);
		txtCMND.setColumns(10);
		
		txtDienThoai = new JTextField();
		txtDienThoai.setBounds(136, 177, 378, 20);
		contentPane.add(txtDienThoai);
		txtDienThoai.setColumns(10);
		
		JLabel lblDiaChi = new JLabel("\u0110\u1ECBa ch\u1EC9:");
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
		
		textField = new JTextField();
		textField.setBounds(136, 243, 378, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnInsert = new JButton("Th\u00EAm Nh\u00E2n vi\u00EAn");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnInsert.setBounds(26, 291, 136, 30);
		contentPane.add(btnInsert);
		
		JButton btnUpdate = new JButton("C\u1EADp nh\u1EADt ");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdate.setBounds(172, 292, 109, 29);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Xo\u00E1 Nh\u00E2n vi\u00EAn");
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
				"M\u00E3 Nh\u00E2n vi\u00EAn", " H\u1ECD v\u00E0 T\u00EAn", "Ng\u00E0y sinh", "Gi\u1EDBi t\u00EDnh", "\u0110\u1ECBa ch\u1EC9", "S\u1ED1 CMND", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "Email"
			}
		));
		tblNhanVien.setForeground(new Color(0, 0, 0));
		tblNhanVien.setBackground(Color.WHITE);
		tblNhanVien.setBounds(10, 350, 546, 141);
		contentPane.add(tblNhanVien);
		
		JButton btnSearch = new JButton("T\u00ECm ki\u1EBFm");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSearch.setBounds(429, 292, 109, 28);
		contentPane.add(btnSearch);
	}
}
