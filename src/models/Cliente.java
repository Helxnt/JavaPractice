/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Asus
 */
public class Cliente {
    
    //variables
    private String cedula;
    private String nombre;
    private String direccion;
    private String genero;
    private String estado;
    
    //constructor
    public Cliente(String cedula, String nombre, String direccion, String genero, String estado){
    
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.genero = genero;
        this.estado = estado;
    
    }
    
    //sobrecarga
    public Cliente(String cedula, String nombre){
        
        this(cedula, nombre, "","","");
    }
    
    //getters 
        public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getGenero() {
        return genero;
    }

    public String getEstado() {
        return estado;
    }
    
    
    // validar los datos de la cedula
    public boolean validarCedula() {
        return cedula != null && cedula.matches("\\d{3}-\\d{7}-\\d");
    }
    
    //asegurarse que no este la cedula o nombre vacios
     public boolean validarDatos() {
        return cedula != null && !cedula.isEmpty() &&
               nombre != null && !nombre.isEmpty();
    }

     //sobreescritura
    @Override
    public String toString() {
        return "Cédula: " + cedula + "\n" +
               "Nombre: " + nombre + "\n" +
               "Dirección: " + direccion + "\n" +
               "Género: " + genero + "\n" +
               "Estado: " + estado;
    }
    
}
