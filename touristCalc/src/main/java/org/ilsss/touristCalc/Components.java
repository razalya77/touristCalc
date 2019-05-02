package org.ilsss.touristCalc;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Components extends JFrame {
	protected JFrame CreateMainFrame(String FrameName, JPanel Panel, int w, int h) {
		JFrame mainFrame = new JFrame(FrameName);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(w, h);
		mainFrame.setContentPane(Panel);
		mainFrame.setResizable(false);
		return mainFrame;
	}

	protected JLabel CreateLabel(String name, int x, int y, int w, int h) {
		JLabel Label = new JLabel(name);
		Label.setBounds(x, y, w, h);
		return Label;
	}

	protected JTextField CreateTextField(int x, int y, int w, int h) {
		JTextField textField = new JTextField();
		textField.setBounds(x, y, w, h);
		return textField;
	}

	protected JPanel CreateMainPanel() {
		JPanel MainPanel = new JPanel();
		MainPanel.setLayout(null);
		return MainPanel;
	}

	protected JCheckBox CreateCheckBox(String name, int x, int y, int w, int h) {
		JCheckBox CheckBox = new JCheckBox();
		CheckBox.setText(name);
		CheckBox.setBounds(x, y, w, h);
		return CheckBox;
	}

	protected JRadioButton CreateRadioButton(String name, int x, int y, int w, int h) {
		JRadioButton RadioButton = new JRadioButton();
		RadioButton.setText(name);
		RadioButton.setBounds(x, y, w, h);
		return RadioButton;
	}

	protected JPanel CreateSmallPanel(String name, int x, int y, int w, int h) {
		JPanel MainPanel = new JPanel();
		MainPanel.setLayout(null);
		MainPanel.setBorder(BorderFactory.createTitledBorder(name));
		MainPanel.setBounds(x, y, w, h);
		return MainPanel;
	}

	protected JButton CreateButton(String name, int x, int y, int h, int w) {
		JButton a = new JButton(name);
		a.setBounds(x, y, h, w);
		return a;
	}

	protected void callMessage(JPanel Panel, String mainMessage, String previewMessage) {
		JOptionPane.showMessageDialog(Panel, mainMessage, previewMessage, JOptionPane.INFORMATION_MESSAGE);
	}

	protected double toDouble(String a) {
		return Double.parseDouble(a);
	}
}