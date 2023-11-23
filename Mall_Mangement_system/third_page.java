package cart;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
public class third_page extends JFrame {

	private JPanel contentPane;
	private JTextField SN;
	private JTextField NM;
	private JTextField ID;
	private JTextField QN;
	private JTextField MB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					third_page frame = new third_page();
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
	public third_page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 928, 489);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.info);
		panel.setBounds(12, 13, 886, 416);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textHighlight);
		panel_1.setBounds(12, 13, 862, 67);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Information");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setBounds(274, 0, 357, 67);
		lblNewLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 35));
		panel_1.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		lblName.setBounds(128, 114, 74, 16);
		panel.add(lblName);
		
		JLabel lblProductId = new JLabel("Product ID");
		lblProductId.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		lblProductId.setBounds(559, 114, 116, 16);
		panel.add(lblProductId);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		lblQuantity.setBounds(721, 114, 103, 16);
		panel.add(lblQuantity);
		
		JLabel lblSrno = new JLabel("Sr.No");
		lblSrno.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		lblSrno.setBounds(36, 114, 74, 16);
		panel.add(lblSrno);
		
		SN = new JTextField();
		SN.setBounds(36, 157, 58, 22);
		panel.add(SN);
		SN.setColumns(10);
		
		NM = new JTextField();
		NM.setColumns(10);
		NM.setBounds(128, 157, 235, 22);
		panel.add(NM);
		
		ID = new JTextField();
		ID.setColumns(10);
		ID.setBounds(559, 157, 116, 22);
		panel.add(ID);
		
		QN = new JTextField();
		QN.setColumns(10);
		QN.setBounds(721, 157, 103, 22);
		panel.add(QN);
		
		MB = new JTextField();
		MB.setColumns(10);
		MB.setBounds(401, 157, 116, 22);
		panel.add(MB);
		
		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		lblMobile.setBounds(401, 114, 74, 16);
		panel.add(lblMobile);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int P1=Integer.parseInt(SN.getText());

				try
				{
					
					Class.forName("com.mysql.jdbc.Driver"); 
					//jdbc:mysql://hostname:port/database?useSSL=true&trustCertificateKeyStoreUrl=file:/path/to/truststore.jks&trustCertificateKeyStorePassword=yourPassword
					System.out.print("Deleted");				
					Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/cart","root","Dnyanesh@7123");
					PreparedStatement ps=(PreparedStatement) con.prepareStatement("delete from seller where sr_no=?");
					ps.setLong(1, P1);
					
					ps.executeUpdate();
					con.close();
					SN.setText("");
					JOptionPane.showMessageDialog(null,"Record Deleted Sucessfully..");
				}
				catch(Exception ee)
				{
					JOptionPane.showInputDialog(ee);
				}
			}
		});
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBounds(465, 250, 97, 25);
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("ADD");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int S1=Integer.parseInt(SN.getText());
				String N=NM.getText();
				int M=Integer.parseInt(MB.getText());
				int I=Integer.parseInt(ID.getText());

				String Q=QN.getText();
				try
				{
					
					Class.forName("com.mysql.jdbc.Driver"); 
					//jdbc:mysql://hostname:port/database?useSSL=true&trustCertificateKeyStoreUrl=file:/path/to/truststore.jks&trustCertificateKeyStorePassword=yourPassword
					System.out.print("connected");				
					Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/cart","root","Dnyanesh@7123");
					PreparedStatement p=(PreparedStatement) con.prepareStatement("insert into seller values(?, ?, ?, ?, ?)");
					PreparedStatement ps=(PreparedStatement) con.prepareStatement("update admin set quantity= quantity-? where product_id=?");

					p.setLong(1, S1);
					p.setString(2, N);
					p.setLong(3,M);
					p.setLong(4,I);
					p.setString(5, Q);
					ps.setLong(2,I);
					ps.setString(1, Q);

					p.executeUpdate();
					ps.executeUpdate();
					con.close();
					
					SN.setText("");
					ID.setText("");
					MB.setText("");
					QN.setText("");
					NM.setText("");
					JOptionPane.showMessageDialog(null,"Record Save Sucessfully..");
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
		btnNewButton_2.setBounds(321, 250, 97, 25);
		panel.add(btnNewButton_2);
	}

}
