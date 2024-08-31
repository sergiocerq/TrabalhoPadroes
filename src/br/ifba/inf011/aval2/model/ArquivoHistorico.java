package br.ifba.inf011.aval2.model;

import br.ifba.inf011.aval2.model.bridge.Conversor;

import java.time.LocalDate;

public class ArquivoHistorico extends Arquivo implements EntradaOperavel{


	public ArquivoHistorico(String nome, LocalDate dataCriacao, String conteudo, Conversor conversor) {
		super(nome, dataCriacao, conteudo, conversor);
	}


}
