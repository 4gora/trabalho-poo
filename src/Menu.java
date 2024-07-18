import java.util.Scanner;

public class Menu {

    // https://stackoverflow.com/questions/2979383/java-clear-the-console
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void menuPrincipal() {
        System.out.println("Qual das ações deseja fazer?");
        System.out.println(
                "1 - Adicionar moeda\n" +
                        "2 - Remover moeda\n" +
                        "3 - listar todas as moedas\n" +
                        "4 - calcular total do cofrinho em R$\n" +
                        "5 - sair");
        System.out.print("Resposta: ");
    }

    public static void escolherMoeda() {
        System.out.println("Insira as informações da moeda:");
        System.out.println(
                "Qual a moeda?\n" +
                        "1 - Real\n" +
                        "2 - Dolar\n" +
                        "3 - Euro");
        System.out.print("Resposta: ");

    }

    public static void valorMoeda() {
        System.out.print("Insira o valor da moeda: ");
    }

    public static void pressioneParaSair(Scanner sc) {
        System.out.println();
        System.out.println("Pressione enter para voltar.");
        sc.nextLine();
    }

}
