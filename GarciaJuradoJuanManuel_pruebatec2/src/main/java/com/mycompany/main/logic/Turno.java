package com.mycompany.main.logic;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Turno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numTurno;
    private String descripcion;
    private String estado = "En espera";//Por defecto al asignar el turno siempre va a estar en espera
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private String dni;

    //Relacion
    @ManyToOne
    @JoinColumn(name = "id_ciudadano")
    private Ciudadano ciudadano;//Un ciudadano puede tener varios turnos

    //Constructor
    public Turno() {

    }

    public Turno(Long numTurno, String descripcion, Date fecha, Ciudadano ciudadano) {
        this.numTurno = numTurno;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.ciudadano = ciudadano;
    }

    public Long getNumTurno() {
        return numTurno;
    }

    public void setNumTurno(Long numTurno) {
        this.numTurno = numTurno;
    }

    public String getDni() {
        return dni;
    }

    //Getters y setters
    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

}
