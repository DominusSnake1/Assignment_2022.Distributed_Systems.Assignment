package gr.hua.dit.ds.Katanemimena_Ergasia.Utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

    public static void TestConnection() {

        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/VehicleDealership?useSSL=false&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true";
        String user = "root";
        String pass = "pass123";

        try {
            System.out.println("Database \"" + jdbcUrl + "\"");
            Connection con = DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("SUCCESSFULLY CONNECTED TO THE DATABASE");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
