package com.mycompany.main.logic;

import com.mycompany.main.persistence.ControladoraPersistencia;
import java.util.List;

public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void crearCiudadano(String nombre, String apellido, String dni) {

        //-------------------------Ciudadanos    
        Ciudadano ciudadano = new Ciudadano();

        ciudadano.setNombre(nombre);
        ciudadano.setApellido(apellido);
        ciudadano.setDni(dni);

        controlPersis.crearCiudadano(ciudadano);

    }

    public List<Ciudadano> getCiudadanos() {

        return controlPersis.getCiudadanos();

    }

    //-----------------------------Turno-------------------------------//
    public void crearTurno(Turno turno, Long idCiudadano) {

        //Obtenemos el ciudadano por el id
        Ciudadano ciudadano = controlPersis.obtenerCiudadano(idCiudadano);
        //seteamos el turno en el ciudadano
        turno.setCiudadano(ciudadano);

        controlPersis.crearTurno(turno);
    }

    public List<Turno> traerTurno() {

        return controlPersis.traerTurno();
    }

    public void editarTurno(Turno turno) {
        controlPersis.editarTurno(turno);
    }

    public Turno obtenerTurnoPorNumero(Long numTurno) { //Metodo para obtener el turno por su numero
        return controlPersis.obtenerTurnoPorNumero(numTurno);
    }
}
