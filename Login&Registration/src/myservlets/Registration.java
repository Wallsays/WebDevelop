package myservlets;

/**
 * Created by IntelliJ IDEA.
 * User: Dis
 * Date: 23.12.12
 * Time: 18:27
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
        String uId = req.getParameter("userId");
        String fname = req.getParameter("firstname");
        String sname = req.getParameter("surname");
        String address1 = req.getParameter("address1");
        String address2 = req.getParameter("address2");
        String town = req.getParameter("town");
        String county = req.getParameter("country");
        String zipcode = req.getParameter("zipcode");
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            connection = DriverManager.getConnection(connectionURL, "Login", "Pass");
            String sql = "insert into userprofile values (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, uId);
            pst.setString(2, fname);
            pst.setString(3, sname);
            pst.setString(4, address1);
            pst.setString(5, address2);
            pst.setString(6, town);
            pst.setString(7, county);
            pst.setString(8, zipcode);
            int numRowsChanged = pst.executeUpdate();
            out.println(" Welcome : ");
            out.println(" '" + fname + "'");
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