import static org.junit.Assert.*;
import org.junit.Test;

public class ContaPoupancaTest {

    @Test
    public void testGetRendimentoFixo() {
        ContaPoupanca contaPoupanca = new ContaPoupanca(12345, 1000.0, 0.03);
        assertEquals(0.03, contaPoupanca.getRendimentoFixo(), 0.001);
    }

    @Test
    public void testSacar() {
        ContaPoupanca contaPoupanca = new ContaPoupanca(11111, 5000.0, 0.02);
        assertTrue(contaPoupanca.sacar(2000.0));
        assertEquals(2990.0, contaPoupanca.getSaldo(), 0.001);

        // Sacar mais do que o saldo, rendimento deve ser aplicado
        assertTrue(contaPoupanca.sacar(3000.0));
        assertEquals(2945.0, contaPoupanca.getSaldo(), 0.001);

        // Verificar rendimento após o saque
        assertEquals(88.35, contaPoupanca.getSaldo() * 0.03, 0.01);

        // Sacar mais do que o saldo e rendimento, não deve ser permitido
        assertFalse(contaPoupanca.sacar(4000.0));
        assertEquals(2945.0, contaPoupanca.getSaldo(), 0.001);
    }

    @Test
    public void testDepositar() {
        ContaPoupanca contaPoupanca = new ContaPoupanca(22222, 1000.0, 0.03);
        contaPoupanca.depositar(500.0);
        assertEquals(1550.0, contaPoupanca.getSaldo(), 0.001);
    }
}
