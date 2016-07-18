package Salg;

import java.util.*;

import Varer.Super_Vare;

public class Object_VareUnit extends Super_Vare {
	
	Date Bought;
	double BuyPrice;
	Date Sold;
	private double SellPrice; //hvis varen ikke er solgt skal denne alltid oppdateres til current varepris. Hvis den er solgt skal den aldri endres igjen.
	double Profit;

	public Object_VareUnit(String Varenavn) {
		super(Varenavn);
		// TODO Auto-generated constructor stub
	}

}
