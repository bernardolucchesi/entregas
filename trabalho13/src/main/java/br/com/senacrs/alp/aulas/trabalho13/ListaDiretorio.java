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
		String[] ordenado = retornaLista(path);
		
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
	
	public String[] retornaLista(String path){

		File arq = new File(path);
		String[] totalarquivos = arq.list();
		File ord = null;
		String absolut = null;
		List ordDir = new List();
		List ordArq = new List();
		String[] diretorios = null;
		String[] arquivos = null;
		
		for(int i = 0, y = 0, z = 0; i < totalarquivos.length; i++){
			absolut = path + File.separator + totalarquivos[i];
			ord = new File(absolut);
			if(ord.isDirectory()){
				ordDir.add("d " + totalarquivos[i]);
				y++;
			}else if(ord.isFile()){
				ordArq.add("a " + totalarquivos[i]);
			}
		}
		
		if(ordDir != null){
			diretorios = orderList(ordDir);
		}
		
		if(ordArq != null){
			arquivos = orderList(ordArq);
		}
		
		for(int i = 0, y = 0, z = 0; i < totalarquivos.length; i++){
			if(z < diretorios.length){
				totalarquivos[i] = diretorios[z];
				z++;
			}else if(y < arquivos.length){
				totalarquivos[i] = arquivos[y];
				y++;
			}
		}
		
		return totalarquivos;
	}
	
	public String[] orderList(List arg){
		
		String aux = null;
		String[] ordenacao = arg.getItems();
		
		for(int i = 0; i < ordenacao.length - 1; i++){
			if(ordenacao[i].compareTo(ordenacao[i+1]) > 0){
				aux = ordenacao[i];
				ordenacao[i] = ordenacao[i+1];
				ordenacao[i+1] = aux;
			}
		}
		
		return ordenacao;
	}
}
