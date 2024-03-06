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

import com.toedter.calendar.JDateChooser;

import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class QlyToursGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QlyToursGUI frame = new QlyToursGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QlyToursGUI() {
		this.setType(Type.UTILITY);
		this.setBackground(SystemColor.windowText);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 864);

		contentPane = new JPanel();
		contentPane.setVerifyInputWhenFocusTarget(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(255, 132, 132));
		panel.setBounds(0, -19, 883, 799);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton tourbtn1 = new JButton("Quản lý Tours");
		tourbtn1.setBorderPainted(false);
		tourbtn1.setFocusable(false);
		tourbtn1.setBorder(null);
		tourbtn1.setBackground(new Color(0, 0, 153));
		tourbtn1.setForeground(new Color(255, 255, 255));
		tourbtn1.setFont(new Font("Tahoma", Font.BOLD, 13));
		tourbtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		tourbtn1.setBounds(109, 64, 140, 40);
		panel.add(tourbtn1);
		
		JButton DVbtn2 = new JButton("Quản lý dịch vụ");
		DVbtn2.setFocusable(false);
		DVbtn2.setBorder(null);
		DVbtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		DVbtn2.setForeground(new Color(255, 255, 255));
		DVbtn2.setBackground(new Color(0, 0, 153));
		DVbtn2.setFont(new Font("Tahoma", Font.BOLD, 13));
		DVbtn2.setBounds(259, 64, 140, 40);
		panel.add(DVbtn2);
		
		JButton khbtn5 = new JButton("Khách hàng");
		khbtn5.setFocusable(false);
		khbtn5.setBorder(null);
		khbtn5.setForeground(new Color(255, 255, 255));
		khbtn5.setBackground(new Color(0, 0, 153));
		khbtn5.setFont(new Font("Tahoma", Font.BOLD, 13));
		khbtn5.setBounds(709, 64, 155, 40);
		panel.add(khbtn5);
		
		JButton nvbtn4 = new JButton("Nhân viên");
		nvbtn4.setFocusable(false);
		nvbtn4.setBorder(null);
		nvbtn4.setForeground(new Color(255, 255, 255));
		nvbtn4.setBackground(new Color(0, 0, 153));
		nvbtn4.setFont(new Font("Tahoma", Font.BOLD, 13));
		nvbtn4.setBounds(559, 64, 140, 40);
		panel.add(nvbtn4);
		
		JButton kmbtn3 = new JButton("Khuyến mãi");
		kmbtn3.setFocusable(false);
		kmbtn3.setBorder(null);
		kmbtn3.setForeground(new Color(255, 255, 255));
		kmbtn3.setFont(new Font("Tahoma", Font.BOLD, 13));
		kmbtn3.setBackground(new Color(0, 0, 153));
		kmbtn3.setBounds(409, 64, 140, 40);
		panel.add(kmbtn3);
		
		JButton mk_btn6 = new JButton("Đổi mật khẩu");
		mk_btn6.setFocusable(false);
		mk_btn6.setFont(new Font("Tahoma", Font.BOLD, 12));
		mk_btn6.setBounds(752, 25, 124, 30);
		panel.add(mk_btn6);
		
		JLabel lblNewLabel = new JLabel("User");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(685, 25, 90, 30);
		panel.add(lblNewLabel);
		
		Label label = new Label("New label");
		label.setBackground(new Color(128, 255, 128));
		label.setBounds(13, 31, 90, 90);
		panel.add(label);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(13, 127, 860, 661);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Thông tin tours");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(40, 10, 134, 30);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_1.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128)));
		scrollPane.setBounds(10, 50, 230, 579);
		panel_1.add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		scrollPane.setViewportView(panel_2);
		panel_2.setLayout(null);
		panel_2.setPreferredSize(new Dimension(210, 1173));
		panel_2.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel_2 = new JLabel("Mã Tour :");
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 10, 153, 35);
		panel_2.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_1.setBounds(10, 41, 190, 35);
		panel_2.add(textField_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Loại Tour :");
		lblNewLabel_2_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(10, 77, 153, 35);
		panel_2.add(lblNewLabel_2_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		comboBox.setBounds(10, 110, 190, 35);
		panel_2.add(comboBox);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Tên Tour :");
		lblNewLabel_2_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1_1.setBounds(10, 146, 153, 35);
		panel_2.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Mô tả :");
		lblNewLabel_2_1_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1_1_1.setBounds(10, 244, 153, 35);
		panel_2.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Số chỗ :");
		lblNewLabel_2_1_1_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1_1_1_1.setBounds(10, 335, 153, 35);
		panel_2.add(lblNewLabel_2_1_1_1_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		comboBox_1.setBounds(10, 364, 70, 35);
		panel_2.add(comboBox_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("Điểm khởi hành :");
		lblNewLabel_2_1_1_1_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1_1_1_1_1.setBounds(10, 401, 153, 35);
		panel_2.add(lblNewLabel_2_1_1_1_1_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		comboBox_2.setBounds(10, 439, 190, 35);
		panel_2.add(comboBox_2);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1 = new JLabel("Điểm đến :");
		lblNewLabel_2_1_1_1_1_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1_1_1_1_1_1.setBounds(10, 479, 153, 35);
		panel_2.add(lblNewLabel_2_1_1_1_1_1_1);
		
		JComboBox comboBox_2_1 = new JComboBox();
		comboBox_2_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		comboBox_2_1.setBounds(10, 511, 190, 35);
		panel_2.add(comboBox_2_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1_1 = new JLabel("Ngày đi :");
		lblNewLabel_2_1_1_1_1_1_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1_1_1_1_1_1_1.setBounds(10, 548, 153, 35);
		panel_2.add(lblNewLabel_2_1_1_1_1_1_1_1);
		
		JComboBox comboBox_2_1_1 = new JComboBox();
		comboBox_2_1_1.setBounds(10, 579, 190, 35);
		panel_2.add(comboBox_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1_1_1 = new JLabel("Ngày về :");
		lblNewLabel_2_1_1_1_1_1_1_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1_1_1_1_1_1_1_1.setBounds(10, 615, 153, 35);
		panel_2.add(lblNewLabel_2_1_1_1_1_1_1_1_1);
		
		JComboBox comboBox_2_1_1_1 = new JComboBox();
		comboBox_2_1_1_1.setBounds(10, 648, 190, 35);
		panel_2.add(comboBox_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1_1_1_1 = new JLabel("Số ngày :");
		lblNewLabel_2_1_1_1_1_1_1_1_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1_1_1_1_1_1_1_1_1.setBounds(10, 684, 153, 35);
		panel_2.add(lblNewLabel_2_1_1_1_1_1_1_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_2.setBounds(10, 713, 70, 35);
		panel_2.add(textField_2);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1_1_1_1_1 = new JLabel("Hướng dẫn viên :");
		lblNewLabel_2_1_1_1_1_1_1_1_1_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_1_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1_1_1_1_1_1_1_1_1_1.setBounds(10, 751, 153, 35);
		panel_2.add(lblNewLabel_2_1_1_1_1_1_1_1_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_3.setBounds(10, 781, 190, 35);
		panel_2.add(textField_3);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1_1_1_1_2 = new JLabel("Giá vé :");
		lblNewLabel_2_1_1_1_1_1_1_1_1_1_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_1_1_1_1_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1_1_1_1_1_1_1_1_1_2.setBounds(10, 817, 153, 35);
		panel_2.add(lblNewLabel_2_1_1_1_1_1_1_1_1_1_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_4.setBounds(10, 846, 190, 35);
		panel_2.add(textField_4);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1_1_1_1_2_1 = new JLabel("Tổng chi :");
		lblNewLabel_2_1_1_1_1_1_1_1_1_1_2_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_1_1_1_1_1_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1_1_1_1_1_1_1_1_1_2_1.setBounds(10, 883, 153, 35);
		panel_2.add(lblNewLabel_2_1_1_1_1_1_1_1_1_1_2_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_5.setBounds(10, 913, 190, 35);
		panel_2.add(textField_5);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1_1_1_1_2_1_1 = new JLabel("Ảnh 1:");
		lblNewLabel_2_1_1_1_1_1_1_1_1_1_2_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_1_1_1_1_1_1_1_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1_1_1_1_1_1_1_1_1_2_1_1.setBounds(10, 958, 60, 35);
		panel_2.add(lblNewLabel_2_1_1_1_1_1_1_1_1_1_2_1_1);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(64, 958, 85, 35);
		panel_2.add(btnNewButton);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1_1_1_1_2_1_1_1 = new JLabel("Ảnh 2:");
		lblNewLabel_2_1_1_1_1_1_1_1_1_1_2_1_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_1_1_1_1_1_1_1_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1_1_1_1_1_1_1_1_1_2_1_1_1.setBounds(10, 994, 60, 35);
		panel_2.add(lblNewLabel_2_1_1_1_1_1_1_1_1_1_2_1_1_1);
		
		JButton btnNewButton_1 = new JButton("Thêm");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(64, 994, 85, 35);
		panel_2.add(btnNewButton_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1_1_1_1_2_1_1_2 = new JLabel("Ảnh 3:");
		lblNewLabel_2_1_1_1_1_1_1_1_1_1_2_1_1_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_1_1_1_1_1_1_1_1_2_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1_1_1_1_1_1_1_1_1_2_1_1_2.setBounds(10, 1031, 60, 35);
		panel_2.add(lblNewLabel_2_1_1_1_1_1_1_1_1_1_2_1_1_2);
		
		JButton btnNewButton_2 = new JButton("Thêm");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBounds(64, 1031, 85, 35);
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Thêm");
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3.setBorder(null);
		btnNewButton_3.setBackground(new Color(0, 0, 128));
		btnNewButton_3.setBounds(10, 1080, 85, 35);
		panel_2.add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("Xóa");
		btnNewButton_3_1.setForeground(Color.WHITE);
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3_1.setBorder(null);
		btnNewButton_3_1.setBackground(new Color(0, 0, 128));
		btnNewButton_3_1.setBounds(115, 1080, 85, 35);
		panel_2.add(btnNewButton_3_1);
		
		JButton btnNewButton_3_2 = new JButton("Sửa");
		btnNewButton_3_2.setForeground(Color.WHITE);
		btnNewButton_3_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3_2.setBorder(null);
		btnNewButton_3_2.setBackground(new Color(0, 0, 128));
		btnNewButton_3_2.setBounds(10, 1117, 85, 35);
		panel_2.add(btnNewButton_3_2);
		
		JButton btnNewButton_3_3 = new JButton("Lưu");
		btnNewButton_3_3.setForeground(Color.WHITE);
		btnNewButton_3_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3_3.setBorder(null);
		btnNewButton_3_3.setBackground(new Color(0, 0, 128));
		btnNewButton_3_3.setBounds(115, 1117, 85, 35);
		panel_2.add(btnNewButton_3_3);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 185, 190, 60);
		panel_2.add(scrollPane_1);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JTextArea textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		textArea.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1_1.setBounds(10, 273, 190, 60);
		panel_2.add(scrollPane_1_1);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_1_1.setViewportView(textArea_1);
		textArea_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(289, 0, 188, 40);
		panel_1.add(comboBox_3);
		
		textField_6 = new JTextField();
		textField_6.setBounds(507, 1, 188, 40);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("TK");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(696, 0, 60, 40);
		panel_1.add(btnNewButton_4);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(260, 50, 553, 172);
		panel_1.add(scrollPane_2);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 Tour", "T\u00EAn Tour", "S\u1ED1 ch\u1ED7", "Ng\u00E0y \u0111i", "Ng\u00E0y v\u1EC1", "H\u01B0\u1EDBng d\u1EABn vi\u00EAn", "T\u1ED5ng chi", "Gi\u00E1 v\u00E9"
			}
		));
		table.getColumnModel().getColumn(5).setPreferredWidth(109);
		scrollPane_2.setViewportView(table);
		
		JLabel lblNewLabel_3 = new JLabel("Tên tour");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(270, 232, 425, 40);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Giá tour");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(740, 232, 100, 40);
		panel_1.add(lblNewLabel_4);
		
		Label label_1 = new Label("Hình 1:");
		label_1.setFont(new Font("Dialog", Font.BOLD, 15));
		label_1.setBackground(new Color(0, 0, 255));
		label_1.setBounds(260, 276, 289, 172);
		panel_1.add(label_1);
		
		Label label_1_1 = new Label("Hình 2:");
		label_1_1.setFont(new Font("Dialog", Font.BOLD, 15));
		label_1_1.setBackground(Color.BLUE);
		label_1_1.setBounds(555, 275, 258, 84);
		panel_1.add(label_1_1);
		
		Label label_1_1_1 = new Label("Hình 3:");
		label_1_1_1.setFont(new Font("Dialog", Font.BOLD, 15));
		label_1_1_1.setBackground(Color.BLUE);
		label_1_1_1.setBounds(555, 364, 258, 83);
		panel_1.add(label_1_1_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Địa điểm");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4_1.setBounds(615, 454, 85, 30);
		panel_1.add(lblNewLabel_4_1);
		
		Label label_2 = new Label("New label");
		label_2.setBackground(new Color(128, 255, 128));
		label_2.setBounds(615, 480, 70, 49);
		panel_1.add(label_2);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_5.setBounds(625, 536, 85, 20);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Phương tiện");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4_1_1.setBounds(716, 453, 104, 30);
		panel_1.add(lblNewLabel_4_1_1);
		
		Label label_2_1 = new Label("New label");
		label_2_1.setBackground(new Color(128, 255, 128));
		label_2_1.setBounds(730, 480, 70, 49);
		panel_1.add(label_2_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("New label");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_5_1.setBounds(740, 535, 85, 20);
		panel_1.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_4_1_2 = new JLabel("Nhà hàng");
		lblNewLabel_4_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4_1_2.setBounds(615, 554, 85, 30);
		panel_1.add(lblNewLabel_4_1_2);
		
		Label label_2_2 = new Label("New label");
		label_2_2.setBackground(new Color(128, 255, 128));
		label_2_2.setBounds(615, 580, 70, 49);
		panel_1.add(label_2_2);
		
		JLabel lblNewLabel_5_2 = new JLabel("New label");
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_5_2.setBounds(625, 636, 85, 20);
		panel_1.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_4_1_3 = new JLabel("Khách sạn");
		lblNewLabel_4_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4_1_3.setBounds(725, 554, 85, 30);
		panel_1.add(lblNewLabel_4_1_3);
		
		Label label_2_3 = new Label("New label");
		label_2_3.setBackground(new Color(128, 255, 128));
		label_2_3.setBounds(730, 580, 70, 49);
		panel_1.add(label_2_3);
		
		JLabel lblNewLabel_5_3 = new JLabel("New label");
		lblNewLabel_5_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_5_3.setBounds(740, 636, 85, 20);
		panel_1.add(lblNewLabel_5_3);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_3.setBounds(260, 454, 316, 102);
		panel_1.add(scrollPane_3);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		scrollPane_3.setViewportView(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_4_1_4 = new JLabel("Thời gian");
		lblNewLabel_4_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4_1_4.setBounds(260, 565, 85, 30);
		panel_1.add(lblNewLabel_4_1_4);
		
		JLabel lblNewLabel_4_1_4_1 = new JLabel("Nơi khởi hành");
		lblNewLabel_4_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4_1_4_1.setBounds(260, 591, 117, 30);
		panel_1.add(lblNewLabel_4_1_4_1);
		
		JLabel lblNewLabel_4_1_4_1_1 = new JLabel("Số chỗ còn nhận");
		lblNewLabel_4_1_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4_1_4_1_1.setBounds(260, 621, 134, 30);
		panel_1.add(lblNewLabel_4_1_4_1_1);
		
	
		
		getContentPane().add(panel);
		this.setVisible(true);
	}
}
