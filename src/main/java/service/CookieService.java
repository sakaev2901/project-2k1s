package service;

import com.sun.deploy.net.HttpResponse;
import dao.CookieDaoImpl;
import org.springframework.http.HttpRequest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class CookieService {

    private Cookie cookie;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public CookieService(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("sessionId")) {
                    this.cookie = cookies[i];
                }
        }
    }

    private void createCookie() {
        this.cookie = new Cookie("sessionId",request.getSession().getAttribute("user") + "-" + new Date().toString().hashCode());
    }

    public void sendCookieToDatabase() {
        createCookie();
        this.response.addCookie(this.cookie);
        CookieDaoImpl cookieDao = new CookieDaoImpl();
        cookieDao.save(this.cookie.getValue());
    }

    public void deleteCookie() {
        CookieDaoImpl cookieDao = new CookieDaoImpl();
        if (this.cookie != null) {
            cookieDao.delete(this.cookie.getValue());
        }
    }

    public boolean checkCookie() {
        CookieDaoImpl cookieDao = new CookieDaoImpl();
        if (this.cookie == null) {
            return false;
        } else {
            return cookieDao.find(this.cookie.getValue());
        }
    }

    public Cookie getCookie() {
        return cookie;
    }
}
