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

	String[] spieler = new String[6];
	int i = 0;

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
		nameLabel = new JLabel("Waehlen Sie einen Spielernamen: ");
		nameFrame = new GrundFrame();

		namePanel.add(nameLabel);
		tfName = new JTextField("", 15);
		tfName.setForeground(Color.BLUE);
		tfName.setBackground(Color.CYAN);
		namePanel.add(tfName);

		ok = new JButton("OK");
		ok.addActionListener((e) -> spieler[i] = tfName.getText());

		namePanel.add(ok);
		
		
		nameFrame.add(namePanel);
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
		jB.addActionListener((e) -> printMSpielerAuswahl());
		jB.addActionListener((e) -> willkommen.setVisible(false));
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

	public void printWurf() {

		GrundFrame grundF = new GrundFrame();
		JPanel colP = new javax.swing.JPanel();
		JPanel colP2 = new javax.swing.JPanel();

		JLabel compLabel = new JLabel("Waehle dein Ergebnis:");
		JButton einer = new JButton("");
		JButton zweier = new JButton("");
		JButton dreier = new JButton("");
		JButton vierer = new JButton("");
		JButton fuenfer = new JButton("");
		JButton sechser = new JButton("");
		JButton drpasch = new JButton("");
		JButton vipasch = new JButton("");
		JButton qfolge = new JButton("");
		JButton fullhouse = new JButton("");
		JButton klstrasse = new JButton("");
		JButton grstrasse = new JButton("");
		JButton kniffel = new JButton("");
		JButton chance = new JButton("");

		colP2.add(compLabel, "North");
		colP.add(new JLabel("Einer"));
		colP2.add(einer);
		colP.add(new JLabel("Zweier"));
		colP2.add(zweier);
		colP.add(new JLabel("Dreier"));
		colP2.add(dreier);
		colP.add(new JLabel("Vierer"));
		colP2.add(vierer);
		colP.add(new JLabel("Fuenfer"));
		colP2.add(fuenfer);
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
		colP.add(new JLabel("Kleine Strasse"));
		colP2.add(klstrasse);
		colP.add(new JLabel("Grosse Strasse"));
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

		auswahlS1.addActionListener((e) -> i = 1);
		auswahlS1.addActionListener((e) -> spielerFrame.setVisible(false));
		auswahlS1.addActionListener((e) -> printSpielerdialog());
		auswahlS2.addActionListener((e) -> i = 2);
		auswahlS2.addActionListener((e) -> spielerFrame.setVisible(false));
		auswahlS2.addActionListener((e) -> printSpielerdialog());
		auswahlS3.addActionListener((e) -> i = 3);
		auswahlS3.addActionListener((e) -> spielerFrame.setVisible(false));
		auswahlS3.addActionListener((e) -> printSpielerdialog());
		auswahlS4.addActionListener((e) -> i = 4);
		auswahlS4.addActionListener((e) -> spielerFrame.setVisible(false));
		auswahlS4.addActionListener((e) -> printSpielerdialog());
		auswahlS5.addActionListener((e) -> i = 5);
		auswahlS5.addActionListener((e) -> spielerFrame.setVisible(false));
		auswahlS5.addActionListener((e) -> printSpielerdialog());
		auswahlS6.addActionListener((e) -> i = 6);
		auswahlS6.addActionListener((e) -> spielerFrame.setVisible(false));
		auswahlS6.addActionListener((e) -> printSpielerdialog());
		abbruch.addActionListener((e) -> System.exit(0));
		spielerFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.exit(0);
			};
		});

		spielerPanel.add(new JLabel(
				"Wieviele menschliche Spieler moechten mitspielen?"));
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
		String[][] inhalt = { { "Einser", "", "", "", "", "", "" },
				{ "Zweier", "", "", "", "", "", "" },
				{ "Dreier", "", "", "", "", "", "" },
				{ "Vierer", "", "", "", "", "", "" },
				{ "Fuenfer", "", "", "", "", "", "" },
				{ "Sechser", "", "", "", "", "", "" },
				{ "Dreierpasch", "", "", "", "", "", "" },
				{ "Viererpasch", "", "", "", "", "", "" },
				{ "Quadratfolge", "", "", "", "", "", "" },
				{ "Full House", "", "", "", "", "", "" },
				{ "Kleine Strasse", "", "", "", "", "", "" },
				{ "Grosse Strasse", "", "", "", "", "", "" },
				{ "Kniffel", "", "", "", "", "", "" },
				{ "Chance", "", "", "", "", "", "" }, };
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

	public void printWurfAufforderung() {
		GrundFrame wuerfeln = new GrundFrame();
		JPanel jP = new JPanel();
		JButton jB = new JButton("Wuerfeln");

		jP.add(new JLabel("Spieler 1 ist am Zug"));
		jP.add(jB, "Center");

		wuerfeln.add(jP);
		wuerfeln.setSize(400, 200);
		wuerfeln.showIt("Wuerfeln!", 600, 400);

	}

	public static void main(String[] args) {

		SwingClass wK = new SwingClass();
		wK.printWelcome();

	}

}
