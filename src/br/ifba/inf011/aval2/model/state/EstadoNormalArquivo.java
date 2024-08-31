package br.ifba.inf011.aval2.model.state;

public class EstadoNormalArquivo extends AbstractArquivoState{

  @Override
  public void somenteLeitura(Arquivo arquivo) {
    arquivo.setState(new SomenteLeituraArquivo());
  }

  @Override
  public void bloquear(Arquivo arquivo) {
    arquivo.setState(new BloqueadoArquivo());
  }

  @Override
  public void excluir(Arquivo arquivo) {
    arquivo.setState(new ExcluidoArquivo());
  }

  @Override
  public void restaurar(Arquivo arquivo) {

  }

  @Override
  public void liberar(Arquivo arquivo) {}

}
