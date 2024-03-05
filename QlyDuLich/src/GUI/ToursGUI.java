package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.Window.Type;
import java.awt.SystemColor;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import java.awt.ScrollPane;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.SwingConstants;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Canvas;
import java.awt.Label;
import java.awt.Panel;
import javax.swing.border.BevelBorder;

public class ToursGUI extends JFrame {

//	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ToursGUI frame = new ToursGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ToursGUI() {
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
		
		JButton btnNewButton = new JButton("Trang chủ");
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
		
		JButton btnNewButton_1 = new JButton("Đặt Tours");
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
		
		JButton btnNewButton_1_1 = new JButton("Quản lý thông tin");
		btnNewButton_1_1.setFocusable(false);
		btnNewButton_1_1.setBorder(null);
		btnNewButton_1_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1_1.setBackground(new Color(0, 0, 153));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_1.setBounds(709, 64, 155, 40);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_6_1 = new JButton("Thống kê");
		btnNewButton_1_6_1.setFocusable(false);
		btnNewButton_1_6_1.setBorder(null);
		btnNewButton_1_6_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1_6_1.setBackground(new Color(0, 0, 153));
		btnNewButton_1_6_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_6_1.setBounds(559, 64, 140, 40);
		panel.add(btnNewButton_1_6_1);
		
		JButton btnNewButton_1_3_1 = new JButton("Quản lý Hóa đơn");
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
		
		
		this.setVisible(true);
	}
}
