<%@page import="com.mycompany.main.logic.Ciudadano"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="components/head.jsp" %>
    <body>
        <!-- Navigation-->
        <%@include file="components/nav.jsp" %>
        <!-- Header-->
        <%@include file="components/header.jsp"%>
        <div class="container">
            <h2>Listado de Ciudadanos</h2>
            <table class="table">
                <thead class="thead-light">
                    <tr>
                        <th scope="col">Nº ID</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Apellido</th>
                        <th scope="col">DNI</th>
                    </tr>
                </thead>

                <% List<Ciudadano> listaCiudadanos = (List) request.getSession().getAttribute("listaCiudadanos"); %>
                <tbody>
                    <% for (Ciudadano ciudadano : listaCiudadanos) {%>
                    <tr>

                        <td><%=ciudadano.getId()%></td><!<!-- Traemos los datos de las variables -->
                        <td><%=ciudadano.getNombre()%></td>
                        <td><%=ciudadano.getApellido()%></td>
                        <td><%=ciudadano.getDni()%></td>
                    </tr>
                    <% }%>
                </tbody>
            </table>
        </div>
    </body>
</html>
