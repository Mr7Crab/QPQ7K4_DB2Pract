/// CRUD a Kolcsonzo táblára:
///
///     -listázás
///     -felvétel
///     -módosítás
///     -törlés
///     -szűrés

import java.sql.*;
import java.util.Scanner;

public class KolcsonzoService {

    public void listAll(){
        String sql = "SELECT * FROM Kolcsonzo";
        
        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                    rs.getInt("Kolcsonzo_ID") + " | " +
                    rs.getString("Nev") + " | " +
                    rs.getString("EmailCim") + " | " +
                    rs.getString("Lakcim") + " | " +
                    rs.getInt("Tiltott") + " | " +
                    rs.getString("Regisztracio_Datuma")            
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(Scanner sc){
        String sql = "INSERT INTO Kolcsonzo (Kolcsonzo_ID, Nev, EmailCim, Lakcim, Tiltott, Regisztracio_Datuma) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            System.out.print("Kölcsönző_ID: ");
            int id = Integer.parseInt(sc.nextLine());            

            System.out.print("Név: ");
            String nev = sc.nextLine();

            System.out.print("Email cím: ");
            String email = sc.nextLine();

            System.out.print("Lakcím: ");
            String lakcim = sc.nextLine();

            System.out.print("Tiltott (0 vagy 1): ");
            int tiltott = Integer.parseInt(sc.nextLine());

            System.out.print("Regisztracio dátuma (YYYY-MM-DD): ");
            String datum = sc.nextLine();

            ps.setInt(1,id);
            ps.setString(2, nev);
            ps.setString(3, email);
            ps.setString(4, lakcim);
            ps.setInt(5, tiltott);
            ps.setString(6, datum);

            ps.executeUpdate();
            System.out.println("Kölcsönző sikeresen hozzáadva.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Scanner sc){
        String sql = "UPDATE Kolcsonzo SET Nev = ?, EmailCim = ?, Lakcim = ?, Tiltott = ?, Regisztracio_Datuma = ? WHERE Kolcsonzo_ID = ?";

        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            System.out.print("Módosítandó ID: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.print("Új név: ");
            String nev = sc.nextLine();

            System.out.print("Új email cím: ");
            String email = sc.nextLine();

            System.out.print("Új lakcím: ");
            String lakcim = sc.nextLine();

            System.out.print("Tiltott (0 vagy 1): ");
            int tiltott = Integer.parseInt(sc.nextLine());

            System.out.print("Új regisztracio dátuma (YYYY-MM-DD): ");
            String datum = sc.nextLine();

            ps.setString(1, nev);
            ps.setString(2, email);
            ps.setString(3, lakcim);
            ps.setInt(4, tiltott);
            ps.setString(5, datum);
            ps.setInt(6, id);

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
        String sql = "DELETE FROM Kolcsonzo WHERE Kolcsonzo_ID = ?";

        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            System.out.print("Törlendő ID: ");
            int id = Integer.parseInt(sc.nextLine());

            ps.setInt(1, id);

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

    public void searchByName(Scanner sc){
        String sql = "SELECT * FROM Kolcsonzo WHERE Nev LIKE ?";

        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            System.out.print("Keresés név alapján: ");
            String nev = sc.nextLine();

            ps.setString(1, "%" + nev + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
             System.out.println(
                    rs.getInt("Kolcsonzo_ID") + " | " +
                    rs.getString("Nev") + " | " +
                    rs.getString("EmailCim") + " | " +
                    rs.getString("Lakcim")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
