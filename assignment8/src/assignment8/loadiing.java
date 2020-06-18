package assignment8;


import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;
import java.sql.*;

public class loadiing extends JFrame implements Runnable {
	//public void actionPerformed(ActionEvent e) {}
	
	private JPanel contentPane;
	private JProgressBar progressBar;
	int s;
	Thread th;
	
	public static void main(String args[])
	{
		new loadiing().setVisible(true);
	}
	
	public void setUploading()
	{
		setVisible(true);
		th.start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try
		{
			for(int i=0;i<200;i++)
			{
				s=s+1;
				int m=progressBar.getMaximum();
				int v=progressBar.getValue();
				if(v<m)
				{
					progressBar.setValue(progressBar.getValue()+1);
				}
				else
				{
					i=201;
					setVisible(false);
					new adminmenu().setVisible(true);
				}
				Thread.sleep(50);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
	}
	public loadiing()
	{
		super("Loading");
		th=new Thread((Runnable) this);
		
		setBounds(600, 300, 600, 400);
		contentPane=new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l=new JLabel("E Library Management");
		l.setForeground(new Color(72, 209, 204));
		l.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
		l.setBounds(130, 46, 500, 35);
		contentPane.add(l);
		
		progressBar=new JProgressBar();
		progressBar.setFont(new Font("Tahoma", Font.BOLD, 12));
		progressBar.setStringPainted(true);
		progressBar.setBounds(130, 135, 300, 25);
		contentPane.add(progressBar);
		
		JLabel ll=new JLabel("Please Wait..............");
		ll.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		ll.setForeground(new Color(160, 82, 45));
		ll.setBounds(200, 165, 150, 20);
		contentPane.add(ll);
		
		JPanel panel=new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 590, 390);
		contentPane.add(panel);
		
		setUploading();
	}

}
