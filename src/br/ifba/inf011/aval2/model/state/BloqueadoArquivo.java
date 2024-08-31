package br.ifba.inf011.aval2.model.state;

import br.ifba.inf011.aval2.model.Credencial;

public class BloqueadoArquivo extends AbstractArquivoState{

  @Override
  public String ler(Arquivo arquivo, Credencial credencial) throws IllegalAccessException{
    throw new IllegalAccessException("Arquivo bloqueado.");
  }

  @Override
  public void escrever(Arquivo arquivo, Credencial credencial, String conteudo) throws IllegalAccessException{
    throw new IllegalAccessException("Arquivo bloqueado.");
  }

  @Override
  public Long tamanho(Arquivo arquivo) throws IllegalAccessException{
    return Long.valueOf(arquivo.dump());
  }

  @Override
  public void somenteLeitura(Arquivo arquivo) {}

  @Override
  public void bloquear(Arquivo arquivo) {}

  @Override
  public void excluir(Arquivo arquivo) {}

  @Override
  public void restaurar(Arquivo arquivo) {}

  @Override
  public void liberar(Arquivo arquivo) {
    arquivo.setState(new EstadoNormalArquivo());
  }
}
