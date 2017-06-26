package ip;

import one.Students;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/10.
 */
@WebServlet(urlPatterns = "/ip/ip")
public class IpServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        System.out.println("进入到IpServlet中。。。");
        String getIp = req.getParameter("getIp");
        if (getIp.equals("selectAll")) {
            selectAll(req,resp);
            return;
        }
    }

    protected void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入selectALL");
        String geo = req.getParameter("geo");
        if (geo.length()==0) {
            req.setAttribute("message", "错误：没有输入任何信息");
            req.getRequestDispatcher("ip.jsp").forward(req, resp);
            return;
        }
        Connection connection = Db.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            String sql ="SELECT * FROM db_1702.ip WHERE  geo REGEXP ?";
            if (connection != null) {
                statement = connection.prepareStatement(sql);
                statement.setString(1,geo);
                resultSet = statement.executeQuery();
                List<IPS> ips = new ArrayList<>();
                while (resultSet.next()) {
                    IPS ip = new IPS(
                            resultSet.getInt("id"),
                            resultSet.getString("min"),
                            resultSet.getString("max"),
                            resultSet.getString("geo")
                    );
                    ips.add(ip);
                }
                req.getSession().setAttribute("ips", ips);
                resp.sendRedirect("ip.jsp");
            } else {
                req.setAttribute("message", "异常：没有获取到ip信息");
                req.getRequestDispatcher("ip.jsp").forward(req, resp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Db.close(resultSet,statement,connection);
        }

    }
}
