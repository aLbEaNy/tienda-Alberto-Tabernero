package es.daw.jakarta.listeners;

import java.time.LocalDate;
import java.time.LocalDateTime;

import es.daw.jakarta.models.Carro;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class AppListener implements ServletContextListener,
        ServletRequestListener, HttpSessionListener {

    private ServletContext sc;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sc = sce.getServletContext();

        sc.log("******** inicializando la aplicacion!");
        //* sc.setAttribute("mensaje", "algun valor global de la app!");
        //* Se recupera desde cualquier lugar con: application.getAttribute("mensaje")

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sc.log("******** destruyendo la aplicacion!");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        sc.log("******** inicializando el request!");
        //* sre.getServletRequest().setAttribute("mensaje", "guardando algun valor para el request");
        //* Se recupera desde el request con: request.getAttribute("mensaje")
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        sc.log("******** destruyendo el request!");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        sc.log("******** inicializando la sesion http");

        Carro carro = new Carro();
        se.getSession().setAttribute("carro", carro);

        //* Comprobar cuando inicia sesion admin
        // if (se.getSession().getAttributeNames("username").equals("admin")){

        // }
        
        //* Hora de inicio de la sesion
        LocalDateTime loginTimeInicio = LocalDateTime.now(); 
        se.getSession().setAttribute("loginTimeInicio", loginTimeInicio);

        sc.log("####### ADMIN HA INICIADO SESION A LAS "+ loginTimeInicio +" #######");


    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        sc.log("******** destruyendo la sesion http");
    }
}
