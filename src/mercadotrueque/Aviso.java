/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercadotrueque;

import java.util.ArrayList;

/**
 * Entidad de la coleccion de avisos de la plataforma, se almacena en
 * EstructuraDeDatos y se referencia desde los usuarios como publicador
 *
 * @author Gonzalo Astorga
 * @author Alonso Robledo
 * @since mercadotrueque 0.1
 */
public class Aviso {

    private String titulo;
    private String descripcion;
    private int precio;
    private int alonsoCoin;
    private String categoria;
    private int region;
    private int idAviso;
    private String idPublicador;
    private String nicknamePublicador;
    private ArrayList<Comentario> comentarios;
    private int idComentario;

    /**
     * Constructor utilizado al cargar los datos
     *
     * @param idPublicador id/correo del usuario que publico el aviso
     * @param titulo titulo del aviso
     * @param descripcion la descripcion del articulo del aviso
     * @param precio precio en moneda chilena del articulo del aviso
     * @param alonsoCoin estimacion valorica en AlonsoCoin que el publicador le
     * asigna a su articulo
     * @param categoria categoria perteneciente del articulo del aviso
     * @param region regoin en la cual es posible la compra o trueque del
     * articulo
     * @param idAviso id del aviso entegrada por EstructuraDeDatos al
     * crear/cargar el aviso
     * @param nicknamePublicador nickname del usuario que publica e aviso
     * @since mercadotrueque 0.1
     */
    public Aviso(String idPublicador, String titulo, String descripcion, int precio, int alonsoCoin, String categoria, int region, int idAviso, String nicknamePublicador) {
        this.idPublicador = idPublicador;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.alonsoCoin = alonsoCoin;
        this.categoria = categoria;
        this.region = region;
        this.idAviso = idAviso;
        this.nicknamePublicador = nicknamePublicador;
        //instancia la coleccion de comentarios que tendra el aviso
        comentarios = new <Comentario>ArrayList();
        //inicializa el id de los futuros comentarios en 0
        idComentario = 0;
    }

    /**
     * Constructor utilizado al crear los datos,esta esta se completa en
     * EstructuraDeDatos llegando de Formulario de manera parcial y luego
     * complementario con setter como el id asignado por EstructruaDeDatos
     *
     * @param titulo titulo del aviso
     * @param descripcion la descripcion del articulo del aviso
     * @param precio precio en moneda chilena del articulo del aviso
     * @param alonsoCoin estimacion valorica en AlonsoCoin que el publicador le
     * asigna a su articulo
     * @param categoria categoria perteneciente del articulo del aviso
     * @param region regoin en la cual es posible la compra o trueque del
     * articulo
     * @since mercadotrueque 0.2
     */
    public Aviso(String titulo, String descripcion, int precio, int alonsoCoin, String categoria, int region) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.alonsoCoin = alonsoCoin;
        this.categoria = categoria;
        this.region = region;
        //instancia la coleccion de comentarios que tendra el aviso
        comentarios = new <Comentario>ArrayList();
        //inicializa el id de los futuros comentarios en 0
        idComentario = 0;
    }

    /**
     * Agrega un comentario a la coleccion de comentarios del aviso
     *
     * @param comentarioClase es una instancia Comentario ya completo listo para
     * agregar a la coleccion de comentarios
     * @since mercadotrueque 0.2
     */
    public void addComentario(Comentario comentarioClase) {
        comentarioClase.setIdComentario(idComentario);
        comentarios.add(comentarioClase);
        idComentario++;
    }

    /**
     * Crea un Comentario para luego agregarlo a la coleccion de comentarios del
     * aviso
     *
     * @param comentarioDescripcion es el comentario en si mismo, el texto
     * descriptivo
     * @param puntuacion valoracion asignada por el creador del comentario
     * @param nombreUsuarioComentante nombre del usuario que comento
     * @since mercadotrueque 0.2
     * @return Comentario creado y agregado
     */
    public Comentario addComentario(String comentarioDescripcion, int puntuacion, String nombreUsuarioComentante) {
        Comentario nuevoComentario = new Comentario(comentarioDescripcion, puntuacion, nombreUsuarioComentante, idComentario);
        comentarios.add(nuevoComentario);
        //aumenta/modifica el idComentario para el proximo comentario que se vaya a crear
        idComentario++;
        return nuevoComentario;
    }

    /**
     * Envia una copia de los comentarios del aviso
     *
     * @return lista copia de los comentarios del aviso
     * @since mercadotrueque 0.2
     */
    public ArrayList<Comentario> getComentarios() {
        ArrayList<Comentario> listaCopia = new <Comentario>ArrayList();
        if (!comentarios.isEmpty()) {
            listaCopia.addAll(comentarios);
            return listaCopia;
        } else {
            return null;
        }
    }

    /**
     * Elimina comentario de la publicacion indicada por su id
     *
     * @param idComentario id del comentario a eliminar
     * @return si la eliminacion fue exitosa
     * @since mercadotrueque 0.4
     */
    public boolean eliminarComentario(int idComentario) {
        for (int i = 0; i < comentarios.size(); i++) {
            if (comentarios.get(i).getIdComentario() == idComentario) {
                comentarios.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Asigna un valor al id del aviso
     *
     * @param idAviso es el id que tendra ese aviso
     * @since mercadotrueque 0.1
     */
    public void setIdAviso(int idAviso) {
        this.idAviso = idAviso;
    }

    /**
     * Asigna un valor id al publicador del aviso
     *
     * @since mercadotrueque 0.1
     */
    public void setIdPublicador(String idPublicador) {
        this.idPublicador = idPublicador;
    }

    /**
     * Retorna id del publicador del aviso
     *
     * @return id del publicador del aviso
     * @since mercadotrueque 0.1
     */
    public String getIdPublicador() {
        return idPublicador;
    }

    /**
     * Retorna titulo del aviso
     *
     * @return titulo del aviso
     * @since mercadotrueque 0.1
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Retorna descripcion del aviso
     *
     * @return descripcion del aviso
     * @since mercadotrueque 0.1
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Retorna precio del aviso
     *
     * @return precio del aviso
     * @since mercadotrueque 0.1
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * Retorna valor de AlonsoCoin del aviso
     *
     * @return cantidada AlonsoCoin
     * @since mercadotrueque 0.1
     */
    public int getAlonsoCoin() {
        return alonsoCoin;
    }

    /**
     * Retorna la categoria del aviso
     *
     * @return categoria del aviso
     * @since mercadotrueque 0.1
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Retorna la region donde se puede comprar o realizar trueque del aviso
     *
     * @return region donde se encuentra facilidad de transsaccion del articulo
     * @since mercadotrueque 0.1
     */
    public int getRegion() {
        return region;
    }

    /**
     * Retorna id del aviso
     *
     * @return id del aviso
     * @since mercadotrueque 0.1
     */
    public int getIdAviso() {
        return idAviso;
    }

    /**
     * Obtiene el nickname del publciador del aviso
     *
     * @return nickname del publciador del aviso
     * @since mercadotrueque 0.1
     */
    public String getNicknamePublicador() {
        return nicknamePublicador;
    }

    /**
     * Asigna un valor al atributo nickname de la clase
     *
     * @param nickname el valor que se asigna al atributo nickname
     * @since mercadotrueque 0.1
     */
    public void setNickanemPublicador(String nickname) {
        nicknamePublicador = nickname;
    }

    /**
     * Asigna un valor al atributo titulo de la clase
     *
     * @param titulo valor que se asigna al atributo titulo
     * @since mercadotrueque 0.1
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Asigna un valor al atributo descripcion de la clase
     *
     * @param descripcion valor que se asigna al atributo descripcion
     * @since mercadotrueque 0.1
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Asigna un valor al atributo precio de la clase
     *
     * @param precio valor que se asigna a atributo precio
     * @since mercadotrueque 0.1
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * Asigna un valor al atributo alonsoCoin de la clase
     *
     * @param alonsoCoin valor que se asigna al atributo alonsoCoin
     * @since mercadotrueque 0.1
     */
    public void setAlonsoCoin(int alonsoCoin) {
        this.alonsoCoin = alonsoCoin;
    }

    /**
     * Asigna un valor al atributo nickname de la clase
     *
     * @param categoria valor que se asigna al atributo categoria
     * @since mercadotrueque 0.1
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Asigna un valor al atributo region de la clase
     *
     * @param region valor que se asigna al atributo region
     * @since mercadotrueque 0.1
     */
    public void setRegion(int region) {
        this.region = region;
    }

}
