package assignment8;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class display extends JFrame {

	private JPanel contentPane;
	private JTextField search;
	private JButton btnSearchh;
	private JButton btnDelete;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					display frame = new display();
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
	
	
	public display() {
		setBackground(new Color(250, 240, 230));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 474);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book Details");
		lblNewLabel.setForeground(new Color(0, 0, 139));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(216, 10, 477, 50);
		contentPane.add(lblNewLabel);
		
		
		
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new adminmenu().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(101, 84, 109, 30);
		btnNewButton.setBackground(new Color(250, 240, 230));
		btnNewButton.setBorder(null);
		contentPane.add(btnNewButton);
		
		search = new JTextField();
		search.setBounds(216, 84, 395, 27);
		contentPane.add(search);
		search.setColumns(10);
		
		JScrollPane s=new JScrollPane();
		s.setBounds(79, 133, 771, 282);
		contentPane.add(s);
		
		btnSearchh = new JButton("Search");
		btnSearchh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PreparedStatement ps;
				JDialog.setDefaultLookAndFeelDecorated(true);
		           String query = "select * from book where concat(name, bookid) like ?";
		        
		        try {
		        	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
		            ps = conn.prepareStatement(query);
		       ps.setString(1, "%" + search.getText() + "%");
		            ResultSet rs=ps.executeQuery();
		            
		            table_1.setModel(DbUtils.resultSetToTableModel(rs));
		            rs.close();
		            
		            
		            
		        ps.close();
			}catch(Exception e1)
		        {
				e1.printStackTrace();
		        }
			}
		});
		btnSearchh.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearchh.setBorder(null);
		btnSearchh.setBackground(new Color(250, 240, 230));
		btnSearchh.setBounds(668, 84, 109, 30);
		contentPane.add(btnSearchh);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PreparedStatement ps;
				JDialog.setDefaultLookAndFeelDecorated(true);
		           String query = "delete from book where name ='" + search.getText()+ "'";
		        
		        try {
		        	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
		            ps = conn.prepareStatement(query);
		            int r=JOptionPane.showConfirmDialog(null, "Do you want to continue?","Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		          	
		            
		             if(r==JOptionPane.YES_OPTION)
		            {
		            	int rs=ps.executeUpdate();
		            	JOptionPane.showMessageDialog(null, "Deleted successfully");
		            }
		        ps.close();
			}catch(Exception e1)
		        {
				e1.printStackTrace();
		        }
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBorder(null);
		btnDelete.setBackground(new Color(250, 240, 230));
		btnDelete.setBounds(794, 84, 109, 30);
		contentPane.add(btnDelete);
		
		
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter()  {
		
		@Override
			public void mouseClicked(MouseEvent arg0)
			{
				int row=table_1.getSelectedRow();
				search.setText(table_1.getModel().getValueAt(row, 1).toString());
			}
		});
				
				
		table_1.setBackground(new Color(240, 240, 255));
		
		
		s.setViewportView(table_1);
	}
}
