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
  public Long tamanho(Arquivo arquivo) throws IllegalAccessException{
    return arquivo.getTamanho();
  }

  @Override
  public abstract void somenteLeitura(Arquivo arquivo);
  @Override
  public abstract void bloquear(Arquivo arquivo);
  @Override
  public abstract void excluir(Arquivo arquivo);
  @Override
  public abstract void restaurar(Arquivo arquivo);
  @Override
  public abstract void liberar(Arquivo arquivo);

}
