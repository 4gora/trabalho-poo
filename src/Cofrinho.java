import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Dolar;
import entities.Euro;
import entities.Moeda;
import entities.Real;

public class Cofrinho {

    

    private List<Moeda> listaMoedas = new ArrayList<>();

    public void adicionar(Scanner sc) {
        Menu.escolherMoeda();

        int nomeMoeda = Integer.parseInt(sc.nextLine());

        Menu.valorMoeda();
        double valorMoeda = Double.parseDouble(sc.nextLine());

        Moeda moeda;

        switch (nomeMoeda) {
            case 1:
                moeda = new Real(valorMoeda);
                break;
            case 2:
                moeda = new Dolar(valorMoeda);
                break;
            case 3:
                moeda = new Euro(valorMoeda);
                break;

            default:
                System.out.println("Tipo de moeda inválido.");
                return;
        }
        
        listaMoedas.add(moeda);
        System.out.println("Moeda adicionada.");
        sc.nextLine();
        Menu.clearScreen();


    }

    public void remover(Moeda moeda) {
        listaMoedas.remove(moeda);

        sc.nextLine();
        Menu.clearScreen();
    }

    public void listagemMoedas() {
        for (Moeda m : listaMoedas) {
            System.out.println(m.info());
        }

    }

    public double totalConvertido() {
        double aux = 0.0;

        for (Moeda m : listaMoedas) {
            aux += m.converter();
        }

        return aux;

    }
    


}
