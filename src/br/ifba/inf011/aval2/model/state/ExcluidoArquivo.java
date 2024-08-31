package br.ifba.inf011.aval2.model.state;

import br.ifba.inf011.aval2.model.Credencial;

public class ExcluidoArquivo extends AbstractArquivoState{

  @Override
  public String ler(Arquivo arquivo, Credencial credencial) throws IllegalAccessException{
    throw new IllegalAccessException("Arquivo excluído.");
  }

  @Override
  public void escrever(Arquivo arquivo, Credencial credencial, String conteudo) throws IllegalAccessException{
    throw new IllegalAccessException("Arquivo excluído.");
  }

  @Override
  public Long tamanho(Arquivo arquivo){
    return 0L;
  }

  @Override
  public void somenteLeitura(Arquivo arquivo) {}

  @Override
  public void bloquear(Arquivo arquivo) {}

  @Override
  public void excluir(Arquivo arquivo) {}

  @Override
  public void restaurar(Arquivo arquivo) {
    arquivo.setState(new EstadoNormalArquivo());
  }

  @Override
  public void liberar(Arquivo arquivo) {}
}
