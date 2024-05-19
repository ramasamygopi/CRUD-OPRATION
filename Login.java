package swingconcept;



	import java.awt.EventQueue;

	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;

	import java.awt.Font;
	import javax.swing.SwingConstants;
	import javax.swing.JTextArea;
	import javax.swing.JTextField;
	import javax.swing.DropMode;
	import javax.swing.JButton;
	import java.awt.event.ActionListener;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.Statement;
	import java.awt.event.ActionEvent;
	import javax.swing.JPasswordField;

	public class Login extends JFrame {

		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
		private JTextField textField;
		private JTextField textField_1;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Login frame = new Login();
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
		public Login() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 498, 379);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Login");
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblNewLabel.setBounds(220, 29, 80, 14);
			contentPane.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("User Id");
			lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
			lblNewLabel_1.setBounds(37, 88, 69, 14);
			contentPane.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Password");
			lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
			lblNewLabel_2.setBounds(37, 147, 69, 14);
			contentPane.add(lblNewLabel_2);
			
			JButton btnNewButton = new JButton("Login");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try
					{
						String t1=textField.getText();
						String t2=textField_1.getText();
						String str1="SELECT * FROM LOGIN";
						Class.forName("org.h2.Driver");
						Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
						Statement stmt=conn.createStatement();
						ResultSet rs=stmt.executeQuery(str1);
						rs.next();
						String u1=rs.getString(1);
						String p1=rs.getString(2);
						if(t1.equals(u1) && t2.equals(p1))
						{
							
							JOptionPane.showMessageDialog(btnNewButton,"LoginSucess!!!");
							
						}
						else
						{
							JOptionPane.showMessageDialog(btnNewButton,"Failer!!!");
						}
					}
					catch(Exception t)
					{
						System.out.println(t);
					}
				}
					
					
			});
			btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			btnNewButton.setBounds(85, 206, 89, 23);
			contentPane.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Cancel");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			btnNewButton_1.setBounds(237, 206, 89, 23);
			contentPane.add(btnNewButton_1);
			
			textField = new JTextField();
			textField.setBounds(131, 85, 183, 20);
			contentPane.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setBounds(131, 144, 183, 20);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
		}
	}


