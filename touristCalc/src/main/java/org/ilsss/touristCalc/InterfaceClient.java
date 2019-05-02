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
	/**
	 * Создание экземпляра класса, производящего сохранение
	 */
	private Saver b = new Saver();
	/**
	 * Объявление коэффициента цены транспорта
	 */
	private double trMult = 1;
	/**
	 * Объявление коэффициента цены еды
	 */
	private double foodMult = 1;
	/**
	 * Инициализация основной панели
	 */
	private JPanel mainPanel;
	/**
	 * Инициализация основного фрейма
	 */
	private JFrame mainFrame;
	/**
	 * Создание массива для хранения кнопок
	 */
	private JButton[] button = new JButton[3];
	/**
	 * Создание массива для хранения панелей
	 */
	private JPanel[] smallPanel = new JPanel[3];
	/**
	 * Создание массива для хранения лейблов
	 */
	private JLabel[] label = new JLabel[8];
	/**
	 * Создание массива для хранения чекбоксов
	 */
	private JCheckBox[] checkbox = new JCheckBox[3];
	/**
	 * Создание массива для хранения переключателей
	 */
	private JRadioButton[] radiobutton = new JRadioButton[2];
	/**
	 * Создание массива для хранения текстовых полей
	 */
	private JTextField[] textField = new JTextField[5];
	/**
	 * Создание массива с названиями панелей
	 */
	private String[] smallPanelNames = { "Основные данные", "Транспорт", "Питание" };
	/**
	 * Создание массива с названиями чекбоксов
	 */
	private String[] checkboxesNames = { "Завтрак", "Обед", "Ужин" };
	/**
	 * Создание массива с названиями переключателей
	 */
	private String[] radiobuttonNames = { "Авиаперелет", "Круиз" };
	/**
	 * Создание массива с названиями кнопок
	 */
	private String[] buttonNames = { "Отправить заявку менеджеру", "Очистить поля", "Вернуться на основное окно" };
	/**
	 * Создание массива с названиями лейблов
	 */
	private String[] labelNames = { "Количество людей", "Количество суток",
			"Цена проживания на одного человека за сутки", "Стоимость транспорта туда-обратно", "Используя:",
			"Стоимость питания за порцию", "С расчетом на:" };
	/**
	 * Создание массива с размерами панелей
	 */
	private int[] smallPanelBounds = { 3, 0, 390, 115, 3, 115, 321, 120, 325, 115, 318, 120 };
	/**
	 * Создание массива с размерами переключателей
	 */
	private int[] radiobuttonBounds = { 10, 65, 120, 50, 140, 65, 80, 50 };
	/**
	 * Создание массива с размерами лейблов
	 */
	private int[] labelBounds = { 10, 5, 280, 50, 10, 35, 280, 50, 10, 65, 280, 50, 10, 5, 210, 50, 10, 30, 200, 50, 10,
			5, 200, 50, 10, 30, 200, 50, 400, 17, 130, 25 };
	/**
	 * Создание массива с размерами чекбоксов
	 */
	private int[] checkboxesBounds = { 10, 65, 90, 50, 120, 65, 90, 50, 230, 65, 80, 50 };
	/**
	 * Создание массива с размерами текстовых полей
	 */
	private int[] textFieldsBounds = { 290, 17, 90, 25, 290, 47, 90, 25, 290, 77, 90, 25, 225, 17, 90, 25, 222, 17, 90,
			25 };
	/**
	 * Создание массива с размерами кнопок
	 */
	private int[] buttonBounds = { 400, 17, 237, 25, 400, 47, 237, 25, 400, 77, 237, 25 };

	public InterfaceClient() throws Exception {
		/**
		 * Создание основной панели
		 */
		mainPanel = CreateMainPanel();
		/**
		 * Создание основного окна
		 */
		mainFrame = CreateMainFrame("Окно клиента", mainPanel, 650, 270);
		/**
		 * Заполнение массива лейблов названиями и размерами
		 */
		for (int i = 0; i < 7; i++) {
			label[i] = CreateLabel(labelNames[i], labelBounds[i * 4], labelBounds[i * 4 + 1], labelBounds[i * 4 + 2],
					labelBounds[i * 4 + 3]);
		}
		/**
		 * Заполнение массива текстовых полей размерами
		 */
		for (int i = 0; i < 5; i++) {
			textField[i] = CreateTextField(textFieldsBounds[i * 4], textFieldsBounds[i * 4 + 1],
					textFieldsBounds[i * 4 + 2], textFieldsBounds[i * 4 + 3]);
		}
		/**
		 * Создание текстового фильтра
		 */
		textFieldFilter j = new textFieldFilter();
		/**
		 * Применение текстового фильтра к текстовым полям
		 */
		for (int i = 0; i < 5; i++) {
			j.PTextFilter(textField[i], 7);
		}
		/**
		 * 13 Создание панелей с рамками, прикрепление лейблов и текстовых полей к
		 * первой панели
		 */
		for (int i = 0; i < 3; i++) {
			smallPanel[i] = CreateSmallPanel(smallPanelNames[i], smallPanelBounds[i * 4], smallPanelBounds[i * 4 + 1],
					smallPanelBounds[i * 4 + 2], smallPanelBounds[i * 4 + 3]);
			mainPanel.add(smallPanel[i]);
			smallPanel[0].add(label[i]);
			smallPanel[0].add(textField[i]);
		}
		/**
		 * Создание переключателей, задание размеров, прикрепление их к панелям
		 */
		for (int i = 0; i < 2; i++) {
			radiobutton[i] = CreateRadioButton(radiobuttonNames[i], radiobuttonBounds[i * 4],
					radiobuttonBounds[i * 4 + 1], radiobuttonBounds[i * 4 + 2], radiobuttonBounds[i * 4 + 3]);
			smallPanel[1].add(radiobutton[i]);
		}
		/**
		 * Создание чекбоксов и кнопок, прикрепление к ним названий и задание размеров
		 */
		for (int i = 0; i < 3; i++) {
			button[i] = CreateButton(buttonNames[i], buttonBounds[i * 4], buttonBounds[i * 4 + 1],
					buttonBounds[i * 4 + 2], buttonBounds[i * 4 + 3]);
			checkbox[i] = CreateCheckBox(checkboxesNames[i], checkboxesBounds[i * 4], checkboxesBounds[i * 4 + 1],
					checkboxesBounds[i * 4 + 2], checkboxesBounds[i * 4 + 3]);
			smallPanel[2].add(checkbox[i]);
			mainPanel.add(button[i]);
		}
		/**
		 * Прикрепление оставшихся графических элементов к панелям
		 */
		smallPanel[1].add(label[4]);
		smallPanel[1].add(label[3]);
		smallPanel[1].add(textField[3]);
		smallPanel[2].add(label[5]);
		smallPanel[2].add(label[6]);
		smallPanel[2].add(textField[4]);
		/**
		 * Примениние фильтра к переключателям
		 */
		selectRadioBtn(radiobutton[0], radiobutton[1]);
		/**
		 * Включение видимости фрейма
		 */
		mainFrame.setVisible(true);
		/**
		 * Проверка наличия заявки
		 */
		if (b.checkIfEmpty("reqAnswer.txt") == false) {
			/**
			 * Выдача сообщения с результатом при наличии заявка
			 */
			callMessage(mainPanel, "Ваша заявка обработана, итоговая стоимость тура - " + b.getNormalResult() + " у.е.",
					"Внимание");
			/**
			 * Очистка документов, содержащих сохранения результатов
			 */
			b.save("", "req.txt");
			b.save("", "ReqAnswer.txt");
		}
		/**
		 * 15 Добавление обработчика для кнопки подачи заявки
		 */
		button[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Проверка заполнения полей
				 */
				if (!textField[0].getText().isEmpty() && !textField[1].getText().isEmpty()
						&& !textField[2].getText().isEmpty() && !textField[3].getText().isEmpty()
						&& !textField[4].getText().isEmpty()) {
					/**
					 * Проверка на выбор хотя бы одного чекбокса
					 */
					if (checkbox[0].isSelected() || checkbox[1].isSelected() || checkbox[2].isSelected()) {
						/**
						 * Проверка на выбор хотя бы одного переключателя
						 */
						if (radiobutton[0].isSelected() || radiobutton[1].isSelected()) {
							/**
							 * Обновление коэффициента еды в случае выбора соответствуюущего чекбокса
							 */
							if (checkbox[0].isSelected()) {
								foodMult = foodMult + 0.26;
							}
							/**
							 * Обновление коэффициента еды в случае выбора соответствуюущего чекбокса
							 */
							if (checkbox[1].isSelected()) {
								foodMult = foodMult + 0.26;
							}
							/**
							 * Обновление коэффициента еды в случае выбора соответствуюущего чекбокса
							 */
							if (checkbox[2].isSelected()) {
								foodMult = foodMult + 0.26;
							}
							/**
							 * Обновление коэффициента транспорта в случае выбора соответствуюущего
							 * переключателя
							 */
							if (radiobutton[0].isSelected()) {
								trMult = trMult + 0.34;
							}
							/**
							 * Обновление коэффициента транспорта в случае выбора соответствуюущего
							 * переключателя
							 */
							if (radiobutton[1].isSelected()) {
								trMult = trMult + 0.28;
							}
							/**
							 * Произведение сохранение результатов заявки в документ
							 */
							try {
								b.save(Double.parseDouble(textField[0].getText()) + "/"
										+ Double.parseDouble(textField[1].getText()) + "/"
										+ Double.parseDouble(textField[2].getText()) + "/"
										+ Double.parseDouble(textField[3].getText()) + "/" + trMult + "/"
										+ Double.parseDouble(textField[4].getText()) + "/" + foodMult + "/", "req.txt");
							} catch (Exception e1) {
								e1.printStackTrace();
							}
							/**
							 * Выдача сообщения о положительном результате отправки заявки
							 */
							callMessage(mainPanel, "Заявка отправлена", "Внимание");
							/**
							 * Обнуление коэффициентов
							 */
							foodMult = 1;
							trMult = 1;
							/**
							 * Выдача собощений о неправильном заполнении в форме ввода
							 */
						} else {
							callMessage(mainPanel, "Для отправки заявки выберите хотя бы один тип транспорта",
									"Внимание");
						}
						/**
						 * Выдача собощений о неправильном заполнении в форме ввода
						 */
					} else {
						callMessage(mainPanel, "Для отправки заявки выберите хотя бы один тип питания", "Внимание");
					}
					/**
					 * Выдача собощений о неправильном заполнении в форме ввода
					 */
				} else {
					callMessage(mainPanel, "Для отправки заявки заполните все поля", "Внимание");
				}
			}
		});
		/**
		 * Добавление обработчика для кнопки очистки полей
		 */
		button[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Очитка текстовых полей
				 */
				for (int i = 0; i < 5; i++) {
					textField[i].setText("");
				}
			}
		});
		/**
		 * Добавление обработчика для кнопки перехода к основному окну
		 */
		button[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Отключение видимости основного фрейма
				 */
				mainFrame.setVisible(false);
				/**
				 * Создание экземпляра класса, описывающего граф. интерфейс основного окна
				 */
				InterfaceAdmin a = new InterfaceAdmin();
			}
		});
	}

	/**
	 * 19 Метод, устанавливающий разрешение на выбор только одного переключателя
	 * 
	 * @param radio1 Переключатель, передаваемый методу
	 * @param radio2 Переключатель, передаваемый методу
	 */
	public void selectRadioBtn(final JRadioButton radio1, final JRadioButton radio2) {
		/**
		 * Создание обработчика нажатия для первого переключателя
		 */
		radio1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Установка отметы выбора второго переключателя, при выборе первого
				 * переключателя
				 */
				if (radio1.isSelected())
					radio2.setSelected(false);
			}
		});
		/**
		 * Создание обработчика нажатия для второго переключателя
		 */
		radio2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Установка отметы выбора первого переключателя, при выборе второго
				 * переключателя
				 */
				if (radio2.isSelected())
					radio1.setSelected(false);
			}
		});
	}
}
