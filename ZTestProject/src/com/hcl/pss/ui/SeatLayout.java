package com.hcl.pss.ui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class SeatLayout {
	private static enum AIRCARFT_TYPE {SINGLE_AISLE, TWIN_AISLE};
	private JFrame frame = new JFrame();

	public SeatLayout() {

		frame.add(getSeatPanel(AIRCARFT_TYPE.TWIN_AISLE.toString(), 40));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				SeatLayout borderPanels = new SeatLayout();
			}
		});
	}

	public JScrollPane getSeatPanel(String type, int maxRow) {
		final int ROW_HEIGHT = 50;
		final int CELL_WIDTH = 55;
		int columns = 0;
		if (type.equals("SINGLE_AISLE")) {
			columns = 6;
		} else if (type.equals("TWIN_AISLE")) {
			columns = 10;
		}
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		Image img = Toolkit.getDefaultToolkit().getImage("seat_icon.JPG");
		ImageIcon icon = new ImageIcon(img);
		int colIncreased = 0;
		for (int row = 0; row < maxRow; row++) {
			for (int col = 0; col < columns; col++) {
				JButton b = new JButton((row + 1) + " " + (char) (65 + col), icon);
				b.putClientProperty("column", col);
				b.putClientProperty("row", row);
				b.setVerticalTextPosition(SwingConstants.TOP);
				b.setHorizontalTextPosition(SwingConstants.CENTER);
				b.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JButton btn = (JButton) e.getSource();
						System.out.println("clicked column " + btn.getClientProperty("column") + ", row "
								+ btn.getClientProperty("row"));
					}
				});
				//b.setSize(40, 55);
				b.setPreferredSize(new Dimension(CELL_WIDTH	, ROW_HEIGHT ));
				gbc.gridx = col + colIncreased;
				gbc.gridy = row;
				gbc.gridwidth = gbc.gridheight = 1;
				gbc.fill = GridBagConstraints.BOTH;
				gbc.anchor = GridBagConstraints.NORTHWEST;
				gbc.weightx = CELL_WIDTH;
				gbc.weighty = ROW_HEIGHT;
				panel.add(b, gbc);
				
				if(col == 2){
					gbc.gridx = col + 1;
					JLabel label = new JLabel();
					label.setPreferredSize(new Dimension(25	, ROW_HEIGHT));
					
					
					panel.add(label, gbc);
					colIncreased ++;
				}
				
				if(col == 6 && type.equals("TWIN_AISLE")){
					gbc.gridx = col + 2;
					JLabel label = new JLabel();
					label.setPreferredSize(new Dimension(25	, ROW_HEIGHT));
					
					
					panel.add(label, gbc);
					colIncreased ++;
				}
			}
			gbc.gridx = columns + 2;
			JLabel label = new JLabel();
			label.setPreferredSize(new Dimension(20	, ROW_HEIGHT));
			
			panel.add(label, gbc);
			colIncreased = 0;
		}
		//panel.setPreferredSize(new Dimension((int) (panel.getPreferredSize().getWidth() + 15), (int)panel.getPreferredSize().getHeight()));
		JScrollPane scrollPanel = new JScrollPane(panel);
		
		return scrollPanel;
	}
}
