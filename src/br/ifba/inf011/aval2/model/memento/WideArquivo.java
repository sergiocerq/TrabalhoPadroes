package br.ifba.inf011.aval2.model.memento;

import br.ifba.inf011.aval2.model.bridge.Conversor;
import br.ifba.inf011.aval2.model.state.ArquivoState;

public interface WideArquivo {
  String getConteudo();
  ArquivoState getState();
  Conversor getConversor();
}
