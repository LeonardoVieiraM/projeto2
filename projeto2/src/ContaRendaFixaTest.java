import static org.junit.Assert.*;
import org.junit.Test;

public class ContaRendaFixaTest {

    @Test
    public void testGetRendimentoContratado() {
        ContaRendaFixa contaRendaFixa = new ContaRendaFixa(12345, 1000.0, 0.05);
        assertEquals(0.05, contaRendaFixa.getRendimentoContratado(), 0.001);
    }

    @Test
    public void testSacar() {
        ContaRendaFixa contaRendaFixa = new ContaRendaFixa(11111, 5000.0, 0.04);
        assertTrue(contaRendaFixa.sacar(2000.0));
        assertEquals(2995.0, contaRendaFixa.getSaldo(), 0.001);

        // Sacar mais do que o saldo, imposto deve ser aplicado
        assertTrue(contaRendaFixa.sacar(3000.0));
        assertEquals(2955.0, contaRendaFixa.getSaldo(), 0.001);

        // Verificar imposto após o saque
        assertEquals(88.65, (5000.0 * 0.04 * 0.15), 0.01);

        // Sacar mais do que o saldo e imposto, não deve ser permitido
        assertFalse(contaRendaFixa.sacar(4000.0));
        assertEquals(2955.0, contaRendaFixa.getSaldo(), 0.001);
    }

    @Test
    public void testDepositar() {
        ContaRendaFixa contaRendaFixa = new ContaRendaFixa(22222, 1000.0, 0.05);
        contaRendaFixa.depositar(500.0);
        assertEquals(1550.0, contaRendaFixa.getSaldo(), 0.001);
    }
}
