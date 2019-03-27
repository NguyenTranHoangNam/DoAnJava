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
		
		JLabel lblNewLabel = new JLabel("MENU");
		lblNewLabel.setBackground(new Color(51, 153, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 0, 384, 22);
		contentPane.add(lblNewLabel);
		
		JButton btnLap = new JButton("Lập phiếu gửi tiền");
		btnLap.setBounds(31, 77, 149, 29);
		contentPane.add(btnLap);
		
		JButton button = new JButton("Mở sổ tiết kiệm");
		button.setBounds(31, 34, 149, 29);
		contentPane.add(button);
		
		JButton btnLpPhiuRt = new JButton("Lập phiếu rút tiền");
		btnLpPhiuRt.setBounds(31, 118, 149, 29);
		contentPane.add(btnLpPhiuRt);
		
		JButton btnTraCuS = new JButton("Tra cứu sổ");
		btnTraCuS.setBounds(204, 118, 149, 29);
		contentPane.add(btnTraCuS);
		
		JButton btnLpBoCo = new JButton("Lập báo cáo tháng");
		btnLpBoCo.setBounds(204, 34, 149, 29);
		contentPane.add(btnLpBoCo);
		
		JButton btnThayiQuy = new JButton("Thay đổi quy định");
		btnThayiQuy.setBounds(204, 77, 149, 29);
		contentPane.add(btnThayiQuy);
	}
}
