import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	}

	public static Connection Connect() throws SQLException 
	{
		return DriverManager.getConnection(url);
	}	
	
	public static  void ReadAllData() {
		String sql = "SELECT Rendszam, Tipus, Szin, Kor, Ar, Tulaj FROM Auto ORDER BY Rendszam";

		try (Connection conn = Connect();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql)){

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
			} catch (SQLException e){
				System.out.println("ReadAll hiba: " + e.getMessage());
			}
	}
	
	public static void Insert(String rendszam, String tipus, String szin, int kor, int ar, String tulaj){
		String sql ="INSERT INTO Auto (Rendszam, Tipus, Szin, Kor, Ar, Tulaj) Values (?, ?, ?, ?, ?, ?)";
		try (Connection conn = Connect();
				PreparedStatement ps = conn.prepareStatement(sql)){
			// PreparedStatement . előre leforditotta SQL utasitást használ, védi a db, gyorsabb
				
			ps.setString(1, rendszam);
			ps.setString(2, tipus);
			ps.setString(3, szin);
			ps.setInt(4, kor);
			ps.setInt(5, ar);
			ps.setString(6, tulaj);

			ps.executeUpdate();
			System.out.println("Sikeres beszúrás!");

		} catch (SQLException e) {
			System.out.println("Insert hiba: " + e.getMessage());
		}

//--------------------------------------
	}
	
	public static void DeleteData(String rendszam) {
		String sql = "DELETE FROM Auto WHERE Rendszam = ?";
		try (Connection conn = Connect();
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, rendszam);
			int db = ps.executeUpdate();

			if(db > 0) System.out.println("A megadott rendszámú autó nem létezik!");
			else System.out.println("Törlődött: " + db + " rekord.");

		}catch (SQLException e) {
			System.out.println("Delete hiba: " + e.getMessage());
		}
	}
	
	public static void UpdatePrice(String rendszam, int ujAr) {
		String sql = "UPDATE Auto SET Ar = ? WHERE Rendszam = ?";
		try (Connection conn = Connect();
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, ujAr);
			ps.setString(2, rendszam);
			int db = ps.executeUpdate();

			if(db > 0) System.out.println("A megadott rendszámú autó nem létezik!");
			else System.out.println("Modosult: " + db + " rekord.");
		}catch (SQLException e) {
			System.out.println("Update hiba: " + e.getMessage());	
		}
	}
}