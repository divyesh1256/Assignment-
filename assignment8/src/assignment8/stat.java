package assignment8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;

public class stat extends JFrame {

	private JPanel contentPane;
	private JTable table2;
	private JTable table22;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stat frame = new stat();
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
	public void issuebook()
	{
		PreparedStatement ps;
		JDialog.setDefaultLookAndFeelDecorated(true);
        String query = "select * from issue";
     
     try {
     	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
       ps=conn.prepareStatement(query);
       ResultSet rs=ps.executeQuery();
       table2.setModel(DbUtils.resultSetToTableModel(rs));

       rs.close();
	}
     catch(Exception e1)
     {
     	e1.printStackTrace();
     }
	
	}
	
	public void returnbook()
	{
		PreparedStatement ps;
		JDialog.setDefaultLookAndFeelDecorated(true);
        String query = "select * from returnbook";
     
     try {
     	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
       ps=conn.prepareStatement(query);
       ResultSet rs=ps.executeQuery();
       table22.setModel(DbUtils.resultSetToTableModel(rs));
rs.close();
       
	}
     catch(Exception e1)
     {
     	e1.printStackTrace();
     }
	}
	
	public stat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1224, 685);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane s=new JScrollPane();
		s.setBounds(40, 51, 708, 217);
		contentPane.add(s);
		
		JTable table2 =new JTable();
		table2.setBackground(new Color(224, 255, 255));
		table2.setForeground(new Color(128, 128, 0));
		table2.setFont(new Font("Tahoma", Font.BOLD, 15));
		s.setViewportView(table2);
		
		JScrollPane s1=new JScrollPane();
		s1.setBounds(40, 316, 717, 217);
		contentPane.add(s1);
		
		JTable table22 =new JTable();
		table22.setBackground(new Color(204, 255, 255));
		table22.setForeground(new Color(153, 51, 0));
		table22.setFont(new Font("Tahoma", Font.BOLD, 12));
		s1.setViewportView(table22);
		
		issuebook();
		returnbook();
		
	}
}
