package ip;

import com.mysql.jdbc.Driver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/5/18.
 *
 */
public class DownloadIP {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/";
    private static final String USER = "root";
    private static final String PASSWORD = "Glory.0808";
    private static final String SQL = "INSERT INTO ip.ip VALUES (NULL, ?, ?, ?)";
    private static int counter = 0;
    private static PreparedStatement preparedStatement;

    private static void Jdbc(String min, String max, String geo) throws SQLException {

//        3,编译语句
        preparedStatement.setString(1,min);
        preparedStatement.setString(2,max);
        preparedStatement.setString(3,geo);
//        4,执行语句
        preparedStatement.addBatch();//batch 批处理

//         preparedStatement.executeUpdate();

    }

    public static void main(String[] args) throws SQLException {
        //        1,准备数据库驱动
        new Driver();
//        2,获得一次数据库连接
        System.out.println();
        Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
        connection.setAutoCommit(false);
        preparedStatement = connection.prepareStatement(SQL);

        try (
                BufferedReader reader = new BufferedReader(new FileReader("file/ip.txt"))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String min =line.split("\\s+")[0];// "\+s"空格至少有一个，可以有多个
                String max =line.split("\\s+")[1];
                String geo =line.replace(min,"").replace(max,"").trim();
                Jdbc(min,max,geo);
                if ( ++counter%1000 == 0) {
                    System.out.println(counter);
                    preparedStatement.executeLargeBatch();
                }
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        preparedStatement.executeBatch();//在这行代码中把之前的内容一起处理
        connection.commit();//提交
        //        5,释放资源
        connection.close();
        preparedStatement.close();
        System.out.println(counter);
    }
}
