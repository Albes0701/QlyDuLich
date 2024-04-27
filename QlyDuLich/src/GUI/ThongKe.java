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

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;
import com.toedter.calendar.JDateChooser;

import BUS.taikhoanBUS;

import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ThongKe extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JTable table_1;
	JButton btn_TrangChu,btn_DatTour,btn_HoaDon,btn_ThongKe;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKe frame = new ThongKe();
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
	public ThongKe() {
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
			@Override
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
		btn_HoaDon.setBounds(463, 65, 120, 40);
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
		btn_QlyThongtin.setBounds(789, 65, 120, 40);
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
		btn_ThongKe.setBounds(621, 65, 120, 40);
		panel.add(btn_ThongKe);
		
		taikhoanBUS tkBUS = new taikhoanBUS();
		
//		Label label = new Label("New label");
//		label.setIgnoreRepaint(true);
//		label.setBackground(new Color(0, 128, 128));
//		label.setBounds(21, 24, 90, 79);
//		panel.add(label);
//		
		
		
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
		btn_DatTour.setBounds(303, 65, 120, 40);
		panel.add(btn_DatTour);
		
		Panel ThongKe = new Panel();
		ThongKe.setBounds(13, 127, 960, 495);
		panel.add(ThongKe);
		ThongKe.setLayout(null);
		ThongKe.setBackground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_2 = new JLabel("Từ Ngày:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(205, 48, 81, 26);
		ThongKe.add(lblNewLabel_2);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		dateChooser.setBounds(275, 48, 128, 26);
		ThongKe.add(dateChooser);
		
		JLabel lblNewLabel_2_1 = new JLabel("Đến Ngày:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(448, 48, 81, 26);
		ThongKe.add(lblNewLabel_2_1);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		dateChooser_1.setBounds(520, 48, 128, 26);
		ThongKe.add(dateChooser_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 940, 28);
		ThongKe.add(panel_1);
		panel_1.setLayout(null);
		
		
		JLabel lblNewLabel_1 = new JLabel("Quản Lý Thống Kê Giao Dịch");
		lblNewLabel_1.setBounds(346, 0, 262, 26);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		ButtonGroup group1 = new ButtonGroup();
		
		JRadioButton RadioButton_Quy1 = new JRadioButton("QUÝ 1");
		RadioButton_Quy1.setFont(new Font("Tahoma", Font.BOLD, 14));
		RadioButton_Quy1.setBounds(104, 93, 81, 21);
		ThongKe.add(RadioButton_Quy1);
		
		JRadioButton RadioButton_Quy2 = new JRadioButton("QUÝ 2");
		RadioButton_Quy2.setFont(new Font("Tahoma", Font.BOLD, 14));
		RadioButton_Quy2.setBounds(322, 93, 81, 21);
		ThongKe.add(RadioButton_Quy2);
		
		JRadioButton RadioButton_Quy3 = new JRadioButton("QUÝ 3");
		RadioButton_Quy3.setFont(new Font("Tahoma", Font.BOLD, 14));
		RadioButton_Quy3.setBounds(533, 93, 82, 21);
		ThongKe.add(RadioButton_Quy3);
		
		JRadioButton RadioButton_Quy4 = new JRadioButton("QUÝ 4");
		RadioButton_Quy4.setFont(new Font("Tahoma", Font.BOLD, 14));
		RadioButton_Quy4.setBounds(750, 93, 81, 21);
		ThongKe.add(RadioButton_Quy4);
		
		group1.add(RadioButton_Quy1);
		group1.add(RadioButton_Quy2);
		group1.add(RadioButton_Quy3);
		group1.add(RadioButton_Quy4);
		
		
		
		//Xử lý RadioButton
		ActionListener radioListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JRadioButton selectedRadioButton = (JRadioButton) e.getSource();
//				System.out.println("Selected: " + selectedRadioButton.getText());
				
			}
		};
		
		
		
		
		
		JLabel lblNewLabel_2_2 = new JLabel("Lượt khách:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_2.setBounds(336, 116, 81, 26);
		ThongKe.add(lblNewLabel_2_2);
		
		textField = new JTextField();
		textField.setBounds(415, 120, 68, 21);
		ThongKe.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Tổng chi:");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_2_1.setBounds(489, 116, 68, 26);
		ThongKe.add(lblNewLabel_2_2_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(547, 120, 68, 21);
		ThongKe.add(textField_1);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Doanh Thu:");
		lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_2_1_1.setBounds(625, 116, 81, 26);
		ThongKe.add(lblNewLabel_2_2_1_1);
		
		JLabel lblNewLabel_2_2_1_2 = new JLabel("Lợi Nhuận:");
		lblNewLabel_2_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_2_1_2.setBounds(774, 116, 81, 26);
		ThongKe.add(lblNewLabel_2_2_1_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(699, 121, 68, 19);
		ThongKe.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(854, 121, 68, 19);
		ThongKe.add(textField_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 255, 255));
		panel_2.setBounds(13, 151, 309, 43);
		ThongKe.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Thống Kê Nhân Viên");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(85, 0, 138, 41);
		panel_2.add(lblNewLabel_3);
		lblNewLabel_3.setBackground(Color.WHITE);
		
		
		
		// Tạo JScrollPane cho Nhân viên
        JScrollPane employeeScrollPane = new JScrollPane();
        employeeScrollPane.setBorder(BorderFactory.createLineBorder(new Color(130, 135, 144), 2, true));
        employeeScrollPane.setBounds(13, 204, 309, 235);
        ThongKe.add(employeeScrollPane);
        
        JTable employeeTable = new JTable();
        employeeTable.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                },
                new String[]{
                        "Mã Nhân Viên", "Tổng Thu"
                }
        ));
        employeeScrollPane.setViewportView(employeeTable);
		
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(130, 135, 144), 2, true));
		scrollPane.setBounds(13, 204, 309, 235);
		ThongKe.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Mã Khách Hàng", "Tổng Chi"
			}
		) 
				
		{
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setVisible(false);
		
		 
		
		
		scrollPane.setViewportView(table);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(0, 255, 255));
		panel_2_1.setBounds(332, 152, 622, 43);
		ThongKe.add(panel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Thống Kê Chi Phí");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_1.setBackground(Color.WHITE);
		lblNewLabel_3_1.setBounds(266, 0, 125, 41);
		panel_2_1.add(lblNewLabel_3_1);
		
		JButton btnXutFile = new JButton("Xuất File");
		btnXutFile.setForeground(new Color(255, 255, 255));
		btnXutFile.setBackground(new Color(0, 255, 64));
		btnXutFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXutFile.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnXutFile.setBounds(738, 450, 85, 26);
		ThongKe.add(btnXutFile);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setForeground(new Color(255, 255, 255));
		btnReset.setBackground(new Color(255, 0, 0));
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReset.setBounds(833, 450, 85, 26);
		ThongKe.add(btnReset);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(332, 205, 622, 235);
		ThongKe.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"M\u00E3 Tour", "T\u1ED5ng Chi", "Doanh Thu", "L\u1EE3i Nhu\u1EADn"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_1.setViewportView(table_1);
		
		String[] options = {"Nhân viên", "Khách hàng"};
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setBounds(10, 120, 312, 21);
        ThongKe.add(comboBox);
		
          //Sử lý sự kiện combobox
        comboBox.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedOption = (String) comboBox.getSelectedItem();
				if(selectedOption.equals("Nhân viên")){
					lblNewLabel_3.setText("Thống Kê Nhân viên");
					employeeScrollPane.setVisible(true);
					scrollPane.setVisible(false);
				} else if(selectedOption.equals("Khách hàng")) {
					lblNewLabel_3.setText("Thống Kê Khách hàng");
					employeeScrollPane.setVisible(false);
					scrollPane.setVisible(true);
				}
							
			}
        	
        });
        
        
        
		
		JButton btnNewButton = new JButton("Thống Kê");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 128, 64));
		btnNewButton.setBounds(636, 450, 92, 26);
		ThongKe.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		
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
		
		this.setVisible(true);
		
	}
}
