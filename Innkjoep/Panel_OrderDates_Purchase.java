package Innkjoep;

import java.awt.Color;

import javax.swing.*;

public class Panel_OrderDates_Purchase extends JPanel {
	
	JPanel[] PanelRows = new JPanel[6];
	JTextField OrderMade = new JTextField("0");
	JTextField PaymentReceived = new JTextField("0");
	JTextField GoodsSent = new JTextField("0");
	JLabel DaysBeforePay = new JLabel("0");
	JLabel DaysBeforeSending = new JLabel("0");
	
	public Panel_OrderDates_Purchase() {
		
		System.out.println ( "Class Panel_OrderDates_Purchase started" );
		
		this.setSize ( 200, 200 );
		this.setLayout ( new BoxLayout ( this, BoxLayout.PAGE_AXIS ) );
		this.setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
		
		for ( int X = 0 ; X < PanelRows.length ; X++ ) {
			PanelRows[X] = new JPanel();
			PanelRows[X].setLayout ( new BoxLayout ( PanelRows[X], BoxLayout.LINE_AXIS ) );
			PanelRows[X].setBackground ( new Color ( ( int ) ( 210 ), ( int ) ( 225 ), ( int ) ( 240 ) ) );
			this.add(PanelRows[X]);
		}

		PanelRows[0].add(new JLabel("Order was made: "));
		PanelRows[0].add(OrderMade);
		
		PanelRows[1].add(new JLabel("Payment was received: "));
		PanelRows[1].add(PaymentReceived);
		PanelRows[1].add(new JLabel("Days waiting for payment: "));
		PanelRows[1].add(DaysBeforePay);
		
		PanelRows[2].add(new JLabel("Goodes were sent: "));
		PanelRows[2].add(GoodsSent);
		PanelRows[2].add(new JLabel("Days before sending: "));
		PanelRows[2].add(DaysBeforeSending);
		
	}
}
