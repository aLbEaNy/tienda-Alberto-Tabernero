<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error</title>
</head>
<body>
    <h1>ERROR:</h1>
    <hr>
    <h2>${msjError}</h2>
    <hr>
    <p><a href="<%=request.getContextPath()%>/index.jsp">Volver al Inicio</a></p>

</body>
</html>
