package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import logic.*;

public class NameTextListener extends JFrame implements ActionListener {

	JFrame nameFrame;
	JPanel namePanel;
	JLabel nameLabel;
	JButton ok;
	JButton abbruch;

	public NameTextListener() {
		this.setTitle("Name");
		this.setSize(300, 100);

		JTextField tfName = new JTextField("", 15);
		tfName.setForeground(Color.BLUE);
		tfName.setBackground(Color.CYAN);
		namePanel.add(tfName);
		namePanel.add(new Label("" + tfName.getText()));

		//Spieler spieler = new MenschlicheSpieler("" + tfName.getText());
		this.add(namePanel);

	}

	@Override
	public void actionPerformed(ActionEvent but) {

		if (but.getSource() == this.ok) {
			
			

		} else if (but.getSource() == this.abbruch) {

		}

	}

}
