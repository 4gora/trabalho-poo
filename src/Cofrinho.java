
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import entities.Dolar;
import entities.Euro;
import entities.Moeda;
import entities.Real;

public class Cofrinho {

    private List<Moeda> listaMoedas = new ArrayList<>();
    List<Integer> possiveisEscolhas = Arrays.asList(1, 2, 3);

    public Cofrinho() {
        this.listaMoedas = new ArrayList<>();
    }

    public void adicionar(Scanner sc) {
        Menu.clearScreen();
        int escolha = 0;

        do {

            try {

                Menu.escolherMoeda();

                escolha = Integer.parseInt(sc.nextLine());

                if (!possiveisEscolhas.contains(escolha)) {
                    Menu.clearScreen();
                    System.out.println("Tipo de moeda inválido. Tente novamente...");
                    continue;
                }
                double valorMoeda = 0.0;
                boolean valorValido = false;

                do {
                    try {
                        Menu.valorMoeda();
                        valorMoeda = Double.parseDouble(sc.nextLine());

                        if (valorMoeda >= 0) {
                            valorValido = true;
                        } else {
                            Menu.clearScreen();
                            System.out.println("O valor deve ser positivo. Tente novamente..");
                        }

                    } catch (NumberFormatException e) {
                        Menu.clearScreen();
                        System.out.println("Valor inválido. Por favor, insira um valor válido.");
                    }
                } while (!valorValido);

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

            } catch (NumberFormatException e) {
                Menu.clearScreen();
                System.out.println("Entrada inválida. Tente novamente.");
                Menu.pressioneParaSair(sc);
            } catch (Exception e) {
                Menu.clearScreen();
                System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
                Menu.pressioneParaSair(sc);

            }

        } while (!possiveisEscolhas.contains(escolha));
    }

    public void remover(Scanner sc) {
        Menu.clearScreen();
        int escolha = 0;

        do {
            try {
                if (listaMoedas.size() < 1) { // verifica se há moedas no cofrinho.
                    System.out.println("Não há moedas no cofrinho.");
                    break;
                }

                Menu.escolherMoeda();
                escolha = Integer.parseInt(sc.nextLine());

                if (!possiveisEscolhas.contains(escolha)) { // verifica se a escolha do usuário está correta.
                    Menu.clearScreen();
                    System.out.println("Tipo de moeda inválido. Tente novamente...");
                    continue;

                } else {
                    Iterator<Moeda> iterator = listaMoedas.iterator();

                    while (iterator.hasNext()) {

                        Moeda moeda = iterator.next();

                        switch (escolha) {
                            case 1:
                                if (moeda instanceof Real) {
                                    iterator.remove();
                                    System.out.println("Todos as moedas de Real foram removidas.");
                                }
                                break;
                            case 2:
                                if (moeda instanceof Dolar) {
                                    iterator.remove();
                                    System.out.println("Todos as moedas de Dolar foram removidas.");
                                }
                                break;
                            case 3:
                                if (moeda instanceof Euro) {
                                    iterator.remove();
                                    System.out.println("Todos as moedas de Euro foram removidas.");
                                }
                                break;
                            default:
                                System.out.println("Escolha inválida. Tente novamente..");
                                break;

                        }

                    }
                    Menu.pressioneParaSair(sc);
                    // melhorar lógica para validar se a escolha é válida.
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

        } while (!possiveisEscolhas.contains(escolha));
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

    public void totalConvertido(Scanner sc) {
        Menu.clearScreen();
        double soma = 0.0;

        for (Moeda m : listaMoedas) {
            soma += m.converter();
        }

        System.out.printf("Total do cofrinho convertido em Reais:%nR$ %,.2f%n", soma);

        Menu.pressioneParaSair(sc);

    }

}
