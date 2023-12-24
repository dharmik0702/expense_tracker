

package expence.tracker.system;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;
    Conn() {
        try {
            c = DriverManager.getConnection("jdbc:mysql:///ebc", "root", "dharmik@0702");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}