package br.com.senacrs.alp.aulas.trabalho13;

import java.awt.List;
import java.io.File;



public class ListaDiretorio {
	
	public String[] listaConteudoDiretorio(String diretorio) {
		
		if(diretorio == null){
			throw new IllegalArgumentException();
		}
		
		List lista = new List();
		String[] dir = null;
		String caminhoabsoluto = diretorio;
		
		try{
			
			File testeArquivo = new File(caminhoabsoluto);
			if(!testeArquivo.isDirectory()){
				throw new IllegalArgumentException();
			}
			
		}catch(IllegalArgumentException e){
			throw new IllegalArgumentException();
		}
		
		lista = escreveDir(caminhoabsoluto);
		dir = lista.getItems();
		
		if(dir == null){
			throw new IllegalArgumentException();
		}
		
		return dir;
	}
	
	public List escreveDir(String path){
		
		List conteudo = new List();
		String[] ordenado = orderList(path);
		
		conteudo.add("list: " + path);
		conteudo.add("total: " + ordenado.length);
		
		for(int y = 0; y < ordenado.length; y++){
			conteudo.add(ordenado[y]);
		}
		
		return conteudo;
		
	}
	
	public String[] orderList(String path){

		File arq = new File(path);
		File ord = null;
		String aux = null;
		
		String[] totalarquivos = arq.list();
		
		for(int i = totalarquivos.length; i == 1; i--){
			if(totalarquivos[i].compareTo(totalarquivos[i-1]) < 0){
				aux = totalarquivos[i];
				totalarquivos[i] = totalarquivos[i-1];
				totalarquivos[i-1] = aux;
			}
		}
		
		for(int i = totalarquivos.length; i == 1; i--){

			try{
				ord = new File(totalarquivos[i]);
				if(ord.isDirectory()){
					
					totalarquivos[i] = "d " + totalarquivos[i];
					aux = totalarquivos[i-1];
					totalarquivos[i-1] = totalarquivos[i];
					totalarquivos[i-1] = aux;
					
				}else if(ord.isFile()){
					
					totalarquivos[i] = "a " + totalarquivos[i];
					
				}
			}catch(IllegalArgumentException e){
				throw new IllegalArgumentException();
			}
		}
	
		return totalarquivos;
	}
}
