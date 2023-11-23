package cart;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login {

	private JFrame frame;
	private JTextField Ur;
	private JPasswordField Pw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.setBounds(100, 100, 450, 335);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.info);
		panel.setBounds(12, 13, 408, 262);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textHighlight);
		panel_1.setBounds(12, 13, 384, 55);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Shopping Karo");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 35));
		lblNewLabel.setBounds(59, 0, 313, 55);
		panel_1.add(lblNewLabel);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Palatino Linotype", Font.BOLD, 22));
		lblLogin.setBounds(159, 81, 72, 16);
		panel.add(lblLogin);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Palatino Linotype", Font.BOLD, 18));
		lblUsername.setBounds(77, 131, 96, 16);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Palatino Linotype", Font.BOLD, 18));
		lblPassword.setBounds(77, 160, 96, 16);
		panel.add(lblPassword);
		
		Ur = new JTextField();
		Ur.setBounds(185, 127, 116, 22);
		panel.add(Ur);
		Ur.setColumns(10);
		
		Pw = new JPasswordField();
		Pw.setBounds(185, 156, 118, 22);
		panel.add(Pw);
		
		JButton btnLogin = new JButton("Admin");
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				String U= Ur.getText();
				String P=Pw.getText();
				
				if (U.equals("Enter") && P.equals("123")){

					JOptionPane.showMessageDialog(null,"login Sucessfully..");
					second_page sp=new second_page();

					sp.setVisible(true);

					frame.dispose();

					}

				else{ JOptionPane.showMessageDialog(frame, "Invalid Username or Password!!!");
				}
			}
		});
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(SystemColor.textHighlight);
		btnLogin.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		btnLogin.setBounds(92, 224, 97, 25);
		panel.add(btnLogin);
		
		JButton btnNewButton = new JButton("Seller");
		btnNewButton.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String U= Ur.getText();
				@SuppressWarnings("deprecation")
				String P=Pw.getText();
				
				if (U.equals("DART") && P.equals("123")){

					JOptionPane.showMessageDialog(null,"login Sucessfully..");
					third_page sp=new third_page();

					sp.setVisible(true);

					frame.dispose();

					}

				else{ JOptionPane.showMessageDialog(frame, "Invalid Username or Password!!!");
				}
			}
			
		});
		btnNewButton.setBounds(217, 224, 97, 25);
		panel.add(btnNewButton);
		
		JLabel lblLoginAs = new JLabel("Login As");
		lblLoginAs.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		lblLoginAs.setForeground(new Color(0, 0, 0));
		lblLoginAs.setBounds(159, 195, 72, 16);
		panel.add(lblLoginAs);
	}
}
