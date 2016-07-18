package Innkjoep;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import Kontroller.*;

public class Panel_Purchases extends JPanel {
	
	Communicator Class_Communicator;
	
	JTabbedPane TabbedPanel;
	
	Border Bord;

	public Panel_Purchases(Communicator Class_Communicator) {
		this.Class_Communicator = Class_Communicator;
	}
	
	public void Startup() {
		
		System.out.println ( "Class Panel_Purchases started" );
		
		this.setSize ( 400, 270 );
		this.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		
		this.Bord = BorderFactory.createEtchedBorder ( EtchedBorder.RAISED );
		
		this.setLayout ( new BoxLayout ( this, BoxLayout.PAGE_AXIS ) );
		this.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		this.setBorder ( this.Bord );
		
		TabbedPanel = new JTabbedPane ( );
		TabbedPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		this.TabbedPanel.addTab ( "New purchase", Class_Communicator.Class_Panel_NewPurchase );
		this.TabbedPanel.addTab ( "Purchase history", Class_Communicator.Class_Panel_PurchaseHistory );

		this.add(TabbedPanel);

	}
}
