import static org.junit.Assert.*;
import org.junit.Test;

public class ContaTest {

    @Test
    public void testGetNumeroConta() {
        Conta conta = new Conta(12345, 1000.0);
        assertEquals(12345, conta.getNumeroConta());
    }

    @Test
    public void testGetSaldo() {
        Conta conta = new Conta(54321, 2000.0);
        assertEquals(2000.0, conta.getSaldo(), 0.001);
    }

    @Test
    public void testSacar() {
        Conta conta = new Conta(11111, 500.0);
        assertTrue(conta.sacar(200.0));
        assertEquals(300.0, conta.getSaldo(), 0.001);
        assertFalse(conta.sacar(400.0));  // Não há saldo suficiente
        assertEquals(300.0, conta.getSaldo(), 0.001);
    }

    @Test
    public void testDepositar() {
        Conta conta = new Conta(22222, 1000.0);
        conta.depositar(500.0);
        assertEquals(1500.0, conta.getSaldo(), 0.001);
    }
}
