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
import java.util.Calendar;

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

import com.toedter.calendar.JCalendar;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Component;
import com.toedter.calendar.JDateChooser;

public class QuanLyTour extends JFrame {
/**
	 * 
	 */
	//	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_MaTour;
	private JTextField textField_SoNgay;
	private JTable table_KhachHang;
	private JTextField textField_TimKiem;
	private JTextField textField_TenTour;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyTour frame = new QuanLyTour();
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
	public QuanLyTour() {
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
		
		Panel QLTour = new Panel();
		QLTour.setBounds(13, 127, 960, 495);
		panel.add(QLTour);
		QLTour.setLayout(null);
		QLTour.setBackground(new Color(255, 255, 255));
		
		JLabel lb_TTKH = new JLabel("Thông tin Tour");
		lb_TTKH.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_TTKH.setBounds(19, 10, 218, 30);
		QLTour.add(lb_TTKH);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 50, 227, 435);
		QLTour.add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		scrollPane.setViewportView(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Mã Tour");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 32, 61, 13);
		panel_2.add(lblNewLabel_2);
		
		textField_MaTour = new JTextField();
		textField_MaTour.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_MaTour.setBounds(90, 26, 125, 26);
		panel_2.add(textField_MaTour);
		textField_MaTour.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Loại Tour");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(10, 70, 73, 20);
		panel_2.add(lblNewLabel_2_1);
		
		textField_SoNgay = new JTextField();
		textField_SoNgay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_SoNgay.setColumns(10);
		textField_SoNgay.setBounds(90, 211, 125, 26);
		panel_2.add(textField_SoNgay);
		
		JLabel lblNewLabel_ = new JLabel("Số Ngày");
		lblNewLabel_.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_.setBounds(10, 213, 61, 20);
		panel_2.add(lblNewLabel_);
		
		JLabel lblNewLabel_2_3 = new JLabel("Khởi hành");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_3.setBounds(10, 259, 85, 13);
		panel_2.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Nơi đến");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_4.setBounds(10, 301, 61, 20);
		panel_2.add(lblNewLabel_2_4);
		
		JButton btnNewButton_Luu = new JButton("Lưu");
		btnNewButton_Luu.setFocusable(false);
		btnNewButton_Luu.setForeground(new Color(255, 255, 255));
		btnNewButton_Luu.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_Luu.setBackground(new Color(255, 128, 64));
		btnNewButton_Luu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_Luu.setBounds(66, 348, 85, 26);
		panel_2.add(btnNewButton_Luu);
		JComboBox comboBox_KhoiHanh = new JComboBox<>();
		comboBox_KhoiHanh.setBackground(new Color(255, 255, 255));
		comboBox_KhoiHanh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_KhoiHanh.setBounds(91, 254, 124, 26);
		panel_2.add(comboBox_KhoiHanh);
		
		String []item_loai = {"Trong nước", "Ngoài nước"};
		JComboBox comboBox_LoaiTour = new JComboBox<>(item_loai);
		comboBox_LoaiTour.setBackground(new Color(255, 255, 255));
		comboBox_LoaiTour.setBounds(91, 69, 123, 26);
		panel_2.add(comboBox_LoaiTour);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Tên Tour");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(10, 110, 73, 20);
		panel_2.add(lblNewLabel_2_1_1);
		
		textField_TenTour = new JTextField();
		textField_TenTour.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_TenTour.setBounds(10, 140, 205, 61);
		panel_2.add(textField_TenTour);
		textField_TenTour.setColumns(10);
		
		JComboBox comboBox_NoiDen = new JComboBox();
		comboBox_NoiDen.setBackground(new Color(255, 255, 255));
		comboBox_NoiDen.setBounds(91, 300, 124, 26);
		panel_2.add(comboBox_NoiDen);
		

//		textField_NgayVL = new JTextField();
//		textField_NgayVL.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		textField_NgayVL.setColumns(10);
//		textField_NgayVL.setBounds(81, 315, 134, 26);
//		panel_2.add(textField_NgayVL);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(269, 50, 681, 435);
		QLTour.add(scrollPane_2);
		
		table_KhachHang = new JTable();
		scrollPane_2.setViewportView(table_KhachHang);
		table_KhachHang.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 Tour", "Lo\u1EA1i Tour", "T\u00EAn Tour", "S\u1ED1 Ng\u00E0y", "Kh\u1EDFi h\u00E0nh", "N\u01A1i \u0111\u1EBFn"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_KhachHang.getColumnModel().getColumn(1).setPreferredWidth(80);
		table_KhachHang.getColumnModel().getColumn(2).setPreferredWidth(139);
		table_KhachHang.getColumnModel().getColumn(3).setPreferredWidth(52);
		table_KhachHang.getColumnModel().getColumn(5).setPreferredWidth(88);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(269, 10, 681, 30);
		QLTour.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton_Xoa = new JButton("Xóa");
		btnNewButton_Xoa.setFocusable(false);
		btnNewButton_Xoa.setBackground(new Color(255, 0, 0));
		btnNewButton_Xoa.setForeground(new Color(255, 255, 255));
		btnNewButton_Xoa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_Xoa.setBounds(596, 3, 75, 25);
		panel_3.add(btnNewButton_Xoa);
		
		JButton btnNewButton_Sua = new JButton("Sửa");
		btnNewButton_Sua.setFocusable(false);
		btnNewButton_Sua.setBackground(new Color(50, 205, 50));
		btnNewButton_Sua.setForeground(new Color(255, 255, 255));
		btnNewButton_Sua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_Sua.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_Sua.setBounds(511, 3, 75, 25);
		panel_3.add(btnNewButton_Sua);
		
		JButton btnNewButton_Them = new JButton("Thêm");
		btnNewButton_Them.setFocusable(false);
		btnNewButton_Them.setForeground(new Color(255, 255, 255));
		btnNewButton_Them.setBackground(new Color(65, 105, 225));
		btnNewButton_Them.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_Them.setBounds(427, 3, 75, 25);
		panel_3.add(btnNewButton_Them);
		
		JLabel lblNewLabel_3 = new JLabel("Tìm kiếm");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 9, 70, 13);
		panel_3.add(lblNewLabel_3);
		
		textField_TimKiem = new JTextField();
		textField_TimKiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_TimKiem.setBounds(81, 3, 160, 25);
		panel_3.add(textField_TimKiem);
		textField_TimKiem.setColumns(10);
		
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
		
		this.setVisible(true);
	}
}
