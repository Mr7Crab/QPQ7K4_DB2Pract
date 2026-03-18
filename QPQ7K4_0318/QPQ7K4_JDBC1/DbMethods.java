import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbMethods {
	
	private static final String url = "jdbc:sqlite:C:/Users/Zsombor/Documents/Miskolci_Egyetem/Adatb_2/QPQ7K4_DB2/QPQ7K4_DB2Pract/0304/QPQ7K4_JDBC1/sqlite-jdbc-3.7.2.jar";	//TODO -- url pontos elérése
	
	public static void Register(){
		//driver belöltése
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			System.out.println("SQLite JDBC driver nem található: " + e.getMessage());
		}
		//TODO ??? táblák létrehozása
/*/
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
		} catch(SQLException e){
			System.out.println("Register hiba: "+ e.getMessage());
		}
		*/
	}

	public static Connection Connect() 
	{
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println( e.getMessage());
		}
		return conn;
	}	
	public static void DisConnect(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static  void ReadAllData() {
		int id;
		String vnev;
		String knev;
		String szuli;
		String lakcim;


		String sqlp = "SELECT ID, Vnev, Knev, SzulI, Lakcím FROM Hallgato ";
		Connection conn = Connect();

		try 
			{
				Statement statement = conn.createStatement();
				ResultSet result_set = statement.executeQuery(sqlp);

				while (result_set.next()){
					id = result_set.getInt("ID");
					vnev = result_set.getString("Vnev");
					knev = result_set.getString("Knev");
					szuli = result_set.getString("SzulI");
					lakcim = result_set.getString("Lakcím");

					System.out.println(
						id + "\t" + 
						vnev + "\t" + 
						knev + "\t" + 
						szuli + "\t" + 
						lakcim
					);
				}

				result_set.close();
				statement.close();
			} catch (SQLException e){
				System.out.println("ReadAll hiba: " + e.getMessage());
			}
		}
	}