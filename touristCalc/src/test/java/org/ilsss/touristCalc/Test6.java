package org.ilsss.touristCalc;

/**
 * Импортирование класса, содержащего набор методов сравнения
 */
import static org.junit.Assert.*;

import org.ilsss.touristCalc.Tour;
public class Test6 {
	@org.junit.Test
	public void test6() {	
		/**
		 * Входными данными является метод, производящий расчета стоимости тура
		 * и предполагаемый результат данного расчета
		 */
		Tour a = new Tour(10.0, 2.0, 2000.0, 5000.0, 1.28,200.0,1.26,78.0);
		/**
		 * Сравнение результата и ожидаемого значения
		 */
		assertEquals("109118.0",a.getResult());
	}
}
