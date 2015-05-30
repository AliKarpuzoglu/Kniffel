package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.WindowAdapter;

import javax.swing.*;

import ergebnisse.Chance;
import ergebnisse.KleineStrasse;
import logic.Spieler;
import logic.Wurf;

public class SwingClass {
	GrundFrame spielerNamen = new GrundFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JButton spielenButton = new JButton("Spielen");
	JButton abbruch = new JButton("Beenden");

	// Für Computer Spieler
	GrundFrame compFrame;
	JPanel compPanel;
	JLabel compLabel;
	JButton Spielen = new JButton("Spielen!");
	JButton auswahl1;
	JButton auswahl2;
	JButton auswahl3;
	JButton auswahl4;
	JButton auswahl5;

	// Für Menschliche Spieler Eingabe
	GrundFrame nameFrame;
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
	GrundFrame spielerFrame;
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
		GrundFrame gf = new GrundFrame();

	}

	public void printComputerSpielerDialog() {
		compFrame = new GrundFrame();
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
		compFrame.showIt("Computer Spieler", 600, 400);

	}

	public void printSpielerdialog() {

		namePanel = new JPanel();
		nameLabel = new JLabel();
		nameFrame = new GrundFrame();

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

		nameFrame.showIt("Name", 600, 400);

	}

	public void printWelcome() {

		GrundFrame willkommen = new GrundFrame();
		JPanel jP = new JPanel();
		JButton jB = new JButton("Spielen!");

		jP.add(new JLabel(
				"Die Gruppe um Jonas Jaeckel wuenscht ihnen ein erfreuliches Spiel!"));
		jP.add(jB);
		jP.add(abbruch);
		abbruch.addActionListener((e) -> System.exit(0));
		willkommen.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.exit(0);
			};
		});

		willkommen.add(jP);
		willkommen.pack();
		willkommen.showIt("Willkommen zu Kniffel!", 600, 400);

	}

	public void printWurf(Wurf wurf) {

		GrundFrame grundF = new GrundFrame();
		JPanel colP = new javax.swing.JPanel();
		JPanel colP2 = new javax.swing.JPanel();

		JLabel compLabel = new JLabel("Wähle dein Ergebnis:");
		JButton einer = new JButton("10");
		JButton zweier = new JButton("20");
		JButton dreier = new JButton("30");
		JButton vierer = new JButton("40");
		JButton fünfer = new JButton("40");
		JButton sechser = new JButton("50");
		JButton drpasch = new JButton("60");
		JButton vipasch = new JButton("70");
		JButton qfolge = new JButton("30");
		JButton fullhouse = new JButton("35");
		JButton klstrasse = new JButton("50");
		JButton grstrasse = new JButton("45");
		JButton kniffel = new JButton("70");
		JButton chance = new JButton("30");

		colP2.add(compLabel, "North");
		colP.add(new JLabel("Einer"));
		colP2.add(einer);
		colP.add(new JLabel("Zweier"));
		colP2.add(zweier);
		colP.add(new JLabel("Dreier"));
		colP2.add(dreier);
		colP.add(new JLabel("Vierer"));
		colP2.add(vierer);
		colP.add(new JLabel("Fünfer"));
		colP2.add(fünfer);
		colP.add(new JLabel("Sechser"));
		colP2.add(sechser);
		colP.add(new JLabel("Dreierpasch"));
		colP2.add(drpasch);
		colP.add(new JLabel("Viererpasch"));
		colP2.add(vipasch);
		colP.add(new JLabel("Quadratfolge"));
		colP2.add(qfolge);
		colP.add(new JLabel("Full House"));
		colP2.add(fullhouse);
		colP.add(new JLabel("Kleine Straße"));
		colP2.add(klstrasse);
		colP.add(new JLabel("Große Straße"));
		colP2.add(grstrasse);
		colP.add(new JLabel("Kniffel"));
		colP2.add(kniffel);
		colP.add(new JLabel("Chance"));
		colP2.add(chance);
		grundF.getContentPane().add(compLabel, "North");
		grundF.getContentPane().add(colP, "Center");
		grundF.getContentPane().add(colP2, "South");
		grundF.setSize(900, 150);

		grundF.showIt("Buttons", 600, 400);

	}

	public void printErgebnisspalte(Spieler spieler) {

	}

	public void printMSpielerAuswahl() {
		spielerFrame = new GrundFrame();
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

		spielerPanel.add(labelS);
		spielerFrame.add(spielerPanel);
		spielerFrame.pack();

		spielerFrame.showIt("Spieleranzahl", 600, 400);
	}

	public void printErgebnistabelle() {
		GrundFrame gF = new GrundFrame();
		String[][] inhalt = { { "Einser", "0", "1", "2", "3", "4", "5" },
				{ "Zweier", "0", "2", "3", "4", "5", "6" },
				{ "Dreier", "0", "1", "2", "3", "4", "5" },
				{ "Vierer", "0", "1", "2", "3", "4", "5" },
				{ "Fünfer", "0", "1", "2", "3", "4", "5" },
				{ "Sechser", "0", "1", "2", "3", "4", "5" },
				{ "Dreierpasch", "0", "1", "2", "3", "4", "5" },
				{ "Viererpasch", "0", "1", "2", "3", "4", "5" },
				{ "Quadratfolge", "0", "1", "2", "3", "4", "5" },
				{ "Full House", "0", "1", "2", "3", "4", "5" },
				{ "Kleine Straße", "0", "1", "2", "3", "4", "5" },
				{ "Große Straße", "0", "1", "2", "3", "4", "5" },
				{ "Kniffel", "0", "1", "2", "3", "4", "5" },
				{ "Chance", "0", "1", "2", "3", "4", "5" }, };
		String[] spaltenNamen = { "Ergebnisse", "Spieler 1", "Spieler 2",
				"Spieler 3", "Spieler 4", "Spieler 5", "Spieler 6" };
		JTable jTab = new JTable(inhalt, spaltenNamen);
		JScrollPane sp = new JScrollPane(jTab);
		sp.setBackground(Color.yellow);

		jTab.setAutoResizeMode(0);
		jTab.setIntercellSpacing(new Dimension(8, 2));
		jTab.setGridColor(Color.black);

		gF.getContentPane().add(sp);
		gF.setSize(550, 325);

		gF.showIt("Ergebnistabelle", 600, 400);

	}

	public static void main(String[] args) {
		// printMSpielerAuswahl();

	}
}
