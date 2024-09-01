package br.ifba.inf011.aval2.model.state;

import br.ifba.inf011.aval2.model.Credencial;
import br.ifba.inf011.aval2.model.Operavel;

//State
public interface ArquivoState extends Operavel {
  Long tamanho(String conteudo) ;
  void somenteLeitura();
  void bloquear();
  void excluir();
  void restaurar();
  void liberar();
}
