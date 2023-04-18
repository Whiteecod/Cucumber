package _JDBC.Gun01;

import org.testng.annotations.Test;

import java.sql.*;

public class _01_Intro {

    @Test
    public void test1() throws SQLException {
        String hostUrl = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username = "root";
        String password="'\"-LhCB'.%k[4S]z";

        // burada connection açılıyor.
        Connection connection = DriverManager.getConnection(hostUrl , username , password); // bağlantıya click yapildi şu an 1. Madde

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from customer"); // sorgu çalıştı sorgular nerde ? RS de
        rs.next(); // next deyince siradakini veriyor. Yani 1. satiri veriyor.
        String firstname = rs.getString("first_name");
        String lastname = rs.getNString("last_name");
        System.out.println("1. Satirin müşteri adi ve soyadi  = " + firstname + " " + lastname);

        rs.next();
        firstname = rs.getString("first_name");
        lastname = rs.getNString("last_name");
        System.out.println("2. Satirin müşteri adi ve soyadi  = " + firstname + " " + lastname);

        connection.close(); // hafizayi temizlemek için kapatma işlemi yapiliyor.


    }
}
