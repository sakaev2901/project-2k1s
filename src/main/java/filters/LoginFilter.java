package filters;

import service.CookieService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", urlPatterns = {"/profile", "/dictionary/*", "/parsing", "/test"})
public class LoginFilter extends HttpFilter {
    @Override
    public void destroy() {

    }


    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = request.getSession();
        CookieService cookieService = new CookieService(request, response);
        if (cookieService.checkCookie()) {
            String cookieValue = cookieService.getCookie().getValue();
            Integer id = Integer.parseInt(cookieValue.substring(0, cookieValue.indexOf("-")));
            session.setAttribute("user", id);
        }
        Integer userId = (Integer)session.getAttribute("user");

        if (userId != null) {
            chain.doFilter(request, response);
        } else {
            response.sendRedirect("login");
        }
    }
}
