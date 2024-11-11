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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

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
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Component;
import com.toedter.calendar.JDateChooser;

import BUS.ChiTietKHT_BUS;
import BUS.DatTourBUS;
import BUS.DichVuBUS;
import BUS.KHToursBUS;
import BUS.KiemTra;
import BUS.QlyToursBUS;
import BUS.taikhoanBUS;
import DTO.CTKHT_DTO;
import DTO.DatTourDTO;
import DTO.KHTourDTO;
import DTO.KhachSanDTO;
import DTO.NhaHangDTO;
import DTO.PhuongTienDTO;
import DTO.QlyToursDTO;

public class DatTourGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_NgayVL;
	JButton btn_TrangChu,btn_DatTour,btn_HoaDon,btn_ThongKe;
	JButton btn_ChonTour;
	private JTable table;
	private JTextField tfGiaVe;
	JLabel lbTenTour,lbGiave,lbHinh1,lbHinh2,lbHinh3,phuongtien_nd,nhahang_nd,khachsan_nd,lbThoigian,lbNoiKhoiHanh,lbSoCho,diadiem_nd;
	JTextArea textArea_mota;
	JComboBox noiden_cb,loaitour_cb,noibatdau_cb;
	JDateChooser ngaydi_cb;
	
	ArrayList<String> arr_noibatdau=new ArrayList<String>();
	ArrayList<String> arr_denTrongNuoc=new ArrayList<String>();
	ArrayList<String> arr_denNgoaiNuoc=new ArrayList<String>();
	
	private static String loaitour ="",noibatdau="",noiden="";
	private static int songay = 0, songuoi=0;
	private static long giave = 0;
	private static Date ngaydi;
	DatTourBUS dattourBUS=new DatTourBUS();
	private JTextField tfSonguoi;
	private JTextField tfSongay;
	public Ve ve;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatTourGUI frame = new DatTourGUI();
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
	public DatTourGUI() {
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

		btn_TrangChu = new JButton("Trang Chủ");
		btn_TrangChu.setBorderPainted(false);
		btn_TrangChu.setFocusable(false);
		btn_TrangChu.setBorder(null);
		btn_TrangChu.setBackground(new Color(24, 171, 138));
		btn_TrangChu.setForeground(new Color(255, 255, 255));
		btn_TrangChu.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_TrangChu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
//				TrangChuGUI tc = new TrangChuGUI();
				FormShare.tc.setVisible(true);
				FormShare.tc.btn_TrangChu.setBackground(Color.ORANGE);
				FormShare.tc.btn_TrangChu.setForeground(Color.BLACK);
			}
		});
		btn_TrangChu.setBounds(154, 65, 120, 40);
		panel.add(btn_TrangChu);

		btn_HoaDon = new JButton("Hóa đơn");
		btn_HoaDon.setFocusable(false);
		btn_HoaDon.setBorder(null);
		btn_HoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
//				HoaDon hd = new HoaDon();\
				FormShare.hd.setVisible(true);
				FormShare.hd.btn_HoaDon.setBackground(Color.ORANGE);
				FormShare.hd.btn_HoaDon.setForeground(Color.BLACK);
			}
		});
		btn_HoaDon.setForeground(new Color(255, 255, 255));
		btn_HoaDon.setBackground(new Color(24, 171, 138));
		btn_HoaDon.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_HoaDon.setBounds(478, 65, 120, 40);
		panel.add(btn_HoaDon);

		JButton btn_QlyThongtin = new JButton("Quản lý thông tin");
		btn_QlyThongtin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
//				QuanLyTour qlt = new QuanLyTour();
				FormShare.qlt.setVisible(true);
				FormShare.qlt.btn_QLTour.setBackground(Color.ORANGE);
				FormShare.qlt.btn_QLTour.setForeground(Color.BLACK);
			}
		});
		btn_QlyThongtin.setFocusable(false);
		btn_QlyThongtin.setBorder(null);
		btn_QlyThongtin.setForeground(new Color(255, 255, 255));
		btn_QlyThongtin.setBackground(new Color(24, 171, 138));
		btn_QlyThongtin.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_QlyThongtin.setBounds(799, 65, 120, 40);
		panel.add(btn_QlyThongtin);

		btn_ThongKe = new JButton("Thống kê");
		btn_ThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
//				ThongKe tk = new ThongKe();
				FormShare.tk.setVisible(true);
				FormShare.tk.btn_ThongKe.setBackground(Color.ORANGE);
				FormShare.tk.btn_ThongKe.setForeground(Color.BLACK);
			}
		});
		btn_ThongKe.setFocusable(false);
		btn_ThongKe.setBorder(null);
		btn_ThongKe.setForeground(new Color(255, 255, 255));
		btn_ThongKe.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_ThongKe.setBackground(new Color(24, 171, 138));
		btn_ThongKe.setBounds(643, 65, 120, 40);
		panel.add(btn_ThongKe);


		taikhoanBUS tkBUS = new taikhoanBUS();

		ImageIcon image = new ImageIcon("src\\Images\\logo.png");
		JLabel label = new JLabel();
		label.setBackground(new Color(0, 128, 255));
		label.setBounds(26, 24, 90, 81);
		Image img = image.getImage();
		Image imgScale = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaleIcon = new ImageIcon(imgScale);
		label.setIcon(scaleIcon);
		label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setVisible(false);
                FormShare.tc.setVisible(true);
                FormShare.tc.btn_TrangChu.setBackground(Color.ORANGE);
                FormShare.tc.btn_TrangChu.setForeground(Color.BLACK);
            }
        });
		panel.add(label);


		this.getContentPane().add(panel);

		Panel KhachHang = new Panel();
		KhachHang.setBounds(13, 127, 960, 495);
		panel.add(KhachHang);
		KhachHang.setLayout(null);
		KhachHang.setBackground(new Color(255, 255, 255));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(10, 54, 270, 431);
		KhachHang.add(panel_1);
		panel_1.setLayout(null);

		JLabel loaitour_lb = new JLabel("Loại Tour");
		loaitour_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		loaitour_lb.setBounds(10, 10, 90, 30);
		panel_1.add(loaitour_lb);
		
		String[] arr_tinh = { "Địa điểm","An Giang", "Bà Rịa – Vũng Tàu", "Bạc Liêu", "Bắc Giang", "Bắc Kạn", "Bắc Ninh",
				"Bến Tre", "Bình Dương", "Bình Định", "Bình Phước", "Bình Thuận", "Cà Mau", "Cao Bằng", "Cần Thơ",
				"Đà Nẵng", "Đắk Lắk", "Đắk Nông", "Điện Biên", "Đồng Nai", "Đồng Tháp", "Gia Lai", "Hà Giang", "Hà Nam",
				"Hà Nội", "Hà Tĩnh", "Hải Dương", "Hải Phòng", "Hậu Giang", "Hòa Bình", "TP Hồ Chí Minh", "Hưng Yên",
				"Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu", "Lạng Sơn", "Lào Cai", "Lâm Đồng", "Long An",
				"Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận", "Phú Thọ", "Phú Yên", "Quảng Bình", "Quảng Nam",
				"Quảng Ngãi", "Quảng Ninh", "Quảng Trị", "Sóc Trăng", "Sơn La", "Tây Ninh", "Thái Bình", "Thái Nguyên",
				"Thanh Hóa", "Thừa Thiên Huế", "Tiền Giang", "Trà Vinh", "Tuyên Quang", "Vĩnh Long", "Vĩnh Phúc",
				"Yên Bái" };

		
		
		

		JLabel noibatdau_lb = new JLabel("Nơi bắt đầu");
		noibatdau_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		noibatdau_lb.setBounds(10, 63, 90, 30);
		panel_1.add(noibatdau_lb);

		

		JLabel noiden_lb = new JLabel("Nơi đến");
		noiden_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		noiden_lb.setBounds(10, 115, 90, 30);
		panel_1.add(noiden_lb);

		

		JLabel ngaydi_lb = new JLabel("Ngày đi");
		ngaydi_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		ngaydi_lb.setBounds(10, 166, 90, 30);
		panel_1.add(ngaydi_lb);

		ngaydi_cb = new JDateChooser();
		ngaydi_cb.setBounds(110, 166, 145, 30);
		panel_1.add(ngaydi_cb);

		JLabel ngayve_lb = new JLabel("Số ngày");
		ngayve_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		ngayve_lb.setBounds(10, 215, 90, 30);
		panel_1.add(ngayve_lb);

		JLabel songuoi_lb = new JLabel("Số người");
		songuoi_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		songuoi_lb.setBounds(10, 265, 90, 30);
		panel_1.add(songuoi_lb);

		JButton loc_btn = new JButton("Lọc");
		loc_btn.setFocusPainted(false);
		loc_btn.setBorder(null);
		loc_btn.setBackground(new Color(51, 204, 255));
		loc_btn.setForeground(Color.WHITE);
		loc_btn.setFont(new Font("Tahoma", Font.BOLD, 18));
		loc_btn.setBounds(37, 361, 90, 40);
		loc_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				XoaDataTable();
				Loc2();
//				initData2(Loc());
				
			}
		});
		panel_1.add(loc_btn);

		JButton reset_btn = new JButton("Reset");
		reset_btn.setFocusPainted(false);
		reset_btn.setBackground(new Color(102, 153, 204));
		reset_btn.setBorder(null);
		reset_btn.setForeground(new Color(255, 255, 255));
		reset_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reset();
				initData();
			}
		});
		reset_btn.setFont(new Font("Tahoma", Font.BOLD, 18));
		reset_btn.setBounds(137, 361, 90, 40);
		panel_1.add(reset_btn);
		
		JLabel songuoi_lb_1 = new JLabel("Giá vé( ≤X)");
		songuoi_lb_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		songuoi_lb_1.setBounds(10, 305, 102, 30);
		panel_1.add(songuoi_lb_1);
		
		tfGiaVe = new JTextField();
		tfGiaVe.setBounds(110, 305, 145, 30);
		panel_1.add(tfGiaVe);
		tfGiaVe.setColumns(10);
		
		tfSonguoi = new JTextField();
		tfSonguoi.addKeyListener(new KeyAdapter() {
			@Override
		    public void keyPressed(KeyEvent e) {
		        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		        	tfGiaVe.requestFocusInWindow();
		        }
		    }
		});
		tfSonguoi.setColumns(10);
		tfSonguoi.setBounds(110, 265, 145, 30);
		panel_1.add(tfSonguoi);
		
		tfSongay = new JTextField();
		tfSongay.setColumns(10);
		tfSongay.setBounds(110, 218, 145, 30);
		tfSongay.addKeyListener(new KeyAdapter() {
			@Override
		    public void keyPressed(KeyEvent e) {
		        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		        	tfSonguoi.requestFocusInWindow();
		        }
		    }
		});
		panel_1.add(tfSongay);

		JLabel lblNewLabel_1 = new JLabel("Lọc kết quả");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 10, 330, 34);
		KhachHang.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(287, 54, 663, 431);
		KhachHang.add(scrollPane);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setPreferredSize(new Dimension(590, 600));
		panel_3.setBackground(Color.LIGHT_GRAY);
		scrollPane.setViewportView(panel_3);
		
		JScrollPane table_sp = new JScrollPane();
		table_sp.setForeground(Color.BLACK);
		table_sp.setFont(new Font("Tahoma", Font.BOLD, 10));
		table_sp.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table_sp.setBounds(10, 10, 621, 172);
		panel_3.add(table_sp);
		
		table = new JTable();
		table_sp.setViewportView(table);
		
		JLabel tentour1_lb = new JLabel("Tên tour");
		tentour1_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		tentour1_lb.setBounds(20, 177, 70, 40);
		panel_3.add(tentour1_lb);
		
		JLabel giatour1_lb = new JLabel("Giá vé");
		giatour1_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		giatour1_lb.setBounds(365, 177, 70, 40);
		panel_3.add(giatour1_lb);
		
		JLabel diadiem_lb = new JLabel("Địa điểm");
		diadiem_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		diadiem_lb.setBounds(396, 404, 85, 30);
		panel_3.add(diadiem_lb);
		
		JLabel diadiem_icon = new JLabel(new ImageIcon("src/Images/Designcontest-Ecommerce-Business-Maps.48.png"));
		diadiem_icon.setBounds(395, 428, 70, 49);
		panel_3.add(diadiem_icon);
		
		
		diadiem_nd = new JLabel("New label");
		diadiem_nd.setFont(new Font("Tahoma", Font.BOLD, 10));
		diadiem_nd.setBounds(410, 487, 85, 20);
		panel_3.add(diadiem_nd);
		
		JLabel phuongtien_icon = new JLabel(new ImageIcon("src/Images/Bevel-And-Emboss-Car-Van-bus.48.png"));
		phuongtien_icon.setBackground(new Color(128, 255, 128));
		phuongtien_icon.setBounds(537, 428, 70, 49);
		panel_3.add(phuongtien_icon);
		
		JLabel nhahang_lb = new JLabel("Nhà hàng");
		nhahang_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		nhahang_lb.setBounds(395, 504, 85, 30);
		panel_3.add(nhahang_lb);
		
		JLabel nhahang_icon = new JLabel(new ImageIcon("src/Images/Iconarchive-Essential-Buildings-Restaurant.48.png"));
		nhahang_icon.setBackground(new Color(128, 255, 128));
		nhahang_icon.setBounds(395, 528, 70, 49);
		panel_3.add(nhahang_icon);
		
		JLabel khachsan_lb = new JLabel("Khách sạn");
		khachsan_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		khachsan_lb.setBounds(537, 504, 85, 30);
		panel_3.add(khachsan_lb);
		
		JLabel khachsan_icon = new JLabel(new ImageIcon("src/Images/Iconarchive-Essential-Buildings-Hotel.48.png"));
		khachsan_icon.setBackground(new Color(128, 255, 128));
		khachsan_icon.setBounds(537, 528, 70, 49);
		panel_3.add(khachsan_icon);
		
		JScrollPane mota1_sp = new JScrollPane();
		mota1_sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		mota1_sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		mota1_sp.setBounds(10, 414, 361, 102);
		panel_3.add(mota1_sp);
		textArea_mota = new JTextArea();
		textArea_mota.setLineWrap(true);
		textArea_mota.setWrapStyleWord(true);
		mota1_sp.setViewportView(textArea_mota);
		
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
		
		nhahang_nd = new JLabel("New label");
		nhahang_nd.setFont(new Font("Tahoma", Font.BOLD, 10));
		nhahang_nd.setBounds(400, 578, 100, 20);
		panel_3.add(nhahang_nd);
		
		khachsan_nd = new JLabel("New label");
		khachsan_nd.setFont(new Font("Tahoma", Font.BOLD, 10));
		khachsan_nd.setBounds(546, 578, 85, 20);
		panel_3.add(khachsan_nd);
		
		JLabel phuongtien_lb = new JLabel("Phương tiện");
		phuongtien_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		phuongtien_lb.setBounds(527, 404, 104, 30);
		panel_3.add(phuongtien_lb);
		
		phuongtien_nd = new JLabel("New label");
		phuongtien_nd.setFont(new Font("Tahoma", Font.BOLD, 10));
		phuongtien_nd.setBounds(546, 486, 85, 20);
		panel_3.add(phuongtien_nd);
		
		JPanel hinh1_panel = new JPanel();
		hinh1_panel.setLayout(null);
		hinh1_panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		hinh1_panel.setBounds(10, 214, 342, 190);
		panel_3.add(hinh1_panel);
		
		lbHinh1 = new JLabel("Hình 1:");
		lbHinh1.setFont(new Font("Dialog", Font.BOLD, 15));
		lbHinh1.setBorder(null);
		lbHinh1.setBackground(Color.WHITE);
		lbHinh1.setBounds(10, 0, 322, 187);
		hinh1_panel.add(lbHinh1);
		
		JPanel hinh2_panel = new JPanel();
		hinh2_panel.setLayout(null);
		hinh2_panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		hinh2_panel.setBounds(362, 214, 269, 90);
		panel_3.add(hinh2_panel);
		
		lbHinh2 = new JLabel("Hình 2:");
		lbHinh2.setFont(new Font("Dialog", Font.BOLD, 15));
		lbHinh2.setBorder(null);
		lbHinh2.setBackground(Color.WHITE);
		lbHinh2.setBounds(10, 0, 250, 90);
		hinh2_panel.add(lbHinh2);
		
		JPanel hinh3_panel = new JPanel();
		hinh3_panel.setLayout(null);
		hinh3_panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		hinh3_panel.setBounds(362, 314, 269, 90);
		panel_3.add(hinh3_panel);
		
		lbHinh3 = new JLabel("Hình 3:");
		lbHinh3.setFont(new Font("Dialog", Font.BOLD, 15));
		lbHinh3.setBorder(null);
		lbHinh3.setBackground(Color.WHITE);
		lbHinh3.setBounds(10, 0, 249, 90);
		hinh3_panel.add(lbHinh3);
		
		btn_ChonTour = new JButton("Đặt Tour");
		btn_ChonTour.setBorder(null);
		btn_ChonTour.setFocusPainted(false);
		btn_ChonTour.setBackground(new Color(255, 127, 80));
		btn_ChonTour.setForeground(new Color(255, 255, 255));
		btn_ChonTour.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_ChonTour.setBounds(546, 184, 85, 28);
		btn_ChonTour.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row==-1) {
					JOptionPane.showMessageDialog(panel, "Bạn chưa chọn Tour.");
					return;
				}
				else {
					DatTourDTO tourduocchon=GetTourDaChon();
					setVisible(false);
					ve = new Ve(tourduocchon);
					
					ve.setSize(1000, 780);
				}
				
			}
		});
		panel_3.add(btn_ChonTour);
		
		lbThoigian = new JLabel("Thời gian");
		lbThoigian.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbThoigian.setBounds(140, 519, 85, 24);
		panel_3.add(lbThoigian);
		
		lbNoiKhoiHanh = new JLabel("Nơi khởi hành");
		lbNoiKhoiHanh.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbNoiKhoiHanh.setBounds(140, 544, 85, 24);
		panel_3.add(lbNoiKhoiHanh);
		
		lbSoCho = new JLabel("Số chỗ");
		lbSoCho.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbSoCho.setBounds(140, 574, 104, 24);
		panel_3.add(lbSoCho);
		
		lbTenTour = new JLabel("");
		lbTenTour.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbTenTour.setBounds(100, 184, 255, 29);
		panel_3.add(lbTenTour);
		
		lbGiave = new JLabel("");
		lbGiave.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbGiave.setBounds(424, 185, 112, 25);
		panel_3.add(lbGiave);
		
		initData();
		Set<String> set = new HashSet<>(arr_noibatdau);
	    ArrayList<String> arr_noibatdau = new ArrayList<>(set);
	    
	    Set<String> set1 = new HashSet<>(arr_denTrongNuoc);
	    ArrayList<String> arr_denTrongNuoc = new ArrayList<>(set1);
	    
	    Set<String> set2 = new HashSet<>(arr_denNgoaiNuoc);
	    ArrayList<String> arr_denNgoaiNuoc = new ArrayList<>(set2);
	    
	    String[] arr_loaiTour= {"Trong nước","Ngoài nước"};
		loaitour_cb = new JComboBox(arr_loaiTour);
		loaitour_cb.setBounds(110, 10, 145, 30);
		loaitour_cb.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (loaitour_cb.getSelectedItem().equals("Trong nước")) {
					noiden_cb.setModel(new DefaultComboBoxModel(arr_denTrongNuoc.toArray()));
				} else if (loaitour_cb.getSelectedItem().equals("Ngoài nước")) {
//					String[] arr_nuocngoai = { "Địa điểm","Trung Quốc", "Hàn Quốc", "Nhật Bản", "Đài Loan", "Hồng Kông", "Macau",
//							"Triều Tiên", "Hàn Quốc", "Mông Cổ", "Brunei", "Campuchia", "Đông Timor", "Indonesia",
//							"Lào", "Malaysia", "Myanma", "Philippines", "Singapore", "Thái Lan" };
					noiden_cb.setModel(new DefaultComboBoxModel(arr_denNgoaiNuoc.toArray()));
				}
				
			}
		});
		panel_1.add(loaitour_cb);
		
		noibatdau_cb = new JComboBox(arr_noibatdau.toArray());
		noibatdau_cb.setBounds(110, 63, 145, 30);
		panel_1.add(noibatdau_cb);
		
		noiden_cb = new JComboBox(arr_denTrongNuoc.toArray());
		noiden_cb.setBounds(110, 115, 145, 30);
		panel_1.add(noiden_cb);

		String []item_loai = {"Trong nước", "Ngoài nước"};

		btn_DatTour = new JButton("Đặt Tour");
		btn_DatTour.setForeground(Color.WHITE);
		btn_DatTour.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_DatTour.setFocusable(false);
		btn_DatTour.setBorderPainted(false);
		btn_DatTour.setBorder(null);
		btn_DatTour.setBackground(new Color(24, 171, 138));
		btn_DatTour.setBounds(317, 65, 120, 40);
		btn_DatTour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
//				DatTourGUI dt = new DatTourGUI();
				FormShare.dt.setVisible(true);
				btn_DatTour.setBackground(Color.ORANGE);
				btn_DatTour.setForeground(Color.BLACK);
			}
		});
		panel.add(btn_DatTour);
		
		JLabel lblNewLabel = new JLabel("Xin chào " + TrangChuGUI.tkBUS.getName(TrangChuGUI.tkDTO.getUser()));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(609, 24, 230, 30);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("Đổi mật khẩu");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MatKhauGUI mk = new MatKhauGUI();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setBounds(849, 25, 124, 30);
		panel.add(btnNewButton_2);
//		this.setVisible(true);
	}
	
	public void initData() {
		dattourBUS.docDSTour();
		String [] colname= {"Mã Tour","Tên Tour","Mã KHT","Ngày đi","Ngày về","Số người","Giá vé"};
		DefaultTableModel tableModel=new DefaultTableModel() {
			 public boolean isCellEditable(int row,int col) {
	                return false;
	         }
		};
		tableModel.setColumnIdentifiers(colname);
		table.setModel(tableModel);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(5).setPreferredWidth(65);
		table.getColumnModel().getColumn(6).setPreferredWidth(115);
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					HienThiTour();
				}
			}
		});
		
		
		if(DatTourBUS.dsTour != null)
		for (DatTourDTO dattour : DatTourBUS.dsTour) {
			if(!KiemTra.getInstance().checkngaydi(KiemTra.getInstance().toDateUtil(dattour.getNgaydi()))) {
				continue;
			}
			arr_noibatdau.add(dattour.getNoikhoihanh());
			if(GetLoaiTour(dattour.getMatour()).equals("loai1")) {
				arr_denTrongNuoc.add(dattour.getDiadiem());
			}else {
				arr_denNgoaiNuoc.add(dattour.getDiadiem());
			}
			tableModel.addRow(new Object[] { dattour.getMatour(), dattour.getTentour(), dattour.getMakht(),
					dattour.getNgaydi().toString(), dattour.getNgayve().toString(), dattour.getSonguoi()+"",dattour.getGiatour()+"" 
					
			});
		}
		
	}
	
	public void initData2(ArrayList<DatTourDTO> tours) {
		dattourBUS.docDSTour();
		String [] colname= {"Mã Tour","Tên Tour","Mã KHT","Ngày đi","Ngày về","Số người","Giá vé"};
		DefaultTableModel tableModel=new DefaultTableModel() {
			 public boolean isCellEditable(int row,int col) {
	                return false;
	         }
		};
		tableModel.setColumnIdentifiers(colname);
		table.setModel(tableModel);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(5).setPreferredWidth(65);
		table.getColumnModel().getColumn(6).setPreferredWidth(115);
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					HienThiTour();
				}
			}
		});
		for (DatTourDTO dattour : tours) {
			tableModel.addRow(new Object[] { dattour.getMatour(), dattour.getTentour(), dattour.getMakht(),
					dattour.getNgaydi().toString(), dattour.getNgayve().toString(), dattour.getSonguoi()+"",dattour.getGiatour()+"" 
					
			});
		}
	}
	
	public void HienThiTour() {
		DatTourDTO dattour=GetTourDaChon();
		
		lbTenTour.setText(dattour.getTentour());
		DecimalFormat decimalFormat = new DecimalFormat("#,##0");
		String formattedNumber = decimalFormat.format(dattour.getGiatour()) +" VND";
		lbGiave.setText(formattedNumber);
		
		ImageIcon img1=new ImageIcon(dattour.getHinh1().replace('#', '\\'));
		Image image1 = img1.getImage().getScaledInstance(388, 187, Image.SCALE_DEFAULT);
		ImageIcon scaledIcon1 = new ImageIcon(image1);
		lbHinh1.setIcon(scaledIcon1);
		
		ImageIcon img2=new ImageIcon(dattour.getHinh2().replace('#', '\\'));
		Image image2 = img2.getImage().getScaledInstance(250, 90, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon2 = new ImageIcon(image2);
		lbHinh2.setIcon(scaledIcon2);
		
		ImageIcon img3=new ImageIcon(dattour.getHinh3().replace('#', '\\'));
		Image image3 = img3.getImage().getScaledInstance(250, 90, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon3 = new ImageIcon(image3);
		lbHinh3.setIcon(scaledIcon3);
		
		lbThoigian.setText(dattour.getNgaydi()+"");
		lbNoiKhoiHanh.setText(dattour.getNoikhoihanh());
		lbSoCho.setText(dattour.getSonguoi()+"");
		
		//Hiển thị Chi tiết kế hoạch Tour
		String chitiet="";
		for(CTKHT_DTO ctkht:ChiTietKHT_BUS.ctkhtList) {
			if(ctkht.getMakht().equals(dattour.getMakht())) {
				String ngay="Ngày :"+ctkht.getNgay().toString()+"\n";
				String khachsan="Khách sạn :"+GetTenKS(ctkht.getMaks())+"\n";
				String nhahang="Nhà hàng :"+GetTenNH(ctkht.getManh())+"\n";
				String phuongtien="Phương tiện :"+GetTenPT(ctkht.getMapt())+"\n";
				chitiet=chitiet+ngay+khachsan+nhahang+phuongtien;
			}	
		}
		textArea_mota.setText(chitiet);
		
		nhahang_nd.setText(dattour.getNhahang());
		khachsan_nd.setText(dattour.getKhachsan());
		phuongtien_nd.setText(dattour.getPhuongtien());
		diadiem_nd.setText(dattour.getDiadiem());
		
	}
	
	public DatTourDTO GetTourDaChon() {
		int row = table.getSelectedRow();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		String makht = model_table.getValueAt(row, 2) + "";
		for(DatTourDTO dattour:DatTourBUS.dsTour) {
			if(dattour.getMakht().equals(makht)) {
				return dattour;
			}
		}
		return null;
	}
	public String GetLoaiTour(String matour) {
		String maloai="";
		for(QlyToursDTO t:QlyToursBUS.tourDTO) {
			if(t.getMatour().equals(matour)) {
				maloai=t.getMaloai();
			}
		}
		return maloai;
	}
	
	
	public void Loc2() {
		if(loaitour_cb.getSelectedItem().toString().equals("Trong nước")) {
			loaitour="loai1";
		}else {
			loaitour="loai2";
		}
		if(noibatdau_cb.getSelectedItem() != null) {
			noibatdau=noibatdau_cb.getSelectedItem().toString();			
		}
		if(noiden_cb.getSelectedItem() != null) {
			noiden=noiden_cb.getSelectedItem().toString();			
		}
//		System.out.println(ngaydi);
		java.util.Date ngaydi_tmp=(java.util.Date) ngaydi_cb.getDate();
		if(ngaydi_tmp!=null) {
			ngaydi = new java.sql.Date(ngaydi_tmp.getTime());			
		}
		
		 if(!tfSongay.getText().equals("")) {
			 songay=Integer.parseInt(tfSongay.getText());			 
		 }

        if(!tfSonguoi.getText().equals("")) {
        	songuoi=Integer.parseInt(tfSonguoi.getText());
        }
        
        
        if(!tfGiaVe.getText().equals("")) {
        	giave=Long.parseLong(tfGiaVe.getText());
        }
        ArrayList<DatTourDTO> list = dattourBUS.LocTour(loaitour, noibatdau, noiden, ngaydi, songay, songuoi, giave);
        if(list == null) {
        	JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả phù hợp");
        }else {
        	initData2(list);
        }
	}
	
	
	public ArrayList<DatTourDTO> Loc(){
		ArrayList<DatTourDTO> locTheoLoai=new ArrayList<DatTourDTO>();
		ArrayList<DatTourDTO> locTheoDiaDiem=new ArrayList<DatTourDTO>();
		ArrayList<DatTourDTO> locTheoNgay=new ArrayList<DatTourDTO>();
		ArrayList<DatTourDTO> locTheoSoNguoi=new ArrayList<DatTourDTO>();
		ArrayList<DatTourDTO> locTheoGiaVe=new ArrayList<DatTourDTO>();
		
		String loaitour="";
		if(loaitour_cb.getSelectedItem().toString().equals("Trong nước")) {
			loaitour="loai1";
		}else {
			loaitour="loai2";
		}
		
		
		String noibatdau=noibatdau_cb.getSelectedItem().toString();
		String noiden=noiden_cb.getSelectedItem().toString();
		
		java.util.Date ngaydi_tmp=(java.util.Date) ngaydi_cb.getDate();
        java.sql.Date ngaydi=null;
        
        if(ngaydi_tmp!=null) {
        	ngaydi=new java.sql.Date(ngaydi_tmp.getTime());
        }
        
        int songay=0;
        if(!tfSongay.getText().equals("")) {
        	songay=Integer.parseInt(tfSongay.getText());
        }
        
        int songuoi=0;
        if(!tfSonguoi.getText().equals("")) {
        	songuoi=Integer.parseInt(tfSonguoi.getText());
        }
        
        
        long giave=0;
        if(!tfGiaVe.getText().equals("")) {
        	giave=Long.parseLong(tfGiaVe.getText());
        }
		
		if(noibatdau.equals("Địa điểm")&&noiden.equals("Địa điểm")&&ngaydi==null&&songay==0&&songuoi==0&&giave==0) {
			locTheoLoai.addAll(LocTheoLoai(loaitour));
			return locTheoLoai;
		}
		
		locTheoLoai.addAll(LocTheoLoai(loaitour));
		
		if(noibatdau.equals(noibatdau.equals("Địa điểm")&&noiden.equals("Địa điểm"))) {
			locTheoDiaDiem.addAll(DatTourBUS.dsTour);
		}else {
			locTheoDiaDiem.addAll(LocTheoDiaDiem(noibatdau, noiden));
		}
		
		if(ngaydi.equals(null)&&songay==0) {
			locTheoNgay.addAll(DatTourBUS.dsTour);
		}else {
			locTheoNgay.addAll(LocTheoNgay(songay,ngaydi));
		}
		
		if(songuoi==0) {
			locTheoSoNguoi.addAll(DatTourBUS.dsTour);
		}else {
			locTheoSoNguoi.addAll(LocTheoSoNguoi(songuoi));
		}
		
		if(giave==0) {
			locTheoGiaVe.addAll(DatTourBUS.dsTour);
		}else {
			locTheoGiaVe.addAll(LocTheoGiaVe(giave));
		}
		
		ArrayList<DatTourDTO> kqLoc = new ArrayList<>(locTheoLoai);
        kqLoc.retainAll(locTheoDiaDiem);
        kqLoc.retainAll(locTheoGiaVe);
        kqLoc.retainAll(locTheoNgay);
        kqLoc.retainAll(locTheoSoNguoi);
        

        System.out.println("Các phần tử chung: " + kqLoc);
		
		return kqLoc;
	}
	
	public ArrayList<DatTourDTO> LocTheoDiaDiem(String noibatdau,String noiden){
		ArrayList<DatTourDTO> dattour=new ArrayList<DatTourDTO>();
		for(DatTourDTO t:DatTourBUS.dsTour) {
			if(t.getNoikhoihanh().equals(noibatdau)||t.getDiadiem().equals(noiden)) {
				dattour.add(t);
			}
		}
		return dattour;
	}
	
	public int getSoNgay(String matour) {
		for(QlyToursDTO t:QlyToursBUS.tourDTO) {
			if(t.getMatour().equals(matour)) {
				return t.getSongay();
			}
		}
		return -1;
	}
	
	public String getMaLoai(String matour) {
		for(QlyToursDTO t:QlyToursBUS.tourDTO) {
			if(t.getMatour().equals(matour)) {
				return t.getMaloai();
			}
		}
		return null;
	}
	
	public ArrayList<DatTourDTO> LocTheoLoai(String LoaiTour){
		ArrayList<DatTourDTO> dattour=new ArrayList<DatTourDTO>();
		for(DatTourDTO t:DatTourBUS.dsTour) {
			if(getMaLoai(t.getMatour()).equals(LoaiTour)) {
				dattour.add(t);
			}
		}
		return dattour;
	}
	
	public ArrayList<DatTourDTO> LocTheoNgay(int songay,Date ngaydi){
		ArrayList<DatTourDTO> dattour=new ArrayList<DatTourDTO>();
		for(DatTourDTO t:DatTourBUS.dsTour) {
			if(getSoNgay(t.getMatour())<=songay||t.getNgaydi().equals(ngaydi)) {
				dattour.add(t);
			}
		}
		return dattour;
	}
	
	public ArrayList<DatTourDTO> LocTheoSoNguoi(int songuoi){
		ArrayList<DatTourDTO> dattour=new ArrayList<DatTourDTO>();
		for(DatTourDTO t:DatTourBUS.dsTour) {
			if(t.getSonguoi()<=songuoi) {
				dattour.add(t);
			}
		}
		return dattour;
	}
	
	public ArrayList<DatTourDTO> LocTheoGiaVe(long giave){
		ArrayList<DatTourDTO> dattour=new ArrayList<DatTourDTO>();
		for(DatTourDTO t:DatTourBUS.dsTour) {
			if(t.getGiatour()<=giave) {
				dattour.add(t);
			}
		}
		return dattour;
	}
	
	public void Reset() {
		loaitour_cb.setSelectedIndex(0);
		noibatdau_cb.setSelectedIndex(0);
		noiden_cb.setSelectedIndex(0);
		ngaydi_cb.setDate(null);
		tfSongay.setText("");
		tfSonguoi.setText("");
		tfGiaVe.setText("");
	}
	
	public void XoaDataTable() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.setRowCount(0);
	}
	
	public String GetTenKS(String maks) {
		for(KhachSanDTO ks: DichVuBUS.ksDTO) {
			if(ks.getMaso().equals(maks)) {
				return ks.getTendv();
			}
		}
		return null;
	}
	public String GetTenNH(String manh) {
		for(NhaHangDTO nh: DichVuBUS.nhDTO) {
			if(nh.getMaso().equals(manh)) {
				return nh.getTendv();
			}
		}
		return null;
	}
	public String GetTenPT(String mapt) {
		for(PhuongTienDTO pt: DichVuBUS.ptDTO) {
			if(pt.getMaso().equals(mapt)) {
				return pt.getTendv();
			}
		}
		return null;
	}
	
	
	
	
	
	
	
	
}