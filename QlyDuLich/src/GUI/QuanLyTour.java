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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.ArrayList;
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
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Component;
import com.toedter.calendar.JDateChooser;

import BUS.QlyToursBUS;
import DTO.QlyToursDTO;


public class QuanLyTour extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_MaTour;
	private JTextField songay_tf;
	private JTable table_Tours;
	private JTextField textField_TimKiem;
	private JTextField textField_NgayVL;
	private JTextField tentour_tf;
	JButton luu_btn;
	JComboBox comboBox_LoaiTour;
	JComboBox khoihanh_cb;
	JComboBox noiden_cb;
	JButton sua_btn;
	JButton them_btn;
	JButton xoa_btn;
	
	//QlyToursDTO tourDTO=new QlyToursDTO();
	QlyToursBUS tourBUS=new QlyToursBUS();

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
		this.setSize(1000, 650);
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
		
		JButton btn_QLTour = new JButton("Quản lý Tours");
		btn_QLTour.setBorderPainted(false);
		btn_QLTour.setFocusable(false);
		btn_QLTour.setBorder(null);
		btn_QLTour.setBackground(new Color(24, 171, 138));
		btn_QLTour.setForeground(new Color(255, 255, 255));
		btn_QLTour.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_QLTour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_QLTour.setBounds(126, 65, 120, 40);
		panel.add(btn_QLTour);
		
		JButton btn_QLDV = new JButton("Quản lý dịch vụ");
		btn_QLDV.setFocusable(false);
		btn_QLDV.setBorder(null);
		btn_QLDV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		
		JButton btn_NhanVien = new JButton("Nhân viên");
		btn_NhanVien.setFocusable(false);
		btn_NhanVien.setBorder(null);
		btn_NhanVien.setForeground(new Color(255, 255, 255));
		btn_NhanVien.setBackground(new Color(24, 171, 138));
		btn_NhanVien.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_NhanVien.setBounds(708, 65, 120, 40);
		panel.add(btn_NhanVien);
		
		JButton btn_KhuyenMai = new JButton("Khuyến mãi");
		btn_KhuyenMai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		
		Panel Tour = new Panel();
		Tour.setBounds(13, 127, 960, 495);
		panel.add(Tour);
		Tour.setLayout(null);
		Tour.setBackground(new Color(255, 255, 255));
		
		JLabel lb_TTTour = new JLabel("Thông tin Tour");
		lb_TTTour.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_TTTour.setBounds(19, 10, 218, 30);
		Tour.add(lb_TTTour);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 50, 227, 435);
		Tour.add(scrollPane);
		
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
		
		songay_tf = new JTextField();
		songay_tf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		songay_tf.setColumns(10);
		songay_tf.setBounds(90, 211, 125, 26);
		panel_2.add(songay_tf);
		
		JLabel songay_lb = new JLabel("Số Ngày");
		songay_lb.setFont(new Font("Tahoma", Font.BOLD, 14));
		songay_lb.setBounds(10, 213, 61, 20);
		panel_2.add(songay_lb);
		
		JLabel khoihanh_lb = new JLabel("Khởi hành");
		khoihanh_lb.setFont(new Font("Tahoma", Font.BOLD, 14));
		khoihanh_lb.setBounds(10, 259, 85, 13);
		panel_2.add(khoihanh_lb);
		
		JLabel noiden_lb = new JLabel("Nơi đến");
		noiden_lb.setFont(new Font("Tahoma", Font.BOLD, 14));
		noiden_lb.setBounds(10, 301, 61, 20);
		panel_2.add(noiden_lb);
		
		luu_btn = new JButton("Lưu");
		luu_btn.setFocusable(false);
		luu_btn.setForeground(new Color(255, 255, 255));
		luu_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		luu_btn.setBackground(new Color(255, 128, 64));
		luu_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XoaDataTable();
				initData();
			}
		});
		luu_btn.setBounds(66, 348, 85, 26);
		panel_2.add(luu_btn);
		String[] arr_tinh = { "An Giang", "Bà Rịa – Vũng Tàu", "Bạc Liêu", "Bắc Giang", "Bắc Kạn", "Bắc Ninh",
				"Bến Tre", "Bình Dương", "Bình Định", "Bình Phước", "Bình Thuận", "Cà Mau", "Cao Bằng", "Cần Thơ",
				"Đà Nẵng", "Đắk Lắk", "Đắk Nông", "Điện Biên", "Đồng Nai", "Đồng Tháp", "Gia Lai", "Hà Giang", "Hà Nam",
				"Hà Nội", "Hà Tĩnh", "Hải Dương", "Hải Phòng", "Hậu Giang", "Hòa Bình", "TP Hồ Chí Minh",
				"Hưng Yên", "Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu", "Lạng Sơn", "Lào Cai", "Lâm Đồng",
				"Long An", "Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận", "Phú Thọ", "Phú Yên", "Quảng Bình",
				"Quảng Nam", "Quảng Ngãi", "Quảng Ninh", "Quảng Trị", "Sóc Trăng", "Sơn La", "Tây Ninh", "Thái Bình",
				"Thái Nguyên", "Thanh Hóa", "Thừa Thiên Huế", "Tiền Giang", "Trà Vinh", "Tuyên Quang", "Vĩnh Long",
				"Vĩnh Phúc", "Yên Bái" };
		khoihanh_cb = new JComboBox(arr_tinh);
		khoihanh_cb.setBackground(new Color(255, 255, 255));
		khoihanh_cb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		khoihanh_cb.setBounds(91, 254, 124, 26);
		panel_2.add(khoihanh_cb);
		
		String []item_loai = {"Trong nước", "Ngoài nước"};
		comboBox_LoaiTour = new JComboBox(item_loai);
		comboBox_LoaiTour.setBackground(new Color(255, 255, 255));
		comboBox_LoaiTour.setBounds(91, 69, 123, 26);
		comboBox_LoaiTour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_LoaiTour.getSelectedItem().equals("Trong nước")) {
					noiden_cb.setModel(new DefaultComboBoxModel(arr_tinh));
				}
				else if(comboBox_LoaiTour.getSelectedItem().equals("Ngoài nước")){
					String[] arr_nuocngoai= {"Trung Quốc", "Hàn Quốc", "Nhật Bản", "Đài Loan", "Hồng Kông", 
							"Macau", "Triều Tiên", "Hàn Quốc", "Mông Cổ","Brunei", "Campuchia", "Đông Timor", 
							"Indonesia", "Lào", "Malaysia", "Myanma", "Philippines", "Singapore", "Thái Lan"};
					noiden_cb.setModel(new DefaultComboBoxModel(arr_nuocngoai));
				}
			}
		});
		panel_2.add(comboBox_LoaiTour);
		
		noiden_cb = new JComboBox(arr_tinh);
		noiden_cb.setBackground(new Color(255, 255, 255));
		noiden_cb.setBounds(91, 300, 124, 26);
		panel_2.add(noiden_cb);
		
		JLabel tentour_lb = new JLabel("Tên Tour");
		tentour_lb.setFont(new Font("Tahoma", Font.BOLD, 14));
		tentour_lb.setBounds(10, 110, 73, 20);
		panel_2.add(tentour_lb);
		
		tentour_tf = new JTextField();
		tentour_tf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tentour_tf.setBounds(10, 140, 205, 61);
		panel_2.add(tentour_tf);
		tentour_tf.setColumns(10);
		

//		textField_NgayVL = new JTextField();
//		textField_NgayVL.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		textField_NgayVL.setColumns(10);
//		textField_NgayVL.setBounds(81, 315, 134, 26);
//		panel_2.add(textField_NgayVL);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(269, 50, 681, 435);
		Tour.add(scrollPane_2);
		
		table_Tours = new JTable();
		scrollPane_2.setViewportView(table_Tours);
		
//		table_Tours.getColumnModel().getColumn(1).setPreferredWidth(80);
//		table_Tours.getColumnModel().getColumn(2).setPreferredWidth(139);
//		table_Tours.getColumnModel().getColumn(3).setPreferredWidth(52);
//		table_Tours.getColumnModel().getColumn(5).setPreferredWidth(88);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(269, 10, 681, 30);
		Tour.add(panel_3);
		panel_3.setLayout(null);
		
		xoa_btn = new JButton("Xóa");
		xoa_btn.setFocusable(false);
		xoa_btn.setBackground(new Color(255, 0, 0));
		xoa_btn.setForeground(new Color(255, 255, 255));
		xoa_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		xoa_btn.setBounds(596, 3, 75, 25);
		panel_3.add(xoa_btn);
		
		sua_btn = new JButton("Sửa");
		sua_btn.setFocusable(false);
		sua_btn.setBackground(new Color(50, 205, 50));
		sua_btn.setForeground(new Color(255, 255, 255));
		sua_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		sua_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		sua_btn.setBounds(511, 3, 75, 25);
		panel_3.add(sua_btn);
		
		them_btn = new JButton("Thêm");
		them_btn.setFocusable(false);
		them_btn.setForeground(new Color(255, 255, 255));
		them_btn.setBackground(new Color(65, 105, 225));
		them_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		them_btn.setBounds(427, 3, 75, 25);
		them_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ThemTour();
			}
		});
		panel_3.add(them_btn);
		
		JLabel timkiem_lb = new JLabel("Tìm kiếm");
		timkiem_lb.setFont(new Font("Tahoma", Font.BOLD, 14));
		timkiem_lb.setBounds(10, 9, 70, 13);
		panel_3.add(timkiem_lb);
		
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
		
		init();
		initData();
		
		
		JButton btn_KHTour = new JButton("Kế hoạch Tours");
		btn_KHTour.setForeground(Color.WHITE);
		btn_KHTour.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_KHTour.setFocusable(false);
		btn_KHTour.setBorderPainted(false);
		btn_KHTour.setBorder(null);
		btn_KHTour.setBackground(new Color(24, 171, 138));
		btn_KHTour.setBounds(273, 65, 120, 40);
		panel.add(btn_KHTour);
		this.setVisible(true);
	}
	
	public void initData() {
		String [] colNames= {"Mã Tour","Tên Tour","Số ngày","Nơi đến","Mã loại","Nơi khởi hành"};
		DefaultTableModel tableModel=new DefaultTableModel();
		table_Tours.setModel(tableModel);
		tableModel.setColumnIdentifiers(colNames);
		table_Tours.addMouseListener((MouseListener) new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		      if (e.getClickCount() == 1) {
		        HienThiTour();
		      }
		    }
		});
		ArrayList<QlyToursDTO> list=tourBUS.docTour();
		for(QlyToursDTO tour:list) {
			tableModel.addRow(new Object[]{
				tour.getMatour(),tour.getTentour(),tour.getSongay()+"",tour.getNoiden(),tour.getMaloai(),tour.getNoikhoihanh()
			});
		}
	}
	public void init() {
		luu_btn.setEnabled(false);
		luu_btn.setBackground(Color.gray);
		textField_MaTour.setEditable(false);
		comboBox_LoaiTour.setEditable(false);
		tentour_tf.setEditable(false);
		songay_tf.setEditable(false);
		khoihanh_cb.setEditable(false);
		noiden_cb.setEditable(false);
		
	}
	public void noneInit() {
		luu_btn.setEnabled(true);
		luu_btn.setBackground(Color.ORANGE);
		textField_MaTour.setEditable(true);
		comboBox_LoaiTour.setEditable(true);
		tentour_tf.setEditable(true);
		songay_tf.setEditable(true);
		khoihanh_cb.setEditable(true);
		noiden_cb.setEditable(true);
	}
	public QlyToursDTO GetTourDaChon() {
		int row=table_Tours.getSelectedRow();
		DefaultTableModel model_table=(DefaultTableModel) table_Tours.getModel();
		
		String matour=model_table.getValueAt(row, 0)+"";
		String tentour=model_table.getValueAt(row, 1)+"";
		int songay=Integer.valueOf(model_table.getValueAt(row, 2) + "");
		
		String noiden=model_table.getValueAt(row, 3).toString();
		String maloai=model_table.getValueAt(row, 4).toString();
		String noikhoihanh=model_table.getValueAt(row, 5).toString();
		QlyToursDTO tour=new QlyToursDTO(matour, tentour, noiden, noikhoihanh, maloai, songay);
		return tour;	
	}
	public void HienThiTour() {
		QlyToursDTO tour=GetTourDaChon();
		this.textField_MaTour.setText(tour.getMatour());
		if(tour.getMaloai().equals("loai1")) {
			this.comboBox_LoaiTour.setSelectedItem("Trong nước");
		}else if(tour.getMaloai().equals("loai2")) {
			this.comboBox_LoaiTour.setSelectedItem("Ngoài nước");
		}
		this.tentour_tf.setText(tour.getTentour());
		this.songay_tf.setText(tour.getSongay()+"");
		this.khoihanh_cb.setSelectedItem(tour.getNoikhoihanh());
		this.noiden_cb.setSelectedItem(tour.getNoiden());
		comboBox_LoaiTour.setEnabled(false);
		khoihanh_cb.setEnabled(false);
		noiden_cb.setEnabled(false);
	}
	public void ThemTour() {
		ResetData();
		noneInit();
		sua_btn.setEnabled(false);
		sua_btn.setBackground(Color.gray);
		xoa_btn.setEnabled(false);
		xoa_btn.setBackground(Color.gray);
//		luu_btn.setEnabled(true);
//		luu_btn.setBackground(Color.orange);
		String matour=textField_MaTour.getText();
		String tentour=tentour_tf.getText();
		int songay=Integer.parseInt(tentour_tf.getText());
		String noiden=(String) noiden_cb.getSelectedItem();
		String maloai="";
		if(comboBox_LoaiTour.getSelectedItem().equals("Trong nước")) {
			maloai="loai1";
		}
		else if(comboBox_LoaiTour.getSelectedItem().equals("Ngoài nước")) {
			maloai="loai2";
		}
		String noikhoihanh=(String) khoihanh_cb.getSelectedItem();
		QlyToursDTO tour=new QlyToursDTO(matour, tentour, noiden, noikhoihanh, maloai, songay);
		if(tourBUS.them(tour)==-1) {
			JOptionPane.showMessageDialog(this, "Lỗi!");
		}
		else {
			JOptionPane.showMessageDialog(this, "Thêm thành công!");
		}
	}
	public void ResetData() {
		textField_MaTour.setText("");
		tentour_tf.setText("");
		songay_tf.setText("");
		comboBox_LoaiTour.setSelectedIndex(0);
		khoihanh_cb.setSelectedIndex(0);
		noiden_cb.setSelectedIndex(0);
	}
	public void XoaDataTable() {
		DefaultTableModel model_table = (DefaultTableModel) table_Tours.getModel();
		model_table.setRowCount(0);
	}
	
	
}
