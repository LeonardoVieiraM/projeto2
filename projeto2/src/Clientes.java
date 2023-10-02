public class Clientes {
    private String nome;
    private int cpf;
    private String senha;

    private int extrato;
    private int saldo;

    private int tipoCliente;

    public Clientes(String nome, int cpf, String senha, int tipoCliente) {
        this.tipoCliente = tipoCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.extrato = 0;
        this.saldo = 0;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setTipoCliente(int tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public void setExtrato(int extrato) {
        this.extrato = extrato;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getExtrato() {
        return extrato;
    }

    public int getSaldo() {
        return saldo;
    }

    public int getTipoCliente() {
        return tipoCliente;
    }

    public int getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }
}