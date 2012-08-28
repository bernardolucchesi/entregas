package br.com.senac.rs.alp.aulas.MinhaLista;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MinhaListaImpTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMinhaListaImp() {
		
		MinhaListaImp<String> obj = null;
		String strg = null;
		
		strg = "valor inválido";
		obj = new MinhaListaImp<String>(strg);
		Assert.assertNotNull((obj));
	}
	
	@Test
	public void testMinhaListaImpNull(){
		
		MinhaListaImp<String> obj = null;
		try{
			obj = new MinhaListaImp<String>(null);
			fail();
		}catch(IllegalArgumentException e){
			Assert.assertNull((obj));
		}
		
	}

	@Test
	public void testBuscar() {
		fail("Not yet implemented");
	}

	@Test
	public void testInserir() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemover() {
		fail("Not yet implemented");
	}

	@Test
	public void testTamanho() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetInicio() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetInicio() {
		fail("Not yet implemented");
	}

}
