package br.com.senac.alp.aulas;

import java.io.Console;

import org.junit.Assert;

public class TestesEntregar {

	public static void main(String[] args) {
		
		PrimeiraAula obj = new PrimeiraAula();
		
		double[] valores = null;
		double esperado = Double.NaN;
		double resultado = obj.somaTotal(valores);
		
		int comparacao = Double.compare(resultado, esperado);
		
		if (comparacao == 0) {
			
			System.out.println("Argumento nulo: Teste OK.");
			
		} else {
			
			System.out.println("Não foi argumento nulo.");
		}
		
		valores = new double[0];
		resultado = obj.somaTotal(valores);
		
		if (resultado == 0) {
			
			System.out.println("Argumento vazio: Teste OK.");
			
		} else {
			
			System.out.println("Não foi argumento vazio.");
		}
		
		valores = new double[1];
		valores[0] = Math.random();
		resultado = obj.somaTotal(valores);
		
		if (resultado == valores[0]) {
			
			System.out.println("Argumento unitário: Teste OK.");
			
		} else {
			
			System.out.println("Não foi argumento unitário.");
			
		}
		
		valores = new double[10];
		double soma = 0;
		
		for (int i = 0; i < valores.length; i++) {
			
			double valor = Math.random();
			valores[i] = valor;
			soma += valor;
			
		}
		
		resultado = obj.somaTotal(valores);
		comparacao = Double.compare(resultado, soma);
		
		if (comparacao == 0) {
			
			System.out.println("Argumento array: Teste OK.");
			
		} else {
			
			System.out.println("Não foi argumento array.");
		}

	}

}
