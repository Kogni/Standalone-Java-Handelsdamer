package GUI_sales;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import Kontroller.*;

public class Panel_NewSale extends JPanel {
	
	Communicator Class_Communicator;
	
	Border Bord;

	public Panel_NewSale(Communicator Class_Communicator) {
		this.Class_Communicator = Class_Communicator;
	}
	
	public void Startup() {
		System.out.println ( "Class Panel_NewSale started" );
		
		this.setSize ( 400, 270 );
		this.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		
		this.Bord = BorderFactory.createEtchedBorder ( EtchedBorder.RAISED );
		
		this.setLayout ( new BoxLayout ( this, BoxLayout.PAGE_AXIS ) );
		this.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		this.setBorder ( this.Bord );
		
		Class_Communicator.Class_Panel_GoodsSelection.setBorder ( this.Bord );
		Class_Communicator.Class_Panel_BuyerSelection.setBorder ( this.Bord );
		Class_Communicator.Class_Panel_CombinedShipping.setBorder ( this.Bord );
		Class_Communicator.Class_Panel_ShippingCosts.setBorder ( this.Bord );
		Class_Communicator.Class_Panel_OrderDates.setBorder ( this.Bord );
		this.add(Class_Communicator.Class_Panel_GoodsSelection);
		this.add(Class_Communicator.Class_Panel_BuyerSelection);
		this.add(Class_Communicator.Class_Panel_CombinedShipping);
		this.add(Class_Communicator.Class_Panel_ShippingCosts);
		this.add(Class_Communicator.Class_Panel_OrderDates);
	}
}
