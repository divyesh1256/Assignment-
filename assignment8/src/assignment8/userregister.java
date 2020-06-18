package assignment8;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

public class userregister extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JPasswordField t3;
	private JPasswordField t4;

	/**
	 * Launch the application.
	 */
	
public boolean checkUsername(String username){
        
        PreparedStatement st;
        ResultSet rs;
        boolean username_exist = false;
        
        String query = "SELECT * FROM `account` WHERE `username` = ?";
        
        try {
            
        	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
            st = conn.prepareStatement(query);
            st.setString(1, t2.getText());
            rs = st.executeQuery();
        
            if(rs.next())
            {
                username_exist = true;
                JOptionPane.showMessageDialog(null, "This Username is Already Taken, Choose Another One", "Username Failed", 2);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(userregister.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return username_exist;
    }


public boolean verifyFields()
{

    String name1=t1.getText();
    
    
     String user=t2.getText();
      String pass = String.valueOf(t3.getPassword());
    String re_pass = String.valueOf(t4.getPassword());
    
    // check empty fields
    if(name1.trim().equals("")  || user.trim().equals("") || pass.trim().equals("")
       || re_pass.trim().equals(""))
    {
        JOptionPane.showMessageDialog(null, "One Or More Fields Are Empty","Empty Fields",2);
        return false;
    }
    
    // check if the two password are equals or not
    else if(!pass.equals(re_pass))
    {
       JOptionPane.showMessageDialog(null, "Password Doesn't Match","Confirm Password",2); 
       return false;
    }
  
    else
   
    // if everything is ok
    return true;
}


		
	
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userregister frame = new userregister();
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
	public userregister() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	        if(verifyFields())
	        {
	        
	        if(!checkUsername(t2.getText()))
	        {
			     PreparedStatement ps;
		           String query = "insert into account(name, username, password) VALUES (?,?,?);";
		        
		        try {
		        	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
		            ps = conn.prepareStatement(query);
		            
		            ps.setString(1, t1.getText());
		           
		            ps.setString(2, t2.getText());
		            ps.setString(3, String.valueOf(t3.getPassword()));
		        
		
		            if(ps.executeUpdate() > 0)
		            {
		          JOptionPane.showMessageDialog(null, "Registration Successful");
		          new userlogin().setVisible(true);
		          dispose();
		        
		            
		           
		          dispose();
		                         }else{
		                             JOptionPane.showMessageDialog(null, "Error: Check Your Information");
		                         }
		        }
		        catch (Exception e1)
		        {
		         Logger.getLogger(userregister.class.getName()).log(Level.SEVERE, null, e1);   
		         System.out.println("hhhhhi");
		        }
		        
	        }
		        }

			}
			
			
		});
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSignUp.setBounds(206, 381, 130, 29);
		contentPane.add(btnSignUp);
		
		JLabel lblCreateAccount = new JLabel("Create Account");
		lblCreateAccount.setHorizontalAlignment(SwingConstants.LEFT);
		lblCreateAccount.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblCreateAccount.setBounds(42, 23, 236, 45);
		contentPane.add(lblCreateAccount);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setBounds(42, 94, 162, 23);
		contentPane.add(lblName);
		
		JLabel label_1 = new JLabel("Username");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(42, 163, 162, 23);
		contentPane.add(label_1);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(42, 238, 162, 23);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConfirmPassword.setBounds(42, 310, 162, 23);
		contentPane.add(lblConfirmPassword);
		
		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t1.setColumns(10);
		t1.setBounds(198, 98, 215, 23);
		contentPane.add(t1);
		
		t2 = new JTextField();
		t2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t2.setColumns(10);
		t2.setBounds(198, 163, 215, 23);
		contentPane.add(t2);
		
		t3 = new JPasswordField();
		t3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t3.setBounds(198, 238, 213, 23);
		contentPane.add(t3);
		
		t4 = new JPasswordField();
		t4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t4.setBounds(198, 310, 213, 23);
		contentPane.add(t4);
	}

}
