/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vrms.invoice.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vrms.invoice.classes.InvoiceDAO;

public class ViewCategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            InvoiceDAO dao = new InvoiceDAO();
            ResultSet result = dao.viewCategory();
            out.print("<select class=\"form-control\" id=\"exampleFormControlSelect1\" name=\"category\" onChange=\"location.href='web_content/invoice/new_invoice.jsp?option1='+this.value;\">");
            out.print("<option value=\"null\">Select Category</option>");
            if (result != null) {
                while (result.next()) {
                    out.print("<option value=" + result.getString("cat_id") + ">" + result.getString("type") + "</option>");
                }
            }else{
                out.print("<option value='null'>Not Available</option>");
            }
            out.print("</select>");
        } catch (SQLException ex) {
            Logger.getLogger(ViewCategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
