package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import BUS.CTKHT_ThucChiBUS;
import BUS.CTKhuyenMaiBUS;
import BUS.CTQuyenBUS;
import BUS.ChiTietKHT_BUS;
import BUS.DatTourBUS;
import BUS.DichVuBUS;
import BUS.HoaDonBUS;
import BUS.KHToursBUS;
import BUS.KhachHangBUS;
import BUS.KhuyenMaiBUS;
import BUS.NhanVienBUS;
import BUS.QlyToursBUS;
import BUS.QuyenBUS;
import BUS.chitiethoadonBUS;
import BUS.taikhoanBUS;
import DTO.KhachHangDTO;
import DTO.chitiethoadonDTO;
import DTO.taikhoanDTO;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.reflect.Method;
import java.text.Normalizer.Form;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;

public class DangNhapGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_User;
	private JTextField textField_Password;
	private taikhoanBUS tkBUS = new taikhoanBUS();
	private taikhoanDTO tkDTO;
	static ArrayList<String> chucnangList;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhapGUI frame = new DangNhapGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DangNhapGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 344, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(51, 204, 204));
		panel.setBackground(new Color(51, 204, 204));
		panel.setBounds(0, 0, 330, 291);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("User");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(45, 74, 45, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("TRAVEL");
		lblNewLabel_2.setForeground(new Color(51, 0, 0));
		lblNewLabel_2.setFont(new Font("Eras Bold ITC", Font.BOLD, 28));
		lblNewLabel_2.setBounds(104, 22, 123, 42);
		panel.add(lblNewLabel_2);
		
		textField_User = new JTextField();
		textField_User.addKeyListener(new KeyAdapter() {
			@Override
		    public void keyPressed(KeyEvent e) {
		        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		            textField_Password.requestFocusInWindow();
		        }
		    }
		});
		textField_User.setBounds(45, 97, 236, 27);
		panel.add(textField_User);
		textField_User.setColumns(10);
		
		textField_Password = new JPasswordField();
		textField_Password.setColumns(10);
		textField_Password.setBounds(45, 167, 236, 27);
		textField_Password.addKeyListener(new KeyAdapter() {
			@Override
		    public void keyPressed(KeyEvent e) {
		        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		        	String user = textField_User.getText();
					String pass = textField_Password.getText();
					checktk(user,pass);
		        }
		    }
		});
		panel.add(textField_Password);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(45, 144, 77, 13);
		panel.add(lblNewLabel_1_1);
		
		JButton dangnhap_btn = new JButton("SIGN IN");
		dangnhap_btn.setFocusPainted(false);
		dangnhap_btn.setBackground(new Color(255, 0, 128));
		dangnhap_btn.setForeground(new Color(255, 255, 255));
		dangnhap_btn.setFont(new Font("Tahoma", Font.BOLD, 16));
		dangnhap_btn.setBounds(104, 233, 135, 33);
		dangnhap_btn.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String user = textField_User.getText();
				String pass = textField_Password.getText();
				
				checktk(user,pass);
			}
		});
		panel.add(dangnhap_btn);
//		tkBUS.docTK();
		setVisible(true);
	}
	

	public void checktk(String user, String pass) {
			tkDTO = tkBUS.checkTaiKhoan(user, pass);
//			for(taikhoanDTO tk: taikhoanBUS.tkDTO) {
				if(tkDTO!=null) {
					JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
					QuyenBUS quyenBUS = new QuyenBUS();
					quyenBUS.docDSQuyen();
					setVisible(false);
					TrangChuGUI.tkDTO.setUser(user);
					TrangChuGUI.tkDTO.setPass(pass);
					FormShare.tc.btn_TrangChu.setBackground(Color.ORANGE);
					FormShare.tc.btn_TrangChu.setForeground(Color.BLACK);
					FormShare.tc.setVisible(true);
					phanQuyen();
					FormShare.tc.initData();
					return;
				}
				else {
				JOptionPane.showMessageDialog(null, "Không tồn tại tài khoản");
				return;
			}
		}
	
	
	public void phanQuyen() {
		// chuc nang 6 "them hoa don" xu li va chuc nang 37 "them nhan vien" xu ly rieng o Ve
		//FormShare.nv.them_btn.setEnabled(false);
		FormShare.dt.btn_ChonTour.setName("cn2");
		//quan ly tour
		FormShare.qlt.them_btn.setName("cn11");
		FormShare.qlt.sua_btn.setName("cn12");
		FormShare.qlt.xoa_btn.setName("cn13");
		//ke hoach tour
		FormShare.kht.ctkehoachtour_btn.setName("cn15");
		FormShare.kht.btnThem.setName("cn15");
		FormShare.kht.btnSua.setName("cn16");
		FormShare.kht.btnXoa.setName("cn17");

		//dich vu
		FormShare.dv.them_btn.setName("cn22");
		FormShare.dv.sua_btn.setName("cn23");
		FormShare.dv.xoa_btn.setName("cn24");
		//khuyen mai
		FormShare.km.them_btn.setName("cn26");
		FormShare.km.sua_btn.setName("cn27");
		FormShare.km.xoa_btn.setName("cn28");
		//chi tiet khuyen mai
		FormShare.ctkm.them_btn.setName("cn30");
		FormShare.ctkm.xoa_btn.setName("cn31");
		//nhanvien
		FormShare.nv.them_btn.setName("cn33");
		FormShare.nv.sua_btn.setName("cn34");
		FormShare.nv.xoa_btn.setName("cn35");
		FormShare.taikhoan.btn_import.setName("q1");
		//khach hang
		FormShare.kh.sua_btn.setName("cn38");
		FormShare.kh.xoa_btn.setName("cn39");
		
		//quan ly tai khoan
		FormShare.taikhoan.them_btn.setName("cn19");
		FormShare.taikhoan.sua_btn.setName("cn20");
		FormShare.taikhoan.xoa_btn.setName("cn40");
		
	  ArrayList<JButton> buttonList = new ArrayList<>();

        // Thêm các JButton vào ArrayList
        buttonList.add(FormShare.dt.btn_ChonTour);
        
        // Quản lý tour
        buttonList.add(FormShare.qlt.them_btn);
        buttonList.add(FormShare.qlt.sua_btn);
        buttonList.add(FormShare.qlt.xoa_btn);
        
        // Kế hoạch tour
        buttonList.add(FormShare.kht.ctkehoachtour_btn);
        buttonList.add(FormShare.kht.btnThem);
        buttonList.add(FormShare.kht.btnSua);
        buttonList.add(FormShare.kht.btnXoa);
        
        // Dịch vụ
        buttonList.add(FormShare.dv.them_btn);
        buttonList.add(FormShare.dv.sua_btn);
        buttonList.add(FormShare.dv.xoa_btn);
        
        // Khuyến mãi
        buttonList.add(FormShare.km.them_btn);
        buttonList.add(FormShare.km.sua_btn);
        buttonList.add(FormShare.km.xoa_btn);
        
        // Chi tiết khuyến mãi
        buttonList.add(FormShare.ctkm.them_btn);
        buttonList.add(FormShare.ctkm.xoa_btn);
        
        // Nhân viên
        buttonList.add(FormShare.nv.them_btn);
        buttonList.add(FormShare.nv.sua_btn);
        buttonList.add(FormShare.nv.xoa_btn);
        buttonList.add(FormShare.taikhoan.btn_import);
        // Khách hàng
        buttonList.add(FormShare.kh.sua_btn);
        buttonList.add(FormShare.kh.xoa_btn);
        //quan ly tai khoan
        buttonList.add(FormShare.taikhoan.them_btn);
        buttonList.add(FormShare.taikhoan.sua_btn);
        buttonList.add(FormShare.taikhoan.xoa_btn);
        for (JButton button : buttonList) {
        		button.setVisible(false);
        }
		
        CTQuyenBUS ctBUS = new CTQuyenBUS();
        chucnangList = ctBUS.selectChucNang(tkDTO.getQuyen());
        if(tkDTO.getQuyen().equals("q1"))FormShare.taikhoan.btn_import.setVisible(true);
        
        // cac chuc nang them, sua, xoa
        for (JButton button : buttonList) {
        	for(String t: chucnangList) {
        		if(button.getName().equals(t)) {
        			button.setVisible(true);
        		}
        	}
        }
        
        // chuc nang xem
        for(String t: chucnangList) {
    		switch (t) {
			case "cn1": {
				//dattour
				QlyToursBUS tourBUS = new QlyToursBUS();
				tourBUS.docTour();
				KHToursBUS khtour = new KHToursBUS();
				khtour.docKHT();
				DatTourBUS dat_tour = new DatTourBUS();
				FormShare.dt.initData();
				break;
			}
			case "cn5": {
				//hoadon
				HoaDonBUS hdBUS = new HoaDonBUS();
				hdBUS.docHoaDon();
				FormShare.hd.initData();
				break;
			}
			case "cn9": {
				//thong ke
				FormShare.tk.initData();
				break;
			}
			case "cn10": {
				//quan ly tour
				QlyToursBUS tourBUS = new QlyToursBUS();
				tourBUS.docTour();
				FormShare.qlt.initData();
				break;
			}
			case "cn14": {
				//ke hoach tour
				KHToursBUS khtour = new KHToursBUS();
				khtour.docKHT();
				ChiTietKHT_BUS ctkh_tour = new ChiTietKHT_BUS();
				ctkh_tour.docCTKHT();
				CTKHT_ThucChiBUS ctkht_thucchi=new CTKHT_ThucChiBUS();
				ctkht_thucchi.docfile();
				FormShare.kht.initData();
				break;
			}
			case "cn18": {
				//quan ly tai khoan
//				taikhoanBUS tkBUS = new taikhoanBUS();
				tkBUS.docTK();
				FormShare.taikhoan.initArrayList();
				break;
			}
			case "cn21": {
				//dich vu
				DichVuBUS dv = new DichVuBUS();
				dv.docKS();
				dv.docNH();
				dv.docPT();
				FormShare.dv.initArrayList();
				break;
			}
			case "cn25": {
				//khuyen mai
				KhuyenMaiBUS kmBUS = new KhuyenMaiBUS();
				kmBUS.docKM();
				FormShare.km.initArrayList();
				break;
			}
			case "cn29": {
				//chi tiet khuyen mai
				CTKhuyenMaiBUS ctkm = new CTKhuyenMaiBUS();
				ctkm.docCTKM();
				FormShare.ctkm.initArrayList();
				break;
			}
			case "cn32": {
				//nhan vien
				NhanVienBUS nvBUS = new NhanVienBUS();
				nvBUS.docNV();
				FormShare.nv.initArrayList();
				break;
			}
			case "cn36": {
				//khach hang
				KhachHangBUS khBUS = new KhachHangBUS();
				khBUS.docKH();
				FormShare.kh.initArrayList();
				break;
			}
			default:
				break;
			}
    	}
	}
	
}
