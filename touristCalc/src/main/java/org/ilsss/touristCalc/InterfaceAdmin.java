package org.ilsss.touristCalc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class InterfaceAdmin extends Components {
	private JPanel mainPanel;
	private JFrame mainFrame;
	private String[] buttonNames = { "Менеджер", "Клиент" };
	private JButton[] button = new JButton[2];
	private int[] buttonBounds = { 7, 37, 250, 25, 7, 67, 250, 25 };

	public InterfaceAdmin() {
		mainPanel = CreateMainPanel();
		mainFrame = CreateMainFrame("Расчет стоимости тура", mainPanel, 270, 170);
		for (int i = 0; i < 2; i++) {
			button[i] = CreateButton(buttonNames[i], buttonBounds[i * 4], buttonBounds[i * 4 + 1],
					buttonBounds[i * 4 + 2], buttonBounds[i * 4 + 3]);
			mainPanel.add(button[i]);
		}
		button[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					InterfaceRequest a = new InterfaceRequest();
					mainFrame.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					InterfaceClient a = new InterfaceClient();
					mainFrame.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		mainFrame.setVisible(true);
	}
}