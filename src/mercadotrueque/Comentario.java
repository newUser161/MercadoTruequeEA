/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercadotrueque;

/**
 * Clase que se encuentra en cada aviso como parte de una coleccion, describe
 * cada comentario de cualquier usuario, una puntuacion y el nombre del susuario
 * que comenta
 *
 * @author Gonzalo Astorga
 * @author Alonso Robledo
 * @since mercadotrueque 0.2
 */
public class Comentario {

    private String comentarioDescripcion;
    private int puntuacion;
    private String nombreUsuarioComentante;
    private int id;

    /**
     * Constructor utilizado al cargar los datos
     *
     * @param comentarioDescripcion descripcion en texto de opicion acerca de la
     * publicacion
     * @param puntuacion valor de 1 a 10 de la publicacion
     * @param nombreUsuarioComentante nombre del usuario que comenta
     * @param id id del comentario en un aviso determinado
     * @since mercadotrueque 0.1
     */
    public Comentario(String comentarioDescripcion, int puntuacion, String nombreUsuarioComentante, int id) {
        this.comentarioDescripcion = comentarioDescripcion;
        this.puntuacion = puntuacion;
        this.nombreUsuarioComentante = nombreUsuarioComentante;
        this.id = id;
    }

    /**
     * Constructor utilizado al instanciar un comentario desde JFAviso
     *
     * @param comentarioDescripcion descripcion en texto de opicion acerca de la
     * publicacion
     * @param puntuacion valor de 1 a 10 de la publicacion
     * @since mercadotrueque 0.1
     */
    Comentario(String comentarioDescripcion, int puntuacion) {
        this.comentarioDescripcion = comentarioDescripcion;
        this.puntuacion = puntuacion;
    }

    /**
     * Retorna la parte del texto del Comentario
     *
     * @return parte del texto del Comentario
     * @since mercadotrueque 0.2
     */
    public String getComentarioDescripcion() {
        return comentarioDescripcion;
    }

    /**
     * Retorna la puntuacion que se dio al aviso en ese comentario
     *
     * @return puntuacion que asigano el comentarista al aviso
     * @since mercadotrueque 0.2
     */
    public int getPuntuacion() {
        return puntuacion;
    }

    /**
     * Retorna el nickname del usuario comentarista
     *
     * @return nickname del usuario comentarista
     * @since mercadotrueque 0.2
     */
    public String getNombreUsuarioComentante() {
        return nombreUsuarioComentante;
    }

    /**
     * Asigna la descripcion del Comentario (la parte del texxto).
     *
     * @param comentarioDescripcion texto del comentario
     * @since mercadotrueque 0.2
     */
    public void setComentarioDescripcion(String comentarioDescripcion) {
        this.comentarioDescripcion = comentarioDescripcion;
    }

    /**
     * Asigna valor a la puntuacion del aviso dejado en el comentario
     *
     * @param puntuacion valor que se asigna al atributo puntuacion
     * @since mercadotrueque 0.2
     */
    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    /**
     * Asigna el nombre del usuario que creo el Comentario
     *
     * @param nombreUsuarioComentante nombre del usuario del Comentario
     * @since mercadotrueque 0.1
     */
    public void setNombreUsuarioComentante(String nombreUsuarioComentante) {
        this.nombreUsuarioComentante = nombreUsuarioComentante;
    }

    /**
     * Retorna ID del Comentario
     *
     * @return ID del Comentario
     * @since mercadotrueque 0.1
     */
    public int getIdComentario() {
        return id;
    }

    /**
     * Asigna un valor al atributo id del Comentario
     *
     * @param id valor que se asignara al atributo id de la clase
     * @since mercadotrueque 0.1
     */
    public void setIdComentario(int id) {
        this.id = id;
    }

}
