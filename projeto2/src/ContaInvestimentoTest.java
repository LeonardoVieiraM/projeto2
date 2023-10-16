import static org.junit.Assert.*;
import org.junit.Test;

public class ContaInvestimentoTest {

    @Test
    public void testGetRendimentoDiario() {
        ContaInvestimento contaInvestimento = new ContaInvestimento(12345, 1000.0, 0.03);
        assertEquals(0.03, contaInvestimento.getRendimentoDiario(), 0.001);
    }

    @Test
    public void testSacar() {
        ContaInvestimento contaInvestimento = new ContaInvestimento(11111, 5000.0, 0.02);
        assertTrue(contaInvestimento.sacar(2000.0));
        assertEquals(2990.0, contaInvestimento.getSaldo(), 0.001);

        // Sacar mais do que o saldo, imposto e taxa devem ser aplicados
        assertTrue(contaInvestimento.sacar(3000.0));
        assertEquals(2935.0, contaInvestimento.getSaldo(), 0.001);

        // Sacar mais do que o saldo e rendimento, não deve ser permitido
        assertFalse(contaInvestimento.sacar(4000.0));
        assertEquals(2935.0, contaInvestimento.getSaldo(), 0.001);
    }

    @Test
    public void testDepositar() {
        ContaInvestimento contaInvestimento = new ContaInvestimento(22222, 1000.0, 0.03);
        contaInvestimento.depositar(500.0);
        assertEquals(1550.0, contaInvestimento.getSaldo(), 0.001);
    }
}
