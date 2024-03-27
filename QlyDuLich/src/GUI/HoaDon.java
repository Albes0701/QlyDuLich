package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BUS.taikhoanBUS;

import javax.swing.border.LineBorder;

public class HoaDon extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	JButton btn_TrangChu,btn_DatTour,btn_HoaDon,btn_ThongKe;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HoaDon frame = new HoaDon();
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
	public HoaDon() {
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
				TrangChuGUI tc = new TrangChuGUI();
				tc.btn_TrangChu.setBackground(Color.ORANGE);
				tc.btn_TrangChu.setForeground(Color.BLACK);
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
				HoaDon hd = new HoaDon();
				hd.btn_HoaDon.setBackground(Color.ORANGE);
				hd.btn_HoaDon.setForeground(Color.BLACK);
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
				QuanLyTour qlt = new QuanLyTour();
				qlt.btn_QLTour.setBackground(Color.ORANGE);
				qlt.btn_QLTour.setForeground(Color.BLACK);
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
				ThongKe tk = new ThongKe();
				tk.btn_ThongKe.setBackground(Color.ORANGE);
				tk.btn_ThongKe.setForeground(Color.BLACK);
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
		JLabel lblNewLabel = new JLabel("Xin chào " + tkBUS.getName(TrangChuGUI.tkDTO.getUser()));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(743, 24, 230, 30);
		panel.add(lblNewLabel);
		
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
				TrangChuGUI tc = new TrangChuGUI();
				tc.btn_TrangChu.setBackground(Color.ORANGE);
				tc.btn_TrangChu.setForeground(Color.BLACK);
			}
		});
		panel.add(label);
		
	
		
		this.getContentPane().add(panel);
		
		btn_DatTour = new JButton("Đặt Tour");
		btn_DatTour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				DatTourGUI dt = new DatTourGUI();
				dt.btn_DatTour.setBackground(Color.ORANGE);
				dt.btn_DatTour.setForeground(Color.BLACK);
			}
		});
		btn_DatTour.setForeground(Color.WHITE);
		btn_DatTour.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_DatTour.setFocusable(false);
		btn_DatTour.setBorderPainted(false);
		btn_DatTour.setBorder(null);
		btn_DatTour.setBackground(new Color(24, 171, 138));
		btn_DatTour.setBounds(317, 65, 120, 40);
		panel.add(btn_DatTour);
		
		Panel HoaDon = new Panel();
		HoaDon.setBounds(13, 127, 960, 495);
		panel.add(HoaDon);
		HoaDon.setLayout(null);
		HoaDon.setBackground(new Color(255, 255, 255));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(130, 135, 144), 3, true));
		scrollPane.setBounds(10, 55, 940, 393);
		HoaDon.add(scrollPane);
//		scrollPane.setVisible(false);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
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
				"M\u00E3 H\u0110", "Nh\u00E2n Vi\u00EAn", "T\u00EAn KH", "Ng\u00E0y L\u1EADp H\u0110", " Th\u00E0nh ti\u1EC1n", "T\u00EAn Tour", "Gi\u00E1 Tour"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(41);
		table.getColumnModel().getColumn(1).setPreferredWidth(101);
		table.getColumnModel().getColumn(2).setPreferredWidth(109);
		table.getColumnModel().getColumn(3).setPreferredWidth(51);
		table.getColumnModel().getColumn(4).setPreferredWidth(54);
		table.getColumnModel().getColumn(5).setPreferredWidth(225);
		table.getColumnModel().getColumn(6).setPreferredWidth(51);
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 940, 35);
		HoaDon.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Quản Lý Hóa Đơn");
		lblNewLabel_1.setBounds(373, 10, 162, 22);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JButton btnNewButton = new JButton("Xem chi tiết");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChiTietHoaDon();
			}
		});
		btnNewButton.setBackground(new Color(24, 171, 138));
		btnNewButton.setBounds(836, 458, 114, 21);
		HoaDon.add(btnNewButton);
		
		this.setVisible(true);
	}
}
