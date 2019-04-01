package SwingUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;
import javax.swing.JButton;

public class PhieuGuiTien extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaSo;
	private JTextField txtNgayGui;
	private JTextField txtKhachHang;
	private JTextField txtSoTienGui;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhieuGuiTien frame = new PhieuGuiTien();
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
	public PhieuGuiTien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 225);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPhieuGui = new JLabel("PHI\u1EBEU G\u1EECI TI\u1EC0N");
		lblPhieuGui.setBounds(208, 11, 146, 24);
		lblPhieuGui.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPhieuGui.setForeground(Color.BLUE);
		contentPane.add(lblPhieuGui);
		
		JLabel lblMaSo = new JLabel("M\u00E3 s\u1ED5:");
		lblMaSo.setForeground(Color.BLACK);
		lblMaSo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMaSo.setBounds(27, 59, 78, 14);
		contentPane.add(lblMaSo);
		
		JLabel lblNgayGui = new JLabel("Ng\u00E0y g\u1EEDi:");
		lblNgayGui.setForeground(Color.BLACK);
		lblNgayGui.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNgayGui.setBounds(27, 99, 78, 14);
		contentPane.add(lblNgayGui);
		
		JLabel lblKhachHang = new JLabel("Kh\u00E1ch h\u00E0ng:");
		lblKhachHang.setForeground(Color.BLACK);
		lblKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblKhachHang.setBounds(251, 59, 78, 14);
		contentPane.add(lblKhachHang);
		
		JLabel lblSoTien = new JLabel("S\u1ED1 ti\u1EC1n g\u1EEDi:");
		lblSoTien.setForeground(Color.BLACK);
		lblSoTien.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSoTien.setBounds(251, 99, 78, 14);
		contentPane.add(lblSoTien);
		
		txtMaSo = new JTextField();
		txtMaSo.setColumns(10);
		txtMaSo.setBounds(82, 56, 150, 20);
		contentPane.add(txtMaSo);
		
		txtNgayGui = new JTextField();
		txtNgayGui.setColumns(10);
		txtNgayGui.setBounds(81, 96, 150, 20);
		contentPane.add(txtNgayGui);
		
		txtKhachHang = new JTextField();
		txtKhachHang.setColumns(10);
		txtKhachHang.setBounds(322, 56, 180, 20);
		contentPane.add(txtKhachHang);
		
		txtSoTienGui = new JTextField();
		txtSoTienGui.setColumns(10);
		txtSoTienGui.setBounds(322, 96, 180, 20);
		contentPane.add(txtSoTienGui);
		
		JButton btnXacNhan = new JButton("X\u00E1c Nh\u1EADn");
		btnXacNhan.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXacNhan.setBounds(322, 137, 92, 29);
		contentPane.add(btnXacNhan);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancel.setBounds(424, 137, 78, 29);
		contentPane.add(btnCancel);
		
		txtSoTienGui.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
			      char c = e.getKeyChar();
			      if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
			         e.consume();  
			      }
			   }
			});
		
		txtNgayGui.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
			      char c = e.getKeyChar();
			      if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
			         e.consume();  
			      }
			   }
		});
	}
}
