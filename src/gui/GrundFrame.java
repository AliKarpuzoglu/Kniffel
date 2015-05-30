package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class GrundFrame extends JFrame {

	public GrundFrame() {

		JFrame infoFrame = new JFrame("Info");
		JLabel infoLabel = new JLabel(
				"Viel Spaß wünscht euch das Team von Jonas Jäckel!");
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
		info.addActionListener((e) -> infoFrame.setVisible(true));
		JMenuItem item = new JMenuItem("Beenden");
		item.addActionListener((e) -> System.exit(0));
		menu.add(info);
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

}
