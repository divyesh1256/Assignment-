package assignment8;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

public class helloo extends JFrame {

	private JPanel contentPane;
String filename;
int s=0;
byte[] person_image=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					helloo frame = new helloo();
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
	public helloo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 814, 631);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("");
		l1.setBounds(169, 435, 550, 28);
		contentPane.add(l1);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser ch=new JFileChooser();
				ch.showOpenDialog(null);
				File f=ch.getSelectedFile();
				filename=f.getAbsolutePath();
				l1.setText(filename);
				
				try
				{
					File image=new File(filename);
					FileInputStream fis=new FileInputStream(image);
					ByteArrayOutputStream bos=new ByteArrayOutputStream();
					byte[] buf=new byte[1024];
					for(int readNum; (readNum=fis.read(buf))!=-1; )
					{
						bos.write(buf,0,readNum);
					}
					person_image=bos.toByteArray();
					
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setBounds(208, 354, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 PreparedStatement ps;
		           String query = "insert into img(image) VALUES (?);";
		        
		        try {
		        	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/kk","root","root");
		            ps = conn.prepareStatement(query);
		           ps.setBytes(1, person_image);
		          
		          if(ps.executeUpdate()>0)
		          {
		        	  JOptionPane.showMessageDialog(null, "saved");
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
		btnNewButton_1.setBounds(649, 63, 85, 21);
		contentPane.add(btnNewButton_1);
	}
}
