import java.io.*;
import javax.servlet.*;

public class NewFilter implements Filter {
    static int count = 0;

    public void init(FilterConfig arg0) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        PrintWriter out = response.getWriter();
        long before = System.currentTimeMillis();

        chain.doFilter(request, response);

        System.out.print("Total visitors:" + (++count) + " ");
        out.close();
        long after = System.currentTimeMillis();
        System.out.print("Total response time: " + (after - before) + " miliseconds" + " ");
        out.close();
    }

    public void destroy() {
    }
}  