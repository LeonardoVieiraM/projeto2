import java.util.List;

public class Diretoria {
    private List<Cliente> clientes;

    public Diretoria(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public double calcularTotalCustodia(TipoConta tipoConta) {
        double totalCustodia = 0;
        for (Cliente cliente : clientes) {
            for (Conta conta : cliente.getContas()) {
                if (conta.getTipoConta() == tipoConta) {
                    totalCustodia += conta.getSaldo();
                }
            }
        }
        return totalCustodia;
    }

    public double calcularSaldoMedioTodasContas() {
        double saldoTotal = 0;
        int totalContas = 0;
        for (Cliente cliente : clientes) {
            for (Conta conta : cliente.getContas()) {
                saldoTotal += conta.getSaldo();
                totalContas++;
            }
        }
        return totalContas > 0 ? saldoTotal / totalContas : 0;
    }

    public int contarClientesSaldoNegativo() {
        int clientesComSaldoNegativo = 0;
        for (Cliente cliente : clientes) {
            double saldoTotal = 0;
            for (Conta conta : cliente.getContas()) {
                saldoTotal += conta.getSaldo();
            }
            if (saldoTotal < 0) {
                clientesComSaldoNegativo++;
            }
        }
        return clientesComSaldoNegativo;
    }

    public Cliente clienteComMaiorSaldo() {
        Cliente clienteMaiorSaldo = null;
        double maiorSaldo = Double.NEGATIVE_INFINITY;

        for (Cliente cliente : clientes) {
            double saldoTotal = 0;
            for (Conta conta : cliente.getContas()) {
                saldoTotal += conta.getSaldo();
            }

            if (saldoTotal > maiorSaldo) {
                maiorSaldo = saldoTotal;
                clienteMaiorSaldo = cliente;
            }
        }
        return clienteMaiorSaldo;
    }

    public Cliente clienteComMenorSaldo() {
        Cliente clienteMenorSaldo = null;
        double menorSaldo = Double.POSITIVE_INFINITY;

        for (Cliente cliente : clientes) {
            double saldoTotal = 0;
            for (Conta conta : cliente.getContas()) {
                saldoTotal += conta.getSaldo();
            }

            if (saldoTotal < menorSaldo) {
                menorSaldo = saldoTotal;
                clienteMenorSaldo = cliente;
            }
        }
        return clienteMenorSaldo;
    }
}

