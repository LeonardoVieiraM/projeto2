import java.util.Calendar;

public class ContaPoupanca extends Conta {
    private double rendimentoFixo;
    private Calendar dataRendimento;

    public ContaPoupanca(int numeroConta, double saldoInicial, double rendimentoFixo) {
        super(numeroConta, saldoInicial);
        this.rendimentoFixo = rendimentoFixo;
        this.dataRendimento = Calendar.getInstance();
        this.dataRendimento.set(Calendar.DAY_OF_MONTH, 5);      // Define a data de rendimento para o dia 5 de cada mês
    }

    public double getRendimentoFixo() {
        return rendimentoFixo;
    }

    public Calendar getDataRendimento() {
        return dataRendimento;
    }

    @Override
    public boolean sacar(double valor) {
        Calendar dataAtual = Calendar.getInstance();            // Verifica se a data atual é o dia de rendimento
        if (dataAtual.get(Calendar.DAY_OF_MONTH) == dataRendimento.get(Calendar.DAY_OF_MONTH)) {        
            double rendimento = getSaldo() * rendimentoFixo;    // Calcula e adiciona o rendimento antes do saque
            setSaldo(getSaldo() + rendimento);
        }

        if (getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            return true;
        }
        return false;
    }

    @Override
    public void depositar(double valor) {
        setSaldo(getSaldo() + valor);
    }
}
