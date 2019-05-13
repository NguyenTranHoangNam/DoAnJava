package SwingUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.DangNhap_DAO;
import model.Dangnhap;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class DangNhap extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsername;
	private JButton btnLogin;
	private JPasswordField tfPassword;
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
		
		JLabel lblUsername = new JLabel("Tên đăng nhập:");
		lblUsername.setBounds(38, 71, 112, 14);
		contentPane.add(lblUsername);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(146, 68, 239, 20);
		contentPane.add(tfUsername);
		tfUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Mật khẩu:");
		lblPassword.setBounds(38, 101, 95, 14);
		contentPane.add(lblPassword);
		
		JButton btnLogin = new JButton("Đăng nhập");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DangNhap_DAO dnDao = new DangNhap_DAO();
				if(tfUsername.getText() != "" && tfPassword.getText() != "") {
					Dangnhap dn = dnDao.KiemTraDangNhap(tfUsername.getText(), tfPassword.getText());
					if(dn != null) {
						Menu mn = new Menu();
						mn.main();
						dispose();
					}
					else {
							JOptionPane.showMessageDialog(null, "Dang nhap that bai");
						}
				}
			}
		});
		btnLogin.setBounds(146, 149, 117, 29);
		contentPane.add(btnLogin);
		
		tfPassword = new JPasswordField();
		tfPassword.setBounds(146, 95, 239, 20);
		contentPane.add(tfPassword);
	}
}
