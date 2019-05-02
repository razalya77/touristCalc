package org.ilsss.touristCalc;

/**
 * Импортирование класса, содержащего набор методов сравнения
 */
import static org.junit.Assert.*;

import org.ilsss.touristCalc.Tour;
public class Test5 {
	@org.junit.Test
	public void test5() {	
		/**
		 * Входными данными является метод, производящий расчета стоимости тура
		 * и предполагаемый результат данного расчета
		 */
		Tour a = new Tour(4.0, 7.0, 1000.0, 7000.0, 1.28,150.0,1.52,66.0);
		/**
		 * Сравнение результата и ожидаемого значения
		 */
		assertEquals("70290.0",a.getResult());
	}
}
