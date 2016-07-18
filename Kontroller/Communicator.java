package Kontroller;
import javax.swing.*;

import Statistikk.*;
import Varer.*;

import Considerations.*;
import GUI.*;
import GUI_sales.*;
import Innkjoep.*;

public class Communicator {
	
	public Brain_Varer Class_Brain_Varer;
	public Brain_Statistics Class_Brain_Statistics;
	
	public Panel_Consideration Class_Panel_Consideration;
		public Panel_GoodsSelection Class_Panel_GoodsSelection_Consideration;
		public Panel_ConsiderationStats Class_Panel_ConsiderationStats;
		public Panel_ShippingCosts_Purchase Class_Panel_ShippingCosts_Consideration;
	public Panel_Statistics Class_Panel_Statistics;
		public Panel_Buyers Class_Panel_Buyers;
		public Panel_Expenses Class_Panel_Expenses;
		public Panel_Goods Class_Panel_Goods;
		public Panel_History Class_Panel_History;
		public Panel_Income Class_Panel_Income;
		public Panel_Profit Class_Panel_Profit;
		public Panel_Sellers Class_Panel_Sellers;
	public Panel_EditVare Class_Panel_EditVare;
	public Panel_GoodsList Class_Panel_GoodsList;
	public Panel_Sales Class_Panel_Sales;
		public Panel_NewSale Class_Panel_NewSale;
			public Panel_GoodsSelection Class_Panel_GoodsSelection;
			public Panel_BuyerSelection Class_Panel_BuyerSelection;
			public Panel_CombinedShipping Class_Panel_CombinedShipping;
			public Panel_ShippingCosts Class_Panel_ShippingCosts;
			public Panel_OrderDates Class_Panel_OrderDates;
		public Panel_SalesHistory Class_Panel_SalesHistory;
	public Panel_Purchases Class_Panel_Purchases;
		public Panel_NewPurchase Class_Panel_NewPurchase;
			public Panel_GoodsSelection Class_Panel_GoodsSelection_Purchase;
			public Panel_SellerSelection Class_Panel_SellerSelection;
			public Panel_ShippingCosts_Purchase Class_Panel_ShippingCosts_Purchase;
			public Panel_OrderDates_Purchase Class_Panel_OrderDates_Purchase;
		public Panel_PurchaseHistory Class_Panel_PurchaseHistory;
	public Frame_Main Class_Frame_Main;

	public void SetupProgram() {
		
		Class_Brain_Varer = new Brain_Varer(this);
			Class_Panel_Buyers = new Panel_Buyers(this);
			Class_Panel_Expenses = new Panel_Expenses(this);
			Class_Panel_Goods = new Panel_Goods(this);
			Class_Panel_History = new Panel_History(this);
			Class_Panel_Income = new Panel_Income(this);
			Class_Panel_Profit = new Panel_Profit(this);
			Class_Panel_Sellers = new Panel_Sellers(this);
		Class_Brain_Statistics = new Brain_Statistics(this);
		
		
			Class_Panel_GoodsSelection_Consideration = new Panel_GoodsSelection(this);
			Class_Panel_ConsiderationStats = new Panel_ConsiderationStats(this);
			Class_Panel_ShippingCosts_Consideration = new Panel_ShippingCosts_Purchase(this);
		Class_Panel_Consideration = new Panel_Consideration(this);
		
		Class_Panel_Purchases = new Panel_Purchases(this);
	 	Class_Panel_NewPurchase = new Panel_NewPurchase(this);
	 		Class_Panel_GoodsSelection_Purchase = new Panel_GoodsSelection(this);
			 Class_Panel_SellerSelection = new Panel_SellerSelection();
			 Class_Panel_ShippingCosts_Purchase = new Panel_ShippingCosts_Purchase(this);
			 Class_Panel_OrderDates_Purchase = new Panel_OrderDates_Purchase();
		Class_Panel_PurchaseHistory = new Panel_PurchaseHistory();
		
			Class_Panel_EditVare = new Panel_EditVare(this);
			Class_Panel_GoodsList = new Panel_GoodsList(this);
		Class_Panel_Statistics = new Panel_Statistics(this);
				Class_Panel_GoodsSelection = new Panel_GoodsSelection(this);
				Class_Panel_BuyerSelection = new Panel_BuyerSelection();
				Class_Panel_CombinedShipping = new Panel_CombinedShipping();
				Class_Panel_ShippingCosts = new Panel_ShippingCosts();
				Class_Panel_OrderDates = new Panel_OrderDates();
			Class_Panel_NewSale = new Panel_NewSale(this);
			Class_Panel_SalesHistory = new Panel_SalesHistory();
		Class_Panel_Sales = new Panel_Sales(this);
		
		Class_Frame_Main = new Frame_Main(this);
		Class_Frame_Main.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
	}

	public void Startup() {
		
		Class_Panel_GoodsSelection.Startup();
		Class_Panel_GoodsSelection_Consideration.Startup();
		Class_Panel_GoodsSelection_Purchase.Startup();
		
		Class_Panel_Purchases.Startup();
		 	Class_Panel_NewPurchase.Startup();
				 Class_Panel_GoodsSelection_Purchase.Startup();
				// Class_Panel_SellerSelection.Startup();
				 //Class_Panel_ShippingCosts_Purchase.Startup();
				 //Class_Panel_OrderDates_Purchase.Startup();
		 //Class_Panel_PurchaseHistory.Startup();
		
			Class_Panel_ConsiderationStats.Startup();
		Class_Panel_Consideration.Startup();
			Class_Panel_Buyers.Startup();
			Class_Panel_Expenses.Startup();
			Class_Panel_Goods.Startup();
			Class_Panel_History.Startup();
			Class_Panel_Income.Startup();
			Class_Panel_Profit.Startup();
			Class_Panel_Sellers.Startup();
		Class_Panel_Statistics.Startup();
			Class_Panel_EditVare.Startup();
			Class_Panel_GoodsList.Startup();
			Class_Panel_NewSale.Startup();
		Class_Panel_Sales.Startup();
		Class_Frame_Main.Startup();
	}

	public void SaveItem(Super_Vare NyVare) {
		Class_Brain_Varer.RegistrerVare(NyVare);
		Class_Panel_GoodsList.FillOverview ( );
		//Class_Panel_Statistics.FillLabels ( );
	}

	public void DeleteItem(Super_Vare superVare) {
		Class_Brain_Varer.SlettVare(superVare);
		Class_Panel_GoodsList.FillOverview ( );
		//Class_Panel_Statistics.FillLabels ( );
	}

}
