import java.util.Objects;

public class Perro {
    private String nombre;
    private String raza;
    private int edad;

    public Perro(String nombre, String raza, int edad) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Perro perro = (Perro) o;
        return edad == perro.edad &&
                Objects.equals(nombre, perro.nombre) &&
                Objects.equals(raza, perro.raza);
    }

    @Override
    public String toString() {
        return "Perro{" + "nombre='" + nombre + '\'' + ", raza='" + raza + '\'' + ", edad=" + edad + '}';
    }
}