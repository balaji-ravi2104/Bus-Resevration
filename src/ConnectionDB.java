import java.sql.*;

public class ConnectionDB {
    private static final String url = "jdbc:mysql://localhost:3306/busresv";
    private static final String name = "root";
    private static final String password = "Balaji@21042003";

   public static Connection getConnection() throws SQLException{
       return DriverManager.getConnection(url,name,password);
   }

}
