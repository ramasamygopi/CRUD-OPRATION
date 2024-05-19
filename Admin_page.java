package swingconcept;




import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin_page extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_page frame = new Admin_page();
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
	public Admin_page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to the Admin Page");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(156, 32, 186, 24);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add Products");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Addproduct().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton.setBounds(197, 77, 119, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add new admin");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new addnewadmin().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_1.setBounds(197, 216, 119, 31);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseFrame();
			}
		});
		btnNewButton_2.setBounds(197, 258, 119, 31);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Delete Product");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Deleteproduct().setVisible(true);
					dispose();
				}catch(Exception t) {
					System.out.println(t);
				}
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnNewButton_3.setBounds(197, 121, 119, 31);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("View Product");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Viewproduct().setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnNewButton_4.setBounds(197, 168, 119, 31);
		contentPane.add(btnNewButton_4);
	}

	public void CloseFrame() {
		super.dispose();
	}
}

