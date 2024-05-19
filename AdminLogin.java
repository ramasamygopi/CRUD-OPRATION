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
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class AdminLogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminLogin frame = new AdminLogin();
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
    public AdminLogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 503, 392);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Admin Login");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel.setBounds(203, 29, 118, 14);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Admin Id");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
        lblNewLabel_1.setBounds(61, 90, 70, 14);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Password");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
        lblNewLabel_2.setBounds(61, 145, 70, 14);
        contentPane.add(lblNewLabel_2);

        textField = new JTextField();
        textField.setBounds(177, 87, 123, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("Login");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String s1 = textField.getText();
                    String s2 = new String(passwordField.getPassword());

                    String str = "SELECT * FROM admin";
                    Class.forName("org.h2.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
                    Statement stm = conn.createStatement();
                    ResultSet rs = stm.executeQuery(str);

                    boolean loginSuccess = false;
                    while (rs.next()) {
                        String uname = rs.getString("ADMIN"); // Update this line
                        String pass = rs.getString("ADMINPWD"); // Update this line

                        if (s1.equals(uname) && s2.equals(pass)) {
                            loginSuccess = true;
                            break;
                        }
                    }

                    if (loginSuccess) {
                        JOptionPane.showMessageDialog(btnNewButton, "Login Success!!!");
                        new Admin_page().setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton, "Login Failed");
                        reset();
                    }

                    rs.close();
                    stm.close();
                    conn.close();
                } catch (Exception t) {
                    t.printStackTrace();
                }
            }

            public void reset() {
                textField.setText("");
                passwordField.setText("");
            }
        });
        btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btnNewButton.setBounds(82, 211, 89, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Cancel");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btnNewButton_1.setBounds(232, 211, 89, 23);
        contentPane.add(btnNewButton_1);

        passwordField = new JPasswordField();
        passwordField.setBounds(179, 142, 121, 20);
        contentPane.add(passwordField);
    }
}
