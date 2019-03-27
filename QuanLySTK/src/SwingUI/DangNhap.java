package SwingUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.DangNhap_DAO;
import model.Dangnhap;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DangNhap extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsername;
	private JTextField tfPassword;
	private JButton btnLogin;
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(45, 80, 75, 16);
		contentPane.add(lblNewLabel);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(124, 75, 130, 26);
		contentPane.add(tfUsername);
		tfUsername.setColumns(10);
		
		tfPassword = new JTextField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(124, 108, 130, 26);
		contentPane.add(tfPassword);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(45, 113, 75, 16);
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
					}
				}
				
				
			}
		});
		btnLogin.setBounds(134, 149, 117, 29);
		contentPane.add(btnLogin);
	}
}
