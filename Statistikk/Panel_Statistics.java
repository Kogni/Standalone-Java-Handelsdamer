package Statistikk;

import java.awt.Color;

import javax.swing.*;
import javax.swing.border.*;

import Kontroller.*;

public class Panel_Statistics extends JPanel {
	
	Communicator Class_Communicator;
	
	JTabbedPane TotalPanel;
	Border BordSeparation;
	
	public Panel_Statistics( Communicator Class_Communicator ) {
		this.Class_Communicator = Class_Communicator;
		System.out.println ( "Class Panel_Statistics created" );
	}

	public void VisVindu ( ) {
		setVisible ( true );
	}

	public void Startup ( ) {
		System.out.println ( "Class Panel_Statistics started" );
		this.BordSeparation = BorderFactory.createEtchedBorder ( EtchedBorder.RAISED );
		this.setSize ( 400, 400 );
		this.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		
		TotalPanel = new JTabbedPane ( );
		TotalPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		this.TotalPanel.addTab ( "Buyers", Class_Communicator.Class_Panel_Buyers );
		this.TotalPanel.addTab ( "Expenses", Class_Communicator.Class_Panel_Expenses );
		this.TotalPanel.addTab ( "Goods", Class_Communicator.Class_Panel_Goods );
		this.TotalPanel.addTab ( "History", Class_Communicator.Class_Panel_History );
		this.TotalPanel.addTab ( "Income", Class_Communicator.Class_Panel_Income );
		this.TotalPanel.addTab ( "Profit", Class_Communicator.Class_Panel_Profit );
		this.TotalPanel.addTab ( "Sellers", Class_Communicator.Class_Panel_Sellers );
		
		this.add ( TotalPanel );
		this.setVisible(true);
	}

}
