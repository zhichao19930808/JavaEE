package util;

import com.mysql.jdbc.Driver;

import javax.validation.constraints.Null;
import java.sql.*;

/**
 * Created by Administrator on 2017/6/9.
 */
public class Db {
    private static String URL = "jdbc:mysql:///?user=root&password=Glory.0808";

    public static Connection getConnection() {
        try {
            new Driver();
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
