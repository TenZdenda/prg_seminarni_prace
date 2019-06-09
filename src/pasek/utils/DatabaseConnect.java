package pasek.utils;

import java.sql.*;

public class DatabaseConnect {

    public static Connection getConnection(){
        Connection connection = null;

        try {
            //Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/prgsp?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;

    }

}
