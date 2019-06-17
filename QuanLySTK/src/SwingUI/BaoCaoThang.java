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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JMonthChooser;

import DAO.LoaiTietKiem_DAO;
import model.Loaitietkiem;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;

public class BaoCaoThang extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JComboBox comboBox = new JComboBox();
	Loaitietkiem ltkChoose = null;
	private DefaultTableModel defaultTable_1; 
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
	
	public void loadDataComboBox() {
		LoaiTietKiem_DAO ltkD = new LoaiTietKiem_DAO();
		ArrayList<Loaitietkiem> ltks = ltkD.getLoaiTietKiem();
		
		if(ltks.size() > 0) {
//			ltkChoose = ltks.get(0);
			comboBox.setModel(new DefaultComboBoxModel<Loaitietkiem>(
					ltks.toArray(new Loaitietkiem[0])
					));
		}
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
		lblLoaiTietkiem.setBounds(10, 54, 98, 14);
		contentPane.add(lblLoaiTietkiem);
		
		JLabel lblThang = new JLabel("Th\u00E1ng:");
		lblThang.setBounds(250, 54, 73, 14);
		contentPane.add(lblThang);
		
		defaultTable_1 = new DefaultTableModel(new Object[][] {},new String[] {
				"STT", "Ng\u00E0y", "S\u1ED1 M\u1EDF", "S\u1ED1 \u0110\u00F3ng", "Ch\u00EAnh L\u1EC7ch"
			});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 97, 442, 132);
		contentPane.add(scrollPane);
		table = new JTable(defaultTable_1);
		scrollPane.setViewportView(table);

				table.getColumnModel().getColumn(0).setPreferredWidth(57);
				table.getColumnModel().getColumn(1).setPreferredWidth(127);
				table.getColumnModel().getColumn(2).setPreferredWidth(97);
				table.getColumnModel().getColumn(3).setPreferredWidth(84);
				table.getColumnModel().getColumn(4).setPreferredWidth(94);
		loadDataComboBox();
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnOK.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnOK.setBounds(363, 250, 89, 23);
		contentPane.add(btnOK);
		
		JMonthChooser monthChooser = new JMonthChooser();
		monthChooser.setBounds(304, 45, 137, 26);
		monthChooser.addPropertyChangeListener(new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				 if ("month".equals(e.getPropertyName())) {
			                 System.out.println(  e.getNewValue());
				 }
			}
		});
		contentPane.add(monthChooser);
		
		comboBox.setBounds(109, 46, 116, 27);
		contentPane.add(comboBox);
		
		JButton btnThot = new JButton("Thoát");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		btnThot.setBounds(6, 246, 98, 29);
		contentPane.add(btnThot);
		
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Loaitietkiem ltk = (Loaitietkiem)comboBox.getSelectedItem();
				ltkChoose = ltk;
			}
		});

	}
}
