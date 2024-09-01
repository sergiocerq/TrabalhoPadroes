package br.ifba.inf011.aval2.model.state;

//ConcreteState
public class EstadoNormalArquivo extends AbstractArquivoState{

  public EstadoNormalArquivo(Arquivo arquivo) {
      super(arquivo);
  }
  @Override
  public void somenteLeitura() {
    arquivo.setState(new SomenteLeituraArquivo(this.arquivo));
  }

  @Override
  public void bloquear() {
    arquivo.setState(new BloqueadoArquivo(this.arquivo));
  }

  @Override
  public void excluir() {
    arquivo.setState(new ExcluidoArquivo(this.arquivo));
  }

}
