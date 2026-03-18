import java.sql.Connection;
import java.sql.ResultSet;
import java. sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;



public class ListingMethods {

    // task_a: A rekord számainak kiirása táblából
    public static void task_a(String table_name){
        String sqlp = "SELECT COUNT(*) AS db FROM " + qIdent(table_name);
        //quote identifier - a tábla formázása, table_name: Dolgozik
        Connection conn = DbMethods.Connect();
        ResultSet result_set = execute(conn, sqlp);

        if (result_set != null) {
            try {
                if (result_set.next()) {
                    int count = result_set.getInt("db");
                    System.out.println(table_name + " tábla rekordjainak száma: " + count);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        DbMethods.DisConnect(conn);
    }    
}

public static void task_b(String table_name, String column){
    String sqlp = "SELECT SUM(" + qIdent(column) + ") AS sum, aVG(" + qIdent(column)+ ") AS avg FROM " + qIdent(table_name);
    Connection conn = DbMethods.Connect();
    ResultSet result_set = execute(conn, sqlp);

    if (result_set != null) {
        try {
            if (result_set.next()) {
                // SUM lehet NULL, ha nincs
                Object sumObj = result_set.getObject("sum");
                double avg = result_set.getDouble("avg");

                String sumStr = (sumObj == null) ? "null" : sumObj.toString();
                System.out.println(table_name + " tábla: " + column + " oszlopának összege: " + sumStr + " átlaga: " + avg);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    DbMethods.DisConnect(conn);
}

// task_c: A Hallgato tábla rendezett listázása: mző és rendezés paraméterrel
// asscending=true -> ASC, false -> DESC
public static void task_c(String table_name, String column, boolean ascending) {
    String sqlp = "SELECT * FROM " + qIdent(table_name)  + " ORDER BY " + qIdent(column) + (ascending ? " ASC" : " DESC");

}


