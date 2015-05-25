package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GameListener extends JFrame implements ActionListener {
	JButton button1;
	JButton button2;
	JButton eingabe;
	JLabel label;
	JPanel panel;

	public GameListener() {
		this.setTitle("Willkommen bei Kniffel!");
		this.setSize(400, 200);

		panel = new JPanel();
		label = new JLabel();

		button1 = new JButton("Spielen");
		button2 = new JButton("Beenden");
		eingabe = new JButton("OK");

		button1.addActionListener(this);
		button2.addActionListener(this);
		eingabe.addActionListener(this);

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
			JPanel spielerPanel = new JPanel();

			JFrame spielerAnzahl = new JFrame();
			spielerAnzahl.setTitle("Spieleranzahl");
			spielerAnzahl.setSize(550, 100);

			JLabel spieler = new JLabel(
					"Wieviele menschliche Spieler möchten mitspielen?");
			spielerPanel.add(spieler);

			JRadioButton auswahl1 = new JRadioButton("1");
			JRadioButton auswahl2 = new JRadioButton("2");
			JRadioButton auswahl3 = new JRadioButton("3");
			JRadioButton auswahl4 = new JRadioButton("4");
			JRadioButton auswahl5 = new JRadioButton("5");
			JRadioButton auswahl6 = new JRadioButton("6");

			ButtonGroup gruppe = new ButtonGroup();
			gruppe.add(auswahl1);
			gruppe.add(auswahl2);
			gruppe.add(auswahl3);
			gruppe.add(auswahl4);
			gruppe.add(auswahl5);
			gruppe.add(auswahl6);

			spielerPanel.add(auswahl1);
			spielerPanel.add(auswahl2);
			spielerPanel.add(auswahl3);
			spielerPanel.add(auswahl4);
			spielerPanel.add(auswahl5);
			spielerPanel.add(auswahl6);
			spielerPanel.add(eingabe);
			spielerPanel.add(button2);

			spielerAnzahl.add(spielerPanel);
			spielerAnzahl.setVisible(true);

		} else if (bt.getSource() == this.button2) {
			System.exit(0);
		} else if (bt.getSource() == this.eingabe) {
			System.exit(0);

		}

	}

}
