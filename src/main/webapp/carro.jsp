<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@page import="es.daw.jakarta.models.*" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Carro de compras</title>
        </head>

        <body>
            <h1>Carro de compras</h1>
            <% Carro carro=(Carro) session.getAttribute("carro"); 
            if (carro==null || carro.getItems().isEmpty()) {%>

                <p>Lo sentimos, no hay productos en el carro de compras!</p>

                <%} else {
                   int dto = Integer.parseInt(request.getSession().getAttribute("descuento").toString());
                    %>

                    <form action="<%=request.getContextPath()%>/actualizar/carro" method="post">
                        <table>
                            <tr>
                                <th>id</th>
                                <th>nombre</th>
                                <th>precio</th>
                                <th>cantidad</th>
                                <th>total</th>
                                <th>borrar</th>
                            </tr>

                            <% for(ItemCarro item: carro.getItems()){ 
                                Long _Id = item.getProducto().getId();%>

                                <tr>
                                    <td>
                                        <%=item.getProducto().getId()%>
                                    </td>
                                    <td>
                                        <%=item.getProducto().getNombre()%>
                                    </td>
                                    <td>
                                        <%=item.getProducto().getPrecio()%>
                                    </td>
                                    
                                    <td><input type="number" name="cantidad<%=_Id%>" value="<%=item.getCantidad()%>"></td>
                                    <td style="text-align: right">
                                        <%=item.getImporte()%>
                                    </td>
                                    <td><input type="checkbox" name="borrar" value="<%=_Id%>"></td>

                                </tr>
                                <%}%>
                                    <tr>
                                        <% if(dto != 0)
                                        {%>
                                        <td colspan="2" style="text-align: right">CUPON <%=dto%>% dto</td>
                                        <td colspan="2" style="text-align: right">Total:</td>
                                        <td style="text-align: right">
                                            <%=(int)(carro.getTotal()-((dto/100.0)*carro.getTotal()))%>
                                        </td>
                                        <%}else{%>

                                        <td colspan="4" style="text-align: right">Total:</td>
                                        <td style="text-align: right">
                                            <%=carro.getTotal()%>
                                        </td>
                                        <%}%>
                                    </tr>

                        </table>

                        <%}%>
                            <hr>
                    <button type="submit">Actualizar</button></p>
                    </form>
                    <p><a href="<%=request.getContextPath()%>/productos">Seguir comprando</a></p>
                    <p><a href="<%=request.getContextPath()%>/index.jsp">Volver</a></p>
        </body>

        </html>