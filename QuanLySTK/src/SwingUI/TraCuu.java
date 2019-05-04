package SwingUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.SoTietKiem_DAO;
import model.Loaitietkiem;
import model.Sotietkiem;
import model.Taikhoankhachhang;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TraCuu extends JFrame {

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
					TraCuu frame = new TraCuu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	public void LoadData(ArrayList<Sotietkiem> stks) {
		if(stks.size() > 0) {
			defaultTable_1 = (DefaultTableModel) table.getModel();
			defaultTable_1.setRowCount(0);
			for (int i = 0; i < stks.size(); i++) {
				Vector<String> row = new Vector<>();
				Sotietkiem stk = stks.get(i);
				int stt = i + 1;
				row.add(stt + "");
				row.add(stk.getMaSo());
				row.add(stk.getLoaitietkiem().getMaLoaiTietKiem() + "");
				row.add(stk.getTaikhoankhachhang().getMaTaiKhoan() + "");
				row.add(stk.getSoDu() + "");
				defaultTable_1.addRow(row);
			}
		}
	}

	
	/**
	 * Create the frame.
	 */
	public TraCuu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 110, 531, 207);
		contentPane.add(scrollPane);
		
		defaultTable_1 = new DefaultTableModel(new Object[][] {},new String[] {
			"STT","MA SO","LOAI TIET KIEM","KHACH HANG","SO DU"	
		});
		
		
		table = new JTable(defaultTable_1);
		scrollPane.setViewportView(table);
		
		SoTietKiem_DAO stkD = new SoTietKiem_DAO();
		LoadData(stkD.TraCuuSTK());
		
		JButton btnGuiTien = new JButton("Gui Tien");
		btnGuiTien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				PhieuGuiTien phieu_gui = new PhieuGuiTien();
				phieu_gui.main(null);
			}
		});
		btnGuiTien.setBounds(347, 179, 131, 29);
		contentPane.add(btnGuiTien);
		
		JButton btnRutTien = new JButton("RutTien");
		btnRutTien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				PhieuRutTien phieu_rut = new PhieuRutTien();
				phieu_rut.main(null);
			}
		});
		btnRutTien.setBounds(92, 179, 136, 29);
		contentPane.add(btnRutTien);
		
		JLabel lblNewLabel = new JLabel("TRA CUU SO TIET KIEM");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(34, 82, 531, 29);
		contentPane.add(lblNewLabel);
	}
}


