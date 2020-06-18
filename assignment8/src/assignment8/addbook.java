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
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class addbook extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t6;
	private JTextField t7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addbook frame = new addbook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void random()
	{
		Random rd=new Random();
		t1.setText("" + rd.nextInt(1000+1));
		t1.setEditable(false);
	}

	/**
	 * Create the frame.
	 */
	public addbook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(119, 96, 77, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(119, 138, 77, 24);
		contentPane.add(lblName);
		
		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIsbn.setBounds(119, 183, 77, 24);
		contentPane.add(lblIsbn);
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPublisher.setBounds(119, 229, 77, 24);
		contentPane.add(lblPublisher);
		
		JLabel lblEdition = new JLabel("Edition");
		lblEdition.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEdition.setBounds(119, 278, 77, 24);
		contentPane.add(lblEdition);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrice.setBounds(119, 328, 77, 24);
		contentPane.add(lblPrice);
		
		JLabel lblPages = new JLabel("Pages");
		lblPages.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPages.setBounds(119, 380, 77, 24);
		contentPane.add(lblPages);
		
		JLabel lblAddBooks = new JLabel("Add Books");
		lblAddBooks.setForeground(new Color(0, 0, 139));
		lblAddBooks.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddBooks.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddBooks.setBounds(107, 25, 269, 30);
		contentPane.add(lblAddBooks);
		
		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.BOLD, 13));
		t1.setBounds(248, 101, 158, 19);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setFont(new Font("Tahoma", Font.BOLD, 13));
		t2.setColumns(10);
		t2.setBounds(248, 141, 158, 19);
		contentPane.add(t2);
		
		t3 = new JTextField();
		t3.setFont(new Font("Tahoma", Font.BOLD, 13));
		t3.setColumns(10);
		t3.setBounds(248, 188, 158, 19);
		contentPane.add(t3);
		
		t4 = new JTextField();
		t4.setFont(new Font("Tahoma", Font.BOLD, 13));
		t4.setColumns(10);
		t4.setBounds(248, 234, 158, 19);
		contentPane.add(t4);
		
		t6 = new JTextField();
		t6.setFont(new Font("Tahoma", Font.BOLD, 13));
		t6.setColumns(10);
		t6.setBounds(248, 328, 158, 19);
		contentPane.add(t6);
		
		t7 = new JTextField();
		t7.setFont(new Font("Tahoma", Font.BOLD, 13));
		t7.setColumns(10);
		t7.setBounds(248, 385, 158, 19);
		contentPane.add(t7);
		
		JComboBox t5 = new JComboBox();
		t5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		t5.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
		t5.setBounds(248, 282, 158, 21);
		contentPane.add(t5);
		random();
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				PreparedStatement ps;
		           String query = "insert into book(bookid, name, isbn, publisher, edition, price, pages) VALUES (?,?,?,?,?,?,?);";
		        
		        try {
		        	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
		            ps = conn.prepareStatement(query);
		            ps.setString(1, t1.getText());
		            ps.setString(2, t2.getText());
		            ps.setString(3, t3.getText());
		            ps.setString(4, t4.getText());
		            ps.setString(5, (String)t5.getSelectedItem());
		            ps.setString(6, t6.getText());
		            ps.setString(7, t7.getText());
		            
		            int rs=ps.executeUpdate();
		            if(rs>0)
		            {
		            	JOptionPane.showMessageDialog(null, "Book Added!");
		            }
		            else
		            {
		            	JOptionPane.showMessageDialog(null, "Error");
		            	t1.setText("");
		            	t2.setText("");
		            	t3.setText("");
		            	t4.setText("");
		           
		            	t6.setText("");
		            	t7.setText("");
		            	ps.close();
		            	
		            }
		        }catch(Exception e1)
		        {
		        	e1.printStackTrace();
		        }
			}   
		});
		btnNewButton.setBounds(81, 447, 106, 30);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new adminmenu().setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(305, 447, 106, 30);
		contentPane.add(btnBack);
	}
}
