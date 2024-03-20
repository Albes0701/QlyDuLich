package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.PublicKey;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.ScrollPaneConstants;
import java.awt.Cursor;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.border.CompoundBorder;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import BUS.KhachHangBUS;
import BUS.KiemTra;
import BUS.NhanVienBUS;
import DTO.KhachHangDTO;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Component;

public class KhachHang extends JFrame {

//	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_MSKH;
	private JTextField textField_HoKH;
	private JTextField textField_TenKH;
	private JTextField textField_SDT;
	private JTable table_KhachHang;
	private JTextField textField_TimKiem;
	private JTextField textField_Email;
	private DefaultTableModel tableModel;
	JComboBox comboBox_gioitinh;
	JComboBox comboBox_dotuoi ;
	JTextArea textArea;
    KhachHangBUS khBus = new KhachHangBUS();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KhachHang frame = new KhachHang();
					frame.setSize(1000, 650);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public KhachHang() {
		setBackground(SystemColor.windowText);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.setVerifyInputWhenFocusTarget(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(34, 99, 138));
		panel.setBounds(0, -19, 1000, 632);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btn_QLTour = new JButton("Quản lý Tours");
		btn_QLTour.setBorderPainted(false);
		btn_QLTour.setFocusable(false);
		btn_QLTour.setBorder(null);
		btn_QLTour.setBackground(new Color(24, 171, 138));
		btn_QLTour.setForeground(new Color(255, 255, 255));
		btn_QLTour.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_QLTour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new QuanLyTour();
			}
		});
		btn_QLTour.setBounds(126, 65, 120, 40);
		panel.add(btn_QLTour);
		
		
		JButton btn_KHTour = new JButton("Kế hoạch Tours");
		btn_KHTour.setForeground(Color.WHITE);
		btn_KHTour.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_KHTour.setFocusable(false);
		btn_KHTour.setBorderPainted(false);
		btn_KHTour.setBorder(null);
		btn_KHTour.setBackground(new Color(24, 171, 138));
		btn_KHTour.setBounds(273, 65, 120, 40);
		btn_KHTour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new KHTourGUI();
			}
		});
		btn_QLTour.setBounds(126, 65, 120, 40);
		panel.add(btn_KHTour);
		
		
		JButton btn_QLDV = new JButton("Quản lý dịch vụ");
		btn_QLDV.setFocusable(false);
		btn_QLDV.setBorder(null);
		btn_QLDV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new DichVu();
			}
		});
		btn_QLDV.setForeground(new Color(255, 255, 255));
		btn_QLDV.setBackground(new Color(24, 171, 138));
		btn_QLDV.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_QLDV.setBounds(420, 65, 120, 40);
		panel.add(btn_QLDV);
		
		JButton btn_KhachHang = new JButton("Khách hàng");
		btn_KhachHang.setFocusable(false);
		btn_KhachHang.setBorder(null);
		btn_KhachHang.setForeground(new Color(255, 255, 255));
		btn_KhachHang.setBackground(new Color(24, 171, 138));
		btn_KhachHang.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_KhachHang.setBounds(853, 65, 120, 40);
		panel.add(btn_KhachHang);
		btn_KhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new KhachHang();
			}
		});
		
		JButton btn_NhanVien = new JButton("Nhân viên");
		btn_NhanVien.setFocusable(false);
		btn_NhanVien.setBorder(null);
		btn_NhanVien.setForeground(new Color(255, 255, 255));
		btn_NhanVien.setBackground(new Color(24, 171, 138));
		btn_NhanVien.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_NhanVien.setBounds(708, 65, 120, 40);
		panel.add(btn_NhanVien);
		btn_NhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new NhanVien();
			}
		});
		
		JButton btn_KhuyenMai = new JButton("Khuyến mãi");
		btn_KhuyenMai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new KhuyenMai();
			}
		});
		btn_KhuyenMai.setFocusable(false);
		btn_KhuyenMai.setBorder(null);
		btn_KhuyenMai.setForeground(new Color(255, 255, 255));
		btn_KhuyenMai.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_KhuyenMai.setBackground(new Color(24, 171, 138));
		btn_KhuyenMai.setBounds(564, 65, 120, 40);
		panel.add(btn_KhuyenMai);
		
		JButton btnNewButton_2 = new JButton("Đổi mật khẩu");
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(849, 24, 124, 30);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("User");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(768, 25, 90, 30);
		panel.add(lblNewLabel);
		
		ImageIcon image = new ImageIcon("src\\Images\\logo.png");
		JLabel label = new JLabel();
		label.setBackground(new Color(0, 128, 255));
		label.setBounds(13, 31, 90, 90);
		Image img = image.getImage();
		Image imgScale = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaleIcon = new ImageIcon(imgScale);
		label.setIcon(scaleIcon);
		panel.add(label);
		
		this.getContentPane().add(panel);
		
		Panel KhachHang = new Panel();
		KhachHang.setBounds(13, 127, 960, 495);
		panel.add(KhachHang);
		KhachHang.setLayout(null);
		KhachHang.setBackground(new Color(255, 255, 255));
		
		JLabel lb_TTKH = new JLabel("Thông tin Khách Hàng");
		lb_TTKH.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_TTKH.setBounds(19, 10, 218, 30);
		KhachHang.add(lb_TTKH);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 50, 227, 435);
		KhachHang.add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		scrollPane.setViewportView(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Mã số");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 32, 45, 13);
		panel_2.add(lblNewLabel_2);
		
		textField_MSKH = new JTextField();
		textField_MSKH.setEnabled(false);
		textField_MSKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_MSKH.setBounds(81, 26, 134, 26);
		panel_2.add(textField_MSKH);
		textField_MSKH.setColumns(10);
		
		textField_HoKH = new JTextField();
		textField_HoKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_HoKH.setColumns(10);
		textField_HoKH.setBounds(81, 72, 134, 26);
		panel_2.add(textField_HoKH);
		
		JLabel lblNewLabel_2_1 = new JLabel("Họ đệm");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(10, 74, 61, 20);
		panel_2.add(lblNewLabel_2_1);
		
		textField_TenKH = new JTextField();
		textField_TenKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_TenKH.setColumns(10);
		textField_TenKH.setBounds(81, 117, 134, 26);
		panel_2.add(textField_TenKH);
		
		JLabel lblNewLabel_2_2 = new JLabel("Tên");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(10, 123, 45, 13);
		panel_2.add(lblNewLabel_2_2);
		
		String [] item_gender = {"Nam","Nữ"};
		
		JLabel lblNewLabel_2_4 = new JLabel("Địa chỉ");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_4.setBounds(10, 241, 61, 20);
		panel_2.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_4_1 = new JLabel("SĐT");
		lblNewLabel_2_4_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_4_1.setBounds(10, 324, 61, 20);
		panel_2.add(lblNewLabel_2_4_1);
		
		textField_SDT = new JTextField();
		textField_SDT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_SDT.setColumns(10);
		textField_SDT.setBounds(81, 318, 134, 26);
		panel_2.add(textField_SDT);
		
		JButton btnNewButton_Luu = new JButton("Lưu");
		btnNewButton_Luu.setFocusable(false);
		btnNewButton_Luu.setForeground(new Color(255, 255, 255));
		btnNewButton_Luu.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_Luu.setBackground(new Color(255, 128, 64));
		btnNewButton_Luu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_Luu.setBounds(65, 397, 85, 26);
		panel_2.add(btnNewButton_Luu);
		
		JLabel lblNewLabel_2_4_1_1 = new JLabel("Email");
		lblNewLabel_2_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_4_1_1.setBounds(10, 356, 61, 20);
		panel_2.add(lblNewLabel_2_4_1_1);
		
		textField_Email = new JTextField();
		textField_Email.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Email.setColumns(10);
		textField_Email.setBounds(81, 354, 134, 26);
		panel_2.add(textField_Email);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_3.setBounds(10, 261, 205, 47);
		panel_2.add(scrollPane_3);
		
		textArea = new JTextArea();
		scrollPane_3.setViewportView(textArea);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Giới Tính");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_1.setBounds(10, 171, 76, 13);
		panel_2.add(lblNewLabel_2_2_1);
		
		String item_gioitinh[] = {"Nam","Nữ"};
		comboBox_gioitinh = new JComboBox(item_gioitinh);
		comboBox_gioitinh.setBounds(81, 165, 134, 28);
		panel_2.add(comboBox_gioitinh);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Độ tuổi");
		lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_1_1.setBounds(10, 213, 76, 18);
		panel_2.add(lblNewLabel_2_2_1_1);
		
		
		String item_dotuoi[] = {"Người lớn","Trẻ em"};
		comboBox_dotuoi = new JComboBox(item_dotuoi);
		comboBox_dotuoi.setBounds(81, 208, 134, 26);
		panel_2.add(comboBox_dotuoi);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(269, 50, 681, 435);
		KhachHang.add(scrollPane_2);
		
		table_KhachHang = new JTable();
		scrollPane_2.setViewportView(table_KhachHang);
		table_KhachHang.setDefaultEditor(Object.class,null);
		String[] colname =  {"Mã kh","Họ","Tên","Giới tính","Độ tuổi","Địa chỉ","Số điện thoại","Email"};
		tableModel = new DefaultTableModel();
		table_KhachHang.setModel(tableModel);
		tableModel.setColumnIdentifiers(colname);

//		table_KhachHang.getColumnModel().getColumn(1).setPreferredWidth(76);
//		table_KhachHang.getColumnModel().getColumn(2).setPreferredWidth(96);
//		table_KhachHang.getColumnModel().getColumn(5).setPreferredWidth(123);
//		table_KhachHang.getColumnModel().getColumn(6).setPreferredWidth(101);
//		table_KhachHang.getColumnModel().getColumn(7).setPreferredWidth(101);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(269, 10, 681, 30);
		KhachHang.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Tìm kiếm");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 9, 70, 13);
		panel_3.add(lblNewLabel_3);
		
		textField_TimKiem = new JTextField();
		textField_TimKiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_TimKiem.setBounds(81, 3, 160, 25);
		panel_3.add(textField_TimKiem);
		textField_TimKiem.setColumns(10);
		
		JButton sua_btn = new JButton("Sửa");
		sua_btn.setForeground(Color.WHITE);
		sua_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		sua_btn.setFocusable(false);
		sua_btn.setBackground(new Color(50, 205, 50));
		sua_btn.setBounds(439, 3, 75, 25);
		panel_3.add(sua_btn);
		
		JButton xoa_btn = new JButton("Xóa");
		xoa_btn.setForeground(Color.WHITE);
		xoa_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		xoa_btn.setFocusable(false);
		xoa_btn.setBackground(Color.RED);
		xoa_btn.setBounds(524, 3, 75, 25);
		panel_3.add(xoa_btn);
		
		JComboBox timkiem_cb = new JComboBox(new Object[]{});
		timkiem_cb.setBounds(251, 3, 100, 25);
		panel_3.add(timkiem_cb);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(13, 127, 863, 495);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Thông tin tours");
		lblNewLabel_1.setBounds(29, 10, 134, 30);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_1.add(lblNewLabel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(new Rectangle(0, 0, 190, 300));
		scrollPane_1.setAutoscrolls(true);
		scrollPane_1.setEnabled(false);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(29, 68, 190, 300);
		panel_1.add(scrollPane_1);
		
		
		initData();
		
		this.setVisible(true);
	}
	
	
	public void initData() {
		if(khBus.docKH()) {
			for(KhachHangDTO kh : KhachHangBUS.khDTO ) {
				tableModel.addRow(new Object[] {
						kh.getMakh(), kh.getHokh(), kh.getTenkh(), KiemTra.getInstance().GioiTinh(kh.isGioitinh()), kh.getDotuoi(), kh.getDiachi(), kh.getSdt(), kh.getEmail()
				});
			}
			
	     table_KhachHang.addMouseListener( new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						if(e.getClickCount() == 1) {
							hienThiThongTin();
						}
					}
	     });
	     
	     
		}
	}
	public KhachHangDTO getSelectedKhachHang() {
		int row = table_KhachHang.getSelectedRow();
//		if(row == -1) return null;
		DefaultTableModel model = (DefaultTableModel) table_KhachHang.getModel();
		String makh = model.getValueAt(row, 0)+ "";
		String hokh = model.getValueAt(row, 1)+ "";
		String tenkh = model.getValueAt(row, 2)+ "";
		Boolean gioitinh =  KiemTra.getInstance().GioiTinh((String)model.getValueAt(row, 3) );
		
		String dotuoi = model.getValueAt(row, 4)+ "";
		String diachi = model.getValueAt(row, 5)+ "";
		String sdt = model.getValueAt(row, 6)+ "";
		String email = model.getValueAt(row, 7)+ "";


        KhachHangDTO kh = new KhachHangDTO(makh, hokh, tenkh, dotuoi, diachi, sdt, email, gioitinh,0);
   
        return kh;



		
	}
	public void hienThiThongTin() {
        KhachHangDTO kh =  getSelectedKhachHang();
        this.textField_MSKH.setText(kh.getMakh());
        this.textField_HoKH.setText(kh.getHokh());
        this.textField_TenKH.setText(kh.getTenkh());
        this.comboBox_gioitinh.setSelectedItem(KiemTra.getInstance().GioiTinh(kh.isGioitinh()));
        this.comboBox_dotuoi.setSelectedIndex(0);

        this.textArea.setText(kh.getDiachi());
        this.textField_SDT.setText(kh.getSdt());
        this.textField_Email.setText(kh.getEmail());
	}
	
}
