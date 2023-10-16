import static org.junit.Assert.*;
import org.junit.Test;

public class ContaCorrenteTest {

    @Test
    public void testGetTaxaMensal() {
        ContaCorrente contaCorrente = new ContaCorrente(12345, 1000.0, 0.02, 500.0);
        assertEquals(0.02, contaCorrente.getTaxaMensal(), 0.001);
    }

    @Test
    public void testGetLimiteEspecial() {
        ContaCorrente contaCorrente = new ContaCorrente(54321, 2000.0, 0.03, 1000.0);
        assertEquals(1000.0, contaCorrente.getLimiteEspecial(), 0.001);
    }

    @Test
    public void testSacar() {
        ContaCorrente contaCorrente = new ContaCorrente(11111, 500.0, 0.01, 200.0);
        assertTrue(contaCorrente.sacar(200.0));
        assertEquals(300.0, contaCorrente.getSaldo(), 0.001);

        // Sacar mais do que o saldo, taxa deve ser aplicada
        assertTrue(contaCorrente.sacar(400.0));
        assertEquals(-100.0, contaCorrente.getSaldo(), 0.001);

        // Sacar mais do que o saldo e o limite especial, não deve ser permitido
        assertFalse(contaCorrente.sacar(200.0));
        assertEquals(-100.0, contaCorrente.getSaldo(), 0.001);
    }

    @Test
    public void testDepositar() {
        ContaCorrente contaCorrente = new ContaCorrente(22222, 1000.0, 0.01, 300.0);
        contaCorrente.depositar(500.0);
        assertEquals(1500.0, contaCorrente.getSaldo(), 0.001);
    }
}
