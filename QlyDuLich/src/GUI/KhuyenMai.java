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
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Component;
import com.toedter.calendar.JDateChooser;

public class KhuyenMai extends JFrame {

//	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_MSKM;
	private JTextField textField_GiamGia;
	private JTable table_KhuyenMai;
	private JTextField textField_TimKiem;
	private JTextField textField_DieuKien;
	private JComboBox comboBox_DoiTuong;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KhuyenMai frame = new KhuyenMai();
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
	public KhuyenMai() {
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
		
		JLabel lb_TTKH = new JLabel("Thông tin Khuyến Mãi");
		lb_TTKH.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_TTKH.setBounds(19, 10, 218, 30);
		KhachHang.add(lb_TTKH);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 50, 249, 435);
		KhachHang.add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		scrollPane.setViewportView(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Mã khuyến mãi");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 27, 120, 20);
		panel_2.add(lblNewLabel_2);
		
		textField_MSKM = new JTextField();
		textField_MSKM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_MSKM.setBounds(127, 25, 110, 26);
		panel_2.add(textField_MSKM);
		textField_MSKM.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tên chương trình");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(10, 65, 144, 20);
		panel_2.add(lblNewLabel_2_1);
		
		String [] item_gender = {"Nam","Nữ"};
		
		textField_GiamGia = new JTextField();
		textField_GiamGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_GiamGia.setColumns(10);
		textField_GiamGia.setBounds(127, 170, 110, 26);
		panel_2.add(textField_GiamGia);
		
		JLabel lblNewLabel_2_4 = new JLabel("Phần trăm (%)");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_4.setBounds(10, 172, 120, 20);
		panel_2.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_4_1 = new JLabel("Ngày bắt đầu");
		lblNewLabel_2_4_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_4_1.setBounds(10, 305, 106, 20);
		panel_2.add(lblNewLabel_2_4_1);
		
		JButton btnNewButton_Luu = new JButton("Lưu");
		btnNewButton_Luu.setFocusable(false);
		btnNewButton_Luu.setForeground(new Color(255, 255, 255));
		btnNewButton_Luu.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_Luu.setBackground(new Color(255, 128, 64));
		btnNewButton_Luu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_Luu.setBounds(84, 397, 85, 26);
		panel_2.add(btnNewButton_Luu);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 100, 227, 52);
		panel_2.add(scrollPane_3);
		
		JTextArea textArea_tenCT = new JTextArea();
		textArea_tenCT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane_3.setViewportView(textArea_tenCT);
		
		JDateChooser dateChooser_NgayBD = new JDateChooser();
		dateChooser_NgayBD.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dateChooser_NgayBD.setBounds(127, 305, 110, 26);
		dateChooser_NgayBD.setDate(Calendar.getInstance().getTime());
		panel_2.add(dateChooser_NgayBD);
		
		JLabel lblNewLabel_2_4_1_1 = new JLabel("Ngày kết thúc");
		lblNewLabel_2_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_4_1_1.setBounds(10, 348, 106, 20);
		panel_2.add(lblNewLabel_2_4_1_1);
		
		JDateChooser dateChooser_NgayKT = new JDateChooser();
		dateChooser_NgayKT.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dateChooser_NgayKT.setBounds(127, 348, 110, 26);
		panel_2.add(dateChooser_NgayKT);
		
		JLabel lblNewLabel_2_2 = new JLabel("<html>Điều</br> kiện (>x)x: số người</html>");
		
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(10, 243, 110, 52);
		panel_2.add(lblNewLabel_2_2);
		
		textField_DieuKien = new JTextField();
		textField_DieuKien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_DieuKien.setColumns(10);
		textField_DieuKien.setBounds(127, 258, 110, 26);
		panel_2.add(textField_DieuKien);
		
		JLabel lblNewLabel_2_3 = new JLabel("Đối tượng");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_3.setBounds(10, 213, 120, 20);
		panel_2.add(lblNewLabel_2_3);
		
		comboBox_DoiTuong = new JComboBox();
		comboBox_DoiTuong.setBackground(new Color(255, 255, 255));
		comboBox_DoiTuong.setBounds(127, 212, 110, 26);
		panel_2.add(comboBox_DoiTuong);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(269, 50, 681, 435);
		KhachHang.add(scrollPane_2);
		
		table_KhuyenMai = new JTable();
		scrollPane_2.setViewportView(table_KhuyenMai);
		table_KhuyenMai.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, "", null, "", null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 khuy\u1EBFn m\u00E3i", "T\u00EAn ch\u01B0\u01A1ng tr\u00ECnh", "Ph\u1EA7n tr\u0103m", "\u0110\u1ED1i t\u01B0\u1EE3ng", "\u0110i\u1EC1u ki\u1EC7n", "Ng\u00E0y B\u1EAFt \u0110\u1EA7u", "Ng\u00E0y k\u1EBFt th\u00FAc", "T\u00ECnh tr\u1EA1ng"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_KhuyenMai.getColumnModel().getColumn(0).setPreferredWidth(90);
		table_KhuyenMai.getColumnModel().getColumn(1).setPreferredWidth(140);
		table_KhuyenMai.getColumnModel().getColumn(2).setPreferredWidth(70);
		table_KhuyenMai.getColumnModel().getColumn(3).setPreferredWidth(70);
		table_KhuyenMai.getColumnModel().getColumn(4).setPreferredWidth(70);
		table_KhuyenMai.getColumnModel().getColumn(5).setPreferredWidth(100);
		table_KhuyenMai.getColumnModel().getColumn(6).setPreferredWidth(100);
		
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
