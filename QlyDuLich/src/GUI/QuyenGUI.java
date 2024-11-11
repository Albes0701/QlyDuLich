package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BUS.KiemTra;
import BUS.NhanVienBUS;
import BUS.QuyenBUS;
import DTO.NhanVienDTO;
import DTO.QuyenDTO;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuyenGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField_tenquyen;
	private JButton them_btn,luu_btn,sua_btn,xoa_btn;
	DefaultTableModel tableModel;
	QuyenBUS quyenBUS = new QuyenBUS();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuyenGUI frame = new QuyenGUI();
					frame.setSize(1000, 650);
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
	public QuyenGUI() {
		setBackground(SystemColor.windowText);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(280, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.setVerifyInputWhenFocusTarget(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));


		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 255));
		panel.setBounds(0, 0, 986, 603);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Danh sách quyền");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(10, 10, 966, 29);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 49, 966, 544);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 120, 946, 380);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setDefaultEditor(Object.class,null);
		String[] colname =  {"Mã quyền","Tên quyền",};
		tableModel = new DefaultTableModel();
		table.setModel(tableModel);
		tableModel.setColumnIdentifiers(colname);
		scrollPane.setViewportView(table);
		
		them_btn = new JButton("Thêm");
		them_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				luu_btn.setEnabled(true);
				luu_btn.setBackground(Color.orange);
				xoa_btn.setBackground(Color.gray);
				xoa_btn.setEnabled(false);
				sua_btn.setBackground(Color.gray);
				sua_btn.setEnabled(false);
				reSetForm();
				initForm();
//				if(textField_tenquyen.getText().isEmpty()) {
//					JOptionPane.showMessageDialog(null, "Vui long nhap ten quyen","ERROR",JOptionPane.INFORMATION_MESSAGE);
//					return;
//				}
//				
//				themQuyen();
//				resetTable();
//				initArrayList();
//				reSetForm();
				
			}
		});
		them_btn.setForeground(Color.WHITE);
		them_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		them_btn.setFocusable(false);
		them_btn.setBackground(new Color(65, 105, 225));
		them_btn.setBounds(255, 21, 75, 25);
		panel_1.add(them_btn);
		
		sua_btn = new JButton("Sửa");
		sua_btn.setForeground(Color.WHITE);
		sua_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		sua_btn.setFocusable(false);
		sua_btn.setBackground(new Color(50, 205, 50));
		sua_btn.setBounds(362, 21, 75, 25);
		panel_1.add(sua_btn);
		sua_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				combo
				if(getSelectedQuyen() == null) {
					JOptionPane.showMessageDialog(null, "Chưa chọn quyền");
					return;
				}
				textField_tenquyen.setEditable(true);
				them_btn.setBackground(Color.gray);
				them_btn.setEnabled(false);
				xoa_btn.setBackground(Color.gray);
				xoa_btn.setEnabled(false);
				luu_btn.setBackground(Color.orange);
				luu_btn.setEnabled(true);
//				suaQuyen();
//				resetTable();
//				initArrayList();
//				reSetForm();
			}
		});
		
		xoa_btn = new JButton("Xóa");
		xoa_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuyenDTO q = getSelectedQuyen();
				if(q!= null) {
					int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa quyền " + q.getMaquyen(),"Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					if(result == JOptionPane.YES_OPTION) {
						xoaQuyen();
						resetTable();
						initArrayList();
						reSetForm();
					}
				}else JOptionPane.showMessageDialog(null,"Chưa chọn quyền");
			}
		});
		xoa_btn.setForeground(Color.WHITE);
		xoa_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		xoa_btn.setFocusable(false);
		xoa_btn.setBackground(Color.RED);
		xoa_btn.setBounds(471, 21, 75, 25);
		panel_1.add(xoa_btn);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 57, 946, 53);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Tên quyền");
		lblNewLabel_3.setBounds(10, 16, 107, 20);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_2.add(lblNewLabel_3);
		
		textField_tenquyen = new JTextField();
		textField_tenquyen.setEditable(false);
		textField_tenquyen.setBounds(145, 14, 146, 26);
		panel_2.add(textField_tenquyen);
		textField_tenquyen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_tenquyen.setColumns(10);
		
		JButton btn_import = new JButton("Chi tiết quyền");
		btn_import.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuyenDTO q = getSelectedQuyen(); 
				if(q == null) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn quyền để xem chi tiết");
					return;
				}else {
					CTQuyen ct = new CTQuyen(q.getMaquyen(), q.getTenquyen());
					ct.setVisible(true);
				}
			}
		});
		btn_import.setForeground(Color.WHITE);
		btn_import.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_import.setFocusable(false);
		btn_import.setBackground(new Color(51, 153, 51));
		btn_import.setBounds(582, 22, 128, 25);
		panel_1.add(btn_import);
		
		luu_btn = new JButton("Lưu");
		luu_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!sua_btn.isEnabled()) {
					if(textField_tenquyen.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Vui long dien ten quyen","ERROR",JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					themQuyen();
					
				}else if(!them_btn.isEnabled()) {
					if(getSelectedQuyen() == null) {
						JOptionPane.showMessageDialog(null, "Chưa chọn tài khoản");
						return;
					}
					suaQuyen();
				}
				textField_tenquyen.setEditable(false);
				them_btn.setEnabled(true);
				them_btn.setBackground(Color.blue);
				xoa_btn.setEnabled(true);
				xoa_btn.setBackground(Color.red);
				sua_btn.setEnabled(true);
				sua_btn.setBackground(new Color(50, 205, 50));
				sua_btn.setForeground(new Color(255, 255, 255));
				luu_btn.setEnabled(false);
				luu_btn.setBackground(Color.GRAY);
				resetTable();
				reSetForm();
				initArrayList();
			}
		});
		luu_btn.setForeground(Color.WHITE);
		luu_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		luu_btn.setFocusable(false);
		luu_btn.setEnabled(false);
		luu_btn.setBackground(Color.GRAY);
		luu_btn.setBounds(433, 508, 85, 26);
		panel_1.add(luu_btn);
		initArrayList();
	}
	
	
	public void initArrayList() {
		for(QuyenDTO q: QuyenBUS.quyenDTO) {
			tableModel.addRow(new Object[]{
				q.getMaquyen().toUpperCase(),q.getTenquyen()
			});
		}
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 1) {
					hienThiThongTin();
				}
			}
		});
	}
	
	public void hienThiThongTin() {
		QuyenDTO q = getSelectedQuyen();
		textField_tenquyen.setText(q.getTenquyen());
	}
	public void resetTable() {
		DefaultTableModel tableModel =(DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
	}
	
	public void reSetForm() {
		this.textField_tenquyen.setText("");
	}
	
	public void themQuyen() {
		QuyenDTO q = new QuyenDTO();
		String maquyen =  QuyenBUS.quyenDTO.get(QuyenBUS.quyenDTO.size()-1).getMaquyen();
		maquyen = maquyen.substring(0, maquyen.length()-1) + String.valueOf(QuyenBUS.quyenDTO.size()+1);
		q.setMaquyen(maquyen);
		q.setTenquyen(this.textField_tenquyen.getText());
		if(quyenBUS.themQuyen(q)!=-1) {
			JOptionPane.showMessageDialog(null, "Thêm thành công quyền");
		}else JOptionPane.showMessageDialog(null, "Không thể thêm quyền");
	}
	
	public QuyenDTO getSelectedQuyen() {
		int row = table.getSelectedRow();
		if(row == -1) return null;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		String maquyen = model.getValueAt(row, 0) + "";
		String tenquyen = model.getValueAt(row, 1) + "";
		QuyenDTO q = new QuyenDTO(maquyen.toLowerCase(), tenquyen);
		return q;
	}
	
	public void suaQuyen() {
		QuyenDTO q = getSelectedQuyen();
		if(q == null) return;
		if(textField_tenquyen.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Vui lòng chọn quyền cần sửa");
			return;
		}
		q.setTenquyen(this.textField_tenquyen.getText());
		if(quyenBUS.suaQuyen(q)!=-1) {
			JOptionPane.showMessageDialog(null,"Sửa thành công tên quyền " + q.getTenquyen());
		}
		else if(quyenBUS.suaQuyen(q)==-1)JOptionPane.showMessageDialog(null,"Không thể sửa tên quyền " + q.getTenquyen());
		
	}
	
	public void xoaQuyen() {
		QuyenDTO q = getSelectedQuyen();
		if(quyenBUS.xoaQuyen(q)!=-1) {
			JOptionPane.showMessageDialog(null,"Xoá thành công");
		}else JOptionPane.showMessageDialog(null,"Không thể xóa quyền");
		
	}
	
	public void initForm() {
		textField_tenquyen.setEditable(true);
	}
}
