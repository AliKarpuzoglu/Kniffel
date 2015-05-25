package gui;

import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import logic.*;

import javax.swing.*;

public class SpielerListener extends JFrame implements ActionListener {
	JButton abbruch = new JButton("Beenden");
	JButton auswahl1;
	JButton auswahl2;
	JButton auswahl3;
	JButton auswahl4;
	JButton auswahl5;
	JButton auswahl6;
	JFrame spielerFrame;
	JPanel spielerPanel;
	JLabel label;

	public SpielerListener() {
		this.setTitle("Spieleranzahl");
		this.setSize(600, 100);

		spielerFrame = new JFrame();
		spielerPanel = new JPanel();
		label = new JLabel();

		auswahl1 = new JButton("1");
		auswahl2 = new JButton("2");
		auswahl3 = new JButton("3");
		auswahl4 = new JButton("4");
		auswahl5 = new JButton("5");
		auswahl6 = new JButton("6");

		auswahl1.addActionListener(this);
		auswahl2.addActionListener(this);
		auswahl3.addActionListener(this);
		auswahl4.addActionListener(this);
		auswahl5.addActionListener(this);
		auswahl6.addActionListener(this);
		abbruch.addActionListener(this);

		ButtonGroup gruppe = new ButtonGroup();
		gruppe.add(auswahl1);
		gruppe.add(auswahl2);
		gruppe.add(auswahl3);
		gruppe.add(auswahl4);
		gruppe.add(auswahl5);
		gruppe.add(auswahl6);

		spielerPanel.add(new JLabel(
				"Wieviele menschliche Spieler möchten mitspielen?"));
		spielerPanel.add(auswahl1);
		spielerPanel.add(auswahl2);
		spielerPanel.add(auswahl3);
		spielerPanel.add(auswahl4);
		spielerPanel.add(auswahl5);
		spielerPanel.add(auswahl6);
		spielerPanel.add(abbruch);

		spielerPanel.add(label);
		this.add(spielerPanel);
	}

	@Override
	public void actionPerformed(ActionEvent jrb) {

		if (jrb.getSource() == this.auswahl1) {
			label.setText(("1 Spieler"));

		} else if (jrb.getSource() == this.auswahl2) {
			label.setText(("2 Spieler"));

		} else if (jrb.getSource() == this.auswahl3) {
			label.setText(("3 Spieler"));

		} else if (jrb.getSource() == this.auswahl4) {
			label.setText(("4 Spieler"));

		} else if (jrb.getSource() == this.auswahl5) {
			label.setText(("5 Spieler"));

		} else if (jrb.getSource() == this.auswahl6) {
			label.setText(("6 Spieler"));

		} else if (jrb.getSource() == this.abbruch) {
			System.exit(0);
		}

	}
}
