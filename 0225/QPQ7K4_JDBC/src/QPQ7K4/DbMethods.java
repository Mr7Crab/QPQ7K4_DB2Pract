package QPQ7K4;

import java.sql.*;
import java.sql.ResoultSet;

public class DbMethods {
	
	final static String url = "jdbc:sqlite:C/sqlite3/autodb";
	
	public static void Register(){
	try {
		Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundExeption e) {
		System.out.println("Class not found exeption: " + e.getMessage());
	}
	}
	public static Connection Connect() 
	{
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		}catch (SQLExeption e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}	
	public static void Disconnect(Connection conn) {
		if(conn != null){
			try {
				conn.close();
			}
			catch (SQLExeption e){
				System.out.println(e.getMessage());
			}
		}	
	}
	public static void CommandExec(String command) {
		Connection conn = Connect();
		try {
			Statement s = conn.createStatement();
		}
		catch (SQLExeption e) {
			System.out.println("Command: " + command);
			System.out.println(e.getMessage());
		}
		DisConnect(conn);
	}
	public static void ReadAllData() {
		String rendszam = "";
		String tipus = "";
		String szin ="";
		String tulaj="";
		int kor=0;
		int ar=0;
		
		String sqlp = "SELECT Rendszam, Tipus, Szin, Kor, Ar, Tulaj From Auto";
		Connection conn = Connect();
		
		System.out.println ("Auto tábla\n");
		
		try {
			Statement statement = conn.createStatement();
			ResultSet result_set = statement.executeQuery(sqlp);
			while(resoult_set.next()){
				rednszam = resoult_set.getString("Rendszam");
				tipus = resoult_set.getString("Tipus");
				szim=resoult_set.getString("Szin");
				kor=resoult_set.getInt("Kor");
				ar=resoult_set.getInt("Ar");
				tulaj=resoult_set.getString("Tulaj");
				System.out.println(
						rendszam + "\t" +
						tipus + "\t" +
						szim + "\t" +
						kor + "\t" +
						ar + "\t" +
 						tulaj
						);	
			}
			resoult_set.close();
		}
		catch (SQLExeption e) {
			System.out.println(e.getMessage());
		}
		DisConnect(conn);
	}
}	
// {}
