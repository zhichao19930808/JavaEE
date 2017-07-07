package library;

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
 * Created by Administrator on 2017/6/28.
 */
@WebServlet(urlPatterns = "/library/libraryBooks")
public class LibraryBooksAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        System.out.println("进入到doGet方法");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        System.out.println("进入到LibraryBooks界面");
        String action = req.getParameter("action");
        if ("add".equals(action)) {
            System.out.println("进入到add方案");
            add(req, resp);
            return;
        }
        if ("queryAll".equals(action)) {
            System.out.println("进入到queryAll方案");
            queryAll(req, resp);
            return;
        }
        if ("queryById".equals(action)) {
            System.out.println("进入到queryById方案");
            queryById(req, resp);
            return;
        }
        if ("queryByKey".equals(action)) {
            System.out.println("进入到queryByKey方案");
            queryByKey(req, resp);
            return;
        }
        if ("edit".equals(action)) {
            System.out.println("进入到edit方案");
            edit(req, resp);
            return;
        }
        if ("remove".equals(action)) {
            System.out.println("进入到remove方案");
            remove(req, resp);
            return;
        }
        req.setAttribute("message", "错误：没有与之匹配的方法");
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("开始执行add方法");
        String title = req.getParameter("title").trim();
        String author = req.getParameter("author").trim();
        String pub = req.getParameter("pub").trim();
        String time = req.getParameter("time").trim();

        if (title.length() == 0 || author.length() == 0 || pub.length() == 0 || time.length() == 0) {
            req.setAttribute("message", "添加失败：您输入的信息不规范");
            req.getRequestDispatcher("admin.jsp").forward(req, resp);
        } else {
            double price = Double.parseDouble(req.getParameter("price").trim());
            int amount = Integer.parseInt(req.getParameter("amount").trim());
            Connection connection = Db.getConnection();
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            String sql = "INSERT INTO library.books VALUES(NULL, ?, ?, ?, ?, ?, ?)";
            try {
                if (connection == null) {
                    req.setAttribute("message", "Connection为null");
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                } else {
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, title);
                    preparedStatement.setString(2, author);
                    preparedStatement.setString(3, pub);
                    preparedStatement.setString(4, time);
                    preparedStatement.setDouble(5, price);
                    preparedStatement.setInt(6, amount);
                    preparedStatement.executeUpdate();

                    req.setAttribute("message", "成功添加书名为《"+title+"》的书集");
                    queryAll(req, resp);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Db.close(null, preparedStatement, connection);
            }
        }
    }
    private void remove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("开始执行remove方法");
        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        Connection connection = Db.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM library.books WHERE id = ?";
        try {
            if (connection == null) {
                req.setAttribute("message", "Connection为null");
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            } else {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1,id);
                preparedStatement.executeUpdate();
                req.setAttribute("message","成功删除《"+title+"》");
                queryAll(req,resp);
            }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Db.close(null, preparedStatement, connection);
            }
        }
    private void queryAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("开始执行queryALL方法");
        Connection connection = Db.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM library.books ORDER BY id";
        try {
            if (connection == null) {
                req.setAttribute("message", "Connection为null");
                req.getRequestDispatcher("index.jsp").forward(req,resp);
            } else {
                preparedStatement = connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
                List<Books> books = new ArrayList<>();
                while (resultSet.next()) {
                    Books book = new Books(
                            resultSet.getInt("id"),
                            resultSet.getString("title"),
                            resultSet.getString("author"),
                            resultSet.getString("pub"),
                            resultSet.getString("time"),
                            resultSet.getDouble("price"),
                            resultSet.getInt("amount")
                    );
                    books.add(book);
                }
                req.getSession().setAttribute("books", books);
                req.setAttribute("message",req.getAttribute("message"));
                req.getRequestDispatcher("admin.jsp").forward(req,resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Db.close(resultSet, preparedStatement, connection);
        }
    }
    private void queryById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("开始执行queryById方法");
        int id = Integer.parseInt(req.getParameter("id"));
        Connection connection = Db.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM library.books WHERE id=?";
        try {
            if (connection == null) {
                req.setAttribute("message", "Connection为null");
                req.getRequestDispatcher("index.jsp").forward(req,resp);
            } else {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1,id);
                resultSet = preparedStatement.executeQuery();
                resultSet.next();
                    Books book = new Books(
                            resultSet.getInt("id"),
                            resultSet.getString("title"),
                            resultSet.getString("author"),
                            resultSet.getString("pub"),
                            resultSet.getString("time"),
                            resultSet.getDouble("price"),
                            resultSet.getInt("amount")
                    );
                req.getSession().setAttribute("book", book);
                resp.sendRedirect("edit.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Db.close(resultSet, preparedStatement, connection);
        }
    }
    private void queryByKey(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("开始执行queryByKey方法");
        String key = req.getParameter("key");
        String value = req.getParameter("value");
        Connection connection = Db.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM library.books WHERE "+key+" LIKE ?";
        System.out.println("11111111");
        try {
            if (connection == null) {
                req.setAttribute("message", "Connection为null");
                req.getRequestDispatcher("index.jsp").forward(req,resp);
            } else {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,"%"+value+"%");
                resultSet = preparedStatement.executeQuery();
                ArrayList<Books> books = new ArrayList<>();
                System.out.println("2222222222");
                while (resultSet.next()) {
                    System.out.println("www");
                    Books book = new Books(
                            resultSet.getInt("id"),
                            resultSet.getString("title"),
                            resultSet.getString("author"),
                            resultSet.getString("pub"),
                            resultSet.getString("time"),
                            resultSet.getDouble("price"),
                            resultSet.getInt("amount")
                    );
                    System.out.println("33333333");
                    books.add(book);
                    System.out.println("3");
                }
                req.getSession().setAttribute("books", books);
                resp.sendRedirect("default.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Db.close(resultSet, preparedStatement, connection);
        }
    }
    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("开始执行edit方法");
        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title").trim();
        String author = req.getParameter("author").trim();
        String pub = req.getParameter("pub").trim();
        String time = req.getParameter("time").trim();
        double price = Double.parseDouble(req.getParameter("price").trim());
        int amount = Integer.parseInt(req.getParameter("amount").trim());
        Connection connection = Db.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE library.books SET " +
                "title = ?," +
                "author= ?," +
                "pub = ?," +
                "time = ?," +
                "price = ?," +
                "amount = ?" +
                " WHERE id = ?";;
        try {
            if (connection == null) {
                req.setAttribute("message", "Connection为null");
                req.getRequestDispatcher("index.jsp").forward(req,resp);
            } else {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,title );
                preparedStatement.setString(2,author);
                preparedStatement.setString(3,pub );
                preparedStatement.setString(4,time);
                preparedStatement.setDouble(5,price );
                preparedStatement.setInt(6,amount);
                preparedStatement.setInt(7,id);
                preparedStatement.executeUpdate();
                req.setAttribute("message","成功编辑该书");
                queryAll(req, resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Db.close(null, preparedStatement, connection);
        }
    }


}
