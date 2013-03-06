/**
 * Created by IntelliJ IDEA.
 * User: Dis
 * Date: 23.12.12
 * Time: 19:57
 * To change this template use File | Settings | File Templates.
 */
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCPreparedStatementCreateExample {

    private static final String DB_DRIVER = "org.hsqldb.jdbcDriver";
    private static final String DB_CONNECTION = "jdbc:hsqldb:file:C:\\Users\\Dis\\IdeaProjects\\WebDevelop\\DB_basics\\db\\testDb;ifexists=true";
    private static final String DB_USER = "Login";
    private static final String DB_PASSWORD = "Pass";

    public static void main(String[] argv) {

        try {

            createTable();

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }

    private static void createTable() throws SQLException {

        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String createTableSQL = "CREATE TABLE DBUSER3("
                + "USER_ID INT NOT NULL, "
                + "USERNAME VARCHAR(20) NOT NULL, "
                + "CREATED_BY VARCHAR(20) NOT NULL, "
                + "CREATED_DATE DATE NOT NULL, " + "PRIMARY KEY (USER_ID) "
                + ")";

        try {
            dbConnection = getDBConnection();
            preparedStatement = dbConnection.prepareStatement(createTableSQL);

            System.out.println(createTableSQL);

            // execute create SQL stetement
            preparedStatement.executeUpdate();

            System.out.println("Table \"dbuser\" is created!");

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }

        }

    }

    private static Connection getDBConnection() {

        Connection dbConnection = null;

        try {

            Class.forName(DB_DRIVER);

        } catch (ClassNotFoundException e) {

            System.out.println(e.getMessage());

        }

        try {

            dbConnection = DriverManager.getConnection(
                    DB_CONNECTION, DB_USER,DB_PASSWORD);
            return dbConnection;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return dbConnection;

    }

}
