package br.com.senacrs.alp.aulas.trabalho12;

import static org.junit.Assert.fail;

import java.io.File;

import junit.framework.Assert;

import org.junit.Test;

public class MainTest {

	private final static String DIRETORIO = System
			.getProperty("user.dir")
			+ File.separatorChar
			+ "configuracoes"
			+ File.separatorChar;
	private final static String NOME_ARQUIVO_CORRETO = "configuracoes_correto.txt";
	private final static String ARQUIVO_CORRETO = DIRETORIO
			+ NOME_ARQUIVO_CORRETO;
	private final static String NOME_ARQUIVO_INCORRETO = "configuracoes_incorreto.txt";
	private final static String ARQUIVO_INCORRETO = DIRETORIO
			+ NOME_ARQUIVO_INCORRETO;
	private final static String NOME_ARQUIVO_GET = "telnet.txt";
	private final static String ARQUIVO_GET = DIRETORIO
			+ NOME_ARQUIVO_GET;
	
	public void criarMain(String argumento, String argumento2) {
		
		String[] args = null;
		String[] args1 = null;
		
		if(argumento != null){
			
			args = new String[1];
			args[0] = argumento;
			if(argumento2 != null){
				args1 = new String[1];
				args1[0] = argumento2;
			}
		}else{
			System.out.println("ERRO");
			throw new IllegalArgumentException();
		}
		
		Main.main(args, args1);
				
	}
	
	@Test
	public void testeArquivoNull() {
		
		try {
			criarMain(null, null);
			fail("Deveria ter abortado.");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}		
	}
	
	@Test
	public void testeArquivoDiretorio() {
		
		try {
			criarMain(DIRETORIO, null);
			fail("Deveria ter abortado.");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}		
		
	}
	
	@Test
	public void testArquivoInexistente() {

		try {
			criarMain("NaoExiste" + ".nao_existe", null);
			fail("Deveria ter abortado");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}	
	
	@Test
	public void testArquivoIncorreto() {
		
		try {
			criarMain(ARQUIVO_INCORRETO, null);
			fail("Deveria ter abortado.");
		} catch (Exception e) {
			Assert.assertTrue(true);
		}		
	}	

	@Test
	public void testArquivoCorreto() {
		
		try {
			criarMain(ARQUIVO_CORRETO, null);
			Assert.assertTrue(true);
		} catch (Exception e) {
			fail("Deveria ter passado.");			
		}		
	}	
	
	@Test
	public void testArquivoGet() {
		
		try {
			criarMain(ARQUIVO_CORRETO, ARQUIVO_GET);
			Assert.assertTrue(true);
		} catch (Exception e) {
			fail("Deveria ter passado.");			
		}		
	}	
	
}
