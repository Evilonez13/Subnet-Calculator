package com.tjbenator;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI {
	public Calculate Cal = new Calculate();
	private JFrame MyJFrame;
	
	private JPanel MyJPanel;
	protected JTextField IpAdd;
	protected JTextField Subnet;
	protected JButton enter;
	
	private JPanel MyInformation;
	protected JLabel MessageLabel;
	protected JLabel Message;
	protected JLabel NetworkLabel;
	protected JLabel Network;
	protected JLabel BroadcastAddLabel;
	protected JLabel BroadcastAdd;
	protected JLabel FirstIpAddLabel;
	protected JLabel FirstIpAdd;
	protected JLabel LastIpAddLabel;
	protected JLabel LastIpAdd;
	protected JLabel WildCardLabel;
	protected JLabel WildCard;
	
	
	public void MyFrame() {
		MyJFrame = new JFrame("Subnet Calculator");
		MyJFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("img/binary.png"));

		MainPanel();
		InformationPanel();

		// Add the panel to the frame.
		MyJFrame.getContentPane().add(MyJPanel, BorderLayout.NORTH);
		MyJFrame.getContentPane().add(MyInformation, BorderLayout.CENTER);

		// Exit when the window is closed.
		MyJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MyJFrame.pack();
		MyJFrame.setVisible(true);

	}
	
	private void MainPanel() {
		Icon EnterIcon = new ImageIcon("img/enter.png");
		MyJPanel = new JPanel();
		MyJPanel.setLayout(new FlowLayout());
		
		IpAdd = new JTextField("192.168.0.1", 20);
		Subnet = new JTextField("255.255.255.64", 20);
		enter = new JButton("Enter");
		enter.setIcon(EnterIcon);
		enter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (IpAdd.getText().matches(".*[0-9]+.*")) {
					Message.setText("Results!");
					Cal.clearMessage();
					String IP = IpAdd.getText();
					String Netmask = Subnet.getText();
					Cal.setIP(IP);
					Cal.setSubnet(Netmask);
					Cal.init();
					Message.setText(Cal.getMessage());
					Subnet.setText(Cal.getSubnet());
					Network.setText(Cal.getNetwork());
					BroadcastAdd.setText(Cal.getBroadcast());
					FirstIpAdd.setText(Cal.getFirstadd());
					LastIpAdd.setText(Cal.getLastadd());
					WildCard.setText(Cal.getWildcard());
				}			
				
			}
		});
		MyJPanel.add(IpAdd);
		MyJPanel.add(Subnet);
		MyJPanel.add(enter);
	}
	
	private void InformationPanel() {
		MyInformation = new JPanel();
		MyInformation.setLayout(new GridLayout(6, 2));
		
		MessageLabel = new JLabel("Message:");
		NetworkLabel = new JLabel("Network:");
		FirstIpAddLabel = new JLabel("First IP:");
		LastIpAddLabel = new JLabel("Last IP:");
		BroadcastAddLabel = new JLabel("Broadcast Address:");
		WildCardLabel = new JLabel("Wildcard:");
		
		Message = new JLabel("");
		Network = new JLabel("");
		FirstIpAdd = new JLabel("");
		LastIpAdd = new JLabel("");
		BroadcastAdd = new JLabel("");
		WildCard = new JLabel("");
		
		MyInformation.add(MessageLabel);
		MyInformation.add(Message);
		
		MyInformation.add(NetworkLabel);
		MyInformation.add(Network);
		
		MyInformation.add(FirstIpAddLabel);
		MyInformation.add(FirstIpAdd);
		
		MyInformation.add(LastIpAddLabel);
		MyInformation.add(LastIpAdd);
		
		MyInformation.add(BroadcastAddLabel);
		MyInformation.add(BroadcastAdd);
		
		MyInformation.add(WildCardLabel);
		MyInformation.add(WildCard);
	}
	
}
