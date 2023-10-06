public abstract class Contas { 
    private int numeroConta;
    private double saldo;

    public Conta(int numeroConta, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    // Método abstrato para sacar dinheiro da conta
    public abstract boolean sacar(double valor);

    // Método abstrato para depositar dinheiro na conta
    public abstract void depositar(double valor);
}
