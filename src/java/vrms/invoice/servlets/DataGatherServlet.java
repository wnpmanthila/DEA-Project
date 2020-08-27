package vrms.invoice.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vrms.invoice.classes.InvoiceBean;

public class DataGatherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String option1 = request.getParameter("option1");
        String option2 = request.getParameter("option2");

        InvoiceBean invoice = new InvoiceBean();

        invoice.setCategory(option1);
        invoice.setModel(option2);
        
        RequestDispatcher dispatch = request.getRequestDispatcher("web_content/invoice/new_invoice.jsp");
        dispatch.forward(request, response);

    }

}
