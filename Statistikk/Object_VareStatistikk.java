package Statistikk;

import Varer.Super_Vare;

public class Object_VareStatistikk extends Super_Vare {
	
	double Sold_Weight;
	double Sold_Volume;
	int Sold_Number;
	double Sold_Value;
	
	double Bought_Weight;
	double Bought_Volume;
	int Bought_Number;
	double Bought_Value;
	
	double AvgSalesTime;//days/sold unit
	double AvgSalesVolume;//sold volume/sales
	double AvgProfit;//profit/sales

	public Object_VareStatistikk(String Varenavn) {
		super(Varenavn);
		
	}

}
