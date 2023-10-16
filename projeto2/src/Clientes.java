public class Cliente {
    private String nome;
    private String cpf;
    private String senha;
    private TipoCliente tipoCliente;
    private List<Conta> contas;

    public Cliente(String nome, String cpf, String senha, TipoCliente tipoCliente) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.tipoCliente = tipoCliente;
        this.contas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void removerConta(Conta conta) {
        contas.remove(conta);
    }

    
    public void acessarExtrato(Conta conta) {
    System.out.println("Extrato da Conta " + conta.getNumeroConta() + ":");
    List<Transacao> transacoes = conta.getTransacoes();
    
    if (transacoes.isEmpty()) {
        System.out.println("Nenhuma transação disponível.");
    } 
    else {
        for (Transacao transacao : transacoes) {
            System.out.println("Data: " + transacao.getData() + ", Descrição: " + transacao.getDescricao() + ", Valor: R$" + transacao.getValor());
            }
        }
    }

    public double consultarSaldo(Conta conta) {
       return conta.getSaldo();
    }

     public void realizarOperacao(Conta conta, double valor) {
        if (valor > 0) {
            conta.depositar(valor);
            System.out.println("Depósito de R$" + valor + " realizado na Conta " + conta.getNumeroConta());
        } 
        else if (valor < 0) {
            if (conta.sacar(Math.abs(valor))) {
                System.out.println("Saque de R$" + Math.abs(valor) + " realizado na Conta " + conta.getNumeroConta());
            } 
            else {
                System.out.println("Saldo insuficiente para saque na Conta " + conta.getNumeroConta());
            }
        } 
        else {
            System.out.println("Operação inválida: o valor deve ser diferente de zero.");
        }
    }
}
}
