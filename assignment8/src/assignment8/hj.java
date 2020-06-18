package assignment8;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

public class hj extends JFrame {

	private JPanel contentPane;
private ImageIcon format=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hj frame = new hj();
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
	public hj() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 933, 729);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("");
		l1.setBorder(new LineBorder(new Color(0, 0, 0)));
		l1.setBounds(64, 61, 494, 470);
		contentPane.add(l1);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 PreparedStatement ps;
		           String query = "select * from img";
		        
		        try {
		        	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/kk","root","root");
		            ps = conn.prepareStatement(query);
		      //     ps.setBytes(1, person_image);
		          ResultSet rs=ps.executeQuery();
		          if(rs.next())
		          {
		        	byte[]imagedata=rs.getBytes("image");
		        	format=new ImageIcon(imagedata);
		        	l1.setIcon(format);
		        	
		          }
		         
		       
		          //ps.setString(4, df.format(d));
		          
		          //ps.setDate(4, convertUtilDateToSqlDate(ldate.getDate()));
		         // ps.setString(4, ((JTextField)date.getDateEditor().getUiComponent()).getText());
		        
		         
					
			      
		        }
		        catch (Exception e1)
		        {    
		         Logger.getLogger(helloo.class.getName()).log(Level.SEVERE, null, e1);   
		         System.out.println("hhhhhi");
		        }

			}
		});
		btnNewButton.setBounds(250, 583, 85, 21);
		contentPane.add(btnNewButton);
	}

}
