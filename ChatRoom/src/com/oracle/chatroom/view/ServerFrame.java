package com.oracle.chatroom.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.oracle.chatroom.control.Server;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class ServerFrame extends JFrame {

	private JPanel contentPane;
	private Server  s;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerFrame frame = new ServerFrame();
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
	public ServerFrame() {
		setTitle("聊天室服务器端");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 textArea = new JTextArea();
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(10, 10, 657, 231);
		contentPane.add(scrollPane);
		
		
		JButton btnNewButton = new JButton("Start server");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s=new Server();
				boolean startResult=s.startServer();
				System.out.println(startResult);
				textArea.append(new Date().toLocaleString()+":\t服务器启动"+(startResult?"成功":"失败")+"!\r\n");
				JOptionPane.showMessageDialog(ServerFrame.this, startResult?"启动成功了":"启动失败了", "温馨提示", startResult?JOptionPane.INFORMATION_MESSAGE:JOptionPane.ERROR_MESSAGE);
			}
		});
		btnNewButton.setBounds(132, 345, 145, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Close server");
		btnNewButton_1.setBounds(373, 345, 137, 23);
		contentPane.add(btnNewButton_1);
	}
}
