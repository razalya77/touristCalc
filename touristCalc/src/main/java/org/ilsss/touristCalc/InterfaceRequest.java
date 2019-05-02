package org.ilsss.touristCalc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InterfaceRequest extends Components {
	/**
	 * Массив для хранения значений заявки
	 */
	private String[] TourStats;
	/**
	 * Инициализация основной панели
	 */
	private JPanel mainPanel;
	/**
	 * Создание экземпляра класса, производящего сохранение
	 */
	private Saver b = new Saver();
	/**
	 * Инициализация основного фрейма
	 */
	private JFrame mainFrame;
	/**
	 * Создание массива для хранения кнопок
	 */
	private JButton[] button = new JButton[4];
	/**
	 * Создание массива для хранения панелей
	 */
	private JPanel[] smallPanel = new JPanel[4];
	/**
	 * Создание массива для хранения лейблов
	 */
	private JLabel[] label = new JLabel[9];
	/**
	 * 21 Создание массива для хранения текстовых полей
	 */
	private JTextField[] textField = new JTextField[9];
	/**
	 * Создание массива с названиями панелей
	 */
	private String[] smallPanelNames = { "Основные данные", "Транспорт", "Питание", "Процент" };
	/**
	 * Создание массива с названиями кнопок
	 */
	private String[] buttonNames = { "Рассчитать", "Принять заявку", "Отклонить заявку", "Вернуться на основное окно" };
	/**
	 * Создание массива с названиями лейблов
	 */
	private String[] labelNames = { "Количество людей", "Количество суток",
			"Цена проживания на одного человека за сутки", "Стоимость транспорта туда-обратно", "Множитель транспорта:",
			"Стоимость питания за порцию", "Множитель еды:", "Итоговая стоимость:", "Налог " };
	/**
	 * Создание массива с размерами панелей
	 */
	private int[] smallPanelBounds = { 6, 0, 390, 115, 6, 115, 390, 85, 6, 200, 390, 85, 6, 285, 390, 55 };
	/**
	 * Создание массива с размерами лейблов
	 */
	private int[] labelBounds = { 10, 5, 280, 50, 10, 35, 280, 50, 10, 65, 280, 50, 10, 5, 210, 50, 10, 30, 200, 50, 10,
			5, 200, 50, 10, 30, 200, 50, 400, 17, 130, 25, 10, 5, 280, 50 };
	/**
	 * Создание массива с размерами текстовых полей
	 */
	private int[] textFieldsBounds = { 290, 17, 90, 25, 290, 47, 90, 25, 290, 77, 90, 25, 290, 17, 90, 25, 290, 47, 90,
			25, 290, 17, 90, 25, 290, 47, 90, 25, 547, 17, 90, 25, 290, 17, 90, 25 };
	/**
	 * Создание массива с размерами кнопок
	 */
	private int[] buttonBounds = { 400, 47, 237, 25, 400, 77, 237, 25, 400, 107, 237, 25, 400, 137, 237, 25 };

	public InterfaceRequest() throws Exception {
		/**
		 * Создание основной панели
		 */
		mainPanel = CreateMainPanel();
		/**
		 * Создание основного окна
		 */
		mainFrame = CreateMainFrame("Окно менеджера", mainPanel, 650, 375);
		/**
		 * Заполнение массива лейблов и текстовых полей названиями и размерами
		 */
		for (int i = 0; i < 9; i++) {
			label[i] = CreateLabel(labelNames[i], labelBounds[i * 4], labelBounds[i * 4 + 1], labelBounds[i * 4 + 2],
					labelBounds[i * 4 + 3]);
			textField[i] = CreateTextField(textFieldsBounds[i * 4], textFieldsBounds[i * 4 + 1],
					textFieldsBounds[i * 4 + 2], textFieldsBounds[i * 4 + 3]);
		}
		/**
		 * Создание текстового фильтра
		 */
		textFieldFilter j = new textFieldFilter();
		/**
		 * Применение текстового фильтра к текстовым полям 23
		 */
		j.PTextFilter(textField[8], 2);
		/**
		 * Создание панелей с рамками, прикрепление кнопок к ним
		 */
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
		/**
		 * Установка запрета на редактирование текстовых полей
		 */
		for (int i = 0; i < 8; i++) {
			textField[i].setEditable(false);
		}
		/**
		 * Добавление к панелям лейблов и текстовых полей
		 */
		for (int i = 3; i < 5; i++) {
			smallPanel[1].add(label[i]);
			smallPanel[1].add(textField[i]);
		}
		for (int i = 5; i < 7; i++) {
			smallPanel[2].add(label[i]);
			smallPanel[2].add(textField[i]);
		}
		/**
		 * 24 Прикрепление оставшихся графических элементов к панелям
		 */
		mainPanel.add(label[7]);
		mainPanel.add(textField[7]);
		smallPanel[3].add(textField[8]);
		smallPanel[3].add(label[8]);
		/**
		 * Проверка наличия заявки
		 */
		if (b.checkIfEmpty("req.txt") == true) {
			/**
			 * Обработка случая отсутствия заявки
			 */
			callMessage(mainPanel, "Заявки не была получена, сначала заполните заявку в режиме клиента", "Внимание");
		} else {
			/**
			 * Обработка при наличии заявки
			 */
			mainFrame.setVisible(true);
			callMessage(mainPanel, "Была получена заявка, поля были заполнены данными из заявки", "Внимание");
			/**
			 * Получение данных из заявки
			 */
			TourStats = b.getReqResult();
			/**
			 * Заполнения полей данными из заявки
			 */
			for (int i = 0; i < 7; i++) {
				textField[i].setText(TourStats[i]);
			}
		}
		/**
		 * Добавление обработчика для кнопки расчета
		 */
		button[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					/**
					 * Проверка наличия заявки
					 */
					if (b.checkIfEmpty("req.txt") != true) {
						/**
						 * Создания экземпляра класса тура со значениями из заявки
						 */
						if (!textField[8].getText().isEmpty()) {
							Tour a = new Tour(toDouble(TourStats[0]), toDouble(TourStats[1]), toDouble(TourStats[2]),
									toDouble(TourStats[3]), toDouble(TourStats[4]), toDouble(TourStats[5]),
									toDouble(TourStats[6]), toDouble(textField[8].getText()));
							/**
							 * Получение результата стоимости тура, внесение результата в текстовое поле
							 */
							textField[7].setText(a.getResult());
						} else {
							/**
							 * Обработка в случае пустого поля налога
							 */
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
		/**
		 * Добавление обработчика для кнопки подтверждения заявки
		 */
		button[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					/**
					 * Обработка подтверждения заявки
					 */
					if (!textField[7].getText().isEmpty()) {
						/**
						 * Сохранение результата в файл
						 */
						b.save(textField[7].getText(), "ReqAnswer.txt");
					} else {
						/**
						 * Обработка случая отсутствия расчета перед отправкой заявки
						 */
						callMessage(mainPanel,
								"Для подтверждения и отправки заявки сначала рассчитайте стоимость тура в ней",
								"Внимание");
					}
				} catch (Exception e1) {
				}
			}
		});
		/**
		 * Добавление обработчика для кнопки отклонения заявки
		 */
		button[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					/**
					 * 27 Очистка документов, содержащих данные о заявке
					 */
					b.save("", "req.txt");
					b.save("", "ReqAnswer.txt");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				/**
				 * Выдача сообщения о отмене заявки
				 */
				callMessage(mainPanel,
						"Заявка была отменена, все данные, связанные с ней, были удалены. Вы будете перенаправленны на начальную форму.",
						"Внимание");
				/**
				 * Закрытие текущего окна
				 */
				mainFrame.setVisible(false);
				/**
				 * Произведение вызова основного окна
				 */
				InterfaceAdmin a = new InterfaceAdmin();
			}
		});
		/**
		 * Добавление обработчика событий для кнопки выхода из формы менеджера
		 */
		button[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Закрытие текущего окна
				 */
				mainFrame.setVisible(false);
				/**
				 * Произведение вызова основного окна 28
				 */
				InterfaceAdmin a = new InterfaceAdmin();
			}
		});
	}
}
