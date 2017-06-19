package one;

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
import java.util.Arrays;

/**
 * Created by Administrator on 2017/6/12.
 */
@WebServlet(urlPatterns = "/one/user")
public class UserAction extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println("action...");
        if ("register".equals(action)) {
            register(request,response);
            return;
        }
        if ("logout".equals(action)) {
            request.getSession().invalidate();
            response.sendRedirect("index.jsp");
            return;
        }
        if ("login".equals(action)) {
            login(request,response);
            return;
        }
        request.setAttribute("message","系统出现了一些小小的问题。。。");
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mobile = request.getParameter("mobile");
        String password = request.getParameter("password");

        Connection connection = Db.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            String sql = "SELECT * FROM db_javaee.user WHERE mobile=? AND password=?";
            if (connection != null) {
                statement = connection.prepareStatement(sql);
            } else {
                return;
            }
            statement.setString(1, mobile);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                request.getSession().setAttribute("nick", resultSet.getString("nick"));
                response.sendRedirect("student?action=queryAll");
            } else {
                request.setAttribute("message", "用户名或密码错误");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Db.close(resultSet, statement, connection);
        }
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nick = request.getParameter("nick").trim();
        String mobile = request.getParameter("mobile").trim();
        String password = request.getParameter("password");


        if (nick.length() == 0 || mobile.length() == 0 || password.length() == 0) {
            request.setAttribute("message", "您的昵称 手机号码 或 密码不规范");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        } else {
            Connection connection = Db.getConnection();
            PreparedStatement statement = null;
            ResultSet resultSet = null;
            try {
                String sqlNick = "SELECT * FROM db_javaee.user WHERE nick=?";
                if (connection != null) {
                    statement = connection.prepareCall(sqlNick);
                } else {
                    return;
                }
                statement.setString(1, nick);
                resultSet = statement.executeQuery();
                boolean isNickExist = resultSet.next();

                String sqlMobile = "SELECT * FROM db_javaee.user WHERE mobile = ?";
                statement = connection.prepareStatement(sqlMobile);
                statement.setString(1, mobile);
                resultSet = statement.executeQuery();
                boolean isMobileExist = resultSet.next();


                if (isNickExist & isMobileExist) {
                    request.setAttribute("message", "昵称和手机号都已存在");
                    request.getRequestDispatcher("signup.jsp").forward(request, response);
                } else if (isNickExist) {
                    request.setAttribute("message", "昵称已经存在");
                    request.getRequestDispatcher("signup.jsp").forward(request, response);
                } else if (isMobileExist) {
                    request.setAttribute("message", "手机号已存在");
                    request.getRequestDispatcher("signup.jsp").forward(request, response);
                } else {
                    String sql = "INSERT INTO db_javaee.user VALUE(NULL,?,?,?)";
                    statement = connection.prepareStatement(sql);
                    statement.setString(1, nick);
                    statement.setString(2, mobile);
                    statement.setString(3, password);
                    statement.executeUpdate();


                    response.sendRedirect("index.jsp");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                Db.close(resultSet, statement, connection);
            }
        }
    }
}
