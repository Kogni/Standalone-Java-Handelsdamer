package Varer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

import Kontroller.*;
import Varer.*;

public class Panel_EditVare extends JPanel implements ActionListener, ChangeListener, FocusListener {

	Communicator Class_Communicator;

	JPanel						TotalPanel					= new JPanel ( );
	JPanel						TotalPanelLines				= new JPanel();

	JPanel						StatsPanel_Comparison;
	JPanel[]					StatsCollumns_Comparison	= new JPanel[2];
	JTextField[]				InputFields				= new JTextField[8];
	//JComboBox					DosageTypes;

	Border						Bord;

	JPanel						ButtonPanel				= new JPanel();
	JButton						ResetChanges				= new JButton ( );
	JButton						Save				= new JButton ( );
	JButton						Delete				= new JButton ( );

	boolean						Updating;

	public Panel_EditVare ( Communicator Class_Communicator ) {
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

		this.StatsCollumns_Comparison[0].add ( new JLabel ( "Item data" ) );
		this.StatsCollumns_Comparison[0].add ( new JLabel ( "Name: " ) );
		this.StatsCollumns_Comparison[0].add ( new JLabel ( "Image path: " ) );
		//this.StatsCollumns_Comparison[0].add ( new JLabel ( "Dosage type: " ) );
		this.StatsCollumns_Comparison[0].add ( new JLabel ( "Number/dose" ) );
		this.StatsCollumns_Comparison[0].add ( new JLabel ( "Weight/dose" ) );
		this.StatsCollumns_Comparison[0].add ( new JLabel ( "Volume/dose" ) );
		this.StatsCollumns_Comparison[0].add ( new JLabel ( "Price/dosage" ) );
		this.StatsCollumns_Comparison[0].add ( new JLabel ( "Price/3" ) );
		this.StatsCollumns_Comparison[0].add ( new JLabel ( "Price/5" ) );

		//this.StatsCollumns_Comparison[1].add ( new JLabel ( " " ) );
		String[] DosageTypeList = new String[3];
		DosageTypeList[0] = "Weight";
		DosageTypeList[1] = "Volume";
		DosageTypeList[2] = "Number";
		//DosageTypes = new JComboBox(DosageTypeList);
		
		this.StatsCollumns_Comparison[1].add ( new JLabel ( " " ) );
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
		
		this.Save = new JButton ( "Save item" );
		this.Save.addActionListener ( this );
		this.Save.setActionCommand ( "Save" );
		this.ButtonPanel.add ( this.Save );
		
		this.Delete = new JButton ( "Delete item" );
		this.Delete.addActionListener ( this );
		this.Delete.setActionCommand ( "Delete" );
		this.ButtonPanel.add ( this.Delete );
		
		this.TotalPanelLines.add ( this.ButtonPanel );

		this.setVisible ( true );
		FillLabels ( "Reset form" );
		this.Updating = false;
	}

	public void FillLabels ( String Source ) {
		this.InputFields[0].setText ( "" );
		this.InputFields[1].setText ( "" );
		this.InputFields[2].setText ( "0" );
		this.InputFields[3].setText ( "0" );
		this.InputFields[4].setText ( "0" );
		this.InputFields[5].setText ( "0" );
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
		if ( InputFields[4].getText().equals("0.0")) {
			
		} else {
			double Price = Double.parseDouble(InputFields[4].getText());
			double Price3 = Price*3;
			double Price5 = Price*5;
			InputFields[6].setText( Double.toString(Price3) );
			InputFields[7].setText( Double.toString(Price5) );
		}
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
		this.InputFields[0].setText ( superVare.Varenavn );
		this.InputFields[1].setText ( superVare.VareBilde );
		this.InputFields[2].setText ( Integer.toString(superVare.Antall_Per_Porsjon) );
		this.InputFields[3].setText ( Integer.toString(superVare.Vekt_Per_Porsjon) );
		this.InputFields[4].setText ( Integer.toString(superVare.ML_Per_Porsjon) );
		this.InputFields[5].setText ( Integer.toString(superVare.Pris_Per_Porsjon) );
	}
}
