package org.ilsss.touristCalc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class InterfaceAdmin extends Components {
	/**
	 * Инициализация основной панели
	 */
	private JPanel mainPanel;
	/**
	 * Инициализация основного фрейма
	 */
	private JFrame mainFrame;
	/**
	 * Создание массива с названиями кнопок
	 */
	private String[] buttonNames = { "Менеджер", "Клиент" };
	/**
	 * Создание массива для хранения кнопок
	 */
	private JButton[] button = new JButton[2];
	/**
	 * Создание массива с координатами кнопок
	 */
	private int[] buttonBounds = { 7, 37, 250, 25, 7, 67, 250, 25 };

	public InterfaceAdmin() {
		/**
		 * Создание основной панели
		 */
		mainPanel = CreateMainPanel();
		/**
		 * Создание фрейма
		 */
		mainFrame = CreateMainFrame("Расчет стоимости тура", mainPanel, 270, 170);
		/**
		 * Создание кнопок, прикрепление к ним названий и задание размеров, прикрепление
		 * их к панели
		 */
		for (int i = 0; i < 2; i++) {
			button[i] = CreateButton(buttonNames[i], buttonBounds[i * 4], buttonBounds[i * 4 + 1],
					buttonBounds[i * 4 + 2], buttonBounds[i * 4 + 3]);
			mainPanel.add(button[i]);
		}
		/**
		 * Добавление обработчика для кнопки перехода в окно менеджера
		 */
		button[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					/**
					 * Создание экземпляра формы менеджера
					 */
					InterfaceRequest a = new InterfaceRequest();
					/**
					 * Закрытие текущего окна
					 */
					mainFrame.dispose();
					/**
					 * Обработка, в случае ошибки 8
					 */
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		/**
		 * Добавление обработчика для кнопки перехода в окно клиента
		 */
		button[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					/**
					 * Создание экземпляра формы клиента
					 */
					InterfaceClient a = new InterfaceClient();
					/**
					 * Закрытие текущего окна
					 */
					mainFrame.dispose();
					/**
					 * Обработка, в случае ошибки
					 */
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		/**
		 * Включение видимости окна
		 */
		mainFrame.setVisible(true);
	}
}