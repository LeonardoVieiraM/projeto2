public class ContaRendaFixa extends Conta {
    private double rendimentoContratado;

    public ContaRendaFixa(int numeroConta, double saldoInicial, double rendimentoContratado) {
        super(numeroConta, saldoInicial);
        this.rendimentoContratado = rendimentoContratado;
    }

    public double getRendimentoContratado() {
        return rendimentoContratado;
    }

    @Override
    public boolean sacar(double valor) {
        double rendimentoDiario = calcularRendimentoDiario();
        double valorComImposto = calcularValorComImposto(valor, rendimentoDiario);

        if (getSaldo() >= valor + valorComImposto) {
            setSaldo(getSaldo() - valor - valorComImposto);
            return true;
        }
        return false;
    }

    @Override
    public void depositar(double valor) {
        double rendimentoDiario = calcularRendimentoDiario();
        setSaldo(getSaldo() + valor + calcularValorComImposto(valor, rendimentoDiario));
    }

    private double calcularRendimentoDiario() {
        return getSaldo() * (rendimentoContratado / 365); 
      //fórmula simples que calcula o rendimento como uma porcentagem fixa.
      // Dividido por 365 para representar rendimento diário.
    }

    private double calcularValorComImposto(double valor, double rendimentoDiario) {
        double rendimento = (getSaldo() + valor) * rendimentoDiario;
        return rendimento * 0.15;
      // Calcula o imposto de 15% sobre o rendimento no momento do saque.
    }
}
