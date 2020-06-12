package srp12.big.refactorings.separate.domain.from.presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class ProcessSaleFrame extends JFrame implements ActionListener {

	private String[] itemIds = new String[] { 
			"012569-798380", "786936-803488", "043396-150232" };

	private JPanel contentPane;
	private JComboBox<String> itemId = new JComboBox<>(itemIds);
	private JSpinner quantity = new JSpinner(new SpinnerNumberModel(1, 0, 100, 1));
	private JTextField descriptionField = new JTextField(10);
	private JTextField priceField = new JTextField(10);
	private JTextField subTotalField = new JTextField(10);
	private JTextField totalField = new JTextField(10);

	private JButton newSaleButton = new JButton("New Sale");
	private JButton enterItemButton = new JButton("Enter Item");
	private JButton endSaleButton = new JButton("End Sale");

	private static final String DB_DRIVER = "org.h2.FunctionalDemo";
	private static final String DB_CONNECTION = "jdbc:h2:~/test";
	private static final String DB_USER = "sa";
	private static final String DB_PASSWORD = "";
	
	private double total = 0;

	private Connection connection = null;

	private Statement stmt = null;

	public void doIt() {
	
		createDB();
		
		EventQueue.invokeLater(() -> {
			try {
				setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProcessSaleFrame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);

		contentPane.add("North", buildNorthPanel());
		contentPane.add("Center", buildCenterPanel());
		contentPane.add("South", buildSouthPanel());
		// Crude way to adjust spacing :-(
		contentPane.add("West", new JLabel("        "));
		contentPane.add("East", new JLabel("        "));

	}

	private JPanel buildSouthPanel() {
		JPanel panel = new JPanel();

		newSaleButton.addActionListener(this);
		panel.add(newSaleButton);

		enterItemButton.addActionListener(this);
		enterItemButton.setEnabled(false);
		panel.add(enterItemButton);

		endSaleButton.addActionListener(this);
		endSaleButton.setEnabled(false);
		panel.add(endSaleButton);

		return panel;
	}

	private JPanel buildCenterPanel() {
		JPanel panel = new JPanel(new SpringLayout());

		panel.add(new JLabel("ItemID", JLabel.TRAILING));
		panel.add(itemId);

		panel.add(new JLabel("Quantity", JLabel.TRAILING));
		panel.add(quantity);

		panel.add(new JLabel("Description", JLabel.TRAILING));
		panel.add(descriptionField);

		panel.add(new JLabel("Price", JLabel.TRAILING));
		panel.add(priceField);

		panel.add(new JLabel("SubTotal", JLabel.TRAILING));
		panel.add(subTotalField);

		panel.add(new JLabel("Total", JLabel.TRAILING));
		panel.add(totalField);

		// Layout the panel.
		SpringUtilities.makeCompactGrid(panel, 6, 2, // rows, cols
				9, 6, // initX, initY
				9, 6);// xPad, yPad
		return panel;
	}

	private JPanel buildNorthPanel() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Welcome to Fantastic Market!");
		label.setFont(new Font("Serif", Font.PLAIN, 20));
		panel.add(label);
		return panel;
	}

	private void resetGUI() {
		itemId.setSelectedIndex(0);
		quantity.setModel(new SpinnerNumberModel(1, 0, 100, 1));
		descriptionField.setText("");
		priceField.setText("");
		subTotalField.setText("");
		totalField.setText("");
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {

		String action = event.getActionCommand();
		try {
			if (action.equals("New Sale")) {
				makeNewSale();
			} else if (action.equals("End Sale")) {
				endSale();
			} else if (action.equals("Enter Item")) {
				enterItem();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void enterItem() {
		JComponent editor = quantity.getEditor();
		int qty = Integer.parseInt(((JSpinner.DefaultEditor) editor).getTextField().getText());
		String id = (String) itemId.getSelectedItem();

		try {
			prepareTransaction();
			
			stmt.execute("INSERT INTO LINEITEM (ItemID, Quantity, ProductDescriptionID, SaleID) VALUES('"
					+ id + "', " + qty + "," 
					+ "(SELECT ItemID from PRODUCT_DESCRIPTION WHERE ItemID = '" + id +
					"'),"
					+ "(SELECT SaleId from SALE WHERE SaleID = 1))" 
					);
			
			ResultSet rs = stmt.executeQuery(
					"select * from PRODUCT_DESCRIPTION where ItemID = '" + id +"'");
			int price = 0;
			String desc = "";
			while (rs.next()) {
				price = rs.getInt("Price");
				desc = rs.getString("Description");
			}
			
			double subTotal = price * qty;
			total += subTotal;
			descriptionField.setText(desc);
			priceField.setText(String.valueOf(price));
			subTotalField.setText(String.valueOf(subTotal));
			totalField.setText(String.valueOf(total));

			wrapUptransaction();
		} catch (SQLException e) {
			System.out.println("Exception Message " + e.getLocalizedMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	private void endSale() {
		enterItemButton.setEnabled(false);
		endSaleButton.setEnabled(false);
		
		try {
			prepareTransaction();
			
			stmt.executeUpdate("UPDATE SALE set TOTAL = " + total + " WHERE SaleID in (1)");

			wrapUptransaction();
		} catch (SQLException e) {
			System.out.println("Exception Message " + e.getLocalizedMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	private void makeNewSale() {
		resetGUI();
		enterItemButton.setEnabled(true);
		endSaleButton.setEnabled(true);

		try {
			prepareTransaction();
			
			stmt.execute("INSERT INTO SALE (OccurredOn) VALUES('" + Date.valueOf(LocalDate.now()) + "')" );

			wrapUptransaction();
		} catch (SQLException e) {
			System.out.println("Exception Message " + e.getLocalizedMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void createDB() {
		
		org.h2.tools.DeleteDbFiles.execute("~", "test", true);
		
		try {
			prepareTransaction();
			
			createProductDescriptionTable();
			createSaleTable();
			createLineItemTable();
			
			wrapUptransaction();
		} catch (SQLException e) {
			System.out.println("Exception Message " + e.getLocalizedMessage());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	private void wrapUptransaction() throws SQLException {
		stmt.close();
		connection.commit();
		connection.close();
	}

	private void prepareTransaction() throws SQLException {
		stmt = null;
		connection = getDBConnection();
		connection.setAutoCommit(false);
		stmt = connection.createStatement();
	}

	private void createLineItemTable() throws SQLException {
		stmt.execute("CREATE TABLE LINEITEM "
				 + "(ItemID varchar(13) not null,"
				 + "Quantity int,"
				 + "ProductDescriptionID varchar(13),"
				 + "SaleID int,"
				 + "primary key (ItemID),"
				 + "foreign key (ProductDescriptionID) references PRODUCT_DESCRIPTION,"
				 + "foreign key (SaleID) references SALE)"
				 );
	}

	private void createSaleTable() throws SQLException {
		stmt.execute("CREATE TABLE SALE "
				+ "(SaleID int not null auto_increment,"
				+ "OccurredOn Date,"
				+ "Total double,"
				+ "primary key(SaleId))");
	}

	private void createProductDescriptionTable() throws SQLException {
		stmt.execute("CREATE TABLE PRODUCT_DESCRIPTION "
					 + "(ItemID varchar(13) not null,"
					 + "Description varchar(80),"
					 + "Price int,"
					 + "primary key(ItemID))");

		stmt.execute("INSERT INTO PRODUCT_DESCRIPTION(ItemID, Description, Price)"
				+ " VALUES('012569-798380','2001: A Space Odyssey', 30.0)");
		stmt.execute("INSERT INTO PRODUCT_DESCRIPTION(ItemID, Description, Price)"
				+ " VALUES('786936-803488','Alice in Wonderland', 50.0)");
		stmt.execute("INSERT INTO PRODUCT_DESCRIPTION(ItemID, Description, Price)"
				+ " VALUES('043396-150232','Black Hawk Down', 25.0)");
	}
	
	private Connection getDBConnection() {
		connection = null;
		try {
			Class.forName(DB_DRIVER);
			connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return connection;
	}

}
