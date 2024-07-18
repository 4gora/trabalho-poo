package entities;

public class Dolar extends Moeda {

    public Dolar(double valor) {
        super(valor);
    }

    @Override
    public String info() {
        return "Moeda: Dolar" + String.format("\nValor = $ %,.2f", valor);


    }

    @Override
    public double converter() {
        return valor * 5.49;
    }

}
