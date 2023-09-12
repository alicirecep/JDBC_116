package jdbcTest;

import org.junit.Assert;
import reusableMethodJDBC.ReusableMethod;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;

public class JDBC_Query03 {
    public static void main(String[] args) throws SQLException {


        Statement statement = ReusableMethod.setUpStatement(ReusableMethod.setUpConnection());

        ResultSet resultSet = statement.executeQuery("SELECT * FROM wonderworld_qa2.staff");

        resultSet.next();
        System.out.println(resultSet.getString("name"));
      //----------------------------------------------------------------

        String actualData = resultSet.getString("name");
        String expectedData = "Joe";

        assertEquals(expectedData,actualData);


    }
}
