package SwingUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.LoaiTietKiem_DAO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
interface AddingLoaiTietKiem {
	 // this can be any type of method
	 void resetTableAfterAdd();
	}
public class ThemLoaiTK extends JFrame {

	private JPanel contentPane;
	private JTextField tfMaLoai;
	private JTextField tfThoiHan;
	private JTextField tfLaiSuat;
	private AddingLoaiTietKiem addInterface;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemLoaiTK frame = new ThemLoaiTK(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 public void registerOnGeekEventListener(AddingLoaiTietKiem mListener)

	 {

	 this.addInterface = mListener;

	 }
	 public void doGeekStuff(){
	 if (this.addInterface != null) {
		 addInterface.resetTableAfterAdd();
	 }
	 }

	/**
	 * Create the frame.
	 */
	public ThemLoaiTK(ThayDoiQuiDinh farm) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 379, 238);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfMaLoai = new JTextField();
		tfMaLoai.setBounds(105, 59, 130, 26);
		contentPane.add(tfMaLoai);
		tfMaLoai.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ma Loai");
		lblNewLabel.setBounds(32, 64, 61, 16);
		contentPane.add(lblNewLabel);
		
		tfThoiHan = new JTextField();
		tfThoiHan.setColumns(10);
		tfThoiHan.setBounds(105, 97, 130, 26);
		contentPane.add(tfThoiHan);
		
		JLabel lblThoiHan = new JLabel("Thoi Han");
		lblThoiHan.setBounds(32, 102, 61, 16);
		contentPane.add(lblThoiHan);
		
		tfLaiSuat = new JTextField();
		tfLaiSuat.setColumns(10);
		tfLaiSuat.setBounds(105, 135, 130, 26);
		contentPane.add(tfLaiSuat);
		
		JLabel lblLaiSuat = new JLabel("Lai suat");
		lblLaiSuat.setBounds(32, 140, 61, 16);
		contentPane.add(lblLaiSuat);
		
//		ThemLoaiTK obj = new ThemLoaiTK();
		AddingLoaiTietKiem mListener = new ThayDoiQuiDinh();

		 registerOnGeekEventListener(mListener);

		
		
		JButton btnHuy = new JButton("Huy");
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnHuy.setBounds(247, 97, 117, 29);
		contentPane.add(btnHuy);
		
		JButton btnThem = new JButton("Them");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfLaiSuat.getText() != "" && tfMaLoai.getText() != "" && tfThoiHan.getText() != "") {
					LoaiTietKiem_DAO ltkD = new LoaiTietKiem_DAO();
					int result = ltkD.themLoaiTietKiem(tfMaLoai.getText(), tfThoiHan.getText(),Float.parseFloat(tfLaiSuat.getText()));
					if(result == 1) {
						JOptionPane.showMessageDialog(null, "Them loai tiet kiem thanh cong");
						tfLaiSuat.setText("");
						tfMaLoai.setText("");
						tfThoiHan.setText("");
//						 doGeekStuff();
							LoaiTietKiem_DAO ltD = new LoaiTietKiem_DAO();
						 farm.LoadData(ltkD.getLoaiTietKiem());
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Them loai tiet kiem that bai");
					}
				}
			}
		});
		btnThem.setBounds(247, 59, 117, 29);
		contentPane.add(btnThem);
		
		JLabel lblNewLabel_1 = new JLabel("Them Loai Tiet Kiem");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(6, 6, 367, 26);
		contentPane.add(lblNewLabel_1);
	}
}
