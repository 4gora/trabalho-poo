package entities;

public class Real extends Moeda {

    
    public Real(double valor) {
        super(valor);
    }
    @Override
    public String info() {
        return "Moeda: Real" + String.format("\nValor = R$ %,.2f", valor);

    }
    @Override
    public double converter() {
        return valor;
    }

    

    
    
}
