package bus;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DangNhap extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenDN;
	private JPasswordField pssMatKhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhap frame = new DangNhap();
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
	public DangNhap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDangNhap = new JLabel("\u0110\u0102NG NH\u1EACP");
		lblDangNhap.setForeground(Color.BLUE);
		lblDangNhap.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDangNhap.setBounds(170, 28, 107, 20);
		contentPane.add(lblDangNhap);
		
		txtTenDN = new JTextField();
		txtTenDN.setBounds(146, 68, 239, 20);
		contentPane.add(txtTenDN);
		txtTenDN.setColumns(10);
		
		JLabel lblTenDN = new JLabel("T\u00EAn \u0110\u0103ng nh\u1EADp:");
		lblTenDN.setBounds(38, 71, 112, 14);
		contentPane.add(lblTenDN);
		
		JLabel lblMatKhau = new JLabel("M\u1EADt kh\u1EA9u:");
		lblMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMatKhau.setBounds(38, 101, 95, 14);
		contentPane.add(lblMatKhau);
		
		pssMatKhau = new JPasswordField();
		pssMatKhau.setBounds(146, 99, 239, 20);
		contentPane.add(pssMatKhau);
		
		JButton btnDangNhap = new JButton("\u0110\u0103ng Nh\u1EADp");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDangNhap.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDangNhap.setBounds(278, 141, 107, 29);
		contentPane.add(btnDangNhap);
	}
}
