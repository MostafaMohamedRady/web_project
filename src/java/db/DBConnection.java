
package DBBusiness;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author 7amouda
 */
public class DBConnection {

    String url = "jdbc:mysql://localhost:3306/web_project";
    String user = "root";
    String password = "";

    public Connection openConnection() {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (SQLException ex) {
            System.out.println("can't connect to database");
        }
        return null;

    }

    public void closeConnection(Connection con, Statement st, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }

        } catch (SQLException ex) {
            System.out.println("can't connect to database");
        }
    }
}
