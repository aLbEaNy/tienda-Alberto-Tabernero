package es.daw.jakarta.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import es.daw.jakarta.models.Carro;
import es.daw.jakarta.models.ItemCarro;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/actualizar/carro")
public class ActualizarCarroServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {

        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {

                Carro carro = (Carro) request.getSession().getAttribute("carro");// recupero carro de sesion

                
                                

                // Guardaré los id de los checkbox marcados
                if (request.getParameterValues("borrar") != null) {
                        String[] itemsABorrar = request.getParameterValues("borrar");
                        // Borro los items del carro
                        for (String item : itemsABorrar) {
                                Long itemL = Long.parseLong(item);
                                carro.removeItem(itemL);// LLAMO A METODO DE Carro
                        }
                }

                // Actualizar cantidades
                for (ItemCarro item : carro.getItems()) {

                        int cantidad = Integer.parseInt(request.getParameter("cantidad" + item.getProducto().getId()));
                        if (cantidad > 0) {
                                item.setCantidad(cantidad);
                        } 
                }
                // vuelvo a mostrar el carro
                getServletContext().getRequestDispatcher("/carro/ver").forward(request, response);

        }
}
