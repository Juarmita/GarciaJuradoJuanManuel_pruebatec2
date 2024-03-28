package com.mycompany.main.servlets;

import com.mycompany.main.logic.Controladora;
import com.mycompany.main.logic.Turno;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@WebServlet(name = "SvEdit", urlPatterns = {"/SvEdit"})
public class SvEdit extends HttpServlet {

    Controladora control = new Controladora();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener el número de turno desde la solicitud
        Long numTurno = Long.parseLong(request.getParameter("numTurno"));

        // Obtener el turno correspondiente desde la base de datos
        Turno turno = control.obtenerTurnoPorNumero(numTurno);

        // Verifico si se encontró un turno con el número dado
        if (turno != null) {
            // Cambiar el estado del turno a "Ya atendido"
            turno.setEstado("Ya atendido");

            // Guardar el cambio en la base de datos
            control.editarTurno(turno);

            // Actualizar la lista de turnos en la sesión
            HttpSession session = request.getSession();
            List<Turno> listaTurnosActualizada = control.traerTurno();
            session.setAttribute("listaTurnos", listaTurnosActualizada);

            // Redirigir de vuelta a la página de listado de turnos
            response.sendRedirect("listadoTurnos.jsp");
        } else {
            System.out.println("Error");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }
    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
