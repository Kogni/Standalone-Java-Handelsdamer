package Statistikk;

import java.awt.Color;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import Kontroller.Communicator;

public class Panel_Expenses extends JPanel {
	
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

	JLabel[]					StatsNames					= new JLabel[7];
	JLabel[]					StatsNumbers_Overall		= new JLabel[7];
	JLabel[]					StatsNumbers_Month			= new JLabel[7];
	JLabel[]					StatsNumbers_Week			= new JLabel[7];
	JLabel[]					StatsNumbers_Day			= new JLabel[7];

	JPanel						StatsTextPanel;
	JPanel						StatsBoxPanel;
	JPanel						StatsBasePanel;

	Border						BordSeparation;

	public Panel_Expenses(Communicator Class_Communicator) {
		this.Class_Communicator = Class_Communicator;
	}

	public void Startup ( ) {
		System.out.println ( "Class Panel_Expenses started" );
		this.BordSeparation = BorderFactory.createEtchedBorder ( EtchedBorder.RAISED );
		setSize ( 400, 400 );

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

		this.StatsNames[1].setText ( "EXPENSES" );
		this.StatsNames[2].setText ( "Expenses total" );
		this.StatsNames[3].setText ( "Values received" );
		this.StatsNames[4].setText ( "Values missing" );
		this.StatsNames[5].setText ( "Values lost" );
		this.StatsNames[6].setText ( "Auction costs" );

		for ( int y = 1 ; y < this.LineDown1.length ; y++ ) {
			this.LineDown1[y] = new JPanel ( );
			this.LineDown1[y].setLayout ( new BoxLayout ( this.LineDown1[y], BoxLayout.PAGE_AXIS ) );
			this.LineDown1[y].setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
			StatsPanel.add ( this.LineDown1[y] );
		}
		
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

		StatsNumbers_Overall[2].setText( Double.toString(this.Class_Communicator.Class_Brain_Statistics.Expenses_Total) );
		StatsNumbers_Overall[3].setText( Double.toString(this.Class_Communicator.Class_Brain_Statistics.Money_Received) );
		StatsNumbers_Overall[4].setText( Double.toString(this.Class_Communicator.Class_Brain_Statistics.Money_Missing) );
		StatsNumbers_Overall[5].setText( Double.toString(this.Class_Communicator.Class_Brain_Statistics.Money_Lost) );
		StatsNumbers_Overall[6].setText( Double.toString(this.Class_Communicator.Class_Brain_Statistics.AuctionCosts) );

	}

}
