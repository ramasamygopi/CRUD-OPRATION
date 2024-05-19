package swingconcept;


	
	import java.awt.EventQueue;

	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;

	import java.awt.Font;
	import javax.swing.JTextField;
	import javax.swing.JButton;
	import java.awt.event.ActionListener;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.Statement;
	import java.awt.event.ActionEvent;

	public class Addproduct extends JFrame {

		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
		private JTextField textField;
		private JTextField textField_1;
		private JTextField textField_2;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Addproduct frame = new Addproduct();
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
		public Addproduct() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 479, 363);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Add Product Page");
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblNewLabel.setBounds(181, 25, 115, 26);
			contentPane.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Product Id");
			lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(62, 83, 69, 14);
			contentPane.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Product Name");
			lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblNewLabel_2.setBounds(62, 122, 89, 14);
			contentPane.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("Product Price");
			lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblNewLabel_3.setBounds(62, 159, 89, 14);
			contentPane.add(lblNewLabel_3);
			
			textField = new JTextField();
			textField.setBounds(181, 80, 115, 20);
			contentPane.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setBounds(181, 119, 115, 20);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
			
			textField_2 = new JTextField();
			textField_2.setBounds(181, 156, 115, 20);
			contentPane.add(textField_2);
			textField_2.setColumns(10);
			
			JButton btnNewButton = new JButton("Add");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
					int PID=Integer.parseInt(textField.getText());
					String PNAME=textField_1.getText();
					int PPRICE=Integer.parseInt(textField_2.getText());
					String str="insert into product values('"+PID+"','"+PNAME+"','"+PPRICE+"')";
					Class.forName("org.h2.Driver");
					Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
					Statement stm=conn.createStatement();
					stm.executeUpdate(str);
					JOptionPane.showMessageDialog(btnNewButton,"Inserted...");
					dispose();
					}catch(Exception u) {
						System.out.println(u);
					}
			}
			});
			btnNewButton.setBounds(62, 210, 89, 23);
			contentPane.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Reset");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textField.setText(" ");
					textField_1.setText(" ");
					textField_2.setText(" ");
				}
			});
			btnNewButton_1.setBounds(195, 210, 89, 23);
			contentPane.add(btnNewButton_1);
			
			JButton btnNewButton_2 = new JButton("Cancel");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new Admin_page().setVisible(true);
				}
			});
			btnNewButton_2.setBounds(313, 210, 89, 23);
			contentPane.add(btnNewButton_2);
		}

	}


