package GUI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Kontroller.*;

public class Vindu_Menu extends JFrame implements ActionListener {

	private static final long	serialVersionUID	= 1L;
	public JButton[]			MenyKnapp			= new JButton[9];
	Communicator				Class_Communicator;

	public Vindu_Menu (Communicator Class_CommunicatorT) {

		super ( "Handelsdamer" );
		Class_Communicator = Class_CommunicatorT;
		System.out.println ( "Class Vindu_Menu created" );
	}

	public void Startup ( ) {

		System.out.println ( "Class Vindu_Menu started" );

		setSize ( 200, 300 );
		Container pane = getContentPane ( );
		pane.setLayout ( new GridLayout ( this.MenyKnapp.length, 1 ) );
		GridBagConstraints c = new GridBagConstraints ( );

		this.MenyKnapp[0] = new JButton ( "Statistics" );
		this.MenyKnapp[1] = new JButton ( "Edit trade goods" );
		this.MenyKnapp[2] = new JButton ( "Profit" );
		this.MenyKnapp[3] = new JButton ( "Trends" );
		this.MenyKnapp[4] = new JButton ( "Sales" );
		this.MenyKnapp[5] = new JButton ( "Purchases" );
		this.MenyKnapp[6] = new JButton ( "Envelopes" );
		this.MenyKnapp[7] = new JButton ( "Shoppinglist" );
		this.MenyKnapp[8] = new JButton ( "Considerations" );

		for ( int y = 0 ; y < this.MenyKnapp.length ; y++ ) {
			pane.add ( this.MenyKnapp[y], c );
			this.MenyKnapp[y].addActionListener ( this );
			this.MenyKnapp[y].setActionCommand ( "Vindu#" + y );
		}

		setVisible ( true );
	}

	public void actionPerformed ( ActionEvent e ) {
		if ( e.getActionCommand ( ).equals ( "Vindu#0" ) ) {
			//this.Class_Communicator.Class_Vindu_Statistics.VisVindu ( );
		} else if ( e.getActionCommand ( ).equals ( "Vindu#1" ) ) {
			//this.Class_Communicator.Class_Vindu_EditVare.VisVindu ( );
		} else if ( e.getActionCommand ( ).equals ( "Vindu#2" ) ) {
			//this.Class_Communicator.Class_Vindu_Gear.VisVindu ( );
		} else if ( e.getActionCommand ( ).equals ( "Vindu#3" ) ) {
			//this.Class_Communicator.Class_Vindu_GearLibrary.VisVindu ( );
		} else if ( e.getActionCommand ( ).equals ( "Vindu#4" ) ) {
			//this.Class_Communicator.Class_Vindu_GemLibrary.VisVindu ( );
		} else if ( e.getActionCommand ( ).equals ( "Vindu#5" ) ) {
			//this.Class_Communicator.Class_Vindu_EnchantLibrary.VisVindu ( );
		} else if ( e.getActionCommand ( ).equals ( "Vindu#6" ) ) {
			//this.Class_Communicator.Class_Vindu_Professions.VisVindu ( );
		}
	}
}
