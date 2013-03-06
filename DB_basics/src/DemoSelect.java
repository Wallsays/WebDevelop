/**
 * Created by IntelliJ IDEA.
 * User: Dis
 * Date: 23.12.12
 * Time: 18:42
 * To change this template use File | Settings | File Templates.
 */

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DemoSelect {

    public static void main(String[] args) {

        //Connection parameters
        String usr = "sa";
        String pwd = "";
        String driver = "org.hsqldb.jdbcDriver";
        String url = "jdbc:hsqldb:file:/db/testdb;ifexists=true";

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {

            //Starting up the driver
            Class.forName(driver);

            //Conecting
            con = DriverManager.getConnection(url, usr, pwd);

            //Writting a query
            String sql = "create table contacts (id bigint generated by default as identity (start with 1) not null primary key, firstName varchar(15), lastName varchar(20), email varchar(150), notes varchar(500), contactGroup varchar(15))";

            //Setting up the SQL statement
            pstm = con.prepareStatement(sql);

            //Execute the SQL query
            rs = pstm.executeQuery();

            //Iterating the results
            while (rs.next()) {

                //Simple method to show the data
                System.out.print(rs.getInt("empno") + ", ");
                System.out.print(rs.getString("ename") + ", ");
                System.out.print(rs.getDate("hiredate") + ", ");
                System.out.println(rs.getInt("deptno"));

            }

        } catch (Exception e) {

            e.printStackTrace();
            throw new RuntimeException(e);

        } finally {

            try {

                //Closing all the opened resources
                if (rs != null) rs.close();
                if (pstm != null) pstm.close();
                if (con != null) con.close();

            } catch (Exception e) {

                e.printStackTrace();
                throw new RuntimeException(e);

            }

        }

    }

}