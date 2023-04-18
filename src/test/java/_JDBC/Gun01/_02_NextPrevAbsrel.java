package _JDBC.Gun01;

import _JDBC.JDBSParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _02_NextPrevAbsrel extends JDBSParent {
    @Test
    public void NextPrev() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from language");
        rs.next(); // 1. satiri veriyor.
        System.out.println("1. Satir = " + rs.getString(2)); // column sirasi

        rs.next(); // 2. Satir
        System.out.println("2. Satir= " + rs.getString(2));

        rs.next(); // 3. Satir
        System.out.println("3. Satir= " + rs.getString(2));

        rs.previous(); // 2. Satir
        System.out.println("1 geri Satira gitti= " + rs.getString(2));
    }

    @Test
    public void AbsoluteRelative() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from film");
        // rs.next(); bir sonraki satir
        // rs.previous(); bir önceki satir
        // rs.absolute(10); baştan itibaren 10. satir git
        // rs.relative(10); bulunduğu yerden 10. satira gider
        // rs.absolute(-10); sondan -10 sondan 10. satira gider
        // rs.relative(-5); bulunduğu yerden 5 satir geri gider..
        rs.absolute(10);
        System.out.println("10. Satir - Title = " + rs.getString("title"));
        rs.relative(5); // 15. satira gider çünkü Bulunduğu yerden itibaren 5 satir ilerler.
        System.out.println("15. Satir - Title = " + rs.getString("title"));

    }
}
