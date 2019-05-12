package SwingUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;
import DAO.TaiKhoanKhachHang_DAO;
import model.Taikhoankhachhang;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TaiKhoanKhachHanng extends JFrame {

	private JPanel contentPane;
	private JTextField tfCMND;
	private JTable table;
	private DefaultTableModel defaultTable_1; 
	private JButton btnLapSoTiet;
	private String cmnd;
	private String hoTen;
	private String diaChi;
	private String maTK;
	private JLabel lblCmnd;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaiKhoanKhachHanng frame = new TaiKhoanKhachHanng();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void LoadDSTaiKhoan(ArrayList<Taikhoankhachhang> tkkh) {
		if(tkkh.size() > 0) {
			defaultTable_1 = (DefaultTableModel) table.getModel();
			defaultTable_1.setRowCount(0);
			for (int i = 0; i < tkkh.size(); i++) {
				Vector<String> row = new Vector<>();
				Taikhoankhachhang tk = tkkh.get(i);
				int stt = i + 1;
				row.add(stt + "");
				row.add(tk.getMaTaiKhoan());
				row.add(tk.getHoTen());
				row.add(tk.getNgaySinh().toString());
				row.add(tk.getGioiTinh());
				row.add(tk.getCmnd());
				row.add(tk.getDienThoai());
				row.add(tk.getDiaChi());
				row.add(tk.getEmail());
				defaultTable_1.addRow(row);
			}
		}
	}

	
	/**
	 * Create the frame.
	 */
	public TaiKhoanKhachHanng() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 811, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Taikhoankhachhang tks = new Taikhoankhachhang();
		tfCMND = new JTextField();
		tfCMND.setBounds(108, 74, 130, 26);
		contentPane.add(tfCMND);
		tfCMND.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 125, 799, 275);
		contentPane.add(scrollPane);
		

		defaultTable_1 = new DefaultTableModel(new Object[][] {},new String[] {
				"STT","Mã tài khoản", "Họ và Tên", "Ngày sinh", "Giới tính", "Số CMND",  "Số điện thoại", "Địa chỉ", "Email"
			});	
		
		
		table = new JTable(defaultTable_1);
		TaiKhoanKhachHang_DAO tkkhD = new TaiKhoanKhachHang_DAO();
		LoadDSTaiKhoan(tkkhD.getTKKH());
		scrollPane.setViewportView(table);
		
		 TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
         table.setRowSorter(sorter);

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	            // do some actions here, for example
	            // print first column value from selected row
	        	maTK = table.getValueAt(table.getSelectedRow(), 1).toString();
	        	hoTen = table.getValueAt(table.getSelectedRow(), 2).toString();
	        	cmnd = table.getValueAt(table.getSelectedRow(), 5).toString();
	        	diaChi = table.getValueAt(table.getSelectedRow(), 7).toString();
	        	
	        }
	    });
		btnLapSoTiet = new JButton("LAP SO TIET KIEM");
		btnLapSoTiet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LapSoTK ltk = new LapSoTK(hoTen, cmnd, diaChi, maTK);
				ltk.main(hoTen, cmnd, diaChi, maTK);
			}
		});
		btnLapSoTiet.setBounds(400, 74, 153, 29);
		contentPane.add(btnLapSoTiet);
		
		lblCmnd = new JLabel("CMND");
		lblCmnd.setBounds(35, 79, 61, 16);
		contentPane.add(lblCmnd);
		
		lblNewLabel = new JLabel("THONG TIN KHACH HANG");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 18, 799, 16);
		contentPane.add(lblNewLabel);
		
		tfCMND.getDocument().addDocumentListener(new DocumentListener() {
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
			    	 sorter.setRowFilter(RowFilter.regexFilter("(?i)" + tfCMND.getText()));
			    	 System.out.println(tfCMND.getText());
			  }
			});
		
	}

}
