package br.luciano.ArquivoMultiplosFormatos_batch.reader;

import br.luciano.ArquivoMultiplosFormatos_batch.dominio.Cliente;
import br.luciano.ArquivoMultiplosFormatos_batch.dominio.Transacao;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class ArquivoClienteTransacaoReader implements ItemStreamReader<Cliente> {
    private Object objAtual;
    @Override
    public Cliente read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (objAtual == null) {
            objAtual = //ler objeto
        }

        Cliente cliente = (Cliente) objAtual;
        objAtual = null;

        if (cliente != null) {
            while (peek() instanceof Transacao) {
                cliente.getTransacoes().add((Transacao) objAtual);
            }
        }

        return cliente;
    }

    private Object peek() {
        objAtual = //leitura próximo item
        return objAtual;
    }
}
