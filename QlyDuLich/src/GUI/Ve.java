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
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

public class Ve extends JFrame {

//	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_HoTenKH;
	private JTextField textField_SDTKH;
	private JTextField textField_DiaChiKH;
	private JTextField textField_EmailKH;
	private JTextField textField_HoTenTV;
	private JTextField textField_SDTTV;
	private JTable table_ThongTin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ve frame = new Ve();
					frame.setSize(1000, 780);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ve() {
		setBackground(SystemColor.windowText);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 20, 1000, 780);
		contentPane = new JPanel();
		contentPane.setVerifyInputWhenFocusTarget(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(34, 99, 138));
		panel.setBounds(0, 0, 1000, 750);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		this.getContentPane().add(panel);
		
		JPanel panel_Header = new JPanel();
		panel_Header.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_Header.setBounds(10, 26, 967, 185);
		panel.add(panel_Header);
		panel_Header.setLayout(null);
		
		Label label_iconTour = new Label("New label");
		label_iconTour.setBackground(new Color(0, 128, 255));
		label_iconTour.setBounds(22, 10, 180, 160);
		panel_Header.add(label_iconTour);
		
		
		JPanel panel_Header_content = new JPanel();
		panel_Header_content.setBounds(226, 10, 731, 169);
		panel_Header.add(panel_Header_content);
		panel_Header_content.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MÃ TOUR:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 0, 98, 23);
		panel_Header_content.add(lblNewLabel);
		
		JLabel lbl_Mstuor = new JLabel("content");
		lbl_Mstuor.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_Mstuor.setBounds(131, 0, 98, 23);
		panel_Header_content.add(lbl_Mstuor);
		
		JLabel lbl_TenTour = new JLabel("<html>[Mã Tour] TOUR DU LỊCH NHẬT BẢN - LỄ HỘI ÁNH SÁNG [OSAKA - KOBE</br>\r\n- KYOTO - VƯỜN TRÁI CÂY - NÚI PHÚ SỸ - TOKYO]</html>");
		lbl_TenTour.setVerticalAlignment(SwingConstants.TOP);
		lbl_TenTour.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_TenTour.setBounds(10, 31, 721, 53);
		panel_Header_content.add(lbl_TenTour);
		
		JLabel lblKhiHnh = new JLabel("Khởi hành:");
		lblKhiHnh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKhiHnh.setBounds(40, 80, 98, 23);
		panel_Header_content.add(lblKhiHnh);
		
		JLabel lbl_Time = new JLabel("time");
		lbl_Time.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Time.setBounds(181, 80, 234, 23);
		panel_Header_content.add(lbl_Time);
		
		JLabel lblThiGian = new JLabel("Thời gian:");
		lblThiGian.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblThiGian.setBounds(40, 102, 98, 23);
		panel_Header_content.add(lblThiGian);
		
		JLabel lbl_Day = new JLabel("day");
		lbl_Day.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Day.setBounds(181, 102, 234, 23);
		panel_Header_content.add(lbl_Day);
		
		JLabel lblNiKhiHnh = new JLabel("Nơi khởi hành:");
		lblNiKhiHnh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNiKhiHnh.setBounds(40, 124, 98, 23);
		panel_Header_content.add(lblNiKhiHnh);
		
		JLabel lbl_Location = new JLabel("location");
		lbl_Location.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Location.setBounds(181, 124, 234, 23);
		panel_Header_content.add(lbl_Location);
		
		JLabel lbl_Slot = new JLabel("slot");
		lbl_Slot.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Slot.setBounds(181, 146, 76, 23);
		panel_Header_content.add(lbl_Slot);
		
		JLabel lblSChCn = new JLabel("Số chỗ còn nhận:");
		lblSChCn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSChCn.setBounds(40, 146, 119, 23);
		panel_Header_content.add(lblSChCn);
		
		JLabel lblHngDnVin = new JLabel("Hướng dẫn viên:");
		lblHngDnVin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHngDnVin.setBounds(514, 146, 119, 23);
		panel_Header_content.add(lblHngDnVin);
		
		JLabel lbl_HDV = new JLabel("NV01");
		lbl_HDV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_HDV.setBounds(655, 146, 76, 23);
		panel_Header_content.add(lbl_HDV);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(10, 207, 567, 533);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tổng quan về chuyến đi");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(168, 10, 234, 26);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Thông tin liên lạc");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(10, 46, 234, 26);
		panel_1.add(lblNewLabel_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 70, 547, 168);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Họ và tên");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(10, 0, 97, 26);
		panel_2.add(lblNewLabel_1_1_1);
		
		textField_HoTenKH = new JTextField();
		textField_HoTenKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_HoTenKH.setBounds(10, 30, 240, 25);
		panel_2.add(textField_HoTenKH);
		textField_HoTenKH.setColumns(10);
		
		textField_SDTKH = new JTextField();
		textField_SDTKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_SDTKH.setColumns(10);
		textField_SDTKH.setBounds(10, 95, 240, 25);
		panel_2.add(textField_SDTKH);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Số điện thoại");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(10, 65, 97, 26);
		panel_2.add(lblNewLabel_1_1_1_1);
		
		textField_DiaChiKH = new JTextField();
		textField_DiaChiKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_DiaChiKH.setColumns(10);
		textField_DiaChiKH.setBounds(302, 95, 240, 25);
		panel_2.add(textField_DiaChiKH);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Email");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_2.setBounds(302, 0, 97, 26);
		panel_2.add(lblNewLabel_1_1_1_2);
		
		textField_EmailKH = new JTextField();
		textField_EmailKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_EmailKH.setColumns(10);
		textField_EmailKH.setBounds(302, 30, 240, 25);
		panel_2.add(textField_EmailKH);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Địa chỉ");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1.setBounds(302, 65, 97, 26);
		panel_2.add(lblNewLabel_1_1_1_1_1);
		
		JButton btnNewButton_Luu = new JButton("Lưu");
		btnNewButton_Luu.setBounds(230, 130, 85, 26);
		panel_2.add(btnNewButton_Luu);
		btnNewButton_Luu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_Luu.setForeground(Color.WHITE);
		btnNewButton_Luu.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_Luu.setFocusable(false);
		btnNewButton_Luu.setBackground(new Color(255, 128, 64));
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Danh sách khách đi tour");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_2.setBounds(10, 238, 234, 26);
		panel_1.add(lblNewLabel_1_1_2);
		
		JButton btnNewButton_Them = new JButton("Thêm");
		btnNewButton_Them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_Them.setForeground(Color.WHITE);
		btnNewButton_Them.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_Them.setFocusable(false);
		btnNewButton_Them.setBackground(new Color(65, 105, 225));
		btnNewButton_Them.setBounds(299, 332, 75, 25);
		panel_1.add(btnNewButton_Them);
		
		JButton btnNewButton_Sua = new JButton("Sửa");
		btnNewButton_Sua.setForeground(Color.WHITE);
		btnNewButton_Sua.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_Sua.setFocusable(false);
		btnNewButton_Sua.setBackground(new Color(50, 205, 50));
		btnNewButton_Sua.setBounds(384, 332, 75, 25);
		panel_1.add(btnNewButton_Sua);
		
		JButton btnNewButton_Xoa = new JButton("Xóa");
		btnNewButton_Xoa.setForeground(Color.WHITE);
		btnNewButton_Xoa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_Xoa.setFocusable(false);
		btnNewButton_Xoa.setBackground(Color.RED);
		btnNewButton_Xoa.setBounds(469, 332, 75, 25);
		panel_1.add(btnNewButton_Xoa);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 367, 537, 156);
		panel_1.add(scrollPane);
		
		table_ThongTin = new JTable();
		scrollPane.setViewportView(table_ThongTin);
		table_ThongTin.setModel(new DefaultTableModel(
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
			},
			new String[] {
				"STT", "H\u1ECD v\u00E0 t\u00EAn", "Gi\u1EDBi t\u00EDnh", "N\u0103m sinh", "\u0110\u1ED9 tu\u1ED5i", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, String.class, String.class, Object.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_ThongTin.getColumnModel().getColumn(0).setPreferredWidth(23);
		table_ThongTin.getColumnModel().getColumn(1).setPreferredWidth(103);
		table_ThongTin.getColumnModel().getColumn(2).setPreferredWidth(57);
		table_ThongTin.getColumnModel().getColumn(3).setPreferredWidth(82);
		table_ThongTin.getColumnModel().getColumn(4).setPreferredWidth(58);
		table_ThongTin.getColumnModel().getColumn(5).setPreferredWidth(99);
		
		JLabel lblNewLabel_1_1_1_3 = new JLabel("Họ và tên");
		lblNewLabel_1_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_3.setBounds(20, 260, 97, 26);
		panel_1.add(lblNewLabel_1_1_1_3);
		
		textField_HoTenTV = new JTextField();
		textField_HoTenTV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_HoTenTV.setColumns(10);
		textField_HoTenTV.setBounds(20, 296, 120, 25);
		panel_1.add(textField_HoTenTV);
		
		JLabel lblNewLabel_1_1_1_3_1 = new JLabel("Giới tính");
		lblNewLabel_1_1_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_3_1.setBounds(168, 260, 70, 26);
		panel_1.add(lblNewLabel_1_1_1_3_1);
		
		JComboBox comboBox_GioiTinhTV = new JComboBox();
		comboBox_GioiTinhTV.setBackground(new Color(255, 255, 255));
		comboBox_GioiTinhTV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_GioiTinhTV.setBounds(168, 296, 70, 25);
		panel_1.add(comboBox_GioiTinhTV);
		
		JLabel lblNewLabel_1_1_1_3_2 = new JLabel("Năm sinh");
		lblNewLabel_1_1_1_3_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_3_2.setBounds(257, 260, 97, 26);
		panel_1.add(lblNewLabel_1_1_1_3_2);
		
		JDateChooser dateChooser_NamSinhTV = new JDateChooser();
		dateChooser_NamSinhTV.setBounds(257, 296, 90, 26);
		panel_1.add(dateChooser_NamSinhTV);
		
		JLabel lblNewLabel_1_1_1_3_3 = new JLabel("Độ tuổi");
		lblNewLabel_1_1_1_3_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_3_3.setBounds(360, 260, 70, 26);
		panel_1.add(lblNewLabel_1_1_1_3_3);
		
		JComboBox comboBox_DoTuoiTV = new JComboBox();
		comboBox_DoTuoiTV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_DoTuoiTV.setBackground(Color.WHITE);
		comboBox_DoTuoiTV.setBounds(360, 297, 70, 25);
		panel_1.add(comboBox_DoTuoiTV);
		
		JLabel lblNewLabel_1_1_1_3_4 = new JLabel("Số điện thoại");
		lblNewLabel_1_1_1_3_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_3_4.setBounds(447, 260, 97, 26);
		panel_1.add(lblNewLabel_1_1_1_3_4);
		
		textField_SDTTV = new JTextField();
		textField_SDTTV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_SDTTV.setColumns(10);
		textField_SDTTV.setBounds(447, 297, 110, 25);
		panel_1.add(textField_SDTTV);
		
		JLabel lblNewLabel_1_1_1_3_5 = new JLabel("Mã giảm giá:");
		lblNewLabel_1_1_1_3_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_3_5.setBounds(20, 331, 97, 26);
		panel_1.add(lblNewLabel_1_1_1_3_5);
		
		JComboBox comboBox_MAGG = new JComboBox();
		comboBox_MAGG.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_MAGG.setBackground(Color.WHITE);
		comboBox_MAGG.setBounds(111, 332, 85, 25);
		panel_1.add(comboBox_MAGG);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(577, 207, 400, 533);
		panel.add(panel_1_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(10, 10, 380, 124);
		panel_1_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("Hóa đơn");
		lblNewLabel_1_2.setBounds(151, 5, 77, 22);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_3.add(lblNewLabel_1_2);
		
		JLabel lblHanS = new JLabel("Hóa đơn số:");
		lblHanS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHanS.setBounds(10, 28, 98, 23);
		panel_3.add(lblHanS);
		
		JLabel lbl_MAHD = new JLabel("HD01");
		lbl_MAHD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_MAHD.setBounds(172, 28, 187, 23);
		panel_3.add(lbl_MAHD);
		
		JLabel lbl_NgayHD = new JLabel("day");
		lbl_NgayHD.setBorder(null);
		lbl_NgayHD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_NgayHD.setBounds(172, 50, 187, 23);
		panel_3.add(lbl_NgayHD);
		
		JLabel lblNgyToHa = new JLabel("Ngày tạo hóa đơn:");
		lblNgyToHa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNgyToHa.setBounds(10, 50, 131, 23);
		panel_3.add(lblNgyToHa);
		
		JLabel lblTnNhVin = new JLabel("Tên nhân viên:");
		lblTnNhVin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnNhVin.setBounds(10, 72, 119, 23);
		panel_3.add(lblTnNhVin);
		
		JLabel lbl_NameNV = new JLabel("nameNV");
		lbl_NameNV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_NameNV.setBounds(172, 72, 187, 23);
		panel_3.add(lbl_NameNV);
		
		JLabel lbl_NameKH = new JLabel("nameKH");
		lbl_NameKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_NameKH.setBounds(172, 94, 187, 23);
		panel_3.add(lbl_NameKH);
		
		JLabel lblTnKhchHng = new JLabel("Tên khách Hàng:");
		lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnKhchHng.setBounds(10, 94, 119, 23);
		panel_3.add(lblTnKhchHng);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 148, 380, 177);
		panel_1_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1_3 = new JLabel("Tóm tắt chuyến đi");
		lblNewLabel_1_3.setBounds(110, 0, 168, 26);
		panel_4.add(lblNewLabel_1_3);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblTnTour = new JLabel("Tên Tour:");
		lblTnTour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnTour.setBounds(10, 30, 73, 23);
		panel_4.add(lblTnTour);
		
		JLabel lbl_Time_1_1 = new JLabel("<html>TOUR DU LỊCH NHẬT BẢN - LỄ HỘI ÁNH SÁNG</br></html>");
		lbl_Time_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Time_1_1.setBounds(93, 30, 277, 38);
		panel_4.add(lbl_Time_1_1);
		
		Label label_1 = new Label("New label");
		label_1.setBackground(new Color(0, 128, 255));
		label_1.setBounds(10, 74, 120, 93);
		panel_4.add(label_1);
		
		JLabel lblBtuChuyn = new JLabel("Bắt đầu chuyến đi:");
		lblBtuChuyn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBtuChuyn.setBounds(177, 78, 131, 23);
		panel_4.add(lblBtuChuyn);
		
		JLabel lblKtThcChuyn = new JLabel("Kết thúc chuyến đi:");
		lblKtThcChuyn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKtThcChuyn.setBounds(177, 130, 156, 23);
		panel_4.add(lblKtThcChuyn);
		
		JLabel lbl_Time_2 = new JLabel("time:time:time");
		lbl_Time_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_Time_2.setBounds(177, 97, 177, 23);
		panel_4.add(lbl_Time_2);
		
		JLabel lbl_Time_2_1 = new JLabel("time:time:time");
		lbl_Time_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_Time_2_1.setBounds(177, 153, 177, 23);
		panel_4.add(lbl_Time_2_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 324, 380, 209);
		panel_1_1.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblTngCng = new JLabel("Tổng cộng:");
		lblTngCng.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTngCng.setBounds(10, 130, 119, 23);
		panel_5.add(lblTngCng);
		
		JLabel lblTrEm = new JLabel("Trẻ em:");
		lblTrEm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTrEm.setBounds(10, 70, 119, 23);
		panel_5.add(lblTrEm);
		
		JLabel lblNgiLn = new JLabel("Người lớn:");
		lblNgiLn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgiLn.setBounds(10, 40, 131, 23);
		panel_5.add(lblNgiLn);
		
		JLabel lblHnhKhch = new JLabel("Hành khách:");
		lblHnhKhch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHnhKhch.setBounds(10, 10, 98, 23);
		panel_5.add(lblHnhKhch);
		
		JLabel lbl_SLKhach = new JLabel("0");
		lbl_SLKhach.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_SLKhach.setBounds(246, 10, 113, 23);
		panel_5.add(lbl_SLKhach);
		
		JLabel lbl_NguoiLon = new JLabel("0x0đ");
		lbl_NguoiLon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_NguoiLon.setBorder(null);
		lbl_NguoiLon.setBounds(246, 40, 113, 23);
		panel_5.add(lbl_NguoiLon);
		
		JLabel lbl_TreEm = new JLabel("0x0đ");
		lbl_TreEm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_TreEm.setBounds(246, 70, 113, 23);
		panel_5.add(lbl_TreEm);
		
		JLabel lbl_Tong = new JLabel("0đ");
		lbl_Tong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_Tong.setBounds(246, 130, 113, 23);
		panel_5.add(lbl_Tong);
		
		JButton btnNewButton_ThanhToan = new JButton("Thanh toán");
		btnNewButton_ThanhToan.setForeground(Color.WHITE);
		btnNewButton_ThanhToan.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_ThanhToan.setFocusable(false);
		btnNewButton_ThanhToan.setBackground(new Color(255, 128, 64));
		btnNewButton_ThanhToan.setBounds(63, 173, 119, 26);
		panel_5.add(btnNewButton_ThanhToan);
		
		JLabel lblGimGi = new JLabel("Giảm giá:");
		lblGimGi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGimGi.setBounds(10, 100, 119, 23);
		panel_5.add(lblGimGi);
		
		JLabel lbl_GiamGia = new JLabel("0đ");
		lbl_GiamGia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_GiamGia.setBounds(246, 100, 113, 23);
		panel_5.add(lbl_GiamGia);
		
		JButton btnNewButton_Thoat = new JButton("Thoát");
		btnNewButton_Thoat.setForeground(Color.WHITE);
		btnNewButton_Thoat.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_Thoat.setFocusable(false);
		btnNewButton_Thoat.setBackground(new Color(255, 0, 0));
		btnNewButton_Thoat.setBounds(229, 173, 119, 26);
		btnNewButton_Thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				DatTourGUI dt = new DatTourGUI();
				dt.btn_DatTour.setBackground(Color.ORANGE);
				dt.btn_DatTour.setForeground(Color.BLACK);
			}
		});
		panel_5.add(btnNewButton_Thoat);
		
		String [] item_gender = {"Nam","Nữ"};
		this.setVisible(true);
	}
}