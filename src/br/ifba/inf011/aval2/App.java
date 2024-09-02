package br.ifba.inf011.aval2;

import java.time.LocalDate;

import br.ifba.inf011.aval2.model.*;
import br.ifba.inf011.aval2.model.memento.HistoricoArquivo;
import br.ifba.inf011.aval2.model.state.*;
import br.ifba.inf011.aval2.model.state.Arquivo;

/*
 * Design Pattern Memento
 *
 * - NarrowArquivo: Interface que não possui métodos, utilizada para identificar um Memento
 * - WideArquivo: Interface que possui métodos para obter informações do Memento
 * - ArquivoSnapshot: Memento que armazena o estado de um Arquivo
 * - HistoricoArquivo: Caretaker que armazena os Mementos
 *
 * @description - A interface NarrowArquivo permite referenciar o memento sem expor os métodos, garandindo uma grande segurança, um código limpo, seguro e modular.
 * @description - A interface WideArquivo permite obter informações do memento, como o conteúdo, o estado e o conversor, sendo utilizada somente pelo Caretaker.
 * @description - O Caretaker é responsável por armazenar os mementos e realizar as operações de checkpoint e undo.
 * @description - O Memento é responsável por armazenar o estado de um objeto, permitindo que ele seja restaurado posteriormente.
 */
public class App {

	public void runQ1() throws IllegalAccessException  {
		
		Credencial user01 = new Credencial("user01");
		
		EntradaOperavel a1 = new Arquivo("A1", LocalDate.now(), "00011000100011100000011111110101", new Conversor2Bin());
		EntradaOperavel b1 = new Arquivo("B1", LocalDate.now(), "UM ARQUIVO TAMANHO GRANDE");
		EntradaOperavel c1 = new Arquivo("C1", LocalDate.now(), "UM ARQUIVO TAMANHO MUITO MUITO GRANDE");
		EntradaOperavel d1 = new Arquivo("D1", LocalDate.now(), "CINCO", new Conversor2Bin());

		Entrada a = new Pasta("A", LocalDate.now());
		Entrada b = new Pasta("B", LocalDate.now());
		Entrada c = new Pasta("C", LocalDate.now());
		Entrada raiz = new Pasta("/", LocalDate.now());
		
		raiz.addFilho(a);
		raiz.addFilho(b);
		
		a.addFilho(a1);
		
		b.addFilho(c);
		b.addFilho(b1);
		
		c.addFilho(c1);

		try {
			b1.escrever(user01, "CINCO");
		}catch(IllegalAccessException ex) {
			System.out.println("NÃO FOI POSSIVEL ESCREVER EM A1");
		}
			
		System.out.println(raiz.getNome() + ": " + raiz.getTamanho() + "K");

		try {
			b1.escrever(user01, "CINCO+2");
		}catch(IllegalAccessException ex) {
			System.out.println("NÃO FOI POSSIVEL ESCREVER EM A1");
		}
		
		try {
			System.out.println("B1: " + b1.ler(user01));
		} catch (IllegalAccessException e) {
			System.out.println("NÃO FOI POSSIVEL LER DE A1");
		}			
		
		System.out.println(raiz.getNome() + ": " + raiz.getTamanho() + "K");

		System.out.println("//////////////////////////////////////////////////////////////////////////");
		System.out.println("B1: " + b1.ler(user01));
		System.out.println("B1 (dump): " + b1.dump());

		System.out.println("A1: " + a1.ler(user01));
		System.out.println("A1 (dump): " + a1.dump());

		System.out.println("D1: " + d1.ler(user01));
		System.out.println("D1 (dump): " + d1.dump());
	}

	private void runMetodosArquivos() {

		Credencial user01 = new Credencial("user01");
		Arquivo a1 = new Arquivo("A1", LocalDate.now(), "00011000100011100000011111110101", new Conversor2Bin());

		try {
			System.out.println("A1: " + a1.ler(user01));
		} catch (IllegalAccessException e) {
			System.out.println("Não foi possível ler de a1");
		}

		a1.bloquear();

		try {
			a1.escrever(user01, "Tentando escrever no bloqueado");
		} catch (IllegalAccessException e) {
			System.out.println("Não foi possível escrever a1 no estado bloqueado");
		}

		try {
			a1.ler(user01);
		} catch (IllegalAccessException e) {
			System.out.println("Não foi possível ler a1 no estado bloqueado");
		}

		a1.somenteLeitura();

		try {
			a1.escrever(user01, "Escrevendo no somente leitura");
		} catch (IllegalAccessException e) {
			System.out.println("Não foi possível escrever a1 no estado somente leitura");
		}
	}

	private void runMudancaEstado() {

		Credencial user01 = new Credencial("user01");
		Arquivo a1 = new Arquivo("A1", LocalDate.now(), "00011000100011100000011111110101", new Conversor2Bin());

		try {
			System.out.println("A1: " + a1.ler(user01));
			// Lendo o arquivo no estado normal
		} catch (IllegalAccessException e) {
			System.out.println("Não foi possível ler a1");
		}

		a1.bloquear();

		try {
			System.out.println("A1: " + a1.ler(user01));
			// Lendo o arquivo no estado bloqueado
		} catch (IllegalAccessException e) {
			System.out.println("Não foi possível ler a1 no estado bloqueado");
		}

		a1.liberar();

		try {
			System.out.println("A1: " + a1.ler(user01));
			// Lendo o arquivo no estado normal
		} catch (IllegalAccessException e) {
			System.out.println("Não foi possível ler a1");
		}

		a1.somenteLeitura();

		try {
			a1.escrever(user01, "Tentando escrever no somente leitura");
		} catch (IllegalAccessException e) {
			System.out.println("Não foi possível escrever a1 no estado somente leitura");
		}

		a1.liberar();

		try {
			a1.escrever(user01, "Escrevendo no normal");
		} catch (IllegalAccessException e) {
			System.out.println("Não foi possível escrever a1 no estado normal");
		}

		try {
			System.out.println("A1: " + a1.ler(user01));
			// Lendo o arquivo no estado normal
		} catch (IllegalAccessException e) {
			System.out.println("Não foi possível ler a1");
		}

		a1.excluir();

		try {
			System.out.println("A1: " + a1.ler(user01));
			// Lendo o arquivo no estado excluido
		} catch (IllegalAccessException e) {
			System.out.println("Não foi possível ler a1 no estado excluido");
		}
	}

	private void runWithMementos() {
		Credencial user01 = new Credencial("user01");
		Arquivo a1 = new Arquivo("A1", LocalDate.now(), "00011000100011100000011111110101", new Conversor2Bin());
		Arquivo b1 = new Arquivo("B1", LocalDate.now(), "CINCO");

		HistoricoArquivo historicoArquivo = new HistoricoArquivo(a1);

		// Estado normal

		historicoArquivo.checkpoint();
		// Salvando o estado normal

		historicoArquivo.bloquear(); // Atualizando para o estado bloqueado

		historicoArquivo.somenteLeitura(); // Não faz nada, pois o estado anterior é bloqueado

		historicoArquivo.checkpoint(); // Salva o arquivo no estado bloqueado


		try {
			System.out.println("A1: " + historicoArquivo.ler(user01));// Lança uma excessão pois o arquivo está bloqueado
		} catch (IllegalAccessException e) {
			System.out.println(e.toString());
		}
		System.out.println("A1 (tamanho): " + historicoArquivo.getTamanho());

		historicoArquivo.liberar();

		try {
			System.out.println("A1: " + historicoArquivo.ler(user01));
		} catch (IllegalAccessException e) {
			System.out.println(e.toString());
		}

		// Lança uma excessão pois o arquivo está bloquado
		historicoArquivo.undo();
		try {
			System.out.println("A1: " + historicoArquivo.ler(user01));
		} catch (IllegalAccessException e) {
			System.out.println(e.toString());
		}

		try {
			System.out.println("Tentando ler em B1");
			System.out.println("B1: " + b1.ler(user01));
		} catch (IllegalAccessException e) {
			System.out.println(e.toString());
		}
		System.out.println("B1 (tamanho): " + b1.getTamanho());
		b1.excluir();
		System.out.println("B1 (tamanho): " + b1.getTamanho());
		a1.bloquear();

		try {
			System.out.println("Tentando ler em B1");
			System.out.println("B1: " + b1.ler(user01));
		} catch (IllegalAccessException e) {
			System.out.println(e.toString());
		}

		try {
			System.out.println("Tentando escrever em B1");
			b1.escrever(user01, "teste");
		} catch (IllegalAccessException e) {
			System.out.println(e.toString());
		}
  }
	
	public static void main(String[] args) throws IllegalAccessException {
		App app = new App();
		app.runWithMementos();
		app.runMetodosArquivos();
		app.runMudancaEstado();
		app.runQ1();
	}

}
