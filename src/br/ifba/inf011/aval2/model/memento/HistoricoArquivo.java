package br.ifba.inf011.aval2.model.memento;

import br.ifba.inf011.aval2.model.state.Arquivo;

import java.util.Stack;

public class HistoricoArquivo {

  private Arquivo arquivo;
  private Stack<NarrowArquivo> mementos = new Stack<NarrowArquivo>();

  public HistoricoArquivo(Arquivo arquivo){
    this.arquivo = arquivo;
  }

  public void checkpoint(){
    this.mementos.push(this.arquivo.snapshot());
  }

  public void undo(){
    if(this.mementos.isEmpty())
      return;

    this.arquivo.restore(this.mementos.pop());
  }
}
