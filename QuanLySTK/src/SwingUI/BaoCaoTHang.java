package SwingUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BaoCaoThang extends JFrame {

	private JPanel contentPane;
	private JTextField txtLoaiTietKiem;
	private JTextField txtThang;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaoCaoThang frame = new BaoCaoThang();
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
	public BaoCaoThang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBaoCao = new JLabel("B\u00C1O C\u00C1O M\u1EDE/\u0110\u00D3NG S\u1ED4 TH\u00C1NG");
		lblBaoCao.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBaoCao.setForeground(Color.BLUE);
		lblBaoCao.setBounds(126, 11, 239, 23);
		contentPane.add(lblBaoCao);
		
		JLabel lblLoaiTietkiem = new JLabel("Lo\u1EA1i ti\u1EBFt ki\u1EC7m:");
		lblLoaiTietkiem.setBounds(35, 54, 73, 14);
		contentPane.add(lblLoaiTietkiem);
		
		JLabel lblThang = new JLabel("Th\u00E1ng:");
		lblThang.setBounds(250, 54, 73, 14);
		contentPane.add(lblThang);
		
		txtLoaiTietKiem = new JTextField();
		txtLoaiTietKiem.setBounds(110, 51, 118, 20);
		contentPane.add(txtLoaiTietKiem);
		txtLoaiTietKiem.setColumns(10);
		
		txtThang = new JTextField();
		txtThang.setColumns(10);
		txtThang.setBounds(303, 51, 118, 20);
		contentPane.add(txtThang);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"STT", "Ng\u00E0y", "S\u1ED1 M\u1EDF", "S\u1ED1 \u0110\u00F3ng", "Ch\u00EAnh L\u1EC7ch"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(57);
		table.getColumnModel().getColumn(1).setPreferredWidth(127);
		table.getColumnModel().getColumn(2).setPreferredWidth(97);
		table.getColumnModel().getColumn(3).setPreferredWidth(84);
		table.getColumnModel().getColumn(4).setPreferredWidth(94);
		table.setBounds(10, 97, 442, 132);
		contentPane.add(table);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnOK.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnOK.setBounds(363, 250, 89, 23);
		contentPane.add(btnOK);
	}
}
