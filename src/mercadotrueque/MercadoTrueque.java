/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercadotrueque;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Main de programa Mercadotrueque, plataforma de publicacion, compra y truque de articulos de todo tipo a lo largo de todo chile
 * @author Gonzalo Astorga
 * @author Alonso Robledo
 * @since mercadotrueque 0.1
 */
public class MercadoTrueque {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Interfaz app= new Interfaz();
        app.runApp();
        
        //modo master = correo = mercadotrueque@gmail.com | clave = 123   
        
        
    }
    
}
