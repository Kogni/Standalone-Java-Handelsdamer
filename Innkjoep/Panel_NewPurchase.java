package Innkjoep;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import Kontroller.*;

public class Panel_NewPurchase extends JPanel {
	
	Communicator Class_Communicator;
	
	Border Bord;

	public Panel_NewPurchase(Communicator Class_Communicator) {
		this.Class_Communicator = Class_Communicator;
	}
	
	public void Startup() {
		
		System.out.println ( "Class Panel_NewPurchase started" );
		
		this.setSize ( 400, 270 );
		this.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		
		this.Bord = BorderFactory.createEtchedBorder ( EtchedBorder.RAISED );
		
		this.setLayout ( new BoxLayout ( this, BoxLayout.PAGE_AXIS ) );
		this.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		this.setBorder ( this.Bord );
		
		Class_Communicator.Class_Panel_GoodsSelection_Purchase.setBorder ( this.Bord );
		Class_Communicator.Class_Panel_SellerSelection.setBorder ( this.Bord );
		Class_Communicator.Class_Panel_ShippingCosts_Purchase.setBorder ( this.Bord );
		Class_Communicator.Class_Panel_OrderDates_Purchase.setBorder ( this.Bord );
		this.add(Class_Communicator.Class_Panel_GoodsSelection_Purchase);
		this.add(Class_Communicator.Class_Panel_SellerSelection);
		this.add(Class_Communicator.Class_Panel_ShippingCosts_Purchase);
		this.add(Class_Communicator.Class_Panel_OrderDates_Purchase);
	}
}
