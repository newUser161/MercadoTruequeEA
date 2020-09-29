/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercadotrueque;

/**
 * Clase que se compone de atributos personales a nivel de persona y no de usuario
 * @author Gonzalo Astorga
 * @author Alonso Robledo
 * @since mercadotrueque 0.1
 */
public class Persona {
    private String nombre;
    private String rut;
    private String direccion;
    private int region;

    public Persona() {
        //
    }

    public Persona(String nombre, String rut, String direccion, int region) {
        this.nombre = nombre;
        this.rut = rut;
        this.direccion = direccion;
        this.region = region;
    }
    /**
     * Entrega nombre de la persona
     *
     * @return nombre de la persona
     * @since mercadotrueque 0.1
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Entrega rut de la persona
     * @return rut de la persona
     * @since mercadotrueque 0.1
     */
    public String getRut() {
        return rut;
    }
    /**
     * Entrega direccion de la persona
     * @return direccion de la persona
     * @since mercadotrueque 0.1
     */
    public String getDireccion() {
        return direccion;
    }
    /**
     * Entrega region de la persona
     * @return region de la persona
     * @since mercadotrueque 0.1
     */
    public int getRegion() {
        return region;
    }
    
}
