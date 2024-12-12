package br.com.danilo;

/**
 * @author danmoreira28
 */

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.com.danilo.dao.ClienteDAO;
import br.com.danilo.dao.IClienteDAO;
import br.com.danilo.domain.Cliente;
import br.com.danilo.exceptions.DAOException;
import br.com.danilo.exceptions.MaisDeUmRegistroException;
import br.com.danilo.exceptions.TableException;
import br.com.danilo.exceptions.TipoChaveNaoEncontradaException;

public class ClienteDAOTest {

    private IClienteDAO clienteDao;

    public ClienteDAOTest() {
        clienteDao = new ClienteDAO();
    }

    @After
    public void end() throws DAOException {
        Collection<Cliente> list = clienteDao.buscarTodos();
        list.forEach(cli -> {
            try {
                clienteDao.excluir(cli.getCpf());
            } catch (DAOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }

    @Test
    public void pesquisarCliente() throws MaisDeUmRegistroException, TableException, TipoChaveNaoEncontradaException, DAOException {
        Cliente cliente = new Cliente();
        cliente.setCpf(12345678910L);
        cliente.setNome("Danilo");
        cliente.setCidade("São Paulo");
        cliente.setEnd("End");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(1199999999L);
        cliente.setSexo("M");
        cliente.setIdade(29);
        clienteDao.cadastrar(cliente);

        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);

        //clienteDao.excluir(cliente.getCpf());
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        Cliente cliente = new Cliente();
        cliente.setCpf(12345678910L);
        cliente.setNome("Danilo");
        cliente.setCidade("São Paulo");
        cliente.setEnd("End");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(1199999999L);
        cliente.setSexo("M");
        cliente.setIdade(29);
        Boolean retorno = clienteDao.cadastrar(cliente);
        Assert.assertTrue(retorno);

        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);

       // clienteDao.excluir(cliente.getCpf());
    }


    @Test
    public void excluirCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        Cliente cliente = new Cliente();
        cliente.setCpf(12345678910L);
        cliente.setNome("Danilo");
        cliente.setCidade("São Paulo");
        cliente.setEnd("End");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(1199999999L);
        cliente.setSexo("M");
        cliente.setIdade(29);
        Boolean retorno = clienteDao.cadastrar(cliente);
        Assert.assertTrue(retorno);

        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);

        clienteDao.excluir(cliente.getCpf());
        clienteConsultado = clienteDao.consultar(cliente.getCpf());
        Assert.assertNull(clienteConsultado);
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        Cliente cliente = new Cliente();
        cliente.setCpf(123456789110L);
        cliente.setNome("Danilo1");
        cliente.setCidade("São Paulo");
        cliente.setEnd("End");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(1199999999L);
        cliente.setSexo("M");
        cliente.setIdade(30);
        Boolean retorno = clienteDao.cadastrar(cliente);
        Assert.assertTrue(retorno);

        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);

        clienteConsultado.setNome("Danilo Moreira");
        clienteDao.alterar(clienteConsultado);

        Cliente clienteAlterado = clienteDao.consultar(clienteConsultado.getCpf());
        Assert.assertNotNull(clienteAlterado);
        Assert.assertEquals("Danilo Moreira", clienteAlterado.getNome());

        clienteDao.excluir(cliente.getCpf());
        clienteConsultado = clienteDao.consultar(cliente.getCpf());
        Assert.assertNull(clienteConsultado);
    }

    @Test
    public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException {
        Cliente cliente = new Cliente();
        cliente.setCpf(12345678910L);
        cliente.setNome("Danilo");
        cliente.setCidade("São Paulo");
        cliente.setEnd("End");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(1199999999L);
        cliente.setSexo("M");
        cliente.setIdade(29);
        Boolean retorno = clienteDao.cadastrar(cliente);
        Assert.assertTrue(retorno);

        Cliente cliente1 = new Cliente();
        cliente1.setCpf(1234567891011L);
        cliente1.setNome("Danilo");
        cliente1.setCidade("São Paulo");
        cliente1.setEnd("End");
        cliente1.setEstado("SP");
        cliente1.setNumero(10);
        cliente1.setTel(1199999999L);
        cliente.setSexo("M");
        cliente.setIdade(29);
        Boolean retorno1 = clienteDao.cadastrar(cliente1);
        Assert.assertTrue(retorno1);

        Collection<Cliente> list = clienteDao.buscarTodos();
        assertTrue(list != null);
        assertTrue(list.size() == 2);

        list.forEach(cli -> {
            try {
                clienteDao.excluir(cli.getCpf());
            } catch (DAOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        Collection<Cliente> list1 = clienteDao.buscarTodos();
        assertTrue(list1 != null);
        assertTrue(list1.size() == 0);
    }
}