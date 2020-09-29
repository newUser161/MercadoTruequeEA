/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercadotrueque;

import java.util.ArrayList;

/**
 *
 * @author Gonzalo
 */
public class ClientePublicidad extends Persona{
    private String nombreEmpresa;
    private String correo;
    private ArrayList<BannerPublicitario>coleccionBannerPublicitario;

    private static final int limitePublicidad = 3;
    public ClientePublicidad(String nombreEmpresa, String correo, String nombre, String rut, String direccion, int region) {
        super(nombre, rut, direccion, region);
        this.nombreEmpresa = nombreEmpresa;
        this.correo = correo;
        this.coleccionBannerPublicitario = new <BannerPublicitario>ArrayList();
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getCorreo() {
        return correo;
    }

    public boolean addBanner(BannerPublicitario bannerNuevo) {
        if(coleccionBannerPublicitario.size()<limitePublicidad){
            coleccionBannerPublicitario.add(bannerNuevo);
            return true;
        }
        return false;
    }

    public int getCantidadBanner(){
        return coleccionBannerPublicitario.size();
    }

    public BannerPublicitario getBanner(int numeroBannerRandom) {
        return (BannerPublicitario)coleccionBannerPublicitario.get(numeroBannerRandom);
    }
}
