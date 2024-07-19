
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Iterator;
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
        Menu.clearScreen();
        List<Integer> possiveisEscolhas = Arrays.asList(1, 2, 3);
        int escolha = 0;

        do {

            try {

                Menu.escolherMoeda();

                escolha = Integer.parseInt(sc.nextLine());

                if (!possiveisEscolhas.contains(escolha)) {
                    Menu.clearScreen();
                    System.out.println("Tipo de moeda inválido. Tente novamente...");
                    continue;
                } else {
                    Menu.valorMoeda();
                    double valorMoeda = Double.parseDouble(sc.nextLine());

                    Moeda moeda = null;
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

                    }

                    listaMoedas.add(moeda);
                    System.out.println("Moeda adicionada.");
                    Menu.pressioneParaSair(sc);
                    // melhorar lógica para validar se a escolha é válida.

                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Tente novamente..");
            }

        } while (!possiveisEscolhas.contains(escolha));
    }

    public void remover(Scanner sc) {
        Menu.escolherMoeda();
        int escolha = Integer.parseInt(sc.nextLine());

        Iterator<Moeda> iterator = listaMoedas.iterator();

        while (iterator.hasNext()) {

            Moeda moeda = iterator.next();

            switch (escolha) {
                case 1:
                    if (moeda instanceof Real) {
                        iterator.remove();
                    }
                    break;
                case 2:
                    if (moeda instanceof Dolar) {
                        iterator.remove();
                    }
                    break;
                case 3:
                    if (moeda instanceof Euro) {
                        iterator.remove();
                    }
                    break;
                default:
                    System.out.println("Escolha inválida. Tente novamente..");
                    break;
            }
        }

        sc.nextLine();
    }

    public void listagemMoedas(Scanner sc) {

        Menu.clearScreen();

        try {
            if (listaMoedas.size() == 0) {
                System.out.println("Não há moedas no cofrinho.");

            } else {
                for (Moeda m : listaMoedas) {
                    System.out.println(m.info());

                }
            }

        } catch (Exception e) {
            System.out.println("erro");
        } finally {
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
