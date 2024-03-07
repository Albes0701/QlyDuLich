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

//import com.toedter.calendar.JDateChooser;

import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class QlyToursGUI extends JFrame {

	//private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField matour_tf;
	private JTextField songay_tf;
	private JTextField huongdanvien_tf;
	private JTextField giave_tf;
	private JTextField tongchi_tf;
	private JTextField timkiem_tf;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QlyToursGUI frame = new QlyToursGUI();
					frame.setSize(900, 625);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QlyToursGUI() {
		this.setType(Type.UTILITY);
		this.setBackground(SystemColor.windowText);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 864);

		contentPane = new JPanel();
		contentPane.setVerifyInputWhenFocusTarget(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(255, 132, 132));
		panel.setBounds(0, -19, 883, 610);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton tourbtn = new JButton("Quản lý Tours");
		tourbtn.setBorderPainted(false);
		tourbtn.setFocusable(false);
		tourbtn.setBorder(null);
		tourbtn.setBackground(new Color(0, 0, 153));
		tourbtn.setForeground(new Color(255, 255, 255));
		tourbtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		tourbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		tourbtn.setBounds(121, 64, 140, 40);
		panel.add(tourbtn);

		JButton dvbtn = new JButton("Quản lý dịch vụ");
		dvbtn.setFocusable(false);
		dvbtn.setBorder(null);
		dvbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dvbtn.setForeground(new Color(255, 255, 255));
		dvbtn.setBackground(new Color(0, 0, 153));
		dvbtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		dvbtn.setBounds(271, 64, 140, 40);
		panel.add(dvbtn);

		JButton khbtn = new JButton("Khách hàng");
		khbtn.setFocusable(false);
		khbtn.setBorder(null);
		khbtn.setForeground(new Color(255, 255, 255));
		khbtn.setBackground(new Color(0, 0, 153));
		khbtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		khbtn.setBounds(721, 64, 155, 40);
		panel.add(khbtn);

		JButton nvbtn = new JButton("Nhân viên");
		nvbtn.setFocusable(false);
		nvbtn.setBorder(null);
		nvbtn.setForeground(new Color(255, 255, 255));
		nvbtn.setBackground(new Color(0, 0, 153));
		nvbtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		nvbtn.setBounds(571, 64, 140, 40);
		panel.add(nvbtn);

		JButton kmbtn = new JButton("Khuyến mãi");
		kmbtn.setFocusable(false);
		kmbtn.setBorder(null);
		kmbtn.setForeground(new Color(255, 255, 255));
		kmbtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		kmbtn.setBackground(new Color(0, 0, 153));
		kmbtn.setBounds(421, 64, 140, 40);
		panel.add(kmbtn);

		JButton mk_btn = new JButton("Đổi mật khẩu");
		mk_btn.setFocusable(false);
		mk_btn.setFont(new Font("Tahoma", Font.BOLD, 12));
		mk_btn.setBounds(752, 25, 124, 30);
		panel.add(mk_btn);

		JLabel userlb = new JLabel("User");
		userlb.setFont(new Font("Tahoma", Font.BOLD, 16));
		userlb.setBounds(685, 25, 90, 30);
		panel.add(userlb);

		
		JLabel logo_lb = new JLabel();
		logo_lb.setBackground(new Color(128, 255, 128));
		logo_lb.setPreferredSize(new Dimension(90,90));
		logo_lb.setBounds(10, 25, 111, 96);
//		ImageIcon originalIcon = new ImageIcon("/Images/vtv-logo.png");
		ImageIcon originalIcon = new ImageIcon("src\\Images\\vtv-logo.png");
		Image originalImage = originalIcon.getImage();
		Image scaledImage = originalImage.getScaledInstance(logo_lb.getPreferredSize().width,
				logo_lb.getPreferredSize().height, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		//logo_lb.setIcon(new ImageIcon(QlyToursGUI.class.getResource("/Images/vtv-logo.png")));
		logo_lb.setIcon(scaledIcon);
		panel.add(logo_lb);
		
		
		
		

		Panel panel_1 = new Panel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(13, 127, 860, 469);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel thongtintour_lb = new JLabel("Thông tin tours");
		thongtintour_lb.setForeground(Color.RED);
		thongtintour_lb.setBounds(40, 10, 134, 30);
		thongtintour_lb.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_1.add(thongtintour_lb);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(128, 128, 128),
				new Color(128, 128, 128), new Color(128, 128, 128)));
		scrollPane.setBounds(10, 50, 230, 410);
		panel_1.add(scrollPane);

		JPanel panel_2 = new JPanel();
		scrollPane.setViewportView(panel_2);
		panel_2.setLayout(null);
		panel_2.setPreferredSize(new Dimension(210, 1173));
		panel_2.setBackground(Color.LIGHT_GRAY);

		JLabel matour_lb = new JLabel("Mã Tour :");
		matour_lb.setForeground(new Color(0, 0, 128));
		matour_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		matour_lb.setBounds(10, 10, 153, 35);
		panel_2.add(matour_lb);

		matour_tf = new JTextField();
		matour_tf.setColumns(10);
		matour_tf.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		matour_tf.setBounds(10, 41, 190, 35);
		panel_2.add(matour_tf);

		JLabel loaitour_lb = new JLabel("Loại Tour :");
		loaitour_lb.setForeground(new Color(0, 0, 128));
		loaitour_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		loaitour_lb.setBounds(10, 77, 153, 35);
		panel_2.add(loaitour_lb);

		String[] loaiTour= {"Tour trong nước","Tour nước ngoài"};
		JComboBox loaitour_cb = new JComboBox(loaiTour);
		loaitour_cb.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		loaitour_cb.setBounds(10, 110, 190, 35);
		panel_2.add(loaitour_cb);

		JLabel tentour_lb = new JLabel("Tên Tour :");
		tentour_lb.setForeground(new Color(0, 0, 128));
		tentour_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		tentour_lb.setBounds(10, 146, 153, 35);
		panel_2.add(tentour_lb);

		JLabel mota_lb = new JLabel("Mô tả :");
		mota_lb.setForeground(new Color(0, 0, 128));
		mota_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		mota_lb.setBounds(10, 244, 153, 35);
		panel_2.add(mota_lb);

		JLabel socho_lb = new JLabel("Số chỗ :");
		socho_lb.setForeground(new Color(0, 0, 128));
		socho_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		socho_lb.setBounds(10, 335, 153, 35);
		panel_2.add(socho_lb);

		String [] socho= {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
		JComboBox socho_cb = new JComboBox(socho);
		socho_cb.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		socho_cb.setBounds(10, 364, 70, 35);
		panel_2.add(socho_cb);

		JLabel diemkhoihanh_lb = new JLabel("Điểm khởi hành :");
		diemkhoihanh_lb.setForeground(new Color(0, 0, 128));
		diemkhoihanh_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		diemkhoihanh_lb.setBounds(10, 401, 153, 35);
		panel_2.add(diemkhoihanh_lb);
		
		String[] arr_tinh = { "An Giang", "Bà Rịa – Vũng Tàu", "Bạc Liêu", "Bắc Giang", "Bắc Kạn", "Bắc Ninh",
				"Bến Tre", "Bình Dương", "Bình Định", "Bình Phước", "Bình Thuận", "Cà Mau", "Cao Bằng", "Cần Thơ",
				"Đà Nẵng", "Đắk Lắk", "Đắk Nông", "Điện Biên", "Đồng Nai", "Đồng Tháp", "Gia Lai", "Hà Giang", "Hà Nam",
				"Hà Nội", "Hà Tĩnh", "Hải Dương", "Hải Phòng", "Hậu Giang", "Hòa Bình", "Thành phố Hồ Chí Minh",
				"Hưng Yên", "Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu", "Lạng Sơn", "Lào Cai", "Lâm Đồng",
				"Long An", "Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận", "Phú Thọ", "Phú Yên", "Quảng Bình",
				"Quảng Nam", "Quảng Ngãi", "Quảng Ninh", "Quảng Trị", "Sóc Trăng", "Sơn La", "Tây Ninh", "Thái Bình",
				"Thái Nguyên", "Thanh Hóa", "Thừa Thiên Huế", "Tiền Giang", "Trà Vinh", "Tuyên Quang", "Vĩnh Long",
				"Vĩnh Phúc", "Yên Bái" };

		JComboBox diemkhoihanh_cb = new JComboBox(arr_tinh);
		diemkhoihanh_cb.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		diemkhoihanh_cb.setBounds(10, 439, 190, 35);
		panel_2.add(diemkhoihanh_cb);

		JLabel diemden_lb = new JLabel("Điểm đến :");
		diemden_lb.setForeground(new Color(0, 0, 128));
		diemden_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		diemden_lb.setBounds(10, 479, 153, 35);
		panel_2.add(diemden_lb);

		JComboBox diemden_cb = new JComboBox(arr_tinh);
		diemden_cb.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		diemden_cb.setBounds(10, 511, 190, 35);
		panel_2.add(diemden_cb);

		JLabel ngaydi_lb = new JLabel("Ngày đi :");
		ngaydi_lb.setForeground(new Color(0, 0, 128));
		ngaydi_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		ngaydi_lb.setBounds(10, 548, 153, 35);
		panel_2.add(ngaydi_lb);

//		JComboBox ngaydi_cb = new JComboBox();
//		ngaydi_cb.setBounds(10, 579, 190, 35);
//		panel_2.add(ngaydi_cb);
		JDateChooser ngaydi_date=new JDateChooser();
		ngaydi_date.setBounds(10, 579, 190, 35);
		panel_2.add(ngaydi_date);

		JLabel ngayve_lb = new JLabel("Ngày về :");
		ngayve_lb.setForeground(new Color(0, 0, 128));
		ngayve_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		ngayve_lb.setBounds(10, 615, 153, 35);
		panel_2.add(ngayve_lb);

//		JComboBox ngayve_cb = new JComboBox();
//		ngayve_cb.setBounds(10, 648, 190, 35);
//		panel_2.add(ngayve_cb);
		JDateChooser ngayve_date=new JDateChooser();
		ngayve_date.setBounds(10, 648, 190, 35);
		panel_2.add(ngayve_date);

		JLabel songay_lb = new JLabel("Số ngày :");
		songay_lb.setForeground(new Color(0, 0, 128));
		songay_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		songay_lb.setBounds(10, 684, 153, 35);
		panel_2.add(songay_lb);

		songay_tf = new JTextField();
		songay_tf.setEditable(false);
		songay_tf.setColumns(10);
		songay_tf.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		songay_tf.setBounds(10, 713, 70, 35);
		panel_2.add(songay_tf);

		JLabel huongdanvien_lb = new JLabel("Hướng dẫn viên :");
		huongdanvien_lb.setForeground(new Color(0, 0, 128));
		huongdanvien_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		huongdanvien_lb.setBounds(10, 751, 153, 35);
		panel_2.add(huongdanvien_lb);

		huongdanvien_tf = new JTextField();
		huongdanvien_tf.setColumns(10);
		huongdanvien_tf.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		huongdanvien_tf.setBounds(10, 781, 190, 35);
		panel_2.add(huongdanvien_tf);

		JLabel giave_lb = new JLabel("Giá vé :");
		giave_lb.setForeground(new Color(0, 0, 128));
		giave_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		giave_lb.setBounds(10, 817, 153, 35);
		panel_2.add(giave_lb);

		giave_tf = new JTextField();
		giave_tf.setColumns(10);
		giave_tf.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		giave_tf.setBounds(10, 846, 190, 35);
		panel_2.add(giave_tf);

		JLabel tongchi_lb = new JLabel("Tổng chi :");
		tongchi_lb.setForeground(new Color(0, 0, 128));
		tongchi_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		tongchi_lb.setBounds(10, 883, 153, 35);
		panel_2.add(tongchi_lb);

		tongchi_tf = new JTextField();
		tongchi_tf.setColumns(10);
		tongchi_tf.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tongchi_tf.setBounds(10, 913, 190, 35);
		panel_2.add(tongchi_tf);

		JLabel anh1_lb = new JLabel("Ảnh 1:");
		anh1_lb.setForeground(new Color(0, 0, 128));
		anh1_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		anh1_lb.setBounds(10, 958, 60, 35);
		panel_2.add(anh1_lb);

		JButton anh1_btn = new JButton("Thêm");
		anh1_btn.setFont(new Font("Tahoma", Font.BOLD, 15));
		anh1_btn.setBackground(Color.WHITE);
		anh1_btn.setBounds(64, 958, 85, 35);
		panel_2.add(anh1_btn);

		JLabel anh2_lb = new JLabel("Ảnh 2:");
		anh2_lb.setForeground(new Color(0, 0, 128));
		anh2_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		anh2_lb.setBounds(10, 994, 60, 35);
		panel_2.add(anh2_lb);

		JButton anh2_btn = new JButton("Thêm");
		anh2_btn.setFont(new Font("Tahoma", Font.BOLD, 15));
		anh2_btn.setBounds(64, 994, 85, 35);
		panel_2.add(anh2_btn);

		JLabel anh3_lb = new JLabel("Ảnh 3:");
		anh3_lb.setForeground(new Color(0, 0, 128));
		anh3_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		anh3_lb.setBounds(10, 1031, 60, 35);
		panel_2.add(anh3_lb);

		JButton anh3_btn = new JButton("Thêm");
		anh3_btn.setFont(new Font("Tahoma", Font.BOLD, 15));
		anh3_btn.setBounds(64, 1031, 85, 35);
		panel_2.add(anh3_btn);

		JButton btnNewButton_3 = new JButton("Thêm");
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3.setBorder(null);
		btnNewButton_3.setBackground(new Color(0, 0, 128));
		btnNewButton_3.setBounds(10, 1080, 85, 35);
		panel_2.add(btnNewButton_3);

		JButton btnNewButton_3_1 = new JButton("Xóa");
		btnNewButton_3_1.setForeground(Color.WHITE);
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3_1.setBorder(null);
		btnNewButton_3_1.setBackground(new Color(0, 0, 128));
		btnNewButton_3_1.setBounds(115, 1080, 85, 35);
		panel_2.add(btnNewButton_3_1);

		JButton btnNewButton_3_2 = new JButton("Sửa");
		btnNewButton_3_2.setForeground(Color.WHITE);
		btnNewButton_3_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3_2.setBorder(null);
		btnNewButton_3_2.setBackground(new Color(0, 0, 128));
		btnNewButton_3_2.setBounds(10, 1117, 85, 35);
		panel_2.add(btnNewButton_3_2);

		JButton btnNewButton_3_3 = new JButton("Lưu");
		btnNewButton_3_3.setForeground(Color.WHITE);
		btnNewButton_3_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3_3.setBorder(null);
		btnNewButton_3_3.setBackground(new Color(0, 0, 128));
		btnNewButton_3_3.setBounds(115, 1117, 85, 35);
		panel_2.add(btnNewButton_3_3);

		JScrollPane tentour_sp = new JScrollPane();
		tentour_sp.setBounds(10, 185, 190, 60);
		panel_2.add(tentour_sp);
		tentour_sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		tentour_sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		JTextArea tentour_ta = new JTextArea();
		tentour_sp.setViewportView(tentour_ta);
		tentour_ta.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JScrollPane mota_sp = new JScrollPane();
		mota_sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		mota_sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		mota_sp.setBounds(10, 273, 190, 60);
		panel_2.add(mota_sp);

		JTextArea mota_ta = new JTextArea();
		mota_sp.setViewportView(mota_ta);
		mota_ta.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JComboBox loaitournhap_cb = new JComboBox(loaiTour);
		loaitournhap_cb.setBounds(250, 8, 188, 40);
		panel_1.add(loaitournhap_cb);

		timkiem_tf = new JTextField();
		timkiem_tf.setBounds(451, 8, 188, 40);
		panel_1.add(timkiem_tf);
		timkiem_tf.setColumns(10);

		JButton timkiem_btn = new JButton("TK");
		timkiem_btn.setFont(new Font("Tahoma", Font.BOLD, 10));
		timkiem_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		timkiem_btn.setBounds(641, 8, 60, 40);
		panel_1.add(timkiem_btn);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setBounds(250, 50, 600, 404);
		panel_1.add(scrollPane_2);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setPreferredSize(new Dimension(590, 600));
		panel_3.setBackground(Color.LIGHT_GRAY);
		scrollPane_2.setViewportView(panel_3);

		JScrollPane table_sp = new JScrollPane();
		table_sp.setFont(new Font("Tahoma", Font.BOLD, 10));
		table_sp.setForeground(new Color(0, 0, 0));
		table_sp.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table_sp.setBounds(10, 10, 553, 172);
		panel_3.add(table_sp);
		
		table = new JTable();
		table.setForeground(new Color(0, 0, 0));
		table.setGridColor(new Color(192, 192, 192));
		table.setModel(new DefaultTableModel(
			new Object[][] {
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
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Mã Tour", "Tên Tour", "Ngày đi", "Ngày về", "Số chỗ", "Tổng chi", "Giá vé"
			}
		));
		table_sp.setViewportView(table);

		JLabel tentour1_lb = new JLabel("Tên tour");
		tentour1_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		tentour1_lb.setBounds(20, 184, 422, 40);
		panel_3.add(tentour1_lb);

		JLabel giatour1_lb = new JLabel("Giá tour");
		giatour1_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		giatour1_lb.setBounds(475, 184, 100, 40);
		panel_3.add(giatour1_lb);

		JLabel hinh2_lb = new JLabel("Hình 2:");
		hinh2_lb.setBorder(null);
		hinh2_lb.setFont(new Font("Dialog", Font.BOLD, 15));
		hinh2_lb.setBackground(new Color(255, 255, 255));
		hinh2_lb.setBounds(305, 214, 250, 90);
		panel_3.add(hinh2_lb);

		JLabel diadiem_lb = new JLabel("Địa điểm");
		diadiem_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		diadiem_lb.setBounds(365, 404, 85, 30);
		panel_3.add(diadiem_lb);

		ImageIcon imgdiadiem_icon=new ImageIcon("src/Images/Designcontest-Ecommerce-Business-Maps.48.png");
		JLabel diadiem_icon = new JLabel();
		//diadiem_icon.setBackground(new Color(128, 255, 128));
		diadiem_icon.setBounds(370, 428, 70, 49);
		diadiem_icon.setIcon(imgdiadiem_icon);
		panel_3.add(diadiem_icon);

		JLabel diadiem_nd = new JLabel("New label");
		diadiem_nd.setFont(new Font("Tahoma", Font.BOLD, 10));
		diadiem_nd.setBounds(375, 486, 85, 20);
		panel_3.add(diadiem_nd);

		JLabel phuongtien_icon = new JLabel();
		phuongtien_icon.setBackground(new Color(128, 255, 128));
		phuongtien_icon.setBounds(495, 428, 70, 49);
		ImageIcon imgphuongtien_icon=new ImageIcon("src\\Images\\Bevel-And-Emboss-Car-Van-bus.48.png");
		phuongtien_icon.setIcon(imgphuongtien_icon);
		panel_3.add(phuongtien_icon);

		JLabel nhahang_lb = new JLabel("Nhà hàng");
		nhahang_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		nhahang_lb.setBounds(365, 504, 85, 30);
		panel_3.add(nhahang_lb);

		JLabel nhahang_icon = new JLabel();
		nhahang_icon.setBackground(new Color(128, 255, 128));
		nhahang_icon.setBounds(375, 528, 70, 49);
		ImageIcon imgnhahang_icon=new ImageIcon("src\\Images\\Iconarchive-Essential-Buildings-Restaurant.48.png");
		nhahang_icon.setIcon(imgnhahang_icon);
		panel_3.add(nhahang_icon);

		JLabel khachsan_lb = new JLabel("Khách sạn");
		khachsan_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		khachsan_lb.setBounds(475, 504, 85, 30);
		panel_3.add(khachsan_lb);

		JLabel khachsan_icon = new JLabel();
		khachsan_icon.setBackground(new Color(128, 255, 128));
		khachsan_icon.setBounds(490, 528, 70, 49);
		ImageIcon imgkhachsan_icon=new ImageIcon("src\\Images\\Iconarchive-Essential-Buildings-Hotel.48.png");
		khachsan_icon.setIcon(imgkhachsan_icon);
		panel_3.add(khachsan_icon);

		JScrollPane mota1_sp = new JScrollPane();
		mota1_sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		mota1_sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		mota1_sp.setBounds(10, 414, 316, 102);
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
		nhahang_nd.setBounds(375, 578, 85, 20);
		panel_3.add(nhahang_nd);

		JLabel khachsan_nd = new JLabel("New label");
		khachsan_nd.setFont(new Font("Tahoma", Font.BOLD, 10));
		khachsan_nd.setBounds(490, 578, 85, 20);
		panel_3.add(khachsan_nd);

		JLabel phuongtien_lb = new JLabel("Phương tiện");
		phuongtien_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		phuongtien_lb.setBounds(475, 404, 104, 30);
		panel_3.add(phuongtien_lb);

		JLabel phuongtien_nd = new JLabel("New label");
		phuongtien_nd.setFont(new Font("Tahoma", Font.BOLD, 10));
		phuongtien_nd.setBounds(495, 486, 85, 20);
		panel_3.add(phuongtien_nd);
		
		JPanel hinh1_panel = new JPanel();
		hinh1_panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		hinh1_panel.setBounds(10, 214, 280, 187);
		panel_3.add(hinh1_panel);
				hinh1_panel.setLayout(null);
		
				JLabel hinh1_lb = new JLabel("Hình 1:");
				hinh1_lb.setBounds(10, 0, 260, 187);
				hinh1_panel.add(hinh1_lb);
				hinh1_lb.setBorder(null);
				hinh1_lb.setFont(new Font("Dialog", Font.BOLD, 15));
				hinh1_lb.setBackground(new Color(255, 255, 255));
				
				JPanel hinh2_panel = new JPanel();
				hinh2_panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				hinh2_panel.setBounds(296, 214, 269, 90);
				panel_3.add(hinh2_panel);
				hinh2_panel.setLayout(null);
				
				JPanel hinh3_panel = new JPanel();
				hinh3_panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				hinh3_panel.setBounds(296, 310, 269, 90);
				panel_3.add(hinh3_panel);
				hinh3_panel.setLayout(null);
				
						JLabel hinh3_lb = new JLabel("Hình 3:");
						hinh3_lb.setBounds(10, 0, 249, 90);
						hinh3_panel.add(hinh3_lb);
						hinh3_lb.setBorder(null);
						hinh3_lb.setFont(new Font("Dialog", Font.BOLD, 15));
						hinh3_lb.setBackground(new Color(255, 255, 255));
		
		JButton btnNewButton = new JButton("Kế hoạch Tour");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 128, 64));
		btnNewButton.setBorder(null);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBounds(737, 9, 113, 38);
		panel_1.add(btnNewButton);

		this.getContentPane().add(panel);
		this.setVisible(true);
	}
}
