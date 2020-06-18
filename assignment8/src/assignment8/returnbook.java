package assignment8;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class returnbook extends JFrame {

	private JPanel contentPane;
	private JTextField t0;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					returnbook frame = new returnbook();
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
	public void delete()
	{
		PreparedStatement ps;
		JDialog.setDefaultLookAndFeelDecorated(true);
           String query = "delete from issue where bookid=? ";
        
        try {
        	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
            ps = conn.prepareStatement(query);
            ps.setString(1, t0.getText());
           
            int i=ps.executeUpdate();
            if(i>0)
            {
            	JOptionPane.showMessageDialog(null, "Book Returned");
            }
            else
            {
            	JOptionPane.showMessageDialog(null, "Error");
            }
        }
            catch(Exception e1)
            {
            	e1.printStackTrace();
            }
            
	}
	
	
	public returnbook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Book ID");
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(34, 83, 77, 24);
		contentPane.add(label);
		
		JLabel lblBook = new JLabel("Book");
		lblBook.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBook.setBounds(34, 154, 77, 24);
		contentPane.add(lblBook);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCourse.setBounds(34, 234, 77, 24);
		contentPane.add(lblCourse);
		
		JLabel lblDateOfIssue = new JLabel("Date Of Issue");
		lblDateOfIssue.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDateOfIssue.setBounds(34, 311, 114, 24);
		contentPane.add(lblDateOfIssue);
		
		JLabel lblDateOfReturn = new JLabel("Date of Return");
		lblDateOfReturn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDateOfReturn.setBounds(34, 375, 130, 24);
		contentPane.add(lblDateOfReturn);
		
		t0 = new JTextField();
		t0.setFont(new Font("Tahoma", Font.BOLD, 13));
		t0.setColumns(10);
		t0.setBounds(104, 83, 154, 24);
		contentPane.add(t0);
		
		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.BOLD, 13));
		t1.setColumns(10);
		t1.setBounds(114, 155, 239, 24);
		contentPane.add(t1);
		
		t2 = new JTextField();
		t2.setFont(new Font("Tahoma", Font.BOLD, 13));
		t2.setColumns(10);
		t2.setBounds(113, 235, 229, 24);
		contentPane.add(t2);
		
		t3 = new JTextField();
		t3.setFont(new Font("Tahoma", Font.BOLD, 13));
		t3.setColumns(10);
		t3.setBounds(158, 312, 195, 24);
		contentPane.add(t3);
		
		JDateChooser date = new JDateChooser();
		date.setBounds(174, 375, 260, 24);
		contentPane.add(date);
		
		JLabel lblRollNoOf = new JLabel("Roll No of Student");
		lblRollNoOf.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRollNoOf.setBounds(328, 83, 172, 24);
		contentPane.add(lblRollNoOf);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(495, 154, 77, 24);
		contentPane.add(lblName);
		
		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBranch.setBounds(495, 217, 77, 24);
		contentPane.add(lblBranch);
		
		t4 = new JTextField();
		t4.setFont(new Font("Tahoma", Font.BOLD, 13));
		t4.setColumns(10);
		t4.setBounds(510, 83, 154, 24);
		contentPane.add(t4);
		
		t5 = new JTextField();
		t5.setFont(new Font("Tahoma", Font.BOLD, 13));
		t5.setColumns(10);
		t5.setBounds(568, 154, 210, 24);
		contentPane.add(t5);
		
		t6 = new JTextField();
		t6.setFont(new Font("Tahoma", Font.BOLD, 13));
		t6.setColumns(10);
		t6.setBounds(572, 217, 206, 24);
		contentPane.add(t6);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				PreparedStatement ps;
				JDialog.setDefaultLookAndFeelDecorated(true);
		           String query = "insert into returnbook(bookid, roll, bname, name, course, branch, dateofissue, dateofreturn) values(?,?,?,?,?,?,?,?);";
		        
		        try {
		        	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
		            ps = conn.prepareStatement(query);
		            ps.setString(1, t0.getText());
		            ps.setString(2, t4.getText());
		            ps.setString(3, t1.getText());
		            ps.setString(4, t5.getText());
		            ps.setString(5, t2.getText());
		            ps.setString(6, t6.getText());
		            ps.setString(7, t3.getText());
		            ps.setString(8, ((JTextField)date.getDateEditor().getUiComponent()).getText());
		          
		            int i=ps.executeUpdate();
		            if(i>0)
		            {
		            	JOptionPane.showMessageDialog(null, "Processing....");
		            	delete();
		            }
		            else
		            {
		            	JOptionPane.showMessageDialog(null, "Error");
		            }
		       
			}
		        catch(Exception e1)
		        {
		        	e1.printStackTrace();
		        }
			}
		});
		btnReturn.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReturn.setBounds(531, 295, 185, 39);
		contentPane.add(btnReturn);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new adminmenu().setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(531, 379, 185, 39);
		contentPane.add(btnBack);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement ps;
				JDialog.setDefaultLookAndFeelDecorated(true);
		           String query = "select * from issue where roll=? and bookid=?";
		        
		        try {
		        	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
		            ps = conn.prepareStatement(query);
		         ps.setString(1, t4.getText());
		         ps.setString(2, t0.getText());
		         ResultSet rs=ps.executeQuery();
				
				while(rs.next())
				{
					t1.setText(rs.getString("bname"));
					t5.setText(rs.getString("name"));
					t2.setText(rs.getString("course"));
					t6.setText(rs.getString("branch"));
					t3.setText(rs.getString("dateofissue"));
				}
				
			}
		        catch(Exception e1)
		        {
		        	e1.printStackTrace();
		        }
			
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.setBounds(707, 83, 114, 25);
		contentPane.add(btnSearch);
	}
}
