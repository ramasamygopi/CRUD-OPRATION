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

public class HRmap extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HRmap frame = new HRmap();
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
	public HRmap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(131, 47, 222, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("HRMAPING SYSTEM");
		lblNewLabel_1.setBounds(172, 47, 128, 30);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Admin login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminLogin().setVisible(true);
				
			}
		});
		btnNewButton.setBounds(172, 99, 128, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("User login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent t) 
			{
				new Login().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(173, 150, 123, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Register");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				new Register().setVisible(true);
			}
		});
		btnNewButton_2.setBounds(172, 199, 128, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Addproduct");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				new Addproduct().setVisible(true);
			}
		});
		btnNewButton_3.setBounds(172, 247, 128, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Delete product");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Deleteproduct().setVisible(true);		}
		});
		btnNewButton_4.setBounds(172, 281, 128, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("View product");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Viewproduct().setVisible(true);		}
		});
		
		btnNewButton_5.setBounds(172, 315, 128, 23);
		contentPane.add(btnNewButton_5);
	}
}
