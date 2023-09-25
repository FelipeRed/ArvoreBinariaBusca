import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Arvore arvore = Arvore.criarArvoreBase();

        int acao = 0;
        while (acao != 4) {
            acao = menu(arvore);
            switch (acao) {
                case 1 -> inserirNovoNumero(arvore);
                case 2 -> buscarNumero(arvore);
                case 3 -> excluirNumero(arvore);
                case 4 -> System.out.println("\n\nEncerrando o programa.");
                default -> System.out.println("Favor digitar uma opção válida do MENU.");
            }
        }
    }

    public static int menu(Arvore arvore) {
        limparTela();
        arvore.print();
        Scanner teclado = new Scanner(System.in);
        System.out.print("""
                ---- MENU ----
                1- Inserir um número na árvore;
                2- Buscar um número na árvore;
                3- Excluir um número da árvore;
                4- Encerrar o programa;
                Insira a ação que deseja realizar:\s""");
        return teclado.nextInt();
    }

    public static void inserirNovoNumero(Arvore arvore) {
        limparTela();
        arvore.print();
        int numero = inputNumeroPara("INSERIR");
        if (numero != 0) {
            arvore.inserirNumero(numero, arvore.getRaiz());
            inserirNovoNumero(arvore);
        }
    }

    public static void buscarNumero(Arvore arvore) {
        int numero = 1;
        String msg = "";
        while (numero != 0) {
            limparTela();
            arvore.print();
            if (!msg.equals("")) {
                System.out.println(msg);
                msg = "";
            }

            numero = inputNumeroPara("BUSCAR");
            if (numero != 0) {
                if (arvore.buscarNumero(numero, arvore.getRaiz())) {
                    msg = "O número " + numero + " que você buscou ESTÁ presente na árvore.";
                }
                else {
                    msg = "O número " + numero + " que você buscou NÃO ESTÁ presente na árvore.";
                }
            }
        }
    }

    public static void excluirNumero(Arvore arvore) {
        int numero = 1;
        String msg = "";
        while (numero != 0) {
            limparTela();
            arvore.print();
            if (!msg.equals("")) {
                System.out.println(msg);
                msg = "";
            }

            numero = inputNumeroPara("EXCLUIR");
            if (numero != 0) {
                if (arvore.buscarNumero(numero, arvore.getRaiz())) {
                    arvore.excluirNumero(numero, arvore.getRaiz(), null);
                }
                else {
                    msg = "O número " + numero + " que você buscou NÃO ESTÁ presente na árvore.";
                }
            }
        }
    }

    public static int inputNumeroPara(String msg) {
        return input("Insira 0 (zero) para voltar ao menu principl.\n" +
                "Digite o número que deseja " + msg + " na árvore: ");
    }

    public static int input(String msg) {
        Scanner teclado = new Scanner(System.in);
        System.out.print(msg);
        return teclado.nextInt();
    }

    public static void limparTela() {
        for (int i=0; i<30; i++) {
            System.out.println();
        }
    }
}
