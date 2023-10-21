import java.util.ArrayList;
import java.util.List;

public class Vertice {
    int valor;
    List<Aresta> arestas;

    public Vertice(int valor) {
        this.valor = valor;
        this.arestas = new ArrayList<>();
    }

    public void adicionarAresta(Aresta aresta) {
        arestas.add(aresta);
    }
}
