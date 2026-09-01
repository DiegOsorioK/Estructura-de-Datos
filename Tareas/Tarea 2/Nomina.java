import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Nomina {

    private String rutaArchivo;
    private ArrayADT<Empleado> empleados;

    // Ruta del archivo
    public Nomina(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
        this.empleados = new ArrayADT<>(14);
    }

    public void leerArchivo() {
        try (BufferedReader br = new BufferedReader(new FileReader(this.rutaArchivo))) {
            String linea = br.readLine(); // Omite la primera línea
            int contador = 0;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(","); // Separa por comas

                int numeroTrabajador = Integer.parseInt(datos[0].trim()); // Convierte variables numericas
                String nombres = datos[1].trim();
                String paterno = datos[2].trim();
                String materno = datos[3].trim();
                int horasExtra = Integer.parseInt(datos[4].trim());
                double sueldoBase = Double.parseDouble(datos[5].trim());
                int añoIngreso = Integer.parseInt(datos[6].trim());

                Empleado emp = new Empleado(numeroTrabajador, nombres, paterno, materno, horasExtra, sueldoBase,
                        añoIngreso);

                this.empleados.insertarElemento(contador, emp); // Guarda el ArrayADT
                contador++;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Trabajador con mayor antigüedad
    public void obtenerMayorAntiguedad() {
        if (empleados.longitud() == 0)
            return;

        Empleado mayor = empleados.obtenerElemento(0);
        for (int i = 1; i < empleados.longitud(); i++) {
            Empleado actual = empleados.obtenerElemento(i);
            if (actual.getAñoIngreso() < mayor.getAñoIngreso()) {
                mayor = actual;
            }
        }
        System.out.println("Trabajador con mayor antigüedad: " + mayor);
    }

    // Trabajador con menor antigüedad
    public void obtenerMenorAntiguedad() {
        if (empleados.longitud() == 0)
            return;

        Empleado menor = empleados.obtenerElemento(0);
        for (int i = 1; i < empleados.longitud(); i++) {
            Empleado actual = empleados.obtenerElemento(i);
            if (actual.getAñoIngreso() > menor.getAñoIngreso()) {
                menor = actual;
            }
        }
        System.out.println("Trabajador con menor antigüedad: " + menor);
    }

    // Despliega a todos los empleados con su sueldo
    public void calcularSueldosyDesplegar() {
        for (int i = 0; i < empleados.longitud(); i++) {
            System.out.println(empleados.obtenerElemento(i));
        }
    }
}