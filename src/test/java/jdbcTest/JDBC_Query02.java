package jdbcTest;

import java.sql.*;

public class JDBC_Query02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

    Class.forName("com.mysql.cj.jdbc.Driver");

       Connection connection = DriverManager.getConnection("jdbc:mysql://194.140.198.209/wonderworld_qa2",
                                     "wonderworld_qawcollegeuser",
                                      "1gvyfx6#Q");

       Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        String query = "SELECT * FROM wonderworld_qa2.staff";

        ResultSet resultSet = statement.executeQuery(query);

        resultSet.next();

        System.out.println(resultSet.getString("name"));

    // Joe

        resultSet.next();

        System.out.println(resultSet.getString("name"));

    // Joe
    // Shivam

        resultSet.absolute(5);
        System.out.println(resultSet.getString("name"));

    // Joe
    // Shivam
    // Jason


        resultSet.absolute(6);
        System.out.println(resultSet.getString("surname"));

    // Joe
    // Shivam
    // Jason
    // Deckar

        resultSet.first();
        System.out.println(resultSet.getString("surname"));



    }
}
