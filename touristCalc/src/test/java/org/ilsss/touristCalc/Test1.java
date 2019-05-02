package org.ilsss.touristCalc;

/**
 * Импортирование класса, содержащего набор методов сравнения
 */
import static org.junit.Assert.*;

import org.ilsss.touristCalc.Tour;
public class Test1 {

	@org.junit.Test
	public void test1() {	
		/**
		 * Входными данными является метод, производящий расчета стоимости тура
		 * и предполагаемый результат данного расчета
		 */
		Tour a = new Tour(2.0, 14.0, 1000, 20000, 1.34,100.0,1.78,10.0);
		/**
		 * Сравнение результата и ожидаемого значения
		 */
		assertEquals("86594.0",a.getResult());
	}
}
