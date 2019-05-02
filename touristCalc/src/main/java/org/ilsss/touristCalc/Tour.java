package org.ilsss.touristCalc;

public class Tour {
	private double NumDays, NumPeople, transportMultiplier, foodMultiplier, RoomPrice, TransportPrice, FoodPrice, Tax;
	String result;
	String loadResult;

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

	public String getResult() {
		return result;
	}

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