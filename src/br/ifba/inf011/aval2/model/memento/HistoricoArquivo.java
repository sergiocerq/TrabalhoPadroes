package br.ifba.inf011.aval2.model.memento;

import br.ifba.inf011.aval2.model.Credencial;
import br.ifba.inf011.aval2.model.Entrada;
import br.ifba.inf011.aval2.model.EntradaOperavel;
import br.ifba.inf011.aval2.model.Operavel;
import br.ifba.inf011.aval2.model.bridge.Conversor;
import br.ifba.inf011.aval2.model.state.Arquivo;

import java.time.LocalDate;
import java.util.List;
import java.util.Stack;

/*
 * Design Pattern Memento
 *
 * - HistoricoArquivo: Caretaker que armazena os Mementos de um Arquivo
 * - Refined Abstraction no bridge
 */
public class HistoricoArquivo extends Arquivo {

  private Stack<NarrowArquivo> mementos = new Stack<NarrowArquivo>();

  public HistoricoArquivo(Arquivo arquivo){
    super(arquivo.getNome(), arquivo.getDataCriacao(), arquivo.getConteudo(), arquivo.getConversor());
  }

  public HistoricoArquivo(String nome, LocalDate dataCriacao, String conteudo, Conversor conversor){
    super(nome, dataCriacao, conteudo, conversor);
  }

  public void checkpoint(){
    this.mementos.push(this.snapshot());
  }

  public void undo(){
    if(this.mementos.isEmpty())
      return;

    this.restore(this.mementos.pop());
  }
}
