import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Grafo {
    private Map<Integer, Vertice> vertices;

    public Grafo() {
        this.vertices = new HashMap<>();
    }

    private void criaVertice(int valor) {
        if (!vertices.containsKey(valor)) {
            Vertice novoVertice = new Vertice(valor);
            vertices.put(valor, novoVertice);
        }
    }

    public void adicionarAresta(int valorOrigem, int valorDestino) {
        this.criaVertice(valorOrigem);
        this.criaVertice(valorDestino);

        Vertice origem = vertices.get(valorOrigem);
        Vertice destino = vertices.get(valorDestino);

        Aresta aresta = new Aresta(origem, destino);
        origem.adicionarAresta(aresta);
    }

    public void buscaEmProfundidade(int valorBusca) {
        Set<Vertice> visitados = new HashSet<>();
        Vertice inicio = vertices.values().iterator().next(); // Escolhe um vértice qualquer como início

        if (inicio != null) {
            executarBuscaEmProfundidade(inicio, valorBusca, visitados);
        } else {
            System.out.println("Grafo vazio. Nenhum vértice encontrado.");
        }
    }

    private boolean executarBuscaEmProfundidade(Vertice atual, int valorBusca, Set<Vertice> visitados) {
        System.out.println("Visitando vértice: " + atual.valor);
        visitados.add(atual);

        if (atual.valor == valorBusca) {
            System.out.println("Vértice encontrado: " + atual.valor);
            return true;
        }

        for (Aresta aresta : atual.arestas) {
            Vertice vizinho = aresta.destino;
            if (!visitados.contains(vizinho) && executarBuscaEmProfundidade(vizinho, valorBusca, visitados)) {
                return true;
            }
        }

        return false;
    }
}
