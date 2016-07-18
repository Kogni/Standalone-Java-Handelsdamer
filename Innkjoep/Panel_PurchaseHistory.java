package Innkjoep;

import java.awt.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

public class Panel_PurchaseHistory extends JPanel {
	
	JScrollPane					Shipping_ScrollPanel	= new JScrollPane ( );
	JTable						Shipping_Table			= new JTable ( );
	DefaultTableModel			Shipping_TableModel;
	Vector						Shipping_TableCollumnNames;
	Vector						Shipping_TableContent;

	public Panel_PurchaseHistory() {
		
		System.out.println ( "Class Panel_PurchaseHistory started" );
		
		this.setSize ( 400, 400 );
		this.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		this.setLayout ( new GridLayout ( 1, 1 ) ); //y, x
		
		this.Shipping_TableContent = new Vector ( );
		this.Shipping_TableCollumnNames = new Vector ( );
		this.Shipping_TableModel = new DefaultTableModel ( );
		this.Shipping_TableCollumnNames.addElement ( "Ordered:" );
		this.Shipping_TableCollumnNames.addElement ( "Buyer:" );
		this.Shipping_TableCollumnNames.addElement ( "Goods:" );
		this.Shipping_TableCollumnNames.addElement ( "#" );
		this.Shipping_TableCollumnNames.addElement ( "Price" );
		this.Shipping_TableCollumnNames.addElement ( "Total" );
		this.Shipping_TableCollumnNames.addElement ( "Paid" );
		this.Shipping_TableCollumnNames.addElement ( "Sent" );
		this.Shipping_TableCollumnNames.addElement ( "Cancel" );
		this.Shipping_TableModel.setDataVector ( this.Shipping_TableContent, this.Shipping_TableCollumnNames );
		this.Shipping_Table = new JTable ( this.Shipping_TableModel );
		this.Shipping_Table.setSize ( 400, 400 );
		this.Shipping_ScrollPanel = new JScrollPane ( this.Shipping_Table );
		this.Shipping_ScrollPanel.setSize ( 400, 400 );
		this.add ( this.Shipping_ScrollPanel );
		
		TableColumn column;
		column = this.Shipping_Table.getColumnModel ( ).getColumn ( 0 );
		column.setPreferredWidth ( 60 ); //name
		column = this.Shipping_Table.getColumnModel ( ).getColumn ( 1 );
		column.setPreferredWidth ( 100 ); //gear upgrade
		column = this.Shipping_Table.getColumnModel ( ).getColumn ( 2 );
		column.setPreferredWidth ( 100 ); //gem upgrade
		column = this.Shipping_Table.getColumnModel ( ).getColumn ( 3 );
		column.setPreferredWidth ( 50 ); //enchant upgrade
		column = this.Shipping_Table.getColumnModel ( ).getColumn ( 4 );
		column.setPreferredWidth ( 50 ); //enchant upgrade
		column = this.Shipping_Table.getColumnModel ( ).getColumn ( 5 );
		column.setPreferredWidth ( 50 ); //enchant upgrade
		column = this.Shipping_Table.getColumnModel ( ).getColumn ( 6 );
		column.setPreferredWidth ( 50 ); //enchant upgrade
		column = this.Shipping_Table.getColumnModel ( ).getColumn ( 7 );
		column.setPreferredWidth ( 50 ); //enchant upgrade
		
		FillTable ( );
		this.setVisible ( true );
	}
	
	public void FillTable ( ) {
		/*
		this.Overview_TableContent.removeAllElements ( );
		for ( int y = 0 ; y < this.Class_Communicator.Class_Brain_Varer.VareListe.length ; y++ ) {
			if ( this.Class_Communicator.Class_Brain_Varer.VareListe[y] != null ) {
				
				Vector Temp = new Vector ( );
				Temp.addElement ( Class_Communicator.Class_Brain_Varer.VareListe[y].Varenavn );
				Temp.addElement ( Class_Communicator.Class_Brain_Varer.VareListe[y].Vekt_Per_Porsjon );
				Temp.addElement ( Class_Communicator.Class_Brain_Varer.VareListe[y].ML_Per_Porsjon );
				Temp.addElement ( Class_Communicator.Class_Brain_Varer.VareListe[y].Antall_Per_Porsjon );
				Temp.addElement ( Class_Communicator.Class_Brain_Varer.VareListe[y].Pris_Per_Porsjon );
				this.Overview_TableContent.addElement ( Temp );
			}
		}
		this.Overview_TableModel.fireTableDataChanged ( );
		*/
	}
}
