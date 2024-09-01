package br.ifba.inf011.aval2.model.memento;

import br.ifba.inf011.aval2.model.Credencial;
import br.ifba.inf011.aval2.model.Operavel;
import br.ifba.inf011.aval2.model.state.Arquivo;

import java.util.Stack;

public class HistoricoArquivo implements Operavel {

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

  @Override
  public String dump() {
    return arquivo.dump();
  }

  @Override
  public String ler(Credencial credencial) throws IllegalAccessException {
    return arquivo.ler(credencial);
  }

  @Override
  public void escrever(Credencial credencial, String escrever) throws IllegalAccessException {
    arquivo.escrever(credencial, escrever);
  }
}
