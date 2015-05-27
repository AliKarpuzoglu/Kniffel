package gui;

import java.awt.Color;
import java.awt.event.WindowAdapter;

import javax.swing.*;

import logic.Spieler;
import logic.Wurf;

public class SwingClass {
	JFrame spielerNamen = new JFrame("Spieler");
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JButton spielenButton = new JButton("Spielen");
	JButton abbruch = new JButton("Beenden");

	// Für Computer Spieler
	JFrame compFrame;
	JPanel compPanel;
	JLabel compLabel;
	JButton Spielen = new JButton("Spielen!");
	JButton auswahl1;
	JButton auswahl2;
	JButton auswahl3;
	JButton auswahl4;
	JButton auswahl5;

	// Für Menschliche Spieler Eingabe
	JFrame nameFrame;
	JPanel namePanel;
	JLabel nameLabel;
	JButton ok;
	JTextField tfName;

	// Für Menschliche Spieler Auswahl
	JButton auswahlS1;
	JButton auswahlS2;
	JButton auswahlS3;
	JButton auswahlS4;
	JButton auswahlS5;
	JButton auswahlS6;
	JFrame spielerFrame;
	JPanel spielerPanel;
	JLabel labelS;

	public void printReihenfolge(Spieler[] spieler) {

		for (int i = 0; i < spieler.length; i++) {
			panel.add(new JLabel(" " + spieler[i]));
		}
		panel.add(spielenButton);
		panel.add(abbruch);
		abbruch.addActionListener((e) -> System.exit(0));
		spielenButton.addActionListener((e) -> label
				.setText("Spiel startet jetzt!"));
		spielerNamen.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.exit(0);
			};
		});
		spielerNamen.pack();

		spielerNamen.setVisible(true);

	}

	public void printSpielerNamen() {

	}

	public void printComputerSpielerDialog() {
		compFrame = new JFrame("Computer Spieler");
		compPanel = new JPanel();
		compLabel = new JLabel();

		auswahl1 = new JButton("1");
		auswahl2 = new JButton("2");
		auswahl3 = new JButton("3");
		auswahl4 = new JButton("4");
		auswahl5 = new JButton("5");

		auswahl1.addActionListener((e) -> compPanel.add(new JLabel(
				"Ein Computer Spieler spielt jetzt mit.")));
		auswahl2.addActionListener((e) -> compPanel.add(new JLabel(
				"Zwei Computer Spieler spielt jetzt mit.")));
		auswahl3.addActionListener((e) -> compPanel.add(new JLabel(
				"Drei Computer Spieler spielt jetzt mit.")));
		auswahl4.addActionListener((e) -> compPanel.add(new JLabel(
				"Vier Computer Spieler spielt jetzt mit.")));
		auswahl5.addActionListener((e) -> compPanel.add(new JLabel("Fünf")));
		abbruch.addActionListener((e) -> System.exit(0));

		compPanel
				.add(new JLabel("Wieviele Computer Spieler sollen mitspielen?"));
		compPanel
				.add(new JLabel("Es können maximal nur 6 Spieler teilnehmen."));
		compPanel.add(auswahl1);
		compPanel.add(auswahl2);
		compPanel.add(auswahl3);
		compPanel.add(auswahl4);
		compPanel.add(auswahl5);
		compPanel.add(abbruch);

		compPanel.add(compLabel);
		compFrame.add(compPanel);
		compFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.exit(0);
			};
		});
		compFrame.pack();
		compFrame.setVisible(true);

	}

	public void printSpielerdialog() {

		namePanel = new JPanel();
		nameLabel = new JLabel();
		nameFrame = new JFrame("Name");

		namePanel.add(new JLabel("Wählen Sie einen Spielernamen: "));
		tfName = new JTextField("", 15);
		tfName.setForeground(Color.BLUE);
		tfName.setBackground(Color.CYAN);
		namePanel.add(tfName);

		ok = new JButton("OK");
		abbruch.addActionListener((e) -> System.exit(0));
		ok.addActionListener((e) -> namePanel.add(new JLabel(""
				+ tfName.getText())));

		namePanel.add(ok);
		namePanel.add(abbruch);
		namePanel.add(nameLabel);
		nameFrame.add(namePanel);
		nameFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.exit(0);
			};
		});
		nameFrame.pack();

		nameFrame.setVisible(true);

	}

	public void printWelcome() {

		JFrame willkommen = new JFrame("Willkommen zu Kniffel!");
		JPanel jP = new JPanel();
		JButton jB = new JButton("Spielen!");

		jP.add(new JLabel(
				"Die Gruppe um Jonas Jaeckel wuenscht ihnen ein erfreuliches Spiel!"));
		jP.add(jB);
		jP.add(abbruch);
		willkommen.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.exit(0);
			};
		});

		willkommen.add(jP);
		willkommen.pack();
		willkommen.setVisible(true);

	}

	public void printWurf(Wurf wurf) {

	}

	public void printErgebnisspalte(Spieler spieler) {

	}

	public void printMSpielerAuswahl() {
		spielerFrame = new JFrame("Spieleranzahl");
		spielerPanel = new JPanel();
		labelS = new JLabel();

		auswahlS1 = new JButton("1");
		auswahlS2 = new JButton("2");
		auswahlS3 = new JButton("3");
		auswahlS4 = new JButton("4");
		auswahlS5 = new JButton("5");
		auswahlS6 = new JButton("6");

		auswahlS1.addActionListener((e) -> labelS.setText(("1 Spieler")));
		auswahlS2.addActionListener((e) -> labelS.setText(("2 Spieler")));
		auswahlS3.addActionListener((e) -> labelS.setText(("3 Spieler")));
		auswahlS4.addActionListener((e) -> labelS.setText(("4 Spieler")));
		auswahlS5.addActionListener((e) -> labelS.setText(("5 Spieler")));
		auswahlS6.addActionListener((e) -> labelS.setText(("6 Spieler")));
		abbruch.addActionListener((e) -> System.exit(0));
		spielerFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.exit(0);
			};
		});

		spielerPanel.add(new JLabel(
				"Wieviele menschliche Spieler möchten mitspielen?"));
		spielerPanel.add(auswahlS1);
		spielerPanel.add(auswahlS2);
		spielerPanel.add(auswahlS3);
		spielerPanel.add(auswahlS4);
		spielerPanel.add(auswahlS5);
		spielerPanel.add(auswahlS6);
		spielerPanel.add(abbruch);

		spielerPanel.add(label);
		spielerFrame.add(spielerPanel);
		spielerFrame.pack();

	}
}
