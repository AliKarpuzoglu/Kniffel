package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GameListener extends JFrame implements ActionListener {
	JButton button1;
	JButton button2;
	JLabel label;
	JPanel panel;

	public GameListener() {
		this.setTitle("Willkommen bei Kniffel!");
		this.setSize(400, 200);

		panel = new JPanel();
		label = new JLabel();

		button1 = new JButton("Spielen");
		button2 = new JButton("Beenden");

		button1.addActionListener(this);
		button2.addActionListener(this);

		panel.add(new JLabel("Willkommen bei Kniffel!"));
		panel.add(button1);
		panel.add(button2);

		panel.add(label);
		this.add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent bt) {
		if (bt.getSource() == this.button1) {
			label.setText("Spiel startet jetzt!");

			SpielerListener sp = new SpielerListener();
			sp.setVisible(true);
		} else if (bt.getSource() == this.button2) {
			System.exit(0);
		}

	}

}
