public class Main {

    public static void main(String[] args) {

        // head con los nodos iniciales.
        Nodo<String> head = new Nodo<>("Al",
                new Nodo<>("B", new Nodo<>("C", new Nodo<>("De", new Nodo<>("Mc", new Nodo<>("Zi"))))));

        Nodo<String> actual;
        Nodo<String> ultimo;

        // Imprime el estado inicial de la lista
        System.out.println("Estado inicial completo de la lista:");
        actual = head;
        while (actual != null) {
            System.out.print(actual + (actual.getSiguiente() != null ? " - " : " - null\n"));
            actual = actual.getSiguiente();
        }
        System.out.println();

        // Imprime el dato del primer nodo
        System.out.println("Dato almacenado en el primer nodo:");
        System.out.println(head.getDato());
        System.out.println();

        // Imprime el estado del último nodo ubicado
        System.out.println("Estado del nodo en la última posición:");
        ultimo = head;
        while (ultimo != null && ultimo.getSiguiente() != null) {
            ultimo = ultimo.getSiguiente();
        }
        System.out.println(ultimo);
        System.out.println();

        // Se insertar "Fe" entre "De" y "Mc" mediante un bucle
        Nodo<String> nodoDe = head;
        while (nodoDe != null && !nodoDe.getDato().equals("De")) {
            nodoDe = nodoDe.getSiguiente();
        }

        if (nodoDe != null) {
            Nodo<String> nodoFe = new Nodo<>("Fe", nodoDe.getSiguiente()); // "Fe" apunta a "Mc"
            nodoDe.setSiguiente(nodoFe); // "De" apunta a "Fe"
        }

        // Imprime el estado de la nueva lista
        System.out.println("Lista tras insertar 'Fe' entre 'De' y 'Mc':");
        actual = head;
        while (actual != null) {
            System.out.print(actual + (actual.getSiguiente() != null ? " - " : " - null\n"));
            actual = actual.getSiguiente();
        }
        System.out.println();

        // Se insertar un nuevo nodo "Zz" hastael final de la lista
        Nodo<String> nodoZz = new Nodo<>("Zz");
        ultimo = head;
        while (ultimo != null && ultimo.getSiguiente() != null) {
            ultimo = ultimo.getSiguiente();
        }
        ultimo.setSiguiente(nodoZz);

        // Se imprime el nuevo estado de la lista
        System.out.println("Lista tras insertar 'Zz' al final:");
        actual = head;
        while (actual != null) {
            System.out.print(actual + (actual.getSiguiente() != null ? " - " : " - null\n"));
            actual = actual.getSiguiente();
        }
        System.out.println();

        // Se insertar un nuevo nodo "Aa" al inicio de la lista
        Nodo<String> nodoAa = new Nodo<>("Aa", head);
        head = nodoAa; // "Aa" pasa a ser head

        // Se imprime el estado final de la lista
        System.out.println("Estado final de la lista:");
        actual = head;
        while (actual != null) {
            System.out.print(actual + (actual.getSiguiente() != null ? " - " : " - null\n"));
            actual = actual.getSiguiente();
        }
        System.out.println();
    }
}