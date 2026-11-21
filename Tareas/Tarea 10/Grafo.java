import java.util.*;

public class Grafo<T extends Comparable<T>> {
    private HashMap<T, List<T>> listaAdyacencia;

    public Grafo() {
        listaAdyacencia = new HashMap<>();
    }

    public void agregarVertice(T vertice) {
        listaAdyacencia.putIfAbsent(vertice, new ArrayList<>());
    }

    public void agregarArista(T origen, T destino) {
        agregarVertice(origen);
        agregarVertice(destino);

        if (!listaAdyacencia.get(origen).contains(destino)) {
            listaAdyacencia.get(origen).add(destino);
            Collections.sort(listaAdyacencia.get(origen));
        }
        if (!listaAdyacencia.get(destino).contains(origen)) {
            listaAdyacencia.get(destino).add(origen);
            Collections.sort(listaAdyacencia.get(destino));
        }
    }

    public List<T> obtenerVecinos(T vertice) {
        return listaAdyacencia.getOrDefault(vertice, new ArrayList<>());
    }

    public List<T> bfs(T inicio) {
        List<T> visitados = new ArrayList<>();
        Queue<T> cola = new LinkedList<>();

        if (!listaAdyacencia.containsKey(inicio)) {
            return visitados;
        }

        visitados.add(inicio);
        cola.offer(inicio);

        while (!cola.isEmpty()) {
            T actual = cola.poll();

            for (T vecino : obtenerVecinos(actual)) {
                if (!visitados.contains(vecino)) {
                    visitados.add(vecino);
                    cola.offer(vecino);
                }
            }
        }
        return visitados;
    }

    public List<T> dfs(T inicio) {
        List<T> visitados = new ArrayList<>();
        Deque<T> pila = new ArrayDeque<>();

        if (!listaAdyacencia.containsKey(inicio)) {
            return visitados;
        }

        pila.push(inicio);

        while (!pila.isEmpty()) {
            T actual = pila.pop();

            if (!visitados.contains(actual)) {
                visitados.add(actual);

                List<T> vecinos = new ArrayList<>(obtenerVecinos(actual));
                Collections.reverse(vecinos);

                for (T vecino : vecinos) {
                    if (!visitados.contains(vecino)) {
                        pila.push(vecino);
                    }
                }
            }
        }
        return visitados;
    }

    public void imprimirGrafo() {
        for (T vertice : listaAdyacencia.keySet()) {
            System.out.println(vertice + " -> " + listaAdyacencia.get(vertice));
        }
    }
}