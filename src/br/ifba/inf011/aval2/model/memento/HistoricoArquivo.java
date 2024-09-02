package br.ifba.inf011.aval2.model.memento;

import br.ifba.inf011.aval2.model.Credencial;
import br.ifba.inf011.aval2.model.Entrada;
import br.ifba.inf011.aval2.model.EntradaOperavel;
import br.ifba.inf011.aval2.model.Operavel;
import br.ifba.inf011.aval2.model.state.Arquivo;

import java.time.LocalDate;
import java.util.List;
import java.util.Stack;

/*
 * Design Pattern Memento
 *
 * - HistoricoArquivo: Caretaker que armazena os Mementos de um Arquivo
 */
public class HistoricoArquivo implements EntradaOperavel {

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

  @Override
  public String getNome() {
    return arquivo.getNome();
  }

  @Override
  public LocalDate getDataCriacao() {
    return arquivo.getDataCriacao();
  }

  @Override
  public Long getTamanho() {
    return arquivo.getTamanho();
  }

  @Override
  public List<Entrada> getFilhos() throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Arquivo não pode ter filhos");
  }

  @Override
  public void addFilho(Entrada entrada) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Arquivo não pode ter filhos");
  }

  @Override
  public void removeFilho(Entrada entrada) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Arquivo não pode ter filhos");
  }
}
