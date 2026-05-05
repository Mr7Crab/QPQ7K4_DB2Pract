///CRUD a Konyv táblára.
import java.sql.*;
import java.util.Scanner;

public class KonyvService {
    
    public void listAll(){
        String sql = "SELECT * FROM Konyv";

        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                    rs.getInt("Konyv_ID") + " | " +
                    rs.getString("Cim") + " | " +
                    rs.getString("Szerzo_Neve") + " | " +
                    rs.getString("Tipus") + " | " +
                    rs.getString("Kiado") + " | " +
                    rs.getString("Kiadas_Ideje") + " | " +
                    rs.getString("Konyvtar_Neve") + " | " +
                    rs.getInt("Darabszam") 
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(Scanner sc){
        String sql = "INSERT INTO Konyv (Konyv_ID, Tipus, Szerzo_Neve, Cim, Kiado, Kiadas_Ideje, Konyvtar_Neve, Darabszam) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            System.out.print("Könyv_ID: ");
            int id = Integer.parseInt(sc.nextLine());       

            System.out.print("Típus: ");
            String tipus = sc.nextLine();

            System.out.print("Szerző neve: ");
            String szerzo = sc.nextLine();

            System.out.print("Cím: ");
            String cim = sc.nextLine();


            System.out.print("Kiadó: ");
            String kiado = sc.nextLine();

            System.out.print("Kiadás ideje (YYYY-MM-DD): ");
            String kiadasIdeje = sc.nextLine();

            System.out.print("Könyvtár neve: ");
            String konyvtarNev = sc.nextLine();

            System.out.print("Darabszam:");
            int darabszam = Integer.parseInt(sc.nextLine());

            ps.setInt(1,id);
            ps.setString(2, tipus);
            ps.setString(3, szerzo);
            ps.setString(4, cim);
            ps.setString(5, kiado);
            ps.setString(6, kiadasIdeje);
            ps.setString(7, konyvtarNev);
            ps.setInt(8, darabszam);

            ps.executeUpdate();
            System.err.println("Könyv sikeresen hozzáadva.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Scanner sc){
        String sql = "UPDATE Konyv SET Tipus = ?, Szerzo_Neve = ?, Cim = ?, Kiado = ?, Kiadas_Ideje = ?, Konyvtar_Neve = ?, Darabszam = ? WHERE Konyv_ID = ?";

        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            System.out.print("Módosítandó ID: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.print("Új típus: ");
            String tipus = sc.nextLine();

            System.out.print("Új szerző: ");
            String szerzo = sc.nextLine();

            System.out.print("Új cím: ");
            String cim = sc.nextLine();

            System.out.print("Új kiadó: ");
            String kiado = sc.nextLine();

            System.out.print("Új kiadás ideje (YYYY-MM-DD): ");
            String kiadasIdeje = sc.nextLine();

            System.out.print("Új könyvtár neve: ");
            String konyvtarNev = sc.nextLine();

            System.out.print("Új darabszám: ");
            int darabszam = Integer.parseInt(sc.nextLine());

            ps.setString(1, tipus);
            ps.setString(2, szerzo);
            ps.setString(3, cim);
            ps.setString(4, kiado);
            ps.setString(5, kiadasIdeje);
            ps.setString(6, konyvtarNev);
            ps.setInt(7, darabszam);
            ps.setInt(8, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Sikeres módosítás.");
            } else {
                System.out.println("Nincs ilyen ID.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Scanner sc){
        String sql = "DELETE FROM Konyv WHERE Konyv_ID = ?";

        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            System.out.print("Törlendő ID: ");
            ps.setInt(1, Integer.parseInt(sc.nextLine()));

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Sikeres törlés.");
            } else {
                System.out.println("Nincs ilyen ID.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void searchByTitle(Scanner sc){
        String sql = "SELECT * FROM Konyv WHERE Cim LIKE ?";

        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            System.out.print("Keresés cím alapján (részlet is lehet): ");
            ps.setString(1, "%" + sc.nextLine() + "%");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                System.out.println(
                    rs.getInt("Konyv_ID") + " | " +
                    rs.getString("Cim") + " | " +
                    rs.getString("Szerzo_Neve")                    
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void searchByTitleAndAuthor(Scanner sc){
        String sql = "SELECT * FROM Konyv WHERE Cim LIKE ? AND Szerzo_Neve LIKE ?";

        try (Connection conn = DBConnection.connect();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            System.out.print("Cím részlete: ");
            String cim = sc.nextLine();

            System.out.print("Szerző részlete: ");
            String szerzo = sc.nextLine();

            ps.setString(1, "%" + cim + "%");
            ps.setString(2, "%" + szerzo + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                    rs.getInt("Konyv_ID") + " | " +
                    rs.getString("Cim") + " | " +
                    rs.getString("Szerzo_Neve") + " | " +
                    rs.getString("Tipus")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
            
