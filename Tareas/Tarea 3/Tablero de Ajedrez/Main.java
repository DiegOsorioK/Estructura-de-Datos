public class Main {
    public static void main(String[] args) {
        System.out.println("\n         Tablero de Ajedrez\n");
        TableroAjedrez ajedrez = new TableroAjedrez(
                "C:\\Users\\osolo\\OneDrive\\Documentos\\Semestre 3\\Estructuras de Datos\\T3\\Tablero de Ajedrez\\tablero.csv");
        ajedrez.mostrarTablero();
    }
}