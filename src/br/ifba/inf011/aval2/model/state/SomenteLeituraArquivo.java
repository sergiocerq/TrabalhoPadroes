package br.ifba.inf011.aval2.model.state;

import br.ifba.inf011.aval2.model.Credencial;

//ConcreteState
public class SomenteLeituraArquivo extends AbstractArquivoState{

  public SomenteLeituraArquivo(Arquivo arquivo) {
      super(arquivo);
  }
  @Override
  public void escrever(Credencial credencial, String conteudo) throws IllegalAccessException{
    throw new IllegalAccessException("Não foi possível escrever no arquivo: Arquivo somente de leitura.");
  }

  @Override
  public void bloquear() {
    arquivo.setState(new BloqueadoArquivo(this.arquivo));
  }

  @Override
  public void liberar() {
    arquivo.setState(new EstadoNormalArquivo(this.arquivo));
  }
}
