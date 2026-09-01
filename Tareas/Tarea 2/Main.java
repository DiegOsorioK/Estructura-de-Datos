public class Main {

    public static void main(String[] args) {

        Nomina nomina = new Nomina(
                "C:\\Users\\osolo\\OneDrive\\Documentos\\Semestre 3\\Estructuras de Datos\\T2\\junio.dat");

        System.out.println("Cargando Archivo...");
        nomina.leerArchivo();

        System.out.println("\nNomina y Sueldos: ");
        nomina.calcularSueldosyDesplegar();

        System.out.println("\nAntigüedad:");
        nomina.obtenerMayorAntiguedad();
        nomina.obtenerMenorAntiguedad();
    }
}