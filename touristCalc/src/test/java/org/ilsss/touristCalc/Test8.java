package org.ilsss.touristCalc;

/**
 * Импортирование класса, содержащего набор методов сравнения
 */
import static org.junit.Assert.*;

import org.ilsss.touristCalc.Tour;
public class Test8 {
	@org.junit.Test
	public void test8() {	
		/**
		 * Входными данными является метод, производящий расчета стоимости тура
		 * и предполагаемый результат данного расчета
		 */
		Tour a = new Tour(22.0, 7.0, 500.0, 50000.0, 1.28,250.0,1.78,69.0);
		/**
		 * Сравнение результата и ожидаемого значения
		 */
		assertEquals("1553599.0",a.getResult());
	}
}
