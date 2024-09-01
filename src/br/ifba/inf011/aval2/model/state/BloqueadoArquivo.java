package br.ifba.inf011.aval2.model.state;

import br.ifba.inf011.aval2.model.Credencial;

//ConcreteState
public class BloqueadoArquivo extends AbstractArquivoState{

  public BloqueadoArquivo(Arquivo arquivo) {
    super(arquivo);
  }

  @Override
  public String ler(Credencial credencial) throws IllegalAccessException{
    throw new IllegalAccessException("Não foi possível ler o arquivo: Arquivo bloqueado.");
  }

  @Override
  public void escrever(Credencial credencial, String conteudo) throws IllegalAccessException{
    throw new IllegalAccessException("Não foi possível escrever no arquivo: Arquivo bloqueado.");
  }

  @Override
  public void liberar() {
    arquivo.setState(new EstadoNormalArquivo(this.arquivo));
  }
}
