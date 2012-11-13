package br.com.senacrs.alp.aulas.trabalho12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

	private static File arquivo = null;
	private static FileReader reader = null;
	private static BufferedReader input = null;
	private static String line = null;
	private static String[] par = new String[2];
	private static Map<String, String> hash = new HashMap<String, String>();
			
	public static void main(String[] args, String[] args1) {
		
		criaArquivo(args[0]);
		lerArquivo(arquivo);
		verificaRoot(hash);
		verificaPort(hash);
		
		criaArquivo(args1[0]);
		lerArquivoRequisicao(arquivo);
		verificaGet(hash);
		verificaHost(hash);
		
	}
	
	public static File criaArquivo(String argumento){
		
		if(argumento == null){
			System.out.println("ERRO");
			throw new IllegalArgumentException();
		} else {
			String nomeArquivo = argumento;
			arquivo = new File(nomeArquivo);
		}
		
		if (!arquivo.exists() || arquivo.isDirectory()) {
			System.out.println("ERRO");
			throw new IllegalArgumentException();
		}
		
		return arquivo;
		
	}
	
	public static Map<String, String> lerArquivo(File arquivo){
		
		try {
			reader = new FileReader(arquivo);
			try {
				input = new BufferedReader(reader);
				line = input.readLine();

				while (line != null) {
					int total = 0;
					for (int i = 0; i < line.length(); i++) {
						if (line.charAt(i) == '=') {
							total++;
						}
					}
					if (total != 1) {
						System.out.println("ERRO");
						input.close();
						throw new IllegalArgumentException();
					}
					
					par = line.split("=");
					hash.put(par[0].trim(), par[1].trim());
					line = input.readLine();	

				}input.close();

			}catch (IOException e2){
				System.out.println("ERRO");
				throw new IllegalArgumentException(e2);
			}
		}catch (FileNotFoundException e1) {
			System.out.println("ERRO");
			throw new IllegalArgumentException(e1);
		}
		
		return hash;
	}
	
	public static void verificaRoot(Map<String, String> mapa){
		
		String caminhoRelativo = null;
		
		if(!hash.containsKey("root_dir")){
			System.out.println("ERRO");
			throw new IllegalArgumentException();
		}
		
		caminhoRelativo = hash.get("root_dir").replace(".",System.getProperty("user.dir")).replace('/', File.separatorChar);
		arquivo = new File(caminhoRelativo);

		if(!arquivo.isDirectory() || !arquivo.exists()){
			System.out.println("ERRO");
			throw new IllegalArgumentException();
		}
		
	}
	
	public static void verificaPort(Map<String, String> mapa){
		
		if(!hash.containsKey("port")){
			System.out.println("ERRO");
			throw new IllegalArgumentException();
		}
		
		try{
			Integer.parseInt(hash.get("port"));
		}catch(Exception e3){
			System.out.println("ERRO");
			throw new IllegalArgumentException();
		}
		
		if(hash.get("port").length() > 5){
			System.out.println("ERRO");
			throw new IllegalArgumentException();
		}
		
	}
	
	public static Map<String, String> lerArquivoRequisicao(File arquivo){
		
		String[] parametros = null;
		int total = 0;
		int totallinha = 0;
		
		try {
			reader = new FileReader(arquivo);
				try {
					input = new BufferedReader(reader);
					line = input.readLine();
					
					while (line != null && totallinha != 2) {
						line = line.trim();
						total = 0;
	
						for (int i = 0; i < line.length(); i++) {
							if (line.charAt(i) == ' ') {
								total++;
							}
						}
						if (total == 2) {
							parametros = new String[3];
							parametros = line.split(" ");
							hash.put(parametros[0].trim(), parametros[1].trim() + " " + parametros[2].trim());
							totallinha++;
						} else if(total == 1) {
							parametros = new String[2];
							parametros = line.split(" ");
							hash.put(parametros[0].trim(), parametros[1].trim());
							totallinha++;
						}
						
						line = input.readLine();
					}
					
					input.close();
				}catch (IOException e2) {
					System.out.println("ERRO");
					throw new IllegalArgumentException(e2);
				}
		} catch (FileNotFoundException e1) {
			System.out.println("ERRO");
			throw new IllegalArgumentException(e1);
		}
		
		return hash;
	}
	
	public static void verificaGet(Map<String, String> mapa){
		
		if(!hash.containsKey("GET")){
			System.out.println("ERRO");
			throw new IllegalArgumentException();
		}
		
		String[] get = new String[2];
		get = hash.get("GET").split(" ");
		
		String path = get[0];
		int total = 0;
		int posicao = -1;
		
			for (int i = 0; i < path.length(); i++) {
				if (path.charAt(i) == '/') {
					if(i == 0){
						posicao = i;
					}
					total++;
				}
			}
			if (posicao != 0 || total < 1) {
				System.out.println("ERRO");
				throw new IllegalArgumentException();
			}
			
			String protocol = get[1];

			if(!protocol.equalsIgnoreCase("http/1.1")){
				System.out.println("ERRO");
				throw new IllegalArgumentException();
			}
	}
	
	public static void verificaHost(Map<String, String> mapa){
		
		int total = 0;
		
		if(!hash.containsKey("Host:")){
			System.out.println("ERRO");
			throw new IllegalArgumentException();
		}
		
		String host = hash.get("Host:");
		
			for (int i = 0; i < host.length(); i++) {
				if (host.charAt(i) == '.') {
					total++;
				}
			}
			if (total < 2) {
				System.out.println("ERRO");
				throw new IllegalArgumentException();
			}
		
	}
	
}

	
			

