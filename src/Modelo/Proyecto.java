/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author juanf
 */
public class Proyecto {
    
    private String codigo;
    private String titulo;
    private LocalDate fechaInicio;
    private String unidadDuracion;
    private byte duracionEstimada;
    private Cliente suCliente;
    private Empleado suGerente;
    private ArrayList<Empleado> suEquipo;
    private String estado;

    public Proyecto(String codigo, String titulo, LocalDate fechaInicio, String unidadDuracion, byte duracionEstimada, Cliente suCliente, Empleado suGerente, ArrayList<Empleado> suEquipo, String estado) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.fechaInicio = fechaInicio;
        this.unidadDuracion = unidadDuracion;
        this.duracionEstimada = duracionEstimada;
        this.suCliente = suCliente;
        this.suGerente = suGerente;
        this.suEquipo = suEquipo;
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getUnidadDuracion() {
        return unidadDuracion;
    }

    public void setUnidadDuracion(String unidadDuracion) {
        this.unidadDuracion = unidadDuracion;
    }

    public byte getDuracionEstimada() {
        return duracionEstimada;
    }

    public void setDuracionEstimada(byte duracionEstimada) {
        this.duracionEstimada = duracionEstimada;
    }

    public Cliente getSuCliente() {
        return suCliente;
    }

    public void setSuCliente(Cliente suCliente) {
        this.suCliente = suCliente;
    }

    public Empleado getSuGerente() {
        return suGerente;
    }

    public void setSuGerente(Empleado suEmpleado) {
        this.suGerente = suEmpleado;
    }

    public ArrayList<Empleado> getSuEquipo() {
        return suEquipo;
    }

    public void setSuEquipo(ArrayList<Empleado> suEquipo) {
        this.suEquipo = suEquipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Proyecto{" + "codigo=" + codigo + ", titulo=" + titulo + ", fechaInicio=" + fechaInicio + ", unidadDuracion=" + unidadDuracion + ", duracionEstimada=" + duracionEstimada + ", suCliente=" + suCliente + ", suGerente=" + suGerente + ", suEquipo=" + suEquipo + ", estado=" + estado + '}';
    }
    
    
    
    public LocalDate determinarFechaFinalizacion() {
        if (this.fechaInicio == null || this.unidadDuracion == null) {
            return null;
        }

        switch (this.unidadDuracion.trim().toLowerCase()) {
            case "semana":
            case "semanas":
                return this.fechaInicio.plusWeeks(this.duracionEstimada);
            case "mes":
            case "meses":
                return this.fechaInicio.plusMonths(this.duracionEstimada);
            case "año":
            case "años":
            case "anio":
            case "anios":
                return this.fechaInicio.plusYears(this.duracionEstimada);
            default:
                return this.fechaInicio;
        }
    }
    
    public void agregarIntegrante(Empleado nuevoIntegrante) {
        if (nuevoIntegrante != null) {
            if (this.suEquipo == null) {
                this.suEquipo = new ArrayList<>();
            }
            this.suEquipo.add(nuevoIntegrante);
        }   
    }
    
    public Empleado eliminarIntegrante(String numeroIdentificacion) {
        if (this.suEquipo == null || numeroIdentificacion == null) {
            return null;
        }

        for (int i = 0; i < this.suEquipo.size(); i++) {
            Empleado integrante = this.suEquipo.get(i);
            // Asume que la clase Empleado posee el método getNumeroIdentificacion()
            if (integrante.getNumeroIdentificacion() != null && 
                integrante.getNumeroIdentificacion().equalsIgnoreCase(numeroIdentificacion)) {
                return this.suEquipo.remove(i);
            }
        }
        return null;
    }
    
}
