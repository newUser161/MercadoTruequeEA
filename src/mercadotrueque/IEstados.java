/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercadotrueque;

/**
 * Almacena constantes comunes de algunas clases como Interfaz
 * indica los distintos flujos existentes en el programa
 *
 * @author Gonzalo Astorga
 * @author Alonso Robledo
 * @since mercadotrueque 0.1
 */
interface IEstados {

    public static final int EXIT = 100;
    public static final int LOGIN = 0;
    public static final int MENU = 1;
    public static final int FORMULARIO = 2;
    public static final int HISTORIALPUBLICACIONES = 3;
    public static final int CONFIGURACION = 4;
    public static final int BUSQUEDA = 5;
    public static final int PEDIDOBUSQUEDA = 6;
    public static final int LISTABUSQUEDA=7;
    public static final int MODO_MASTER = 99;
    
    public static final int SIN_RESPUESTA=0;
    public static final int LOGIN_ACEPTADA=1;
    public static final int REGISTRO=2;
    public static final int LOGINAMENU=3;
    
    public static final int SIN_ID_AVISO_ELIMINAR=-1;
    
}
