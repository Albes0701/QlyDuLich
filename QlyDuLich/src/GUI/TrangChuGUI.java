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

public class TrangChuGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_NgayVL;
	private Label nhanvien_lb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChuGUI frame = new TrangChuGUI();
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
	public TrangChuGUI() {
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
		
		Label Tour_lb = new Label("Tours");
		Tour_lb.setAlignment(Label.CENTER);
		Tour_lb.setFont(new Font("Dialog", Font.BOLD, 15));
		Tour_lb.setBackground(new Color(0, 128, 255));
		Tour_lb.setBounds(100, 116, 200, 120);
		KhachHang.add(Tour_lb);
		
		Label kehoachtour_lb = new Label("Kế hoạch Tour");
		kehoachtour_lb.setAlignment(Label.CENTER);
		kehoachtour_lb.setFont(new Font("Dialog", Font.BOLD, 15));
		kehoachtour_lb.setBackground(new Color(0, 128, 255));
		kehoachtour_lb.setBounds(374, 116, 200, 120);
		KhachHang.add(kehoachtour_lb);
		
		Label hoadon_lb = new Label("Hóa đơn");
		hoadon_lb.setAlignment(Label.CENTER);
		hoadon_lb.setFont(new Font("Tahoma", Font.BOLD, 15));
		hoadon_lb.setBackground(new Color(0, 128, 255));
		hoadon_lb.setBounds(639, 116, 200, 120);
		KhachHang.add(hoadon_lb);
		
		nhanvien_lb = new Label("Nhân viên");
		nhanvien_lb.setAlignment(Label.CENTER);
		nhanvien_lb.setFont(new Font("Dialog", Font.BOLD, 15));
		nhanvien_lb.setBackground(new Color(0, 128, 255));
		nhanvien_lb.setBounds(100, 314, 200, 120);
		KhachHang.add(nhanvien_lb);
		
		Label khachhang_lb = new Label("Khách hàng");
		khachhang_lb.setAlignment(Label.CENTER);
		khachhang_lb.setFont(new Font("Dialog", Font.BOLD, 15));
		khachhang_lb.setBackground(new Color(0, 128, 255));
		khachhang_lb.setBounds(374, 314, 200, 120);
		KhachHang.add(khachhang_lb);
		
		Label khuyenmai_lb = new Label("Khuyến mãi");
		khuyenmai_lb.setAlignment(Label.CENTER);
		khuyenmai_lb.setFont(new Font("Arial", Font.BOLD, 15));
		khuyenmai_lb.setFocusable(false);
		khuyenmai_lb.setBackground(new Color(0, 128, 255));
		khuyenmai_lb.setBounds(639, 314, 200, 120);
		KhachHang.add(khuyenmai_lb);
		
		JLabel trangchu_lb = new JLabel("Trang chủ(Kiếm tra số lượng)");
		trangchu_lb.setFont(new Font("Tahoma", Font.BOLD, 20));
		trangchu_lb.setBounds(316, 10, 322, 80);
		KhachHang.add(trangchu_lb);
		
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