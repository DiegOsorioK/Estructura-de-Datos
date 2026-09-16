public class Nodo<T> {

    private T dato;
    private Nodo<T> siguiente;

    // Constructor 1: Recibe 1 parámetro (dato)
    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    // Constructor 2: Recibe 2 parámetros (dato y siguiente) - ¡AGREGAR ESTE!
    public Nodo(T dato, Nodo<T> siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    public void setSiguienteNodo(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "[" + dato + "]";
    }
}