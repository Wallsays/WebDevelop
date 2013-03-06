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
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.Map;

public class Send extends HttpServlet {
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
        String whom = req.getParameter("uId");
        String mess = req.getParameter("text");
        String sender = req.getParameter("sender");

        try {
            Class.forName("org.hsqldb.jdbcDriver");
            connection = DriverManager.getConnection(connectionURL, "Login", "Pass");
            String sql = "insert into BSN_IM (sender,whom,mes) values (?,?,?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, sender);
            pst.setString(2, whom);
            pst.setString(3, mess);
            int numRowsChanged = pst.executeUpdate();

            sql = "select whom,mes from BSN_IM im WHERE im.SENDER=?";
            pst = connection.prepareStatement(sql);
            pst.setString(1, sender);
            ResultSet mrs = pst.executeQuery();
            StringBuffer sb = new StringBuffer("");
            while( mrs.next() ) {
                sb.append("To " + mrs.getString("whom")+" "+mrs.getString("mes")+"<p>");
            }
//            String goTo= "/send.jsp?uId="+ sender;
//            req.getRequestDispatcher(goTo).include(req,res);
//            out.println(sb);

            sql = "select sender,mes from BSN_IM im WHERE im.WHOM=?";
            pst = connection.prepareStatement(sql);
            pst.setString(1, sender);
            ResultSet mmrs = pst.executeQuery();
            //StringBuffer ssb = new StringBuffer("");
            while( mmrs.next() ) {
                sb.append("From " + mmrs.getString("sender")+" "+mmrs.getString("mes")+"<p>");
            }
            String goTo= "/send.jsp?uId="+ sender;
            req.getRequestDispatcher(goTo).include(req,res);
            out.println(sb);
            mmrs.close();
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
