package ModeloCCL;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

public class Cnn {

    public static final String URL = "jdbc:mysql://localhost:3306/bdcontrolescola?autoReconnect=true&useSSL=false";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "123";

    public static Connection getConection() {
        Connection cnn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnn = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
            

        } catch (Exception e) {
            System.out.println(e);

        }
        return cnn;
    }

}
