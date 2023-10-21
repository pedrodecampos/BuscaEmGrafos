import java.io.FileReader;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Grafo grafo = new Grafo();

        FileReader arquivo = new FileReader("graph-test-100.txt");
        Scanner scanner = new Scanner(arquivo);

        scanner.nextLine(); // Pula a primeira linha do arquivo

        while (scanner.hasNextLine()) {
            String[] linha = scanner.nextLine().split("\\s+");

            grafo.adicionarAresta(Integer.parseInt(linha[1]), Integer.parseInt(linha[2]));
        }

        scanner.close();
        scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Digite o valor a ser buscado: ");
            int valorBusca = Integer.parseInt(scanner.nextLine());
            grafo.buscaEmProfundidade(valorBusca);
        }
    }
}
