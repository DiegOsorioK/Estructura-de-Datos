public class Main {

    public static void main(String[] args) {

        int filas = 10;
        int columnas = 10;
        int generacionesTotales = 10;
        String rutaCSV = "C:\\Users\\osolo\\OneDrive\\Documentos\\Semestre 3\\Estructuras de Datos\\T3\\Game Of Life\\población.csv";

        GameOfLife juego = new GameOfLife(filas, columnas, rutaCSV);

        System.out.println("\n    Game Of Life     ");
        System.out.println("\n    Generación 0      ");
        juego.mostrarTablero();

        // Generaciones
        for (int g = 1; g <= generacionesTotales; g++) {
            juego.siguienteGeneracion();
            System.out.println("\n   Generación " + g + "    ");
            juego.mostrarTablero();
        }
    }
}