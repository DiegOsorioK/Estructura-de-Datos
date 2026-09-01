public class Empleado {

    private int numeroTrabajador;
    private String nombres;
    private String paterno;
    private String materno;
    private int horasExtra;
    private double sueldoBase;
    private int añoIngreso;

    public Empleado(int numeroTrabajador, String nombres, String paterno, String materno, int horasExtra,
            double sueldoBase, int añoIngreso) {

        this.numeroTrabajador = numeroTrabajador;
        this.nombres = nombres;
        this.paterno = paterno;
        this.materno = materno;
        this.horasExtra = horasExtra;
        this.sueldoBase = sueldoBase;
        this.añoIngreso = añoIngreso;
    }

    // Calcular la antigüedad
    public int calcularAntiguedad() {
        return 2026 - this.añoIngreso;
    }

    // Calcular Sueldo
    public double calcularSueldo() {

        double pagoHorasExtra = this.horasExtra * 276.5;
        double bonoAntiguedad = this.sueldoBase * (calcularAntiguedad() * 0.03);

        return this.sueldoBase + pagoHorasExtra + bonoAntiguedad;
    }

    // Getters
    public int getNumeroTrabajador() {
        return numeroTrabajador;
    }

    public String getNombres() {
        return nombres;
    }

    public String getPaterno() {
        return paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public int getAñoIngreso() {
        return añoIngreso;
    }

    // Formato de salida para desplegar la información completa de cada trabajador
    @Override
    public String toString() {
        return "Número de Trabajador: " + numeroTrabajador +
                " | Nombre: " + nombres + ", Apellido Paterno: " + paterno + " y" + " Apellido Materno: " + materno +
                " | Antigüedad: " + calcularAntiguedad() + " años" +
                " | Sueldo Final: $" + calcularSueldo();
    }
}