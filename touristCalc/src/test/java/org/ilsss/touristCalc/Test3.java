package org.ilsss.touristCalc;

/**
 * Импортирование класса, содержащего набор методов сравнения
 */
import static org.junit.Assert.*;

import org.ilsss.touristCalc.Tour;
public class Test3 {
	@org.junit.Test
	public void test3() {	
		/**
		 * Входными данными является метод, производящий расчета стоимости тура
		 * и предполагаемый результат данного расчета
		 */
		Tour a = new Tour(3.0, 7.0, 10000, 100000, 1.34,250.0,1.78,50.0);
		/**
		 * Сравнение результата и ожидаемого значения
		 */
		assertEquals("621395.0",a.getResult());
	}
}
