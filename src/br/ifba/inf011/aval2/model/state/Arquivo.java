package br.ifba.inf011.aval2.model.state;

import java.time.LocalDate;
import java.util.List;

import br.ifba.inf011.aval2.model.Conversor2Text;
import br.ifba.inf011.aval2.model.Credencial;
import br.ifba.inf011.aval2.model.Entrada;
import br.ifba.inf011.aval2.model.EntradaOperavel;
import br.ifba.inf011.aval2.model.bridge.Conversor;
import br.ifba.inf011.aval2.model.composite.AbstractEntrada;

public class Arquivo extends AbstractEntrada implements EntradaOperavel {

	private Conversor conversor;
	private String conteudo;
	private ArquivoState state = new EstadoNormalArquivo(); // Estado Inicial de um arquivo;

	public Arquivo(String nome, LocalDate dataCriacao, String conteudo, Conversor conversor) {
		super(nome, dataCriacao);
		this.conversor = conversor;
		this.conteudo = this.conversor.encode(conteudo);
	}

	public Arquivo(String nome, LocalDate dataCriacao, String conteudo) {
		super(nome, dataCriacao);
		this.conteudo =  conteudo;
		this.conversor = new Conversor2Text();
	}

	@Override
	public List<Entrada> getFilhos() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	@Override
	public void addFilho(Entrada entrada) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	@Override
	public void removeFilho(Entrada entrada) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	@Override
	public Long getTamanho() throws IllegalAccessException{
		//return Long.valueOf(this.conteudo.length());
		return this.state.tamanho(this);
	}
	
	@Override
	public String ler(Credencial credencial) throws IllegalAccessException {
		//return this.conversor.decode(this.conteudo);
		return this.state.ler(this, credencial);
	}

	@Override
	public void escrever(Credencial credencial, String conteudo) throws IllegalAccessException {
		// this.conteudo = this.conversor.encode(conteudo);
		this.state.escrever(this, credencial, conteudo);
	}

	@Override
	public String dump() {
		return this.conteudo;
	};

	public void setState(ArquivoState state) {
		this.state = state;
	}

	public ArquivoState getState() {
		return this.state;
	}

	protected Conversor getConversor() {
		return this.conversor;
	}

	protected void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	protected String getConteudo() {
		return this.conteudo;
	}

	public void somenteLeitura(){
		this.state.somenteLeitura(this);
	}

	public void bloquear() {
		this.state.bloquear(this);
	}

	public void excluir() {
		this.state.excluir(this);
	}

	public void restaurar() {
		this.state.restaurar(this);
	}

	public void liberar() {
		this.state.liberar(this);
	}
}
