
package bank.management.system;

import java.sql.*;

public class Conn {
//    In JDBC connectivity there are 5 steps
//    - Register the driver
//    - Create Connection
//    - Create Statement
//    - Execute Query
//    - Close Connection
    Connection c;
    Statement s;
    public Conn(){
        try {
//            Class.forName(conn.mysql.cj.jdbc.Driver);   //  register the driver
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "@A2m4o6l3");   //create connection
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
