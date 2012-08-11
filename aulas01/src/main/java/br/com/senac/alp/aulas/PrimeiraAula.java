package br.com.senac.alp.aulas;


public class PrimeiraAula {
	
	public static PrimeiraAula instancia = new PrimeiraAula();
	
	
	public PrimeiraAula() {

		super();
	}
	
	public double somaTotal(double[] valores) {
		
		double resultado = 0.0;
		
		if (valores == null) {
			resultado = Double.NaN;
		} else {
			for (int i = 0; i < valores.length; i++) {
					resultado += valores[i];
				}
			}
		
		return resultado;
	}
	
	public static PrimeiraAula getInstancia() {
		
		return PrimeiraAula.instancia;
	}
}
