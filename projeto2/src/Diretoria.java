public class Diretoria {
    int custodia;
    int saldoMedio;
    int clienteNegativo;
    Clientes maior;
    Clientes menor;

    public void setClienteNegativo(int clienteNegativo) {
        this.clienteNegativo = clienteNegativo;
    }

    public void setCustodia(int custodia) {
        this.custodia = custodia;
    }

    public void setMaior(Clientes maior) {
        this.maior = maior;
    }

    public void setMenor(Clientes menor) {
        this.menor = menor;
    }

    public void setSaldoMedio(int saldoMedio) {
        this.saldoMedio = saldoMedio;
    }

    public int getClienteNegativo() {
        return clienteNegativo;
    }

    public int getCustodia() {
        return custodia;
    }

    public Clientes getMaior() {
        return maior;
    }

    public Clientes getMenor() {
        return menor;
    }

    public int getSaldoMedio() {
        return saldoMedio;
    }
}
