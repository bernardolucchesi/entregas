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
	private final static String NOME_INDEX = "index.html";
			
	public static void main(String[] args, String[] args1) {
		
		FileReader reader = null;
		BufferedReader input = null;
		String line = null;
		
		String[] par = new String[2];
		Map<String, String> hash = new HashMap<String, String>();
				
		if(args == null){
			System.out.println("ERRO");
			throw new IllegalArgumentException();
		} else {
			String nomeArquivo = args[0];
			arquivo = new File(nomeArquivo);
			if (!arquivo.exists() || arquivo.isDirectory()) {
				System.out.println("ERRO");
				throw new IllegalArgumentException();
			} else {
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
						}
						
						if(!hash.containsKey("root_dir") || !hash.containsKey("port")){
							input.close();
							System.out.println("ERRO");
							throw new IllegalArgumentException();
						} 
						arquivo = new File(hash.get("root_dir").replace(".",System.getProperty("user.dir")).replace("/", "\\"));
						
						if(!arquivo.isDirectory() || !arquivo.exists()){
							input.close();
							System.out.println("ERRO");
							throw new IllegalArgumentException();
						}
						
						try{
							int porta = Integer.parseInt(hash.get("port"));
						}
						catch(Exception e){
							input.close();
							System.out.println("ERRO");
							throw new IllegalArgumentException();
						}
						
						if(hash.get("port").length() > 5){
							input.close();
							System.out.println("ERRO");
							throw new IllegalArgumentException();
						}
						
						System.out.println(hash.get("port") + ":" 
						+ hash.get("root_dir").replace("/", "\\").replace(".",System.getProperty("user.dir")) + NOME_INDEX);
						
						input.close();
					} catch (IOException e2) {
						System.out.println("ERRO");
						throw new IllegalArgumentException(e2);
					}
				} catch (FileNotFoundException e1) {
					System.out.println("ERRO");
					throw new IllegalArgumentException(e1);
				}
			}
			
			
		}
		
		if(args1 == null){
			System.out.println("ERRO");
			throw new IllegalArgumentException();
		} else {
			String nomeArquivo = args1[0];
			arquivo = new File(nomeArquivo);
			if (!arquivo.exists() || arquivo.isDirectory()) {
				System.out.println("ERRO");
				throw new IllegalArgumentException();
			} else {
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
						}
						
						if(!hash.containsKey("GET") || !hash.containsKey("Host")){
							input.close();
							System.out.println("ERRO");
							throw new IllegalArgumentException();
						} 
						arquivo = new File(hash.get("GET").replace(".",System.getProperty("user.dir")).replace("/", "\\"));
						
						if(!arquivo.isDirectory() || !arquivo.exists()){
							input.close();
							System.out.println("ERRO");
							throw new IllegalArgumentException();
						}
					
						System.out.println(hash.get("GET").replace("/", "\\").replace(".",System.getProperty("user.dir")) + NOME_INDEX);
						
						input.close();
					} catch (IOException e2) {
						System.out.println("ERRO");
						throw new IllegalArgumentException(e2);
					}
				} catch (FileNotFoundException e1) {
					System.out.println("ERRO");
					throw new IllegalArgumentException(e1);
				}
			} 
		
	}
		
	}
}
