package cart;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class second_page extends JFrame {

	private JPanel contentPane;
	private JTextField SN;
	private JTextField ID;
	private JTextField PN;
	private JTextField QN;
	private JTextField SR;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					second_page frame = new second_page();
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
	public second_page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 973, 346);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.info);
		panel.setBounds(12, 13, 925, 274);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textHighlight);
		panel_1.setBounds(12, 13, 904, 61);
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Admin Page");
		lblNewLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 35));
		lblNewLabel.setForeground(SystemColor.text);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Quantity");
		lblNewLabel_1.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		lblNewLabel_1.setBounds(556, 103, 156, 16);
		panel.add(lblNewLabel_1);
		
		JLabel label = new JLabel("Product Name");
		label.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		label.setBounds(253, 103, 156, 16);
		panel.add(label);
		
		JLabel lblRate = new JLabel("Selling Rate");
		lblRate.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		lblRate.setBounds(761, 103, 156, 16);
		panel.add(lblRate);
		
		JLabel lblProductId = new JLabel("Product ID");
		lblProductId.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		lblProductId.setBounds(121, 103, 156, 16);
		panel.add(lblProductId);
		
		JLabel lblSrNo = new JLabel("SR. NO.");
		lblSrNo.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		lblSrNo.setBounds(23, 103, 98, 16);
		panel.add(lblSrNo);
		
		SN = new JTextField();
		SN.setBounds(22, 131, 74, 22);
		panel.add(SN);
		SN.setColumns(10);
		
		ID = new JTextField();
		ID.setColumns(10);
		ID.setBounds(121, 131, 98, 22);
		panel.add(ID);
		
		PN = new JTextField();
		PN.setBounds(249, 132, 244, 22);
		panel.add(PN);
		PN.setColumns(10);
		
		QN = new JTextField();
		QN.setBounds(556, 132, 116, 22);
		panel.add(QN);
		QN.setColumns(10);
		
		SR = new JTextField();
		SR.setBounds(761, 132, 116, 22);
		panel.add(SR);
		SR.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int S1=Integer.parseInt(SN.getText());
				int P1=Integer.parseInt(ID.getText());
				String P2=PN.getText();
				String Q=QN.getText();
				int S2=Integer.parseInt(SR.getText());
				try
				{
					
					Class.forName("com.mysql.jdbc.Driver"); 
					//jdbc:mysql://hostname:port/database?useSSL=true&trustCertificateKeyStoreUrl=file:/path/to/truststore.jks&trustCertificateKeyStorePassword=yourPassword
					System.out.print("connected");				
					Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/cart","root","Dnyanesh@7123");
					PreparedStatement ps=(PreparedStatement) con.prepareStatement("insert into admin values(?, ?, ?, ?, ?)");
					ps.setLong(1, S1);
					ps.setLong(2, P1);
					ps.setString(3, P2);
					ps.setString(4, Q);
					ps.setLong(5, S2);

					ps.executeUpdate();
					con.close();
					
					SN.setText("");
					ID.setText("");
					PN.setText("");
					QN.setText("");
					SR.setText("");
					JOptionPane.showMessageDialog(null,"Record Save Sucessfully..");
				}
				catch(Exception ee)
				{
					JOptionPane.showInputDialog(ee);
				}
			}
		});
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		btnNewButton.setBounds(195, 201, 108, 36);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("UPDATE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				int S1=Integer.parseInt(SN.getText());
				int P1=Integer.parseInt(ID.getText());
//				String P2=PN.getText();
				String Q=QN.getText();
				int S2=Integer.parseInt(SR.getText());
				try
				{
					
					Class.forName("com.mysql.jdbc.Driver"); 
					//jdbc:mysql://hostname:port/database?useSSL=true&trustCertificateKeyStoreUrl=file:/path/to/truststore.jks&trustCertificateKeyStorePassword=yourPassword
					System.out.print("Changed");				
					Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/cart","root","Dnyanesh@7123");
					PreparedStatement ps=(PreparedStatement) con.prepareStatement("update admin set quantity=quantity+?, selling_rate=? where product_id=?");
					ps.setString(1, Q);
					ps.setLong(2, S2);
					ps.setLong(3, P1);
					
					ps.executeUpdate();
					con.close();
					SN.setText("");
					ID.setText("");
					PN.setText("");
					QN.setText("");
					SR.setText("");					
					
					JOptionPane.showMessageDialog(null,"upadate Sucessfully..");
				}
				catch(Exception ee)
				{
					JOptionPane.showInputDialog(ee);
				}

			}
		});
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.setBackground(SystemColor.textHighlight);
		btnNewButton_1.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		btnNewButton_1.setBounds(424, 201, 108, 36);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("REMOVE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int P1=Integer.parseInt(ID.getText());

				try
				{
					
					Class.forName("com.mysql.jdbc.Driver"); 
					//jdbc:mysql://hostname:port/database?useSSL=true&trustCertificateKeyStoreUrl=file:/path/to/truststore.jks&trustCertificateKeyStorePassword=yourPassword
					System.out.print("Deleted");				
					Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/cart","root","Dnyanesh@7123");
					PreparedStatement ps=(PreparedStatement) con.prepareStatement("delete from admin where product_id=?");
					ps.setLong(1, P1);
					
					ps.executeUpdate();
					con.close();
					ID.setText("");
					JOptionPane.showMessageDialog(null,"Item Removed Sucessfully..");
				}
				catch(Exception ee)
				{
					JOptionPane.showInputDialog(ee);
				}

			}
		});
		btnNewButton_2.setForeground(SystemColor.text);
		btnNewButton_2.setBackground(SystemColor.textHighlight);
		btnNewButton_2.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		btnNewButton_2.setBounds(663, 201, 108, 36);
		panel.add(btnNewButton_2);
	}
}
