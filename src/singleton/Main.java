package singleton;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnDBServer con = ConnDBServer.getInstance();
				
		con.getConnection();
		
	
		
	}

}
