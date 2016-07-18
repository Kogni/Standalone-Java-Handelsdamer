package Statistikk;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import Kontroller.*;

public class Panel_Income extends JPanel {

	private static final long	serialVersionUID	= 1L;

	Communicator				Class_Communicator;
	
	JPanel						TotalPanel;
	JPanel						StatsPanel;
		JPanel					LineDown1[]			= new JPanel[5];
	JPanel						TalentsPanel;
	JPanel						PlayingmodesPanel;
	JPanel						SourcePanel;

	JPanel						Numbers_Overall_Panel;
	JPanel						Numbers_Month_Panel;
	JPanel						Numbers_Week_Panel;
	JPanel						Numbers_Day_Panel;

	JLabel[]					StatsNames					= new JLabel[35];
	JLabel[]					StatsNumbers_Overall		= new JLabel[35];
	JLabel[]					StatsNumbers_Month			= new JLabel[35];
	JLabel[]					StatsNumbers_Week			= new JLabel[35];
	JLabel[]					StatsNumbers_Day			= new JLabel[35];

	JPanel						cards				= new JPanel ( );
	JPanel						StatsTextPanel;
	JPanel						StatsBoxPanel;
	JPanel						StatsBasePanel;

	Border						BordSeparation;

	public Panel_Income (Communicator Class_Communicator) {
		this.Class_Communicator = Class_Communicator;
		System.out.println ( "Class Panel_Income created" );
	}

	public void VisVindu ( ) {
		setVisible ( true );
		this.FillLabels();
	}

	public void Startup ( ) {
		System.out.println ( "Class Panel_Income started" );
		this.BordSeparation = BorderFactory.createEtchedBorder ( EtchedBorder.RAISED );
		this.setSize ( 400, 400 );

		TotalPanel = new JPanel ( );
		TotalPanel.setLayout ( new BoxLayout ( TotalPanel, BoxLayout.LINE_AXIS ) );
		TotalPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		
		StatsPanel = new JPanel ( );
		StatsPanel.setLayout ( new BoxLayout ( StatsPanel, BoxLayout.LINE_AXIS ) );
		StatsPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		
		TalentsPanel = new JPanel ( );
		TalentsPanel.setLayout ( new BoxLayout ( TalentsPanel, BoxLayout.LINE_AXIS ) );
		TalentsPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		
		PlayingmodesPanel = new JPanel ( );
		PlayingmodesPanel.setLayout ( new BoxLayout ( PlayingmodesPanel, BoxLayout.LINE_AXIS ) );
		PlayingmodesPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		
		SourcePanel = new JPanel ( );
		SourcePanel.setLayout ( new BoxLayout ( SourcePanel, BoxLayout.LINE_AXIS ) );
		SourcePanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );

		TotalPanel.add(StatsPanel);

		//StatsTalentsModePanel = new JPanel ( );
		//StatsTalentsModePanel.setLayout ( new BoxLayout ( StatsTalentsModePanel, BoxLayout.LINE_AXIS ) );
		//TotalPanel.add ( StatsTalentsModePanel, c );

		//UpperPanel = new JPanel ( );
		//UpperPanel.setLayout ( new BoxLayout ( UpperPanel, BoxLayout.LINE_AXIS ) );
		//UpperPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		
		for ( int y = 0 ; y < this.StatsNames.length ; y++ ) {
			this.StatsNames[y] = new JLabel ( " " );
			this.StatsNumbers_Overall[y] = new JLabel ( "# Overall"  );
			this.StatsNumbers_Month[y] = new JLabel ( "# month"  );
			this.StatsNumbers_Week[y] = new JLabel ( "# week"  );
			this.StatsNumbers_Day[y] = new JLabel ( "# day"  );
		}
		for ( int y = 1 ; y < this.StatsNames.length ; y++ ) {
			this.StatsNames[y].setText( " " );
			this.StatsNumbers_Overall[y].setText( " "  );
			this.StatsNumbers_Month[y].setText( " "  );
			this.StatsNumbers_Week[y].setText( " "  );
			this.StatsNumbers_Day[y].setText( " "  );
		}

		this.StatsNames[1].setText ( "INCOME" );
		this.StatsNames[2].setText ( "Purchased values" );
		this.StatsNames[3].setText ( "Income (w.o cancels)" );
		this.StatsNames[4].setText ( "Shipping" );
		this.StatsNames[5].setText ( " " );
		this.StatsNames[6].setText ( "Payments missing" );
		this.StatsNames[7].setText ( "Money missing" );
		this.StatsNames[8].setText ( "Income missing" );
		this.StatsNames[9].setText ( "Shipping missing" );
		this.StatsNames[10].setText ( " " );
		this.StatsNames[11].setText ( "Received money" );
		this.StatsNames[12].setText ( "Income received" );
		this.StatsNames[13].setText ( "Shipping received" );
		this.StatsNames[14].setText ( " " );
		this.StatsNames[15].setText ( "Cancelled orders" );
		this.StatsNames[16].setText ( "Cancelled values" );
		this.StatsNames[17].setText ( "Cancelled income" );
		this.StatsNames[18].setText ( "Cancelled shipping" );
		this.StatsNames[19].setText ( " " );
		this.StatsNames[20].setText ( "Sales" );
		this.StatsNames[21].setText ( "Receipts sent" );
		this.StatsNames[22].setText ( "Values sold" );
		this.StatsNames[23].setText ( "Shipping sold" );
		this.StatsNames[24].setText ( " " );
		this.StatsNames[25].setText ( "Avg pay time in days" );
		this.StatsNames[26].setText ( " " );
		this.StatsNames[27].setText ( "FUTURE" );
		this.StatsNames[28].setText ( "Money spent" );
		this.StatsNames[29].setText ( "Values bought" );
		this.StatsNames[30].setText ( "Values lost" );
		this.StatsNames[31].setText ( "Auction expenses" );
		this.StatsNames[32].setText ( "Money earned" );
		this.StatsNames[33].setText ( "Profit" );
		this.StatsNames[34].setText ( "Capital change" );

		//this.Ding = new JButton ( "Ding" );

		for ( int y = 1 ; y < this.LineDown1.length ; y++ ) {
			this.LineDown1[y] = new JPanel ( );
			this.LineDown1[y].setLayout ( new BoxLayout ( this.LineDown1[y], BoxLayout.PAGE_AXIS ) );
			this.LineDown1[y].setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
			StatsPanel.add ( this.LineDown1[y] );
		}
		/*
		this.CharDescr1 = new JLabel ( " " + "" );
		this.LineDown1[1].add ( this.CharDescr1, c );

		AbovePanel = new JPanel ( );
		AbovePanel.setLayout ( new BoxLayout ( AbovePanel, BoxLayout.PAGE_AXIS ) );

		if ( 0 < 80 ) {
			this.LineDown1[1].add ( this.Ding, c );
			this.Ding.addActionListener ( this );
			this.Ding.setActionCommand ( "Ding" );
		}
		*/
		
		StatsBoxPanel = new JPanel ( );
		StatsBoxPanel.setLayout ( new BoxLayout ( StatsBoxPanel, BoxLayout.PAGE_AXIS ) );
		StatsBoxPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		
		StatsTextPanel = new JPanel ( );
		StatsTextPanel.setLayout ( new BoxLayout ( StatsTextPanel, BoxLayout.PAGE_AXIS ) );
		StatsTextPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		
		//this.LineDown1[1].add ( AbovePanel );
		this.LineDown1[1].add ( this.StatsBoxPanel );
		this.StatsBoxPanel.setLayout ( new BoxLayout ( this.StatsBoxPanel, BoxLayout.LINE_AXIS ) );
		this.StatsTextPanel.setLayout ( new BoxLayout ( this.StatsTextPanel, BoxLayout.PAGE_AXIS ) );
		this.StatsTextPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		this.StatsTextPanel.setBorder ( this.BordSeparation );
		for ( int y = 0 ; y < this.StatsNames.length ; y++ ) {
			if ( this.StatsNames[y] != null ) {
				this.StatsTextPanel.add ( this.StatsNames[y] );
			}
		}
		this.StatsBoxPanel.add ( this.StatsTextPanel );

		this.Numbers_Overall_Panel = new JPanel ( );
		this.Numbers_Overall_Panel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		this.Numbers_Overall_Panel.setLayout ( new BoxLayout ( this.Numbers_Overall_Panel, BoxLayout.PAGE_AXIS ) );
		this.Numbers_Overall_Panel.setBorder ( this.BordSeparation );
		for ( int y = 0 ; y < this.StatsNumbers_Overall.length ; y++ ) {
			if ( this.StatsNumbers_Overall[y] != null ) {
				this.Numbers_Overall_Panel.add ( this.StatsNumbers_Overall[y] );
			}
		}
		this.StatsBoxPanel.add ( this.Numbers_Overall_Panel );

		Numbers_Month_Panel = new JPanel ( );
		Numbers_Month_Panel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		Numbers_Month_Panel.setLayout ( new BoxLayout ( Numbers_Month_Panel, BoxLayout.PAGE_AXIS ) );
		Numbers_Month_Panel.setBorder ( this.BordSeparation );
		for ( int y = 0 ; y < this.StatsNumbers_Month.length ; y++ ) {
			if ( this.StatsNumbers_Month[y] != null ) {
				Numbers_Month_Panel.add ( this.StatsNumbers_Month[y] );
			}
		}
		this.StatsBoxPanel.add ( Numbers_Month_Panel );

		Numbers_Week_Panel = new JPanel ( );
		Numbers_Week_Panel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		Numbers_Week_Panel.setLayout ( new BoxLayout ( Numbers_Week_Panel, BoxLayout.PAGE_AXIS ) );
		Numbers_Week_Panel.setBorder ( this.BordSeparation );
		for ( int y = 0 ; y < this.StatsNumbers_Week.length ; y++ ) {
			if ( this.StatsNumbers_Week[y] != null ) {
				Numbers_Week_Panel.add ( this.StatsNumbers_Week[y] );
			}
		}
		this.StatsBoxPanel.add ( Numbers_Week_Panel );
		
		Numbers_Day_Panel = new JPanel ( );
		Numbers_Day_Panel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		Numbers_Day_Panel.setLayout ( new BoxLayout ( Numbers_Day_Panel, BoxLayout.PAGE_AXIS ) );
		Numbers_Day_Panel.setBorder ( this.BordSeparation );
		for ( int y = 0 ; y < this.StatsNumbers_Day.length ; y++ ) {
			if ( this.StatsNumbers_Day[y] != null ) {
				Numbers_Day_Panel.add ( this.StatsNumbers_Day[y] );
			}
		}
		this.StatsBoxPanel.add ( Numbers_Day_Panel );

		this.add ( TotalPanel );
		FillLabels ( );
	}

	public void FillLabels ( ) {

		StatsNumbers_Overall[2].setText( Double.toString(this.Class_Communicator.Class_Brain_Statistics.TradeValues_Purchased) );
		StatsNumbers_Overall[3].setText( Double.toString(this.Class_Communicator.Class_Brain_Statistics.Income_WOcancels) );
		StatsNumbers_Overall[4].setText( Double.toString(this.Class_Communicator.Class_Brain_Statistics.Shipping_Received) );
		
		StatsNumbers_Overall[6].setText( Double.toString(this.Class_Communicator.Class_Brain_Statistics.Payments_Missing) );
		StatsNumbers_Overall[7].setText( Double.toString(this.Class_Communicator.Class_Brain_Statistics.Money_Missing) );
		StatsNumbers_Overall[8].setText( Double.toString(this.Class_Communicator.Class_Brain_Statistics.Income_Missing) );
		StatsNumbers_Overall[9].setText( Double.toString(this.Class_Communicator.Class_Brain_Statistics.Shipping_Missing) );
		
		StatsNumbers_Overall[11].setText( Double.toString(this.Class_Communicator.Class_Brain_Statistics.Money_Received) );
		StatsNumbers_Overall[12].setText( Double.toString(this.Class_Communicator.Class_Brain_Statistics.Income_Received) );
		StatsNumbers_Overall[13].setText( Double.toString(this.Class_Communicator.Class_Brain_Statistics.Shipping_Received) );
		
		StatsNumbers_Overall[15].setText( Double.toString(this.Class_Communicator.Class_Brain_Statistics.Orders_Cancelled) );
		StatsNumbers_Overall[16].setText( Double.toString(this.Class_Communicator.Class_Brain_Statistics.Money_Cancelled) );
		StatsNumbers_Overall[17].setText( Double.toString(this.Class_Communicator.Class_Brain_Statistics.Income_Cancelled) );
		StatsNumbers_Overall[18].setText( Double.toString(this.Class_Communicator.Class_Brain_Statistics.Shipping_Cancelled) );
		
		StatsNumbers_Overall[20].setText( "?" );
		StatsNumbers_Overall[21].setText( Double.toString(this.Class_Communicator.Class_Brain_Statistics.Sales_ReceiptsSent) );
		StatsNumbers_Overall[22].setText( Double.toString(this.Class_Communicator.Class_Brain_Statistics.TradeValues_Sold) );
		StatsNumbers_Overall[23].setText( Double.toString(this.Class_Communicator.Class_Brain_Statistics.Shipping_Sold) );
		
		StatsNumbers_Overall[25].setText( Double.toString(this.Class_Communicator.Class_Brain_Statistics.AvgPayTimeInDays) );

		StatsNumbers_Overall[26].setText( Double.toString(this.Class_Communicator.Class_Brain_Statistics.Expenses_Total_Future) );
		StatsNumbers_Overall[27].setText( Double.toString(this.Class_Communicator.Class_Brain_Statistics.TradeValues_Purchased_Future) );
		StatsNumbers_Overall[28].setText( Double.toString(this.Class_Communicator.Class_Brain_Statistics.Money_Lost) );
		StatsNumbers_Overall[29].setText( Double.toString(this.Class_Communicator.Class_Brain_Statistics.AuctionCosts_Future) );
		StatsNumbers_Overall[30].setText( Double.toString(this.Class_Communicator.Class_Brain_Statistics.Profit_Future) );
		StatsNumbers_Overall[31].setText( "?" );
		StatsNumbers_Overall[32].setText( Double.toString(this.Class_Communicator.Class_Brain_Statistics.CapitalChange_Future) );

	}

	public void itemStateChanged ( ItemEvent evt ) {
		CardLayout cl = ( CardLayout ) ( this.cards.getLayout ( ) );
		cl.show ( this.cards, ( String ) evt.getItem ( ) );
	}

	public void actionPerformed ( ActionEvent e ) {
		if ( e.getActionCommand ( ).equals ( "Ding" ) ) {
			/*
			this.Class_Communicator.Command_CharacterLevel();
			if ( 0 >= 80 ) {
				this.Ding.enable ( false );
				this.Ding.setVisible ( false );
			}
			*/
		}
	}

}
