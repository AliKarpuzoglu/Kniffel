package gui;

import java.awt.*;

import javax.swing.JPanel;

public class ColorPanel extends JPanel {

	public ColorPanel(Color col) {
		setBackground(col);
	}

	public ColorPanel(Color col, int width, int height) {
		this.setPreferredSize(new Dimension(width, height));
		setBackground(col);
	}
}
