/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercadotrueque;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Gonzalo
 */
public class AdminClientePublicidad {

    private ArrayList<ClientePublicidad> clienteColeccion;
    private int totalBanner;
    private static final String extensionPermitida=".png";
    private static final String direccion="src/img/";
    public AdminClientePublicidad() {
        clienteColeccion=new <ClientePublicidad>ArrayList();
        totalBanner=0;
        cargarDatos();
    }

    private void cargarDatos() {
        //a la mala :3
        clienteColeccion.add(new ClientePublicidad("cola-cola","coca@gmail.com","john","5.555.555-5","Av.coca123",5));
        addBannerACliente("cola-cola","toma la nueva coca-zapato","https://www.micoca-cola.cl//",direccion+"cocazapato"+extensionPermitida);
        addBannerACliente("cola-cola","toma la nueva coca-merluza","https://www.micoca-cola.cl//",direccion+"cocamerluza"+extensionPermitida);
        addBannerACliente("cola-cola","toma la nueva coca-piojo","https://www.micoca-cola.cl//",direccion+"cocapiojo"+extensionPermitida);
        
        clienteColeccion.add(new ClientePublicidad("unimarc","unimarc@gmail.com","marcelo","8.555.555-5","Av.uni123",7));
        addBannerACliente("unimarc","nueva oferta1","https://www.unimarc.cl/",direccion+"uni1"+extensionPermitida);
        addBannerACliente("unimarc","nueva oferta2","https://www.unimarc.cl/",direccion+"uni2"+extensionPermitida);
        addBannerACliente("unimarc","nueva oferta3","https://www.unimarc.cl/",direccion+"uni3"+extensionPermitida);
        
        clienteColeccion.add(new ClientePublicidad("pcfactory","pcfactory@gmail.com","pepito","6.555.555-5","Av.pc123",7));
        addBannerACliente("pcfactory","nueva oferta1","https://www.pcfactory.cl/",direccion+"pcssd"+extensionPermitida);
        addBannerACliente("pcfactory","nueva oferta2","https://www.pcfactory.cl/",direccion+"pcps"+extensionPermitida);
        addBannerACliente("pcfactory","nueva oferta3","https://www.pcfactory.cl/",direccion+"pcmonitor"+extensionPermitida);
    }

    private void addBannerACliente(String nombreCliente, String titulo, String link, String nombreImg) {
        BannerPublicitario bannerNuevo= new BannerPublicitario(titulo,link,nombreImg);
        for(int i=0;i<clienteColeccion.size();i++){
            if(clienteColeccion.get(i).getNombreEmpresa().equals(nombreCliente)){
                clienteColeccion.get(i).addBanner(bannerNuevo);
                totalBanner++;
                return;
            }
        }
    }
    public BannerPublicitario getRandomBanner(){
        int  numeroClienteRandom=(int) (Math.random() * clienteColeccion.size() + 0);
        int numeroBannerRandom;
        ClientePublicidad clienteActual= (ClientePublicidad)clienteColeccion.get(numeroClienteRandom);
        numeroBannerRandom=(int) (Math.random() * clienteActual.getCantidadBanner() + 0);
        
        return clienteActual.getBanner(numeroBannerRandom);
    }
}
