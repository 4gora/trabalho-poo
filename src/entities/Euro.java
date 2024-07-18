package entities;

public class Euro extends Moeda {

    

    public Euro(double valor) {
        super(valor);
    }

    @Override
    public String info() {
        return "Moeda: Euro" + String.format("\nValor = € %,.2f", valor);

    }

    @Override
    public double converter() {
        return valor * 6.00;
    }
    
}
