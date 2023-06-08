import java.sql.*;

public class BusDAO {
    public void displayBusInfo() throws SQLException{
        String query = "select *from bus";
        Connection connection = ConnectionDB.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while(resultSet.next()){
            System.out.println("Bus No :"+resultSet.getInt(1));
            if(resultSet.getInt(2)==0){
                System.out.println("AC: No ");
            }else{
                System.out.println("AC : YES ");
            }
            System.out.println("Capacity :"+resultSet.getInt(3));
        }

        System.out.println("!!!!.................!!!!");
    }

    public static int getCapacity(int id)throws SQLException{
        String query = "select capacity from bus where id = "+ id;
        Connection connection = ConnectionDB.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();
        return resultSet.getInt(1);
    }
}
