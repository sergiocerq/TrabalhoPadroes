package br.ifba.inf011.aval2.model.state;

import br.ifba.inf011.aval2.model.Credencial;

public class BloqueadoArquivo extends AbstractArquivoState{

  @Override
  public String ler(Arquivo arquivo, Credencial credencial) throws IllegalAccessException{
    throw new IllegalAccessException("Não foi possível ler o arquivo: Arquivo bloqueado.");
  }

  @Override
  public void escrever(Arquivo arquivo, Credencial credencial, String conteudo) throws IllegalAccessException{
    throw new IllegalAccessException("Não foi possível escrever no arquivo: Arquivo bloqueado.");
  }

  @Override
  public void liberar(Arquivo arquivo) {
    arquivo.setState(new EstadoNormalArquivo());
  }
}
