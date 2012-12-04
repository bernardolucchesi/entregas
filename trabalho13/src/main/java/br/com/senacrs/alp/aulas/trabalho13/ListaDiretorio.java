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
		
		for(int i = 0; i <= ordenado.length; i++){
			System.out.println(conteudo.getItem(i));
		}
		
		return conteudo;
		
	}
	
	public String[] orderList(String path){

		File arq = new File(path);
		String[] totalarquivos = arq.list();
		File ord = null;
		String absolut = null;
		boolean troca = false;
		
		for(int i = 0; i < totalarquivos.length -1; i++){
			
			if(totalarquivos[i].compareTo(totalarquivos[i+1]) < 0){
				String aux = totalarquivos[i];
				totalarquivos[i] = totalarquivos[i+1];
				totalarquivos[i+1] = aux;
			}
		}
		
		do{
			troca = false;
			for(int i = 0; i < totalarquivos.length - 1; i++){
				absolut = path + File.separator + totalarquivos[i];
				ord = new File(absolut);
				if(ord.isDirectory()){
					String aux = totalarquivos[i];
					totalarquivos[i] = totalarquivos[i+1];
					totalarquivos[i+1] = aux;
					//troca = true;
				}
			}
		}while(troca);
		
		return totalarquivos;
	}
}
