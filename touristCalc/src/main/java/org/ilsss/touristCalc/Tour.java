package org.ilsss.touristCalc;

public class Tour {
	/**
	 * Переменные, используемые при расчете стоимости тура
	 */
	private double NumDays, NumPeople, transportMultiplier, foodMultiplier, RoomPrice, TransportPrice, FoodPrice, Tax;
	/**
	 * Строки, в которуе записывается результаты для вывода
	 */
	String result;
	String loadResult;

	/**
	 * Конструктор класса расчета стоимости тура
	 * 
	 * @param NumDays             Количество дней
	 * @param NumPeople           Количество людей
	 * @param transportMultiplier Коэффициент цены транспорта
	 * @param foodMultiplier      Коэффициент цены еды
	 * @param RoomPrice           Цена проживания
	 * @param TransportPrice      Цена транспорта
	 * @param FoodPrice           Цена еды
	 * @param Tax                 Налог на общую стоимость
	 */
	public Tour(double NumPeople, double NumDays, double RoomPrice, double TransportPrice, double transportMultiplier,
			double FoodPrice, double foodMultiplier, double Tax) {
		this.NumDays = NumDays;
		this.NumPeople = NumPeople;
		this.transportMultiplier = transportMultiplier;
		this.foodMultiplier = foodMultiplier;
		this.RoomPrice = RoomPrice;
		this.TransportPrice = TransportPrice;
		this.FoodPrice = FoodPrice;
		this.Tax = Tax;
		result = calcTourCost(NumPeople, NumDays, RoomPrice, TransportPrice, transportMultiplier, FoodPrice,
				foodMultiplier, Tax);
	}

	/**
	 * Метод, возвращающий результат в строковом типе для вывода в текстовом поле
	 * 
	 * @return Строка, в которую записывается результат для вывода
	 */
	public String getResult() {
		return result;
	}

	/**
	 * Метод расчета стоимости тура
	 * 
	 * @param NumDays             Количество дней
	 * @param NumPeople           Количество людей
	 * @param transportMultiplier Коэффициент цены транспорта
	 * @param foodMultiplier      Коэффициент цены еды
	 * @param RoomPrice           Цена проживания
	 * @param TransportPrice      Цена транспорта
	 * @param FoodPrice           Цена еды
	 * @return Стоимость тура
	 */
	private String calcTourCost(double NumPeople, double NumDays, double RoomPrice, double TransportPrice,
			double transportMultiplier, double FoodPrice, double foodMultiplier, double Tax) {
		String TourPriceString = null;
		double TourPriceDouble = 0;
		TourPriceDouble = ((RoomPrice * NumDays * NumPeople) + (TransportPrice * NumPeople * transportMultiplier)
				+ (FoodPrice * NumPeople * NumDays * foodMultiplier)) + Tax;
		TourPriceString = Double.toString(TourPriceDouble);
		return TourPriceString;
	}
}