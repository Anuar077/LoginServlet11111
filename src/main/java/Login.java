import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        request.getRequestDispatcher("link.html").include(request, response);

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        if (password.equals("aa")) {
            out.print("Welcome to the site");
            out.print("Welcome, " + name);

            Cookie ck = new Cookie("name", name);
            ck.setMaxAge(1800);
            response.addCookie(ck);
        } else {
            out.print(" Username or password error!");
            request.getRequestDispatcher("login.html").include(request, response);
        }

        out.close();
    }

}