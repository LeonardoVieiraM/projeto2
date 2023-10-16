public abstract class Contas { 
    private int numeroConta;
    private double saldo;
    private List<Transacao> transacoes;

    public Conta(int numeroConta, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
        transacoes = new ArrayList<>();
        saldo = 0.0;
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
    
    public void adicionarTransacao(String descricao, double valor) {
        Transacao transacao = new Transacao(descricao, valor);
        transacoes.add(transacao);
    }
    
    public List<Transacao> getTransacoes() {
        return transacoes;
    }
    
}
