package Considerations;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

import Kontroller.*;
import Varer.*;

public class Panel_ConsiderationStats extends JPanel implements ActionListener, ChangeListener, FocusListener {

	Communicator Class_Communicator;

	JPanel						TotalPanel					= new JPanel ( );
	JPanel						TotalPanelLines				= new JPanel();

	JPanel						StatsPanel_Comparison;
	JPanel[]					StatsCollumns_Comparison	= new JPanel[2];
	JTextField[]				InputFields				= new JTextField[10];
	//JComboBox					DosageTypes;

	Border						Bord;

	JPanel						ButtonPanel				= new JPanel();
	JButton						ResetChanges				= new JButton ( );
	JButton						Save				= new JButton ( );
	JButton						Delete				= new JButton ( );

	boolean						Updating;

	public Panel_ConsiderationStats ( Communicator Class_Communicator ) {
		this.Class_Communicator = Class_Communicator;
		this.Updating = true;
		System.out.println ( "Class Panel_EditVare created" );
	}

	public void Startup ( ) {
		System.out.println ( "Class Panel_EditVare started" );
		this.setSize ( 400, 270 );
		this.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );

		this.Bord = BorderFactory.createEtchedBorder ( EtchedBorder.RAISED );

		this.TotalPanel = new JPanel ( );
		this.TotalPanel.setLayout ( new BoxLayout ( this.TotalPanel, BoxLayout.LINE_AXIS ) );
		this.TotalPanel.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		this.TotalPanel.setBorder ( this.Bord );
		this.add(TotalPanel);

		//for ( int y = 0 ; y < this.TotalPanelLines.length ; y++ ) {
			this.TotalPanelLines = new JPanel ( );
			this.TotalPanelLines.setLayout ( new BoxLayout ( this.TotalPanelLines, BoxLayout.PAGE_AXIS ) );
			this.TotalPanelLines.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
			//this.TotalPanelLines.setBorder ( this.Bord );
			this.TotalPanel.add ( this.TotalPanelLines );
		//}

		this.StatsPanel_Comparison = new JPanel ( );
		this.StatsPanel_Comparison.setLayout ( new BoxLayout ( this.StatsPanel_Comparison, BoxLayout.LINE_AXIS ) );
		//this.StatsPanel_Comparison.setBorder ( this.Bord );
		for ( int y = 0 ; y < this.StatsCollumns_Comparison.length ; y++ ) {
			this.StatsCollumns_Comparison[y] = new JPanel ( );
			this.StatsCollumns_Comparison[y].setLayout ( new GridLayout ( 0, 1 ) );
			this.StatsCollumns_Comparison[y].setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
			this.StatsPanel_Comparison.add ( this.StatsCollumns_Comparison[y] );
		}
		this.TotalPanelLines.add ( this.StatsPanel_Comparison );

		this.StatsCollumns_Comparison[0].add ( new JLabel ( "Weight per bid:" ) );
		this.StatsCollumns_Comparison[0].add ( new JLabel ( "Volume per bid" ) );
		this.StatsCollumns_Comparison[0].add ( new JLabel ( "Items per bid" ) );
		this.StatsCollumns_Comparison[0].add ( new JLabel ( "Price per bid" ) );
		this.StatsCollumns_Comparison[0].add ( new JLabel ( "Bids" ) );
		this.StatsCollumns_Comparison[0].add ( new JLabel ( "Currency" ) );
		this.StatsCollumns_Comparison[0].add ( new JLabel ( "Total NOK" ) );
		this.StatsCollumns_Comparison[0].add ( new JLabel ( "NOK per item" ) );
		this.StatsCollumns_Comparison[0].add ( new JLabel ( "Selling Value" ) );
		this.StatsCollumns_Comparison[0].add ( new JLabel ( "Profit total" ) );
		
		for ( int y = 0 ; y < this.InputFields.length ; y++ ) {
			//if ( y == 1 ) {
			//	this.StatsCollumns_Comparison[1].add ( DosageTypes );
			//} else {
				this.InputFields[y] = new JTextField ( "0" );
				this.InputFields[y].addFocusListener ( this );
				this.StatsCollumns_Comparison[1].add ( this.InputFields[y] );
			//}
			if ( y > 5 ) {
				this.InputFields[y].setEditable(false);
			}
		}
		
		
		this.ButtonPanel = new JPanel ( );
		this.ButtonPanel.setLayout ( new GridLayout ( 1, 0 ) );
		
		this.ResetChanges = new JButton ( "Clear form" );
		this.ResetChanges.addActionListener ( this );
		this.ResetChanges.setActionCommand ( "Reset" );
		this.ButtonPanel.add ( this.ResetChanges );
		
		this.Save = new JButton ( "Save data" );
		this.Save.addActionListener ( this );
		this.Save.setActionCommand ( "Save" );
		this.ButtonPanel.add ( this.Save );
		
		this.Delete = new JButton ( "Delete data" );
		this.Delete.addActionListener ( this );
		this.Delete.setActionCommand ( "Delete" );
		this.ButtonPanel.add ( this.Delete );
		
		this.TotalPanelLines.add ( this.ButtonPanel );

		this.setVisible ( true );
		FillLabels ( "Reset form" );
		this.Updating = false;
	}

	public void FillLabels ( String Source ) {
		for ( int y = 0 ; y < this.InputFields.length ; y++ ) {
			InputFields[y].setText( "0" );
		}
	}

	public void stateChanged ( ChangeEvent e ) {
	}

	public void VisVindu ( ) {
		
		FillLabels ( "Reset form" );
		//this.Class_Communicator.Command_OpenVindu_Comparison();
	}

	public void focusLost ( FocusEvent A ) {
		UpdateDifference ( "User changed stats" );
	}

	public void focusGained ( FocusEvent A ) {
	}

	public void UpdateDifference ( String Source ) {
		
		double SellingPrice_Item = 0;
		int Bids = Integer.parseInt(InputFields[4].getText());
		double Items_Bid = Double.parseDouble(InputFields[2].getText());
		if ( this.Class_Communicator.Class_Panel_GoodsSelection_Consideration.VareListe.getSelectedItem().equals("") == false ) {
			for ( int y = 0 ; y < this.Class_Communicator.Class_Brain_Varer.VareListe.length ; y++ ) {
				if ( this.Class_Communicator.Class_Brain_Varer.VareListe[y] != null ) {
					if ( Class_Communicator.Class_Brain_Varer.VareListe[y].Varenavn.equals ( Class_Communicator.Class_Panel_GoodsSelection_Consideration.VareListe.getSelectedItem() ) ) {
						SellingPrice_Item = Class_Communicator.Class_Brain_Varer.VareListe[y].Pris_Per_Porsjon;
					}
				}
			}
		}
		
		double Valuta = 1;
		double Price_Bid = Double.parseDouble(InputFields[3].getText());
		if ( InputFields[5].getText().equals("$")) {
			Valuta = 6.4;
		}
		double NOK_Bid = Price_Bid * Valuta;
		NOK_Bid = (Math.floor((NOK_Bid*100))/100);
		
		double NOK_Item = NOK_Bid/Items_Bid;
		NOK_Item = (Math.floor((NOK_Item*100))/100);
		
		double SellingPrice_Bid = (SellingPrice_Item*Items_Bid);
		SellingPrice_Bid = (Math.floor((SellingPrice_Bid*100))/100);
		
		double Profit_Bid = SellingPrice_Bid - NOK_Bid;
		Profit_Bid = (Math.floor((Profit_Bid*100))/100);
		
		double Profit_Total = Profit_Bid*Bids;
		Profit_Total = (Math.floor((Profit_Total*100))/100);
		
		double Profit_Prcnt = SellingPrice_Bid / NOK_Bid;
		Profit_Prcnt = (Math.floor(Profit_Prcnt*10000))/100;
		InputFields[6].setText( Double.toString( NOK_Bid*Bids ) );
		InputFields[7].setText( Double.toString( NOK_Item ) );
		InputFields[8].setText( Double.toString( SellingPrice_Bid*Bids ) );
		InputFields[9].setText( Double.toString( Profit_Total )+" ("+Profit_Prcnt+"%)" );

	}

	public void actionPerformed ( ActionEvent e ) {
		System.out.println( e.getActionCommand ( ) );
		if ( e.getActionCommand ( ).equals ( "Reset" ) ) {
			FillLabels ( "Reset form" );
		} else if ( e.getActionCommand ( ).equals ( "Save" ) ) {
			Super_Vare NyVare = new Super_Vare( InputFields[0].getText() );
			NyVare.VareBilde = InputFields[1].getText();
			NyVare.Antall_Per_Porsjon = Integer.parseInt(InputFields[2].getText());
			NyVare.Vekt_Per_Porsjon = Integer.parseInt(InputFields[3].getText());
			NyVare.ML_Per_Porsjon = Integer.parseInt(InputFields[4].getText());
			/*
			String Dosage = (String) DosageTypes.getSelectedItem();
			if ( Dosage.equals("Weight")) {
				NyVare.Vekt_Per_Porsjon = Integer.parseInt(InputFields[2].getText());
			} else if ( Dosage.equals("Volume")) {
				NyVare.ML_Per_Porsjon = Integer.parseInt(InputFields[2].getText());
			} else {
				NyVare.Antall_Per_Porsjon = Integer.parseInt(InputFields[2].getText());
			}
			*/
			NyVare.Pris_Per_Porsjon = Integer.parseInt(InputFields[5].getText());
			Class_Communicator.SaveItem(NyVare);
			FillLabels ( "Reset form" );
		} else if ( e.getActionCommand ( ).equals ( "Delete" ) ) {
			Class_Communicator.DeleteItem( new Super_Vare( InputFields[0].getText() ) );
		}
	}

	public void VisItem(Super_Vare superVare) {
		/*
		this.InputFields[0].setText ( superVare.Varenavn );
		this.InputFields[1].setText ( superVare.VareBilde );
		this.InputFields[2].setText ( Integer.toString(superVare.Antall_Per_Porsjon) );
		this.InputFields[3].setText ( Integer.toString(superVare.Vekt_Per_Porsjon) );
		this.InputFields[4].setText ( Integer.toString(superVare.ML_Per_Porsjon) );
		this.InputFields[5].setText ( Integer.toString(superVare.Pris_Per_Porsjon) );
		*/
	}
}
