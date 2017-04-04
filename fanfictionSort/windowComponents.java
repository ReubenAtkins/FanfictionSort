package fanfictionSort;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.*;
import javax.swing.*;
public class windowComponents extends JFrame {
	JPanel mainPanel;
	JTextArea label1;
	JTextArea info;
	JScrollPane scroll;
	JButton urlB;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new windowComponents();

	}
	public windowComponents() {
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setTitle("Story Finder!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel = new JPanel();
		info = new JTextArea("Data will be here: \n", 20, 30);
		info.setLineWrap(true);
		info.setWrapStyleWord(true);
		info.setEditable(false);
		info.setSize(360, 350);
		//label1.setSize(100, 10);
		Dimension d = new Dimension(10, 100);
		
		urlB = new JButton();
		urlB.setText("Get Story Information");
		//ListenForButton lForButton = new ListenForButton();
		//urlB.addActionListener(lForButton);
		scroll = new JScrollPane(info, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		label1 = new JTextArea("Insert category link from AOO", 1, 10);
		label1.setMinimumSize(d);
		//label1.setBackground(Color.WHITE);
		//mainPanel.setLayout(new BorderLayout());
		
		mainPanel.add(label1, BorderLayout.PAGE_START);
		mainPanel.add(urlB,  BorderLayout.PAGE_END);
		mainPanel.add(scroll, BorderLayout.CENTER);
		
		
		
		this.add(mainPanel);
		this.setVisible(true);
	}
	




}
