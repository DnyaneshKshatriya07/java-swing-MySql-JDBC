package loginpage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class myframe1 {

	private JFrame frame;
	private JPasswordField Pw;
	private JTextField Un;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					myframe1 window = new myframe1();
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
	public myframe1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 641, 456);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(15, 16, 587, 367);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(15, 16, 556, 77);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDailyDiary = new JLabel("Daily Diary");
		lblDailyDiary.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 50));
		lblDailyDiary.setForeground(Color.WHITE);
		lblDailyDiary.setBackground(Color.ORANGE);
		lblDailyDiary.setBounds(147, 0, 291, 66);
		panel_1.add(lblDailyDiary);
		
		JLabel lblUsername = new JLabel("Username:-");
		lblUsername.setBackground(new Color(240, 240, 240));
		lblUsername.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblUsername.setBounds(98, 129, 152, 26);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:-");
		lblPassword.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblPassword.setBounds(98, 184, 152, 26);
		panel.add(lblPassword);
		
		Pw = new JPasswordField();
		Pw.setBounds(244, 184, 202, 30);
		panel.add(Pw);
		
		Un = new JTextField();
		Un.setBounds(244, 129, 202, 30);
		panel.add(Un);
		Un.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String U =Un.getText();
				String P =Pw.getText();
				
				if(U.equals("admin")&& P.equals("xyz")){
					JOptionPane.showMessageDialog(null,"login Sucessfully..");
					secondpage sp=new secondpage();
					sp.setVisible(true);
					frame.dispose();
				}
				else{
					JOptionPane.showMessageDialog(frame,"Invalid Username or Password!!!");
				}
			}
		});
		btnLogin.setBackground(Color.BLACK);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnLogin.setBounds(219, 255, 168, 37);
		panel.add(btnLogin);
	}
}
