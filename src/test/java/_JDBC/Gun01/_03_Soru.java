package _JDBC.Gun01;

import _JDBC.JDBSParent;
import com.mongodb.DBCollection;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_Soru extends JDBSParent {

    // city tablosundaki tüm kayıtlardaki isimleri next ile yazdırınız

    @Test
    public void test1() throws SQLException {

        ResultSet rs = statement.executeQuery("select city from city");

        int rowCount = 0;
        while (rs.next()) {
            System.out.println(rs.getString("city"));
            rowCount++;

        }
        System.out.println("rowCount = " + rowCount);
    }
}

// TODO : city tablosundaki tüm satırlardaki şehir isimlerini absolute ile yazdırınız
// TODO : city tablosundaki tüm satırlardaki şehir isimlerini relative ile yazdırınız
