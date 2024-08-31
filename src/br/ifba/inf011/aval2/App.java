package br.ifba.inf011.aval2;

import java.time.LocalDate;

import br.ifba.inf011.aval2.model.*;

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
	
	
	public static void main(String[] args) throws IllegalAccessException {
		App app = new App();
		app.runQ1();
	}

}
