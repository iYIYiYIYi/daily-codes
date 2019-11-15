package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JSlider;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class appGUI_Design extends JFrame {
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					appGUI_Design frame = new appGUI_Design();
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
	public appGUI_Design() {
		getContentPane().setForeground(Color.WHITE);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(14, 125, 225, 53);
		getContentPane().add(panel_2);
		
		JLabel lblChooseWhatYou = new JLabel("\u4F60\u8981\u5E72\u4EC0\u4E48\uFF1A");
		lblChooseWhatYou.setFont(new Font("Yu Gothic UI", Font.BOLD, 32));
		panel_2.add(lblChooseWhatYou);
		JButton btnServer = new JButton("\u63A5\u6536");
		btnServer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Server server = new Server();
				server.serverpanel();
			}
		});
		btnServer.setBounds(253, 191, 225, 53);
		getContentPane().add(btnServer);
		
		JButton btnTerminal = new JButton("\u53D1\u9001");
		btnTerminal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Terminal terminal = new Terminal();
				Terminal.terminalpanel();
			}
		});
		btnTerminal.setBounds(14, 191, 225, 53);
		getContentPane().add(btnTerminal);
		
		JLabel label = new JLabel("\u6CE8\u610F\uFF1A\u53D1\u9001\u6587\u4EF6\u65F6\u8BF7\u5148\u786E\u4FDD\u63A5\u6536\u7AEF\u8FD0\u884C\u6B63\u5E38");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(UIManager.getFont("FileChooser.listFont"));
		label.setBounds(15, 15, 464, 97);
		getContentPane().add(label);
		btnTerminal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnServer.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
			}
		});
		setTitle("File Transfer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 326);
	}
}
