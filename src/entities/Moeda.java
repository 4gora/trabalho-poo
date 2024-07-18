package entities;

public abstract class Moeda {

    protected double valor;

    public double getValor() {
        return valor;
    }

    public Moeda(double valor) {
        this.valor = valor;
    }

    public String info() {
        return "Moeda: " + this.getClass().getSimpleName() + String.format("\nValor = %,.2f", valor);
    }

    public abstract double converter();

}
