public class ContaCorrente extends Conta {
    private double taxaMensal;
    private double limiteEspecial;

    public ContaCorrente(int numeroConta, double saldoInicial, double taxaMensal, double limiteEspecial) {
        super(numeroConta, saldoInicial);
        this.taxaMensal = taxaMensal;
        this.limiteEspecial = limiteEspecial;
    }

    public double getTaxaMensal() {
        return taxaMensal;
    }

    public double getLimiteEspecial() {
        return limiteEspecial;
    }
    // Calcula a taxa mensal se o saldo for insuficiente
    @Override
    public boolean sacar(double valor) {
        if (getSaldo() + limiteEspecial >= valor) {
            if (valor > getSaldo()) {
                double taxa = (valor - getSaldo()) * taxaMensal;
                setSaldo(getSaldo() - valor - taxa);
            } else {
                setSaldo(getSaldo() - valor);
            }
            return true;
        }
        return false;
    }

    @Override
    public void depositar(double valor) {
        setSaldo(getSaldo() + valor);
    }
}
