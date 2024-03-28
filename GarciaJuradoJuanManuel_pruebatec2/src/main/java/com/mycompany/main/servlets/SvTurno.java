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

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvTurno", urlPatterns = {"/SvTurno"})
public class SvTurno extends HttpServlet {

    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Obtenemos los turnos de la base de datos
        List<Turno> listaTurnos = new ArrayList<Turno>();
        
        listaTurnos = control.traerTurno();
        
        HttpSession misesion = request.getSession();//Mantemos activa la sesion
        misesion.setAttribute("listaTurnos", listaTurnos);
        
        //Obtenemos los turnos para mostrarlos en el JSP
        request.setAttribute("turno", listaTurnos);

        request.getRequestDispatcher("listadoTurnos.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idCiudadano = request.getParameter("id");
        String descripcionTurno = request.getParameter("tramite");
        String fechaTurnos = request.getParameter("fecha");
        String numeroTurno = request.getParameter("numTurno");
        String nuevoEstado = "Ya atendido"; // El nuevo estado que deseas asignar

        // Convertir la cadena de fecha a un objeto Date
        Date fechaTurno = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            fechaTurno = dateFormat.parse(fechaTurnos);

            //Creamos el nuevo Turno
            Turno turno = new Turno();
            turno.setDescripcion(descripcionTurno);
            turno.setFecha(fechaTurno);

            //Persistimos el turno con el id
            control.crearTurno(turno, Long.parseLong(idCiudadano));

            // Redirigir a la página principal
            response.sendRedirect("index.jsp");
        }
        catch (ParseException ex) {
            Logger.getLogger(SvTurno.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}
