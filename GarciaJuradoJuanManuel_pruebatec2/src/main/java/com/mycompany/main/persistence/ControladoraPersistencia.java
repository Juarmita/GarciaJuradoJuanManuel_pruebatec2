package com.mycompany.main.persistence;

import com.mycompany.main.logic.Ciudadano;
import com.mycompany.main.logic.Turno;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {

    CiudadanoJpaController ciudJpa = new CiudadanoJpaController();
    TurnoJpaController turnJpa = new TurnoJpaController();

    //-----------Ciudadano---------------------
    public void crearCiudadano(Ciudadano ciudadano) {
        ciudJpa.create(ciudadano);
    }

    public List<Ciudadano> getCiudadanos() {

        return ciudJpa.findCiudadanoEntities();

    }

    public Ciudadano obtenerCiudadano(Long id) {
        return ciudJpa.findCiudadano(id);
    }

    //---------------------Turno-----------------
    public void crearTurno(Turno turno) {
        turnJpa.create(turno);
    }

    public List<Turno> traerTurno() {

        return turnJpa.findTurnoEntities();
    }

    public void editarTurno(Turno turno) {
        try {
            turnJpa.edit(turno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Turno obtenerTurnoPorNumero(Long numTurno) {
        return turnJpa.findTurno(numTurno);
    }

}
