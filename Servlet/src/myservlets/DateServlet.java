package myservlets;

/**
 * Created by IntelliJ IDEA.
 * User: Dis
 * Date: 23.12.12
 * Time: 0:05
 * To change this template use File | Settings | File Templates.
 */

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DateServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {

        PrintWriter pw = response.getWriter();

        Date today = new Date();

        pw.println("<html>" + "<body bgcolor=\"#999966\">" +
                "<h1>Date and Time with Servlet</h1>");
        pw.println("<b>" + today + "</b></body>" + "</html>");

    }
}