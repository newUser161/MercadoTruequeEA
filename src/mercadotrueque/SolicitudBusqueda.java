/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercadotrueque;

/**
 * Clase que continen informacion de Busqueda, se gestiona como solicitud que se
 * envia a Interfaz la cual envia la solicitud a Estrctura de datos para crear
 * una lista de Avisos conforme la informacion de la solicitud de busqueda
 *
 * @author Gonzalo Astorga
 * @author Alonso Robledo
 * @since mercadotrueque 0.1
 */
public class SolicitudBusqueda {

    private int region;
    private String categoria;
    private int orden;

    /**
     * Constructor de clase
     *
     * @param region region donde se desea buscar
     * @param categoria categoria donde se desea buscar
     * @since mercadotrueque 0.2
     */
    public SolicitudBusqueda(int region, String categoria, int orden) {
        this.region = region;
        this.categoria = categoria;
        this.orden = orden;
    }

    /**
     * Entrega region en la cual se desea buscar
     *
     * @return region en la cual se desea buscar
     * @since mercadotrueque 0.1
     */
    public int getRegion() {
        return region;
    }

    /**
     * Entrega categoria en la cual se desea buscar
     *
     * @return categoria en la cual se desea buscar
     * @since mercadotrueque 0.1
     */
    public String getCategoria() {
        return categoria;
    }

    public int getOrden() {
        return orden;
    }
    
}
