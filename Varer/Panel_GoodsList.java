package Varer;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

import Kontroller.*;

public class Panel_GoodsList extends JPanel implements MouseListener {
	
	Communicator Class_Communicator;
	
	JScrollPane					Overview_ScrollPanel	= new JScrollPane ( );
	JTable						Overview_Table			= new JTable ( );
	DefaultTableModel			Overview_TableModel;
	Vector						Overview_TableCollumnNames;
	Vector						Overview_TableContent;
	
	public Panel_GoodsList(Communicator Class_Communicator) {
		this.Class_Communicator = Class_Communicator;
	}
	
	public void Startup() {
		
		this.setSize ( 400, 270 );
		this.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		
		this.Overview_TableContent = new Vector ( );
		this.Overview_TableCollumnNames = new Vector ( );
		this.Overview_TableModel = new DefaultTableModel ( );
		this.Overview_TableCollumnNames.addElement ( "Name" );
		this.Overview_TableCollumnNames.addElement ( "Weight/dose" );
		this.Overview_TableCollumnNames.addElement ( "ML/dose" );
		this.Overview_TableCollumnNames.addElement ( "Number/dose" );
		this.Overview_TableCollumnNames.addElement ( "Price/dose" );
		this.Overview_TableModel.setDataVector ( this.Overview_TableContent, this.Overview_TableCollumnNames );
		this.Overview_Table = new JTable ( this.Overview_TableModel );
		this.Overview_ScrollPanel = new JScrollPane ( this.Overview_Table );
		this.add ( this.Overview_ScrollPanel );
		
		TableColumn column;
		column = this.Overview_Table.getColumnModel ( ).getColumn ( 0 );
		column.setPreferredWidth ( 75 ); //name
		column = this.Overview_Table.getColumnModel ( ).getColumn ( 1 );
		column.setPreferredWidth ( 50 ); //gear upgrade
		column = this.Overview_Table.getColumnModel ( ).getColumn ( 2 );
		column.setPreferredWidth ( 50 ); //gem upgrade
		column = this.Overview_Table.getColumnModel ( ).getColumn ( 3 );
		column.setPreferredWidth ( 50 ); //enchant upgrade
		column = this.Overview_Table.getColumnModel ( ).getColumn ( 4 );
		column.setPreferredWidth ( 50 ); //special upgrade
		
		this.Overview_Table.addMouseListener ( this );
		
		FillOverview ( );
		this.setVisible ( true );
	}
	
	public void FillOverview ( ) {
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
	}
	
	private void VisSelectedProfession ( ) {
		if ( this.Overview_Table.getSelectedRow ( ) > -1 ) {
			for ( int y = 0 ; y < this.Class_Communicator.Class_Brain_Varer.VareListe.length ; y++ ) {
				if ( this.Class_Communicator.Class_Brain_Varer.VareListe[y] != null ) {
					if ( Class_Communicator.Class_Brain_Varer.VareListe[y].Varenavn.equals ( this.Overview_TableModel.getValueAt ( this.Overview_Table.getSelectedRow ( ), 0 ) ) ) {
						this.Class_Communicator.Class_Panel_EditVare.VisItem(Class_Communicator.Class_Brain_Varer.VareListe[y]);
					}
				}
			}
		}
	}
	
	public void mouseClicked ( MouseEvent e ) {
		VisSelectedProfession ( );
	}

	public void mouseExited ( MouseEvent e ) {
	}

	public void mouseEntered ( MouseEvent e ) {
	}

	public void mouseReleased ( MouseEvent e ) {
	}

	public void mousePressed ( MouseEvent e ) {
	}

}
