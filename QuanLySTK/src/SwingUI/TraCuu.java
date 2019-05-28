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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import DAO.SoTietKiem_DAO;
import model.Loaitietkiem;
import model.Sotietkiem;
import model.Taikhoankhachhang;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.RowFilter;

public class TraCuu extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel defaultTable_1; 
	private JTextField tfMaSoTietKiem;
	private String maSotietkiem;
	private String hoTen;
	private String loaiTK;

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
		scrollPane.setBounds(34, 77, 531, 240);
		contentPane.add(scrollPane);
		
		defaultTable_1 = new DefaultTableModel(new Object[][] {},new String[] {
			"STT","MA SO","LOAI TIET KIEM","KHACH HANG","SO DU"	
		});
		
		
		table = new JTable(defaultTable_1);
		scrollPane.setViewportView(table);
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
        table.setRowSorter(sorter);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	            // do some actions here, for example
	            // print first column value from selected row
	        	maSotietkiem = table.getValueAt(table.getSelectedRow(), 1).toString();
	        	hoTen = table.getValueAt(table.getSelectedRow(), 3).toString();
	        	loaiTK = table.getValueAt(table.getSelectedRow(), 2).toString();
	        }
	    });
		
		SoTietKiem_DAO stkD = new SoTietKiem_DAO();
		LoadData(stkD.TraCuuSTK());
		
		JLabel lblNewLabel = new JLabel("TRA CUU SO TIET KIEM");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(34, 3, 531, 29);
		contentPane.add(lblNewLabel);
		
		JButton btnThoat = new JButton("Thoat");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThoat.setBounds(27, 329, 124, 29);
		contentPane.add(btnThoat);
		
		tfMaSoTietKiem = new JTextField();
		tfMaSoTietKiem.setBounds(152, 44, 130, 26);
		contentPane.add(tfMaSoTietKiem);
		tfMaSoTietKiem.setColumns(10);
		
		JLabel lblMaSoTiet = new JLabel("MA SO TIET KIEM");
		lblMaSoTiet.setBounds(34, 49, 106, 16);
		contentPane.add(lblMaSoTiet);
		
		JButton btnPhieuGuiTien = new JButton("LAP PHIEU GUI");
		btnPhieuGuiTien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PhieuGuiTien phieu_gui = new PhieuGuiTien(maSotietkiem, hoTen,loaiTK);
				phieu_gui.main(maSotietkiem, hoTen,loaiTK);
			}
		});
		btnPhieuGuiTien.setBounds(294, 44, 117, 29);
		contentPane.add(btnPhieuGuiTien);
		
		JButton btnPhieuRutTien = new JButton("LAP PHIEU RUT");
		btnPhieuRutTien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PhieuRutTien phieu_rut = new PhieuRutTien(maSotietkiem, hoTen,loaiTK);
				phieu_rut.main(maSotietkiem, hoTen,loaiTK); 
			}
		});
		btnPhieuRutTien.setBounds(448, 44, 117, 29);
		contentPane.add(btnPhieuRutTien);
		
		tfMaSoTietKiem.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
//				  updateText();
			  }
			  public void removeUpdate(DocumentEvent e) {
				  updateText();
			  }
			  public void insertUpdate(DocumentEvent e) {
				  updateText();
			  }
			  public void updateText() {
			    	 sorter.setRowFilter(RowFilter.regexFilter("(?i)" + tfMaSoTietKiem.getText()));
			    	
			  }
			});

	}
}


