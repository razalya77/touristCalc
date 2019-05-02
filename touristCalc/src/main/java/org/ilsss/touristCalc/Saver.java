package org.ilsss.touristCalc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Saver {
	private String temp;
	private String result = "";

	private void load(String filename) throws Exception {
		FileReader fileReader = new FileReader(filename);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		while ((temp = bufferedReader.readLine()) != null) {
			result = temp;
		}
		bufferedReader.close();
	}

	public boolean checkIfEmpty(String filename) throws Exception {
		load(filename);
		if (result.length() == 0)
			return true;
		else
			return false;
	}

	public String getNormalResult() throws Exception {
		load("reqAnswer.txt");
		return result;
	}

	public String[] getReqResult() throws Exception {
		load("req.txt");
		String[] req = result.split("/");
		return req;
	}

	public void save(String enter, String filename) throws Exception {
		FileWriter fileWriter = new FileWriter(filename);
		fileWriter.write(enter);
		fileWriter.close();
	}
}