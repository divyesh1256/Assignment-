package assignment8;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class userlogin extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JPasswordField t2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userlogin frame = new userlogin();
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
	public userlogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblLogin.setBounds(28, 58, 85, 45);
		contentPane.add(lblLogin);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(29, 149, 162, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(28, 225, 162, 23);
		contentPane.add(lblPassword);
		
		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t1.setBounds(200, 149, 215, 23);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JPasswordField();
		t2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t2.setBounds(202, 229, 213, 23);
		contentPane.add(t2);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String user = t1.getText();
		        String pass = String.valueOf(t2.getPassword());
		       
                String query="select * from account where username='"+user+"' and password='"+pass+"'";
		        ResultSet rs;
		    
		        // get the username & password
		        
		        
		        //create a select query to check if the username and the password exist in the database
		        Connection conn;
				try {
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
					   
	                Statement st = conn.createStatement();
	           

	            rs = st.executeQuery(query);
	            
	       
	            if(rs.next())
	            {
	                // show a new form
	             
	              // close the current form(login form)
	     
	          new loadiing();
	          
	             
	          dispose();
	       
	                
	               // adminjdjd.lname.setText("");
	            }  
	            
	                
	            else{
	                // error message
	                JOptionPane.showMessageDialog(null, "Invalid Username / Password");
	                t1.setText("");
	                t2.setText("");
	               
	            }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  
			}
				
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(93, 314, 130, 29);
		contentPane.add(btnNewButton);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new userregister().setVisible(true);
				dispose();
			}
		});
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSignUp.setBounds(351, 314, 130, 29);
		contentPane.add(btnSignUp);
	}
}
