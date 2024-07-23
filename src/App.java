import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Cofrinho cofrinho = new Cofrinho();

        int escolha = 0;

        do {
            try {

                Menu.clearScreen();

                Menu.menuPrincipal();
                escolha = Integer.parseInt(sc.nextLine());

                switch (escolha) {
                    case 1:
                        cofrinho.adicionar(sc);
                        break;
                    case 2:
                        cofrinho.remover(sc);
                        break;

                    case 3:
                        cofrinho.listagemMoedas(sc);
                        break;

                    case 4:
                        cofrinho.totalConvertido(sc);
                        break;
                    case 5:
                        System.out.println("Saindo do sistema...");
                        break;

                    default:
                        break;
                }

            } catch (NumberFormatException e) {
                Menu.clearScreen();
                System.out.println("Entrada inválida. Tente novamente.");
                Menu.pressioneParaSair(sc);
            } catch (Exception e) {
                Menu.clearScreen();
                System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
                Menu.pressioneParaSair(sc);

            }

        } while (escolha != 5);
        sc.close();
    }
}
