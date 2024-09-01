package br.ifba.inf011.aval2.model.state;

import br.ifba.inf011.aval2.model.Credencial;

public abstract class AbstractArquivoState implements ArquivoState {

  protected Arquivo arquivo;

  public AbstractArquivoState(Arquivo arquivo) {
    this.arquivo = arquivo;
  }

  @Override
  public String dump() {
    return "";
  }

  @Override
  public String ler(Credencial credencial) throws IllegalAccessException {
    return arquivo.getConversor().decode(arquivo.getConteudo());
  }

  @Override
  public void escrever(Credencial credencial, String conteudo) throws IllegalAccessException{
    arquivo.setConteudo(arquivo.getConversor().encode(conteudo));
  }

  @Override
  public Long tamanho(String conteudo) {
    return (long) conteudo.length();
  }

  @Override
  public void somenteLeitura(){}
  @Override
  public void bloquear(){}
  @Override
  public void excluir(){}
  @Override
  public void restaurar(){}
  @Override
  public void liberar(){}

}
