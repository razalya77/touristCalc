package org.ilsss.touristCalc;

/**
 * Импортирование класса, содержащего набор методов сравнения
 */
import static org.junit.Assert.*;

import org.ilsss.touristCalc.Tour;
public class Test4 {
	@org.junit.Test
	public void test4() {	
		/**
		 * Входными данными является метод, производящий расчета стоимости тура
		 * и предполагаемый результат данного расчета
		 */
		Tour a = new Tour(2.0, 21.0, 5000.0, 50000.0, 1.28,150.0,1.78,33.0);
		/**
		 * Сравнение результата и ожидаемого значения
		 */
		assertEquals("349247.0",a.getResult());
	}
}
