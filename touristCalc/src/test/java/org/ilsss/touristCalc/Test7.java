package org.ilsss.touristCalc;

/**
 * Импортирование класса, содержащего набор методов сравнения
 */
import static org.junit.Assert.*;

import org.ilsss.touristCalc.Tour;
public class Test7 {
	@org.junit.Test
	public void test7() {	
		/**
		 * Входными данными является метод, производящий расчета стоимости тура
		 * и предполагаемый результат данного расчета
		 */
		Tour a = new Tour(8.0, 31.0, 2000.0, 121000.0, 1.34,150.0,1.52,16.0);
		/**
		 * Сравнение результата и ожидаемого значения
		 */
		assertEquals("1849680.0",a.getResult());
	}
}
