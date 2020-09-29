/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercadotrueque;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Clase destinada a gestionar el audio, tanto musica como efectos de sonido en
 * formato wav
 *
 * @author Gonzalo Astorga
 * @author Alonso Robledo
 * @since mercadotrueque 0.1
 */
public class Sonido {

    public static final int UNA_VEZ = 0;
    public static final int LOOP = 1;
    private String direccionCompleta = "";
    private static final String DIRECCION_CARPETA = "src/sound/";
    private static final String FORMATO = ".wav";

    public Sonido() {

    }

    /**
     * Reproduce un sonido
     *
     * @param nombreSonido direccion del audio
     * @param modo modo LOOP para musica backgroundo y modo UNA_VEZ para efectos
     * de sonido
     * @since mercadotrueque 0.3
     */
    public void playSonido(String nombreSonido, int modo) {
        //completamos la ruta del archivo de audio
        direccionCompleta = "";
        direccionCompleta += DIRECCION_CARPETA + nombreSonido + FORMATO;
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(direccionCompleta).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            // si se selecciona modo loop
            if (modo == LOOP) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            //gestion de exception
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println("Error al reproducir el sonido.");
        }
    }
}
