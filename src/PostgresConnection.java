/**
 * Created by vito on 4/11/17.
 */

import java.sql.*;
import java.util.ArrayList;

public class PostgresConnection {
    public ArrayList<String> getResult(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        Statement statement = null;
        ArrayList<String> result = new ArrayList();
        try {

            connection = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/todo", "postgres",
                    "9E5Ab3qq");
            statement = connection.createStatement();
            String sql = "SELECT * FROM POSTS_TABLE;";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                result.add("id: " + resultSet.getString("id")+" post_name: " +
                        resultSet.getString("post_name") + " post_text: "+ resultSet.getString("post_text")+ "\n");
            }
            connection.close();
            statement.close();
            resultSet.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
