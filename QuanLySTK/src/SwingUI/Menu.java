package SwingUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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
		lblMenu.setBackground(new Color(51, 153, 255));
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setBounds(6, 0, 384, 22);
		contentPane.add(lblMenu);
		
		JButton btnGuiTien = new JButton("Lập phiếu gửi tiền");
		btnGuiTien.setBounds(31, 77, 149, 29);
		contentPane.add(btnGuiTien);
		
		JButton btnMoSo = new JButton("Mở sổ tiết kiệm");
		btnMoSo.setBounds(31, 34, 149, 29);
		contentPane.add(btnMoSo);
		
		JButton btnRutTien = new JButton("Lập phiếu rút tiền");
		btnRutTien.setBounds(31, 118, 149, 29);
		contentPane.add(btnRutTien);
		
		JButton btnTraCuuSo = new JButton("Tra cứu sổ");
		btnTraCuuSo.setBounds(204, 118, 149, 29);
		contentPane.add(btnTraCuuSo);
		
		JButton btnBaoCao = new JButton("Lập báo cáo tháng");
		btnBaoCao.setBounds(204, 34, 149, 29);
		contentPane.add(btnBaoCao);
		
		JButton btnThayDoiQD = new JButton("Thay đổi quy định");
		btnThayDoiQD.setBounds(204, 77, 149, 29);
		contentPane.add(btnThayDoiQD);
	}
}
