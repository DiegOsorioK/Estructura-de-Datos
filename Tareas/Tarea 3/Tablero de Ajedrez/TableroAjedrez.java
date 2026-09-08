import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TableroAjedrez {
    private ArrayADT2D<String> tablero;

    public TableroAjedrez(String rutaCSV) {
        this.tablero = new ArrayADT2D<>(8, 8);
        cargarDesdeCSV(rutaCSV);
    }

    private void cargarDesdeCSV(String rutaCSV) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaCSV))) {
            String linea;
            int fila = 0;

            while ((linea = br.readLine()) != null && fila < 8) {
                String[] valores = linea.split(",");
                for (int col = 0; col < valores.length && col < 8; col++) {
                    tablero.insertarElemento(fila, col, valores[col]);
                }
                fila++;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        }
    }

    public void mostrarTablero() {
        System.out.println("  ---------------------------------");
        for (int i = 0; i < tablero.getFilas(); i++) {
            System.out.print((8 - i) + " | ");
            for (int j = 0; j < tablero.getColumnas(); j++) {
                String pieza = tablero.obtenerElemento(i, j);
                System.out.print((pieza != null ? pieza : " ") + " | ");
            }
            System.out.println();
            System.out.println("  ---------------------------------");
        }
        System.out.println("    a   b   c   d   e   f   g   h");
    }
}