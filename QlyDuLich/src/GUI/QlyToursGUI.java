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
import java.awt.Dimension;
import java.awt.Rectangle;

public class QlyToursGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

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
		setType(Type.UTILITY);
		setBackground(SystemColor.windowText);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 650);
		contentPane = new JPanel();
		contentPane.setVerifyInputWhenFocusTarget(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(255, 132, 132));
		panel.setBounds(0, -19, 886, 632);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Quản lý Tours");
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFocusable(false);
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(0, 0, 153));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(109, 64, 140, 40);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Quản lý dịch vụ");
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 153));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(259, 64, 140, 40);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Khách hàng");
		btnNewButton_1_1.setFocusable(false);
		btnNewButton_1_1.setBorder(null);
		btnNewButton_1_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1_1.setBackground(new Color(0, 0, 153));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_1.setBounds(709, 64, 155, 40);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_6_1 = new JButton("Nhân viên");
		btnNewButton_1_6_1.setFocusable(false);
		btnNewButton_1_6_1.setBorder(null);
		btnNewButton_1_6_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1_6_1.setBackground(new Color(0, 0, 153));
		btnNewButton_1_6_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_6_1.setBounds(559, 64, 140, 40);
		panel.add(btnNewButton_1_6_1);
		
		JButton btnNewButton_1_3_1 = new JButton("Khuyến mãi");
		btnNewButton_1_3_1.setFocusable(false);
		btnNewButton_1_3_1.setBorder(null);
		btnNewButton_1_3_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_3_1.setBackground(new Color(0, 0, 153));
		btnNewButton_1_3_1.setBounds(409, 64, 140, 40);
		panel.add(btnNewButton_1_3_1);
		
		JButton btnNewButton_2 = new JButton("Đổi mật khẩu");
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(752, 25, 124, 30);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("User");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(685, 25, 90, 30);
		panel.add(lblNewLabel);
		
		Label label = new Label("New label");
		label.setBackground(new Color(128, 255, 128));
		label.setBounds(13, 31, 90, 90);
		panel.add(label);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(13, 127, 863, 495);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Thông tin tours");
		lblNewLabel_1.setBounds(29, 10, 134, 30);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_1.add(lblNewLabel_1);
		
		
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setBounds(new Rectangle(298, 36, 505, 410));
		panel_2.setMinimumSize(new Dimension(550, 400));
		panel_2.setBackground(new Color(0, 255, 0));
		panel_2.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(148, 74, 96, 19);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.setBounds(406, 291, 85, 21);
		panel_2.add(btnNewButton_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(99, 279, 197, 68);
		panel_2.add(comboBox);
		
		JScrollPane scrollPane_1 = new JScrollPane(panel_2);
		scrollPane_1.setBounds(new Rectangle(0, 0, 190, 300));
		scrollPane_1.setAutoscrolls(true);
		scrollPane_1.setEnabled(false);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(29, 68, 190, 300);
		panel_1.add(scrollPane_1);
		
		
		this.getContentPane().add(panel);
		this.setVisible(true);
	}
}
