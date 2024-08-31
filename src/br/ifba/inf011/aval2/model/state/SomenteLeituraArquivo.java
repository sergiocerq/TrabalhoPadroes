package br.ifba.inf011.aval2.model.state;

import br.ifba.inf011.aval2.model.Credencial;

public class SomenteLeituraArquivo extends AbstractArquivoState{

  @Override
  public void escrever(Arquivo arquivo, Credencial credencial, String conteudo) throws IllegalAccessException{
    throw new IllegalAccessException("Arquivo somente de leitura.");
  }

  @Override
  public void somenteLeitura(Arquivo arquivo) {}

  @Override
  public void bloquear(Arquivo arquivo) {
    arquivo.setState(new BloqueadoArquivo());
  }

  @Override
  public void excluir(Arquivo arquivo) {}

  @Override
  public void restaurar(Arquivo arquivo) {}

  @Override
  public void liberar(Arquivo arquivo) {
    arquivo.setState(new EstadoNormalArquivo());
  }
}
