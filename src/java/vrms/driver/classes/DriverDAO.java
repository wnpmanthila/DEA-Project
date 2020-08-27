/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vrms.driver.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import vrms.user.classes.UserDAO;

/**
 *
 * @author PAVANI
 */
public class DriverDAO {

    public int insert(DriverBean driver) {
        int result = 0;
        try {
            String url = "jdbc:mysql://localhost:3306/vrms_db";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = con.prepareStatement("INSERT INTO driver VALUES (?,?,?,?,?,?,?,?,?)");
            ps.setString(1, driver.getFirst_name());
            ps.setString(2, driver.getLast_name());
            ps.setString(3, driver.getGender());
            ps.setString(4, driver.getPhone_no());
            ps.setString(5, driver.getEmail());
            ps.setString(6, driver.getNic());
            ps.setString(7, driver.getDl_no());
            ps.setString(8, driver.getDob());
            ps.setString(9, driver.getAddress());
            result = ps.executeUpdate();
            ps.close();
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }

}
