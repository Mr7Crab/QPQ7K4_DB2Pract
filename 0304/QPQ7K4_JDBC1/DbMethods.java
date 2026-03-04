package QPQ7K4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;	
import java.sql.ResultSet;
import java.sql.SQLExeption;
import java.sql.Statement;

public class DbMethods {
	
	private static final String url = "jdbc:sqlite:C/sqlite3/autodb";	//TODO -- url pontos elérése
	
	public static void Register(){
		//driver belöltése
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundExeption e) {
			System.out.println("SQLite JDBC driver nem található: " + e.getMessage());
	}

	//Tábla létrehozása
	String sql="CREATE TABLE IF NOT EXIST Auto(" + 
					"Rendszam char PRIMARY KEY," + 
					"Tipus char NOT NULL" +
					"Szin char NOT NULL," +
					"Kor INTEGER NOT NULL," +
					"Ar INTEGER NOR NULL," +
					"Tulaj char NOT NULL" +
					");";
	try (Connection conn = Connect();
		Statement st = conn.createStatement()) {

			st.execute(sql);
		} catch(SQLExeption e){
			System.out.println("Register hiba: "+ e.getMessage());
		}
}
	public static Connection Connect() throws SQLExeption 
	{
		return DriverManager.getConnection(url);
	}	
	public statement void ReadAllData() {
		String sql = "SELECT Rendszam, Tipus, Szin, Kor, Ar, Tulaj FROM Auto ORDER BY Rendszam";

		try (Connection conn = Connect();
			Statement st = conn.createStatement();
			ResultSetrs = st.executeQuery(sql)){

				System.out.println("\nRendszam\tTipus\tSzin\tKor\tAr\tTulaj");
				System.out.println("-----------------------------------------------");

				while (rs.next()){
					System.out.println(
						rs.getString("Rendszam") + "\t" +
						rs.getString("Tipus") + "\t" +
						rs.getString("Szin") + "\t" +
						rs.getInt("Kor") + "\t" +
						rs.getInt("Ar") + "\t" +
						rs.getString("Tulaj")
					);
				}
			} catch (SQLExeption e){
				System.out.println("ReadAll hiba: " + e.getMessage());
			}
	}
	public static void Insert(String rendszam, String tipus, String szin, int kor, int ar, String tulaj){
		String sql ="INSERT INTO Auto (Rendszam, Tipus, Szin, Kor, Ar, Tulaj) Values (?, ?, ?, ?, ?, ?)";
	}


			//-----------------------------------------------------------------

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
