package br.com.danilo;

/**
 * @author danmoreira28
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.danilo.dao.ClienteDaoMock;
import br.com.danilo.dao.IClienteDAO;
import br.com.danilo.domain.Cliente;
import br.com.danilo.exceptions.DAOException;
import br.com.danilo.exceptions.TipoChaveNaoEncontradaException;
import br.com.danilo.services.ClienteService;
import br.com.danilo.services.IClienteService;


public class ClienteServiceTest {

    private IClienteService clienteService;

    private Cliente cliente;

    public ClienteServiceTest() {
        IClienteDAO dao = new ClienteDaoMock();
        clienteService = new ClienteService(dao);
    }

    @Before
    public void init() {
        cliente = new Cliente();
        cliente.setCpf(12345678L);
        cliente.setNome("Danilo");
        cliente.setCidade("São Paulo");
        cliente.setEnd("End");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(1199999999L);
        cliente.setSexo("M");
        cliente.setIdade(29);
    }

    @Test
    public void pesquisarCliente() throws DAOException {
        Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException, DAOException {
        Boolean retorno = clienteService.cadastrar(cliente);

        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() throws DAOException {
        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException {
        cliente.setNome("Danilo Moreira");
        clienteService.alterar(cliente);

        Assert.assertEquals("Danilo Moreira", cliente.getNome());
    }
}