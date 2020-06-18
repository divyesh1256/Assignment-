package assignment8;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class adminmenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminmenu frame = new adminmenu();
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
	public adminmenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1135, 726);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("E-Library");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(45, 43, 1018, 43);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "Are you sure you want to log out from the session?");
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(946, -3, 76, 23);
		btnNewButton.setBorder(null);
		contentPane.add(btnNewButton);
		
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExit.setBounds(1045, 0, 76, 17);
		btnExit.setBorder(null);
		contentPane.add(btnExit);
		
		JButton btnAddBooks = new JButton("Add Books");
		btnAddBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new addbook().setVisible(true);
				dispose();
			}
		});
		btnAddBooks.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAddBooks.setBorder(null);
		btnAddBooks.setBounds(105, 253, 181, 48);
		contentPane.add(btnAddBooks);
		
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new addstudent().setVisible(true);
				dispose();
			}
		});
		btnAddStudent.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAddStudent.setBorder(null);
		btnAddStudent.setBounds(771, 253, 181, 48);
		contentPane.add(btnAddStudent);
		
		JButton btnIssueBook = new JButton("Issue Book");
		btnIssueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new issue().setVisible(true);
				dispose();
			}
		});
		btnIssueBook.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnIssueBook.setBorder(null);
		btnIssueBook.setBounds(105, 481, 181, 48);
		contentPane.add(btnIssueBook);
		
		JButton btnReturnBook = new JButton("Return Book");
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new returnbook().setVisible(true);
				dispose();
			}
		});
		btnReturnBook.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReturnBook.setBorder(null);
		btnReturnBook.setBounds(771, 481, 181, 48);
		contentPane.add(btnReturnBook);
		
		JButton btnDiplayAllBooks = new JButton("Display Books");
		btnDiplayAllBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new display().setVisible(true);
				dispose();
			}
		});
		btnDiplayAllBooks.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDiplayAllBooks.setBorder(null);
		btnDiplayAllBooks.setBounds(455, 481, 181, 48);
		contentPane.add(btnDiplayAllBooks);
		
	}
}
