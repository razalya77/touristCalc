package org.ilsss.touristCalc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Saver {
	/**
	 * Строка для хранения промежуточных значений
	 */
	private String temp;
	/**
	 * Строка для хранения результата
	 */
	private String result = "";

	/**
	 * Метод считывания данных из файла
	 * 
	 * @param filename Название файла, из которого производится считывание
	 */
	private void load(String filename) throws Exception {
		FileReader fileReader = new FileReader(filename);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		while ((temp = bufferedReader.readLine()) != null) {
			result = temp;
		}
		bufferedReader.close();
	}

	/**
	 * Проверка наличая содержимого у файла
	 * 
	 * @param filename Названия файла
	 * @return Булего значение, показываешь наличие или отсутствие содержимого в
	 *         файле
	 */
	public boolean checkIfEmpty(String filename) throws Exception {
		load(filename);
		if (result.length() == 0)
			return true;
		else
			return false;
	}

	/**
	 * Метод, загружающий содержимое файла reqAnswer.txt
	 */
	public String getNormalResult() throws Exception {
		load("reqAnswer.txt");
		return result;
	}

	/**
	 * Метод, загружающий содержимое файла req.txt
	 */
	public String[] getReqResult() throws Exception {
		load("req.txt");
		String[] req = result.split("/");
		return req;
	}

	/**
	 * Метод, производящий сохранение в файл
	 * 
	 * @param enter    Значение для записи 30
	 * @param filename Название файла, в который будет произведено сохранение
	 */
	public void save(String enter, String filename) throws Exception {
		FileWriter fileWriter = new FileWriter(filename);
		fileWriter.write(enter);
		fileWriter.close();
	}
}