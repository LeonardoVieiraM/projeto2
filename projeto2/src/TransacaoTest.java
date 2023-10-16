import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Date;

public class TransacaoTest {

    @Test
    public void testGetDescricao() {
        Transacao transacao = new Transacao("Compra de ações", 1000.0);
        assertEquals("Compra de ações", transacao.getDescricao());
    }

    @Test
    public void testGetValor() {
        Transacao transacao = new Transacao("Venda de títulos", 1500.0);
        assertEquals(1500.0, transacao.getValor(), 0.001);
    }

    @Test
    public void testGetData() {
        Date data = new Date();
        Transacao transacao = new Transacao("Depósito em conta", 500.0);
        assertNotNull(transacao.getData());
        assertEquals(data.getClass(), transacao.getData().getClass());
    }
}
