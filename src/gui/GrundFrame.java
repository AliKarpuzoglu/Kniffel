package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class GrundFrame extends JFrame {

	public GrundFrame() {

		this.setSize(400, 400);
		JFrame infoFrame = new JFrame("Info");
		JLabel infoLabel = new JLabel(
				"Viel Spa� w�nscht euch das Team von Jonas J�ckel!");
		infoLabel.setFont(new Font("Cambria", Font.PLAIN, 16));
		ColorPanel infoPanel = new ColorPanel(Color.orange);
		infoPanel.add(infoLabel);
		infoFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				infoFrame.setVisible(false);
			}
		});
		infoFrame.add(infoPanel);
		infoFrame.setSize(400, 200);
		;
		infoFrame.setLocation(900, 400);

		Border bo = new LineBorder(Color.white);
		JMenuBar bar = new JMenuBar();
		setSize(200, 200);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.exit(0);
			}
		});
		bar.setBorder(bo);
		JMenu menu = new JMenu("Optionen");
		JMenuItem info = new JMenuItem("Info");
		JMenuItem tabelle = new JMenuItem("Ergebnistabelle");
		tabelle.addActionListener((e) -> printErgebnistabelle());
		info.addActionListener((e) -> infoFrame.setVisible(true));
		JMenuItem item = new JMenuItem("Beenden");
		item.addActionListener((e) -> System.exit(0));
		menu.add(info);
		menu.add(tabelle);
		menu.addSeparator();
		menu.add(item);
		bar.add(menu);

		this.setJMenuBar(bar);
	}

	public void showIt() {
		setVisible(true);
	}

	public void showIt(String title) {
		setTitle(title);
		setVisible(true);
	}

	public void showIt(String title, int x, int y) {
		setTitle(title);
		setLocation(x, y);
		setVisible(true);
	}

	public void hideIt() {
		setVisible(false);
	}

	public void printErgebnistabelle() {
		JFrame gF = new JFrame();
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
				{ "Endergebnis", "", "", "", "", "", "" } };
		String[] spaltenNamen = { "Ergebnisse", "Spieler 1", "Spieler 2",
				"Spieler 3", "Spieler 4", "Spieler 5", "Spieler 6" };
		JTable jTab = new JTable(inhalt, spaltenNamen);
		jTab.setAutoResizeMode(0);
		JScrollPane sp = new JScrollPane(jTab);
		sp.setBackground(Color.yellow);

		jTab.setIntercellSpacing(new Dimension(8, 2));
		jTab.setGridColor(Color.black);

		gF.getContentPane().add(sp);
		gF.setSize(600, 400);
		gF.setLocation(600, 400);

		gF.setVisible(true);
	}
}
