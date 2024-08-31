package br.ifba.inf011.aval2.model.state;

import br.ifba.inf011.aval2.model.Credencial;

public interface ArquivoState {
  String ler(Arquivo arquivo, Credencial credencial) throws IllegalAccessException;
  void escrever(Arquivo arquivo, Credencial credencial, String conteudo) throws IllegalAccessException;
  Long tamanho(Arquivo arquivo) throws IllegalAccessException;

  void somenteLeitura(Arquivo arquivo);
  void bloquear(Arquivo arquivo);
  void excluir(Arquivo arquivo);
  void restaurar(Arquivo arquivo);
  void liberar(Arquivo arquivo);
}
