import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class DiretoriaTest {
    private List<Cliente> clientes;
    private Diretoria diretoria;

    @Before
    public void setUp() {
        // Configurar um conjunto de clientes e contas para testar
        clientes = new ArrayList<>();
        clientes.add(new Cliente("Cliente1"));
        clientes.add(new Cliente("Cliente2"));

        // Cliente1 tem uma conta corrente com saldo de 1000 e uma conta poupança com saldo de 1500
        clientes.get(0).addConta(new ContaCorrente(1, 1000.0, 0.01, 500.0));
        clientes.get(0).addConta(new ContaPoupanca(2, 1500.0, 0.02));

        // Cliente2 tem uma conta investimento com saldo de 2000 e uma conta renda fixa com saldo de 3000
        clientes.get(1).addConta(new ContaInvestimento(3, 2000.0, 0.03));
        clientes.get(1).addConta(new ContaRendaFixa(4, 3000.0, 0.04));

        diretoria = new Diretoria(clientes);
    }

    @Test
    public void testCalcularTotalCustodia() {
        assertEquals(2500.0, diretoria.calcularTotalCustodia(TipoConta.CONTA_CORRENTE), 0.001);
        assertEquals(1500.0, diretoria.calcularTotalCustodia(TipoConta.CONTA_POUPANCA), 0.001);
        assertEquals(2000.0, diretoria.calcularTotalCustodia(TipoConta.CONTA_INVESTIMENTO), 0.001);
        assertEquals(3000.0, diretoria.calcularTotalCustodia(TipoConta.CONTA_RENDA_FIXA), 0.001);
    }

    @Test
    public void testCalcularSaldoMedioTodasContas() {
        assertEquals(2375.0, diretoria.calcularSaldoMedioTodasContas(), 0.001);
    }

    @Test
    public void testContarClientesSaldoNegativo() {
        assertEquals(0, diretoria.contarClientesSaldoNegativo());
        clientes.get(0).getConta(0).sacar(1100.0);  // Cliente1, ContaCorrente
        assertEquals(1, diretoria.contarClientesSaldoNegativo());
    }

    @Test
    public void testClienteComMaiorSaldo() {
        Cliente clienteComMaiorSaldo = diretoria.clienteComMaiorSaldo();
        assertEquals("Cliente2", clienteComMaiorSaldo.getNome());
    }

    @Test
    public void testClienteComMenorSaldo() {
        Cliente clienteComMenorSaldo = diretoria.clienteComMenorSaldo();
        assertEquals("Cliente1", clienteComMenorSaldo.getNome());
    }
}
