package Innkjoep;

import java.awt.*;

import javax.swing.*;

import Kontroller.Communicator;

public class Panel_ShippingCosts_Purchase extends JPanel {
	
	JPanel[] PanelRows = new JPanel[4];
	JTextField Amount = new JTextField("1");
	JComboBox VareListe = new JComboBox();
	JLabel Weight = new JLabel("0");
	JLabel MinimumEnvelope = new JLabel("-");
	JLabel Number = new JLabel("0");
	JLabel Price = new JLabel("0");


	public Panel_ShippingCosts_Purchase(Communicator communicator) {
		
		this.setSize ( 200, 200 );
		//this.setLayout ( new BoxLayout ( this, BoxLayout.PAGE_AXIS ) );
		this.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		
		for ( int X = 0 ; X < PanelRows.length ; X++ ) {
			PanelRows[X] = new JPanel();
			PanelRows[X].setLayout ( new BoxLayout ( PanelRows[X], BoxLayout.LINE_AXIS ) );
			PanelRows[X].setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
			this.add(PanelRows[X]);
		}
		
		PanelRows[0].add(new JLabel("Total weight: "));
		PanelRows[0].add(Weight);
		PanelRows[0].add(new JLabel(" gr"));
		
		PanelRows[1].add(new JLabel("Minimum envelope:"));
		PanelRows[1].add(MinimumEnvelope);
		
		PanelRows[1].add(new JLabel(" Envelope override:"));
		PanelRows[1].add(VareListe);
		
	}
}
