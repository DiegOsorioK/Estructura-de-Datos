public class Array2DADT<T> {

    private int filas;
    private int columnas;
    private Object[][] datos;

    // Constructor que recibe filas y columnas
    public Array2DADT(Class<T> clase, int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.datos = new Object[filas][columnas];
    }

    public T obtenerElemento(int fila, int columna) {
        if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
            return (T) datos[fila][columna];
        } else {
            System.out.println("Indice fuera de rango");
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void insertarElemento(int fila, int columna, T elemento) {
        if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
            datos[fila][columna] = elemento;
        } else {
            System.out.println("Indice fuera de rango");
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void rellenar(T elemento) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                datos[i][j] = elemento; // Asigna el valor a cada posición
            }
        }
    }

    public void imprimir() {
        System.out.print("[");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(datos[i][j] + ",");
            }
        }
        System.out.println("]");
    }

}