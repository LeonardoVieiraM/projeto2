public class ContaInvestimento extends Conta {
    private double rendimentoDiario;

    public ContaInvestimento(int numeroConta, double saldoInicial, double rendimentoDiario) {
        super(numeroConta, saldoInicial);
        this.rendimentoDiario = rendimentoDiario;
    }

    public double getRendimentoDiario() {
        return rendimentoDiario;
    }

    @Override
    public boolean sacar(double valor) {
        double rendimento = calcularRendimentoDiario();
        double imposto = calcularImposto(rendimento);
        double taxa = calcularTaxa(rendimento);

        if (getSaldo() + rendimento >= valor + imposto + taxa) {
            setSaldo(getSaldo() + rendimento - valor - imposto - taxa);
            return true;
        }
        return false;
    }

    @Override
    public void depositar(double valor) {
        double rendimento = calcularRendimentoDiario();
        setSaldo(getSaldo() + valor + rendimento);
    }

    private double calcularRendimentoDiario() {
        return getSaldo() * rendimentoDiario;
      // Calcula o rendimento diário com base na variação diária (positiva ou negativa).
    }

    private double calcularImposto(double rendimento) {     
        return rendimento * 0.15;
      // Calcula o imposto de 15% sobre o rendimento no momento do saque.
    }

    private double calcularTaxa(double rendimento) {
        return rendimento * 0.015;
      // Calcula a taxa de 1,5% sobre o rendimento no momento do saque.
    }
}
