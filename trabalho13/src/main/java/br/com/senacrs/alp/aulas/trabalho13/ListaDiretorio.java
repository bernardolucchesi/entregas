package br.com.senacrs.alp.aulas.trabalho13;

import java.io.File;


public class ListaDiretorio {
	
	public String[] listaConteudoDiretorio(String diretorio) {
		
		if(diretorio == null){
			throw new IllegalArgumentException();
		}
		String[] dir = null;
		String caminho = null;
		String caminhoabsoluto = null;
		
		final String root = System.getProperty("user.dir");
		caminhoabsoluto = root + File.separator + caminho;
		
		try{
			
			File testeArquivo = new File(caminhoabsoluto);
			if(!testeArquivo.isDirectory() || !testeArquivo.isFile()){
				throw new IllegalArgumentException();
			}
			
		}catch(IllegalArgumentException e){
			throw new IllegalArgumentException();
		}
		
		escreveDir(caminhoabsoluto);
		
		if(dir == null){
			throw new IllegalArgumentException();
		}
		
		return dir;
	}
	
	public String[] escreveDir(String path){
		
		File arq = new File(path);
		char teste;
		char teste1; 
		
		String[] conteudo = null;
		String[] totalarquivos = arq.list();
		
		conteudo[0] = "list: " + path;
		conteudo[1] = "total: " + totalarquivos.length;
		
		for(int i = 0; i < totalarquivos.length; i++){
			teste = totalarquivos[i].charAt(0);
			teste1 = totalarquivos[i+1].charAt(0);
		}
		
		return conteudo;
		
	}
}
