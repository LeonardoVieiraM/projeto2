import static org.junit.Assert.*;
import org.junit.Test;

public class ClientesTest {

    @Test
    public void testGetNome() {
        Clientes cliente = new Clientes("João", 123456789, "senha123", 1);
        assertEquals("João", cliente.getNome());
    }

    @Test
    public void testGetCpf() {
        Clientes cliente = new Clientes("Maria", 987654321, "senha456", 2);
        assertEquals(987654321, cliente.getCpf());
    }

    @Test
    public void testGetSenha() {
        Clientes cliente = new Clientes("Carlos", 555555555, "minhasenha", 3);
        assertEquals("minhasenha", cliente.getSenha());
    }

    @Test
    public void testGetTipoCliente() {
        Clientes cliente = new Clientes("Ana", 111111111, "senha789", 4);
        assertEquals(4, cliente.getTipoCliente());
    }

    @Test
    public void testGetExtrato() {
        Clientes cliente = new Clientes("Pedro", 999999999, "senha987", 5);
        cliente.setExtrato(1000);
        assertEquals(1000, cliente.getExtrato());
    }

    @Test
    public void testGetSaldo() {
        Clientes cliente = new Clientes("Marta", 888888888, "senha654", 6);
        cliente.setSaldo(5000);
        assertEquals(5000, cliente.getSaldo());
    }
}
