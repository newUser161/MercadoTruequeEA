/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercadotrueque;

/**
 *
 * @author Gonzalo
 */
class BannerPublicitario {
    private String titulo;
    private String link;
    private String nombreImagen;

    public BannerPublicitario(String titulo, String link, String nombreImagen) {
        this.titulo = titulo;
        this.link = link;
        this.nombreImagen = nombreImagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getLink() {
        return link;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }
    
}
