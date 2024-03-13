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

public class DatTourGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_NgayVL;
	private JTextField timkiem_tf;
	private JTable table;

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
		setBounds(100, 100, 1000, 650);
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

		JButton btn_TrangChu = new JButton("Trang Chủ");
		btn_TrangChu.setBorderPainted(false);
		btn_TrangChu.setFocusable(false);
		btn_TrangChu.setBorder(null);
		btn_TrangChu.setBackground(new Color(24, 171, 138));
		btn_TrangChu.setForeground(new Color(255, 255, 255));
		btn_TrangChu.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_TrangChu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_TrangChu.setBounds(154, 65, 120, 40);
		panel.add(btn_TrangChu);

		JButton btn_HoaDon = new JButton("Hóa đơn");
		btn_HoaDon.setFocusable(false);
		btn_HoaDon.setBorder(null);
		btn_HoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_HoaDon.setForeground(new Color(255, 255, 255));
		btn_HoaDon.setBackground(new Color(24, 171, 138));
		btn_HoaDon.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_HoaDon.setBounds(478, 65, 120, 40);
		panel.add(btn_HoaDon);

		JButton btn_QlyThongtin = new JButton("Quản lý thông tin");
		btn_QlyThongtin.setFocusable(false);
		btn_QlyThongtin.setBorder(null);
		btn_QlyThongtin.setForeground(new Color(255, 255, 255));
		btn_QlyThongtin.setBackground(new Color(24, 171, 138));
		btn_QlyThongtin.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_QlyThongtin.setBounds(799, 65, 120, 40);
		panel.add(btn_QlyThongtin);

		JButton btn_ThongKe = new JButton("Thống kê");
		btn_ThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_ThongKe.setFocusable(false);
		btn_ThongKe.setBorder(null);
		btn_ThongKe.setForeground(new Color(255, 255, 255));
		btn_ThongKe.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_ThongKe.setBackground(new Color(24, 171, 138));
		btn_ThongKe.setBounds(643, 65, 120, 40);
		panel.add(btn_ThongKe);

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

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_2.setBounds(350, 54, 600, 431);
		KhachHang.add(scrollPane_2);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setPreferredSize(new Dimension(590, 600));
		panel_3.setBackground(Color.LIGHT_GRAY);
		scrollPane_2.setViewportView(panel_3);

		JScrollPane table_sp = new JScrollPane();
		table_sp.setForeground(Color.BLACK);
		table_sp.setFont(new Font("Tahoma", Font.BOLD, 10));
		table_sp.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table_sp.setBounds(10, 10, 553, 172);
		panel_3.add(table_sp);

		table = new JTable();
		table.setModel(new DefaultTableModel(
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
			},
			new String[] {
				"M\u00E3 Tour", "T\u00EAn Tour", "S\u1ED1 ch\u1ED7", "Ng\u00E0y b\u1EAFt \u0111\u1EA7u", "Ng\u00E0y k\u1EBFt th\u00FAc", "Gi\u00E1 Tour"
			}
		));
		table_sp.setViewportView(table);

		JLabel tentour1_lb = new JLabel("Tên tour");
		tentour1_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		tentour1_lb.setBounds(20, 184, 262, 40);
		panel_3.add(tentour1_lb);

		JLabel giatour1_lb = new JLabel("Giá tour");
		giatour1_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		giatour1_lb.setBounds(292, 184, 100, 40);
		panel_3.add(giatour1_lb);

		JLabel hinh2_lb = new JLabel("Hình 2:");
		hinh2_lb.setFont(new Font("Dialog", Font.BOLD, 15));
		hinh2_lb.setBorder(null);
		hinh2_lb.setBackground(Color.WHITE);
		hinh2_lb.setBounds(305, 214, 250, 90);
		panel_3.add(hinh2_lb);

		JLabel diadiem_lb = new JLabel("Địa điểm");
		diadiem_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		diadiem_lb.setBounds(365, 404, 85, 30);
		panel_3.add(diadiem_lb);

		JLabel diadiem_icon = new JLabel();
		diadiem_icon.setBounds(370, 428, 70, 49);
		panel_3.add(diadiem_icon);

		JLabel diadiem_nd = new JLabel("New label");
		diadiem_nd.setFont(new Font("Tahoma", Font.BOLD, 10));
		diadiem_nd.setBounds(375, 486, 85, 20);
		panel_3.add(diadiem_nd);

		JLabel phuongtien_icon = new JLabel();
		phuongtien_icon.setBackground(new Color(128, 255, 128));
		phuongtien_icon.setBounds(495, 428, 70, 49);
		panel_3.add(phuongtien_icon);

		JLabel nhahang_lb = new JLabel("Nhà hàng");
		nhahang_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		nhahang_lb.setBounds(365, 504, 85, 30);
		panel_3.add(nhahang_lb);

		JLabel nhahang_icon = new JLabel();
		nhahang_icon.setBackground(new Color(128, 255, 128));
		nhahang_icon.setBounds(375, 528, 70, 49);
		panel_3.add(nhahang_icon);

		JLabel khachsan_lb = new JLabel("Khách sạn");
		khachsan_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		khachsan_lb.setBounds(475, 504, 85, 30);
		panel_3.add(khachsan_lb);

		JLabel khachsan_icon = new JLabel();
		khachsan_icon.setBackground(new Color(128, 255, 128));
		khachsan_icon.setBounds(490, 528, 70, 49);
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
		hinh1_panel.setLayout(null);
		hinh1_panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		hinh1_panel.setBounds(10, 214, 280, 187);
		panel_3.add(hinh1_panel);

		JLabel hinh1_lb = new JLabel("Hình 1:");
		hinh1_lb.setFont(new Font("Dialog", Font.BOLD, 15));
		hinh1_lb.setBorder(null);
		hinh1_lb.setBackground(Color.WHITE);
		hinh1_lb.setBounds(10, 0, 260, 187);
		hinh1_panel.add(hinh1_lb);

		JPanel hinh2_panel = new JPanel();
		hinh2_panel.setLayout(null);
		hinh2_panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		hinh2_panel.setBounds(296, 214, 269, 90);
		panel_3.add(hinh2_panel);

		JPanel hinh3_panel = new JPanel();
		hinh3_panel.setLayout(null);
		hinh3_panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		hinh3_panel.setBounds(296, 310, 269, 90);
		panel_3.add(hinh3_panel);

		JLabel hinh3_lb = new JLabel("Hình 3:");
		hinh3_lb.setFont(new Font("Dialog", Font.BOLD, 15));
		hinh3_lb.setBorder(null);
		hinh3_lb.setBackground(Color.WHITE);
		hinh3_lb.setBounds(10, 0, 249, 90);
		hinh3_panel.add(hinh3_lb);

		JButton btnNewButton = new JButton("Đặt Tour");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBounds(478, 184, 85, 30);
		panel_3.add(btnNewButton);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(10, 54, 330, 431);
		KhachHang.add(panel_1);
		panel_1.setLayout(null);

		JLabel loaitour_lb = new JLabel("Loại Tour");
		loaitour_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		loaitour_lb.setBounds(10, 10, 90, 30);
		panel_1.add(loaitour_lb);

		JComboBox loaitour_cb = new JComboBox();
		loaitour_cb.setBounds(110, 10, 210, 30);
		panel_1.add(loaitour_cb);

		JLabel noibatdau_lb = new JLabel("Nơi bắt đầu");
		noibatdau_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		noibatdau_lb.setBounds(10, 63, 90, 30);
		panel_1.add(noibatdau_lb);

		JComboBox noibatdau_cb = new JComboBox();
		noibatdau_cb.setBounds(110, 63, 210, 30);
		panel_1.add(noibatdau_cb);

		JLabel noiden_lb = new JLabel("Nơi đến");
		noiden_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		noiden_lb.setBounds(10, 115, 90, 30);
		panel_1.add(noiden_lb);

		JComboBox noiden_cb = new JComboBox();
		noiden_cb.setBounds(110, 115, 210, 30);
		panel_1.add(noiden_cb);

		JLabel ngaydi_lb = new JLabel("Ngày đi");
		ngaydi_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		ngaydi_lb.setBounds(10, 166, 90, 30);
		panel_1.add(ngaydi_lb);

		JComboBox ngaydi_cb = new JComboBox();
		ngaydi_cb.setBounds(110, 166, 210, 30);
		panel_1.add(ngaydi_cb);

		JLabel ngayve_lb = new JLabel("Ngày về");
		ngayve_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		ngayve_lb.setBounds(10, 215, 90, 30);
		panel_1.add(ngayve_lb);

		JComboBox ngayve_cb = new JComboBox();
		ngayve_cb.setBounds(110, 215, 210, 30);
		panel_1.add(ngayve_cb);

		JLabel songuoi_lb = new JLabel("Số người");
		songuoi_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		songuoi_lb.setBounds(10, 265, 90, 30);
		panel_1.add(songuoi_lb);

		JComboBox songuoi_cb = new JComboBox();
		songuoi_cb.setBounds(110, 265, 210, 30);
		panel_1.add(songuoi_cb);

		JButton loc_btn = new JButton("Lọc");
		loc_btn.setFont(new Font("Tahoma", Font.BOLD, 15));
		loc_btn.setBounds(65, 328, 90, 40);
		panel_1.add(loc_btn);

		JButton reset_btn = new JButton("Reset");
		reset_btn.setFont(new Font("Tahoma", Font.BOLD, 15));
		reset_btn.setBounds(165, 328, 90, 40);
		panel_1.add(reset_btn);

		JLabel lblNewLabel_1 = new JLabel("Lọc kết quả");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 10, 330, 34);
		KhachHang.add(lblNewLabel_1);

		timkiem_tf = new JTextField();
		timkiem_tf.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		timkiem_tf.setBounds(350, 10, 509, 34);
		KhachHang.add(timkiem_tf);
		timkiem_tf.setColumns(10);

		JButton timkiem_btn = new JButton("Tìm kiếm");
		timkiem_btn.setFont(new Font("Tahoma", Font.BOLD, 10));
		timkiem_btn.setBounds(865, 10, 85, 34);
		KhachHang.add(timkiem_btn);

		String []item_loai = {"Trong nước", "Ngoài nước"};

		JButton btn_DatTour = new JButton("Đặt Tour");
		btn_DatTour.setForeground(Color.WHITE);
		btn_DatTour.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_DatTour.setFocusable(false);
		btn_DatTour.setBorderPainted(false);
		btn_DatTour.setBorder(null);
		btn_DatTour.setBackground(new Color(24, 171, 138));
		btn_DatTour.setBounds(317, 65, 120, 40);
		panel.add(btn_DatTour);
		this.setVisible(true);
	}
}