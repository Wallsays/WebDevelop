package servlets;

/**
 * Created by IntelliJ IDEA.
 * User: Dis
 * Date: 26.12.12
 * Time: 0:00
 * To change this template use File | Settings | File Templates.
 */

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class Login extends HttpServlet {
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String connectionURL = "jdbc:hsqldb:file:C:\\Users\\Dis\\IdeaProjects\\WebDevelop\\DB_basics\\db\\testDb;ifexists=true";
        Connection connection = null;
        ResultSet rs;
        res.setContentType("text/html");
        //res.setContentType("java");
        PrintWriter out = res.getWriter();
        String uId = req.getParameter("login");
        String pass = req.getParameter("pass");
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            connection = DriverManager.getConnection(connectionURL, "Login", "Pass");
            String sql = "select PASS from BSN_USERS u WHERE u.UID=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, uId);
            //int numRowsChanged =

            ResultSet mrs = pst.executeQuery();
            mrs.next();
            String password = mrs.getString("PASS");
            boolean b = false;
            String outMes = /*"Неверный пароль";*/   "Incorrect pass";
            if (password.equals(pass)) {
                b = true;
                out.println(" Welcome : ");
                out.println(" '" + uId + "'");
                //req.setAttribute("uId", uId);

                String goTo= "/send.jsp?uId="+ uId;
                req.getRequestDispatcher(goTo).include(req,res);

                sql = "select whom,mes from BSN_IM im WHERE im.SENDER=?";
                pst = connection.prepareStatement(sql);
                pst.setString(1, uId);
                ResultSet mmrs = pst.executeQuery();
                StringBuffer sb = new StringBuffer("");
                while( mmrs.next() ) {
                    sb.append("To " + mmrs.getString("whom")+" "+mmrs.getString("mes")+"<p>");
                }
                sql = "select sender,mes from BSN_IM im WHERE im.WHOM=?";
                pst = connection.prepareStatement(sql);
                pst.setString(1, uId);
                ResultSet mmmrs = pst.executeQuery();
                while( mmmrs.next() ) {
                    sb.append("From " + mmmrs.getogetString("sender")+" "+mmmrs.getString("mes")+"<p>");
                }
                out.println(sb);
                mmmrs.close();
                mmrs.close();

                mmrs.close();
            } else {
                out.println(outMes + "<p><a href=\"index.jsp\" >Go to login page</a> ");

                req.getRequestDispatcher("/index.jsp").include(req,res);
            }

            mrs.close();
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
