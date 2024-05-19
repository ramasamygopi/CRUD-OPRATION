package swingconcept;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Viewproduct extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Viewproduct frame = new Viewproduct();
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
    public Viewproduct() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        // Create the table
        table = new JTable();
        contentPane.add(new JScrollPane(table), BorderLayout.CENTER);

        // Load data from the database
        loadData();
    }

    private void loadData() {
        // Database connection parameters
        String url = "jdbc:h2:tcp://localhost/~/test"; // Change the URL if your database is located elsewhere
        String username = "sa"; // Default username for H2 database
        String password = ""; // Default password for H2 database

        // SQL query to fetch data
        String query = "SELECT * FROM PRODUCT"; // Replace with your actual table name

        try {
            // Establish connection
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Get metadata to create the table model
            int columnCount = resultSet.getMetaData().getColumnCount();
            String[] columnNames = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                columnNames[i - 1] = resultSet.getMetaData().getColumnName(i);
            }

            // Create the table model and fill it with data
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = resultSet.getObject(i);
                }
                model.addRow(row);
            }

            // Set the model to the table
            table.setModel(model);

            // Close connections
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

