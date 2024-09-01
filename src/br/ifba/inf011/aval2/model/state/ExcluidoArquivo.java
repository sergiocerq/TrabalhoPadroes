package br.ifba.inf011.aval2.model.state;

import br.ifba.inf011.aval2.model.Credencial;

public class ExcluidoArquivo extends AbstractArquivoState{

  @Override
  public String ler(Arquivo arquivo, Credencial credencial) throws IllegalAccessException{
    throw new IllegalAccessException("Não foi possível ler o arquivo: Arquivo excluído.");
  }

  @Override
  public void escrever(Arquivo arquivo, Credencial credencial, String conteudo) throws IllegalAccessException{
    throw new IllegalAccessException("Não foi possível escrever no arquivo: Arquivo excluído.");
  }

  @Override
  public Long tamanho(String conteudo){
    return 0L;
  }


  @Override
  public void restaurar(Arquivo arquivo) {
    arquivo.setState(new EstadoNormalArquivo());
  }

}
