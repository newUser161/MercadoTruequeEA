/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercadotrueque;

import java.util.ArrayList;

/**
 * Guarda los datos del usuario correspondiente a la logica de mercadoTruque,
 * hereda de Persona que tiene los datos personales de persona usuaria
 *
 * @author Gonzalo Astorga
 * @author Alonso Robledo
 * @since mercadotrueque 0.1
 */
public class Usuario extends Persona {

    private String nickname;
    private String correo;
    private String clave;
    private ArrayList<Integer> avisos;

    /**
     * Constructor de Usuario
     *
     * @param nickname nickname del usuario
     * @param correo correo/email del usuario, sirve hash para la coleccion de
     * usuarios de la clase EstructuraDeDatos
     * @param clave clave de acceso a la cuenta de usuario
     * @since mercadotrueque 0.1
     */
    public Usuario(String nickname, String correo, String clave) {
        super();
        this.nickname = nickname;
        this.correo = correo;
        this.clave = clave;
        avisos = new <Integer>ArrayList();
    }

    /**
     * Entrega nombre del ususario
     *
     * @return nombre del ususario
     * @since mercadotrueque 0.1
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Entrega correo del usuario
     *
     * @return correo del usuario
     * @since mercadotrueque 0.1
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Entrega clave de usuario
     *
     * @return clave de usuario
     * @since mercadotrueque 0.1
     */
    public String getClave() {
        return clave;
    }

    /**
     * Agrega aviso a la colleccion de avisos publicaods del usuario
     *
     * @param idAviso numero identificatio del aviso
     * @since mercadotrueque 0.1
     */
    public void addAviso(int idAviso) {
        avisos.add(idAviso);
    }

    /**
     * Crea y entrega una copia de la coleccion de avisos publciados por el
     * usuario
     *
     * @return copia de la coleccion de avisos publciados por el usuario
     * @since mercadotrueque 0.2
     */
    public ArrayList<Integer> getAvisos() {
        if (avisos.isEmpty()) {
            return null;
        }
        ArrayList<Integer> lista = new <Integer>ArrayList();
        lista.addAll(avisos);
        return (ArrayList) lista;
    }

    /**
     * Elimina un aviso de la coleccion de avisos publicados
     *
     * @param idEliminar id de aviso que se desea eliminar
     * @since mercadotrueque 0.2
     */
    public void eliminarAviso(int idEliminar) {
        boolean terminado = false;
        //recorremos los avisos publicados por el usuario
        for (int i = 0; i < avisos.size() && terminado == false; i++) {
            /*  Si acierta el id del paraemtro con algun aviso de la coleccion
                lo podemos eliminar*/
            if (avisos.get(i) == idEliminar) {
                avisos.remove(i);
                terminado = true;
            }
        }
    }

    /**
     * Verifica si existe cierta publicacion de determinado id
     *
     * @param id de publicacion que se decea verificar si existe
     * @return retorna true si existe publicacion
     * @since mercadotrueque 0.2
     */
    public boolean isPublicacion(int id) {
        for (int i = 0; i < avisos.size(); i++) {
            if (avisos.get(i) == id) {
                return true;
            }
        }
        return false;
    }
}
