package GUI;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import BUS.CTQuyenBUS;
import DTO.CT_Quyen_ChucNang_DTO;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import java.awt.Checkbox;
import javax.swing.ButtonGroup;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.Rectangle;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CTQuyen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField quyen_tf;
	private JCheckBox xem_DatTour,them_DatTour,sua_DatTour,xoa_DatTour;
	private JCheckBox xem_HoaDon,them_HoaDon,sua_HoaDon,xoa_HoaDon;
	private JCheckBox xem_ThongKe,them_ThongKe,sua_ThongKe,xoa_ThongKe;
	private JCheckBox xem_QuanLyTour, them_QuanLyTour, sua_QuanLyTour, xoa_QuanLyTour;
	private JCheckBox xem_KHTour, them_KHTour, sua_KHTour, xoa_KHTour;
	private JCheckBox xem_CT_KHTour, them_CT_KHTour, sua_CT_KHTour, xoa_CT_KHTour;
	private JCheckBox xem_QuanLyDV, them_QuanLyDV, sua_QuanLyDV, xoa_QuanLyDV;
	private JCheckBox xem_KhuyenMai, them_KhuyenMai, sua_KhuyenMai, xoa_KhuyenMai;
	private JCheckBox xem_CT_KhuyenMai, them_CT_KhuyenMai, sua_CT_KhuyenMai, xoa_CT_KhuyenMai;
	private JCheckBox xem_NhanVien, them_NhanVien, sua_NhanVien, xoa_NhanVien;
	private JCheckBox xem_KhachHang, them_KhachHang, sua_KhachHang, xoa_KhachHang;
	private ArrayList<JCheckBox>  checkBoxList = new ArrayList<>();
	private ArrayList<CT_Quyen_ChucNang_DTO> CTQuyenList = new ArrayList<>();
	private String maquyen;
	private CTQuyenBUS ctBUS = new CTQuyenBUS();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CTQuyen frame = new CTQuyen();
					frame.setSize(1000, 650);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public CTQuyen(String maquyen, String tenquyen) {
		this();
		quyen_tf.setText(tenquyen);
		this.maquyen = maquyen;
		
		
		if(ctBUS.docDSQuyen(maquyen)) {
			for(CT_Quyen_ChucNang_DTO t : CTQuyenBUS.CT_Quyen_DTO) {
				for (JCheckBox checkBox : checkBoxList) {
					if (checkBox.getText().equals(t.getMachucnang())) {
						checkBox.setSelected(true);
					}
				}			
			}			
		}
	}
	
	public CTQuyen() {
		// Thêm tất cả các JCheckBox vào ArrayList
       
        
        
		setBackground(SystemColor.windowText);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(280, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.setVerifyInputWhenFocusTarget(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 255));
		panel.setBounds(0, 0, 986, 603);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chi tiết quyền");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(10, 10, 946, 29);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 49, 966, 544);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 62, 926, 50);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Xem");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(259, 10, 84, 30);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Thêm");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(439, 10, 84, 30);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Sửa");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(619, 10, 84, 30);
		panel_2.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Xóa");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_2.setBounds(799, 10, 84, 30);
		panel_2.add(lblNewLabel_1_1_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 122, 926, 380);
		panel_1.add(scrollPane);
		
		JPanel panel_3 = new JPanel();
		scrollPane.setViewportView(panel_3);
		
		JPanel panel_DatTour = new JPanel();
		MatteBorder bottomBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK);
        panel_3.setLayout(new GridLayout(0, 1, 0, 0));
        panel_DatTour.setBorder(bottomBorder);
		panel_3.add(panel_DatTour);
		panel_DatTour.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Đặt tour");
		lblNewLabel_2.setBounds(10, 0, 115, 31);
		panel_DatTour.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		xem_DatTour = new JCheckBox("cn1");
		xem_DatTour.setBounds(266, 6, 21, 21);
		panel_DatTour.add(xem_DatTour);
		xem_DatTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		them_DatTour = new JCheckBox("cn2");
		them_DatTour.setBounds(453, 6, 21, 21);
		panel_DatTour.add(them_DatTour);
		them_DatTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		sua_DatTour = new JCheckBox("cn3");
		sua_DatTour.setEnabled(false);
		sua_DatTour.setBounds(624, 6, 21, 21);
		panel_DatTour.add(sua_DatTour);
		sua_DatTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		xoa_DatTour = new JCheckBox("cn4");
		xoa_DatTour.setEnabled(false);
		xoa_DatTour.setBounds(803, 6, 21, 21);
		panel_DatTour.add(xoa_DatTour);
		xoa_DatTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel panel_HoaDon = new JPanel();
		panel_HoaDon.setBorder(bottomBorder);
		panel_HoaDon.setLayout(null);
		panel_3.add(panel_HoaDon);
		
		JLabel lblNewLabel_2_1 = new JLabel("Hóa đơn");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(10, 6, 115, 31);
		panel_HoaDon.add(lblNewLabel_2_1);
		
		xem_HoaDon = new JCheckBox("cn5");
		xem_HoaDon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		xem_HoaDon.setBounds(266, 6, 21, 21);
		panel_HoaDon.add(xem_HoaDon);
		
		them_HoaDon = new JCheckBox("cn6");
		them_HoaDon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		them_HoaDon.setBounds(453, 6, 21, 21);
		panel_HoaDon.add(them_HoaDon);
		
		sua_HoaDon = new JCheckBox("cn7");
		sua_HoaDon.setEnabled(false);
		sua_HoaDon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sua_HoaDon.setBounds(624, 6, 21, 21);
		panel_HoaDon.add(sua_HoaDon);
		
		xoa_HoaDon = new JCheckBox("cn8");
		xoa_HoaDon.setEnabled(false);
		xoa_HoaDon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		xoa_HoaDon.setBounds(803, 6, 21, 21);
		panel_HoaDon.add(xoa_HoaDon);
		
		JPanel panel_ThongKe = new JPanel();
		panel_ThongKe.setBorder(bottomBorder);
		panel_ThongKe.setLayout(null);
		panel_3.add(panel_ThongKe);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Thống kê");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_1.setBounds(10, 0, 115, 36);
		panel_ThongKe.add(lblNewLabel_2_1_1);
		
		xem_ThongKe = new JCheckBox("cn9");
		xem_ThongKe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		xem_ThongKe.setBounds(266, 6, 21, 21);
		panel_ThongKe.add(xem_ThongKe);
		
		them_ThongKe = new JCheckBox("");
		them_ThongKe.setEnabled(false);
		them_ThongKe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		them_ThongKe.setBounds(453, 6, 21, 21);
		panel_ThongKe.add(them_ThongKe);
		
		sua_ThongKe = new JCheckBox("");
		sua_ThongKe.setEnabled(false);
		sua_ThongKe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sua_ThongKe.setBounds(624, 6, 21, 21);
		panel_ThongKe.add(sua_ThongKe);
		
		xoa_ThongKe = new JCheckBox("");
		xoa_ThongKe.setEnabled(false);
		xoa_ThongKe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		xoa_ThongKe.setBounds(803, 6, 21, 21);
		panel_ThongKe.add(xoa_ThongKe);
		
		JPanel panel_QuanLyTour = new JPanel();
		panel_QuanLyTour.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_QuanLyTour.setLayout(null);
		panel_3.add(panel_QuanLyTour);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Quản lý tour");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_1_1.setBounds(10, 0, 128, 36);
		panel_QuanLyTour.add(lblNewLabel_2_1_1_1);
		
		xem_QuanLyTour = new JCheckBox("cn10");
		xem_QuanLyTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		xem_QuanLyTour.setBounds(266, 6, 21, 21);
		panel_QuanLyTour.add(xem_QuanLyTour);
		
		them_QuanLyTour = new JCheckBox("cn11");
		them_QuanLyTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		them_QuanLyTour.setBounds(453, 6, 21, 21);
		panel_QuanLyTour.add(them_QuanLyTour);
		
		sua_QuanLyTour = new JCheckBox("cn12");
		sua_QuanLyTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sua_QuanLyTour.setBounds(624, 6, 21, 21);
		panel_QuanLyTour.add(sua_QuanLyTour);
		
		xoa_QuanLyTour = new JCheckBox("cn13");
		xoa_QuanLyTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		xoa_QuanLyTour.setBounds(803, 6, 21, 21);
		panel_QuanLyTour.add(xoa_QuanLyTour);
		
		JPanel panel_KHTour = new JPanel();
		panel_KHTour.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_KHTour.setLayout(null);
		panel_3.add(panel_KHTour);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Kế hoạch tour");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1.setBounds(10, 0, 128, 36);
		panel_KHTour.add(lblNewLabel_2_1_1_1_1);
		
		xem_KHTour = new JCheckBox("cn14");
		xem_KHTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		xem_KHTour.setBounds(266, 6, 21, 21);
		panel_KHTour.add(xem_KHTour);
		
		them_KHTour = new JCheckBox("cn15");
		them_KHTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		them_KHTour.setBounds(453, 6, 21, 21);
		panel_KHTour.add(them_KHTour);
		
		sua_KHTour = new JCheckBox("cn16");
		sua_KHTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sua_KHTour.setBounds(624, 6, 21, 21);
		panel_KHTour.add(sua_KHTour);
		
		xoa_KHTour = new JCheckBox("cn17");
		xoa_KHTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		xoa_KHTour.setBounds(803, 6, 21, 21);
		panel_KHTour.add(xoa_KHTour);
		
		JPanel panel_CT_KHTour = new JPanel();
		panel_CT_KHTour.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_CT_KHTour.setLayout(null);
		panel_3.add(panel_CT_KHTour);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("Quản lý tài khoản");
		lblNewLabel_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_1.setBounds(10, 0, 186, 36);
		panel_CT_KHTour.add(lblNewLabel_2_1_1_1_1_1);
		
		xem_CT_KHTour = new JCheckBox("cn18");
		xem_CT_KHTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		xem_CT_KHTour.setBounds(266, 6, 21, 21);
		panel_CT_KHTour.add(xem_CT_KHTour);
		
		them_CT_KHTour = new JCheckBox("cn19");
		them_CT_KHTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		them_CT_KHTour.setBounds(453, 6, 21, 21);
		panel_CT_KHTour.add(them_CT_KHTour);
		
		sua_CT_KHTour = new JCheckBox("cn20");
		sua_CT_KHTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sua_CT_KHTour.setBounds(624, 6, 21, 21);
		panel_CT_KHTour.add(sua_CT_KHTour);
		
		xoa_CT_KHTour = new JCheckBox("cn40");
		xoa_CT_KHTour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		xoa_CT_KHTour.setBounds(803, 6, 21, 21);
		panel_CT_KHTour.add(xoa_CT_KHTour);
		
		JPanel panel_QuanLyDV = new JPanel();
		panel_QuanLyDV.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_QuanLyDV.setLayout(null);
		panel_3.add(panel_QuanLyDV);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1 = new JLabel("Quản lý dịch vụ");
		lblNewLabel_2_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_1_1.setBounds(10, 0, 187, 36);
		panel_QuanLyDV.add(lblNewLabel_2_1_1_1_1_1_1);
		
		xem_QuanLyDV = new JCheckBox("cn21");
		xem_QuanLyDV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		xem_QuanLyDV.setBounds(266, 6, 21, 21);
		panel_QuanLyDV.add(xem_QuanLyDV);
		
		them_QuanLyDV = new JCheckBox("cn22");
		them_QuanLyDV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		them_QuanLyDV.setBounds(453, 6, 21, 21);
		panel_QuanLyDV.add(them_QuanLyDV);
		
		sua_QuanLyDV = new JCheckBox("cn23");
		sua_QuanLyDV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sua_QuanLyDV.setBounds(624, 6, 21, 21);
		panel_QuanLyDV.add(sua_QuanLyDV);
		
		xoa_QuanLyDV = new JCheckBox("cn24");
		xoa_QuanLyDV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		xoa_QuanLyDV.setBounds(803, 6, 21, 21);
		panel_QuanLyDV.add(xoa_QuanLyDV);
		
		JPanel panel_KhuyenMai = new JPanel();
		panel_KhuyenMai.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_KhuyenMai.setLayout(null);
		panel_3.add(panel_KhuyenMai);
		
		JLabel lblNewLabel_2_1_1_1_1_3 = new JLabel("Khuyến mãi");
		lblNewLabel_2_1_1_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_3.setBounds(10, 0, 128, 36);
		panel_KhuyenMai.add(lblNewLabel_2_1_1_1_1_3);
		
		xem_KhuyenMai = new JCheckBox("cn25");
		xem_KhuyenMai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		xem_KhuyenMai.setBounds(266, 6, 21, 21);
		panel_KhuyenMai.add(xem_KhuyenMai);
		
		them_KhuyenMai = new JCheckBox("cn26");
		them_KhuyenMai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		them_KhuyenMai.setBounds(453, 6, 21, 21);
		panel_KhuyenMai.add(them_KhuyenMai);
		
		sua_KhuyenMai = new JCheckBox("cn27");
		sua_KhuyenMai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sua_KhuyenMai.setBounds(624, 6, 21, 21);
		panel_KhuyenMai.add(sua_KhuyenMai);
		
		xoa_KhuyenMai = new JCheckBox("cn28");
		xoa_KhuyenMai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		xoa_KhuyenMai.setBounds(803, 6, 21, 21);
		panel_KhuyenMai.add(xoa_KhuyenMai);
		
		JPanel panel_KhuyenMai_1 = new JPanel();
		panel_KhuyenMai_1.setLayout(null);
		panel_KhuyenMai_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_3.add(panel_KhuyenMai_1);
		
		JLabel lblNewLabel_2_1_1_1_1_3_1 = new JLabel("Chi tiết khuyến mãi");
		lblNewLabel_2_1_1_1_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_1_1_1_3_1.setBounds(10, 0, 187, 36);
		panel_KhuyenMai_1.add(lblNewLabel_2_1_1_1_1_3_1);
		
		xem_CT_KhuyenMai = new JCheckBox("cn29");
		xem_CT_KhuyenMai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		xem_CT_KhuyenMai.setBounds(266, 6, 21, 21);
		panel_KhuyenMai_1.add(xem_CT_KhuyenMai);
		
		them_CT_KhuyenMai = new JCheckBox("cn30");
		them_CT_KhuyenMai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		them_CT_KhuyenMai.setBounds(453, 6, 21, 21);
		panel_KhuyenMai_1.add(them_CT_KhuyenMai);
		
		sua_CT_KhuyenMai = new JCheckBox("");
		sua_CT_KhuyenMai.setEnabled(false);
		sua_CT_KhuyenMai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sua_CT_KhuyenMai.setBounds(624, 6, 21, 21);
		panel_KhuyenMai_1.add(sua_CT_KhuyenMai);
		
		xoa_CT_KhuyenMai = new JCheckBox("cn31");
		xoa_CT_KhuyenMai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		xoa_CT_KhuyenMai.setBounds(803, 6, 21, 21);
		panel_KhuyenMai_1.add(xoa_CT_KhuyenMai);
		
		JPanel panel_NhanVien = new JPanel();
		panel_NhanVien.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_NhanVien.setLayout(null);
		panel_3.add(panel_NhanVien);
		
		JLabel lblNewLabel_2_2 = new JLabel("Nhân viên");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_2.setBounds(10, 0, 115, 36);
		panel_NhanVien.add(lblNewLabel_2_2);
		
		xem_NhanVien = new JCheckBox("cn32");
		xem_NhanVien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		xem_NhanVien.setBounds(266, 6, 21, 21);
		panel_NhanVien.add(xem_NhanVien);
		
		them_NhanVien = new JCheckBox("cn33");
		them_NhanVien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		them_NhanVien.setBounds(453, 6, 21, 21);
		panel_NhanVien.add(them_NhanVien);
		
		sua_NhanVien = new JCheckBox("cn34");
		sua_NhanVien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sua_NhanVien.setBounds(624, 6, 21, 21);
		panel_NhanVien.add(sua_NhanVien);
		
		xoa_NhanVien = new JCheckBox("cn35");
		xoa_NhanVien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		xoa_NhanVien.setBounds(803, 6, 21, 21);
		panel_NhanVien.add(xoa_NhanVien);
		
		JPanel panel_KhachHang = new JPanel();
		panel_KhachHang.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_KhachHang.setLayout(null);
		panel_3.add(panel_KhachHang);
		
		JLabel lblNewLabel_2_3 = new JLabel("Khách hàng");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_3.setBounds(10, 0, 115, 36);
		panel_KhachHang.add(lblNewLabel_2_3);
		
		xem_KhachHang = new JCheckBox("cn36");
		xem_KhachHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		xem_KhachHang.setBounds(266, 6, 21, 21);
		panel_KhachHang.add(xem_KhachHang);
		
		them_KhachHang = new JCheckBox("cn37");
		them_KhachHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		them_KhachHang.setBounds(453, 6, 21, 21);
		panel_KhachHang.add(them_KhachHang);
		
		sua_KhachHang = new JCheckBox("cn38");
		sua_KhachHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sua_KhachHang.setBounds(624, 6, 21, 21);
		panel_KhachHang.add(sua_KhachHang);
		
		xoa_KhachHang = new JCheckBox("cn39");
		xoa_KhachHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		xoa_KhachHang.setBounds(803, 6, 21, 21);
		panel_KhachHang.add(xoa_KhachHang);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBounds(10, 10, 926, 42);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Tên vai trò");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(10, 10, 103, 22);
		panel_5.add(lblNewLabel_3);
		
		quyen_tf = new JTextField();
		quyen_tf.setFocusable(false);
		quyen_tf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		quyen_tf.setBounds(145, 10, 146, 23);
		panel_5.add(quyen_tf);
		quyen_tf.setColumns(10);
		
		JButton luu_btn = new JButton("Lưu");
		luu_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CTQuyenList.clear();
	            for (JCheckBox checkBox : checkBoxList) {
	                if (checkBox.isSelected()) {
	                	CT_Quyen_ChucNang_DTO tmp = new CT_Quyen_ChucNang_DTO(maquyen, checkBox.getText());
	                    CTQuyenList.add(tmp);
	                }
	            }
	            luu_CTQuyen();
//	            for(CT_Quyen_ChucNang_DTO t: CTQuyenList) {
//	            	System.out.println(t.getMaquyen()+" " + t.getMachucnang());
//	            }
			}
		});
		luu_btn.setForeground(Color.WHITE);
		luu_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		luu_btn.setFocusable(false);
		luu_btn.setBackground(new Color(255, 127, 80));
		luu_btn.setBounds(438, 508, 85, 26);
		panel_1.add(luu_btn);
		
		
		checkBoxList.add(xem_DatTour); checkBoxList.add(them_DatTour); checkBoxList.add(sua_DatTour); checkBoxList.add(xoa_DatTour);
        checkBoxList.add(xem_HoaDon); checkBoxList.add(them_HoaDon); checkBoxList.add(sua_HoaDon); checkBoxList.add(xoa_HoaDon);
        checkBoxList.add(xem_ThongKe); checkBoxList.add(them_ThongKe); checkBoxList.add(sua_ThongKe); checkBoxList.add(xoa_ThongKe);
        checkBoxList.add(xem_QuanLyTour); checkBoxList.add(them_QuanLyTour); checkBoxList.add(sua_QuanLyTour); checkBoxList.add(xoa_QuanLyTour);
        checkBoxList.add(xem_KHTour); checkBoxList.add(them_KHTour); checkBoxList.add(sua_KHTour); checkBoxList.add(xoa_KHTour);
        checkBoxList.add(xem_CT_KHTour); checkBoxList.add(them_CT_KHTour); checkBoxList.add(sua_CT_KHTour); checkBoxList.add(xoa_CT_KHTour);
        checkBoxList.add(xem_QuanLyDV); checkBoxList.add(them_QuanLyDV); checkBoxList.add(sua_QuanLyDV); checkBoxList.add(xoa_QuanLyDV);
        checkBoxList.add(xem_KhuyenMai); checkBoxList.add(them_KhuyenMai); checkBoxList.add(sua_KhuyenMai); checkBoxList.add(xoa_KhuyenMai);
        checkBoxList.add(xem_CT_KhuyenMai); checkBoxList.add(them_CT_KhuyenMai); checkBoxList.add(sua_CT_KhuyenMai); checkBoxList.add(xoa_CT_KhuyenMai);
        checkBoxList.add(xem_NhanVien); checkBoxList.add(them_NhanVien); checkBoxList.add(sua_NhanVien); checkBoxList.add(xoa_NhanVien);
        checkBoxList.add(xem_KhachHang); checkBoxList.add(them_KhachHang); checkBoxList.add(sua_KhachHang); checkBoxList.add(xoa_KhachHang);
		
	}
	
	
	
	
	public void luu_CTQuyen() {
		if(CTQuyenList.isEmpty()) {
			return;
		}
		if(ctBUS.capnhatCTQuyen(CTQuyenList)!=-1) {
			JOptionPane.showMessageDialog(null,"Lưu thành công");
		}else {
			JOptionPane.showMessageDialog(null,"Lưu không thành công");
		}
	}
	
}
