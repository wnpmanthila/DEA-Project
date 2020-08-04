package vrms.user.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO {

    public ResultSet check(UserBean user) {
        ResultSet rs = null;
        try {
            String url = "jdbc:mysql://localhost:3306/vrms_db";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = con.prepareStatement("SELECT user_name,user_role FROM user WHERE user_name=? AND password=?");
            ps.setString(1, user.getUser_name());
            ps.setString(2, user.getPassword1());
            rs = ps.executeQuery();
            if (rs.next() != false) {
                return rs;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

}
