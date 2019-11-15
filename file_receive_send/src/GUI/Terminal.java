package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import file_receive_send.File_receive;
import file_receive_send.File_send;

import java.awt.GridLayout;
import javax.swing.JEditorPane;
import javax.swing.JTree;
import java.awt.GridBagLayout;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Terminal extends JFrame {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void terminalpanel() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Terminal frame = new Terminal();
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
	public Terminal() {
		setTitle("terminal");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 309, 223);
		getContentPane().setLayout(null);
		
		
		textField = new JTextField();
	    textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 textField.getText();
			}
		});
		
			
		textField.setBounds(14, 30, 258, 27);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPleaseEnterYour = new JLabel("IP\u5730\u5740\uFF1A");
		lblPleaseEnterYour.setBounds(14, 13, 258, 18);
		getContentPane().add(lblPleaseEnterYour);
		
		JLabel label = new JLabel("\u6587\u4EF6\u4F4D\u7F6E\uFF1A");
		label.setBounds(14, 59, 99, 18);
		getContentPane().add(label);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.setBounds(159, 123, 113, 27);
		getContentPane().add(button);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				System.out.println(textField.getText() +" "+ textField_1.getText());
				String ip = textField.getText();
				try {
					File_send term = new File_send(ip);
					term.path=textField_1.getText();
					term.FileSend();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		textField_1 = new JTextField();
		textField_1.setBounds(14, 78, 258, 27);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
	}
}
