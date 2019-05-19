package SwingUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

import DAO.BaoCao_DAO;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class BaoCaoNgay extends JFrame {

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
					BaoCaoNgay frame = new BaoCaoNgay();
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
	public BaoCaoNgay() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBaoCaoNgay = new JLabel("BAO CAO DOANH SO HOAT DONG NGAY");
		lblBaoCaoNgay.setHorizontalAlignment(SwingConstants.CENTER);
		lblBaoCaoNgay.setBounds(0, 6, 637, 16);
		contentPane.add(lblBaoCaoNgay);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setBounds(304, 34, 143, 26);
		contentPane.add(dateChooser);
		dateChooser.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				 if ("date".equals(e.getPropertyName())) {
		                System.out.println(e.getPropertyName()
		                    + ": " + (Date) e.getNewValue());
		           }
			}
		});
		
		JLabel lblNewLabel = new JLabel("NGAY");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(224, 34, 68, 26);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 86, 631, 212);
		contentPane.add(scrollPane);
		

		defaultTable_1 = new DefaultTableModel(new Object[][] {},new String[] {
			"STT","LOAI TIET KIEM","TONG THU","TONG CHI","CHENH LECH"	
		});
		table = new JTable(defaultTable_1);
		scrollPane.setViewportView(table);
	}
}
