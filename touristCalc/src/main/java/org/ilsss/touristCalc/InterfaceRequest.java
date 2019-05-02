package org.ilsss.touristCalc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InterfaceRequest extends Components {
	private String[] TourStats;
	private JPanel mainPanel;
	private Saver b = new Saver();
	private JFrame mainFrame;
	private JButton[] button = new JButton[4];
	private JPanel[] smallPanel = new JPanel[4];
	private JLabel[] label = new JLabel[9];
	private JTextField[] textField = new JTextField[9];
	private String[] smallPanelNames = { "Основные данные", "Транспорт", "Питание", "Процент" };
	private String[] buttonNames = { "Рассчитать", "Принять заявку", "Отклонить заявку", "Вернуться на основное окно" };
	private String[] labelNames = { "Количество людей", "Количество суток",
			"Цена проживания на одного человека за сутки", "Стоимость транспорта туда-обратно", "Множитель транспорта:",
			"Стоимость питания за порцию", "Множитель еды:", "Итоговая стоимость:", "Налог " };
	private int[] smallPanelBounds = { 6, 0, 390, 115, 6, 115, 390, 85, 6, 200, 390, 85, 6, 285, 390, 55 };
	private int[] labelBounds = { 10, 5, 280, 50, 10, 35, 280, 50, 10, 65, 280, 50, 10, 5, 210, 50, 10, 30, 200, 50, 10,
			5, 200, 50, 10, 30, 200, 50, 400, 17, 130, 25, 10, 5, 280, 50 };
	private int[] textFieldsBounds = { 290, 17, 90, 25, 290, 47, 90, 25, 290, 77, 90, 25, 290, 17, 90, 25, 290, 47, 90,
			25, 290, 17, 90, 25, 290, 47, 90, 25, 547, 17, 90, 25, 290, 17, 90, 25 };
	private int[] buttonBounds = { 400, 47, 237, 25, 400, 77, 237, 25, 400, 107, 237, 25, 400, 137, 237, 25 };

	public InterfaceRequest() throws Exception {
		mainPanel = CreateMainPanel();
		mainFrame = CreateMainFrame("Окно менеджера", mainPanel, 650, 375);
		for (int i = 0; i < 9; i++) {
			label[i] = CreateLabel(labelNames[i], labelBounds[i * 4], labelBounds[i * 4 + 1], labelBounds[i * 4 + 2],
					labelBounds[i * 4 + 3]);
			textField[i] = CreateTextField(textFieldsBounds[i * 4], textFieldsBounds[i * 4 + 1],
					textFieldsBounds[i * 4 + 2], textFieldsBounds[i * 4 + 3]);
		}
		textFieldFilter j = new textFieldFilter();
		j.PTextFilter(textField[8], 2);
		for (int i = 0; i < 4; i++) {
			smallPanel[i] = CreateSmallPanel(smallPanelNames[i], smallPanelBounds[i * 4], smallPanelBounds[i * 4 + 1],
					smallPanelBounds[i * 4 + 2], smallPanelBounds[i * 4 + 3]);
			mainPanel.add(smallPanel[i]);
			smallPanel[0].add(label[i]);
			smallPanel[0].add(textField[i]);
			button[i] = CreateButton(buttonNames[i], buttonBounds[i * 4], buttonBounds[i * 4 + 1],
					buttonBounds[i * 4 + 2], buttonBounds[i * 4 + 3]);
			mainPanel.add(button[i]);
		}
		for (int i = 0; i < 8; i++) {
			textField[i].setEditable(false);
		}
		for (int i = 3; i < 5; i++) {
			smallPanel[1].add(label[i]);
			smallPanel[1].add(textField[i]);
		}
		for (int i = 5; i < 7; i++) {
			smallPanel[2].add(label[i]);
			smallPanel[2].add(textField[i]);
		}
		mainPanel.add(label[7]);
		mainPanel.add(textField[7]);
		smallPanel[3].add(textField[8]);
		smallPanel[3].add(label[8]);
		if (b.checkIfEmpty("req.txt") == true) {
			callMessage(mainPanel, "Заявки не была получена, сначала заполните заявку в режиме клиента", "Внимание");
		} else {
			mainFrame.setVisible(true);
			callMessage(mainPanel, "Была получена заявка, поля были заполнены данными из заявки", "Внимание");
			TourStats = b.getReqResult();
			for (int i = 0; i < 7; i++) {
				textField[i].setText(TourStats[i]);
			}
		}
		button[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (b.checkIfEmpty("req.txt") != true) {
						if (!textField[8].getText().isEmpty()) {
							Tour a = new Tour(toDouble(TourStats[0]), toDouble(TourStats[1]), toDouble(TourStats[2]),
									toDouble(TourStats[3]), toDouble(TourStats[4]), toDouble(TourStats[5]),
									toDouble(TourStats[6]), toDouble(textField[8].getText()));
							textField[7].setText(a.getResult());
						} else {
							callMessage(mainPanel,
									"Для рассчета требуется ввести значение налога, введите значение и повторите попытку",
									"Внимание");
						}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!textField[7].getText().isEmpty()) {
						b.save(textField[7].getText(), "ReqAnswer.txt");
					} else {
						callMessage(mainPanel,
								"Для подтверждения и отправки заявки сначала рассчитайте стоимость тура в ней",
								"Внимание");
					}
				} catch (Exception e1) {
				}
			}
		});
		button[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					b.save("", "req.txt");
					b.save("", "ReqAnswer.txt");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				callMessage(mainPanel,
						"Заявка была отменена, все данные, связанные с ней, были удалены. Вы будете перенаправленны на начальную форму.",
						"Внимание");
				mainFrame.setVisible(false);
				InterfaceAdmin a = new InterfaceAdmin();
			}
		});
		button[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.setVisible(false);
				InterfaceAdmin a = new InterfaceAdmin();
			}
		});
	}
}
