package br.ifba.inf011.aval2.model.memento;

import br.ifba.inf011.aval2.model.bridge.Conversor;
import br.ifba.inf011.aval2.model.state.ArquivoState;

/*
 * Design Pattern Memento
 *
 * - WideArquivo: Interface que possui métodos para obter informações do Memento
 */
public interface WideArquivo {
  String getConteudo();
  ArquivoState getState();
  Conversor getConversor();
}
