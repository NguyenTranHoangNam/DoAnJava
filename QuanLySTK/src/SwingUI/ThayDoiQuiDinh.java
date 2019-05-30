package SwingUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import DAO.LoaiTietKiem_DAO;
import DAO.SoTietKiem_DAO;
import model.Loaitietkiem;
import model.Sotietkiem;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThayDoiQuiDinh extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel defaultTable_1; 
	private JTextField tfTenLoaiTK;
	private JTextField tfLaiSuat;
	private String maLoaiTietKiem;
	private JButton btnThemLoaiTiet;
	private JButton btnToar;
	private JButton btnXoaLoaiTiet;
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
		scrollPane.setBounds(6, 34, 642, 196);
		contentPane.add(scrollPane);
		
		defaultTable_1 = new DefaultTableModel(new Object[][] {},new String[] {
				"STT","MA LOAI","TEN LOAI TIET KIEM","LAI SUAT"	
			});
		table = new JTable(defaultTable_1);
		table.setDefaultEditor(Object.class, null);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	        maLoaiTietKiem = table.getValueAt(table.getSelectedRow(), 1).toString();
	        tfTenLoaiTK.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
	        tfLaiSuat.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
	        }
	    });

		
		LoaiTietKiem_DAO ltkD = new LoaiTietKiem_DAO();
		LoadData(ltkD.getLoaiTietKiem());
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("TEN LOAI TIET KIEM");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(6, 256, 130, 16);
		contentPane.add(lblNewLabel);
		
		tfTenLoaiTK = new JTextField();
		tfTenLoaiTK.setBounds(140, 251, 130, 26);
		contentPane.add(tfTenLoaiTK);
		tfTenLoaiTK.setColumns(10);
		tfTenLoaiTK.setEditable(false);
		
		tfLaiSuat = new JTextField();
		tfLaiSuat.setColumns(10);
		tfLaiSuat.setBounds(140, 287, 130, 26);
		contentPane.add(tfLaiSuat);
		
		JLabel lblLaiSuat = new JLabel("LAI SUAT");
		lblLaiSuat.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLaiSuat.setBounds(6, 292, 130, 16);
		contentPane.add(lblLaiSuat);
		
		JButton btnNewButton = new JButton("XAC NHAN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoaiTietKiem_DAO ltk = new LoaiTietKiem_DAO();
				if(maLoaiTietKiem != null) {
					int result = ltk.updateLoaiTietKiem(maLoaiTietKiem, Float.parseFloat(tfLaiSuat.getText()));
					if(result == 1) {
						LoaiTietKiem_DAO ltkD = new LoaiTietKiem_DAO();
						LoadData(ltkD.getLoaiTietKiem());		
					}	
				}
				else {
					JOptionPane.showMessageDialog(null, "Vui long chon loai tiet kiem");
				}
				
			}
		});
		btnNewButton.setBounds(140, 325, 130, 29);
		contentPane.add(btnNewButton);
		
		btnThemLoaiTiet = new JButton("THEM LOAI TIET KIEM");
		btnThemLoaiTiet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemLoaiTK themLTK = new ThemLoaiTK();
				themLTK.main(null);
			}
		});
		btnThemLoaiTiet.setBounds(290, 251, 172, 29);
		contentPane.add(btnThemLoaiTiet);
		
		btnToar = new JButton("THOAT");
		btnToar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnToar.setBounds(6, 325, 117, 29);
		contentPane.add(btnToar);
		
		btnXoaLoaiTiet = new JButton("XOA LOAI TIET KIEM");
		btnXoaLoaiTiet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(maLoaiTietKiem != null) {
					LoaiTietKiem_DAO ltkD = new LoaiTietKiem_DAO();
					int result = ltkD.xoaLoaiTietKiem(maLoaiTietKiem);
					if(result == 1) {
//						JOptionPane.showMessageDialog(null, "Xoa loai tiet kiem thanh cong");
					
						LoadData(ltkD.getLoaiTietKiem());
					}
					else {
						JOptionPane.showMessageDialog(null, "Xoa loai tiet kiem that bai");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Vui long chon loai tiet kiem");
				}
			}
		});
		btnXoaLoaiTiet.setBounds(290, 287, 172, 29);
		contentPane.add(btnXoaLoaiTiet);
	}
	
	public void LoadData(ArrayList<Loaitietkiem> ltks) {
		defaultTable_1.setRowCount(0);
			if(ltks.size() > 0) {
//			defaultTable_1 = (DefaultTableModel) table.getModel();
				LoaiTietKiem_DAO ltkD = new LoaiTietKiem_DAO();
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
