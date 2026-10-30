import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack; // Pila

public class SolucionLaberinto {

    static class Posicion {
        int fila;
        int col;

        public Posicion(int fila, int col) {
            this.fila = fila;
            this.col = col;
        }

        @Override
        public String toString() {
            return "(" + fila + ", " + col + ")";
        }
    }

    // Direcciones de mov
    private static final int[] DIR_FILA = { -1, 1, 0, 0 };
    private static final int[] DIR_COL = { 0, 0, -1, 1 };

    public static void main(String[] args) {
        String archivoEntrada = "C:\\Users\\osolo\\OneDrive\\Documentos\\Semestre 3\\Estructuras de Datos\\Tarea Opcional, Pilas y Backtraking\\entrada.lab";
        char[][] tablero = cargarLaberinto(archivoEntrada);

        if (tablero == null) {
            System.err.println("No se pudo cargar el archivo " + archivoEntrada);
            return;
        }

        System.out.println("\nLaberinto Original\n");
        imprimirTablero(tablero);

        // Localiza inicio y salida
        Posicion inicio = null;
        Posicion fin = null;

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == 'S' || tablero[i][j] == 's') {
                    inicio = new Posicion(i, j);
                } else if (tablero[i][j] == 'E' || tablero[i][j] == 'e') {
                    fin = new Posicion(i, j);
                }
            }
        }

        if (inicio == null || fin == null) {
            System.err.println("No se encontró la casilla de inicio o de salida en el laberinto");
            return;
        }

        System.out.println("\nBuscando ruta desde " + inicio + " hasta " + fin);
        boolean resuelto = resolverLaberinto(tablero, inicio, fin);

        if (resuelto) {
            System.out.println("\nLaberinto Resuelto\n");
            imprimirTablero(tablero);
        } else {
            System.out.println("\nNo existe camino posible entre la entrada y la salida.");
        }
    }

    public static boolean resolverLaberinto(char[][] tablero, Posicion inicio, Posicion fin) {
        int filas = tablero.length;
        int cols = tablero[0].length;

        Stack<Posicion> pila = new Stack<>();

        // Apilar posición inicial
        pila.push(inicio);

        while (!pila.isEmpty()) {
            Posicion actual = pila.peek();

            // Si llega a la salida se resuelve el laberinto
            if (actual.fila == fin.fila && actual.col == fin.col) {
                return true;
            }

            boolean movido = false;

            // Intenta avanzar hacia uno de los 4 vecinos válidos
            for (int i = 0; i < 4; i++) {
                int nuevaFila = actual.fila + DIR_FILA[i];
                int nuevaCol = actual.col + DIR_COL[i];

                if (esValido(tablero, nuevaFila, nuevaCol, filas, cols)) {
                    // Si encuentra la salida
                    if (tablero[nuevaFila][nuevaCol] == 'E' || tablero[nuevaFila][nuevaCol] == 'e') {
                        pila.push(new Posicion(nuevaFila, nuevaCol));
                        return true;
                    }

                    // Marca las casillas visitadas como * y apila
                    tablero[nuevaFila][nuevaCol] = '*';
                    pila.push(new Posicion(nuevaFila, nuevaCol));
                    movido = true;
                    break;
                }
            }

            // Backtracking
            if (!movido) {
                Posicion pasoInvalido = pila.pop();
                // Si la casilla no es la entrada se marca como sin salida x
                if (tablero[pasoInvalido.fila][pasoInvalido.col] != 'S') {
                    tablero[pasoInvalido.fila][pasoInvalido.col] = 'x';
                }
            }
        }

        return false;
    }

    private static boolean esValido(char[][] tablero, int f, int c, int maxFilas, int maxCols) {
        // Verificar límites de la matriz
        if (f < 0 || f >= maxFilas || c < 0 || c >= maxCols) {
            return false;
        }
        // Permite avanzar solo a las celdas libres 0 o la salida E
        char celda = tablero[f][c];
        return celda == '0' || celda == 'E' || celda == 'e';
    }

    public static char[][] cargarLaberinto(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String lFila = br.readLine();
            String lCol = br.readLine();

            if (lFila == null || lCol == null)
                return null;

            int filas = Integer.parseInt(lFila.trim());
            int cols = Integer.parseInt(lCol.trim());

            char[][] tablero = new char[filas][cols];

            for (int i = 0; i < filas; i++) {
                String linea = br.readLine();
                if (linea != null) {
                    String[] valores = linea.trim().split(",");
                    for (int j = 0; j < cols && j < valores.length; j++) {
                        tablero[i][j] = valores[j].trim().charAt(0);
                    }
                }
            }
            return tablero;
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al procesar el archivo: " + e.getMessage());
            return null;
        }
    }

    public static void imprimirTablero(char[][] tablero) {
        for (char[] fila : tablero) {
            for (char c : fila) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}