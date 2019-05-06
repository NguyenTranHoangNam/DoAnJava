package SwingUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.LoaiTietKiem_DAO;
import DAO.SoTietKiem_DAO;
import model.Loaitietkiem;
import model.Sotietkiem;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ThayDoiQuiDinh extends JFrame {

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
					ThayDoiQuiDinh frame = new ThayDoiQuiDinh();
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
	public ThayDoiQuiDinh() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 77, 642, 196);
		contentPane.add(scrollPane);
		
		defaultTable_1 = new DefaultTableModel(new Object[][] {},new String[] {
				"STT","MA LOAI","TEN LOAI TIET KIEM","LAI SUAT"	
			});
		table = new JTable(defaultTable_1);
		LoaiTietKiem_DAO ltkD = new LoaiTietKiem_DAO();
		LoadData(ltkD.getLoaiTietKiem());
		scrollPane.setViewportView(table);
	}
	
	public void LoadData(ArrayList<Loaitietkiem> ltks) {
		if(ltks.size() > 0) {
			defaultTable_1 = (DefaultTableModel) table.getModel();
			defaultTable_1.setRowCount(0);
			for (int i = 0; i < ltks.size(); i++) {
				Vector<String> row = new Vector<>();
				Loaitietkiem ltk = ltks.get(i);
				int stt = i + 1;
				row.add(stt + "");
				row.add(ltk.getMaLoaiTietKiem());
				row.add(ltk.getThoiHan());
				row.add(ltk.getLaiSuat() + "");
				defaultTable_1.addRow(row);
			}
		}
	}
}
