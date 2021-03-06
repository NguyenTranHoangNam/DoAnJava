package SwingUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 396, 245);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenu = new JLabel("MENU");
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMenu.setBackground(new Color(51, 153, 255));
		lblMenu.setForeground(Color.BLUE);
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setBounds(6, 0, 384, 22);
		contentPane.add(lblMenu);
		
		JButton btnTaiKhoan = new JButton("Lập Sổ tiết kiệm");
		btnTaiKhoan.setBounds(31, 77, 162, 29);
		contentPane.add(btnTaiKhoan);
		btnTaiKhoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TaiKhoanKhachHanng tk = new TaiKhoanKhachHanng();
				tk.main(null);
//				LapSoTK lapSTK = new LapSoTK();
//				lapSTK.main(null);
			}
		});
		
		/*JButton btnSoTietKiem = new JButton("Sổ tiết kiệm");
		btnSoTietKiem.setBounds(31, 34, 162, 29);
		contentPane.add(btnSoTietKiem);
		btnSoTietKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
			}
		});*/
		
		JButton btnBaoCao = new JButton("Lập báo cáo tháng");
		btnBaoCao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			BaoCaoThang bcThang = new BaoCaoThang();
			bcThang.setVisible(true);
			}
		});
		btnBaoCao.setBounds(204, 34, 162, 29);
		contentPane.add(btnBaoCao);
		
		JButton btnThayDoiQD = new JButton("Thay đổi quy định");
		btnThayDoiQD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThayDoiQuiDinh tdqd = new ThayDoiQuiDinh();
				tdqd.main(null);
			}
		});
		btnThayDoiQD.setBounds(204, 77, 162, 29);
		contentPane.add(btnThayDoiQD);
		
		JButton btnNewButton = new JButton("Tra cứu Sổ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TraCuu tc = new TraCuu();
				tc.main(null);
			}
		});
		btnNewButton.setBounds(31, 34, 162, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Lập báo cáo ngày");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BaoCaoNgay bcNgay = new BaoCaoNgay();
				bcNgay.main(null);
			}
		});
		btnNewButton_1.setBounds(31, 112, 162, 29);
		contentPane.add(btnNewButton_1);
	}
}
