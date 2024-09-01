package br.ifba.inf011.aval2.model.state;

import br.ifba.inf011.aval2.model.Credencial;

public abstract class AbstractArquivoState implements ArquivoState {

  @Override
  public String ler(Arquivo arquivo, Credencial credencial) throws IllegalAccessException {
    return arquivo.getConversor().encode(arquivo.getConteudo());
  }

  @Override
  public void escrever(Arquivo arquivo, Credencial credencial, String conteudo) throws IllegalAccessException{
    arquivo.setConteudo(conteudo);
  }

  @Override
  public Long tamanho(String conteudo) {
    return (long) conteudo.length();
  }

  @Override
  public void somenteLeitura(Arquivo arquivo){}
  @Override
  public void bloquear(Arquivo arquivo){}
  @Override
  public void excluir(Arquivo arquivo){}
  @Override
  public void restaurar(Arquivo arquivo){}
  @Override
  public void liberar(Arquivo arquivo){}

}
