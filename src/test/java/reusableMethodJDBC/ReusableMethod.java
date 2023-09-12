package reusableMethodJDBC;

import java.sql.*;

public class ReusableMethod {

    //URL: "jdbc:mysql://194.140.198.209/wonderworld_qa2";
    //USERNAME= "wonderworld_qawcollegeuser";
    //PASSWORD="1gvyfx6#Q";


    public static Connection setUpConnection(){

        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://194.140.198.209/wonderworld_qa2",
                    "wonderworld_qawcollegeuser",
                    "1gvyfx6#Q");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }


    public static Statement setUpStatement(Connection connection){

        Statement statement = null;

        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return statement;
    }


}
