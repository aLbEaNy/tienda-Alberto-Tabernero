package es.daw.jakarta.services;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieService {

    /**
     * CREA UNA COOKIE
     * 
     * @param nombreCookie
     * @param valor
     * @param response
     */
    public void creaCookie(String nombreCookie, String valor, HttpServletResponse response) {
        Cookie cookie = new Cookie(nombreCookie, valor);
        response.addCookie(cookie);
        System.out.println(cookie);
    }

    /**
     * COMPRUEBA SI EXISTE UNA COOKIE
     * 
     * @param nombreCookie
     * @param request
     * @return
     */
    public boolean existeCookie(String nombreCookie, HttpServletRequest request) {
        // Obtener el array de cookies del request
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (nombreCookie.equals(c.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void borraCookie(String nombreCookie, HttpServletRequest request, HttpServletResponse response) {
        Cookie c = new Cookie("fondo", "");
        c.setMaxAge(0);
        response.addCookie(c);
    }

    /**
     * METODO ESTATICO PARA DEVOLVER EL VALOR DE UNA COOKIE
     * 
     * @param nombreCookie
     * @param request
     * @return
     */
    public static String valorCookie(String nombreCookie, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (nombreCookie.equals(c.getName())) {
                    return c.getValue();
                }
            }
        }
        return "";
    }
}
