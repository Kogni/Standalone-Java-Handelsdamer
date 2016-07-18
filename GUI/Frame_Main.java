package GUI;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import Kontroller.*;

public class Frame_Main extends JFrame {
	
	Communicator				Class_Communicator;
	
	JPanel						TotalPanel;
	JTabbedPane					TabbedPanel;
	JPanel GoodsManagement;
	
	Border						BordSeparation;

	public Frame_Main(Communicator Class_Communicator) {
		super ( "Handelsdamer" );
		
		this.Class_Communicator = Class_Communicator;
		

	}
	
	public void Startup() {
		
		System.out.println ( "Class Frame_Main started" );
		this.BordSeparation = BorderFactory.createEtchedBorder ( EtchedBorder.RAISED );
		setSize ( 1000, 800 );
		
		Container pane = getContentPane ( );
		pane.setLayout ( new GridLayout ( 1, 3 ) ); //y, x
		GridBagConstraints c = new GridBagConstraints ( );

		TotalPanel = new JPanel ( );
		TotalPanel.setLayout ( new BoxLayout ( TotalPanel, BoxLayout.LINE_AXIS ) );
		TotalPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		
		GoodsManagement = new JPanel();
		GoodsManagement.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		GoodsManagement.setLayout ( new BoxLayout ( GoodsManagement, BoxLayout.LINE_AXIS ) );
		GoodsManagement.add(Class_Communicator.Class_Panel_EditVare);
		GoodsManagement.add(Class_Communicator.Class_Panel_GoodsList);
		
		TabbedPanel = new JTabbedPane ( );
		//TabbedPanel.setLayout ( new BoxLayout ( TabbedPanel, BoxLayout.LINE_AXIS ) );
		TabbedPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		this.TabbedPanel.addTab ( "Statistics", Class_Communicator.Class_Panel_Statistics );
		this.TabbedPanel.addTab ( "Goods management", GoodsManagement );
		this.TabbedPanel.addTab ( "Profit", new JPanel() );
		this.TabbedPanel.addTab ( "Trends", new JPanel() );
		this.TabbedPanel.addTab ( "Sales", Class_Communicator.Class_Panel_Sales );
		this.TabbedPanel.addTab ( "Purchases",  Class_Communicator.Class_Panel_Purchases );
		this.TabbedPanel.addTab ( "Envelopes", new JPanel() );
		this.TabbedPanel.addTab ( "Shoppinglist", new JPanel() );
		this.TabbedPanel.addTab ( "Considerations", Class_Communicator.Class_Panel_Consideration );
		TotalPanel.add(TabbedPanel);
		
		pane.add ( TotalPanel, c );
		setVisible ( true );
		
	}
}
