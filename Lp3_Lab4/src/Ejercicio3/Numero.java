package Ejercicio3;

class Numero {
    private double valor;

    public Numero(double valor) {
        setValor(valor);
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("No se acepta numero negativo");
        }
        this.valor = valor;
    }

    public void imprimir() {
        System.out.println("Numero guardado: " + valor);
    }
}
