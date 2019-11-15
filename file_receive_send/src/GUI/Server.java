package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import file_receive_send.File_receive;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Server extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 * @return 
	 */
	public void serverpanel() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server frame = new Server();
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
	public Server() {
		setTitle("Server");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(14, 13, 404, 48);
		contentPane.add(panel);
		
		JLabel lblPleaseEnterYour = new JLabel("文件存储位置：");
		lblPleaseEnterYour.setFont(new Font("黑体", Font.PLAIN, 20));
		panel.add(lblPleaseEnterYour);
		
		textField = new JTextField();
		textField.setBounds(14, 74, 404, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			private File_receive server;

			public void actionPerformed(ActionEvent arg0) {
				System.out.println(textField.getText());
				try {
					server = new File_receive();
					server.Path = textField.getText();
					server.load();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button.setBounds(305, 153, 113, 27);
		contentPane.add(button);
	}
}
