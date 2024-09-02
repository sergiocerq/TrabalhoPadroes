package br.ifba.inf011.aval2.model.state;

import java.time.LocalDate;
import java.util.List;

import br.ifba.inf011.aval2.model.Conversor2Text;
import br.ifba.inf011.aval2.model.Credencial;
import br.ifba.inf011.aval2.model.Entrada;
import br.ifba.inf011.aval2.model.EntradaOperavel;
import br.ifba.inf011.aval2.model.bridge.Conversor;
import br.ifba.inf011.aval2.model.composite.AbstractEntrada;
import br.ifba.inf011.aval2.model.memento.ArquivoSnapshot;
import br.ifba.inf011.aval2.model.memento.NarrowArquivo;
import br.ifba.inf011.aval2.model.memento.WideArquivo;

//Context no State e Abstraction no Bridge
public class Arquivo extends AbstractEntrada implements EntradaOperavel {

	private Conversor conversor;
	private String conteudo;
	private ArquivoState state = new EstadoNormalArquivo(this); // Estado Inicial de um arquivo;

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
	public Long getTamanho() {
		//return Long.valueOf(this.conteudo.length());
		return this.state.tamanho(this.conteudo);
	}
	
	@Override
	public String ler(Credencial credencial) throws IllegalAccessException {
		//return this.conversor.decode(this.conteudo);
		return this.state.ler(credencial);
	}

	@Override
	public void escrever(Credencial credencial, String conteudo) throws IllegalAccessException {
		// this.conteudo = this.conversor.encode(conteudo);
		this.state.escrever(credencial, conteudo);
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

	public Conversor getConversor() {
		return this.conversor;
	}

	protected void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getConteudo() {
		return this.conteudo;
	}

	public void somenteLeitura(){
		this.state.somenteLeitura();
	}

	public void bloquear() {
		this.state.bloquear();
	}

	public void excluir() {
		this.state.excluir();
	}

	public void restaurar() {
		this.state.restaurar();
	}

	public void liberar() {
		this.state.liberar();
	}

	/*
	 * - snapshot(): Método que cria um Memento do estado atual do objeto e retorna um NarrowArquivo
	 *  (Memento estreito) para que o Caretaker possa armazenar.
	 */
	public NarrowArquivo snapshot() {
		return new ArquivoSnapshot(
			this.conversor,
			this.conteudo,
			this.state
		);
	}

	/*
	 * - restore(NarrowArquivo snapshot): Método que recebe um Memento sem métodos e restaura o estado do objeto para o estado do Memento.
	 *
	 * 	O Memento sem métodos (NarrowArquivo) é convertido em um Memento (WideArquivo) para que o objeto possa acessar as informações do Memento.
	 */
	public void restore(NarrowArquivo snapshot) {
		WideArquivo wideArquivo = (WideArquivo) snapshot;
		this.conversor = wideArquivo.getConversor();
		this.conteudo = wideArquivo.getConteudo();
		this.state = wideArquivo.getState();
	}
}
