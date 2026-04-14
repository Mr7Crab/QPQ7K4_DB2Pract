
import java.sql.*;
import java.util.Scanner;

public class KolcsonzesService {
    
    public void insert(Scanner sc){
        String sql = "INSERT INTO Kolcsonzes (Kolcsonzes_ID, Kolcsonzes_Ideje, Leadas_ideje, Kolcsonzo_ID, Konyv_ID) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.connect();
             PreparedStatement ps= conn.prepareStatement(sql)) {

            System.out.print("Kolcsonzes_ID: ");
            int kolcsonzesId = Integer.parseInt(sc.nextLine());

            System.out.print("Kolcsonzes_Ideje (YYYY-MM-DD): ");
            String kolcsonzesIdeje = sc.nextLine();

            System.out.print("Leadas_ideje (YYYY-MM-DD): ");
            String leadasIdeje = sc.nextLine();

            System.out.print("Kolcsonzo_ID: ");
            int kolcsonzoId = Integer.parseInt(sc.nextLine());

            System.out.print("Konyv_ID: ");
            int konyvId = Integer.parseInt(sc.nextLine());

            ps.setInt(1, kolcsonzesId);
            ps.setString(2, kolcsonzesIdeje);
            ps.setString(3, leadasIdeje);
            ps.setInt(4, kolcsonzoId);
            ps.setInt(5, konyvId);

            ps.executeUpdate();
            System.out.println("Kölcsönzés rögzítve!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
    public void update(Scanner sc){
        String sql = "UPDATE Kolcsonzes SET Kolcsonzes_Ideje = ?, Leadas_Ideje = ?, Kolcsonzo_ID = ?, Konyv_ID = ? WHERE Kolcsonzes_ID = ?";

        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            System.out.print("Módosítandó kölcsönzés ID: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.print("Új kölcsönzés ideje (YYYY-MM-DD): ");
            String kolcsonzesIdeje = sc.nextLine();

            System.out.print("Új leadás ideje (YYYY-MM-DD): ");
            String leadasIdeje = sc.nextLine();

            System.out.print("Új kölcsönző ID: ");
            int kolcsonzoId = Integer.parseInt(sc.nextLine());

            System.out.print("Új könyv ID: ");
            int konyvId = Integer.parseInt(sc.nextLine());

            ps.setString(1, kolcsonzesIdeje);
            ps.setString(2, leadasIdeje);
            ps.setInt(3, kolcsonzoId);
            ps.setInt(4, konyvId);
            ps.setInt(5, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Sikeres módosítás.");
            } else {
                System.out.println("Nincs ilyen kölcsönzés ID.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
   public void delete(Scanner sc){
        String sql = "DELETE FROM Kolcsonzes WHERE Kolcsonzes_ID = ?";

        try (Connection conn = DBConnection.connect();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            System.out.print("Törlendő kölcsönzés ID: ");
            int id = Integer.parseInt(sc.nextLine());

            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Sikeres törlés.");
            } else {
                System.out.println("Nincs ilyen kölcsönzés ID.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listAllJoined(){        
        String sql ="""
                SELECT kz.Kolcsonzes_ID, k.Nev, b.Cim, kz.Kolcsonzes_Ideje, kz.Leadas_Ideje 
                     FROM Kolcsonzes kz 
                     JOIN Kolcsonzo k ON kz.Kolcsonzo_ID = k.Kolcsonzo_ID 
                     JOIN Konyv b ON kz.Konyv_ID = b.Konyv_ID
                """;
         
        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                    rs.getInt("Kolcsonzes_ID") + " | " +
                    rs.getString("Nev") + " | " +
                    rs.getString("Cim") + " | " +
                    rs.getString("Kolcsonzes_Ideje") + " | " +
                    rs.getString("Leadas_Ideje")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void searchJoined(Scanner sc){
        String sql = """
            SELECT kz.Kolcsonzes_ID, k.Nev, b.Cim, kz.Kolcsonzes_Ideje, kz.Leadas_Ideje
            FROM Kolcsonzes kz
            JOIN Kolcsonzo k ON kz.Kolcsonzo_ID = k.Kolcsonzo_ID
            JOIN Konyv b ON kz.Konyv_ID = b.Konyv_ID
            WHERE k.Nev LIKE ? AND b.Cim LIKE ?
            """;

        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            System.out.print("Kölcsönző neve: ");
            String nev = sc.nextLine();

            System.out.print("Könyv címe: ");
            String cim = sc.nextLine();

            ps.setString(1, "%" + nev + "%");
            ps.setString(2, "%" + cim + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                    rs.getInt("Kolcsonzes_ID") + " | " +
                    rs.getString("Nev") + " | " +
                    rs.getString("Cim") + " | " +
                    rs.getString("Kolcsonzes_Ideje") + " | " +
                    rs.getString("Leadas_Ideje")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
