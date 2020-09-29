/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercadotrueque;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase destinada a validar, cargar y procesar los datos para almacenarlo y
 * enviar a Interfaz. Gestiona la logica de datos.
 *
 * @author Gonzalo Astorga
 * @author Alonso Robledo
 * @since mercadotrueque 0.1
 */
public class EstructuraDatos implements IBusquedaParametro{

    private HashMap<Integer, Aviso> avisoColeccion;
    private ArrayList<Integer> hashAvisoColeccion;
    private int idAviso;
    private HashMap<String, Usuario> usuarioColeccion;
    private ArrayList<String> listaHashUsuarioColeccion;
    private JSONArray jArrayUsuario;

    private AdminClientePublicidad adminClientePublicidad;
    public EstructuraDatos() {
        this.avisoColeccion = new <Integer, Aviso>HashMap();
        this.usuarioColeccion = new <String, Usuario>HashMap();
        this.hashAvisoColeccion = new <Integer>ArrayList();
        listaHashUsuarioColeccion = new <String>ArrayList();
        this.idAviso = 0;
        this.jArrayUsuario = HandlerJson.init("src\\mercadotrueque\\datos.json");
        adminClientePublicidad=new AdminClientePublicidad();
        
        
    }

    /**
     * Coleccion de procesos que cargan todos los datos de la clase para
     * funcionar
     *
     * @since mercadotrueque 0.1
     */
    public void cargarDatos() throws IOException {
        //variable local que captaran los atributos de usuario
        String nombre;
        String clave;
        String correo;
        String titulo;
        //variable local que captaran los atributos de publicacion
        String descripcion;
        String categoria;
        String hashPublicador;
        //variable local que captaran los atributos de comentario
        String cDescripcion;
        String cUsuario;
        int precio;
        int alonsoCoin;
        int region;
        int puntuacion;

        for (Object o : jArrayUsuario) {
            JSONObject usuario = (JSONObject) o;

            nombre = usuario.get("nombre").toString();
            correo = usuario.get("correo").toString();
            clave = usuario.get("clave").toString();
            addUsuario(nombre, correo, clave);

            JSONArray jArrayAviso = (JSONArray) usuario.get("aviso");
            for (Object o1 : jArrayAviso) {
                JSONObject aviso = (JSONObject) o1;
                titulo = aviso.get("titulo").toString();
                descripcion = aviso.get("descripcion").toString();
                categoria = aviso.get("categoria").toString();
                hashPublicador = aviso.get("idPublicador").toString();
                precio = Integer.parseInt(aviso.get("precio").toString());
                alonsoCoin = Integer.parseInt(aviso.get("alonsoCoin").toString());
                region = Integer.parseInt(aviso.get("region").toString());
                int idAvisoNuevo = addPublicacion(hashPublicador, titulo, descripcion, precio, alonsoCoin, categoria, region);

                JSONArray jArrayComentario = (JSONArray) aviso.get("comentario");
                for (Object o2 : jArrayComentario) {
                    JSONObject comentario = (JSONObject) o2;
                    cDescripcion = comentario.get("cDescripcion").toString();
                    cUsuario = comentario.get("cUsuario").toString();
                    puntuacion = Integer.parseInt(comentario.get("puntuacion").toString());
                    addComentario(idAvisoNuevo, cDescripcion, puntuacion, cUsuario);
                }
            }
        }
    }

    /**
     * Crea, valida y agrega un usuario
     *
     * @param nickname nombre del usuario
     * @param correo correo del usuario, este es como se identifica, valor unico
     * entre los demas usuarios
     * @param clave clave de acceso a la session
     * @since mercadotrueque 0.1
     */
    private boolean addUsuario(String nickname, String correo, String clave) {
        //verificamos si existe, si existe retorna null
        if (!isUsuario(correo)) {
            //al no existir es valido agregarlo a las listas
            usuarioColeccion.put(correo, new Usuario(nickname, correo, clave));
            listaHashUsuarioColeccion.add(correo);//
            return true;
        }
        return false;
    }

    /**
     * Crea, valida y agrega un usuario
     *
     * @param usuarioNuevo Nuevo usuario creado mediante formulario
     * @return usuario recientemente agregado
     * @since mercadotrueque 0.2
     */
    public Usuario addUsuario(Usuario usuarioNuevo) throws IOException {
        //lo agregamos a la lista de usuarios
        listaHashUsuarioColeccion.add(usuarioNuevo.getCorreo());
        //persistencia de datos
        JSONObject jUser = HandlerJson.encode(usuarioNuevo);
        HandlerJson.push(jUser, null, jArrayUsuario);
        //agregamos usuario a la lista hashMap y aprovechamos este metodo para retornar
        return usuarioColeccion.put(usuarioNuevo.getCorreo(), usuarioNuevo);
    }

    /**
     * Valida si ya existe el usuario
     *
     * @param correo el correo es el atributo que identifica al usuario
     * @return si ya existe el usuario retorna true, si no, false
     * @since mercadotrueque 0.1
     */
    public boolean isUsuario(String correo) {
        return usuarioColeccion.containsKey(correo);
    }

    /**
     * Crea y Agrega publicidad a la coleccion de avisos, ademas genera id del
     * aviso, agrega aviso a la coleccion del usuario y agrega id del aviso a la
     * coleccion de idAviso
     *
     * @param hashPublicador id (correo) de usuario publicador
     * @param titulo titulo del la publicacion
     * @param descripcion la descripcion del articulo de la publicidad
     * @param precio el precio del articulo
     * @param alonsoCoin valoracion del producto en alonsoCoin
     * @param categoria del articulo [Vechiculo,Hogar,Moda,Computacion,Arte]
     * @param region region en la cual es posible la entrega para la compra o
     * trueque (puede ser en todas las regiones)
     * @return id del aviso
     * @since mercadotrueque 0.1
     */
    private int addPublicacion(String hashPublicador, String titulo, String descripcion, int precio, int alonsoCoin, String categoria, int region) {
        //instanciamos publicacion y lo agregamos a la lista HashMap de aviso
        avisoColeccion.put(idAviso, new Aviso(hashPublicador, titulo, descripcion, precio, alonsoCoin, categoria, region, idAviso, getUsuario(hashPublicador).getNickname()));
        //obtenemos el usuario que publico
        Usuario user = getUsuario(hashPublicador);
        //agregamos el aviso a la coleccion de avisos publicados del usuario
        user.addAviso(idAviso);
        //agregamos hash de aviso a la lista de hash de avisos
        hashAvisoColeccion.add(idAviso);
        //aumentamos/modificamos idAviso para una proxima instanciacion de publicacion
        idAviso++;
        //retornamos el id del aviso recientemente creada
        return (idAviso - 1);
    }

    /**
     * Completa datos de Aviso parcial entrega por Interfaz,Agrega publicidad a
     * la coleccion de avisos, ademas genera id del aviso, agrega aviso a la
     * coleccion del usuario y agrega id del aviso a la coleccion de idAviso.
     *
     * @param correoPublicador id (correo) de usuario publicador
     * @param nuevoAviso Aviso parcial (sin idaviso,sin idpublicador) para
     * agregar
     * @return id del aviso
     * @since mercadotrueque 0.2
     */
    public int addPublicacion(String correoPublicador, Aviso nuevoAviso) throws IOException {
        //buscamos el usuario actual que creo la publicacion
        Usuario user = getUsuario(correoPublicador);
        //creamos una publicacion y la asignamos al aviso parcial traspasada por parametro
        Aviso aviso = nuevoAviso;
        //completamos los datos del aviso
        aviso.setIdAviso(idAviso);
        aviso.setIdPublicador(correoPublicador);
        aviso.setIdAviso(idAviso);
        aviso.setNickanemPublicador(user.getNickname());
        //agregamos el aviso a la lista de avisos de l usuario
        user.addAviso(idAviso);
        //ahora modificamos las colecciones de EstructuraDeDatos donde se registran los avisos 
        avisoColeccion.put(idAviso, aviso);
        hashAvisoColeccion.add(idAviso);
        //persistencia de datos
        JSONObject jAviso = HandlerJson.encode(aviso);
        HandlerJson.push(jAviso, user, jArrayUsuario);
        //recordar modificar el id para las proximas instancias de aviso
        idAviso++;
        //retornar el id del aviso creado recientemente
        return (idAviso - 1);
    }

    /**
     * Devuelve copia de la coleccion de usuarios
     *
     * @return copia de la coleccion de usuarios
     * @since mercadotrueque 0.1
     */
    public ArrayList<Usuario> getUsuarios() {
        ArrayList<Usuario> lista = new <Usuario>ArrayList();
        for (int i = 0; i < listaHashUsuarioColeccion.size(); i++) {
            Usuario UserActual = usuarioColeccion.get(listaHashUsuarioColeccion.get(i));
            lista.add(UserActual);
        }
        //lista.addAll(listaUsuario);
        return lista;
    }

    /**
     * Valida y devuelve usuario buscado por su id(correo) de la coleccion de
     * usuarios
     *
     * @param correoLogin correo de suaurio a buscar que funciona como id
     * @return usuario o null en caso de no existir en la coleccion
     * @since mercadotrueque 0.1
     */
    public Usuario getUsuario(String correoLogin) {
        if (isUsuario(correoLogin)) {
            return (Usuario) usuarioColeccion.get(correoLogin);
        } else {
            return null;
        }
    }

    /**
     * Entrega una copia(se ve la implenatcion de copira en .getAvisos()) de la
     * coleccion de idHash de los avisos de usuario
     *
     * @param userActual usuario a quien se desea obtener lista de sus idHash de
     * los avisos publicados
     * @return copia de la lista de los idHash de sus avisos
     * @since mercadotrueque 0.2
     */
    private ArrayList<Integer> getHashAvisosUser(Usuario userActual) {
        return userActual.getAvisos();
    }

    /**
     * Crea y Entrega una lista de clase Aviso de los avisos de un usuario
     *
     * @param userActual usuario a quien se desea obtener lista de sus avisos
     * publiados
     * @return copia de la lista de sus avisos
     * @since mercadotrueque 0.2
     */
    public ArrayList<Aviso> getAvisosUser(Usuario userActual) {
        ArrayList<Aviso> listaAvisos = new <Aviso>ArrayList();
        ArrayList<Integer> listaHash = getHashAvisosUser(userActual);
        //verifico que exista usuario y aviso
        if (getHashAvisosUser(userActual) != null && !getHashAvisosUser(userActual).isEmpty()) {
            //recorro a lista hash de aviso
            for (int i = 0; i < listaHash.size(); i++) {
                //obtengo aviso de lista y agrego a la lista copia que se retornará
                Aviso actual = (Aviso) avisoColeccion.get(listaHash.get(i));
                listaAvisos.add(actual);
            }
        }
        return listaAvisos;
    }

    /**
     * Elimina una publicacion, tanto de la coleccion de avisos de
     * estructuraDeDatos, de la coleccion de aviso de usuario y elimina el
     * idHash del aviso de la coleccion de idHash de avisos
     *
     * @param idUser id (correo) de usuario publicador del aviso
     * @param idEliminarAviso id del aviso a eliminar
     * @return retorna true en caso de exito en la eliminacion
     * @since mercadotrueque 0.2
     */
    public boolean eliminarPublicacion(String idUser, int idEliminarAviso) {
        if (!isUsuario(idUser)) {
            return false;
        }
        if (!usuarioColeccion.get(idUser).isPublicacion(idEliminarAviso)) {
            return false;
        }

        //buscamos a usuario y eliminamos aviso de su coleccion de publicaciones
        usuarioColeccion.get(idUser).eliminarAviso(idEliminarAviso);
        //eliminamos de la coleccion de avisos
        avisoColeccion.remove(idEliminarAviso);
        //eliminamos de la coleccion de hash de aviso
        boolean encontrado = false;
        for (int i = 0; i < hashAvisoColeccion.size() && encontrado != true; i++) {
            if (hashAvisoColeccion.get(i) == idEliminarAviso) {
                hashAvisoColeccion.remove(i);
                encontrado = true;
            }
        }
        return true;
    }

    /**
     * Busca usuario para eliminar su publicacion, tanto de la coleccion de
     * avisos de estructuraDeDatos, de la coleccion de aviso de usuario y
     * elimina el idHash del aviso de la coleccion de idHash de avisos
     *
     * @param userActual usuario publicador del aviso
     * @param idEliminar id del aviso a eliminar
     * @since mercadotrueque 0.2
     */
    public void eliminarPublicacion(Usuario userActual, int idEliminar) {
        //eliminar de coleccion aviso
        avisoColeccion.remove(idEliminar);
        //eliminar de usuario
        userActual.eliminarAviso(idEliminar);
        boolean eliminado = false;
        //eliminar de coleccion<HashAviso
        for (int i = 0; i < hashAvisoColeccion.size() && eliminado == false; i++) {
            if (hashAvisoColeccion.get(i) == idEliminar) {
                hashAvisoColeccion.remove(i);
                eliminado = true;
            }
        }
    }

    /**
     * crea y retorna una copia de Persona, superclase de Usuario
     *
     * @param userActual usuario que hereda de Persona
     * @return copia de Persona, clase padre de parametro "userActual"
     * @since mercadotrueque 0.2
     */
    public Persona getCopiaPersona(Usuario userActual) {
        Persona userEnvio = new Persona(userActual.getNombre(), userActual.getRut(), userActual.getDireccion(), userActual.getRegion());
        return userEnvio;
    }

    /**
     * Crea y Guarda comentario de aviso
     *
     * @param idAvisoNuevo id del aviso donde se agregará comentario
     * @param comentarioDescripcion parte descriptiva (texto) del Comentario
     * @param puntuacion valoracion del articulo que asigno el comentarista
     * @param nombreUsuarioComentante nombre del usuario que creo el Comentario
     * @since mercadotrueque 0.2
     */
    private void addComentario(int idAvisoNuevo, String comentarioDescripcion, int puntuacion, String nombreUsuarioComentante) throws IOException {//
        Aviso avisoAgregandoComentario = getAvisoId(idAvisoNuevo);
        avisoAgregandoComentario.addComentario(comentarioDescripcion, puntuacion, nombreUsuarioComentante);

    }

    /**
     * Retorna aviso buscado por su id
     *
     * @param idAvisoNuevo id del aviso que se busca
     * @return aviso buscado con el parametro "idAvisoNuevo"
     * @since mercadotrueque 0.2
     */
    private Aviso getAvisoId(int idAvisoNuevo) {
        return (Aviso) avisoColeccion.get(idAvisoNuevo);
    }

    /**
     * Crea y Retorna copia de coleccion aviso
     *
     * @return copia de coleccion aviso
     * @since mercadotrueque 0.3
     */
    public ArrayList<Aviso> getAvisoColeccion() {
        ArrayList<Aviso> copiaListaAviso = new <Aviso>ArrayList();
        //recorremos la lista de avisos
        for (int i = 0; i < hashAvisoColeccion.size(); i++) {
            Aviso avisoTraspaso = (Aviso) avisoColeccion.get(hashAvisoColeccion.get(i));
            //lo vamos copiando a la lista
            copiaListaAviso.add(avisoTraspaso);
        }
        return copiaListaAviso;
    }

    /**
     * Crea y Retorna copia de coleccion de claves hash de usuarios
     *
     * @return coleccion de claves hash de usuarios
     * @since mercadotrueque 0.3
     */
    public ArrayList<String> getListaHashUsuario() {
        ArrayList<String> copiaLista = new <String>ArrayList();
        copiaLista.addAll(listaHashUsuarioColeccion);
        return copiaLista;
    }
    /**
     * Retorna copia de lista de los avisos
     *
     * @return copia de lista de los avisos
     * @since mercadotrueque 0.3
     */
    public ArrayList<Integer> getListaHashAvisos() {
        ArrayList<Integer> copiaLIstaHashAviso = new <Integer>ArrayList();
        copiaLIstaHashAviso.addAll(hashAvisoColeccion);
        return copiaLIstaHashAviso;
    }
    /**
     * Retorna lista acotada (por busqueda) de avisos
     *
     * @param mensajeSolicitudBusqueda solicitud que contiene los requerimientos de busqueda
     * @return lista acotada (por busqueda) de avisos
     * @since mercadotrueque 0.3
     */
    public ArrayList<Aviso> getAvisosAcotados(SolicitudBusqueda mensajeSolicitudBusqueda) {
        ArrayList<Aviso> listaAcotada = new <Aviso>ArrayList();
        for (int i = 0; i < hashAvisoColeccion.size(); i++) {
            //obtenemos aviso de la lsiat de avisos
            Aviso avisoActual = (Aviso) avisoColeccion.get(hashAvisoColeccion.get(i));
            //verificamos si cumple con requisito de categoria
            if (avisoActual.getCategoria().equals(mensajeSolicitudBusqueda.getCategoria())) {
                //verificamos si cumple con requisito de region
                if (mensajeSolicitudBusqueda.getRegion() == 0 || mensajeSolicitudBusqueda.getRegion() == avisoActual.getRegion()) {
                    // si cumple ambos requisitos se agrega a nuestra lista acotada
                    listaAcotada.add(avisoActual);
                }
            }
        }
        //ordenamos la lista
        listaAcotada=ordenarListaBusqueda(listaAcotada,mensajeSolicitudBusqueda.getOrden());
        return listaAcotada;
    }

    /**
     * Elimina usuario
     *
     * @param correo rut de usuario a eliminar
     * @return true si es exitosa la eliminacion
     * @since mercadotrueque 0.4
     */
    public boolean eliminarUsuario(String correo) {
        //verificamos que exista el usuario
        if (isUsuario(correo)) {
            usuarioColeccion.remove(correo);
            //recorremos lista hash de usuarios
            for (int i = 0; i < listaHashUsuarioColeccion.size(); i++) {
                //si un usuario de la lista con mismo correo que el parametro lo hemos encontrado
                //lo eliminamos y retornamos true por ser exitosa la eliminacion
                if (listaHashUsuarioColeccion.get(i).equals(correo)) {
                    listaHashUsuarioColeccion.remove(i);
                }
            }
            return true;
        }
        //retornamos false en caso de no encontrar usuario
        return false;
    }
    /**
     * Verifica y Elimina publicacion
     * @param idAvisoEliminar id del aviso que se desea eliminar
     * @return true si es exitosa la eliminacion
     * @since mercadotrueque 0.4
     */
    public boolean eliminarPublicacion(int idAvisoEliminar) {
        //recorremos la lista de hash de los usuarios
        for (int i = 0; i < listaHashUsuarioColeccion.size(); i++) {
            Usuario user = (Usuario) usuarioColeccion.get(listaHashUsuarioColeccion.get(i));
            ArrayList<Integer> lista = user.getAvisos();
            if (lista != null) {
                //buscamos en lista de publicaciones de cada usuario
                for (int k = 0; k < lista.size(); k++) {
                    //si lo encontramos lo eliminamos de cada lista donde esta registrado
                    if (lista.get(k) == idAvisoEliminar) {
                        user.eliminarAviso(idAvisoEliminar);
                        avisoColeccion.remove(idAvisoEliminar);
                        return true;
                    }
                }
            }
        }
        //si no lo encontramos retornamos false
        return false;
    }
    /**
     * Retorna si es verdadero que cierto id es existente en la lista de avisos
     * @param id id del aviso que se desea verificar si existe en la coleccion de avisos
     * @return true si existe el aviso en la coleccion de avisos
     * @since mercadotrueque 0.4
     */
    public boolean isAviso(int id) {
        return avisoColeccion.containsKey(id);
    }
    /**
     * Retorna Aviso buscado por su id
     * @param id id del aviso que se desea obtener
     * @return Aviso perteneciente al id entregado, en caso de no existir retornará null
     * @since mercadotrueque 0.4
     */
    public Aviso getAviso(int id) {
        if (isAviso(id)) {
            return avisoColeccion.get(id);
        }
        return null;
    }

    private ArrayList<Aviso> ordenarListaBusqueda(ArrayList<Aviso> listaAcotada, int orden) {
        ArrayList<Aviso>listaOrdenada=new <Aviso>ArrayList();
        switch(orden){
            
            case SIN_ORDEN:{
                listaOrdenada=listaAcotada;
                break;
            }
            case ASCENDENTE:{
                for(int i=1;i<=10;i++){
                    for(int j=0;j<listaAcotada.size();j++){
                        if(listaAcotada.get(j).getAlonsoCoin() == i)
                            listaOrdenada.add(listaAcotada.get(j));
                    }
                }
                break;
            }
            case DESCENDENTE:{
                for(int i=10;i>=1;i--){
                    for(int j=0;j<listaAcotada.size();j++){
                        if(listaAcotada.get(j).getAlonsoCoin() == i)
                            listaOrdenada.add(listaAcotada.get(j));
                    }
                }
                break;
            }
        }
        
        return listaOrdenada;
    }

    public BannerPublicitario getRandomBanner() {
        return adminClientePublicidad.getRandomBanner();
    }
}
