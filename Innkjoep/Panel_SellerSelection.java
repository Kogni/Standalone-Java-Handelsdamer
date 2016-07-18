package Innkjoep;

import java.awt.Color;

import javax.swing.*;

public class Panel_SellerSelection extends JPanel {
	
	JPanel[] PanelRows = new JPanel[5];
	JComboBox NickList = new JComboBox();
	JTextField Nick = new JTextField("");
	JTextField Name = new JTextField("");
	JTextField Street = new JTextField("");
	JTextField Zip = new JTextField("");
	
	public Panel_SellerSelection() {
		
		this.setSize ( 200, 200 );
		this.setLayout ( new BoxLayout ( this, BoxLayout.PAGE_AXIS ) );
		this.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		
		for ( int X = 0 ; X < PanelRows.length ; X++ ) {
			PanelRows[X] = new JPanel();
			PanelRows[X].setLayout ( new BoxLayout ( PanelRows[X], BoxLayout.LINE_AXIS ) );
			PanelRows[X].setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
			this.add(PanelRows[X]);
		}
		
		PanelRows[0].add(new JLabel("Buyer datas"));
		
		PanelRows[1].add(new JLabel("Nick"));
		PanelRows[1].add(Nick);
		PanelRows[1].add(NickList);
		
		PanelRows[2].add(new JLabel("Name"));
		PanelRows[2].add(Name);
		
		PanelRows[3].add(new JLabel("Street"));
		PanelRows[3].add(Street);
		
		PanelRows[4].add(new JLabel("Zip"));
		PanelRows[4].add(Zip);
		
		this.setVisible(true);
		
	}
}
