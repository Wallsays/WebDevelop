package servlets;

/**
 * Created by IntelliJ IDEA.
 * User: Dis
 * Date: 26.12.12
 * Time: 0:00
 * To change this template use File | Settings | File Templates.
 */

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Registration extends HttpServlet {
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String connectionURL = "jdbc:hsqldb:file:C:\\Users\\Dis\\IdeaProjects\\WebDevelop\\DB_basics\\db\\testDb;ifexists=true";
        Connection connection = null;
        ResultSet rs;
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String uId = req.getParameter("login");
        String pass = req.getParameter("pass1");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            connection = DriverManager.getConnection(connectionURL, "Login", "Pass");
            String sql = "insert into BSN_USERS values (?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(sql);

            Statement stmt = connection.createStatement();

            pst.setString(1, uId);
            pst.setString(2, pass);
            pst.setString(3, name);
            pst.setString(4, age);  Statement s ;
            int numRowsChanged = pst.executeUpdate();
            out.println(" Welcome : ");
            out.println(" '" + name + "'");
            pst.close();
        } catch (ClassNotFoundException e) {
            out.println("Couldn't load database driver: " + e.getMessage());
        } catch (SQLException e) {
            out.println("SQLException caught: " + e.getMessage());
        } catch (Exception e) {
            out.println(e);
        } finally {

            try {
                if (connection != null) connection.close();
            } catch (SQLException ignored) {
                out.println(ignored);
            }
        }
    }
}
