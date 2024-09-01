package br.ifba.inf011.aval2.model.memento;

import br.ifba.inf011.aval2.model.bridge.Conversor;
import br.ifba.inf011.aval2.model.state.ArquivoState;

/*
  * Design Pattern Memento
  *
  * - ArquivoSnapshot: Memento que armazena o estado de um Arquivo
 */
public class ArquivoSnapshot implements NarrowArquivo, WideArquivo{

  private Conversor conversor;
  private String conteudo;
  private ArquivoState state;

  public ArquivoSnapshot(
    Conversor conversor,
    String conteudo,
    ArquivoState state
  ) {
    this.conversor = conversor;
    this.conteudo = conteudo;
    this.state = state;
  }

  public Conversor getConversor() {
    return this.conversor;
  }

  public String getConteudo() {
    return this.conteudo;
  }

  public ArquivoState getState() {
    return this.state;
  }
}
