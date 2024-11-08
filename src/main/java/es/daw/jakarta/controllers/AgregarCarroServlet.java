package es.daw.jakarta.controllers;
import java.io.IOException;
import java.util.Optional;
import es.daw.jakarta.models.Carro;
import es.daw.jakarta.models.ItemCarro;
import es.daw.jakarta.models.Producto;
import es.daw.jakarta.services.ProductService;
import es.daw.jakarta.services.ProductServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/carro/agregar")
public class AgregarCarroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // RECOGER LOS PARÁMETROS DE LA PETICIÓN URL...
        Long id = Long.parseLong(request.getParameter("id"));//desde productos.jsp 


        // LÓGICA DE NEGOCIO....
        // Comprobar si existe el producto. Lo busco por id
        ProductService service = new ProductServiceImpl();

        Optional<Producto> producto = service.buscarPorId(id);

        if (producto.isPresent()){
            // Crear itemCarro. Añadir dicho item al carro
            ItemCarro item = new ItemCarro(1, producto.get());

            HttpSession session = request.getSession();

            Carro carro;
            
            // FASE II: con Listener
            carro = (Carro) session.getAttribute("carro");
            
            carro.addItemCarro(item);
        
       

    }
        
        response.sendRedirect(request.getContextPath()+"/carro/ver");

        //getServletContext().getRequestDispatcher("/carro/ver").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
