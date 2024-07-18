import java.util.Scanner;

public class App {

    private static Cofrinho cofrinho = new Cofrinho();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int escolha;

        do {

            Menu.clearScreen();

            Menu.menuPrincipal();
            escolha = Integer.parseInt(sc.nextLine());

            switch (escolha) {
                case 1:
                    cofrinho.adicionar(sc);

                    break;
                case 2:
                    Menu.escolherMoeda();

                case 3:
                    cofrinho.listagemMoedas();

                case 4:
                    cofrinho.totalConvertido();

                default:
                    break;
            }

        } while (escolha != 5);

        System.out.println("Saindo do sistema...");

        sc.close();
    }
}
