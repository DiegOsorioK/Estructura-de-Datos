import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GameOfLife {

    private int filas;
    private int columnas;
    private Array2DADT<Integer> tablero;

    // Constructor
    public GameOfLife(int filas, int columnas, String rutaCSV) {
        this.filas = Math.max(10, filas);
        this.columnas = Math.max(10, columnas);

        this.tablero = new Array2DADT<>(Integer.class, this.filas, this.columnas);
        this.tablero.rellenar(0);

        cargarDesdeCSV(rutaCSV);
    }

    private void cargarDesdeCSV(String ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            int r = 0;
            while ((linea = br.readLine()) != null && r < filas) {
                String[] valores = linea.split(",");
                for (int c = 0; c < valores.length && c < columnas; c++) {
                    int val = Integer.parseInt(valores[c].trim());
                    tablero.insertarElemento(r, c, val);
                }
                r++;
            }
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo CSV: " + e.getMessage());
        }
    }

    public void mostrarTablero() {
        for (int r = 0; r < filas; r++) {
            for (int c = 0; c < columnas; c++) {
                System.out.print(tablero.obtenerElemento(r, c) == 1 ? "■ " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private int contarVecinosVivos(int fila, int columna) {
        int vecinosVivos = 0;

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (dr == 0 && dc == 0)
                    continue; // Salta la celda central

                int nr = fila + dr;
                int nc = columna + dc;

                if (nr >= 0 && nr < filas && nc >= 0 && nc < columnas) {
                    if (tablero.obtenerElemento(nr, nc) == 1) {
                        vecinosVivos++;
                    }
                }
            }
        }
        return vecinosVivos;
    }

    public void siguienteGeneracion() {
        Array2DADT<Integer> nuevoTablero = new Array2DADT<>(Integer.class, filas, columnas);
        nuevoTablero.rellenar(0);

        for (int r = 0; r < filas; r++) {
            for (int c = 0; c < columnas; c++) {
                int estadoActual = tablero.obtenerElemento(r, c);
                int vecinos = contarVecinosVivos(r, c);

                if (estadoActual == 1) {
                    if (vecinos == 2 || vecinos == 3) {
                        nuevoTablero.insertarElemento(r, c, 1);
                    }
                } else {
                    if (vecinos == 3) {
                        nuevoTablero.insertarElemento(r, c, 1);
                    }
                }
            }
        }

        this.tablero = nuevoTablero;
    }
}