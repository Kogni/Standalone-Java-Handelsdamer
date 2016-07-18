package Varer;

import java.awt.Color;

import javax.swing.*;

import Kontroller.Communicator;

public class Panel_GoodsSelection extends JPanel {
	
	Communicator Class_Communicator;
	
	JPanel[] PanelRows = new JPanel[6];
	JTextField Amount = new JTextField("1");
	public JComboBox VareListe;
	JLabel Weight = new JLabel("0");
	JLabel Volume = new JLabel("0");
	JLabel Number = new JLabel("0");
	JLabel Price = new JLabel("0");

	public Panel_GoodsSelection( Communicator Class_Communicator ) {
		
		this.Class_Communicator = Class_Communicator;
		
		System.out.println ( "Class Panel_GoodsSelection started" );
		
		this.setSize ( 200, 200 );
		//this.setLayout ( new BoxLayout ( this, BoxLayout.PAGE_AXIS ) );
		this.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		
		for ( int X = 0 ; X < PanelRows.length ; X++ ) {
			PanelRows[X] = new JPanel();
			PanelRows[X].setLayout ( new BoxLayout ( PanelRows[X], BoxLayout.LINE_AXIS ) );
			PanelRows[X].setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
			this.add(PanelRows[X]);
		}
		
		PanelRows[0].add(new JLabel("Goods: "));
		VareListe = new JComboBox();
		PanelRows[0].add(VareListe);
		
		PanelRows[0].add(new JLabel("Amount: "));
		PanelRows[0].add(Amount);
		PanelRows[0].add(new JLabel(" doses"));
		
		PanelRows[1].add(new JLabel("Weight: "));
		PanelRows[1].add(Weight);
		
		PanelRows[1].add(new JLabel(" Volume: "));
		PanelRows[1].add(Volume);
		
		PanelRows[1].add(new JLabel(" Number: "));
		PanelRows[1].add(Number);
		
		PanelRows[2].add(new JLabel("Price: "));
		PanelRows[2].add(Price);
		
		this.setVisible(true);
	}
	
	public void Startup() {
		
		VareListe.removeAllItems();
		for ( int y = 0 ; y < this.Class_Communicator.Class_Brain_Varer.VareListe.length ; y++ ) {
			if ( this.Class_Communicator.Class_Brain_Varer.VareListe[y] != null ) {

				VareListe.addItem( Class_Communicator.Class_Brain_Varer.VareListe[y].Varenavn );
			}
		}
		
	}
}
