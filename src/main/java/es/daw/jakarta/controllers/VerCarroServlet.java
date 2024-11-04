package es.daw.jakarta.controllers;
import java.io.IOException;

import es.daw.jakarta.models.Carro;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/carro/ver")
public class VerCarroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

                 // GESTIONO SI HAY QUE AÑADIR EL DESCUENTO...

        Carro carro = (Carro)request.getSession().getAttribute("carro");//Recupero el carro

        if(carro.getItems().size() > 1){
            request.getSession().setAttribute("descuento","10");  // 10% si hay 2 items o más en el carro
        }else{
            request.getSession().setAttribute("descuento","0");
        }
                
        getServletContext().getRequestDispatcher("/carro.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
