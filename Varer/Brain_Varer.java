package Varer;

import java.io.*;

import Kontroller.*;
import Salg.Object_VareUnit;

public class Brain_Varer {
	
	Communicator Class_Communicator; 
	
	public Super_Vare[] VareListe = new Super_Vare[999];
	private Object_VareUnit[] VareUnits = new Object_VareUnit[9999];
	int Items = 0;
	String VareData = "Goods.HD";
	String UnitData = "Units";

	public Brain_Varer(Communicator Class_Communicator) {
		this.Class_Communicator = Class_Communicator;
		HentGearFraFil ( );
	}
	
	public boolean RegistrerVare(Super_Vare NyVare) {
		for ( int X = 1 ; X < VareListe.length ; X++ ) {
			if ( VareListe[X] == null ) {
				VareListe[X] = NyVare;
				System.out.println("Varen er registrert");
				Items ++;
				SaveDatas ( );
				return true;
			} else if ( VareListe[X].Varenavn.equals(NyVare.Varenavn)) {
				System.out.println("Varen finnes fra før, skriver over");
				VareListe[X] = NyVare;
				return false;
			}
		}
		System.out.println("Varen fikk ikke plass");
		return false;
	}
	
	public void HentGearFraFil ( ) {
		try {
			ObjectInputStream objectIn = null;
			Super_Vare object = null;
			objectIn = new ObjectInputStream ( new BufferedInputStream ( new FileInputStream ( VareData ) ) );
			int NumberOfItems = Integer.parseInt ( objectIn.readObject ( ) + "" );
			System.out.println ( "Gear items i fil: " + NumberOfItems );
			int X = 0;
			this.Items = 0;
			boolean ValidItem = false;
			while ( X < NumberOfItems ) {
				X++;
				object = ( Super_Vare ) objectIn.readObject ( );
				ValidItem = false;
				System.out.println("Leste et objekt:"+object);
				if ( object != null ) {

					Super_Vare New = new Super_Vare ( object.Varenavn );
					New.Antall_Per_Porsjon = object.Antall_Per_Porsjon;
					New.ML_Per_Porsjon = object.ML_Per_Porsjon;
					New.Pris_Per_Porsjon = object.Pris_Per_Porsjon;
					New.Vekt_Per_Porsjon = object.Vekt_Per_Porsjon;
					
					this.Items++;
					this.VareListe[this.Items] = New;
					System.out.println("Addet vare til array:"+VareListe[this.Items]);
				}
			}
			objectIn.close ( );
		} catch ( Exception e ) {
			System.err.println ( "Klarte ikke hente fra " + VareData );
		}

	}
	
	public void SaveDatas ( ) {
			try {
				ObjectOutputStream objectOut = new ObjectOutputStream ( new BufferedOutputStream ( new FileOutputStream ( VareData ) ) );
				objectOut.writeObject ( this.Items );
				for ( int y = 1 ; y <= this.Items ; y++ ) {
					objectOut.writeObject ( this.VareListe[y] );
				}
				objectOut.close ( ); // Close the output stream
			} catch ( Exception e ) {
				System.err.println ( "Klarte ikke skrive til " + VareData );
			}
	}

	public boolean SlettVare(Super_Vare NyVare) {
		boolean FoundObject = false;
		for ( int y = 0 ; y <= this.Items ; y++ ) {
			if ( this.VareListe[y + 1] != null ) {
				if ( FoundObject == false ) {
					if ( this.VareListe[y + 1].Varenavn.equals ( NyVare.Varenavn ) ) {
						System.out.println ( "Fant deleteobject: " + this.VareListe[y + 1].Varenavn + " i spot#" + ( y + 1 ) );
						FoundObject = true;
						this.VareListe[ ( y + 1 )] = this.VareListe[ ( y + 2 )];
						//System.out.println ( "Flytter alle senere items fremover" );
						for ( int x = y + 3 ; x <= this.Items ; x++ ) {
							if ( this.VareListe[x] != null ) {
								this.VareListe[x - 1] = this.VareListe[x];
							} else {
								this.VareListe[x - 1] = null; //Må være med for å unngå at siste item blir duplisert.
							}
						}
						this.Items--;
					}
				}
			}
		}
		if ( FoundObject == false ) {
			System.err.println ( "Brain gear fant ikke delete object: " + NyVare.Varenavn );
			return false;
		}
		SaveDatas ( );
		return true;
	}
}
