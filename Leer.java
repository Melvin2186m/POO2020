import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Leer{
    
    public static void main(String[] args) {        
        /*creamos un nuevo archivo con la ruta especificada
         * y pedinos una palabrabusar
         * 
         */
        File archivo = new File("/Users/usuario/Desktop/hola.txt");
        Scanner teclado = new Scanner(System.in);
        System.out.print("Escribe la palabra a buscar en el archivo: ");
        String palabra = teclado.nextLine();
        System.out.println("");
        
        buscarPalabra(archivo, palabra);

    }
    


   public static void buscarPalabra(File archivo, String palabra) {
        try {
            int lineasTotales=0;
            int totalCoincidencias=0; 
            if(archivo!=null) {
                /*en linea primero comparamos si existe el archivo con el metodo 
                 * exist
                 */
                BufferedReader leerArchivo = new BufferedReader(new FileReader(archivo));
                /*con este buffer lo que hacemos es leer el texto en el archivo
                 * ya que la clase buffer reader de la api de java nos permite leer linea por
                 * linea un documento con su readLine().
                 */
                String lineaasignar;//creamos una variable que almacenara la las linea
                while((lineaasignar = leerArchivo.readLine()) != null) {
                    lineasTotales = lineasTotales + 1;
                    /*en esta linea decimos que la lineaasignar es igual ala linea 
                     * de leer archivo en la linea asignada por le metodo readline()
                     * al mismo timepo que desimos que se ejute un ciclo while y este se
                     * ejecute mientras lineaasignar sea diferente a null
                     */
                    String[] palabras = lineaasignar.split(" ");
                    for(int i = 0 ; i < palabras.length ; i++) {
                        if(palabras[i].equalsIgnoreCase(palabra)) {
                            /*en esta linea declaramos un arreglo de tipo string que le 
                             * pondremos palabras y con la ayuda del metodo split perteneciente ala 
                             * clase del api de java.StringTokenizer asignamos cada palabra 
                             * omitiendo los espacios
                             */ 
                            totalCoincidencias ++;
                            System.out.println(lineaasignar);
                            System.out.println("En la linea: " + lineasTotales + " se encontro la palabra a buscar: " + palabra);
                            System.out.println("");
                            /*en esta parte de codigo imprimimos en que linea se encontro y cuantas veces se enconto en esa
                             * linea de codigo
                             * 
                             */
                        }
                    }
                }
            }
            System.out.println("En total se encotro la palabra: " + palabra + ", " + totalCoincidencias + " Veces en el archivo");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
} 





