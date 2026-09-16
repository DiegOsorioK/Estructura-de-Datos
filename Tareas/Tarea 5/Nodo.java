public class Nodo<T> {

    private T dato;
    private Nodo<T> siguiente;

    // Recibe el dato y lo almacena en nodo y el sig. nodo se inicializa en null
    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    // Crea e interconecta
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

    // Cambia el puntero siguiente para enlazarse a un nuevo nodo
    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    // Same
    public void setSiguienteNodo(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    // Sobreescribe...
    @Override
    public String toString() {
        return "[" + dato + "]";
    }
}