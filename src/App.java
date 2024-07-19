import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Cofrinho cofrinho = new Cofrinho();

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
                    cofrinho.remover(sc);
                    break;

                case 3:
                    cofrinho.listagemMoedas(sc);
                    break;

                case 4:
                    cofrinho.totalConvertido();
                    break;

                default:
                    break;
            }

        } while (escolha != 5);
        Menu.clearScreen();
        System.out.println("Saindo do sistema...");

        sc.close();
    }
}
