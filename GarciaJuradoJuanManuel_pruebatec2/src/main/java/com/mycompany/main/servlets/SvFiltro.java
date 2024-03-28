package com.mycompany.main.servlets;

import com.mycompany.main.logic.Controladora;
import com.mycompany.main.logic.Turno;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvFiltro", urlPatterns = {"/SvFiltro"})
public class SvFiltro extends HttpServlet {

    Controladora control = new Controladora();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener parámetros desde el JSP
        String estado = request.getParameter("estado");
        String fechaStr = request.getParameter("fecha");

        // Filtrado de los turnos
        List<Turno> listaTurnosFiltrados = filtrarTurnos(estado, fechaStr);

        // Almacenar la lista filtrada en la sesión
        HttpSession session = request.getSession();
        session.setAttribute("listaTurnos", listaTurnosFiltrados);

        // Redireccionar a la página de listado de turnos
        response.sendRedirect("listadoTurnos.jsp");
    }

    // Método para filtrar los turnos según el estado y la fecha
    private List<Turno> filtrarTurnos(String estado, String fechaStr) {
        List<Turno> listaTurnosFiltrados = new ArrayList<>();

        // Obtener todos los turnos
        List<Turno> listaTurnos = control.traerTurno();

        // Filtrar por estado
        if (estado != null && !estado.isEmpty()) {
            for (Turno turno : listaTurnos) {
                if (turno.getEstado().equals(estado)) {
                    listaTurnosFiltrados.add(turno);
                }
            }
        } else {
            
            listaTurnosFiltrados.addAll(listaTurnos);
        }

        // Filtrar por fechagit 
        if (fechaStr != null && !fechaStr.isEmpty()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date fecha = dateFormat.parse(fechaStr);
                listaTurnosFiltrados = listaTurnosFiltrados.stream() //Uso del stream y filter tal como especifica la consigna
                        .filter(turno -> turno.getFecha().equals(fecha))
                        .collect(Collectors.toList());
            } catch (ParseException ex) {
                Logger.getLogger(SvFiltro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return listaTurnosFiltrados;
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
