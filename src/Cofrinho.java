
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import entities.Dolar;
import entities.Euro;
import entities.Moeda;
import entities.Real;

public class Cofrinho {

    private List<Moeda> listaMoedas = new ArrayList<>();

    public Cofrinho() {
        this.listaMoedas = new ArrayList<>();
    }

    public void adicionar(Scanner sc) {

        List<Integer> possiveisEscolhas = Arrays.asList(1,2,3);

        int escolha;

        do {

            Menu.escolherMoeda();
            
             escolha = Integer.parseInt(sc.nextLine());
            
            Menu.valorMoeda();
            double valorMoeda = Double.parseDouble(sc.nextLine());
            
            Moeda moeda;
            
            switch (escolha) {
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
                    System.out.println("Tipo de moeda inválido. Tente novamente...");
                return;
            }
            
            listaMoedas.add(moeda);
            System.out.println("Moeda adicionada.");
            sc.nextLine();
            Menu.clearScreen();

            // adicionar lógica para validar se a escolha é válida.
            // se não for válida, mostrar o menu e pedir a informação novamente.
            
        } while (!possiveisEscolhas.contains(escolha));
    } 

    public void remover(Scanner sc) {
        Menu.escolherMoeda();

        int escolha = Integer.parseInt(sc.nextLine());

        Menu.valorMoeda();
        double valorMoeda = Double.parseDouble(sc.nextLine());

        Moeda moeda;

        switch (escolha) {
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

        listaMoedas.remove(moeda);
        System.out.println("Moeda removida.");
        sc.nextLine();
        Menu.clearScreen();
    }

    public void listagemMoedas(Scanner sc) {
        try {
            if (listaMoedas.size() == 0) {
                System.out.println("Não há moedas no cofrinho.");

            } else {
                for (Moeda m : listaMoedas) {
                    System.out.println(m.info());

                }
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
        finally {
            Menu.pressioneParaSair(sc);
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
