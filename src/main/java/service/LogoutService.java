package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutService {

    public void logout(HttpServletResponse resp, HttpServletRequest req) {
        CookieService cookieService = new CookieService(req, resp);
        cookieService.deleteCookie();
    }
}
