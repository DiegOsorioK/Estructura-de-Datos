public class Main {
    public static void main(String[] args) {
        Grafo<String> grafo = new Grafo<>();

        grafo.agregarArista("A", "B");
        grafo.agregarArista("A", "C");
        grafo.agregarArista("B", "D");
        grafo.agregarArista("B", "E");
        grafo.agregarArista("C", "F");
        grafo.agregarArista("C", "G");
        grafo.agregarArista("D", "H");
        grafo.agregarArista("E", "H");
        grafo.agregarArista("E", "I");
        grafo.agregarArista("F", "I");
        grafo.agregarArista("F", "J");
        grafo.agregarArista("G", "J");
        grafo.agregarArista("H", "I");
        grafo.agregarArista("I", "J");

        System.out.println("Recorrido BFS desde A:");
        System.out.println(grafo.bfs("A"));

        System.out.println("\nRecorrido DFS desde A:");
        System.out.println(grafo.dfs("A"));
    }
}