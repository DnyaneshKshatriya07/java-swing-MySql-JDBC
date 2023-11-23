package loginpage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class secondpage extends JFrame {

	private JPanel contentPane;
	private JTextField Date;
	private JTextField Dy;
	private JTextField Nm;
	private JTextField Em;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					secondpage frame = new secondpage();
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
	public secondpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 519);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Dt = new JPanel();
		Dt.setBackground(Color.ORANGE);
		Dt.setBounds(15, 16, 591, 431);
		contentPane.add(Dt);
		Dt.setLayout(null);
		
		JEditorPane Box = new JEditorPane();
		Box.setBounds(15, 130, 561, 200);
		Dt.add(Box);
		
		JLabel lblDate = new JLabel("Date:-");
		lblDate.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblDate.setBounds(405, 16, 69, 20);
		Dt.add(lblDate);
		
		Date = new JTextField();
		Date.setBounds(473, 15, 103, 26);
		Dt.add(Date);
		Date.setColumns(10);
		
		JLabel lblDdmmyyyy = new JLabel("YYYY/MM/DD");
		lblDdmmyyyy.setFont(new Font("Comic Sans MS", Font.BOLD, 10));
		lblDdmmyyyy.setBounds(405, 39, 69, 11);
		Dt.add(lblDdmmyyyy);
		
		JLabel lblDay = new JLabel("Day:-");
		lblDay.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblDay.setBounds(405, 57, 69, 20);
		Dt.add(lblDay);
		
		Dy = new JTextField();
		Dy.setBounds(473, 57, 103, 26);
		Dt.add(Dy);
		Dy.setColumns(10);
		
		JLabel lblWriteHere = new JLabel("Write Here:-");
		lblWriteHere.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblWriteHere.setBounds(15, 94, 134, 20);
		Dt.add(lblWriteHere);
		
		JLabel lblName = new JLabel("Name:-");
		lblName.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblName.setBounds(15, 16, 75, 20);
		Dt.add(lblName);
		
		Nm = new JTextField();
		Nm.setBounds(95, 15, 297, 26);
		Dt.add(Nm);
		Nm.setColumns(10);
		
		JLabel lblEmailId = new JLabel("Email Id:-");
		lblEmailId.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblEmailId.setBounds(15, 59, 103, 20);
		Dt.add(lblEmailId);
		
		Em = new JTextField();
		Em.setBounds(124, 56, 266, 26);
		Dt.add(Em);
		Em.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String N=Nm.getText();
				String E=Em.getText();
				String D1=Date.getText();
				String D2=Dy.getText();
				String B=Box.getText();
				try
				{
					
					Class.forName("com.mysql.jdbc.Driver"); 
					//jdbc:mysql://hostname:port/database?useSSL=true&trustCertificateKeyStoreUrl=file:/path/to/truststore.jks&trustCertificateKeyStorePassword=yourPassword
					System.out.print("connected");				
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Daily_Dairy","root","Dnyanesh@7123");
					PreparedStatement ps=con.prepareStatement("insert into Dairy values(?,?,?,?,?)");
					ps.setString(1, N);
					ps.setString(2, E);
					ps.setString(3, D1);
					ps.setString(4, D2);
					ps.setString(5, B);
					
					ps.executeUpdate();
					con.close();
					Nm.setText("");
					Em.setText("");
					Date.setText("");
					Dy.setText("");
					Box.setText("");

					JOptionPane.showMessageDialog(null,"Record Save Sucessfully..");
				}
				catch(Exception ee)
				{
					JOptionPane.showInputDialog(ee);
				}
			}
		});
		btnSave.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnSave.setBackground(Color.BLACK);
		btnSave.setForeground(Color.WHITE);
		btnSave.setBounds(164, 92, 103, 29);
		Dt.add(btnSave);
		
		JButton btnResetAll = new JButton("Reset All");
		btnResetAll.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnResetAll.setBackground(Color.BLACK);
		btnResetAll.setForeground(Color.WHITE);
		btnResetAll.setBounds(277, 92, 115, 29);
		Dt.add(btnResetAll);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String N=Nm.getText();
				String D1=Date.getText();

				try
				{
					
					Class.forName("com.mysql.jdbc.Driver"); 
					//jdbc:mysql://hostname:port/database?useSSL=true&trustCertificateKeyStoreUrl=file:/path/to/truststore.jks&trustCertificateKeyStorePassword=yourPassword
					System.out.print("Deleted");				
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Daily_Dairy","root","Dnyanesh@7123");
					PreparedStatement ps=con.prepareStatement("delete from Dairy where name=? and date=?");
					//ps.setString(1, P);
					ps.setString(1, N);
					ps.setString(2, D1);
					
					ps.executeUpdate();
					con.close();
					Nm.setText("");
					Date.setText("");
					JOptionPane.showMessageDialog(null,"Delete Sucessfully..");
				}
				catch(Exception ee)
				{
					JOptionPane.showInputDialog(ee);
				}
			}
		});
		btnDelete.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnDelete.setBackground(Color.BLACK);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBounds(405, 93, 115, 29);
		Dt.add(btnDelete);
		
		JLabel lblNote = new JLabel("*Note:-");
		lblNote.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblNote.setBounds(15, 346, 91, 20);
		Dt.add(lblNote);
		
		JLabel lblForNewPage = new JLabel("For New Page:- Enter the values in the sequence of 1)Name  2)Email  3)Date  4)Day  5)Description");
		lblForNewPage.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblForNewPage.setBounds(15, 364, 561, 20);
		Dt.add(lblForNewPage);
		
		JLabel lblForDeleteThe = new JLabel("For Delete the page:- Enter the values in the sequence of 1)Name  2)Date");
		lblForDeleteThe.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblForDeleteThe.setBounds(15, 382, 555, 20);
		Dt.add(lblForDeleteThe);
	}
}
