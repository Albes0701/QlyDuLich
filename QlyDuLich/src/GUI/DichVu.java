package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Component;
import com.toedter.calendar.JDateChooser;

public class DichVu extends JFrame {
/**
	 * 
	 */
	//	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_MaDichVu;
	private JTextField textField_TenDV;
	private JTable table_KhachHang;
	private JTextField textField_TimKiem;
	private JTextField textField_Gia;
	private JComboBox comboBox_LoaiDV;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DichVu frame = new DichVu();
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
	public DichVu() {
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
		
		Label label = new Label("New label");
		label.setBackground(new Color(0, 128, 255));
		label.setBounds(13, 31, 90, 90);
		panel.add(label);
		
		
		this.getContentPane().add(panel);
		
		Panel KhachHang = new Panel();
		KhachHang.setBounds(13, 127, 960, 495);
		panel.add(KhachHang);
		KhachHang.setLayout(null);
		KhachHang.setBackground(new Color(255, 255, 255));
		
		JLabel lb_TTKH = new JLabel("Thông tin Dịch Vụ");
		lb_TTKH.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_TTKH.setBounds(19, 10, 218, 30);
		KhachHang.add(lb_TTKH);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 50, 249, 246);
		KhachHang.add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		scrollPane.setViewportView(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Mã Dịch Vụ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 28, 92, 20);
		panel_2.add(lblNewLabel_2);
		
		textField_MaDichVu = new JTextField();
		textField_MaDichVu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_MaDichVu.setBounds(112, 26, 125, 26);
		panel_2.add(textField_MaDichVu);
		textField_MaDichVu.setColumns(10);
		
		textField_TenDV = new JTextField();
		textField_TenDV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_TenDV.setColumns(10);
		textField_TenDV.setBounds(112, 113, 125, 26);
		panel_2.add(textField_TenDV);
		
		JButton btnNewButton_Luu = new JButton("Lưu");
		btnNewButton_Luu.setFocusable(false);
		btnNewButton_Luu.setForeground(new Color(255, 255, 255));
		btnNewButton_Luu.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_Luu.setBackground(new Color(255, 128, 64));
		btnNewButton_Luu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_Luu.setBounds(75, 203, 85, 26);
		panel_2.add(btnNewButton_Luu);
		
		String []item_loai = {"Trong nước", "Ngoài nước"};
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Tên Dịch Vụ");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(10, 115, 92, 20);
		panel_2.add(lblNewLabel_2_1_1);
		
		textField_Gia = new JTextField();
		textField_Gia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Gia.setColumns(10);
		textField_Gia.setBounds(112, 156, 125, 26);
		panel_2.add(textField_Gia);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Giá");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_1.setBounds(10, 158, 61, 20);
		panel_2.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Loại Dịch Vụ");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(10, 72, 92, 20);
		panel_2.add(lblNewLabel_2_1);
		
		comboBox_LoaiDV = new JComboBox();
		comboBox_LoaiDV.setBackground(new Color(255, 255, 255));
		comboBox_LoaiDV.setBounds(112, 70, 125, 26);
		panel_2.add(comboBox_LoaiDV);
		

		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(269, 50, 681, 435);
		KhachHang.add(scrollPane_2);
		
		table_KhachHang = new JTable();
		scrollPane_2.setViewportView(table_KhachHang);
		table_KhachHang.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"M\u00E3 D\u1ECBch V\u1EE5", "Lo\u1EA1i D\u1ECBch V\u1EE5", "T\u00EAn D\u1ECBch V\u1EE5", "Gi\u00E1"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_KhachHang.getColumnModel().getColumn(0).setPreferredWidth(70);
		table_KhachHang.getColumnModel().getColumn(1).setPreferredWidth(72);
		table_KhachHang.getColumnModel().getColumn(2).setPreferredWidth(139);
		table_KhachHang.getColumnModel().getColumn(3).setPreferredWidth(100);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(269, 10, 681, 30);
		KhachHang.add(panel_3);
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
