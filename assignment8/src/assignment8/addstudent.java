package assignment8;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class addstudent extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	public static JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addstudent frame = new addstudent();
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
	public addstudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 559);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(94, 99, 77, 24);
		contentPane.add(lblName);
		
		JLabel lblAddStudent = new JLabel("Add Student");
		lblAddStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddStudent.setForeground(new Color(0, 0, 139));
		lblAddStudent.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddStudent.setBounds(148, 23, 269, 30);
		contentPane.add(lblAddStudent);
		
		JLabel lblRollNo = new JLabel("Roll no");
		lblRollNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRollNo.setBounds(94, 153, 77, 24);
		contentPane.add(lblRollNo);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCourse.setBounds(94, 214, 77, 24);
		contentPane.add(lblCourse);
		
		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBranch.setBounds(94, 276, 77, 24);
		contentPane.add(lblBranch);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblYear.setBounds(94, 345, 77, 24);
		contentPane.add(lblYear);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSemester.setBounds(94, 409, 77, 24);
		contentPane.add(lblSemester);
		
		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.BOLD, 13));
		t1.setColumns(10);
		t1.setBounds(222, 99, 194, 24);
		contentPane.add(t1);
		
		t2 = new JTextField();
		t2.setFont(new Font("Tahoma", Font.BOLD, 13));
		t2.setColumns(10);
		t2.setBounds(222, 153, 195, 24);
		contentPane.add(t2);
		
		JComboBox t3 = new JComboBox();
		t3.setModel(new DefaultComboBoxModel(new String[] {"B.E.", "B Tech"}));
		t3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		t3.setBounds(222, 218, 195, 21);
		contentPane.add(t3);
		
		JComboBox t4 = new JComboBox();
		t4.setModel(new DefaultComboBoxModel(new String[] {"Computer Science", "Mechanical", "Electrical", "Aerospace", "Civil"}));
		t4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		t4.setBounds(222, 280, 195, 21);
		contentPane.add(t4);
		
		JComboBox t5 = new JComboBox();
		t5.setModel(new DefaultComboBoxModel(new String[] {"FY", "SY", "TY", "Final Year"}));
		t5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		t5.setBounds(222, 349, 195, 21);
		contentPane.add(t5);
		
		JComboBox t6 = new JComboBox();
		t6.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
		t6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		t6.setBounds(222, 413, 195, 21);
		contentPane.add(t6);
		
		JButton button = new JButton("Add");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PreparedStatement ps;
		           String query = "insert into student(name, roll, course, branch, year, sem) VALUES (?,?,?,?,?,?);";
		        
		        try {
		        	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
		            ps = conn.prepareStatement(query);
		            ps.setString(1, t1.getText());
		            ps.setString(2, t2.getText());
		            ps.setString(3, (String)t3.getSelectedItem());
		            ps.setString(4, (String)t4.getSelectedItem());
		            ps.setString(5, (String)t5.getSelectedItem());
		            ps.setString(6, (String)t6.getSelectedItem());
		            
		            int rs=ps.executeUpdate();
		            if(rs>0)
		            {
		            	JOptionPane.showMessageDialog(null, "Student Added!");
		            }
		            else
		            {
		            	JOptionPane.showMessageDialog(null, "Error");
		            	t1.setText("");
		            	t2.setText("");
		            	
		            	ps.close();
		            	
		            }
		        }catch(Exception e1)
		        {
		        	e1.printStackTrace();
		        }
			
	
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.setBounds(120, 482, 106, 30);
		contentPane.add(button);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new adminmenu().setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(396, 482, 106, 30);
		contentPane.add(btnBack);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 593, 522);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton button_1 = new JButton("Add");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrinterJob job=PrinterJob.getPrinterJob();
				job.setJobName("Print");
				
				job.setPrintable(new Printable()
						{
					public int print(Graphics pg,PageFormat pf, int pageNum)
					{
						if(pageNum>0)
						{
							return Printable.NO_SUCH_PAGE;
						}
						Graphics2D g=(Graphics2D)pg;
						g.translate(pf.getImageableX(), pf.getImageableY());
						g.scale(0.24, 0.24);
						
						panel.paint(g);
						return Printable.PAGE_EXISTS;
						
					}
						});
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_1.setBounds(452, 367, 106, 30);
		panel.add(button_1);
		
	}
}
