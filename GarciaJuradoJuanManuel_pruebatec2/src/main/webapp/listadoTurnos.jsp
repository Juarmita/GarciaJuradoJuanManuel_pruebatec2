<%@page import="com.mycompany.main.logic.Turno"%>
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
            <h2>Listado de Turnos</h2>
            <!-- Filtros -->
            <div class="row mb-3">
                <!-- Filtro por Estado -->
                <div class="col-md-3">
                    <form action="SvFiltro" method="POST">
                        <label for="estado">Filtrar por Estado:</label>
                        <select name="estado" id="estado" class="form-control">
                            <option value="">Todos</option>
                            <option value="En espera">En espera</option>
                            <option value="Ya atendido">Ya atendido</option>
                        </select>
                        <button type="submit" class="btn btn-primary mt-2">Aplicar</button>
                    </form>
                </div>
                <!-- Filtro por Fecha -->
                <div class="col-md-3">
                    <form action="SvFiltro" method="POST">
                        <label for="fecha">Filtrar por Fecha:</label>
                        <input type="date" name="fecha" id="fecha" class="form-control">
                        <button type="submit" class="btn btn-primary mt-2">Aplicar</button>
                    </form>
                </div>
            </div>

            <!-- Tabla de Turnos -->
            <table class="table">
                <thead class="thead-light">
                    <tr>
                        <th scope="col">Nº de Turno</th>
                        <th scope="col">Trámite</th>
                        <th scope="col">Estado</th>
                        <th scope="col">Fecha</th>
                        <th scope="col">DNI Ciudadano Asociado</th>
                        <th scope="col">Acción</th>
                    </tr>
                </thead>
                <tbody>
                    <% List<Turno> listaTurnos = (List<Turno>) request.getSession().getAttribute("listaTurnos"); %>
                    <% for (Turno turno : listaTurnos) {%>
                    <tr>
                        <td><%= turno.getNumTurno()%></td>
                        <td><%= turno.getDescripcion()%></td>
                        <td><%= turno.getEstado()%></td>
                        <td><%= turno.getFecha()%></td>
                        <td><%= turno.getCiudadano().getDni()%></td>
                        <td>
                            <form action="SvEdit" method="POST">
                                <button type="submit" class="btn btn-warning">Cambiar estado</button>
                                <input type="hidden" name="numTurno" value="<%= turno.getNumTurno()%>">
                            </form>
                        </td>
                    </tr>
                    <% }%>
                </tbody>
            </table>
        </div>
    </body>
</html>





