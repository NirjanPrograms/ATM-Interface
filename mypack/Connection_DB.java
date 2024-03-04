package mypack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connection_DB {
    Connection con;
    Statement stm;

    Connection_DB() {
        try {
            String url = "jdbc:mysql://localhost:3306/Applications";
            String user = "root";
            String password = "Nirjan@2503";
            con = DriverManager.getConnection(url, user, password);
            stm = con.createStatement();
            // System.out.println("Connected");
        } catch (Exception e) {
            // System.out.println("Unable to connect with database!!!");
            System.out.println(e.getMessage());
        }
    }
}
