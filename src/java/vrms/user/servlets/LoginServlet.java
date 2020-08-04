package vrms.user.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import vrms.user.classes.UserBean;
import vrms.user.classes.UserDAO;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserBean user = new UserBean();
        user.setUser_name(request.getParameter("user_name"));
        user.setPassword1(request.getParameter("password"));

        UserDAO dao = new UserDAO();
        if (dao.check(user) != null) {
            try {
                HttpSession session = request.getSession();
                session.setAttribute("first_name", dao.check(user).getString("first_name"));
                session.setAttribute("user_role", dao.check(user).getString("user_role"));
                RequestDispatcher dispatch = request.getRequestDispatcher("web_content/dashboard.jsp");
                dispatch.forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Username/Password is Wrong! Please Check Again!');");
//            out.println("location='login.html';");
            out.println("</script>");
            RequestDispatcher dispatch = request.getRequestDispatcher("web_content/dashboard.jsp");
            dispatch.forward(request, response);
        }

    }

}
