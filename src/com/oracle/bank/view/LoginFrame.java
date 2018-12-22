package com.oracle.bank.view;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import javax.sql.DataSource;
import javax.swing.*;

public class LoginFrame extends JFrame {
	private int width=500;
	private int height=300;
	private JLabel logo,usernameLabel,passwordLabel;
	private JTextField  username;
	private JPasswordField  password;
	private JButton  login,exit;

	public LoginFrame() {
		this.setTitle("�й�ũҵ����ATM-��¼");
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

		usernameLabel=new JLabel("�����˻�:");
		usernameLabel.setBounds(50, 140, 100, 20);
		this.add(usernameLabel);
		username=new JTextField();
		username.setBounds(180, 140, 200, 20);
		this.add(username);

		passwordLabel=new JLabel("�˻�����:");
		passwordLabel.setBounds(50, 180, 100, 20);
		this.add(passwordLabel);
		password=new JPasswordField();
		password.setBounds(180, 180, 200, 20);
		this.add(password);

		login=new JButton("��¼");
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//1.��ȡ��������������п�������
				String accountNO=username.getText();
				String accountPass=password.getText();
				//2.ʹ��jdbc�������ݿ��ѯ����˻����������Ƿ����
				try{
					Properties  pros=new Properties();
					pros.load(new FileInputStream("source/datasourcepool.properties"));
					DataSource  source=BasicDataSourceFactory.createDataSource(pros);
					Connection c=source.getConnection();

//					Connection  c= DriverManager.getConnection("jdbc:oracle:thin:@172.19.22.104:1521:XE","test","test");
					PreparedStatement pre=c.prepareStatement("select * from ACCOUNT where ACCNO=? and ACCPASS=?");
					pre.setString(1,accountNO);
					pre.setString(2,accountPass);
					ResultSet rs=pre.executeQuery();
					ResultSetMetaData metaData=rs.getMetaData();
					if(rs.next()){

						Account  a=new Account();
						a.setAccNo(rs.getString("accNo"));
						a.setAccPass(rs.getString("accPass"));
						a.setRealname(rs.getString("realname"));
						a.setSex(rs.getString("sex"));
						a.setMoney(rs.getFloat("money"));

						MainFrame  m=new MainFrame(a);
						LoginFrame.this.dispose();
					}else{
						JOptionPane.showMessageDialog(LoginFrame.this,"�˺Ż����벻�ԣ�","��ܰ��ʾ",JOptionPane.INFORMATION_MESSAGE);
					}
				}catch (Exception ee){
					ee.printStackTrace();
				}
			}
		});
		login.setBounds(150, 220, 60, 20);
		this.add(login);
		exit=new JButton("�˿�");
		exit.setBounds(250, 220, 60, 20);
		this.add(exit);
	}
	public static void main(String[] args) {
		new LoginFrame();
	}

}
