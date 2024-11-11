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
import BUS.taikhoanBUS;
import DTO.NhanVienDTO;
import DTO.QuyenDTO;
import DTO.taikhoanDTO;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;

public class taikhoanGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	DefaultTableModel tableModel;
	JButton btn_import;
	QuyenBUS quyenBUS = new QuyenBUS();
//	private JPasswordField passwordField_mk1;
	private JTextField passwordField_mk1;
	private JComboBox comboBox_TK,comboBox_Quyen;
	JButton them_btn,sua_btn,xoa_btn,luu_btn;
	private taikhoanBUS tkBUS = new taikhoanBUS();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					taikhoanGUI frame = new taikhoanGUI();
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
	public taikhoanGUI() {
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
		
		
		JLabel lblNewLabel = new JLabel("Danh sách tài khoản");
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
		scrollPane.setBounds(265, 56, 691, 433);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setDefaultEditor(Object.class,null);
		String[] colname =  {"Tài khoản","Mật khẩu","Quyền",};
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
				
			}
		});
		them_btn.setForeground(Color.WHITE);
		them_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		them_btn.setFocusable(false);
		them_btn.setBackground(new Color(65, 105, 225));
		them_btn.setBounds(420, 21, 75, 25);
		panel_1.add(them_btn);
		
		xoa_btn = new JButton("Xóa");
		xoa_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				luu_btn.setEnabled(false);
				luu_btn.setBackground(Color.gray);
				lockForm();
				taikhoanDTO tk = getSelectedTaiKhoan();
				if(tk!= null) {
					int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa tài khoản " + tk.getUser(),"Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					if(result == JOptionPane.YES_OPTION) {
						xoaTK();
						resetTable();
						initArrayList();
						reSetForm();
					}
				}else JOptionPane.showMessageDialog(null,"Chưa chọn nhân viên");
			}
		});
		xoa_btn.setForeground(Color.WHITE);
		xoa_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		xoa_btn.setFocusable(false);
		xoa_btn.setBackground(Color.RED);
		xoa_btn.setBounds(530, 21, 75, 25);
		panel_1.add(xoa_btn);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 56, 245, 433);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Tài khoản");
		lblNewLabel_3.setBounds(10, 30, 107, 20);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_2.add(lblNewLabel_3);
		
		
		
		

		NhanVienBUS nv = new NhanVienBUS();
		String [] item_nv = nv.getMaNV().toArray(new String [0]);
		comboBox_TK = new JComboBox<>(item_nv);
		comboBox_TK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_TK.setEnabled(false);
		comboBox_TK.setBackground(Color.WHITE);
		comboBox_TK.setBounds(10, 58, 211, 27);
		panel_2.add(comboBox_TK);
		
		JLabel lblNewLabel_3_1 = new JLabel("Mật khẩu");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_1.setBounds(10, 106, 93, 20);
		panel_2.add(lblNewLabel_3_1);
		
		passwordField_mk1 = new JTextField();
		passwordField_mk1.setColumns(10);
		passwordField_mk1.setBounds(10, 136, 211, 27);
		panel_2.add(passwordField_mk1);
		
		JLabel lblNewLabel_2_3 = new JLabel("Quyền");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_3.setBounds(10, 187, 73, 20);
		panel_2.add(lblNewLabel_2_3);
		
		QuyenBUS q = new QuyenBUS();
		String [] item_Quyen = q.getQuyen().toArray(new String [0]);
		comboBox_Quyen = new JComboBox<>(item_Quyen);
		comboBox_Quyen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_Quyen.setEnabled(false);
		comboBox_Quyen.setBackground(Color.WHITE);
		comboBox_Quyen.setBounds(10, 217, 211, 27);
		panel_2.add(comboBox_Quyen);
		
		btn_import = new JButton("Quyền");
		btn_import.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					QuyenGUI q = new QuyenGUI();
					q.setVisible(true);
				}
			});
		btn_import.setForeground(Color.WHITE);
		btn_import.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_import.setFocusable(false);
		btn_import.setBackground(new Color(51, 153, 51));
		btn_import.setBounds(753, 21, 88, 25);
		panel_1.add(btn_import);
		
		sua_btn = new JButton("sửa");
		sua_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(getSelectedTaiKhoan()== null) {
					JOptionPane.showMessageDialog(null, "Chưa chọn tài khoản");
					return;
				}
				lockForm();
				comboBox_Quyen.setEnabled(true);
				them_btn.setBackground(Color.gray);
				them_btn.setEnabled(false);
				xoa_btn.setBackground(Color.gray);
				xoa_btn.setEnabled(false);
				luu_btn.setBackground(Color.orange);
				luu_btn.setEnabled(true);
			}
		});
		sua_btn.setBounds(644, 21, 75, 25);
		panel_1.add(sua_btn);
		sua_btn.setForeground(Color.WHITE);
		sua_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		sua_btn.setFocusable(false);
		sua_btn.setBackground(new Color(50, 205, 50));
		
		JLabel lb_TTKH = new JLabel("Thông tin tài khoản");
		lb_TTKH.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_TTKH.setBounds(42, 17, 182, 30);
		panel_1.add(lb_TTKH);
		
		luu_btn = new JButton("Lưu");

		luu_btn.setForeground(Color.WHITE);
		luu_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		luu_btn.setFocusable(false);
		luu_btn.setEnabled(false);
		luu_btn.setBackground(Color.GRAY);
		luu_btn.setBounds(467, 500, 85, 26);
		panel_1.add(luu_btn);
		luu_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!sua_btn.isEnabled()) {
					if(checkNull()) {
						JOptionPane.showMessageDialog(null, "Vui long dien du thong tin","ERROR",JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					themTK();
					
				}else if(!them_btn.isEnabled()) {
					if(getSelectedTaiKhoan() == null) {
						JOptionPane.showMessageDialog(null, "Chưa chọn tài khoản");
						return;
					}
					suaTK();
				}
				lockForm();
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
		
		lockForm();
//		initArrayList();
	}
	
	
	public void initArrayList() {
		if(taikhoanBUS.tkDTO!=null)
		for(taikhoanDTO tk: taikhoanBUS.tkDTO) {
			tableModel.addRow(new Object[]{
				tk.getUser(),tk.getPass(),tk.getQuyen()
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
	
	public void initForm() {
		this.comboBox_Quyen.setEnabled(true);
		this.comboBox_TK.setEnabled(true);
		this.passwordField_mk1.setEditable(true);
	}
	
	public void reSetForm() {
		this.comboBox_Quyen.setSelectedIndex(0);;
		this.comboBox_TK.setSelectedIndex(0);
		this.passwordField_mk1.setText("");
	}
	
	public void lockForm() {	
		this.comboBox_Quyen.setEnabled(false);
		this.comboBox_TK.setEnabled(false);
		this.passwordField_mk1.setEditable(false);
	}
	
	public void resetTable() {
		DefaultTableModel tableModel =(DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
	}
	
	public boolean checkNull() {
		if(this.passwordField_mk1.getText().isEmpty()) 
		{
			return true;
		}
		return false;
	}
	public taikhoanDTO getSelectedTaiKhoan() {
		int row = table.getSelectedRow();
		if(row == -1) return null;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		String user = model.getValueAt(row, 0) + "";
		String matkhau = model.getValueAt(row, 1) + "";
		String quyen = model.getValueAt(row, 2) + "";
		taikhoanDTO tk = new taikhoanDTO(user, matkhau, quyen);
		return tk;
	}
	
	
	public void hienThiThongTin() {
		taikhoanDTO tk = getSelectedTaiKhoan();
		this.comboBox_TK.setSelectedItem(tk.getUser());
		this.passwordField_mk1.setText(tk.getPass());
		this.comboBox_Quyen.setSelectedItem(tk.getQuyen());
	}
	
	
	public void xoaTK() {
		taikhoanDTO tk = getSelectedTaiKhoan();
		if(tkBUS.xoaTK(tk)!=-1) {
			JOptionPane.showMessageDialog(null,"Xoá thành công");
		}else JOptionPane.showMessageDialog(null,"Không thể xóa nhân viên");
		
	}
	
	public void themTK() {
		taikhoanDTO tk = new taikhoanDTO();
		tk.setUser(this.comboBox_TK.getSelectedItem()+"");
		tk.setPass(this.passwordField_mk1.getText());
		tk.setQuyen(tkBUS.getMaQuyen(this.comboBox_Quyen.getSelectedItem().toString()));
		if(tkBUS.themTK(tk) != -1) {
			JOptionPane.showMessageDialog(null, "Thêm thành công tài khoản");
		}else JOptionPane.showMessageDialog(null, "Không thể thêm tài khoản");
	}
	
	public void suaTK() {
		taikhoanDTO tk = new taikhoanDTO();
		tk.setUser(this.comboBox_TK.getSelectedItem()+"");
		tk.setPass(this.passwordField_mk1.getText());
		tk.setQuyen(tkBUS.getMaQuyen(this.comboBox_Quyen.getSelectedItem().toString()));
		if(tkBUS.updateQuyen(tk) != -1) {
			JOptionPane.showMessageDialog(null,"Sửa thông tin thành công tài khoản " + tk.getUser());
		}
		else if(tkBUS.updateQuyen(tk)==-1)JOptionPane.showMessageDialog(null,"Không thể sửa thông tin tài khoản " + tk.getUser());
		
	}
}
