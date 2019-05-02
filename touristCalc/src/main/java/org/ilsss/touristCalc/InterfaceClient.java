package org.ilsss.touristCalc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class InterfaceClient extends Components {
	private Saver b = new Saver();
	private double trMult = 1;
	private double foodMult = 1;
	private JPanel mainPanel;
	private JFrame mainFrame;
	private JButton[] button = new JButton[3];
	private JPanel[] smallPanel = new JPanel[3];
	private JLabel[] label = new JLabel[8];
	private JCheckBox[] checkbox = new JCheckBox[3];
	private JRadioButton[] radiobutton = new JRadioButton[2];
	private JTextField[] textField = new JTextField[5];
	private String[] smallPanelNames = { "Основные данные", "Транспорт", "Питание" };
	private String[] checkboxesNames = { "Завтрак", "Обед", "Ужин" };
	private String[] radiobuttonNames = { "Авиаперелет", "Круиз" };
	private String[] buttonNames = { "Отправить заявку менеджеру", "Очистить поля", "Вернуться на основное окно" };
	private String[] labelNames = { "Количество людей", "Количество суток",
			"Цена проживания на одного человека за сутки", "Стоимость транспорта туда-обратно", "Используя:",
			"Стоимость питания за порцию", "С расчетом на:" };
	private int[] smallPanelBounds = { 3, 0, 390, 115, 3, 115, 321, 120, 325, 115, 318, 120 };
	private int[] radiobuttonBounds = { 10, 65, 120, 50, 140, 65, 80, 50 };
	private int[] labelBounds = { 10, 5, 280, 50, 10, 35, 280, 50, 10, 65, 280, 50, 10, 5, 210, 50, 10, 30, 200, 50, 10,
			5, 200, 50, 10, 30, 200, 50, 400, 17, 130, 25 };
	private int[] checkboxesBounds = { 10, 65, 90, 50, 120, 65, 90, 50, 230, 65, 80, 50 };
	private int[] textFieldsBounds = { 290, 17, 90, 25, 290, 47, 90, 25, 290, 77, 90, 25, 225, 17, 90, 25, 222, 17, 90,
			25 };
	private int[] buttonBounds = { 400, 17, 237, 25, 400, 47, 237, 25, 400, 77, 237, 25 };

	public InterfaceClient() throws Exception {
		mainPanel = CreateMainPanel();
		mainFrame = CreateMainFrame("Окно клиента", mainPanel, 650, 270);
		for (int i = 0; i < 7; i++) {
			label[i] = CreateLabel(labelNames[i], labelBounds[i * 4], labelBounds[i * 4 + 1], labelBounds[i * 4 + 2],
					labelBounds[i * 4 + 3]);
		}
		for (int i = 0; i < 5; i++) {
			textField[i] = CreateTextField(textFieldsBounds[i * 4], textFieldsBounds[i * 4 + 1],
					textFieldsBounds[i * 4 + 2], textFieldsBounds[i * 4 + 3]);
		}
		textFieldFilter j = new textFieldFilter();
		for (int i = 0; i < 5; i++) {
			j.PTextFilter(textField[i], 7);
		}
		for (int i = 0; i < 3; i++) {
			smallPanel[i] = CreateSmallPanel(smallPanelNames[i], smallPanelBounds[i * 4], smallPanelBounds[i * 4 + 1],
					smallPanelBounds[i * 4 + 2], smallPanelBounds[i * 4 + 3]);
			mainPanel.add(smallPanel[i]);
			smallPanel[0].add(label[i]);
			smallPanel[0].add(textField[i]);
		}
		for (int i = 0; i < 2; i++) {
			radiobutton[i] = CreateRadioButton(radiobuttonNames[i], radiobuttonBounds[i * 4],
					radiobuttonBounds[i * 4 + 1], radiobuttonBounds[i * 4 + 2], radiobuttonBounds[i * 4 + 3]);
			smallPanel[1].add(radiobutton[i]);
		}
		for (int i = 0; i < 3; i++) {
			button[i] = CreateButton(buttonNames[i], buttonBounds[i * 4], buttonBounds[i * 4 + 1],
					buttonBounds[i * 4 + 2], buttonBounds[i * 4 + 3]);
			checkbox[i] = CreateCheckBox(checkboxesNames[i], checkboxesBounds[i * 4], checkboxesBounds[i * 4 + 1],
					checkboxesBounds[i * 4 + 2], checkboxesBounds[i * 4 + 3]);
			smallPanel[2].add(checkbox[i]);
			mainPanel.add(button[i]);
		}
		smallPanel[1].add(label[4]);
		smallPanel[1].add(label[3]);
		smallPanel[1].add(textField[3]);
		smallPanel[2].add(label[5]);
		smallPanel[2].add(label[6]);
		smallPanel[2].add(textField[4]);
		selectRadioBtn(radiobutton[0], radiobutton[1]);
		mainFrame.setVisible(true);
		if (b.checkIfEmpty("reqAnswer.txt") == false) {
			callMessage(mainPanel, "Ваша заявка обработана, итоговая стоимость тура - " + b.getNormalResult() + " у.е.",
					"Внимание");
			b.save("", "req.txt");
			b.save("", "ReqAnswer.txt");
		}
		button[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField[0].getText().isEmpty() && !textField[1].getText().isEmpty()
						&& !textField[2].getText().isEmpty() && !textField[3].getText().isEmpty()
						&& !textField[4].getText().isEmpty()) {
					if (checkbox[0].isSelected() || checkbox[1].isSelected() || checkbox[2].isSelected()) {
						if (radiobutton[0].isSelected() || radiobutton[1].isSelected()) {
							if (checkbox[0].isSelected()) {
								foodMult = foodMult + 0.26;
							}
							if (checkbox[1].isSelected()) {
								foodMult = foodMult + 0.26;
							}
							if (checkbox[2].isSelected()) {
								foodMult = foodMult + 0.26;
							}
							if (radiobutton[0].isSelected()) {
								trMult = trMult + 0.34;
							}
							if (radiobutton[1].isSelected()) {
								trMult = trMult + 0.28;
							}
							try {
								b.save(Double.parseDouble(textField[0].getText()) + "/"
										+ Double.parseDouble(textField[1].getText()) + "/"
										+ Double.parseDouble(textField[2].getText()) + "/"
										+ Double.parseDouble(textField[3].getText()) + "/" + trMult + "/"
										+ Double.parseDouble(textField[4].getText()) + "/" + foodMult + "/", "req.txt");
							} catch (Exception e1) {
								e1.printStackTrace();
							}
							callMessage(mainPanel, "Заявка отправлена", "Внимание");
							foodMult = 1;
							trMult = 1;
						} else {
							callMessage(mainPanel, "Для отправки заявки выберите хотя бы один тип транспорта",
									"Внимание");
						}
					} else {
						callMessage(mainPanel, "Для отправки заявки выберите хотя бы один тип питания", "Внимание");
					}
				} else {
					callMessage(mainPanel, "Для отправки заявки заполните все поля", "Внимание");
				}
			}
		});
		button[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 5; i++) {
					textField[i].setText("");
				}
			}
		});
		button[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.setVisible(false);
				InterfaceAdmin a = new InterfaceAdmin();
			}
		});
	}

	public void selectRadioBtn(final JRadioButton radio1, final JRadioButton radio2) {
		radio1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radio1.isSelected())
					radio2.setSelected(false);
			}
		});
		radio2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radio2.isSelected())
					radio1.setSelected(false);
			}
		});
	}
}
