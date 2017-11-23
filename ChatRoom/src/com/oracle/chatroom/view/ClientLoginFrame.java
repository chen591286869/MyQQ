package com.oracle.chatroom.view;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.oracle.chatroom.control.Client;

public class ClientLoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel;
	private Client c;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientLoginFrame frame = new ClientLoginFrame();
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
	public ClientLoginFrame() {
		setTitle("客户端登陆界面");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(107, 22, 192, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(107, 70, 192, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		for(int n=97;n<138;n++)
		{
			comboBox.addItem(n+".gif");
		}
		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				String  pathName=e.getItem().toString();
				System.out.println(pathName);
				lblNewLabel.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage("sources/images/"+pathName).getScaledInstance(93, 112, Image.SCALE_DEFAULT)));
			}
		});
		comboBox.setBounds(107, 116, 192, 21);
		contentPane.add(comboBox);
		
		JLabel lblIp = new JLabel("IP地址");
		lblIp.setBounds(26, 25, 54, 15);
		contentPane.add(lblIp);
		
		JLabel label = new JLabel("昵称");
		label.setBounds(26, 73, 54, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("头像");
		label_1.setBounds(26, 119, 54, 15);
		contentPane.add(label_1);
		
		JButton button = new JButton("登陆");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 c=new Client();
				 Boolean result= c.connectServer();
				 JOptionPane.showMessageDialog(ClientLoginFrame.this, (result?"链接成功":"链接失败"), "温馨提示", (result?JOptionPane.INFORMATION_MESSAGE:JOptionPane.ERROR_MESSAGE), new ImageIcon("sources/images/97.gif"));
			}
		});
		button.setBounds(175, 206, 93, 23);
		contentPane.add(button);
		
		 lblNewLabel = new JLabel();
		 lblNewLabel.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage("sources/images/97.gif").getScaledInstance(93, 112, Image.SCALE_DEFAULT)));
		lblNewLabel.setBounds(329, 25, 93, 112);
		contentPane.add(lblNewLabel);
	}
}
