package mercadotrueque;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.text.MaskFormatter;
import java.io.*;


/**
 * Esta clase permite manejar archivos en formato JSON para lectura y escritura
 * @since mercadotrueque 0.2
 * @author Alonso
 */


abstract class HandlerJson  {
    private static JSONObject jMasterObject;
    private static String masterPath;
    public static JSONArray init(String path)
    {
        try (FileReader lector = new FileReader(path)){
            masterPath = path;
            // inicializa un objeto generico con el JSON string que devuelve el parser con la ruta del argumento
            Object obj = new JSONParser().parse(lector);

            // casting a JSONObject del objeto anterior
             jMasterObject = (JSONObject) obj;

            // obtenemos el array de usuarios y es asignado a un JSON array
            JSONArray jArrayUsuario = (JSONArray) jMasterObject.get("usuario");

            return  jArrayUsuario;

        } catch (ParseException | IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        return null;
    }
    /**
    *   Esta clase codifica un objeto de formato propietario a formato JSON
     * @author Alonso Robledo A.
     * @param generic recibe un objeto generico que puede contener los datos para un aviso, usuario o comentario
     * @since mercadotrueque 0.2
     *
    * */
    public static JSONObject encode (Object generic) throws IllegalStateException {
        JSONObject nuevoJSON = new JSONObject();
        if (generic instanceof Aviso) {
            nuevoJSON.put("titulo", ((Aviso) generic).getTitulo());
            nuevoJSON.put("descripcion", ((Aviso) generic).getDescripcion());
            nuevoJSON.put("precio", ((Aviso) generic).getPrecio());
            nuevoJSON.put("alonsoCoin", ((Aviso) generic).getAlonsoCoin());
            nuevoJSON.put("categoria", ((Aviso) generic).getCategoria());
            nuevoJSON.put("region", ((Aviso) generic).getRegion());
            nuevoJSON.put("idAviso", ((Aviso) generic).getIdAviso());
            nuevoJSON.put("idPublicador", ((Aviso) generic).getIdPublicador());
            nuevoJSON.put("comentario", ((Aviso) generic).getComentarios());
        } else if (generic instanceof Comentario) {
            nuevoJSON.put("cDescripcion", ((Comentario) generic).getComentarioDescripcion());
            nuevoJSON.put("cUsuario", ((Comentario) generic).getNombreUsuarioComentante());
            nuevoJSON.put("puntuacion", ((Comentario) generic).getPuntuacion());
        } else if (generic instanceof Usuario) {
            nuevoJSON.put("nombre", ((Usuario) generic).getNickname());
            nuevoJSON.put("correo", ((Usuario) generic).getCorreo());
            nuevoJSON.put("clave", ((Usuario) generic).getClave());
            nuevoJSON.put("aviso", ((Usuario) generic).getAvisos());
        } else {
            return null;//atajar excepcion
        }
        return nuevoJSON;
    }
    /**
     *   Esta clase permite escribir un objeto json a la estructura que contiene los datos propios de la aplicacion
     * @param generic es un objeto cualquiera que puede ser Aviso, Comentario o Usuario
     * @param jObject Es el objeto de referencia al cual pertenece el objeto generic
     * @param masterArray es el objeto JSON principal en el cual estan todos los datos
     * @author Alonso Robledo A.
     * @since mercadotrueque 0.2
     *
     * */
    public static void push (JSONObject jObject, Object generic, JSONArray masterArray) throws IOException {

        if (jObject.get("correo") != null){
            JSONArray avisosVacios = new JSONArray();
            jObject.put("aviso",avisosVacios);
            masterArray.add(jObject);
        }

        else if (jObject.get("precio") != null) {
            for (Object o : masterArray) {
                if (o instanceof JSONObject && generic instanceof Usuario) {
                    if (((JSONObject) o).get("correo").equals(((Usuario) generic).getCorreo())) {
                        JSONArray temp = (JSONArray) ((JSONObject) o).get("aviso");
                        JSONArray comentariosVacios = new JSONArray();
                        jObject.put("comentario",comentariosVacios);
                        temp.add(jObject);
                    }
                }
            }
        } else if (jObject.get("puntuacion") != null) {
            for (Object o : masterArray) {
                if (o instanceof JSONObject && generic instanceof Aviso) {
                    if (((JSONObject) o).get("idAviso").equals(((Aviso) generic).getIdAviso())) {
                        JSONArray tempA = (JSONArray) ((JSONObject) o).get("aviso");
                        for (Object o1 : tempA) {
                            if (((JSONObject) o1).get("idAviso").equals(((Aviso) generic).getIdAviso())) {
                                JSONArray tempC = (JSONArray) ((JSONObject) o1).get("comentario");
                                tempC.add(jObject);
                            }
                        }

                    }
                }
            }
        }

        PrintWriter prw= new PrintWriter (masterPath);
        prw.println(jMasterObject.toJSONString());
        prw.close();

    }
}
