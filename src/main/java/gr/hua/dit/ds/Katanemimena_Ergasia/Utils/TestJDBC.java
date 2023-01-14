package gr.hua.dit.ds.Katanemimena_Ergasia.Utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/VehicleDealership?useSSL=false";
        String user = "root";
        String pass = "ergasia_kat";

        try {
            System.out.println("Connecting to database: " + jdbcUrl);
            Connection con = DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("Connection success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
