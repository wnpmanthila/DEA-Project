package vrms.invoice.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vrms.invoice.classes.InvoiceBean;
import vrms.invoice.classes.InvoiceDAO;

public class SearchCustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        InvoiceBean invoice = new InvoiceBean();
        InvoiceDAO dao = new InvoiceDAO();
        
        String nic = request.getParameter("nic");
        
        String customer_name = dao.viewSpecificCustomer(invoice, nic);
        
        if(!customer_name.equals("null")){
            request.setAttribute("customer_name", customer_name);
            RequestDispatcher dispatch = request.getRequestDispatcher("web_content/invoice/new_invoice.jsp");
            dispatch.forward(request, response);
        }else{
            request.setAttribute("customer_name", "Not Available");
            RequestDispatcher dispatch = request.getRequestDispatcher("web_content/invoice/new_invoice.jsp");
            dispatch.forward(request, response);
        }
        
    }

}
