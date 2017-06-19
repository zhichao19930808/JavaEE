package ip;

import util.Db;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/6/10.
 */
@WebServlet(urlPatterns = "/ip/ip")
public class IpServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.doPost(req, resp);
        String ip = request.getParameter("ip");

        Connection connection = Db.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            String sql = "SELECT * FROM db_1702.ip WHERE geo REGEXP ?";
            if (connection != null) {
                statement = connection.prepareStatement(sql);
            } else {
                return;
            }
            statement.setString(1,ip);
            statement.executeUpdate();
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                request.getSession().setAttribute("geo", resultSet.getString("geo"));
                request.getSession().setAttribute("min", resultSet.getString("min"));
                request.getSession().setAttribute("max", resultSet.getString("max"));
                request.getRequestDispatcher("/ip/ip.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "没有查到这个地址的ip");
                request.getRequestDispatcher("/ip/ip.jsp").forward(request,response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Db.close(resultSet, statement, connection);
        }
    }
}
