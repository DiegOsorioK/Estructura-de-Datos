import java.io.FileReader; // Abre el archivo
import java.io.BufferedReader; // Lee el archivo línea por línea
import java.io.IOException; // Evita que el programa colapse en caso de un error
import java.util.Scanner; // Permite pedir datos a traves de la consola

public class Tarea1 {

    public static void main(String[] args) {

        String rutaArchivo = "C:/Users/osolo/OneDrive/Documentos/Semestre 3/Estructuras de Datos/T1/datos_redes_sociales (1).csv"; // Ruta
        Scanner scanner = new Scanner(System.in);

        // 1. Diferencia de seguidores en Twitter entre enero y junio
        int twitterSeguidoresEnero = 0;
        int twitterSeguidoresJunio = 0;

        // 2. Calcular diferencia de seguidores en YouTubes
        int youtubeVisualizacionesMes1 = 0;
        int youtubeVisualizacionesMes2 = 0;

        // 3. Calcular promedio de crecimiento de Facebook y Twitter
        double sumaCrecimientoFacebook = 0;
        double sumaCrecimientoTwitter = 0;

        // 4. Acumuladores de me gusta
        double sumaMeGustaFacebook = 0;
        double sumaMeGustaTwitter = 0;
        double sumaMeGustaYouTube = 0;

        try { // Se utilizó "try" ya que las insttrucciones podrían generar un error

            FileReader fr = new FileReader(rutaArchivo); // Abre el archivo
            BufferedReader br = new BufferedReader(fr); // Lee el archivo
            System.out.println("\n El archivo se leyó correctamente... \n");
            String linea;
            br.readLine(); // Se salta la primera fila del CSV

            // 2.
            System.out.println("Comparación de Visualizaciones de YouTube");
            System.out.println("Opciones: Enero (3), Febrero (4), Marzo (5), Abril (6), Mayo (7), Junio (9)\n");
            System.out.print("Ingresa el número de columna del primer mes: ");
            int columnaMes1 = scanner.nextInt();

            System.out.print("Ingresa el número de columna del segundo mes: ");
            int columnaMes2 = scanner.nextInt();
            System.out.println();

            while ((linea = br.readLine()) != null) { // Mientras haya líneas por leer, las guardará en la variable
                                                      // "linea" y se ejecuta el código del bucle

                String[] datos = linea.split(","); // Se crea un arreglo de nombre "datos", y ya que la variable "linea"
                                                   // contiene el renglón, se utiliza .split(""), que busca todas las
                                                   // comas y corta esa sección

                String redSocial = datos[0].trim(); // Se accede a la posición 0 y .strim elimina los espacios
                String concepto = datos[1].trim(); // Samee

                // 1.
                // Se compara el texto de la variable "redSocial" con la palabra "TWITTER", en
                // este caso, ".equalsIgnoreCase()" es un método que compra dos textos
                if (redSocial.equalsIgnoreCase("TWITTER") && concepto.equalsIgnoreCase("SEGUIDORES (FOLLOWERS)")) {
                    twitterSeguidoresEnero = Integer.parseInt(datos[3].trim());
                    twitterSeguidoresJunio = Integer.parseInt(datos[9].trim()); // Se crea una variable para guardar los
                                                                                // seguidores, se usa Integer.parseInt()
                                                                                // para convertir el texto a número y se
                                                                                // accede a la posición 9 del arreglo y
                                                                                // ".trim()" elimina los espacios
                }

                // 2.
                // Se compara el texto guardado en la variable "redSocial", .equalsIgnoreCse()
                // permite comparar las cadenas
                if (redSocial.equalsIgnoreCase("YOUTUBE") && concepto.equalsIgnoreCase("VISUALIZACIONES")) {
                    youtubeVisualizacionesMes1 = Integer.parseInt(datos[columnaMes1].trim()); // Se crea una variable
                                                                                              // para almacenar las
                                                                                              // vistas,"Integer.parseInt()"
                                                                                              // convierte la cadena a
                                                                                              // números
                    youtubeVisualizacionesMes2 = Integer.parseInt(datos[columnaMes2].trim()); // Same
                }

                // 3.
                // Una condición que compara el texto de la variable "redSocial" con el texto
                // "FACEBOOK", ".equalsIgnoreCse()" ayuda a que no importa si son may. o min.
                if (redSocial.equalsIgnoreCase("FACEBOOK") && concepto.toUpperCase().contains("CRECIMIENTO")) {
                    sumaCrecimientoFacebook = Double.parseDouble(datos[3].trim().replace("%", ""))
                            + Double.parseDouble(datos[4].trim().replace("%", ""))
                            + Double.parseDouble(datos[5].trim().replace("%", ""))
                            + Double.parseDouble(datos[6].trim().replace("%", ""))
                            + Double.parseDouble(datos[7].trim().replace("%", ""))
                            + Double.parseDouble(datos[9].trim().replace("%", ""));
                    // Se ocupa la variable de tipo double para ir sumando el crecimiento mes con
                    // mes, se utiliza "Double,parseDouble()" porque los porcentajes llevan
                    // decimales, se accede a la columna del arreglo, se eliminan los espacios con
                    // ",trim()" y ".replace("%", "")" toma la cadena y transforma el porcentaje
                }

                // Same
                if (redSocial.equalsIgnoreCase("TWITTER") && concepto.toUpperCase().contains("CRECIMIENTO")) {
                    sumaCrecimientoTwitter = Double.parseDouble(datos[3].trim().replace("%", ""))
                            + Double.parseDouble(datos[4].trim().replace("%", ""))
                            + Double.parseDouble(datos[5].trim().replace("%", ""))
                            + Double.parseDouble(datos[6].trim().replace("%", ""))
                            + Double.parseDouble(datos[7].trim().replace("%", ""))
                            + Double.parseDouble(datos[9].trim().replace("%", ""));
                }

                // 4.
                //
                if (redSocial.equalsIgnoreCase("FACEBOOK") && concepto.equalsIgnoreCase("ME GUSTA")) {
                    sumaMeGustaFacebook = Integer.parseInt(datos[3].trim()) + Integer.parseInt(datos[4].trim())
                            + Integer.parseInt(datos[5].trim()) + Integer.parseInt(datos[6].trim())
                            + Integer.parseInt(datos[7].trim()) + Integer.parseInt(datos[9].trim());
                }

                if (redSocial.equalsIgnoreCase("TWITTER") && concepto.equalsIgnoreCase("ME GUSTA")) {
                    sumaMeGustaTwitter = Integer.parseInt(datos[3].trim()) + Integer.parseInt(datos[4].trim())
                            + Integer.parseInt(datos[5].trim()) + Integer.parseInt(datos[6].trim())
                            + Integer.parseInt(datos[7].trim()) + Integer.parseInt(datos[9].trim());
                }

                if (redSocial.equalsIgnoreCase("YOUTUBE") && concepto.equalsIgnoreCase("ME GUSTA")) {
                    sumaMeGustaYouTube = Integer.parseInt(datos[3].trim()) + Integer.parseInt(datos[4].trim())
                            + Integer.parseInt(datos[5].trim()) + Integer.parseInt(datos[6].trim())
                            + Integer.parseInt(datos[7].trim()) + Integer.parseInt(datos[9].trim());
                }
            }

            br.close(); // Finaliza la lectura

        } catch (IOException e) { // Si ocurre algún error dentro de "try", se detiene la ejecución y se salta a
                                  // "catch"
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        // 1. Resultado de la diferencia de seguidores en Twitter
        int diferenciaSeguidoresTwitter = twitterSeguidoresJunio - twitterSeguidoresEnero; // Se calcula la diferencia
        System.out.println(
                "1. La diferencia de seguidores en Twitter entre enero y junio es: " + diferenciaSeguidoresTwitter
                        + "\n");

        // 2. Resultado de la comparación de visualizaciones de YouTube
        int diferenciaVisualizacionesYouTube = youtubeVisualizacionesMes2 - youtubeVisualizacionesMes1;
        System.out.println("2. La diferencia de visualizaciones en YouTube entre los dos meses seleccionados es de: "
                + diferenciaVisualizacionesYouTube + "\n");

        // 3. Resultado del crecimiento de seguidores en Facebook y Twitter
        double promedioCrecimientoTotal = (sumaCrecimientoFacebook + sumaCrecimientoTwitter) / 12.0;
        System.out.println("3. El promedio de crecimiento de Twitter y Facebook entre los meses de enero a junio es: "
                + promedioCrecimientoTotal + "\n");

        // 4. Promedio general de "Me gusta" en las 3 redes sociales (Enero a Junio)
        double promedioMeGustaFacebook = sumaMeGustaFacebook / 6.0;
        double promedioMeGustaTwitter = sumaMeGustaTwitter / 6.0;
        double promedioMeGustaYouTube = sumaMeGustaYouTube / 6.0;

        System.out.println("4. Promedio mensual de me gusta de cada red social es:");
        System.out.println(" Facebook: " + promedioMeGustaFacebook);
        System.out.println(" Twitter: " + promedioMeGustaTwitter);
        System.out.println(" YouTube: " + promedioMeGustaYouTube + "\n");

        scanner.close();
    }
}