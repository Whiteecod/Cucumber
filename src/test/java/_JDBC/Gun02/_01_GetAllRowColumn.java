package _JDBC.Gun02;

import _JDBC.JDBSParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class _01_GetAllRowColumn extends JDBSParent {

    @Test
    public void test1() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from language");

        ResultSetMetaData rsmd = rs.getMetaData(); // kolon sayisi, isimleri, tipleri
        int columnCount = rsmd.getColumnCount();
        System.out.println("columnCount = " + columnCount);

        for (int i = 1; i <= columnCount; i++) {
            System.out.print("Column name = " + rsmd.getColumnName(i));
            System.out.println("\t Column Type = " + rsmd.getColumnTypeName(i));
        }
    }

    @Test
    public void test2() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from language");
        ResultSetMetaData rsmd = rs.getMetaData();

        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            System.out.print(rsmd.getColumnName(i) + "\t");

        }
        System.out.println();

        while (rs.next()) {
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println();
        }

    }

    // bir metoda sorguyu("select * from language") gönderiniz,
    // metod size sorgunun datasını bir ArrayList olarak döndürsün

    @Test
    public void test3() throws SQLException {
        String sql = "select * from language";
        ArrayList<ArrayList<String>> donenSonuc = getListData(sql);
        System.out.println("donenSonuc = " + donenSonuc);
    }

    public ArrayList<ArrayList<String>> getListData(String sql) throws SQLException {
        ArrayList<ArrayList<String>> tablo = new ArrayList<>();
        ResultSet rs = statement.executeQuery(sql);

        try {
            while (rs.next()) {
                ArrayList<String> satir = new ArrayList<>();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    satir.add(rs.getString(i));
                }
                tablo.add(satir);
            }
        } catch (Exception e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        return tablo;
    }
}
