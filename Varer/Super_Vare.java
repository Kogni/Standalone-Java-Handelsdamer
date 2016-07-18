package Varer;

import java.io.*;

public class Super_Vare implements Serializable {
	
	private static final long serialVersionUID = 1;
	
	public String Varenavn;
	public int Vekt_Per_Porsjon = 0;
	public int ML_Per_Porsjon = 0;
	public int Antall_Per_Porsjon = 0;
	public int Pris_Per_Porsjon = 0;
	public String VareBilde;
	
	public Super_Vare(String Varenavn) {
		this.Varenavn = Varenavn;
	}

}
