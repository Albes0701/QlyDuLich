package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageProducer;
import java.net.MalformedURLException;
import java.net.URL;

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

import com.toedter.calendar.JDateChooser;

import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class KHTourGUI extends JFrame {

	// private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField timkiem_tf;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KHTourGUI frame = new KHTourGUI();
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
	public KHTourGUI() {
		this.setBackground(SystemColor.windowText);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280, 100, 1000, 650);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
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
		JLabel logo_lb = new JLabel();
		logo_lb.setBackground(new Color(128, 255, 128));
		logo_lb.setPreferredSize(new Dimension(90, 90));
		logo_lb.setBounds(10, 25, 100, 96);
//		ImageIcon originalIcon = new ImageIcon("/Images/vtv-logo.png");
		ImageIcon originalIcon = new ImageIcon("src\\Images\\vtv-logo.png");
		Image originalImage = originalIcon.getImage();
		Image scaledImage = originalImage.getScaledInstance(logo_lb.getPreferredSize().width,
				logo_lb.getPreferredSize().height, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		// logo_lb.setIcon(new
		// ImageIcon(QlyToursGUI.class.getResource("/Images/vtv-logo.png")));
		logo_lb.setIcon(scaledIcon);
		panel.add(logo_lb);

		Panel KHTOUR = new Panel();
		KHTOUR.setBackground(new Color(255, 255, 255));
		KHTOUR.setBounds(13, 127, 960, 495);
		panel.add(KHTOUR);
		KHTOUR.setLayout(null);

		JLabel thongtintour_lb = new JLabel("Thông tin Kế hoạch Tour");
		thongtintour_lb.setForeground(new Color(0, 0, 0));
		thongtintour_lb.setBounds(10, 10, 230, 30);
		thongtintour_lb.setFont(new Font("Tahoma", Font.BOLD, 17));
		KHTOUR.add(thongtintour_lb);

		String[] loaiTour = { "Tour trong nước", "Tour nước ngoài" };

		String[] socho = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
				"18", "19", "20" };

		String[] arr_tinh = { "An Giang", "Bà Rịa – Vũng Tàu", "Bạc Liêu", "Bắc Giang", "Bắc Kạn", "Bắc Ninh",
				"Bến Tre", "Bình Dương", "Bình Định", "Bình Phước", "Bình Thuận", "Cà Mau", "Cao Bằng", "Cần Thơ",
				"Đà Nẵng", "Đắk Lắk", "Đắk Nông", "Điện Biên", "Đồng Nai", "Đồng Tháp", "Gia Lai", "Hà Giang", "Hà Nam",
				"Hà Nội", "Hà Tĩnh", "Hải Dương", "Hải Phòng", "Hậu Giang", "Hòa Bình", "Thành phố Hồ Chí Minh",
				"Hưng Yên", "Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu", "Lạng Sơn", "Lào Cai", "Lâm Đồng",
				"Long An", "Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận", "Phú Thọ", "Phú Yên", "Quảng Bình",
				"Quảng Nam", "Quảng Ngãi", "Quảng Ninh", "Quảng Trị", "Sóc Trăng", "Sơn La", "Tây Ninh", "Thái Bình",
				"Thái Nguyên", "Thanh Hóa", "Thừa Thiên Huế", "Tiền Giang", "Trà Vinh", "Tuyên Quang", "Vĩnh Long",
				"Vĩnh Phúc", "Yên Bái" };

		timkiem_tf = new JTextField();
		timkiem_tf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		timkiem_tf.setBounds(250, 9, 338, 40);
		KHTOUR.add(timkiem_tf);
		timkiem_tf.setColumns(10);

		JButton timkiem_btn = new JButton("TK");
		timkiem_btn.setBackground(new Color(239, 95, 16));
		timkiem_btn.setBorder(null);
		timkiem_btn.setFont(new Font("Tahoma", Font.BOLD, 10));
		timkiem_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		timkiem_btn.setBounds(589, 8, 60, 40);
		KHTOUR.add(timkiem_btn);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setBounds(250, 50, 703, 445);
		KHTOUR.add(scrollPane_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setLayout(null);
		panel_3.setPreferredSize(new Dimension(590, 600));
		KHTOUR.setBackground(new Color(255, 255, 255));
		scrollPane_2.setViewportView(panel_3);

		JScrollPane table_sp = new JScrollPane();
		table_sp.setFont(new Font("Tahoma", Font.BOLD, 10));
		table_sp.setForeground(new Color(0, 0, 0));
		table_sp.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table_sp.setBounds(10, 10, 664, 172);
		panel_3.add(table_sp);

		table = new JTable();
		table.setForeground(new Color(0, 0, 0));
		table.setGridColor(new Color(192, 192, 192));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, "", null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 Tour", "M\u00E3 k\u1EBF ho\u1EA1ch Tour", "Ng\u00E0y \u0111i", "Ng\u00E0y v\u1EC1", "S\u1ED1 ch\u1ED7", "T\u1ED5ng chi", "Gi\u00E1 v\u00E9"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(93);
		table_sp.setViewportView(table);

		JLabel tentour1_lb = new JLabel("Tên tour");
		tentour1_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		tentour1_lb.setBounds(20, 184, 422, 40);
		panel_3.add(tentour1_lb);

		JLabel giatour1_lb = new JLabel("Giá tour");
		giatour1_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		giatour1_lb.setBounds(475, 184, 100, 40);
		panel_3.add(giatour1_lb);

		JLabel diadiem_lb = new JLabel("Địa điểm");
		diadiem_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		diadiem_lb.setBounds(456, 402, 85, 30);
		panel_3.add(diadiem_lb);

		ImageIcon imgdiadiem_icon = new ImageIcon("src/Images/Designcontest-Ecommerce-Business-Maps.48.png");
		JLabel diadiem_icon = new JLabel();
		// diadiem_icon.setBackground(new Color(128, 255, 128));
		diadiem_icon.setBounds(464, 426, 70, 49);
		diadiem_icon.setIcon(imgdiadiem_icon);
		panel_3.add(diadiem_icon);

		JLabel diadiem_nd = new JLabel("New label");
		diadiem_nd.setFont(new Font("Tahoma", Font.BOLD, 10));
		diadiem_nd.setBounds(469, 484, 85, 20);
		panel_3.add(diadiem_nd);

		JLabel phuongtien_icon = new JLabel();
		phuongtien_icon.setBackground(new Color(128, 255, 128));
		phuongtien_icon.setBounds(589, 426, 70, 49);
		ImageIcon imgphuongtien_icon = new ImageIcon("src\\Images\\Bevel-And-Emboss-Car-Van-bus.48.png");
		phuongtien_icon.setIcon(imgphuongtien_icon);
		panel_3.add(phuongtien_icon);

		JLabel nhahang_lb = new JLabel("Nhà hàng");
		nhahang_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		nhahang_lb.setBounds(457, 514, 85, 30);
		panel_3.add(nhahang_lb);

		JLabel nhahang_icon = new JLabel();
		nhahang_icon.setBackground(new Color(128, 255, 128));
		nhahang_icon.setBounds(471, 538, 70, 49);
		ImageIcon imgnhahang_icon = new ImageIcon("src\\Images\\Iconarchive-Essential-Buildings-Restaurant.48.png");
		nhahang_icon.setIcon(imgnhahang_icon);
		panel_3.add(nhahang_icon);

		JLabel khachsan_lb = new JLabel("Khách sạn");
		khachsan_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		khachsan_lb.setBounds(570, 514, 85, 30);
		panel_3.add(khachsan_lb);

		JLabel khachsan_icon = new JLabel();
		khachsan_icon.setBackground(new Color(128, 255, 128));
		khachsan_icon.setBounds(585, 538, 70, 49);
		ImageIcon imgkhachsan_icon = new ImageIcon("src\\Images\\Iconarchive-Essential-Buildings-Hotel.48.png");
		khachsan_icon.setIcon(imgkhachsan_icon);
		panel_3.add(khachsan_icon);

		JScrollPane mota1_sp = new JScrollPane();
		mota1_sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		mota1_sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		mota1_sp.setBounds(10, 414, 404, 102);
		panel_3.add(mota1_sp);

		JLabel thoigian_lb = new JLabel("Thời gian");
		thoigian_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		thoigian_lb.setBounds(10, 515, 85, 30);
		panel_3.add(thoigian_lb);

		JLabel noikhoihanh_lb = new JLabel("Nơi khởi hành");
		noikhoihanh_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		noikhoihanh_lb.setBounds(10, 541, 117, 30);
		panel_3.add(noikhoihanh_lb);

		JLabel sochoconnhan_lb = new JLabel("Số chỗ còn nhận");
		sochoconnhan_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		sochoconnhan_lb.setBounds(10, 571, 134, 30);
		panel_3.add(sochoconnhan_lb);

		JLabel nhahang_nd = new JLabel("New label");
		nhahang_nd.setFont(new Font("Tahoma", Font.BOLD, 10));
		nhahang_nd.setBounds(469, 582, 85, 20);
		panel_3.add(nhahang_nd);

		JLabel khachsan_nd = new JLabel("New label");
		khachsan_nd.setFont(new Font("Tahoma", Font.BOLD, 10));
		khachsan_nd.setBounds(589, 582, 85, 20);
		panel_3.add(khachsan_nd);

		JLabel phuongtien_lb = new JLabel("Phương tiện");
		phuongtien_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		phuongtien_lb.setBounds(569, 402, 104, 30);
		panel_3.add(phuongtien_lb);

		JLabel phuongtien_nd = new JLabel("New label");
		phuongtien_nd.setFont(new Font("Tahoma", Font.BOLD, 10));
		phuongtien_nd.setBounds(589, 484, 85, 20);
		panel_3.add(phuongtien_nd);

		JPanel hinh1_panel = new JPanel();
		hinh1_panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		hinh1_panel.setBounds(10, 214, 404, 187);
		panel_3.add(hinh1_panel);
		hinh1_panel.setLayout(null);

		JLabel hinh1_lb = new JLabel("Hình 1:");
		hinh1_lb.setBounds(10, 0, 388, 187);
		hinh1_panel.add(hinh1_lb);
		hinh1_lb.setBorder(null);
		hinh1_lb.setFont(new Font("Dialog", Font.BOLD, 15));
		hinh1_lb.setBackground(new Color(255, 255, 255));

		JPanel hinh2_panel = new JPanel();
		hinh2_panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		hinh2_panel.setBounds(424, 214, 250, 90);
		panel_3.add(hinh2_panel);
		hinh2_panel.setLayout(null);
		
				JLabel hinh2_lb = new JLabel("Hình 2:");
				hinh2_lb.setBounds(10, 0, 250, 90);
				hinh2_panel.add(hinh2_lb);
				hinh2_lb.setBorder(null);
				hinh2_lb.setFont(new Font("Dialog", Font.BOLD, 15));
				hinh2_lb.setBackground(new Color(255, 255, 255));

		JPanel hinh3_panel = new JPanel();
		hinh3_panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		hinh3_panel.setBounds(424, 310, 250, 90);
		panel_3.add(hinh3_panel);
		hinh3_panel.setLayout(null);

		JLabel hinh3_lb = new JLabel("Hình 3:");
		hinh3_lb.setBounds(10, 0, 249, 90);
		hinh3_panel.add(hinh3_lb);
		hinh3_lb.setBorder(null);
		hinh3_lb.setFont(new Font("Dialog", Font.BOLD, 15));
		hinh3_lb.setBackground(new Color(255, 255, 255));

		JButton ctkehoachtour_btn = new JButton("Chi tiết Kế hoạch Tour");
		ctkehoachtour_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ChiTietKeHoachTourGUI();
			}
		});
		ctkehoachtour_btn.setForeground(new Color(255, 255, 255));
		ctkehoachtour_btn.setBackground(new Color(0, 128, 64));
		ctkehoachtour_btn.setBorder(null);
		ctkehoachtour_btn.setFont(new Font("Tahoma", Font.BOLD, 13));
		ctkehoachtour_btn.setBounds(740, 8, 191, 38);
		KHTOUR.add(ctkehoachtour_btn);
		
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 50, 230, 445);
				KHTOUR.add(scrollPane);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(128, 128, 128),
						new Color(128, 128, 128), new Color(128, 128, 128)));
				
				JPanel panel_2 = new JPanel();
				panel_2.setBackground(new Color(255, 255, 255));
				panel_2.setLayout(null);
				panel_2.setPreferredSize(new Dimension(210, 925));
				KHTOUR.setBackground(new Color(255, 255, 255));
				scrollPane.setViewportView(panel_2);
				
				JLabel matour_lb = new JLabel("Mã Tour :");
				matour_lb.setForeground(new Color(0, 0, 0));
				matour_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
				matour_lb.setBounds(10, 10, 153, 35);
				panel_2.add(matour_lb);
				
				JLabel loaitour_lb = new JLabel("Mã Kế hoạch Tour :");
				loaitour_lb.setForeground(new Color(0, 0, 0));
				loaitour_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
				loaitour_lb.setBounds(10, 77, 153, 35);
				panel_2.add(loaitour_lb);
				
				JLabel mota_lb = new JLabel("Mô tả :");
				mota_lb.setForeground(new Color(0, 0, 0));
				mota_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
				mota_lb.setBounds(10, 148, 153, 35);
				panel_2.add(mota_lb);
				
				JLabel socho_lb = new JLabel("Số chỗ :");
				socho_lb.setForeground(new Color(0, 0, 0));
				socho_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
				socho_lb.setBounds(10, 237, 153, 35);
				panel_2.add(socho_lb);
				
				JComboBox socho_cb = new JComboBox(new Object[]{});
				socho_cb.setBackground(new Color(255, 255, 255));
				socho_cb.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				socho_cb.setBounds(10, 268, 70, 35);
				panel_2.add(socho_cb);
				
				JLabel ngaydi_lb = new JLabel("Ngày đi :");
				ngaydi_lb.setForeground(new Color(0, 0, 0));
				ngaydi_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
				ngaydi_lb.setBounds(10, 304, 153, 35);
				panel_2.add(ngaydi_lb);
				
				JDateChooser ngaydi_date = new JDateChooser();
				ngaydi_date.setBounds(10, 340, 190, 35);
				panel_2.add(ngaydi_date);
				
				JLabel ngayve_lb = new JLabel("Ngày về :");
				ngayve_lb.setForeground(new Color(0, 0, 0));
				ngayve_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
				ngayve_lb.setBounds(10, 375, 153, 35);
				panel_2.add(ngayve_lb);
				
				JDateChooser ngayve_date = new JDateChooser();
				ngayve_date.setBounds(10, 404, 190, 35);
				panel_2.add(ngayve_date);
				
				JLabel songay_lb = new JLabel("Số ngày :");
				songay_lb.setForeground(new Color(0, 0, 0));
				songay_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
				songay_lb.setBounds(10, 437, 153, 35);
				panel_2.add(songay_lb);
				
				textField_1 = new JTextField();
				textField_1.setEditable(false);
				textField_1.setColumns(10);
				textField_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				textField_1.setBounds(10, 469, 70, 35);
				panel_2.add(textField_1);
				
				JLabel huongdanvien_lb = new JLabel("Hướng dẫn viên :");
				huongdanvien_lb.setForeground(new Color(0, 0, 0));
				huongdanvien_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
				huongdanvien_lb.setBounds(10, 505, 153, 35);
				panel_2.add(huongdanvien_lb);
				
				textField_2 = new JTextField();
				textField_2.setColumns(10);
				textField_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				textField_2.setBounds(10, 538, 190, 35);
				panel_2.add(textField_2);
				
				JLabel giave_lb = new JLabel("Giá vé :");
				giave_lb.setForeground(new Color(0, 0, 0));
				giave_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
				giave_lb.setBounds(10, 571, 153, 35);
				panel_2.add(giave_lb);
				
				textField_3 = new JTextField();
				textField_3.setColumns(10);
				textField_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				textField_3.setBounds(10, 600, 190, 35);
				panel_2.add(textField_3);
				
				JLabel tongchi_lb = new JLabel("Tổng chi :");
				tongchi_lb.setForeground(new Color(0, 0, 128));
				tongchi_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
				tongchi_lb.setBounds(10, 638, 153, 35);
				panel_2.add(tongchi_lb);
				
				textField_4 = new JTextField();
				textField_4.setEditable(false);
				textField_4.setColumns(10);
				textField_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				textField_4.setBounds(10, 673, 190, 35);
				panel_2.add(textField_4);
				
				JLabel anh1_lb = new JLabel("Ảnh 1:");
				anh1_lb.setForeground(new Color(0, 0, 128));
				anh1_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
				anh1_lb.setBounds(10, 718, 60, 35);
				panel_2.add(anh1_lb);
				
				JButton anh1_btn = new JButton("Thêm");
				anh1_btn.setFont(new Font("Tahoma", Font.BOLD, 15));
				anh1_btn.setBackground(Color.WHITE);
				anh1_btn.setBounds(64, 718, 85, 35);
				panel_2.add(anh1_btn);
				
				JLabel anh2_lb = new JLabel("Ảnh 2:");
				anh2_lb.setForeground(new Color(0, 0, 128));
				anh2_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
				anh2_lb.setBounds(10, 754, 60, 35);
				panel_2.add(anh2_lb);
				
				JButton anh2_btn = new JButton("Thêm");
				anh2_btn.setFont(new Font("Tahoma", Font.BOLD, 15));
				anh2_btn.setBounds(64, 754, 85, 35);
				panel_2.add(anh2_btn);
				
				JLabel anh3_lb = new JLabel("Ảnh 3:");
				anh3_lb.setForeground(new Color(0, 0, 128));
				anh3_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
				anh3_lb.setBounds(10, 791, 60, 35);
				panel_2.add(anh3_lb);
				
				JButton anh3_btn = new JButton("Thêm");
				anh3_btn.setFont(new Font("Tahoma", Font.BOLD, 15));
				anh3_btn.setBounds(64, 791, 85, 35);
				panel_2.add(anh3_btn);
				
				JButton btnNewButton_3 = new JButton("Thêm");
				btnNewButton_3.setForeground(Color.WHITE);
				btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnNewButton_3.setBorder(null);
				btnNewButton_3.setBackground(new Color(0, 0, 128));
				btnNewButton_3.setBounds(10, 836, 85, 35);
				panel_2.add(btnNewButton_3);
				
				JButton btnNewButton_3_1 = new JButton("Xóa");
				btnNewButton_3_1.setForeground(Color.WHITE);
				btnNewButton_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnNewButton_3_1.setBorder(null);
				btnNewButton_3_1.setBackground(new Color(0, 0, 128));
				btnNewButton_3_1.setBounds(115, 836, 85, 35);
				panel_2.add(btnNewButton_3_1);
				
				JButton btnNewButton_3_2 = new JButton("Sửa");
				btnNewButton_3_2.setForeground(Color.WHITE);
				btnNewButton_3_2.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnNewButton_3_2.setBorder(null);
				btnNewButton_3_2.setBackground(new Color(0, 0, 128));
				btnNewButton_3_2.setBounds(10, 873, 85, 35);
				panel_2.add(btnNewButton_3_2);
				
				JButton btnNewButton_3_3 = new JButton("Lưu");
				btnNewButton_3_3.setForeground(Color.WHITE);
				btnNewButton_3_3.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnNewButton_3_3.setBorder(null);
				btnNewButton_3_3.setBackground(new Color(0, 0, 128));
				btnNewButton_3_3.setBounds(115, 873, 85, 35);
				panel_2.add(btnNewButton_3_3);
				
				JScrollPane mota_sp = new JScrollPane();
				mota_sp.setBackground(new Color(255, 255, 255));
				mota_sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				mota_sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				mota_sp.setBounds(10, 179, 190, 60);
				panel_2.add(mota_sp);
				
				textField_5 = new JTextField();
				textField_5.setColumns(10);
				textField_5.setBounds(10, 110, 190, 35);
				panel_2.add(textField_5);
				
				JComboBox matour_cb = new JComboBox(new Object[]{});
				matour_cb.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				matour_cb.setBounds(10, 39, 190, 35);
				panel_2.add(matour_cb);

		this.getContentPane().add(panel);
		this.setVisible(true);
	}
}
