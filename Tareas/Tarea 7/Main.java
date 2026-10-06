public class Main {
    public static void main(String[] args) {
        ListaLigadaADT<Perro> listaPerros = new ListaLigadaADT<>();

        System.out.println("¿Está vacía?: " + listaPerros.estaVacia());

        Perro p1 = new Perro("Firulais", "Husky", 3);
        Perro p2 = new Perro("Kivy", "Pastor Alemán", 5);
        Perro p3 = new Perro("Max", "Beagle", 2);
        Perro p4 = new Perro("Tom", "Pug", 1);

        listaPerros.agregar(p1);
        listaPerros.agregar(p2);
        listaPerros.agregarAlInicio(p3);

        System.out.print("Lista actual: ");
        listaPerros.transversal();
        System.out.println();

        System.out.println("Posición de Kivy: " + listaPerros.buscar(p2));

        listaPerros.eliminarElPrimero();
        listaPerros.eliminarElFinal();

        System.out.print("Lista tras eliminar el primero y el final: ");
        listaPerros.transversal();
        System.out.println();
    }
}