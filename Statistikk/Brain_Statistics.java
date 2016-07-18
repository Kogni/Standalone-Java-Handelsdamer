package Statistikk;

import Kontroller.Communicator;

public class Brain_Statistics {
	
	Communicator Class_Communicator;
	
	Object_MonthData[] History = new Object_MonthData[999];
	Object_VareStatistikk[] VareStatistikker = new Object_VareStatistikk[999];
	
	//income
	public double Income_WOcancels = 0;
	public double Income_Missing = 0;
	public double Income_Received = 0;
	public double Income_Received_Future = 0;
	public double Income_Cancelled = 0;
	
	//money
	public double Money_Missing = 0;
	public double Money_Received = 0;
	public double Money_Received_LastWeek = 0;
	public double Money_Received_LastMonth = 0;
	public double Money_Received_Future = 0;
	public double Money_Cancelled = 0;
	public double Money_Lost = 0;
	
	//tradevalues
	public double TradeValues_Purchased = 0;
	public double TradeValues_Sold = 0;
	public double TradeValues_Received = 0;
	public double TradeValues_Purchased_Future = 0;
	
	//payments\orders
	public double Payments_Missing = 0;
	public double Orders_Cancelled = 0;
	public double Sales_ReceiptsSent = 0;
	public double Sales_LastWeek = 0;
	public double Sales_LastMonth = 0;
	public double AvgPayTimeInDays = 0;
	
	//shipping
	public double Shipping_Missing = 0;
	public double Shipping_Received = 0;
	public double Shipping_Cancelled = 0;
	public double Shipping_Sold = 0;
	
	//expenses
	public double Expenses_Total = 0;
	public double Expenses_Total_Future = 0;
	public double AuctionCosts = 0;
	public double AuctionCosts_Future = 0;
	
	//profit
	public double Profit_ATM = 0;
	public double Profit_Soon = 0;
	public double Profit_Estimated = 0;
	public double Profit_LastWeek = 0;
	public double Profit_LastMonth = 0;
	public double Profit_Future = 0;
	public double CapitalChange_Future = 0;

	public Brain_Statistics(Communicator Class_Communicator) {
		this.Class_Communicator = Class_Communicator;
	}
}
