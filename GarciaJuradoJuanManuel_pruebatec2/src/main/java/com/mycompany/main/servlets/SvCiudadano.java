package com.mycompany.main.servlets;

import com.mycompany.main.logic.Ciudadano;
import com.mycompany.main.logic.Controladora;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvCiudadano", urlPatterns = {"/SvCiudadano"})
public class SvCiudadano extends HttpServlet {

    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Ciudadano> listaCiudadanos = new ArrayList<Ciudadano>();

        listaCiudadanos = control.getCiudadanos();

        HttpSession misesion = request.getSession();//Mantenemos la sesion activa del user
        misesion.setAttribute("listaCiudadanos", listaCiudadanos);//Guardamos la lista como un atributo de la sesion

        response.sendRedirect("listadoCiudadanos.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Capturamos los datos desde index
        String nombreCiudadano = request.getParameter("nombre");
        String apellidoCiudadano = request.getParameter("apellido");
        String dniCiudadano = request.getParameter("dni");

        control.crearCiudadano(nombreCiudadano, apellidoCiudadano, dniCiudadano);

        response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
   
}
