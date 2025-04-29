import java.util.Scanner;

class ListaLigada {
    public class No {
        public int elemento;
        public No proximo;

        public No(int elemento) {
            this.elemento = elemento;
            this.proximo = null;
        }
    }

    private No inicio;

    public ListaLigada() {
        this.inicio = null;
    }

    public void inserirFim(int elemento) {
        No novoNo = new No(elemento);
        if (this.inicio == null) {
            this.inicio = novoNo;
        } else {
            No noAtual = inicio;
            while (noAtual.proximo != null) {
                noAtual = noAtual.proximo;
            }
            noAtual.proximo = novoNo;
        }
    }

    public void inserir(int elemento) {
        No novoNo = new No(elemento);
        novoNo.proximo = this.inicio; // O novo nó aponta para o início atual
        this.inicio = novoNo;
    }

    public void exibir() {
        if (inicio == null) {
            System.out.println("A lista está vazia.");
            return;
        }

        No atual = inicio;
        while (atual != null) {
            System.out.print(atual.elemento + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    public void remover(int elemento) {
        if (inicio == null) {
            System.out.println("A lista está vazia.");
            return;
        }

        if (inicio.elemento == elemento) {
            inicio = inicio.proximo; // Remover
            return;
        }

        No atual = inicio;
        No anterior = null;

        while (atual != null && atual.elemento != elemento) {
            anterior = atual;
            atual = atual.proximo;
        }

        if (atual == null) {
            System.out.println("Elemento não encontrado.");
            return;
        }

        anterior.proximo = atual.proximo;
        System.out.println("Elemento " + elemento + " removido.");
    }

    public Boolean buscarValor(int valor) {
        No atual = inicio;

        while (atual != null) {
            if (atual.elemento == valor) {
                System.out.println("O valor " + valor + " existe");
                return true;
            }
            atual = atual.proximo;
        }


        System.out.println("Elemento não encontrado");
        return true;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ListaLigada lista = new ListaLigada();
        int opcao = 0;

        while (opcao != 9) {
            System.out.println("=== MENU ===");
            System.out.println("Digite 1 - Inserção no Início");
            System.out.println("Digite 2 - Inserção no Fim");
            System.out.println("Digite 3 - Remover um elemento específico");
            System.out.println("Digite 4 - Buscar um valor");
            System.out.println("Digite 5 - Listar Elementos");
            System.out.println("Digite 9 - Sair");
            System.out.println();
            System.out.println("Digite a opção que deseja");

            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite um valor de entrada");
                    int valor = entrada.nextInt();
                    lista.inserir(valor);
                    break;
                case 2:
                    System.out.println("Digite um valor de entrada");
                    int valorFim = entrada.nextInt();
                    lista.inserirFim(valorFim);
                    break;
                case 3:
                    System.out.println("Digite um valor que deseja remover: ");
                    int removerValor = entrada.nextInt();
                    lista.remover(removerValor);
                case 4:
                    System.out.println("Digite o valor que deseja buscar:");
                    int valorBuscar = entrada.nextInt();
                    lista.buscarValor(valorBuscar);
                    break;
                case 5:
                    System.out.println("Lista de elementos: ");
                    lista.exibir();
                    break;
                case 9:
                    System.out.println("Até mais");
                    return;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        }
    }
}