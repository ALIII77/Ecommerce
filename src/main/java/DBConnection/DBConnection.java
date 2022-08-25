package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String SERVER_ADDRESS = "127.0.0.1:5432";
    private static final String DBNAME = "Ecommerce";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Aliii09124169320";
    private Connection connection;


    public Connection connect() {


        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://" + SERVER_ADDRESS + "/" + DBNAME, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;

    }
}

