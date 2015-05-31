package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;

import javax.swing.*;
import javax.swing.JTable.PrintMode;

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

	static String[] spieler = new String[6];
	int i;
	int c = 0;
	int a = 0;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

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

		auswahl1.addActionListener((e) -> c = 1);
		auswahl2.addActionListener((e) -> c = 2);
		auswahl3.addActionListener((e) -> c = 3);
		auswahl4.addActionListener((e) -> c = 4);
		auswahl5.addActionListener((e) -> c = 5);

		compPanel
				.add(new JLabel("Wieviele Computer Spieler sollen mitspielen?"));
		compPanel
				.add(new JLabel("Es können maximal nur 6 Spieler teilnehmen."));
		compPanel.add(auswahl1);
		compPanel.add(auswahl2);
		compPanel.add(auswahl3);
		compPanel.add(auswahl4);
		compPanel.add(auswahl5);

		compPanel.add(compLabel);
		compFrame.add(compPanel);

		compFrame.pack();
		compFrame.showIt("Computer Spieler", 600, 400);

	}

	public void printSpielerdialog() {

		int a = printMSpielerAuswahl();

		/*
		 * namePanel = new JPanel(); nameLabel = new
		 * JLabel("Waehlen Sie einen Spielernamen: ");
		 * 
		 * namePanel.add(nameLabel); tfName = new JTextField("", 15);
		 * tfName.setForeground(Color.BLUE); tfName.setBackground(Color.CYAN);
		 * namePanel.add(tfName);
		 * 
		 * ok = new JButton("OK"); ok.addActionListener((e) -> nameLabel
		 * .setText("Name des nächsten Spielers:")); ok.addActionListener((e) ->
		 * tfName.setText(""));
		 * 
		 * namePanel.add(ok);
		 * 
		 * JDialog dialog = new JDialog(); dialog.setTitle("Spielernamen");
		 * dialog.setAlwaysOnTop(true);
		 * 
		 * dialog.addWindowListener(new WindowAdapter() {
		 * 
		 * @Override public void windowClosing(java.awt.event.WindowEvent e) {
		 * System.exit(0); } }); ok.addActionListener((e) -> spieler[0] = "" +
		 * tfName.getText()); ok.addActionListener((e) ->
		 * dialog.setVisible(false));
		 * 
		 * dialog.setLocation(600, 400);
		 * 
		 * dialog.add(namePanel); dialog.pack();
		 * 
		 * dialog.setVisible(true);
		 */

		if (a == 1) {
			TextPanelModel tpm = new TextPanelModel(Color.WHITE);
			GrundFrame frame = new GrundFrame();

			frame.add(tpm);
			frame.setVisible(true);
			spieler[0] = tpm.getName();

		}

	}

	public boolean printWelcome() {

		GrundFrame willkommen = new GrundFrame();
		JPanel jP = new JPanel();
		JButton jB = new JButton("Spielen!");

		jP.add(new JLabel("Willkommen zu Kniffel!"));
		jP.add(jB);
		jB.addActionListener((e) -> printMSpielerAuswahl());
		jB.addActionListener((e) -> willkommen.setVisible(false));
		jP.add(abbruch);
		abbruch.addActionListener((e) -> System.exit(0));

		willkommen.add(jP);
		willkommen.pack();
		willkommen.showIt("Willkommen zu Kniffel!", 600, 400);

		if (!willkommen.isShowing()) {
			return false;
		}
		return true;

	}

	public void printWurf() {

		GrundFrame grundF = new GrundFrame();
		grundF.setLayout(new GridLayout(/* 3 */0, 2, 28, 14));

		JLabel compLabel = new JLabel("Du hast folgendes gewuerfelt:");
		JButton einer = new JButton("5");
		JButton zweier = new JButton("10");
		JButton dreier = new JButton("15");
		JButton vierer = new JButton("20");
		JButton fuenfer = new JButton("25");
		JButton sechser = new JButton("30");
		JButton drpasch = new JButton("18");
		JButton vipasch = new JButton("16");
		JButton qfolge = new JButton("25");
		JButton fullhouse = new JButton("20");
		JButton klstrasse = new JButton("30");
		JButton grstrasse = new JButton("40");
		JButton kniffel = new JButton("35");
		JButton chance = new JButton("50");

		grundF.add(compLabel, "North");
		grundF.add(new JLabel(""));
		grundF.add(new JLabel("Einer"));
		grundF.add(einer);
		grundF.add(new JLabel("Zweier"));
		grundF.add(zweier);
		grundF.add(new JLabel("Dreier"));
		grundF.add(dreier);
		grundF.add(new JLabel("Vierer"));
		grundF.add(vierer);
		grundF.add(new JLabel("Fuenfer"));
		grundF.add(fuenfer);
		grundF.add(new JLabel("Sechser"));
		grundF.add(sechser);
		grundF.add(new JLabel("Dreierpasch"));
		grundF.add(drpasch);
		grundF.add(new JLabel("Viererpasch"));
		grundF.add(vipasch);
		grundF.add(new JLabel("Quadratfolge"));
		grundF.add(qfolge);
		grundF.add(new JLabel("Full House"));
		grundF.add(fullhouse);
		grundF.add(new JLabel("Kleine Strasse"));
		grundF.add(klstrasse);
		grundF.add(new JLabel("Grosse Strasse"));
		grundF.add(grstrasse);
		grundF.add(new JLabel("Kniffel"));
		grundF.add(kniffel);
		grundF.add(new JLabel("Chance"));
		grundF.add(chance);

		JPanel wuerfelW = new JPanel();
		JPanel wuerfelW2 = new JPanel();
		wuerfelW2.add(new JLabel("Dein Wurf:  2  3  4  5  6"));
		JRadioButton eins = new JRadioButton("Wuerfel 1");
		JRadioButton zwei = new JRadioButton("Wuerfel 2");
		JRadioButton drei = new JRadioButton("Wuerfel 3");
		JRadioButton vier = new JRadioButton("Wuerfel 4");
		JRadioButton fuenf = new JRadioButton("Wuerfel 5");
		GrundFrame wuerfelWeglegen = new GrundFrame();
		JButton weglegen = new JButton("Ok");
		JPanel wuerfW = new JPanel();

		wuerfW.add(eins);
		wuerfW.add(zwei);
		wuerfW.add(drei);
		wuerfW.add(vier);
		wuerfW.add(fuenf);
		wuerfW.add(weglegen);
		wuerfelWeglegen.getContentPane().add(wuerfW);
		wuerfelWeglegen.pack();

		JButton aus = new JButton("Wuerfel weglegen");
		aus.addActionListener((e) -> wuerfelWeglegen.showIt("Deine Wuerfel",
				600, 400));

		wuerfelW.add(aus);
		grundF.getContentPane().add(wuerfelW);
		grundF.getContentPane().add(wuerfelW2);

		grundF.pack();

		grundF.showIt("Ergebnisse", 600, 150);

	}

	public void reihenfolgeWuerfeln() {

		GrundFrame wurfFrame = new GrundFrame();
		JPanel panel = new JPanel();
		JButton wuerfeln = new JButton("Wuerfeln");
		panel.add(new JLabel("Wuerfeln Sie Ihre Position aus!"));
		panel.add(wuerfeln);
		wuerfeln.addActionListener((e) -> JOptionPane.showMessageDialog(null,
				"Sie sind auf Platz: "));
		wurfFrame.getContentPane().add(panel);
		wurfFrame.setSize(200, 200);
		wurfFrame.showIt("Wuerfeln", 600, 400);

	}

	public int printMSpielerAuswahl() {
		spielerFrame = new GrundFrame();
		spielerPanel = new JPanel();
		labelS = new JLabel();

		auswahlS1 = new JButton("1");
		auswahlS2 = new JButton("2");
		auswahlS3 = new JButton("3");
		auswahlS4 = new JButton("4");
		auswahlS5 = new JButton("5");
		auswahlS6 = new JButton("6");

		auswahlS1.addActionListener((e) -> setI(1));
		auswahlS1.addActionListener((e) -> spielerFrame.setVisible(false));
		auswahlS2.addActionListener((e) -> setI(2));
		auswahlS2.addActionListener((e) -> spielerFrame.setVisible(false));
		auswahlS3.addActionListener((e) -> setI(3));
		auswahlS3.addActionListener((e) -> spielerFrame.setVisible(false));
		auswahlS4.addActionListener((e) -> setI(4));
		auswahlS4.addActionListener((e) -> spielerFrame.setVisible(false));
		auswahlS5.addActionListener((e) -> setI(5));
		auswahlS5.addActionListener((e) -> spielerFrame.setVisible(false));
		auswahlS6.addActionListener((e) -> setI(6));
		auswahlS6.addActionListener((e) -> spielerFrame.setVisible(false));

		spielerPanel.add(new JLabel(
				"Wieviele menschliche Spieler moechten mitspielen?"));
		spielerPanel.add(auswahlS1);
		spielerPanel.add(auswahlS2);
		spielerPanel.add(auswahlS3);
		spielerPanel.add(auswahlS4);
		spielerPanel.add(auswahlS5);
		spielerPanel.add(auswahlS6);

		spielerPanel.add(labelS);
		spielerFrame.add(spielerPanel);
		spielerFrame.pack();

		spielerFrame.showIt("Spieleranzahl", 600, 400);

		return i;
	}

	public void printErgebnistabelle() {
		GrundFrame gF = new GrundFrame();
		String[][] inhalt = { { "Einser", "", "", "", "", "", "" },
				{ "Zweier", "", "", "", "", "", "" },
				{ "Dreier", "", "", "", "", "", "" },
				{ "Vierer", "", "", "", "", "", "" },
				{ "Fuenfer", "", "", "", "", "", "" },
				{ "Sechser", "", "", "", "", "", "" },
				{ "Summe oben", "", "", "", "", "", "" },
				{ "Bonus", "", "", "", "", "", "" },
				{ "Dreierpasch", "", "", "", "", "", "" },
				{ "Viererpasch", "", "", "", "", "", "" },
				{ "Quadratfolge", "", "", "", "", "", "" },
				{ "Full House", "", "", "", "", "", "" },
				{ "Kleine Strasse", "", "", "", "", "", "" },
				{ "Grosse Strasse", "", "", "", "", "", "" },
				{ "Kniffel", "", "", "", "", "", "" },
				{ "Chance", "", "", "", "", "", "" },
				{ "Summe unten", "", "", "", "", "", "" },
				{ "Ergebnis", "", "", "", "", "", "" } };
		String[] spaltenNamen = { "Ergebnisse", "Spieler 1", "Spieler 2",
				"Spieler 3", "Spieler 4", "Spieler 5", "Spieler 6" };
		JTable jTab = new JTable(inhalt, spaltenNamen);
		JScrollPane sp = new JScrollPane(jTab);
		sp.setBackground(Color.yellow);

		jTab.setAutoResizeMode(0);
		jTab.setIntercellSpacing(new Dimension(8, 2));
		jTab.setGridColor(Color.black);

		gF.getContentPane().add(sp);
		gF.pack();

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
