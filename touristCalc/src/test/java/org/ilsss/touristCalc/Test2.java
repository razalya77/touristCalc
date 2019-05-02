package org.ilsss.touristCalc;

/**
 * Импортирование класса, содержащего набор методов сравнения
 */
import static org.junit.Assert.*;

import org.ilsss.touristCalc.Tour;
public class Test2 {
	@org.junit.Test
	public void test2() {	
		/**
		 * Входными данными является метод, производящий расчета стоимости тура
		 * и предполагаемый результат данного расчета
		 */
		Tour a = new Tour(1.0, 14.0, 6000, 40000, 1.34,200.0,1.78,99.0);
		/**
		 * Сравнение результата и ожидаемого значения
		 */
		assertEquals("142683.0",a.getResult());
	}
}
