package vrms.invoice.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InvoiceDAO {

    public String viewSpecificCustomer(InvoiceBean invoice, String nic) {
        String customer_name = "null";
        try {
            String url = "jdbc:mysql://localhost:3306/vrms_db";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = con.prepareStatement("SELECT nic,first_name FROM customer WHERE nic=?");
            ps.setString(1, nic);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                invoice.setNic(rs.getString("nic"));
                customer_name = rs.getString("first_name");

            } else {
                customer_name = "null";
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(InvoiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customer_name;
    }

    public ResultSet viewCategory() {
        ResultSet result = null;
        try {
            String url = "jdbc:mysql://localhost:3306/vrms_db";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = con.prepareStatement("SELECT cat_id,type FROM category");
            result = ps.executeQuery();
            return result;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(InvoiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public ResultSet viewModel() {
        ResultSet result = null;
        try {
            String url = "jdbc:mysql://localhost:3306/vrms_db";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = con.prepareStatement("SELECT make_id,name FROM make");
            result = ps.executeQuery();
            return result;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(InvoiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
