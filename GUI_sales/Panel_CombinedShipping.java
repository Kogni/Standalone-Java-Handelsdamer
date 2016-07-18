package GUI_sales;

import java.awt.Color;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

public class Panel_CombinedShipping extends JPanel {
	
	JScrollPane					Shipping_ScrollPanel	= new JScrollPane ( );
	JTable						Shipping_Table			= new JTable ( );
	DefaultTableModel			Shipping_TableModel;
	Vector						Shipping_TableCollumnNames;
	Vector						Shipping_TableContent;

	public Panel_CombinedShipping() {
		
		System.out.println ( "Class Panel_CombinedShipping started" );
		this.setSize ( 200, 200 );
		this.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		
		this.Shipping_TableContent = new Vector ( );
		this.Shipping_TableCollumnNames = new Vector ( );
		this.Shipping_TableModel = new DefaultTableModel ( );
		this.Shipping_TableCollumnNames.addElement ( "Goods" );
		this.Shipping_TableCollumnNames.addElement ( "Doses" );
		this.Shipping_TableCollumnNames.addElement ( "Weight" );
		this.Shipping_TableCollumnNames.addElement ( "Price" );
		this.Shipping_TableModel.setDataVector ( this.Shipping_TableContent, this.Shipping_TableCollumnNames );
		this.Shipping_Table = new JTable ( this.Shipping_TableModel );
		this.Shipping_Table.setSize ( 200, 200 );
		this.Shipping_ScrollPanel = new JScrollPane ( this.Shipping_Table );
		this.Shipping_ScrollPanel.setSize ( 200, 200 );
		this.add ( this.Shipping_ScrollPanel );
		
		TableColumn column;
		column = this.Shipping_Table.getColumnModel ( ).getColumn ( 0 );
		column.setPreferredWidth ( 75 ); //name
		column = this.Shipping_Table.getColumnModel ( ).getColumn ( 1 );
		column.setPreferredWidth ( 50 ); //gear upgrade
		column = this.Shipping_Table.getColumnModel ( ).getColumn ( 2 );
		column.setPreferredWidth ( 50 ); //gem upgrade
		column = this.Shipping_Table.getColumnModel ( ).getColumn ( 3 );
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
