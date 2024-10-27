import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContextoDeOrdenacao contexto = new ContextoDeOrdenacao();
        
        System.out.println("Digite os números separados por espaço:");
        String[] entrada = scanner.nextLine().split(" ");
        List<Integer> numeros = new ArrayList<>();
        for (String num : entrada) {
            numeros.add(Integer.parseInt(num));
        }

        System.out.println("Escolha o método de ordenação:");
        System.out.println("1 - Bubble Sort");
        System.out.println("2 - Selection Sort");
        System.out.println("3 - Insertion Sort");
        
        int escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                contexto.setEstrategia(new OrdenacaoBubbleSort());
                break;
            case 2:
                contexto.setEstrategia(new OrdenacaoSelectionSort());
                break;
            case 3:
                contexto.setEstrategia(new OrdenacaoInsertionSort());
                break;
            default:
                System.out.println("Opção inválida.");
                scanner.close();
                return;
        }

        contexto.executarOrdenacao(numeros);
        System.out.println("Lista ordenada: " + numeros);

        scanner.close();
    }
}
