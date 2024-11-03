<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="es.daw.jakarta.services.CookieService" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/index.css">
    </head>

    <body>
        <% String cValor = CookieService.valorCookie("fondo", request);%>
        <div class="container fondo<%=cValor%>">
            <main>
                <h1>ELIGE UNA OPCIÓN</h1>
                <hr>
                <ul>
                    <li><a class="fondo<%=cValor%>" href="productos">Mostrar productos html</a></li>
                    <li><a class="fondo<%=cValor%>" href="login">Login</a></li>
                    <li><a class="fondo<%=cValor%>" href="logout">Logout</a></li>
                    <li><a class="fondo<%=cValor%>" href="carro/ver">ver carro</a></li>
                </ul>
            </main>
        </div>
    </body>

    </html>