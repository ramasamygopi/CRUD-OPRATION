package swingconcept;




	import java.awt.EventQueue;

	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;
	import javax.swing.JLabel;
	import java.awt.Font;
	import javax.swing.JTextArea;

	public class HomePage extends JFrame {

		private static final long serialVersionUID = 1L;
		private JPanel contentPane;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						HomePage frame = new HomePage();
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
		public HomePage() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 499, 404);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Welcome to Home Page");
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
			lblNewLabel.setBounds(146, 23, 229, 14);
			contentPane.add(lblNewLabel);
			
			JTextArea textArea = new JTextArea();
			textArea.setBounds(52, 74, 410, 149);
			contentPane.add(textArea);
		}

	}

