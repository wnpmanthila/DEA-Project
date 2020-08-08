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

public class ViewMakeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String option1 = request.getParameter("option1");

        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            InvoiceDAO dao = new InvoiceDAO();
            ResultSet result = dao.viewModel();
            out.print("<select class=\"form-control\" id=\"exampleFormControlSelect1\" name=\"make\" onChange=\"location.href='web_content/invoice/new_invoice.jsp?option2='+this.value;\">");
            out.print("<option value=\"null\">Select Make</option>");
            if (result.next()) {
                while (result.next()) {
                    out.print("<option value=" + result.getString("make_id") + ">" + result.getString("name") + "</option>");
                }
            } else {
                out.print("<option value='null'>Not Available</option>");
            }
            out.print("</select>");
        } catch (SQLException ex) {
            Logger.getLogger(ViewCategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
