package entities;

public class Euro extends Moeda {

    

    public Euro(double valor) {
        super(valor);
    }

    @Override
    public String info() {
        return "Moeda: " + this.getClass().getSimpleName() + String.format("\nValor = € %,.2f", valor);

    }

    @Override
    public double converter() {
        return valor * 6.00;
    }
    
}
