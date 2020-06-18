package assignment8;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import com.toedter.*;
import com.toedter.calendar.JDateChooser;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class issue extends JFrame {

	protected static final String JTextField = null;
	private JPanel contentPane;
	private JTextField t7;
	private JTextField t8;
	private JTextField t0;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t5;
	private JTextField t6;
	private JTextField t4;
	private JTextField t10;
	private JTextField t12;
	private JTextField t11;
	private JTextField t00;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					issue frame = new issue();
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
	public issue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1064, 760);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(516, 35, 524, 522);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Name");
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(94, 99, 77, 24);
		panel.add(label);
		
		JLabel label_2 = new JLabel("Roll no");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_2.setBounds(94, 153, 77, 24);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Course");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_3.setBounds(94, 214, 77, 24);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Branch");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_4.setBounds(94, 276, 77, 24);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Year");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_5.setBounds(94, 345, 77, 24);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Semester");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_6.setBounds(94, 409, 77, 24);
		panel.add(label_6);
		
		t7 = new JTextField();
		t7.setFont(new Font("Tahoma", Font.BOLD, 13));
		t7.setColumns(10);
		t7.setBounds(222, 99, 194, 24);
		panel.add(t7);
		
		t8 = new JTextField();
		t8.setFont(new Font("Tahoma", Font.BOLD, 13));
		t8.setColumns(10);
		t8.setBounds(222, 153, 195, 24);
		panel.add(t8);
		
		JTextField t9 = new JTextField();
		t9.setFont(new Font("Tahoma", Font.BOLD, 13));
		t9.setColumns(10);
		t9.setBounds(222, 219, 195, 24);
		panel.add(t9);
		
		t10 = new JTextField();
		t10.setFont(new Font("Tahoma", Font.BOLD, 13));
		t10.setColumns(10);
		t10.setBounds(222, 281, 195, 24);
		panel.add(t10);
		
		t12 = new JTextField();
		t12.setFont(new Font("Tahoma", Font.BOLD, 13));
		t12.setColumns(10);
		t12.setBounds(222, 410, 195, 24);
		panel.add(t12);
		
		t11 = new JTextField();
		t11.setFont(new Font("Tahoma", Font.BOLD, 13));
		t11.setColumns(10);
		t11.setBounds(222, 346, 195, 24);
		panel.add(t11);
		
		JLabel lblStudentDetails = new JLabel("Student details");
		lblStudentDetails.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStudentDetails.setBounds(22, 10, 165, 24);
		panel.add(lblStudentDetails);
		
		JButton button = new JButton("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement ps;
				
		           String query = "select * from student where roll=?";
		        
		        try {
		        	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
		            ps = conn.prepareStatement(query);
		            ps.setString(1, t00.getText());  
		           ResultSet rs=ps.executeQuery();
		           while(rs.next())
		            {
		            	t7.setText(rs.getString("name"));
		            	t8.setText(rs.getString("roll"));
		            	t9.setText(rs.getString("course"));
		            	t10.setText(rs.getString("branch"));
		            	t11.setText(rs.getString("year"));
		            	t12.setText(rs.getString("sem"));
		            }
		           ps.close();
		           rs.close();
				
			}catch(Exception e1)
		        {
					e1.printStackTrace();
		        }
			}
				
				
				
				
				
				
				
			
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button.setBounds(364, 47, 85, 21);
		panel.add(button);
		
		JLabel label_1 = new JLabel("Roll no");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_1.setBounds(32, 52, 77, 24);
		panel.add(label_1);
		
		t00 = new JTextField();
		t00.setFont(new Font("Tahoma", Font.BOLD, 13));
		t00.setColumns(10);
		t00.setBounds(119, 49, 195, 24);
		panel.add(t00);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_1.setBounds(0, 55, 460, 502);
		contentPane.add(panel_1);
		
		JLabel label_7 = new JLabel("Book ID");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_7.setBounds(95, 65, 77, 24);
		panel_1.add(label_7);
		
		JDateChooser date = new JDateChooser();
		date.getCalendarButton().setBounds(241, 1, 21, 115);
		date.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		date.setBounds(208, 592, 260, 24);
		date.setForeground(new Color(105, 105, 105));
		contentPane.add(date);
	
		
		JLabel label_8 = new JLabel("Name");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_8.setBounds(119, 138, 77, 24);
		panel_1.add(label_8);
		
		JLabel label_9 = new JLabel("ISBN");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_9.setBounds(119, 183, 77, 24);
		panel_1.add(label_9);
		
		JLabel label_10 = new JLabel("Publisher");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_10.setBounds(119, 229, 77, 24);
		panel_1.add(label_10);
		
		JLabel label_11 = new JLabel("Edition");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_11.setBounds(119, 278, 77, 24);
		panel_1.add(label_11);
		
		JLabel label_12 = new JLabel("Price");
		label_12.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_12.setBounds(119, 328, 77, 24);
		panel_1.add(label_12);
		
		JLabel label_13 = new JLabel("Pages");
		label_13.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_13.setBounds(119, 380, 77, 24);
		panel_1.add(label_13);
		
		t0 = new JTextField();
		t0.setFont(new Font("Tahoma", Font.BOLD, 13));
		t0.setColumns(10);
		t0.setBounds(182, 68, 158, 19);
		panel_1.add(t0);
		
		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.BOLD, 13));
		t1.setColumns(10);
		t1.setBounds(248, 141, 158, 19);
		panel_1.add(t1);
		
		t2 = new JTextField();
		t2.setFont(new Font("Tahoma", Font.BOLD, 13));
		t2.setColumns(10);
		t2.setBounds(248, 188, 158, 19);
		panel_1.add(t2);
		
		t3 = new JTextField();
		t3.setFont(new Font("Tahoma", Font.BOLD, 13));
		t3.setColumns(10);
		t3.setBounds(248, 234, 158, 19);
		panel_1.add(t3);
		
		t5 = new JTextField();
		t5.setFont(new Font("Tahoma", Font.BOLD, 13));
		t5.setColumns(10);
		t5.setBounds(248, 328, 158, 19);
		panel_1.add(t5);
		
		t6 = new JTextField();
		t6.setFont(new Font("Tahoma", Font.BOLD, 13));
		t6.setColumns(10);
		t6.setBounds(248, 385, 158, 19);
		panel_1.add(t6);
		
		t4 = new JTextField();
		t4.setFont(new Font("Tahoma", Font.BOLD, 13));
		t4.setColumns(10);
		t4.setBounds(248, 283, 158, 19);
		panel_1.add(t4);
		
		JLabel lblIssueBooks = new JLabel("Issue Books");
		lblIssueBooks.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIssueBooks.setBounds(10, 10, 103, 24);
		panel_1.add(lblIssueBooks);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement ps;
				
		           String query = "select * from book where bookid=?";
		        
		        try {
		        	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
		            ps = conn.prepareStatement(query);
		            ps.setString(1, t0.getText());  
		           ResultSet rs=ps.executeQuery();
		           while(rs.next())
		            {
		            	t1.setText(rs.getString("name"));
		            	t2.setText(rs.getString("isbn"));
		            	t3.setText(rs.getString("publisher"));
		            	t4.setText(rs.getString("edition"));
		            	t5.setText(rs.getString("price"));
		            	t6.setText(rs.getString("pages"));
		            }
		           ps.close();
		           rs.close();
				
			}catch(Exception e1)
		        {
					e1.printStackTrace();
		        }
			}
				
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(350, 68, 85, 21);
		panel_1.add(btnNewButton);
		
		table = new JTable();
		table.setBounds(171, 499, 103, -51);
		panel_1.add(table);
		
		JButton btnIssue = new JButton("Issue");
		btnIssue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PreparedStatement ps;
				
		           String query = "insert into issue(bookid, roll, bname, name, course, branch, dateofissue) values(?,?,?,?,?,?,?);";
		        
		        try {
		        	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
		            ps = conn.prepareStatement(query);
		            ps.setString(1, t0.getText());
		            ps.setString(2, t8.getText());
		            ps.setString(3, t1.getText());
		            ps.setString(4, t7.getText());
		            ps.setString(5, t9.getText());
		            ps.setString(6, t10.getText());
		            ps.setString(7, ((JTextField)date.getDateEditor().getUiComponent()).getText());
		            int i=ps.executeUpdate();
		            if(i>0)
		            {
		            	JOptionPane.showMessageDialog(null, "Book issued successfully");
		            }
		            else
		            {
		            	JOptionPane.showMessageDialog(null, "Error. Check details!");
		            }
		        }
		        catch(Exception e1)
		        {
		        	
		        }
				
			}
		});
		btnIssue.setBounds(168, 650, 106, 30);
		contentPane.add(btnIssue);
		btnIssue.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton button_3 = new JButton("Back");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new adminmenu().setVisible(true);
				dispose();
			}
		});
		button_3.setBounds(415, 650, 106, 30);
		contentPane.add(button_3);
		button_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblDateOfIssue = new JLabel("Date of Issue:");
		lblDateOfIssue.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDateOfIssue.setBounds(85, 592, 130, 24);
		contentPane.add(lblDateOfIssue);
		
	
	
	}
}
