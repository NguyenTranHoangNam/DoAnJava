package SwingUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BaoCaoTHang extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel defaultTable_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaoCaoTHang frame = new BaoCaoTHang();
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
	public BaoCaoTHang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 597, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BAO CAO MO / DONG SO THANG");
		lblNewLabel.setBounds(5, 5, 440, 16);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(121, 50, 111, 27);
		contentPane.add(comboBox);
		
		JLabel lblLoaiTietKiem = new JLabel("LOAI TIET KIEM");
		lblLoaiTietKiem.setBounds(14, 53, 95, 16);
		contentPane.add(lblLoaiTietKiem);
		
		JLabel lblThang = new JLabel("THANG");
		lblThang.setBounds(244, 54, 61, 16);
		contentPane.add(lblThang);
		
		JMonthChooser monthChooser = new JMonthChooser();
		monthChooser.setBounds(296, 50, 137, 26);
		contentPane.add(monthChooser);
		
		JButton btnTimKiem = new JButton("TIM KIEM");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTimKiem.setBounds(457, 49, 117, 29);
		contentPane.add(btnTimKiem);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 98, 560, 181);
		contentPane.add(scrollPane);
		
		defaultTable_1 = new DefaultTableModel(new Object[][] {},new String[] {
				"STT","MA SO","LOAI TIET KIEM","KHACH HANG","SO DU"	
			});
			table = new JTable(defaultTable_1);
			scrollPane.setViewportView(table);
	}
}
