package br.ifba.inf011.aval2.model.state;

import br.ifba.inf011.aval2.model.Credencial;

//ConcreteState
public class ExcluidoArquivo extends AbstractArquivoState{

  public ExcluidoArquivo(Arquivo arquivo) {
    super(arquivo);
  }
  @Override
  public String ler(Credencial credencial) throws IllegalAccessException{
    throw new IllegalAccessException("Não foi possível ler o arquivo: Arquivo excluído.");
  }

  @Override
  public void escrever(Credencial credencial, String conteudo) throws IllegalAccessException{
    throw new IllegalAccessException("Não foi possível escrever no arquivo: Arquivo excluído.");
  }

  @Override
  public Long tamanho(String conteudo){
    return 0L;
  }


  @Override
  public void restaurar() {
    arquivo.setState(new EstadoNormalArquivo(this.arquivo));
  }

}
