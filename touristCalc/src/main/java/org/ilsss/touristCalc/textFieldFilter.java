package org.ilsss.touristCalc;

/**
* Импортирование библиотеки, описывающей текстовые поля
*/
import javax.swing.JTextField;
/**
* Импортирование библиотек, описывающих документ
*/
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class textFieldFilter {
	private static void TextFilter(JTextField TextField, final int length) {
		/**
		 * Создание нового пустого документа
		 */
		TextField.setDocument(new PlainDocument() {
			/**
			 * Задание строки символов, разрешенных для записи
			 */
			String chars = "0123456789.";

			/**
			 * Вставка символов в пустой документа
			 */
			public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
				if (chars.indexOf(str) != -1) {
					if (getLength() < length) {
						super.insertString(offs, str, a);
					}
				}
			}
		});
	}

	/**
	 * Метод применения фильтра к текстовому полю
	 * 
	 * @param TextField текстовое поле для изменения
	 * @param length    устанавливаемая длинна в текстовом поле
	 */
	public static void PTextFilter(JTextField TextField, final int length) {
		TextFilter(TextField, length);
	}
}
