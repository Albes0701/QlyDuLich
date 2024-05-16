package GUI;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.toedter.calendar.JDateChooser;

import BUS.HoaDonBUS;
import BUS.KHToursBUS;
import BUS.KhuyenMaiBUS;
import BUS.QlyToursBUS;
import BUS.QlyVeBUS;
import DTO.CTKM_DTO;
import DTO.DatTourDTO;
import DTO.HoaDonDTO;
import DTO.KHTourDTO;
import DTO.KhachHangDTO;
import DTO.KhachSanDTO;
import DTO.KhuyenMaiDTO;
import DTO.QlyToursDTO;
import DTO.VeDTO;
import BUS.taikhoanBUS;
import DTO.NhanVienDTO;
import DTO.taikhoanDTO;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;

public class Ve extends JFrame {

//	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfHoTen;
	private JTextField tfSdt;
	private JTextField tfDiachi;
	private JTextField tfEmail;
	private JTable table_ThongTin;
	private String mahd,MaKHT1;
	private double giave=0,tongcong=0,tongcong_truocgg=0;
	private Date ngaytaohoadon;
	private JComboBox<String> cbGioitinh,cbMaKM;
	private JDateChooser datechooserNgaysinh;
	private JButton btnLuu1;
//	private String [] arr_TTLienLac;
	private JLabel lbNameKH,lbSlot,lbSLHanhKhach,lbTongCong,lbNguoiLon,lbTreEm,lbGiamGia;
	private int socho;
	private HoaDonDTO hd;
	
	QlyVeBUS veBUS=new QlyVeBUS();
	HoaDonBUS hdBUS=new HoaDonBUS();
	private JTextField tfPhanTram;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Ve frame = new Ve();
//					frame.setSize(1000, 780);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Ve(DatTourDTO tourduocchon) {
		mahd=TaoMaHD();
		MaKHT1=tourduocchon.getMakht();
		giave=tourduocchon.getGiatour();
		socho=tourduocchon.getSonguoi();
		
		long millis=System.currentTimeMillis();      
	    ngaytaohoadon = new java.sql.Date(millis); 
		
		
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
		
		
		JPanel panel_Header_content = new JPanel();
		panel_Header_content.setBounds(226, 10, 731, 169);
		panel_Header.add(panel_Header_content);
		panel_Header_content.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MÃ TOUR:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 0, 98, 23);
		panel_Header_content.add(lblNewLabel);
		
		JLabel lbMatour = new JLabel(tourduocchon.getMatour());
		lbMatour.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbMatour.setBounds(131, 0, 98, 23);
		panel_Header_content.add(lbMatour);
		
		JLabel lbTentour = new JLabel(tourduocchon.getTentour());
		lbTentour.setVerticalAlignment(SwingConstants.TOP);
		lbTentour.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbTentour.setBounds(10, 31, 721, 53);
		panel_Header_content.add(lbTentour);
		
		JLabel lblKhiHnh = new JLabel("Khởi hành:");
		lblKhiHnh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKhiHnh.setBounds(40, 80, 98, 23);
		panel_Header_content.add(lblKhiHnh);
		
		JLabel lbTgKhoiHanh = new JLabel(tourduocchon.getNgaydi().toString());
		lbTgKhoiHanh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbTgKhoiHanh.setBounds(181, 80, 234, 23);
		panel_Header_content.add(lbTgKhoiHanh);
		
		JLabel lblThiGian = new JLabel("Thời gian:");
		lblThiGian.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblThiGian.setBounds(40, 102, 98, 23);
		panel_Header_content.add(lblThiGian);
		
		JLabel lbDay = new JLabel(GetSoNgay(tourduocchon.getMatour())+" "+"ngày");
		lbDay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbDay.setBounds(181, 102, 234, 23);
		panel_Header_content.add(lbDay);
		
		JLabel lblNiKhiHnh = new JLabel("Nơi khởi hành:");
		lblNiKhiHnh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNiKhiHnh.setBounds(40, 124, 98, 23);
		panel_Header_content.add(lblNiKhiHnh);
		
		JLabel lbNoiKhoiHanh = new JLabel(tourduocchon.getNoikhoihanh());
		lbNoiKhoiHanh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbNoiKhoiHanh.setBounds(181, 124, 234, 23);
		panel_Header_content.add(lbNoiKhoiHanh);
		
		lbSlot = new JLabel(socho+" "+"chỗ");
		lbSlot.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbSlot.setBounds(181, 146, 76, 23);
		panel_Header_content.add(lbSlot);
		
		JLabel lblSChCn = new JLabel("Số chỗ còn nhận:");
		lblSChCn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSChCn.setBounds(40, 146, 119, 23);
		panel_Header_content.add(lblSChCn);
		
		JLabel lblHngDnVin = new JLabel("Hướng dẫn viên:");
		lblHngDnVin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHngDnVin.setBounds(398, 146, 119, 23);
		panel_Header_content.add(lblHngDnVin);
		
		JLabel lbHuongDanVien = new JLabel(GetHuongDanVien(tourduocchon.getMakht()));
		lbHuongDanVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbHuongDanVien.setBounds(527, 146, 194, 23);
		panel_Header_content.add(lbHuongDanVien);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(0, 128, 64));
		panel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_6.setBounds(10, 10, 215, 169);
		panel_Header.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel label_iconTour = new JLabel("New label");
		label_iconTour.setBounds(10, 7, 195, 152);
		label_iconTour.setBackground(new Color(0, 128, 255));
		ImageIcon img1=new ImageIcon(tourduocchon.getHinh1().replace('#', '\\'));
		Image image1 = img1.getImage().getScaledInstance(195, 152, Image.SCALE_DEFAULT);
		ImageIcon scaledIcon1 = new ImageIcon(image1);
		label_iconTour.setIcon(scaledIcon1);
		panel_6.add(label_iconTour);
		
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
		panel_2.setBounds(10, 70, 547, 211);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Họ và tên");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(10, 0, 97, 26);
		panel_2.add(lblNewLabel_1_1_1);
		
		tfHoTen = new JTextField();
		tfHoTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfHoTen.setBounds(10, 30, 240, 25);
		tfHoTen.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					tfEmail.requestFocusInWindow();
		        }
			}
		});
		panel_2.add(tfHoTen);
		tfHoTen.setColumns(10);
		
		tfSdt = new JTextField();
		tfSdt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfSdt.setColumns(10);
		tfSdt.setBounds(10, 95, 240, 25);
		tfSdt.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					tfDiachi.requestFocusInWindow();
		        }
				
			}
		});
		panel_2.add(tfSdt);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Số điện thoại");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(10, 65, 97, 26);
		panel_2.add(lblNewLabel_1_1_1_1);
		
		tfDiachi = new JTextField();
		tfDiachi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfDiachi.setColumns(10);
		tfDiachi.setBounds(302, 95, 240, 25);
		tfDiachi.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnLuu1.doClick();
		        }
			}
		});
		panel_2.add(tfDiachi);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Email");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_2.setBounds(302, 0, 97, 26);
		panel_2.add(lblNewLabel_1_1_1_2);
		
		tfEmail = new JTextField();
		tfEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfEmail.setColumns(10);
		tfEmail.setBounds(302, 30, 240, 25);
		tfEmail.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					tfSdt.requestFocusInWindow();
		        }
				
			}
		});
		panel_2.add(tfEmail);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Địa chỉ");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1.setBounds(302, 65, 97, 26);
		panel_2.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_3_1 = new JLabel("Giới tính");
		lblNewLabel_1_1_1_3_1.setBounds(10, 130, 70, 26);
		panel_2.add(lblNewLabel_1_1_1_3_1);
		lblNewLabel_1_1_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		String[] arr_gioitinh= {"Nam","Nữ"};
		cbGioitinh = new JComboBox(arr_gioitinh);
		cbGioitinh.setBounds(10, 166, 70, 25);
		panel_2.add(cbGioitinh);
		cbGioitinh.setBackground(new Color(255, 255, 255));
		cbGioitinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_1_1_3_2 = new JLabel("Năm sinh");
		lblNewLabel_1_1_1_3_2.setBounds(103, 129, 97, 26);
		panel_2.add(lblNewLabel_1_1_1_3_2);
		lblNewLabel_1_1_1_3_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		datechooserNgaysinh = new JDateChooser();
		datechooserNgaysinh.setBounds(103, 165, 107, 26);
		panel_2.add(datechooserNgaysinh);
		
		cbMaKM = new JComboBox(GetMaKM(tourduocchon.getMatour()).toArray());
		cbMaKM.setBounds(243, 166, 85, 25);
		cbMaKM.setSelectedItem(GetMaKMLonNhat(GetMaKM(tourduocchon.getMatour())));
		panel_2.add(cbMaKM);
		//		String arr_makm[]= {"km01","km02","km03"};
		//		cbMaKM = new JComboBox(arr_makm);
				
				cbMaKM.setFont(new Font("Tahoma", Font.PLAIN, 14));
				cbMaKM.setBackground(Color.WHITE);
				
				JLabel lblNewLabel_1_1_1_3_5 = new JLabel("Mã giảm giá");
				lblNewLabel_1_1_1_3_5.setBounds(243, 130, 97, 26);
				panel_2.add(lblNewLabel_1_1_1_3_5);
				lblNewLabel_1_1_1_3_5.setFont(new Font("Tahoma", Font.BOLD, 14));
				
				JLabel lblNewLabel_1_1_1_3_5_1 = new JLabel("Phần trăm");
				lblNewLabel_1_1_1_3_5_1.setBounds(363, 130, 84, 26);
				panel_2.add(lblNewLabel_1_1_1_3_5_1);
				lblNewLabel_1_1_1_3_5_1.setFont(new Font("Tahoma", Font.BOLD, 14));
				
				tfPhanTram = new JTextField();
				tfPhanTram.setBounds(367, 166, 70, 25);
				panel_2.add(tfPhanTram);
				tfPhanTram.setFont(new Font("Tahoma", Font.PLAIN, 14));
				tfPhanTram.setEditable(false);
				tfPhanTram.setColumns(10);
				
				btnLuu1 = new JButton("Lưu");
				btnLuu1.setBounds(457, 165, 85, 26);
				
				btnLuu1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
//						arr_TTLienLac=GetThongTinLienLac();
//						init2();
//						tfHoTenTV.setText(arr_TTLienLac[0]);
						if(lbNameKH.getText().equals("....................")) {
							lbNameKH.setText(tfHoTen.getText());
						}
						if(socho>0) {	
							Them();
							XoaDataTable();
							initDataTable();
							Reset();
						}
						else {
							JOptionPane.showMessageDialog(panel, "Tour đã hết chỗ.");
						}
						
					}
				});
				btnLuu1.setForeground(Color.WHITE);
				btnLuu1.setFont(new Font("Tahoma", Font.BOLD, 14));
				btnLuu1.setFocusable(false);
				btnLuu1.setBackground(new Color(255, 128, 64));
				panel_2.add(btnLuu1);
		cbMaKM.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				for(KhuyenMaiDTO km: KhuyenMaiBUS.kmDTO) {
					if(km.getMakm().equals(e.getItem().toString())) {
						tfPhanTram.setText(km.getPhantram()+"");
						break;
					}
				}
			}
		});
		String kmSelected = cbMaKM.getItemAt(0).toString();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 312, 547, 211);
		panel_1.add(scrollPane);
		
		table_ThongTin = new JTable();
		scrollPane.setViewportView(table_ThongTin);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Danh sách khách hàng");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_2.setBounds(10, 285, 234, 26);
		panel_1.add(lblNewLabel_1_1_2);
		
//		String [] arr_gioitinh= {"Nam","Nữ"};
		try {
			for(KhuyenMaiDTO km: KhuyenMaiBUS.kmDTO) {
				if(km.getMakm().equals(kmSelected)){
					tfPhanTram.setText(km.getPhantram()+"");
					break;
				}
			}			
		} catch (Exception e) {
			// TODO: handle exception
			tfPhanTram.setText("");
		}
		
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
		
		JLabel lbl_MAHD = new JLabel(mahd);
		lbl_MAHD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_MAHD.setBounds(172, 28, 187, 23);
		panel_3.add(lbl_MAHD);
		
		JLabel lbl_NgayHD = new JLabel(ngaytaohoadon.toString());
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
		
		taikhoanBUS tkBUS = new taikhoanBUS();
		JLabel lbl_NameNV = new JLabel(tkBUS.getName(TrangChuGUI.tkDTO.getUser()));
		lbl_NameNV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_NameNV.setBounds(172, 72, 187, 23);
		panel_3.add(lbl_NameNV);
		
		lbNameKH = new JLabel("....................");
		lbNameKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbNameKH.setBounds(172, 94, 187, 23);
		panel_3.add(lbNameKH);
		
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
		
		JLabel lbTenTour = new JLabel(tourduocchon.getTentour());
		lbTenTour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbTenTour.setBounds(93, 22, 277, 38);
		panel_4.add(lbTenTour);
		
		JLabel lblBtuChuyn = new JLabel("Bắt đầu chuyến đi:");
		lblBtuChuyn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBtuChuyn.setBounds(177, 78, 131, 23);
		panel_4.add(lblBtuChuyn);
		
		JLabel lblKtThcChuyn = new JLabel("Kết thúc chuyến đi:");
		lblKtThcChuyn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKtThcChuyn.setBounds(177, 130, 156, 23);
		panel_4.add(lblKtThcChuyn);
		
		JLabel lbNgayBatDau = new JLabel(tourduocchon.getNgaydi().toString());
		lbNgayBatDau.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbNgayBatDau.setBounds(177, 97, 177, 23);
		panel_4.add(lbNgayBatDau);
		
		JLabel lbNgayKetThuc = new JLabel(tourduocchon.getNgayve().toString());
		lbNgayKetThuc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbNgayKetThuc.setBounds(177, 153, 177, 23);
		panel_4.add(lbNgayKetThuc);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(0, 128, 64));
		panel_7.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_7.setBounds(0, 60, 167, 116);
		panel_4.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setBounds(10, 5, 147, 101);
		label_1.setBackground(new Color(0, 128, 255));
		ImageIcon img2=new ImageIcon(tourduocchon.getHinh2().replace('#', '\\'));
		Image image2 = img2.getImage().getScaledInstance(145, 100, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon2 = new ImageIcon(image2);
        label_1.setIcon(scaledIcon2);
		panel_7.add(label_1);
		
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
		
		lbSLHanhKhach = new JLabel("0");
		lbSLHanhKhach.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbSLHanhKhach.setBounds(246, 10, 113, 23);
		panel_5.add(lbSLHanhKhach);
		
		lbNguoiLon = new JLabel("0x0đ");
		lbNguoiLon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbNguoiLon.setBorder(null);
		lbNguoiLon.setBounds(246, 40, 113, 23);
		panel_5.add(lbNguoiLon);
		
		lbTreEm = new JLabel("0x0đ");
		lbTreEm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbTreEm.setBounds(246, 70, 113, 23);
		panel_5.add(lbTreEm);
		
		lbTongCong = new JLabel("0đ");
		lbTongCong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbTongCong.setBounds(246, 130, 113, 23);
		panel_5.add(lbTongCong);
		
		JButton btnThanhToan = new JButton("Thanh toán");
		btnThanhToan.setForeground(Color.WHITE);
		btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThanhToan.setFocusable(false);
		btnThanhToan.setBackground(new Color(255, 128, 64));
		btnThanhToan.setBounds(63, 173, 119, 26);
		btnThanhToan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				veBUS.themKH();
				ThemHD();
				veBUS.themVe();
				veBUS.UpdateSoCho(MaKHT1, socho);
				XuatPDF pdf=new XuatPDF(hd, veBUS.GetListVe());
				try {
		            // Specify the path to your PDF file
		            File pdfFile = new File("src/PdfFiles/"+hd.getMahd()+".pdf");

		            // Check if the PDF file exists
		            if (pdfFile.exists()) {
		                // Open the PDF file using the default PDF viewer
		                Desktop.getDesktop().open(pdfFile);
		            } else {
		                System.out.println("PDF file not found.");
		            }
		        } catch (IOException e1) {
		            System.out.println("Error opening PDF file: " + e1.getMessage());
		        }
				veBUS.GetListKH().clear();
				veBUS.GetListVe().clear();
			}
		});
		panel_5.add(btnThanhToan);
		
		JLabel lblGimGi = new JLabel("Giảm giá:");
		lblGimGi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGimGi.setBounds(10, 100, 119, 23);
		panel_5.add(lblGimGi);
		
		lbGiamGia = new JLabel("0đ");
		lbGiamGia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbGiamGia.setBounds(246, 100, 113, 23);
		panel_5.add(lbGiamGia);
		
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
		init();
		
		String [] item_gender = {"Nam","Nữ"};
		this.setVisible(true);
	}
	
	public int GetSoNgay(String matour) {
		for(QlyToursDTO tour:QlyToursBUS.tourDTO) {
			if(tour.getMatour().equals(matour)) {
				return tour.getSongay();
			}
		}
		return -1;
	}
	
	public String GetHuongDanVien(String makht) {
		for(KHTourDTO kht:KHToursBUS.khtList) {
			if(kht.getMakht().equals(makht)) {
				return kht.getHuongdanvien();
			}
		}
		return null;
	}
	
	public String TaoMaHD() {
		int max=1000,min=0;
		int randNum=(int) ((Math.random() * (max - min)) + min);
		Random random = new Random();
        StringBuilder randomLetters = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            char randomChar = (char) (random.nextInt(26) + 'a');
            randomLetters.append(randomChar);
        }
		return "HD"+randomLetters.toString()+randNum;
	}
	
	public String TaoMaKH() {
		int max=10000,min=0;
		int randNum=(int) ((Math.random() * (max - min)) + min);
		Random random = new Random();
        StringBuilder randomLetters = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            char randomChar = (char) (random.nextInt(26) + 'a');
            randomLetters.append(randomChar);
        }
		return "KH"+randomLetters.toString()+randNum;
	}
	
	public String TaoMaVe() {
		int max=10000,min=0;
		int randNum=(int) ((Math.random() * (max - min)) + min);
		Random random = new Random();
        StringBuilder randomLetters = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            char randomChar = (char) (random.nextInt(26) + 'a');
            randomLetters.append(randomChar);
        }
		return "VE"+randomLetters.toString()+randNum;
	}
	
	
	public ArrayList<String> GetMaKM(String matour) {
		veBUS.docCTKM();
		ArrayList<String> dsMaKM=new ArrayList<String>();
		for(CTKM_DTO ctkm:QlyVeBUS.ctkmList) {
			if(ctkm.getMatour().equals(matour)&&veBUS.checkTinhTrangKM(ctkm.getMakm())) {
				dsMaKM.add(ctkm.getMakm());
			}
		}
		return dsMaKM;
	}
	
	public String GetMaKMLonNhat(ArrayList<String> listMaKM) {
		int max=0;
		String makmMax="";
		for(String e:listMaKM) {
			if(GetPTGiamGia(e)>max) {
				max=(int) GetPTGiamGia(e);
				makmMax=e;
			}
		}
		return makmMax;
	}
	
	
	
//	public String[] GetThongTinLienLac() {
//		String hoten=tfHoTen.getText();
//		String email=tfEmail.getText();
//		String sdt=tfSdt.getText();
//		String diachi=tfDiachi.getText();
//		String [] arr_TTLienLac1= {hoten,email,sdt,diachi};
//		return arr_TTLienLac1;
//	}
	
	public void init() {
		tfPhanTram.setText(GetPTGiamGia(cbMaKM.getSelectedItem().toString())+"");
//		cbGioitinh.setEnabled(false);
//		datechooserNgaysinh.setEnabled(false);
//		cbMaKM.setEnabled(false);
	}
	
	public void init2() {
//		tfHoTen.setEnabled(false);
//		tfEmail.setEnabled(false);
//		tfSdt.setEnabled(false);
//		tfDiachi.setEnabled(false);
//		btnLuu1.setEnabled(false);
	}
	
	public void noneInit() {
//		tfHoTenTV.setEditable(true);
//		cbGioitinh.setEnabled(true);
//		datechooserNgaysinh.setEnabled(true);
//		cbMaKM.setEnabled(true);
//		btnLuu2.setEnabled(true);
//		btnLuu2.setBackground(Color.orange);
	}
	
	public void initDataTable() {
		String[] colNames = { "STT", "Họ và tên", "Giới tính", "Năm sinh", "Độ tuổi", "Số điện thoại" };
		DefaultTableModel tableModel=new DefaultTableModel() {
			 public boolean isCellEditable(int row,int col) {
	                return false;
	         }
		};
		table_ThongTin.setModel(tableModel);
		tableModel.setColumnIdentifiers(colNames);
		table_ThongTin.getColumnModel().getColumn(0).setPreferredWidth(23);
		table_ThongTin.getColumnModel().getColumn(1).setPreferredWidth(103);
		table_ThongTin.getColumnModel().getColumn(2).setPreferredWidth(57);
		table_ThongTin.getColumnModel().getColumn(3).setPreferredWidth(82);
		table_ThongTin.getColumnModel().getColumn(4).setPreferredWidth(58);
		table_ThongTin.getColumnModel().getColumn(5).setPreferredWidth(99);
		table_ThongTin.addMouseListener((MouseListener) new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
//					HienThiTTKhachHang();
				}
			}
		});
		int i=1;
		for (KhachHangDTO kh : veBUS.GetListKH()) {
			String loaikhachhang="Người lớn";
	        if(calculateAge(kh.getNgaysinh())<=12) {
	        	loaikhachhang="Trẻ em";
	        }
	        String gioitinh="Nam";
	        if(kh.isGioitinh()==false) {
	        	gioitinh="Nữ";
	        }
			tableModel.addRow(new Object[] { i, kh.getHokh()+" "+kh.getTenkh(), gioitinh + "",
					kh.getNgaysinh().toString(),loaikhachhang,kh.getSdt(),
			});
			i++;
		}
	}
	
	public void Them() {
		//==================Them Khách hàng=================
//		String [] ttLienLac=arr_TTLienLac;
		String makh=TaoMaKH();
		String tenkh_tmp=tfHoTen.getText();
		String[] parts = tenkh_tmp.split(" ");
		String tenkh=parts[parts.length-1];
		String hokh="";
		for(int i=0;i<parts.length-1;i++) {
			hokh=hokh+" "+parts[i];
		}
		hokh=hokh.trim();
		
		String sdt=tfSdt.getText();
		String email=tfEmail.getText();
		boolean gioitinh=true;
		if(cbGioitinh.getSelectedItem().toString().equals("Nữ")) {
			gioitinh=false;
		}
		String diachi=tfDiachi.getText();
		java.util.Date ngaysinh_tmp=(java.util.Date) datechooserNgaysinh.getDate();
        java.sql.Date ngaysinh=new java.sql.Date(ngaysinh_tmp.getTime());
        
        if(calculateAge(ngaysinh)<18 && veBUS.GetListKH().contains(null)) {
        	JOptionPane.showMessageDialog(this, "Người đại diện chưa đủ tuổi.");
        	return;
        }else {	
        	KhachHangDTO kh=new KhachHangDTO(makh, hokh, tenkh, diachi, sdt, email, gioitinh,ngaysinh);
        	veBUS.ThemTTKhachHang(kh);
        }
        
        
        //==================Thêm Vé==================
        String mave=TaoMaVe();
        String makm=cbMaKM.getSelectedItem().toString();
        int ptgg=(int) GetPTGiamGia(makm);
        if(checkTreEm(makh)) {
        	VeDTO ve=new VeDTO(mave, MaKHT1, mahd, makm, makh, giave*70/100,(100-ptgg)*(giave*70/100)/100);
            veBUS.ThemTTVe(ve); 
        }
        else {
        	VeDTO ve=new VeDTO(mave, MaKHT1, mahd, makm, makh, giave,giave*(100-ptgg)/100);
        	veBUS.ThemTTVe(ve);    
        }
        
        socho=socho-1;
        lbSlot.setText(socho+"");
        UpdateTTVe();
	}
	
	public void XoaDataTable() {
		DefaultTableModel model_table = (DefaultTableModel) table_ThongTin.getModel();
		model_table.setRowCount(0);
	}
	
	public void Reset() {
		tfHoTen.setText("");
		tfEmail.setText("");
		tfSdt.setText("");
		tfDiachi.setText("");
		cbGioitinh.setSelectedIndex(0);
		datechooserNgaysinh.setDate(null);
	}
	
	public void UpdateTTVe() {
		int soluongnguoilon=0;
		int soluongtreem=0;
		double giamgia=0;
		for(VeDTO ve1:veBUS.GetListVe()) {
			if(checkTreEm(ve1.getMakh())) {
				soluongtreem++;
				giamgia=giamgia+(giave*70/100)*GetPTGiamGia(ve1.getMakm())/100;
			}
			else {
				soluongnguoilon++;
				giamgia=giamgia+giave*GetPTGiamGia(ve1.getMakm())/100;
			}
		}
		tongcong=soluongnguoilon*giave+soluongtreem*(giave*70/100)-giamgia;
		tongcong_truocgg=soluongnguoilon*giave+soluongtreem*(giave*70/100);
		lbSLHanhKhach.setText((soluongnguoilon+soluongtreem)+"");
		lbNguoiLon.setText(soluongnguoilon+"x"+giave+"đ");
		lbTreEm.setText(soluongtreem+"x"+giave*70/100+"đ");
		lbGiamGia.setText(giamgia+"đ");
		lbTongCong.setText(tongcong+"đ");
		
		
		
	}
	
	public boolean checkTreEm(String makh) {
		for(KhachHangDTO kh:veBUS.GetListKH()) {
			if(kh.getMakh().equals(makh)) {
		        if(calculateAge(kh.getNgaysinh())<=12) {
		        	return true;
		        }
			}
		}
		return false;
	}
	
	public double GetPTGiamGia(String makm) {
		for(KhuyenMaiDTO km:KhuyenMaiBUS.kmDTO) {
			if(km.getMakm().equals(makm)) {
				return km.getPhantram();
			}
		}
		return 0;
	}
	
	public int calculateAge(Date birthDate) {
        LocalDate currentDate = LocalDate.now();
        LocalDate birthLocalDate = birthDate.toLocalDate();
        // Tính toán sự khác biệt giữa hai ngày
        Period period = Period.between(birthLocalDate, currentDate);
        int age = period.getYears();
        // Kiểm tra nếu ngày sinh lớn hơn ngày hiện tại
        // Trong trường hợp này, trả về tuổi -1
        if (birthLocalDate.plusYears(age).isAfter(currentDate)) {
            age--;
        }
        return age;
	}
	
	public void ThemHD() {
		String manv=TrangChuGUI.tkDTO.getUser();
		String makh=veBUS.GetListKH().get(0).getMakh();
		hd=new HoaDonDTO(mahd,manv,makh,ngaytaohoadon,tongcong,tongcong_truocgg);
		if (hdBUS.them(hd) == -1) {
			JOptionPane.showMessageDialog(this, "Lỗi!");
		} else {
			JOptionPane.showMessageDialog(this, "Thêm thành công!");
		}
	}
}