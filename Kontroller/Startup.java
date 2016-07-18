package Kontroller;

public class Startup
{
  public static void main( String[] args )
  {

		System.out.println ( "Starting Handelsdamer" );

		Communicator Class_Communicator = new Communicator ( );
		
		Class_Communicator.SetupProgram ( );
		Class_Communicator.Startup( );
  }

}