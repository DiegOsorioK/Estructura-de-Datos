import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PalabrasDiferentes {

    public static void contarPalabras(String rutaArchivo) {

        try {
            File archivo = new File(rutaArchivo);
            Scanner scanner = new Scanner(archivo);

            Set<String> palabras = new HashSet<>();

            while (scanner.hasNextLine()) {
                String texto = scanner.nextLine();
                texto = texto.replaceAll("[^a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]", "");

                for (String palabra : texto.split(" ")) {
                    if (!palabra.isEmpty()) {
                        palabras.add(palabra.toLowerCase());
                    }
                }
            }

            scanner.close();
            System.out.println("Palabras diferentes: " + palabras.size() + "\n");

        } catch (FileNotFoundException e) {
            System.out.println("Error: No se encontró el archivo.");
        }
    }
}