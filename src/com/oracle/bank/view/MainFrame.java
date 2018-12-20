package com.oracle.bank.view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
	private int width=500;
	private int height=300;
	private JLabel logo,usernameinfo,moneyinfo;
	private JTextField  username;
	private JPasswordField  password;
	private JButton  login,exit;
	private Account a;

	public MainFrame(Account a) {
		this.a=a;
		this.setTitle("中国农业很行ATM-主页");
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		initComponent();
		this.paintAll(getGraphics());
	}
	public void initComponent() {
		logo=new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().createImage("source/logo.jpeg").getScaledInstance(width, 100, Image.SCALE_DEFAULT)));
		logo.setBorder(BorderFactory.createLineBorder(Color.black));
		logo.setBounds(0, 0, width, 100);
		this.add(logo);

		usernameinfo=new JLabel("您的卡号:"+a.getAccNo()+",欢迎您："+a.getRealname()+",您的余额:"+a.getMoney()+"RMB");
		usernameinfo.setBounds(20,140,460,20);
		this.add(usernameinfo);

//		login=new JButton("登录");
//		login.setBounds(150, 220, 60, 20);
//		this.add(login);
//		exit=new JButton("退卡");
//		exit.setBounds(250, 220, 60, 20);
//		this.add(exit);
	}
	public static void main(String[] args) {
//		new MainFrame();
	}

}
